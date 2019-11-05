package xmu.oomall.domain;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @Author: Ming Qiu$
 * @Description: 付款记录
 * @Date: Created in 13:12 2019/11/5
 * @Modified By:
 **/
public class Payment {

    private Integer id;
    private String paySN; //付款编号
    private LocalDateTime payTime; //付款时间
    private Short payChannel; //付款渠道，微信，银行等等
    private LocalDateTime beginTime; //付款的开始时间 （在开始时间和结束时间之间才可以付款）
    private LocalDateTime endTime; //付款的结束时间
    private Short status; //付款状态，待付款，已付款，未付款（规定时间内未付款）
    private LocalDateTime addTime;
    private LocalDateTime updateTime;

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", paySN='" + paySN + '\'' +
                ", payTime=" + payTime +
                ", payChannel=" + payChannel +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", status=" + status +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return getId().equals(payment.getId());
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

    public String getPaySN() {
        return paySN;
    }

    public void setPaySN(String paySN) {
        this.paySN = paySN;
    }

    public LocalDateTime getPayTime() {
        return payTime;
    }

    public void setPayTime(LocalDateTime payTime) {
        this.payTime = payTime;
    }

    public Short getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(Short payChannel) {
        this.payChannel = payChannel;
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

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
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
