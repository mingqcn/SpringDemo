package xmu.oomall.domain.order;


import org.apache.ibatis.type.Alias;
import xmu.oomall.domain.cart.CartItem;
import xmu.oomall.domain.goods.Product;
import xmu.oomall.util.Common;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author  Ming Qiu
 * @Description: 订单明细
 *  当用户删除一条明细时，这一对象会真实在数据库中删除
 * @Date: Created in 16:08 2019/11/5
 * @Modified By:
 */
@Alias("orderItem")
 public class OrderItem implements Cloneable {

    private Integer id;
    /**
     * 所属订单的ID
     */
    private Integer orderId;
    /**
     * 数量
     */
    private Integer quantity = 0;
    /**
     * 价格
     */
    private BigDecimal price = BigDecimal.ZERO;
    /**
     * 成交价格，用于退货
     */
    private BigDecimal dealPrice = BigDecimal.ZERO;
    /**
     * 货品
     */
    private Product product;
    /**
     * 商品名称+货品属性
     * 冗余存储
     */
    private String productName = "";

    /**
     * 优惠活动序号（优惠卷，团购活动或者预售活动的编号）
     */
    private String promotionSn = "";

    private LocalDateTime addTime;
    private LocalDateTime updateTime = Common.DEFAULT_TIME;
    private Boolean beDeleted = false;

    /**
     * 由购物车对象构造订单明细对象
     * @param cartItem 购物车对象
     */
    public OrderItem(CartItem cartItem) {
        this.setQuantity(cartItem.getQuantity());
        Product product = cartItem.getProduct();
        this.setProduct(product);
        this.setPrice(product.getPurchasePrice());

        StringBuffer productName = new StringBuffer(product.getDesc().getName());
        productName.append(" ");
        productName.append(product.getProductProperty());
        this.setProductName(productName.toString());

        this.setAddTime(LocalDateTime.now());
    }

    /**
     * 默认构造函数
     */
    public OrderItem() {
        this.setAddTime(LocalDateTime.now());
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        OrderItem newItem = (OrderItem) super.clone();
        newItem.setId(null);
        newItem.setAddTime(LocalDateTime.now());
        newItem.setUpdateTime(null);
        return newItem;
    }


    /****************************************************
     * 生成代码
     ****************************************************/


    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", quantity=" + quantity +
                ", price=" + price +
                ", dealPrice=" + dealPrice +
                ", product=" + product +
                ", productName='" + productName + '\'' +
                ", promotionSn='" + promotionSn + '\'' +
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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPromotionSn() {
        return promotionSn;
    }

    public void setPromotionSn(String promotionSn) {
        this.promotionSn = promotionSn;
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
