package com.bsys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bsys.models.Transactions;

public interface TransRepo extends JpaRepository<Transactions, Integer> {

}
