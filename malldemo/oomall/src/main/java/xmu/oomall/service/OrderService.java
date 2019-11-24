package xmu.oomall.service;

import org.springframework.stereotype.Service;
import xmu.oomall.domain.cart.CartItem;
import xmu.oomall.domain.order.Order;

import java.util.List;

/**
 * @Author: Ming Qiu
 * @Description: 订单有关的服务
 * @Date: Created in 15:47 2019/11/5
 * @Modified By:
 **/
@Service
public interface OrderService {

    /**
     * 提交订单
     * @param order 新订单
     * @param cartItems 购物车中加入订单的货品
     * @return 新产生的订单
     */
    public Order submit(Order order, List<CartItem> cartItems);

}
