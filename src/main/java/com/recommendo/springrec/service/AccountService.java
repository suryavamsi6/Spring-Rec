package com.recommendo.springrec.service;

import com.recommendo.springrec.entity.Account;
import com.recommendo.springrec.repository.AccountRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public void createAccount(Account account) {
        account.password = passwordEncoder.encode(account.password);
        accountRepository.save(account);
    }

    public void updateAccount(Account account) {
        account.password = passwordEncoder.encode(account.password);
        accountRepository.save(account);
    }

    public void deleteAccount(Account account) {
        accountRepository.delete(account);
    }

    public Account signIn(String username, String password) {
        Account existingAccount = accountRepository.getAccountByUsername(username);
        if (existingAccount != null && passwordEncoder.matches(password, existingAccount.password)) {
            return existingAccount;
        } else {
            return null;
        }
    }
}
