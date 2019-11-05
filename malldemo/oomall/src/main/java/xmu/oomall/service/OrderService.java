package xmu.oomall.service;

import xmu.oomall.domain.CartItem;
import xmu.oomall.domain.GroupOnRule;
import xmu.oomall.domain.Order;

import java.util.List;

/**
 * @Author: Ming Qiu
 * @Description: 订单有关的服务
 * @Date: Created in 15:47 2019/11/5
 * @Modified By:
 **/
public interface OrderService {

    /**
     * 提交订单
     * @param order 新订单
     * @param cartItems 购物车中加入订单的货品
     * @param groupOnRule 团购规则
     */
    public Order submit(Order order, List<CartItem> cartItems, GroupOnRule groupOnRule);

}
