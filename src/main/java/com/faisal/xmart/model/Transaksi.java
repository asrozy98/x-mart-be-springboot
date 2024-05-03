package com.faisal.xmart.model;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "transaksi")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String qrCode;
    private String rfid;
    private BigDecimal hargaSatuan;
    private Integer jumlah;
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggal;

}
