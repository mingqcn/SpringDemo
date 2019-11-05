package xmu.oomall.domain;

import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @Author: Ming Qiu
 * @Description: 优惠卷
 * @Date: Created in 13:47 2019/11/5
 * @Modified By:
 **/
public class Coupon {
    private Integer id;
    private String name; //优惠卷名称
    private String brief; //优惠卷编号起始字母
    private String pic; //优惠卷图片
    private String desc; //优惠卷描述
    private LocalDateTime beginTime; //优惠卷开始领取时间，默认设为2019年10月1日
    private Integer validPeriod; //优惠卷有效时间，单位天，负数表示绝对时间，即优惠卷开始领取时间后的天数，正数表示相对时间，即用户实际领取优惠卷后的天数
    private Integer number; //优惠卷剩余数目
    private String picUrl; //优惠卷图片
    private List<Goods> goods; //适用商品， 在数据库中用JSON数组存放id
    private User owner; //优惠卷的主人
    private LocalDateTime addTime;
    private LocalDateTime updateTime;
    private Boolean deleted;

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brief='" + brief + '\'' +
                ", pic='" + pic + '\'' +
                ", desc='" + desc + '\'' +
                ", beginTime=" + beginTime +
                ", validPeriod=" + validPeriod +
                ", number=" + number +
                ", picUrl='" + picUrl + '\'' +
                ", goods=" + goods +
                ", owner=" + owner +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coupon coupon = (Coupon) o;
        return getId().equals(coupon.getId());
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
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
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Integer getValidPeriod() {
        return validPeriod;
    }

    public void setValidPeriod(Integer validPeriod) {
        this.validPeriod = validPeriod;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
