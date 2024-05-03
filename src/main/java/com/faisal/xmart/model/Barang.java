package com.faisal.xmart.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "barang")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
public class Barang {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String rfid;
    private String namaBarang;
    private String hargaSatuan;

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }
}
