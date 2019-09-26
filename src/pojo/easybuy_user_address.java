package pojo;

import java.util.Date;

/**
 * 用户地址表
 */
public class easybuy_user_address {
    private Integer id;   //编号  主键ID

    private Integer userId;  //用户ID

    private String address; //用户地址

    private Date createTime;  //创建时间

    private Integer isDefault;  //是否默认地址  状态码1-->是，0-->否

    private String remark;  //备注

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}