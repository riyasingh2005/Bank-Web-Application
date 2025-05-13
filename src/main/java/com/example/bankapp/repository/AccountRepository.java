package com.example.bankapp.repository;

import com.example.bankapp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepostory extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
}
