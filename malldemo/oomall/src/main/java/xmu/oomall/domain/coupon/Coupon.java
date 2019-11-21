package xmu.oomall.domain.coupon;

import xmu.oomall.domain.order.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @Author: Ming Qiu
 * @Description:一张优惠卷
 * @Date: Created in 14:10 2019/11/5
 * @Modified By:
 **/
public class Coupon {

    /**
     * 未使用
     */
    public static int NOT_USED = 1;

    private Integer id;
    /**
     * 优惠卷序号
     */
    private String couponSn;
    /**
     * 优惠卷启用时间，默认2019年10月1日
     */
    private LocalDateTime beginTime;
    /**
     * 优惠卷失效时间，默认3019年10月1日
     */
    private LocalDateTime endTime;
    /**
     * 优惠卷状态, 未使用，已使用，过期等等
     */
    private Integer status = Status.NOT_USED.getValue();
    /**
     * 所属的优惠卷类别
     */
    private CouponRule couponRule;
    private LocalDateTime addTime;
    private LocalDateTime updateTime;
    private Boolean beDeleted = false;

    /**
     * 优惠卷的状态
     */
    public enum Status {
        NOT_USED("未用", Integer.valueOf(0)),
        USED("已用", Integer.valueOf(1)),
        EXPIRED("过期", Integer.valueOf(2));

        /**
         * 值
         */
        private final Integer value;

        /**
         * 名称
         */
        private final String name;

        /**
         * 构造函数
         * @param name 名称
         * @param value 值
         */
        Status(String name, Integer value) {
            this.value = value;
            this.name = name;
        }

        /**
         * 获得值
         * @return 值
         */
        public Integer getValue() {
            return this.value;
        }

        /**
         * 获得名称
         * @return 名
         */
        public String getName() {
            return this.name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    /**
     * 判断某个优惠卷是否能用
     *
     * @return
     */
    public boolean isReadyToUse() {
        LocalDateTime now = LocalDateTime.now();
        return (this.getBeginTime().isBefore(now) &&
                this.getEndTime().isAfter(now) &&
                this.getStatus().equals(Status.NOT_USED.getValue()));
    }

    /**
     * 获得优惠的费用
     *
     * @param order 订单
     * @return 优惠的费用
     */
    public BigDecimal getReductPrice(Order order) {
        BigDecimal reductPrice = BigDecimal.ZERO;
        if (this.isReadyToUse()){
            reductPrice = this.getCouponRule().getReductPrice(order);
        }
        return reductPrice;
    }

    /**
     * 获得优惠卷名称
     *
     * @return
     */
    public String getName() {
        return this.getCouponRule().getName();
    }

    /**
     * 获得优惠卷的图片
     *
     * @return
     */
    public String getPicUrl() {
        return this.getCouponRule().getPicUrl();
    }

    /**
     * 获得适用的商品
     *
     * @return 按照商品id升序返回
     */
    public List<Integer> getGoodsIds() {
        return this.getCouponRule().getGoodsIds();
    }

    /****************************************************
     * 生成代码
     ****************************************************/

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", couponSn='" + couponSn + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", status=" + status +
                ", couponRule=" + couponRule +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                ", beDeleted=" + beDeleted +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coupon coupon = (Coupon) o;
        return getId().equals(coupon.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCouponSn() {
        return couponSn;
    }

    public void setCouponSn(String couponSn) {
        this.couponSn = couponSn;
    }

    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public CouponRule getCouponRule() {
        return couponRule;
    }

    public void setCouponRule(CouponRule couponRule) {
        this.couponRule = couponRule;
    }

    public LocalDateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getBeDeleted() {
        return beDeleted;
    }

    public void setBeDeleted(Boolean beDeleted) {
        this.beDeleted = beDeleted;
    }
}
