package xmu.oomall.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xmu.oomall.dao.OrderDao;
import xmu.oomall.domain.cart.CartItem;
import xmu.oomall.domain.goods.Promotion;
import xmu.oomall.domain.order.Order;
import xmu.oomall.domain.order.OrderItem;
import xmu.oomall.service.CartItemService;
import xmu.oomall.service.OrderService;
import xmu.oomall.util.Config;

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
    CartItemService cartItemService;

    @Autowired
    OrderDao orderDao;


    @Autowired
    Config config;

    @Override
    @Transactional
    public Order submit(Order order, List<CartItem> cartItems) {

        //把购物车中的物品加入订单
        logger.debug("submit参数order = "+ order + " cartItems = " + cartItems);

        List<OrderItem> orderItems = new ArrayList<>(cartItems.size());

        for (CartItem cartItem: cartItems) {
            OrderItem orderItem = new OrderItem(cartItem);
            orderItems.add(orderItem);
            Promotion promotion = orderItem.getProduct().getDesc().getPromotion();
            if (order.getPromotion() == null){
                order.setPromotion(promotion);
            }else if (!order.getPromotion().equals(promotion)){
                //TODO:报错，一个订单只能有一个促销活动
            }
        }
        order.setItems(orderItems);

        cartItemService.clearCartItem(cartItems);

        //计算优惠价
        order.cacuDealPrice();

        logger.debug("order = "+ order);

        //计算付款方式
        order.cacuPayment(config.getMaxPayTime());

        Order newOrder = orderDao.addOrder(order);

        logger.debug("submit返回值：order = "+ newOrder);

    return newOrder;

    }
}
