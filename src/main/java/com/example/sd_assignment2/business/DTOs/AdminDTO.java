package com.example.sd_assignment2.business.DTOs;

public class AdminDTO {
    private long user_id;
    private long admin_id;

    public AdminDTO(long user_id, long admin_id) {
        this.user_id = user_id;
        this.admin_id = admin_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(long admin_id) {
        this.admin_id = admin_id;
    }
}
