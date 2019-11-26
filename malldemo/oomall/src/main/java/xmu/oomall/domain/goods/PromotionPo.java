package xmu.oomall.domain.goods;

import xmu.oomall.util.Common;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 商品的优惠活动，如团购，预售等
 *
 * @author: Ming Qiu
 * @date: Created in 14:16 2019/11/26
 **/
public class PromotionPo {

    private Integer id;

    /**
     * 活动开始时间
     */
    private LocalDateTime beginTime= Common.DEFAULT_TIME;
    /**
     * 活动开始时间
     */
    private LocalDateTime endTime = Common.DEFAULT_TIME;
    /**
     * 活动序号
     */
    private String promotionSn ="";
    /**
     * 活动描述
     */
    private String descr="";

    /**
     * 付款策略
     */
    private String payStrategy;

    private LocalDateTime addTime;
    private LocalDateTime updateTime = Common.DEFAULT_TIME;
    private Boolean beDeleted = false;

    /****************************************************
     * 生成代码
     ****************************************************/

    @Override
    public String toString() {
        return "PromotionPo{" +
                "id=" + id +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", promotionSn='" + promotionSn + '\'' +
                ", descr='" + descr + '\'' +
                ", payStrategy='" + payStrategy + '\'' +
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
        PromotionPo that = (PromotionPo) o;
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

    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getPromotionSn() {
        return promotionSn;
    }

    public void setPromotionSn(String promotionSn) {
        this.promotionSn = promotionSn;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getPayStrategy() {
        return payStrategy;
    }

    public void setPayStrategy(String payStrategy) {
        this.payStrategy = payStrategy;
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
