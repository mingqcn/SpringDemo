package xmu.oomall.domain;

import xmu.oomall.domain.goods.Product;
import xmu.oomall.domain.user.User;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @Author: Ming Qiu
 * @Description: 购物车中的货品
 * 这一对象会真实在数据库中删除
 * @Date: Created in 14:28 2019/11/5
 * @Modified By:
 **/
public class CartItem {
    private Integer id;
    /**
     * 数量
     */
    private Integer quantity;
    /**
     * 归属的用户
     */
    private User owner;
    /**
     * 货品
     */
    private Product product;
    private LocalDateTime addTime;
    private LocalDateTime updateTime;


    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", owner=" + owner +
                ", product=" + product +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return id.equals(cartItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
