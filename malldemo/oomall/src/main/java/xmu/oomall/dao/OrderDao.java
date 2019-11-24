package xmu.oomall.dao;

import xmu.oomall.domain.cart.CartItem;
import xmu.oomall.domain.order.Order;

import java.util.List;

/**
 * @Author: Ming Qiu
 * @Description:
 * @Date: Created in 17:02 2019/11/5
 * @Modified By:
 **/
public class OrderDao {

    /**
     * 将购物车中物品加入订单
     * @param cartItems 购物车物品
     * @param order 订单
     */
    public void addCartToOrder(List<CartItem> cartItems, Order order){
        for (CartItem item: cartItems){

        }
    }
}
