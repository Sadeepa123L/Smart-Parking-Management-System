package com.spms.payment_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String bookingId;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private String paymentStatus;

    @Column(unique = true, nullable = false)
    private String receiptNumber;

    @Column(nullable = false)
    private LocalDateTime timestamp;
}
