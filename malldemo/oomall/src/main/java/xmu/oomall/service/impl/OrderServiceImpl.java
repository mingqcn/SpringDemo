package xmu.oomall.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.domain.cart.CartItem;
import xmu.oomall.domain.order.Order;
import xmu.oomall.domain.order.OrderItem;
import xmu.oomall.service.GoodsService;
import xmu.oomall.service.OrderService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Ming Qiu
 * @description:
 * @date: Created in 16:51 2019/11/5
 * @modified By:
 **/
@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    GoodsService goodsService;

    @Override
    public Order submit(Order order, List<CartItem> cartItems) {

        //把购物车中的物品加入订单
        logger.debug("order = "+ order);
        logger.debug("cartItems = "+ cartItems);

        List<OrderItem> orderItems = new ArrayList<>(cartItems.size());

        for (CartItem cartItem: cartItems) {
            OrderItem orderItem = new OrderItem(cartItem);
            orderItems.add(orderItem);
        }

        order.setItems(orderItems);

        goodsService.clearCartItem(cartItems);

        //计算优惠价
        order.cacuDealPrice();

    return order;

    }
}
