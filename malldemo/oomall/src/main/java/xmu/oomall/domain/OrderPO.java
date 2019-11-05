package xmu.oomall.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @Author: Ming Qiu$
 * @Description:
 * @Date: Created in 16:08$ 2019/11/5$
 * @Modified By:
 **/
public class OrderPO {
    private Integer id;
    private String orderSN; //订单序号
    private String address; //地址 JSON格式
    private Short orderStatus; //订单状态
    private String message; //留言
    private BigDecimal goodPrice; //订单费用
    private BigDecimal couponPrice; //优惠卷减免费用
    private BigDecimal freightPrice; //配送费用
    private BigDecimal integralPrice; //积分费用
    private String shipSN; //快递单编号
    private Short shipChannel; //发货快递公司
    private LocalDateTime shipTime; //发货时间
    private LocalDateTime confirmTime; //用户收货确认时间
    private LocalDateTime endTime; //订单关闭时间
    private List<OrderItem> items; //订单明细
    private List<Payment> payments; //付款记录
    private User user; //下单用户
    private ACoupon coupon; //使用的优惠卷
    private LocalDateTime addTime;
    private LocalDateTime updateTime;

    @Override
    public String toString() {
        return "OrderPO{" +
                "id=" + id +
                ", orderSN='" + orderSN + '\'' +
                ", address='" + address + '\'' +
                ", orderStatus=" + orderStatus +
                ", message='" + message + '\'' +
                ", goodPrice=" + goodPrice +
                ", couponPrice=" + couponPrice +
                ", freightPrice=" + freightPrice +
                ", integralPrice=" + integralPrice +
                ", shipSN='" + shipSN + '\'' +
                ", shipChannel=" + shipChannel +
                ", shipTime=" + shipTime +
                ", confirmTime=" + confirmTime +
                ", endTime=" + endTime +
                ", items=" + items +
                ", payments=" + payments +
                ", user=" + user +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderPO orderPO = (OrderPO) o;
        return getId().equals(orderPO.getId());
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

    public String getOrderSN() {
        return orderSN;
    }

    public void setOrderSN(String orderSN) {
        this.orderSN = orderSN;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Short getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Short orderStatus) {
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

    public String getShipSN() {
        return shipSN;
    }

    public void setShipSN(String shipSN) {
        this.shipSN = shipSN;
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

    public ACoupon getCoupon() {
        return coupon;
    }

    public void setCoupon(ACoupon coupon) {
        this.coupon = coupon;
    }
}
