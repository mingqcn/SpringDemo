package xmu.oomall.service;

import org.springframework.stereotype.Service;
import xmu.oomall.domain.cart.CartItem;

import java.util.List;

/**
 * @Author: Ming Qiu
 * @Description: 商品有关的服务
 * @Date: Created in 15:47 2019/11/5
 * @Modified By:
 **/
@Service
public interface CartItemService {

    /**
     * 用ID获得CartItem对象
     * @param id 对象ID
     * @return cartItem对象
     */
    CartItem findCartItemById(Integer id);

    /**
     * 清空购物车里的指定项目
     * @param cartItems 待清空的项目
     */
    void clearCartItem(List<CartItem> cartItems);



}
