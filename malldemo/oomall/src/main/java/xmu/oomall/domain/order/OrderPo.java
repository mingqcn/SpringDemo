package xmu.oomall.domain.order;

import xmu.oomall.domain.coupon.Coupon;
import xmu.oomall.domain.Payment;
import xmu.oomall.domain.user.User;
import xmu.oomall.util.Common;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @Author: Ming Qiu
 * @Description:
 * @Date: Created in 16:08 2019/11/5
 * @Modified By:
 **/
public class OrderPo {
    private Integer id;
    /**
     * 订单序号
     */
    private String orderSn;
    /**
     * 地址 JSON格式
     */
    private String address;
    /**
     * 订单状态
     */
    private Integer orderStatus;
    /**
     * 留言
     */
    private String message;
    /**
     * 订单费用
     */
    private BigDecimal goodPrice;
    /**
     * 优惠卷减免费用
     */
    private BigDecimal couponPrice;
    /**
     * 配送费用
     */
    private BigDecimal freightPrice;
    /**
     * 积分费用
     */
    private BigDecimal integralPrice;
    /**
     * 订单中货品件数
     */
    private Integer quantity;
    /**
     * 订单毛重 单位克
     */
    private Integer grossWeight;
    /**
     * 快递单编号
     */
    private String shipSn;
    /**
     * 发货快递公司
     */
    private Short shipChannel;
    /**
     * 发货时间
     */
    private LocalDateTime shipTime;
    /**
     * 用户收货确认时间
     */
    private LocalDateTime confirmTime;
    /**
     * 订单关闭时间
     */
    private LocalDateTime endTime;
    /**
     * 订单明细
     */
    private List<OrderItem> items;
    /**
     *付款记录
     */
    private List<Payment> payments;
    /**
     * 下单用户
     */
    private User user;
    /**
     * 使用的优惠卷（一个订单只能使用一张优惠卷）
     */
    private Coupon coupon;

    private LocalDateTime addTime;
    private LocalDateTime updateTime;
    private Boolean isDeleted;

    /**
     * 订单号起头字母
     */
    private final static String PREFIX = "O";
    /**
     * 尾部随机数长度
     */
    private final static int RANDOM_LEN = 1;
    /**
     * 订单的状态
     * <p>
     * 订单状态：
     * NEW：101 订单生成，未支付；NOTPAID_CANCELLED:102，下单后未支付用户取消；TIMEOUT:103，下单后未支付超时系统自动取消
     * PAID:201 支付完成，商家未发货；PAID_CANCELLED:202，订单生产，已付款未发货，但是退款取消；REFUND:203 已退款
     * DELIVERED:301 商家发货，用户未确认；
     * USER_CONFIRMED: 401 用户确认收货； AUTO_CONFIRMED：402 用户没有确认收货超过一定时间，系统自动确认收货；
     *
     * <p>
     * 用户操作：
     * 当101用户未付款时，此时用户可以进行的操作是取消订单，或者付款操作
     * 当201支付完成而商家未发货时，此时用户可以取消订单并申请退款
     * 当301商家已发货时，此时用户可以有确认收货的操作
     * 当401用户确认收货以后，此时用户可以进行的操作是删除订单，评价商品，或者再次购买
     * 当402系统自动确认收货以后，此时用户可以删除订单，评价商品，或者再次购买
     */
    public enum Status {
        NEW("未支付", Integer.valueOf(101)),
        NOTPAID_CANCELLED("未付款取消", Integer.valueOf(102)),
        TIMEOUT("付款超时", Integer.valueOf(103)),
        PAID("已付款", Integer.valueOf(201)),
        PAID_CANCELLED("已付款取消", Integer.valueOf(202)),
        REFUND("已退款", Integer.valueOf(203)),
        DELIVERED("已发货", Integer.valueOf(301)),
        USER_CONFIRM("用户收货", Integer.valueOf(401)),
        AUTO_CONFIRM("默认收货", Integer.valueOf(402));

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


    public OrderPo() {
        this.orderStatus = Status.NEW.getValue();
        this.orderSn = PREFIX+ Common.getRandomNum(RANDOM_LEN);
        this.addTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "OrderPO{" +
                "id=" + id +
                ", orderSn='" + orderSn + '\'' +
                ", address='" + address + '\'' +
                ", orderStatus=" + orderStatus +
                ", message='" + message + '\'' +
                ", goodPrice=" + goodPrice +
                ", couponPrice=" + couponPrice +
                ", freightPrice=" + freightPrice +
                ", integralPrice=" + integralPrice +
                ", quantity=" + quantity +
                ", grossWeight=" + grossWeight +
                ", shipSn='" + shipSn + '\'' +
                ", shipChannel=" + shipChannel +
                ", shipTime=" + shipTime +
                ", confirmTime=" + confirmTime +
                ", endTime=" + endTime +
                ", items=" + items +
                ", payments=" + payments +
                ", user=" + user +
                ", coupon=" + coupon +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                ", isDeleted=" + isDeleted +
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
        OrderPo orderPo = (OrderPo) o;
        return getId().equals(orderPo.getId());
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

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BigDecimal getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(BigDecimal goodPrice) {
        this.goodPrice = goodPrice;
    }

    public BigDecimal getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
    }

    public BigDecimal getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(BigDecimal freightPrice) {
        this.freightPrice = freightPrice;
    }

    public BigDecimal getIntegralPrice() {
        return integralPrice;
    }

    public void setIntegralPrice(BigDecimal integralPrice) {
        this.integralPrice = integralPrice;
    }

    public String getShipSn() {
        return shipSn;
    }

    public void setShipSn(String shipSn) {
        this.shipSn = shipSn;
    }

    public Short getShipChannel() {
        return shipChannel;
    }

    public void setShipChannel(Short shipChannel) {
        this.shipChannel = shipChannel;
    }

    public LocalDateTime getShipTime() {
        return shipTime;
    }

    public void setShipTime(LocalDateTime shipTime) {
        this.shipTime = shipTime;
    }

    public LocalDateTime getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(LocalDateTime confirmTime) {
        this.confirmTime = confirmTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(Integer grossWeight) {
        this.grossWeight = grossWeight;
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

}
