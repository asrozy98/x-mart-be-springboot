package com.faisal.xmart.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.faisal.xmart.dto.response.DefaultDataResponse;
import com.faisal.xmart.dto.response.DefaultResponse;
import com.faisal.xmart.model.Barang;
import com.faisal.xmart.repository.BarangRepository;

@Service
public class BarangService {
    @Autowired
    private BarangRepository barangRepository;

    public ResponseEntity<DefaultDataResponse<Barang>> findById(String id) {
        Barang barang = barangRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Barang dengan RFID " + id + " tidak ditemukan"));
        if (barang == null) {
            throw new IllegalArgumentException("Barang tidak ditemukan");
        }

        DefaultDataResponse response = DefaultDataResponse.<Barang>builder()
                .status("Success")
                .data(barang)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<DefaultDataResponse<List<Barang>>> findAll() {
        List<Barang> allBarang = barangRepository.findAll();

        DefaultDataResponse response = DefaultDataResponse.<List<Barang>>builder()
                .status("Success")
                .data(allBarang)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<DefaultResponse> create(Barang barang) {
        barang.setRfid(UUID.randomUUID().toString());
        barangRepository.save(barang);

        DefaultResponse response = DefaultResponse.builder()
                .status("Success")
                .message("Barang Disimpan")
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
