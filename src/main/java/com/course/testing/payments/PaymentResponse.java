package com.course.testing.payments;

public class PaymentResponse {

    enum PaymentStatus {
        OK, ERROR
    }

    private PaymentStatus paymentStatus;

    public PaymentResponse(PaymentStatus status){
        paymentStatus = status;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentStatus getStatus() {
        return paymentStatus;
    }
}
