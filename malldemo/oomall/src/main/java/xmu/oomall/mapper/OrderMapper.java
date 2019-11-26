package xmu.oomall.mapper;

import org.apache.ibatis.annotations.Mapper;
import xmu.oomall.domain.order.Order;
import xmu.oomall.domain.order.OrderItem;

import java.util.List;

/**
 * @author: Ming Qiu
 * @date: Created in 14:43 2019/11/26
 **/
@Mapper
public interface OrderMapper {
    /**
     * 根据id返回订单对象
     * @param id 订单id
     * @return 订单对象，带订单明细
     */
    Order findOrderById(Integer id);

    /**
     * 新增一个订单
     * @param order 订单对象
     * @return 行数
     */
    int addOrder(Order order);

    /**
     * 新增订单的所有明细
     * @param items 订单明细
     * @return 行数
     */
    int addOrderItems(List<OrderItem> items);

}
