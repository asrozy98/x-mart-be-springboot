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
import com.faisal.xmart.model.Customer;
import com.faisal.xmart.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
    public ResponseEntity<DefaultDataResponse<List<Customer>>> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/customer/{qrCode}")
    public ResponseEntity<DefaultDataResponse<Customer>> findByQrCode(@PathVariable("qrCode") String qrCode) {
        return customerService.findByQrCode(qrCode);
    }

    @PostMapping("/customer")
    public ResponseEntity<DefaultResponse> create(@RequestBody Customer customer) {
        return customerService.create(customer);
    }
}
