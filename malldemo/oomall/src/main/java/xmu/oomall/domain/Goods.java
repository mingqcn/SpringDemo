package xmu.oomall.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * 商品信息
 * 该对象不可以删除
 */
public class Goods {
    private Integer id;
    private String goodsSN; //商品编码
    private String name; //商品名称
    private String shortName; //简称
    private String englishName; //英文名称
    private String barCode; //条码
    private String stockUnit; //库存单位
    private Integer length; //长 单位mm
    private Integer width; //宽 单位mm
    private Integer height; //高 单位mm
    private Integer grossWeight; //毛重 单位克
    private Integer netWeight; //净重 单位克
    private Short status; //商品状态，下架，上架，
    private Boolean isHot; //是否人气推荐，如果设置则可以在人气推荐页面展示
    private Boolean isNew; //是否新品首发，如果设置则可以在新品首发页面展示
    private String gallery; //商品宣传图片列表，采用JSON数组格式
    private String brief; //商品简介
    private String picUrl; //商品页面商品图片
    private String shareUrl; //商品分享朋友圈图片
    private List<Product> products; //商品的不同规格货品
    private LocalDateTime addTime;
    private LocalDateTime updateTime;

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsSN='" + goodsSN + '\'' +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", englishName='" + englishName + '\'' +
                ", barCode='" + barCode + '\'' +
                ", stockUnit='" + stockUnit + '\'' +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", grossWeight=" + grossWeight +
                ", netWeight=" + netWeight +
                ", status=" + status +
                ", isHot=" + isHot +
                ", isNew=" + isNew +
                ", gallery='" + gallery + '\'' +
                ", brief='" + brief + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", shareUrl='" + shareUrl + '\'' +
                ", products=" + products +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return id.equals(goods.getId());
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

    public String getGoodsSN() {
        return goodsSN;
    }

    public void setGoodsSN(String goodsSN) {
        this.goodsSN = goodsSN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getStockUnit() {
        return stockUnit;
    }

    public void setStockUnit(String stockUnit) {
        this.stockUnit = stockUnit;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(Integer grossWeight) {
        this.grossWeight = grossWeight;
    }

    public Integer getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(Integer netWeight) {
        this.netWeight = netWeight;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
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

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Boolean getHot() {
        return isHot;
    }

    public void setHot(Boolean hot) {
        isHot = hot;
    }

    public String getGallery() {
        return gallery;
    }

    public void setGallery(String gallery) {
        this.gallery = gallery;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}