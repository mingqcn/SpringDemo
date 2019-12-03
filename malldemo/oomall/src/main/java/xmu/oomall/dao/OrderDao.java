package xmu.oomall.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.cart.CartItem;
import xmu.oomall.domain.order.Order;
import xmu.oomall.domain.order.OrderItem;
import xmu.oomall.mapper.OrderMapper;
import xmu.oomall.service.PaymentService;
import xmu.oomall.service.impl.OrderServiceImpl;

import java.util.List;

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
}
