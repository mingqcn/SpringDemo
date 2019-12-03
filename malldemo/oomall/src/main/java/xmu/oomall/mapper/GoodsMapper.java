package xmu.oomall.mapper;

import org.apache.ibatis.annotations.Mapper;
import xmu.oomall.domain.goods.Goods;
import xmu.oomall.domain.goods.Product;
import xmu.oomall.domain.goods.PromotionPo;

import java.util.List;

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

    /**
     * 用商品id获取商品的所有优惠活动
     * @param id
     * @return 优惠对象列表
     */
    List<PromotionPo> findPromotionByGoodsId(Integer id);

    /**
     * 获得数据库中的货品库存量
     * @param id 货品id
     * @return 库存量
     */
    Integer getStockInDB(Integer id);

    /**
     * 更新货品对象
     * @param product 货品
     * @return 行数
     */
    int updateProduct(Product product);
}
