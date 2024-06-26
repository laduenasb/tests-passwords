package org.example.payments;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentProcessorTest {
  @Test
  public void payment_is_correct() {
    PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);
    Mockito.when(paymentGateway.requestPayment(Mockito.any()))
        .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

    PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);

    assertTrue(paymentProcessor.makePayment(1000));
  }

  @Test
  public void payment_is_incorrect() {
    PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);
    Mockito.when(paymentGateway.requestPayment(Mockito.any()))
        .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

    PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);

    assertFalse(paymentProcessor.makePayment(1000));
  }
}