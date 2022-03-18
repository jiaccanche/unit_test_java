package com.course.testing.payments;

public class PaymentProcessor {
    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway gateway){
        paymentGateway = gateway;
    }

    public boolean makePayment(double amount){
        PaymentResponse response = paymentGateway.requestPayment( new PaymentRequest(amount) );
        return response.getStatus().equals(PaymentResponse.PaymentStatus.OK);
    }
}
