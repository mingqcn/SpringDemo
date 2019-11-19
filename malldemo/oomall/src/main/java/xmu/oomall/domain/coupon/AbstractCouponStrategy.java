package xmu.oomall.domain.coupon;

import xmu.oomall.domain.order.Order;
import xmu.oomall.domain.order.OrderItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: Ming Qiu
 * @Description: 优惠卷策略的抽象類
 * @Date: Created in 15:47 2019/11/5
 * @Modified By:
 * */
public abstract class AbstractCouponStrategy {

    /**
     * 用于判断是否已经满足优惠门槛
     * @param totalPrice 总费用
     * @param totalQuantity 总数量
     * @return true- 已经满足， false - 不满足
     */
    protected abstract boolean isEnough(BigDecimal totalPrice, Integer totalQuantity);

    /**
     * 计算折扣后的价格
     * @param totalPrice 优惠货品的总价
     * @param  itemPrice 当前货品的小计价格
     * @return 折扣后的价格
     */
    protected abstract BigDecimal getDealPrice(BigDecimal itemPrice, BigDecimal totalPrice);

    /**
     * 获得优惠的费用
     * @param validItems 订单中可以用于优惠卷的明细
     * @return 优惠減免的费用
     */
    public BigDecimal cacuDiscount(List<OrderItem> validItems){
        //优惠商品的总价和数量
        BigDecimal totalPrice = BigDecimal.ZERO;
        Integer totalQuantity = 0;

        //优惠的货品
        List<OrderItem> discountItems = new ArrayList<OrderItem>(validItems.size());

        Iterator<OrderItem> itemIterator = validItems.iterator();
        //判断是否达到优惠门槛
        boolean enough = this.isEnough(totalPrice, totalQuantity);

        while (itemIterator.hasNext() && !enough){
            OrderItem item = itemIterator.next();
            totalPrice.add(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
            totalQuantity += item.getQuantity();
            discountItems.add(item);
            enough = this.isEnough(totalPrice, totalQuantity);
        }

        //计算优惠后的价格
        BigDecimal dealTotalPrice = BigDecimal.ZERO;
        if (enough) {
            for (OrderItem item: discountItems){
                //按照比例分配，可能会出现精度误差，在后面补偿到第一个货品上
                BigDecimal dealPrice = this.getDealPrice(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())), totalPrice);
                item.setDealPrice(dealPrice);
                dealTotalPrice.add(dealPrice);
            }

            BigDecimal error =  totalPrice.subtract(dealTotalPrice);

            if (error.compareTo(BigDecimal.ZERO) != 0){
                //前面保留小数两位数可能出现的精度误差
                //TODO：处理优惠后的精度误差
            }

        }

        return totalPrice.subtract(dealTotalPrice);
    }
}
