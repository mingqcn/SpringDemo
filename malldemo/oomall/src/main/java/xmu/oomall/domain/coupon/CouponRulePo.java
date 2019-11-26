package xmu.oomall.domain.coupon;

import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @Author: Ming Qiu
 * @Description: CouponRule的PO对象
 * @Date: Created in 11:28 2019/11/14
 * @Modified By:
 **/
@Alias("couponRulePo")
public class CouponRulePo {
    private Integer id;
    /**
     * 优惠卷名称
     */
    private String name = "";
    /**
     * 优惠卷编号起始字母
     */
    private String brief = "";
    /**
     * 优惠卷图片url
     */
    private String picUrl = "";
    /**
     *优惠卷描述
     */
    private String descr = "";
    /**
     * 优惠卷开始领取时间，默认设为2019年10月1日
     */
    private LocalDateTime beginTime;
    /**
     * 优惠卷有效时间，单位天，
     * 负数表示绝对时间，即优惠卷开始领取时间后的天数，
     * 正数表示相对时间，即用户实际领取优惠卷后的天数
     */
    private Integer validPeriod;
    /**
     *优惠卷剩余数目
     */
    private Integer quantity;
    /**
     * 适用商品的id 长度小于65534
     * { gIDs：[xxx,xxx,xxx,xxx,xxx]}
     */
    private String goodsIds = "";
    /**
     * 折扣策略
     * { name：“XXX”, obj:{XXX}}
     */
    private String strategy = "";

    private LocalDateTime addTime;
    private LocalDateTime updateTime;
    private Boolean beDeleted = false;


    public CouponRulePo() {
        this.addTime=LocalDateTime.now();

    }

    /****************************************************
     * 生成代码
     ****************************************************/

    @Override
    public String toString() {
        return "CouponRulePo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brief='" + brief + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", desc='" + descr + '\'' +
                ", beginTime=" + beginTime +
                ", validPeriod=" + validPeriod +
                ", quantity=" + quantity +
                ", goodsIds='" + goodsIds + '\'' +
                ", strategy='" + strategy + '\'' +
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
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        CouponRulePo that = (CouponRulePo) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public Integer getValidPeriod() {
        return validPeriod;
    }

    public void setValidPeriod(Integer validPeriod) {
        this.validPeriod = validPeriod;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getGoodsIds() {
        return goodsIds;
    }

    public void setGoodsIds(String goodsIds) {
        this.goodsIds = goodsIds;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
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
