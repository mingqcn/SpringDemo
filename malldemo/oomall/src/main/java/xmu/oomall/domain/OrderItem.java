package xmu.oomall.domain;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 订单明细
 *  当用户删除一条明细时，这一对象会真实在数据库中删除
 */
public class OrderItem {

    private Integer id;
    private Integer number; //数量
    private BigDecimal price; //价格
    private BigDecimal dealPrice; //成交价格，用于退货
    private Product product; //货品
    private LocalDateTime addTime;
    private LocalDateTime updateTime;

    /**
     * 由购物车对象构造订单明细对象
     * @param cartItem 购物车对象
     */
    public OrderItem(CartItem cartItem) {
        this.setNumber(cartItem.getNumber());
        this.setProduct(cartItem.getProduct());
        this.setPrice(this.getProduct().getPurchasePrice());
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", number=" + number +
                ", price=" + price +
                ", dealPrice=" + dealPrice +
                ", product=" + product +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return id.equals(orderItem.id);
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(BigDecimal dealPrice) {
        this.dealPrice = dealPrice;
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
