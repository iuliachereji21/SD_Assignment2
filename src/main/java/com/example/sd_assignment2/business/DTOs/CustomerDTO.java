package com.example.sd_assignment2.business.DTOs;

public class CustomerDTO {
    private long userId;
    private long customerId;

    public CustomerDTO(long userId, long customerId) {
        this.userId = userId;
        this.customerId = customerId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
