package com.course.testing.payments;

public class PaymentRequest {
    private double amount;

    public PaymentRequest(double value){
        amount = value;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
