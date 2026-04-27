package com.example.kfcglobaloperationsapp.Uzair_2521139.Model;

import java.time.LocalDate;

public class Coupon {
    private String couponCode;
    private Double discountPercent;
    private boolean isActive;
//    private LocalDate expiryDate;


    public Coupon(String couponCode, Double discountPercent, boolean isActive) {
        this.couponCode = couponCode;
        this.discountPercent = discountPercent;
        this.isActive = isActive;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public Double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
