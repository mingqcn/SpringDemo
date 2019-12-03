package xmu.oomall.service;

import org.springframework.stereotype.Service;
import xmu.oomall.domain.goods.Product;

/**
 * 商品服务
 * @author: Ming Qiu
 * @date: Created in 21:03 2019/11/25
 **/
@Service
public interface GoodsService {

    /**
     * 用id获得货品
     * @param id 货品io
     * @return 货品
     */
    Product findProductById(Integer id);

    /**
     * 获得数据库中的货品库存量
     * @param id 货品id
     * @return 库存量
     */
    Integer getStockInDB(Integer id);

    /**
     * 更新数据库中的货品库存量
     * @param id 货品id
     * @param quantity 库存数量
     */
    void updateStockInDB(Integer id, Integer quantity);

}
