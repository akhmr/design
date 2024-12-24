package com.design.ratelimit;

import java.time.LocalDateTime;

public class TokenBucket {

    private String userId;

    private Integer tokenAllowed;

    private LocalDateTime updatedTime;

    public TokenBucket(String userId, int tokenAllowed) {
        this.userId =userId;
        this.tokenAllowed=tokenAllowed;
        updatedTime = LocalDateTime.now();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getTokenAllowed() {
        return tokenAllowed;
    }

    public void setTokenAllowed(Integer tokenAllowed) {
        this.tokenAllowed = tokenAllowed;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }
}
