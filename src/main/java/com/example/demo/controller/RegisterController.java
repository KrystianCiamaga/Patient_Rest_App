package com.example.demo.controller;


import com.example.demo.dto.AccountDto;
import com.example.demo.email.MailService;
import com.example.demo.entity.Account;
import com.example.demo.entity.Token;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.TokenRepository;
import com.example.demo.service.AccountService;

import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class RegisterController {


    private AccountService accountService;
    private AccountRepository accountRepository;
    private TokenRepository tokenRepository;
    private MailService mailService;

    public RegisterController(AccountService accountService, AccountRepository accountRepository, TokenRepository tokenRepository, MailService mailService) {
        this.accountService = accountService;
        this.accountRepository = accountRepository;
        this.tokenRepository = tokenRepository;
        this.mailService = mailService;
    }

    @PostMapping("/register")
    public String register(@RequestBody AccountDto accountDto) throws MalformedURLException, MessagingException {

        Account account = accountRepository.findByLogin(accountDto.getLogin());

        if (account == null) {
            accountService.addAccount(accountDto);

            return "Added correctly";
        }

        return "Account already exist";
    }


    @GetMapping("/token")
    public void checkToken(@RequestParam String value){
        Token token=tokenRepository.findByValue(value);
        Account account=token.getAccount();
        account.setActive(true);
        accountRepository.save(account);
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
