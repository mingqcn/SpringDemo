package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.goods.Product;
import xmu.oomall.mapper.GoodsMapper;

/**
 * @author: Ming Qiu
 * @date: Created in 21:31 2019/11/25
 **/
@Repository
public class GoodsDao {

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 用ID获取货品
     * @param id 货品id
     * @return 带商品一起返回
     */
    public Product findProductById(Integer id){
        return goodsMapper.findProductById(id);
    }

}
