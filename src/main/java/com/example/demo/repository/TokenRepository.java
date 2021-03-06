package com.example.demo.repository;

import com.example.demo.entity.Account;
import com.example.demo.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token,Long> {

    Optional<Account> findByAccount_Login(String login);
    Token findByValue(String value);



}
