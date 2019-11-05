package xmu.oomall.domain;

import xmu.oomall.util.JacksonUtil;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 订单
 */
public class Order {
    private OrderPO realObj;

    public Order(OrderPO realObj) {
        this.realObj = realObj;
    }

    public Order() {
        this.realObj = new OrderPO();
    }


    public Integer getId() {
        return realObj.getId();
    }

    public void setId(Integer id) {
        realObj.setId(id);
    }

    public String getOrderSN() {
        return realObj.getOrderSN();
    }

    public void setOrderSN(String orderSN) {
        realObj.setOrderSN(orderSN);
    }

    public Address getAddress() {
        return JacksonUtil.toObject(realObj.getAddress(), Address.class);
    }

    public void setAddress(Address address) {
        realObj.setAddress(JacksonUtil.toJson(address));
    }

    public Short getOrderStatus() {
        return realObj.getOrderStatus();
    }

    public void setOrderStatus(Short orderStatus) {
        realObj.setOrderStatus(orderStatus);
    }

    public String getMessage() {
        return realObj.getMessage();
    }

    public void setMessage(String message) {
        realObj.setMessage(message);
    }

    public BigDecimal getGoodPrice() {
        return realObj.getGoodPrice();
    }

    public void setGoodPrice(BigDecimal goodPrice) {
        realObj.setGoodPrice(goodPrice);
    }

    public BigDecimal getCouponPrice() {
        return realObj.getCouponPrice();
    }

    public void setCouponPrice(BigDecimal couponPrice) {
        realObj.setCouponPrice(couponPrice);
    }

    public BigDecimal getFreightPrice() {
        return realObj.getFreightPrice();
    }

    public void setFreightPrice(BigDecimal freightPrice) {
        realObj.setFreightPrice(freightPrice);
    }

    public BigDecimal getIntegralPrice() {
        return realObj.getIntegralPrice();
    }

    public void setIntegralPrice(BigDecimal integralPrice) {
        realObj.setIntegralPrice(integralPrice);
    }

    public String getShipSN() {
        return realObj.getShipSN();
    }

    public void setShipSN(String shipSN) {
        realObj.setShipSN(shipSN);
    }

    public Short getShipChannel() {
        return realObj.getShipChannel();
    }

    public void setShipChannel(Short shipChannel) {
        realObj.setShipChannel(shipChannel);
    }

    public LocalDateTime getShipTime() {
        return realObj.getShipTime();
    }

    public void setShipTime(LocalDateTime shipTime) {
        realObj.setShipTime(shipTime);
    }

    public LocalDateTime getConfirmTime() {
        return realObj.getConfirmTime();
    }

    public void setConfirmTime(LocalDateTime confirmTime) {
        realObj.setConfirmTime(confirmTime);
    }

    public LocalDateTime getEndTime() {
        return realObj.getEndTime();
    }

    public void setEndTime(LocalDateTime endTime) {
        realObj.setEndTime(endTime);
    }

    public List<OrderItem> getItems() {
        return realObj.getItems();
    }

    public void setItems(List<OrderItem> items) {
        realObj.setItems(items);
    }

    public List<Payment> getPayments() {
        return realObj.getPayments();
    }

    public void setPayments(List<Payment> payments) {
        realObj.setPayments(payments);
    }

    public User getUser() {
        return realObj.getUser();
    }

    public void setUser(User user) {
        realObj.setUser(user);
    }

    public LocalDateTime getAddTime() {
        return realObj.getAddTime();
    }

    public void setAddTime(LocalDateTime addTime) {
        realObj.setAddTime(addTime);
    }

    public LocalDateTime getUpdateTime() {
        return realObj.getUpdateTime();
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        realObj.setUpdateTime(updateTime);
    }

    public OrderPO getRealObj() {
        return realObj;
    }

    public void setAddress(String address) {
        realObj.setAddress(address);
    }

    public ACoupon getCoupon() {
        return realObj.getCoupon();
    }

    public void setCoupon(ACoupon coupon) {
        realObj.setCoupon(coupon);
    }
}
