package com.faisal.xmart.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "qr_code")
    private String qrCode;
    private String nama;
    private String wallet;

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
}
