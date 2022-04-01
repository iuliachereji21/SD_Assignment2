package com.example.sd_assignment2.business.DTOs;

public class AdminDTO {
    private long userId;
    private long adminId;

    public AdminDTO(long userId, long adminId) {
        this.userId = userId;
        this.adminId = adminId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }
}
