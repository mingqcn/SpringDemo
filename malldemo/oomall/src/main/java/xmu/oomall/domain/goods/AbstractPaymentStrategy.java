package xmu.oomall.domain.goods;

import xmu.oomall.domain.payment.Payment;
import xmu.oomall.domain.order.Order;

import java.util.List;

/**
 * 活动付款策略
 * @author: Ming Qiu
 * @date: Created in 14:21 2019/11/26
 **/
public interface AbstractPaymentStrategy{
    /**
     * 获得付款方式
     * @param order 订单对象
     * @param maxPayTime 最长付款间隔
     * @return  付款列表（预售可能会返回多个付款）
     */
    List<Payment> getPayment(Order order, Integer maxPayTime);
}
