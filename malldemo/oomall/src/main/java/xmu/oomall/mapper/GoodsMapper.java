package xmu.oomall.mapper;

import org.apache.ibatis.annotations.Mapper;
import xmu.oomall.domain.goods.Goods;
import xmu.oomall.domain.goods.Product;

/**
 * 商品Mapper
 * @author Ming Qiu
 */
@Mapper
public interface GoodsMapper {

    /**
     * 用id获得货品
     * @param id 货品id
     * @return 货品,带商品一起返回
     */
    Product findProductById(Integer id);

    /**
     * 用id获得商品
     * @param id 商品id
     * @return 商品
     */
    Goods findGoodsById(Integer id);
}
