package com.example.bankapp.service;

import com.example.bankapp.model.Account;
import com.example.bankapp.model.Transaction;
import com.example.bankapp.repository.AccountRepostory;
import com.example.bankapp.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private AccountRepostory accountRepostory;

    @Autowired
    private TransactionRepository transactionRepository;

    public Account findAccountByUsername(String username){
        return accountRepostory.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Account not found!"));
    }

    public Account registerAccount(String username, String password){
        if (accountRepostory.findByUsername(username).isPresent()){
            throw new RuntimeException("Username already exists.");
        }

        Account account = new Account();
        account.setUsername(username);
        account.setPassword(passwordEncoder.encode(password));
        account.setBalance(BigDecimal.ZERO);
        return accountRepostory.save(account);
    }

    public void deposit(Account account, BigDecimal amount){
        account.setBalance(account.getBalance().add(amount));
        accountRepostory.save(account);

        Transaction transaction = new Transaction(
                amount,
                "Deposit",
                LocalDateTime.now(),
                account
        );
        transactionRepository.save(transaction);
    }

    public void withdraw(Account account, BigDecimal amount){
        if (account.getBalance().compareTo(amount) < 0){
            throw new RuntimeException("Insufficient funds");
        }
        account.setBalance(account.getBalance().subtract(amount));
        accountRepostory.save(account);

        Transaction transaction = new Transaction(
                amount,
                "Withdrawal",
                LocalDateTime.now(),
                account
        );
        transactionRepository.save(transaction);
    }


}
