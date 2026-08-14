package com.spms.payment_service.dto;

import lombok.Data;

@Data
public class PaymentRequestDTO {
    private String userId;
    private String bookingId;
    private Double amount;
    private String cardNumber;
    private String expiryDate;
    private String cvv;
}
