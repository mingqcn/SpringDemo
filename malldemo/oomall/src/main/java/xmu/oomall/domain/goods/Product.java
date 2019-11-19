package xmu.oomall.domain.goods;

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
    /**
     * 货品编号
     */
    private String productSn;
    /**
     * sku属性，用于描述特定货品，如红色，41码
     */
    private String productPropery;
    /**
     * 库存量
     */
    private Integer stock;
    /**
     * 零售价
     */
    private BigDecimal retailPrice;
    /**
     * 销售价
     */
    private BigDecimal purchasePrice;
    /**
     * 商品
     */
    private Goods desc;

    private LocalDateTime addTime;
    private LocalDateTime updateTime;
    private Boolean isDeleted = false;


    /**
     * 默认构造函数
     */
    public Product() {
        this.setAddTime(LocalDateTime.now());
    }

    /****************************************************
     * 生成代码
     ****************************************************/



    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productSn='" + productSn + '\'' +
                ", productPropery='" + productPropery + '\'' +
                ", stock=" + stock +
                ", retailPrice=" + retailPrice +
                ", purchasePrice=" + purchasePrice +
                ", desc=" + desc +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                ", isDeleted=" + isDeleted +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
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

    public String getProductSn() {
        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn;
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

    public Goods getDesc() {
        return desc;
    }

    public void setDesc(Goods desc) {
        this.desc = desc;
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

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
