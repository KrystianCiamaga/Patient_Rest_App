package com.example.demo.controller;


import com.example.demo.dto.AccountDto;
import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/accounts")
public class RegisterController {


    private AccountService accountService;
    private AccountRepository accountRepository;

    public RegisterController(AccountService accountService, AccountRepository accountRepository) {
        this.accountService = accountService;
        this.accountRepository = accountRepository;
    }


    @PostMapping("/register")
    public String register(@RequestBody AccountDto accountDto) {

        Account account = accountRepository.findByLogin(accountDto.getLogin());

        if (account == null) {
            Long a = accountService.addAccount(accountDto);
            return "Added correctly";
        }

        return "Account already exist";
    }


    @GetMapping("/{id}")
    public AccountDto getById(@PathVariable Long id) {

        return accountService.findById(id);

    }

    @GetMapping("/all")
    public List<AccountDto> getAll(){

        return accountService.findAll();

    }


}
