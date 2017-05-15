package com.where.where_user_management.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Business implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message="用户名不能为空！！")
	@Size(min=0,max=10,message="名称不能超过10个字符")
    private String username;

    private String password;

    private String salt;

    private Short islocked;
    
    private Date birthday;
    
    private String birthdayStr;

    private Short sex;

    private Date registrationTime;

    private String phone;
    @Email(message="邮箱格式不正确！！")
    private String email;
    @Size(min=0,max=50,message="字数不能超过50！！")
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getCredentialsSalt() {
        return username+salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Short getIslocked() {
        return islocked;
    }

    public void setIslocked(Short islocked) {
        this.islocked = islocked;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    
    public String getBirthdayStr() {
		return birthdayStr;
	}

	public void setBirthdayStr(String birthdayStr) {
		this.birthdayStr = birthdayStr;
	}

	public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    
	@Override
	public String toString() {
		return "Business [id=" + id + ", username=" + username + ", password=" + password + ", salt=" + salt
				+ ", islocked=" + islocked + ", birthday=" + birthday + ", sex=" + sex + ", registrationTime="
				+ registrationTime + ", phone=" + phone + ", email=" + email + ", address=" + address + "]";
	}
    
    
}