package xmu.oomall.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.cart.CartItem;
import xmu.oomall.domain.order.Order;
import xmu.oomall.domain.order.OrderItem;
import xmu.oomall.mapper.OrderMapper;
import xmu.oomall.service.GoodsService;
import xmu.oomall.service.PaymentService;
import xmu.oomall.service.impl.OrderServiceImpl;
import xmu.oomall.util.Config;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 订单Dao
 * @author: Ming Qiu
 * @date: Created in 17:02 2019/11/5
 **/
@Repository
public class OrderDao {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private Config config;

    @Autowired
    private GoodsService goodsService;

    /**
     * 新增订单，包括订单明细
     * @param order 订单
     * @return 新订单，带id的
     */
    public Order addOrder( Order order){
        logger.debug("addOrder参数： order="+order);
        orderMapper.addOrder(order);
        logger.debug("订单增加成功：");
        //用获得的orderId设置item
        order.setItemsOrderId();
        orderMapper.addOrderItems(order.getItems());
        logger.debug("订单明细增加成功：orderItems = "+order.getItems());
        //用orderid设置payment对象
        order.setPaymentsOrderId();
        paymentService.addPayment(order.getPayments());
        logger.debug("订单支付增加成功：payments = "+order.getPayments());
        order.setItems(null);
        order.setCoupon(null);
        order.setUser(null);
        order.setPayments(null);
        logger.debug("addOrder返回： order="+order);
        return order;
    }

    /**
     * 扣减货品库存量
     * @param productId
     * @param quantity
     * @return
     */
    public Boolean deductStock(Integer productId, Integer quantity){
        logger.debug("deductStock参数： productId="+ productId +" quantity = "+quantity);
        Boolean ret = false;
        String key = "ST_" + productId;
        Integer stock = (Integer)  redisTemplate.opsForValue().get(key);
        if (stock !=null && stock - quantity >= 0){
            //redis内扣减
            redisTemplate.opsForValue().set(key, stock - quantity, config.getRedisExpireTime(), TimeUnit.MINUTES);
            return true;
        }else{
            //从数据库读取
            logger.debug(key+"不在Redis中或者Redis中数量不够");
            if (this.fetchFromDB(productId, key)){
                stock = (Integer) redisTemplate.opsForValue().get(key);
                if (stock - quantity < 0) {
                    return false;
                }
                redisTemplate.opsForValue().set(key, stock - quantity, config.getRedisExpireTime(), TimeUnit.MINUTES);
                return true;
            }else{
                return false;
            }
        }
    }

    /**
     * 从数据库中提取库存值，并放入redis
     * @param productId 货品id
     * @param key redis的key
     * @return 是否成功从数据库中提取库存
     */
    private boolean fetchFromDB(Integer productId, String key) {
        logger.debug("fetchFromDB参数：productId = "+productId +" key = "+key);
        Integer stockInDB = goodsService.getStockInDB(productId);
        if (stockInDB == 0){
            logger.debug("fetchFromDB返回：false" );
            return false;
        }
        Integer stockInRedis = config.getPreDeductQty();
        stockInDB = stockInDB - stockInRedis;
        if (stockInDB < 0){
           stockInRedis = stockInRedis + stockInDB;
           stockInDB = 0;
        }
        redisTemplate.opsForValue().set(key, stockInRedis, config.getRedisExpireTime(), TimeUnit.MINUTES);
        goodsService.updateStockInDB(productId, stockInDB);
        logger.debug("fetchFromDB返回：true" );
        return true;

    }
}
