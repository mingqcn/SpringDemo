package xmu.oomall.domain.coupon;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * @Author: Ming Qiu
 * @Description: 按照比例计算优惠折扣
 * @Date: Created in 18:55 2019/11/14
 * @Modified By:
 **/
public class PercentageStrategy extends AbstractCouponStrategy {
    /**
     * JSON格式
     * {threshold:xxx, percentage:xxx}
     */

    /**
     *满
     */
    private BigDecimal threshold = BigDecimal.ZERO;
    /**
     * 优惠比例
     */
    private BigDecimal percentage = BigDecimal.valueOf(1.0);

    @Override
    protected boolean isEnough(BigDecimal totalPrice, Integer totalQuantity) {
        return false;
    }

    @Override
    protected BigDecimal getDealPrice(BigDecimal itemPrice, BigDecimal totalPrice) {
        return  itemPrice.subtract(this.percentage.multiply(itemPrice));
    }

    @Override
    protected BigDecimal getError(BigDecimal totalPrice, BigDecimal dealPrice) {
        return dealPrice.subtract(totalPrice.multiply(this.percentage).setScale(2, RoundingMode.HALF_UP));
    }


    /****************************************************
     * 生成代码
     ****************************************************/

    public PercentageStrategy() {
    }

    @Override
    public String toString() {
        return "PercentageStrategy{" +
                "threshold=" + threshold +
                ", percentage=" + percentage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        PercentageStrategy that = (PercentageStrategy) o;
        return Objects.equals(threshold, that.threshold) &&
                Objects.equals(percentage, that.percentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(threshold, percentage);
    }

    public PercentageStrategy(BigDecimal threshold, BigDecimal percentage) {
        this.threshold = threshold;
        this.percentage = percentage;
    }

    public BigDecimal getThreshold() {
        return threshold;
    }

    public void setThreshold(BigDecimal threshold) {
        this.threshold = threshold;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }
}
