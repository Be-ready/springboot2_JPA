package com.example.springboo2_jpa.repository;

import com.example.springboo2_jpa.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
