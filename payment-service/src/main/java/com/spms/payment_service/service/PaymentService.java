package com.spms.payment_service.service;

import com.spms.payment_service.dto.PaymentRequestDTO;
import com.spms.payment_service.dto.PaymentResponseDTO;

public interface PaymentService {
    PaymentResponseDTO processPayment(PaymentRequestDTO paymentRequestDTO);
    PaymentResponseDTO getPaymentReceipt(String receiptNumber);
}
