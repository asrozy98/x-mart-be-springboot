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
import com.faisal.xmart.model.Barang;
import com.faisal.xmart.service.BarangService;

@RestController
@RequestMapping("/api")
public class BarangController {
    @Autowired
    private BarangService barangService;

    @GetMapping("/barang")
    public ResponseEntity<DefaultDataResponse<List<Barang>>> findAll() {
        return barangService.findAll();
    }

    @GetMapping("/barang/{id}")
    public ResponseEntity<DefaultDataResponse<Barang>> findById(@PathVariable("id") String id) {
        return barangService.findById(id);
    }

    @PostMapping("/barang")
    public ResponseEntity<DefaultResponse> create(@RequestBody Barang barang) {
        return barangService.create(barang);
    }
}
