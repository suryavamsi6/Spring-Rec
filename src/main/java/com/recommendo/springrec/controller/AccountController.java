package com.recommendo.springrec.controller;

import com.recommendo.springrec.entity.Account;
import com.recommendo.springrec.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/health-check")
    public void healthCheck() {
        System.out.println("Health check");
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody Account account) {
        accountService.createAccount(account);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<Account> signIn(@RequestBody Account account) {
        return ResponseEntity.ok().body(accountService.signIn(account.username, account.password));
    }
}
