package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import xmu.oomall.domain.CartItem;
import xmu.oomall.domain.GroupOnRule;
import xmu.oomall.domain.Order;
import xmu.oomall.domain.OrderItem;
import xmu.oomall.service.OrderService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ming Qiu
 * @Description:
 * @Date: Created in 16:51 2019/11/5
 * @Modified By:
 **/
public class OrderServiceImpl implements OrderService {

    @Autowired

    @Override
    public Order submit(Order order, List<CartItem> cartItems, GroupOnRule groupOnRule) {

        //把购物车中的物品加入订单
        List<OrderItem> orderItems = new ArrayList<OrderItem>(cartItems.size());
        for (CartItem cartItem: cartItems){
            OrderItem orderItem = new OrderItem(cartItem);
            orderItems.add(orderItem);
        }


    }
}
