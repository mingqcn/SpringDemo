package xmu.oomall.domain.goods;

import xmu.oomall.domain.payment.Payment;
import xmu.oomall.domain.order.Order;
import xmu.oomall.domain.order.OrderItem;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 预售的付款方式
 * @author: Ming Qiu
 * @date: Created in 22:36 2019/11/29
 **/
public class PrePayStrategy implements AbstractPaymentStrategy, Serializable {

    /**
     * 预付款
     */
    private BigDecimal advPayment;

    /**
     * 尾款
     */
    private BigDecimal finalPayment;

    /**
     * 尾款付清的期限
     */
    private LocalDateTime finalPayEndTime;
    /**
     * 开始支付尾款付清的时间
     */
    private LocalDateTime finalPayBeginTime;


    @Override
    public List<Payment> getPayment(Order order, Integer maxPayTime) {
        BigDecimal prePay = BigDecimal.ZERO;
        BigDecimal finalPay = BigDecimal.ZERO;
        LocalDateTime now = LocalDateTime.now();

        for (OrderItem item: order.getItems()){
            prePay = prePay.add(this.advPayment);
            finalPay = finalPay.add(this.finalPayment);
        }

        Payment prePayment = new Payment();
        prePayment.setAmount(prePay);
        prePayment.setEndTime(now.plusMinutes(maxPayTime));

        Payment finalPayment = new Payment();
        finalPayment.setAmount(finalPay);
        finalPayment.setBeginTime(this.finalPayBeginTime);
        finalPayment.setEndTime(this.finalPayEndTime);

        List<Payment> ret = new ArrayList<>(2);
        ret.add(prePayment);
        ret.add(finalPayment);
        return ret;
    }

    @Override
    public String toString() {
        return "PrePayStrategy{" +
                "advPayment=" + advPayment +
                ", finalPayment=" + finalPayment +
                ", finalPayEndTime=" + finalPayEndTime +
                ", finalPayBeginTime=" + finalPayBeginTime +
                '}';
    }

    public BigDecimal getAdvPayment() {
        return advPayment;
    }

    public void setAdvPayment(BigDecimal advPayment) {
        this.advPayment = advPayment;
    }

    public BigDecimal getFinalPayment() {
        return finalPayment;
    }

    public void setFinalPayment(BigDecimal finalPayment) {
        this.finalPayment = finalPayment;
    }

    public LocalDateTime getFinalPayEndTime() {
        return finalPayEndTime;
    }

    public void setFinalPayEndTime(LocalDateTime finalPayEndTime) {
        this.finalPayEndTime = finalPayEndTime;
    }

    public LocalDateTime getFinalPayBeginTime() {
        return finalPayBeginTime;
    }

    public void setFinalPayBeginTime(LocalDateTime finalPayBeginTime) {
        this.finalPayBeginTime = finalPayBeginTime;
    }

}
