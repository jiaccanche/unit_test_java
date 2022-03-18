package com.course.testing.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;

public class PaymentProcessorTest {
    private PaymentGateway gateway;
    private PaymentProcessor processor;

    @Before
    public void setup() {
        gateway = Mockito.mock(PaymentGateway.class);
        processor = new PaymentProcessor(gateway);
    }

    @Test
    public void payment_is_correct() {
        Mockito.when(gateway.requestPayment(any())).thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        boolean result = processor.makePayment(1000);
        assertTrue(result);
    }

    @Test
    public void payment_is_wrong() {
        Mockito.when(gateway.requestPayment(any())).thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        boolean result = processor.makePayment(1000);

        assertFalse(result);
    }
}