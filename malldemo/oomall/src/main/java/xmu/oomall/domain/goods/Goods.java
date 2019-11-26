package xmu.oomall.domain.goods;

import org.apache.ibatis.type.Alias;
import xmu.oomall.util.Common;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * 商品信息
 * 该对象不可以删除
 * @author Ming Qiu
 */
@Alias("goods")
public class Goods {
    private Integer id;
    /**
     * 商品编码
     */
    private String goodsSn;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 简称
     */
    private String shortName;
    /**
     * 英文名称
     */
    private String englishName;
    /**
     * 条码
     */
    private String barCode;
    /**
     * 库存单位
     */
    private String stockUnit;
    /**
     * 长 单位mm
     */
    private Integer length;
    /**
     * 宽 单位mm
     */
    private Integer width;
    /**
     * 高 单位mm
     */
    private Integer height;
    /**
     * 毛重 单位克
     */
    private Integer grossWeight;
    /**
     * 净重 单位克
     */
    private Integer netWeight;
    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * 商品状态，下架，上架，
     */
    private Integer status;
    /**
     * 是否人气推荐，如果设置则可以在人气推荐页面展示
     */
    private Boolean beHot = false;
    /**
     * 是否新品首发，如果设置则可以在新品首发页面展示
     */
    private Boolean beNew = false;
    /**
     * 商品宣传图片列表，采用JSON数组格式
     */
    private String gallery;
    /**
     * 商品简介
     */
    private String brief;
    /**
     * 商品页面商品图片
     */
    private String picUrl;
    /**
     * 商品分享朋友圈图片
     */
    private String shareUrl;
    /**
     * 商品的不同规格货品
     */
    private List<Product> products;
    /**
     * 商品的促销活动
     */
    private Promotion promotion = null;

    private LocalDateTime addTime;
    private LocalDateTime updateTime = Common.DEFAULT_TIME;
    private Boolean beDeleted = false;


    public static Goods ALL_GOODS = new Goods(0);

    /**
     * 用id构造Goods
     * @param id
     */
    public Goods(Integer id) {
        this.id = id;
        this.setAddTime(LocalDateTime.now());
    }

    public Goods(){
    }



    /****************************************************
     * 生成代码
     ****************************************************/

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsSn='" + goodsSn + '\'' +
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
                ", categoryName='" + categoryName + '\'' +
                ", brandName='" + brandName + '\'' +
                ", status=" + status +
                ", beHot=" + beHot +
                ", beNew=" + beNew +
                ", gallery='" + gallery + '\'' +
                ", brief='" + brief + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", shareUrl='" + shareUrl + '\'' +
                ", products=" + products +
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

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
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
        return beNew;
    }

    public void setNew(Boolean aNew) {
        beNew = aNew;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getHot() {
        return beHot;
    }

    public void setHot(Boolean hot) {
        beHot = hot;
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

    public Boolean getBeHot() {
        return beHot;
    }

    public void setBeHot(Boolean beHot) {
        this.beHot = beHot;
    }

    public Boolean getBeNew() {
        return beNew;
    }

    public void setBeNew(Boolean beNew) {
        this.beNew = beNew;
    }

    public Boolean getBeDeleted() {
        return beDeleted;
    }

    public void setBeDeleted(Boolean beDeleted) {
        this.beDeleted = beDeleted;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }
}