package com.where.where_user_management.model;

import org.hibernate.validator.constraints.NotEmpty;

public class DeliveryAddress {
    private String id;
    
   
    private String area;
    
    @NotEmpty(message="街道地址不能为空！")
    private String streetAddress;
    
    @NotEmpty(message="收件人不能为空！")
    private String consigneeName;
    
    @NotEmpty(message="手机号不能为空！")
    private String phone;
    
  
    private Integer usersId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress == null ? null : streetAddress.trim();
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName == null ? null : consigneeName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

	@Override
	public String toString() {
		return "DeliveryAddress [id=" + id + ", area=" + area + ", streetAddress=" + streetAddress + ", consigneeName="
				+ consigneeName + ", phone=" + phone + ", usersId=" + usersId + "]";
	}
    
    
    
}