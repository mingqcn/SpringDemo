package xmu.oomall.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 货品
 * 特定规格的商品被称为货品，如红色，41码的运动鞋被称为货品
 * 该对象不可以删除
 */
public class Product {
    private Integer id;
    private String productSN; //货品编号
    private String productPropery; //sku属性，用于描述特定货品，如红色，41码
    private Integer stock; //库存量
    private BigDecimal retailPrice; //零售价
    private BigDecimal purchasePrice; //销售价
    private Goods desc; //商品
    private LocalDateTime addTime;
    private LocalDateTime updateTime;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productSN='" + productSN + '\'' +
                ", productPropery='" + productPropery + '\'' +
                ", stock=" + stock +
                ", retailPrice=" + retailPrice +
                ", purchasePrice=" + purchasePrice +
                ", desc=" + desc +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id);
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

    public String getProductSN() {
        return productSN;
    }

    public void setProductSN(String productSN) {
        this.productSN = productSN;
    }

    public String getProductPropery() {
        return productPropery;
    }

    public void setProductPropery(String productPropery) {
        this.productPropery = productPropery;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
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

    public Goods getDesc() {
        return desc;
    }

    public void setDesc(Goods desc) {
        this.desc = desc;
    }
}
