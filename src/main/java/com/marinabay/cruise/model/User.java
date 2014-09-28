package com.marinabay.cruise.model;

import com.marinabay.cruise.constant.ROLE;
import com.marinabay.cruise.constant.USERTYPE;

/**
 * User: son.nguyen
 * Date: 9/21/14
 * Time: 9:19 PM
 */
public class User extends GenericModel{

    private String userName;
    private String email;
    private String password;
    private ROLE role;
    private String mobile;
    private String taxiLicense;
    private String address;
    private USERTYPE userType;
    private Long userGroupId;

    //custom field
    private String userGroupView;

    public User() {
    }

    public String getUserGroupView() {
        return userGroupView;
    }

    public void setUserGroupView(String userGroupView) {
        this.userGroupView = userGroupView;
    }

    public USERTYPE getUserType() {
        return userType;
    }

    public void setUserType(USERTYPE userType) {
        this.userType = userType;
    }

    public Long getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(Long userGroupId) {
        this.userGroupId = userGroupId;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTaxiLicense() {
        return taxiLicense;
    }

    public void setTaxiLicense(String taxiLicense) {
        this.taxiLicense = taxiLicense;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
