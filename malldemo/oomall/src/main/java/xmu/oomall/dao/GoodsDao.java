package xmu.oomall.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.goods.Goods;
import xmu.oomall.domain.goods.Product;
import xmu.oomall.domain.goods.Promotion;
import xmu.oomall.domain.goods.PromotionPo;
import xmu.oomall.mapper.GoodsMapper;
import xmu.oomall.service.impl.OrderServiceImpl;
import xmu.oomall.util.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 商品Dao
 * @author: Ming Qiu
 * @date: Created in 21:31 2019/11/25
 **/
@Repository
public class GoodsDao {
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private Config config;

    /**
     * 用ID获取货品
     * @param id 货品id
     * @return 带商品一起返回
     */
    public Product findProductById(Integer id){
        //从redis中获取product
        String key = "P_"+id;
        Product product = (Product) redisTemplate.opsForValue().get(key);
        if (product == null) {
            logger.debug("Redis中无product对象"+key);
            product = goodsMapper.findProductById(id);
            redisTemplate.opsForValue().set(key, product, config.getRedisExpireTime(), TimeUnit.MINUTES);
            logger.debug("Redis中存入 product = "+product);
        }
        Goods goods = this.findGoodsById(product.getGoodsId());
        product.setDesc(goods);
        return product;
    }

    /**
     * 用ID获取商品
     * @param id 商品id
     * @return 商品，带商品的Promotion一起返回
     */
    public Goods findGoodsById(Integer id){
        String key = "G_"+id;
        Goods goods = (Goods) redisTemplate.opsForValue().get(key);
        if (goods == null) {
            logger.debug("Redis中无goods对象"+key);
            goods = goodsMapper.findGoodsById(id);
            List<PromotionPo> promotionPos = goodsMapper.findPromotionByGoodsId(id);
            List<Promotion> promotions = new ArrayList<>(promotionPos.size());
            for (PromotionPo item : promotionPos){
                Promotion promotion = new Promotion(item);
                promotions.add(promotion);
            }
            goods.setPromotion(promotions);
            redisTemplate.opsForValue().set(key, goods, config.getRedisExpireTime(), TimeUnit.MINUTES);
            logger.debug("Redis中存入 goods = "+goods);
        }
        return goods;
    }



}
