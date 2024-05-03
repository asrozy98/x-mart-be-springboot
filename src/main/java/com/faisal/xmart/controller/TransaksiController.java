package com.faisal.xmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faisal.xmart.dto.response.DefaultDataResponse;
import com.faisal.xmart.dto.response.DefaultResponse;
import com.faisal.xmart.model.Transaksi;
import com.faisal.xmart.service.TransaksiService;

@RestController
@RequestMapping("/api")
public class TransaksiController {
    @Autowired
    private TransaksiService transaksiService;

    @GetMapping("/transaksi")
    public ResponseEntity<DefaultDataResponse<List<Transaksi>>> findAll() {
        return transaksiService.findAll();
    }

    @GetMapping("/transaksi/{id}")
    public ResponseEntity<DefaultDataResponse<Transaksi>> findById(@PathVariable("id") String id) {
        return transaksiService.findById(id);
    }

    @PostMapping("/transaksi")
    public ResponseEntity<DefaultResponse> create(@RequestBody Transaksi transaksi) {
        return transaksiService.create(transaksi);
    }
}
