package com.faisal.xmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.faisal.xmart.dto.response.DefaultDataResponse;
import com.faisal.xmart.dto.response.DefaultResponse;
import com.faisal.xmart.model.Transaksi;
import com.faisal.xmart.repository.TransaksiRepository;

@Service
public class TransaksiService {
    @Autowired
    private TransaksiRepository transaksiRepository;

    public ResponseEntity<DefaultDataResponse<Transaksi>> findById(String id) {
        Transaksi transaksi = transaksiRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Transaksi dengan id " + id + " tidak ditemukan"));
        if (transaksi == null) {
            throw new IllegalArgumentException("Transaksi tidak ditemukan");
        }

        DefaultDataResponse response = DefaultDataResponse.<Transaksi>builder()
                .status("Success")
                .data(transaksi)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<DefaultDataResponse<List<Transaksi>>> findAll() {
        List<Transaksi> allTransaksi = transaksiRepository.findAll();
        DefaultDataResponse response = DefaultDataResponse.<List<Transaksi>>builder()
                .status("Success")
                .data(allTransaksi)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<DefaultResponse> create(Transaksi transaksi) {
        transaksiRepository.save(transaksi);
        DefaultResponse response = DefaultResponse.builder()
                .status("Success")
                .message("Transaksi Disimpan")
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
