package xmu.oomall.domain;

import ch.qos.logback.classic.pattern.ClassOfCallerConverter;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @Author: Ming Qiu
 * @Description:团购活动
 * 该对象不可以删除
 * @Date: Created in 15:17 2019/11/5
 * @Modified By:
 **/
public class GroupOnRule{
    private Integer id;
    /**
     * 团购活动结束时间
     */

    private LocalDateTime endTime;

    private LocalDateTime addTime;
    private LocalDateTime updateTime;
    private Boolean beDeleted = false;

    /****************************************************
     * 生成代码
     ****************************************************/

    @Override
    public String toString() {
        return "GroupOnRule{" +
                "id=" + id +
                ", endTime=" + endTime +
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
        GroupOnRule that = (GroupOnRule) o;
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

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
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
