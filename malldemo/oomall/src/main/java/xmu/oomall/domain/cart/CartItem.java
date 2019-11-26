package xmu.oomall.domain.cart;

import org.apache.ibatis.type.Alias;
import xmu.oomall.domain.goods.Product;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @Author: Ming Qiu
 * @Description: 购物车中的货品
 * 这一对象会真实在数据库中删除
 * @Date: Created in 14:28 2019/11/5
 * @Modified By:
 **/
@Alias("cartItem")
public class CartItem {
    private Integer id;
    /**
     * 数量
     */
    private Integer quantity;
    /**
     * 归属的用户id
     */
    private Integer  userId;
    /**
     * 货品
     */
    private Product product;
    /**
     * 货品ID
     */
    private Integer productId;

    private LocalDateTime addTime;
    private LocalDateTime updateTime;

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", userId=" + userId +
                ", product=" + product +
                ", productId=" + productId +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                '}';
    }

    /****************************************************
     * 生成代码
     ****************************************************/



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
