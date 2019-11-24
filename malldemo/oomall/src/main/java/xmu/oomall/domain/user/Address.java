package xmu.oomall.domain.user;

import java.util.Objects;

/**
 * @Author: Ming Qiu
 * @Description:地址 本对象以JSON方式存数据库
 * @Date: Created in 14:49 2019/11/5
 * @Modified By:
 **/
public class Address {
    private Integer id;
    /**
     * 收件人姓名
     */
    private String name = "";
    /**
     * 省份
     */
    private String province  = "";
    /**
     * 城市
     */
    private String city  = "";
    /**
     * 县区
     */
    private String county  = "";
    /**
     * 地址详情
     */
    private String addressDetail  = "";
    /**
     * 联系电话
     */
    private String tel  = "";
    /**
     * 是否是默认地址
     */
    private boolean beDefault = false;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", address_detail='" + addressDetail + '\'' +
                ", tel='" + tel + '\'' +
                ", beDefault=" + beDefault +
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
        Address address = (Address) o;
        return getId().equals(address.getId());
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public boolean isBeDefault() {
        return beDefault;
    }

    public void setBeDefault(boolean beDefault) {
        this.beDefault = beDefault;
    }
}
