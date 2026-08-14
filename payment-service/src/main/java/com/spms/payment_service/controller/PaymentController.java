package com.spms.payment_service.controller;

import com.spms.payment_service.dto.PaymentRequestDTO;
import com.spms.payment_service.dto.PaymentResponseDTO;
import com.spms.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public ResponseEntity<PaymentResponseDTO> processPayment(@RequestBody PaymentRequestDTO requestDTO) {
        PaymentResponseDTO response = paymentService.processPayment(requestDTO);
        if ("FAILED".equals(response.getPaymentStatus())) {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{receiptNumber}")
    public ResponseEntity<PaymentResponseDTO> getReceipt(@PathVariable String receiptNumber) {
        return ResponseEntity.ok(paymentService.getPaymentReceipt(receiptNumber));
    }
}
