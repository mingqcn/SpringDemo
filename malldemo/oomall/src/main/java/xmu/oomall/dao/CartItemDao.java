package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.cart.CartItem;
import xmu.oomall.domain.goods.Product;
import xmu.oomall.mapper.CartItemMapper;
import xmu.oomall.service.CartItemService;
import xmu.oomall.service.GoodsService;

/**
 * 购物车Dao对象
 * @author: Ming Qiu
 * @date: Created in 20:42 2019/11/25
 **/

@Repository
public class CartItemDao {

    @Autowired
    private CartItemMapper cartItemMapper;

    @Autowired
    private GoodsService goodsService;

    /**
     * 用id返回购物车明细
     * @param id 购物车id
     * @return 购物车明细，带关联的货品和商品
     */
    public CartItem findCartItemById(Integer id){
        CartItem item = cartItemMapper.findCartItemById(id);
        Product product = goodsService.findProductById(item.getProductId());
        item.setProduct(product);
        return item;
    }
}
