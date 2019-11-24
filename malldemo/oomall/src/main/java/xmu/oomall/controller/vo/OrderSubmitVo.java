package xmu.oomall.controller.vo;

import xmu.oomall.domain.user.Address;

import java.util.List;

/**
 * @Author: Ming Qiu
 * @Description: OrderController.submit 的VO对象
 * @Date: Created in 15:06 2019/11/5
 * @Modified By:
 **/
public class OrderSubmitVo {
    /**
     *  用户在购物车中选中项目的id
     */
    private List<Integer> cartItemIds;
    /**
     * 配送的地址
     */
    private Address address;
    /**
     * 优惠卷id
     */
    private Integer couponId;
    /**
     * 订单留言
     */
    private String message ="";

    /****************************************************
     * 生成代码
     ****************************************************/
    @Override
    public String toString() {
        return "OrderSubmitVo{" +
                "cartItemIds=" + cartItemIds +
                ", address=" + address +
                ", couponId=" + couponId +
                ", message='" + message + '\'' +
                '}';
    }

    public List<Integer> getCartItemIds() {
        return cartItemIds;
    }

    public void setCartItemIds(List<Integer> cartItemIds) {
        this.cartItemIds = cartItemIds;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
