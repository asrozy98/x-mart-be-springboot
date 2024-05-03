package com.faisal.xmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faisal.xmart.model.Transaksi;

public interface TransaksiRepository extends JpaRepository<Transaksi, String> {

}
