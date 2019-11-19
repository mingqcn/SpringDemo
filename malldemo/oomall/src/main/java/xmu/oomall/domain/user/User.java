package xmu.oomall.domain.user;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @Author: Ming Qiu
 * @Description:用户信息
 * @Date: Created in 13:27 2019/11/5
 * @Modified By:
 **/
public class User {

    private Integer id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 0：男， 1：女
     */
    private Integer gender;
    /**
     * 生日
     */
    private LocalDateTime birthDay;
    /**
     * 最后一次登录时间
     */
    private LocalDateTime lastLoginTime;
    /**
     * 最后一次登录IP
     */
    private String lastLoginIP;
    /**
     * 用户级别
     */
    private Short userLevel;
    /**
     * 用户积分
     */
    private Integer credits;
    /**
     * 用户头像图片
     */
    private String avatar;
    /**
     * 微信Open ID
     */
    private String wxOpenID;
    /**
     * 微信会话Key
     */
    private String sessionKey;
    /**
     * 地址簿
     */
    private List<Address> address;

    private LocalDateTime addTime;
    private LocalDateTime updateTime;
    private Boolean deleted;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", birthDay=" + birthDay +
                ", lastLoginTime=" + lastLoginTime +
                ", lastLoginIP='" + lastLoginIP + '\'' +
                ", userLevel=" + userLevel +
                ", credits=" + credits +
                ", avatar='" + avatar + '\'' +
                ", wxOpenID='" + wxOpenID + '\'' +
                ", sessionKey='" + sessionKey + '\'' +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
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
        User user = (User) o;
        return getId().equals(user.getId());
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public LocalDateTime getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDateTime birthDay) {
        this.birthDay = birthDay;
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIP() {
        return lastLoginIP;
    }

    public void setLastLoginIP(String lastLoginIP) {
        this.lastLoginIP = lastLoginIP;
    }

    public Short getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Short userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getWxOpenID() {
        return wxOpenID;
    }

    public void setWxOpenID(String wxOpenID) {
        this.wxOpenID = wxOpenID;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
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

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
}
