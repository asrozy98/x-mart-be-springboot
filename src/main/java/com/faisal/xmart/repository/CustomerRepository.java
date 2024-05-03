package com.faisal.xmart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faisal.xmart.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer> findByQrCode(String qrCode);
}
