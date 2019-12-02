package com.xinghuo.pojo;

public class TbUser {
    /**人员id**/
    private Integer userId;
    /**人员姓名**/
    private String userName;
    /**密码**/
    private String password;
    /**权限**/
    private Integer role;

    private String loginStatus;

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }




    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}