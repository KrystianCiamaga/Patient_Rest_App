package com.example.demo.service;


import com.example.demo.dto.AccountDto;
import com.example.demo.entity.Account;

import javax.mail.MessagingException;
import java.util.List;

public interface AccountService {


    List<AccountDto> findAll();

    AccountDto findById(Long id);

    Long addAccount(AccountDto accountDto) throws MessagingException;





}
