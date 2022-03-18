package com.course.testing.payments;

public interface PaymentGateway {
    PaymentResponse requestPayment( PaymentRequest request);
}
