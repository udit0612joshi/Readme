package com.example.demo.model;

public class JwtUser {
    private String userName;
    private String tenantName;
    private String password;
    private String role;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public String getId() {
        return password;
    }

    public String getRole() {
        return role;
    }

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
}
