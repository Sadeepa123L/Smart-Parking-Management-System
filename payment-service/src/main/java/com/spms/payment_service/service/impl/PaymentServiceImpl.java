package com.spms.payment_service.service.impl;

import com.spms.payment_service.dto.PaymentRequestDTO;
import com.spms.payment_service.dto.PaymentResponseDTO;
import com.spms.payment_service.entity.Payment;
import com.spms.payment_service.repository.PaymentRepository;
import com.spms.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public PaymentResponseDTO processPayment(PaymentRequestDTO requestDTO) {
        PaymentResponseDTO responseDTO = new PaymentResponseDTO();
        responseDTO.setAmount(requestDTO.getAmount());
        responseDTO.setBookingId(requestDTO.getBookingId());
        responseDTO.setTimestamp(LocalDateTime.now());

        // Validate mock card data
        if (requestDTO.getCardNumber() == null || requestDTO.getCardNumber().length() != 16) {
            responseDTO.setPaymentStatus("FAILED");
            responseDTO.setMessage("Invalid card number. Must be 16 digits.");
            return responseDTO;
        }

        // Simulate transaction processing (Mock success for demonstration)
        String status = "SUCCESS";
        String receiptNumber = UUID.randomUUID().toString();

        Payment payment = new Payment();
        payment.setUserId(requestDTO.getUserId());
        payment.setBookingId(requestDTO.getBookingId());
        payment.setAmount(requestDTO.getAmount());
        payment.setPaymentStatus(status);
        payment.setReceiptNumber(receiptNumber);
        payment.setTimestamp(responseDTO.getTimestamp());

        paymentRepository.save(payment);

        responseDTO.setPaymentStatus(status);
        responseDTO.setReceiptNumber(receiptNumber);
        responseDTO.setMessage("Payment processed successfully.");

        return responseDTO;
    }

    @Override
    public PaymentResponseDTO getPaymentReceipt(String receiptNumber) {
        Payment payment = paymentRepository.findByReceiptNumber(receiptNumber)
                .orElseThrow(() -> new RuntimeException("Receipt not found"));

        PaymentResponseDTO responseDTO = new PaymentResponseDTO();
        responseDTO.setReceiptNumber(payment.getReceiptNumber());
        responseDTO.setPaymentStatus(payment.getPaymentStatus());
        responseDTO.setAmount(payment.getAmount());
        responseDTO.setBookingId(payment.getBookingId());
        responseDTO.setTimestamp(payment.getTimestamp());
        responseDTO.setMessage("Receipt fetched successfully.");

        return responseDTO;
    }
}
