package pojo;

import java.util.Date;
import java.util.List;

public class Order {
    private Integer id;

    private Integer userId;

    private String loginName;

    private Integer addressId;

    private Date createTime;

    private Float cost;

    private Integer state;

    private String serialNumber;

    private List<Order_Detail> detailList;

    private User user;

    private User_Address user_Address;

    public User_Address getUser_Address() {
        return user_Address;
    }

    public void setUser_Address(User_Address user_Address) {
        this.user_Address = user_Address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<Order_Detail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<Order_Detail> detailList) {
        this.detailList = detailList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
}