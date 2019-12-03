package xmu.oomall.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.goods.Goods;
import xmu.oomall.domain.goods.Product;
import xmu.oomall.mapper.GoodsMapper;
import xmu.oomall.service.impl.OrderServiceImpl;

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

    /**
     * 用ID获取货品
     * @param id 货品id
     * @return 带商品一起返回
     */
    public Product findProductById(Integer id){

        Product product = goodsMapper.findProductById(id);
        Goods goods = goodsMapper.findGoodsById(product.getGoodsId());
        product.setDesc(goods);
        return product;
    }

}
