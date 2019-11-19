package xmu.oomall.domain.order;

import xmu.oomall.domain.*;
import xmu.oomall.domain.coupon.Coupon;
import xmu.oomall.domain.user.Address;
import xmu.oomall.domain.user.User;
import xmu.oomall.util.JacksonUtil;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author  Ming Qiu
 * @Description: 订单
 * @Date: Created in 16:08 2019/11/5
 * @Modified By:
 */
public class Order {
    private OrderPo realObj;

    /**
     * 计算订单的总费用和货物件数
     */
    private void cacuTotal(){
        BigDecimal total = BigDecimal.ZERO;
        BigDecimal dealTotal = BigDecimal.ZERO;
        Integer totalQuantity = 0;
        for (OrderItem item:this.getItems()){
            total = total.add(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
            totalQuantity += item.getQuantity();
            BigDecimal dealPrice = item.getDealPrice();
            if (dealPrice != null){
                dealTotal = dealTotal.add(dealPrice);
            }
        }
        this.setGoodPrice(total);
        this.setQuantity(totalQuantity);
        this.setCouponPrice(total.subtract(dealTotal));
    }

    /**
     * 计算订单的成交价格
     */
    public void cacuDealPrice(){
        //目前设计只支持一个订单中同类优惠卷只能使用一张优惠卷，一个货品只能选择使用一张优惠卷
        Coupon coupon = this.getCoupon();
        coupon.cacuCouponPrice(this);
        this.cacuTotal();
    }

    /**
     * 获得地址
     * JSON格式{ name：“XXX”, obj:{XXX}}
      * @return 地址对象
     */
    public Address getAddress() {
        return JacksonUtil.parseObject(realObj.getAddress(),"obj", Address.class);
    }

    /**
     * 设置定制
     * @param address 地址对象
     */
    public void setAddress(Address address) {
        Map<String, Object> addressMap= new HashMap<String, Object>();
        addressMap.put("name", Address.class.getName());
        addressMap.put("obj", address);
        realObj.setAddress(JacksonUtil.toJson(addressMap));
    }

    /****************************************************
     * 生成代码
     ****************************************************/

    public Order() {
        this.realObj = new OrderPo();
    }

    public Order(OrderPo realObj) {
        this.realObj = realObj;
    }


    public Integer getId() {
        return realObj.getId();
    }

    public void setId(Integer id) {
        realObj.setId(id);
    }

    public String getOrderSN() {
        return realObj.getOrderSn();
    }

    public void setOrderSN(String orderSN) {
        realObj.setOrderSn(orderSN);
    }

    public Integer getOrderStatus() {
        return realObj.getOrderStatus();
    }

    public void setOrderStatus(Integer orderStatus) {
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
        return realObj.getShipSn();
    }

    public void setShipSN(String shipSN) {
        realObj.setShipSn(shipSN);
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

    public Coupon getCoupon() {
        return realObj.getCoupon();
    }

    public void setCoupon(Coupon coupon) {
        realObj.setCoupon(coupon);
    }

    public Integer getQuantity() {
        return realObj.getQuantity();
    }

    public void setQuantity(Integer quantity) {
        realObj.setQuantity(quantity);
    }

    public Integer getGrossWeight() {
        return realObj.getGrossWeight();
    }

    public void setGrossWeight(Integer grossWeight) {
        realObj.setGrossWeight(grossWeight);
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

    public OrderPo getRealObj() {
        return realObj;
    }

}
