package com.spms.payment_service.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PaymentResponseDTO {
    private String receiptNumber;
    private String paymentStatus;
    private Double amount;
    private String bookingId;
    private LocalDateTime timestamp;
    private String message;
}
