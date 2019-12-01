package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.cart.CartItem;
import xmu.oomall.domain.order.Order;
import xmu.oomall.domain.order.OrderItem;
import xmu.oomall.mapper.OrderMapper;
import xmu.oomall.service.PaymentService;

import java.util.List;

/**
 * @author: Ming Qiu
 * @date: Created in 17:02 2019/11/5
 **/
@Repository
public class OrderDao {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private PaymentService paymentService;

    /**
     * 新增订单，包括订单明细
     * @param order 订单
     * @return 新订单，带id的
     */
    public Order addOrder( Order order){

        orderMapper.addOrder(order);
        //用获得的orderId设置item
        order.setItemsOrderId();
        orderMapper.addOrderItems(order.getItems());
        //用orderid设置payment对象
        order.setPaymentsOrderId();
        paymentService.addPayment(order.getPayments());

        for (OrderItem item: order.getItems()){
            item.setProduct(null);
        }
        order.getCoupon().setCouponRule(null);

        return order;
    }
}
