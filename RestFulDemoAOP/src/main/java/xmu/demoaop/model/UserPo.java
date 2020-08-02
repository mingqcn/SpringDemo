package xmu.demoaop.model;


import java.time.LocalDateTime;

/**
 * @auther mingqiu
 * @date 2020/6/26 下午3:02
 */

public class UserPo {

    private Integer id;
    private String userName;
    private String password;
    private String name;
    private String email;
    private Integer  userType;
    private Boolean forbid;
    private Boolean authorized;
    private String activCode;
    private LocalDateTime createDate;
    private LocalDateTime modiDate;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Boolean getForbid() {
        return forbid;
    }

    public void setForbid(Boolean forbid) {
        this.forbid = forbid;
    }

    public Boolean getAuthorized() {
        return authorized;
    }

    public void setAuthorized(Boolean authorized) {
        this.authorized = authorized;
    }

    public String getActivCode() {
        return activCode;
    }

    public void setActivCode(String activCode) {
        this.activCode = activCode;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getModiDate() {
        return modiDate;
    }

    public void setModiDate(LocalDateTime modiDate) {
        this.modiDate = modiDate;
    }
}
