package com.faisal.xmart.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.faisal.xmart.dto.response.DefaultDataResponse;
import com.faisal.xmart.dto.response.DefaultResponse;
import com.faisal.xmart.model.Customer;
import com.faisal.xmart.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<DefaultDataResponse<Customer>> findByQrCode(String qrCode) {
        Customer customer = customerRepository.findByQrCode(qrCode)
                .orElseThrow(() -> new IllegalArgumentException("Customer dengan QRCode tersebut tidak ditemukan"));
        if (customer == null) {
            throw new IllegalArgumentException("Customer tidak ditemukan");
        }

        DefaultDataResponse response = DefaultDataResponse.<Customer>builder()
                .status("Success")
                .data(customer)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<DefaultDataResponse<List<Customer>>> findAll() {
        List<Customer> allCustomer = customerRepository.findAll();
        DefaultDataResponse response = DefaultDataResponse.<List<Customer>>builder()
                .status("Success")
                .data(allCustomer)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<DefaultResponse> create(Customer customer) {
        customer.setQrCode(UUID.randomUUID().toString());
        customerRepository.save(customer);
        DefaultResponse response = DefaultResponse.builder()
                .status("Success")
                .message("Customer Disimpan")
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
