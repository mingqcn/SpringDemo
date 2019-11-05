package xmu.oomall.controller.vo;

import xmu.oomall.domain.Address;
import xmu.oomall.domain.CartItem;
import xmu.oomall.domain.GroupOnRule;

import java.util.List;

/**
 * @Author: Ming Qiu
 * @Description: OrderController.submit 的VO对象
 * @Date: Created in 15:06 2019/11/5
 * @Modified By:
 **/
public class OrderSubmitVO {
    private List<Integer> cartItem_ids; // 用户在购物车中选中项目的id
    private Address address; //配送的地址
    private Integer ACoupon_id; //优惠卷id
    private Integer groupOnRule_id; //团购活动id
    private String message; //订单留言

    @Override
    public String toString() {
        return "OrderSubmitVO{" +
                "cartItem_ids=" + cartItem_ids +
                ", address=" + address +
                ", ACoupon_id=" + ACoupon_id +
                ", groupOnRule_id=" + groupOnRule_id +
                ", message='" + message + '\'' +
                '}';
    }

    public Integer getGroupOnRule_id() {
        return groupOnRule_id;
    }

    public void setGroupOnRule_id(Integer groupOnRule_id) {
        this.groupOnRule_id = groupOnRule_id;
    }

    public List<Integer> getCartItem_ids() {
        return cartItem_ids;
    }

    public void setCartItem_ids(List<Integer> cartItem_ids) {
        this.cartItem_ids = cartItem_ids;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getACoupon_id() {
        return ACoupon_id;
    }

    public void setACoupon_id(Integer ACoupon_id) {
        this.ACoupon_id = ACoupon_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
