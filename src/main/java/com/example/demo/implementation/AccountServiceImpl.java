package com.example.demo.implementation;

import com.example.demo.dto.AccountDto;
import com.example.demo.email.MailService;
import com.example.demo.entity.Account;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.TokenRepository;
import com.example.demo.service.AccountService;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {


    private AccountRepository accountRepository;
    private MailService mailService;
    private TokenRepository tokenRepository;

    public AccountServiceImpl(AccountRepository accountRepository, MailService mailService, TokenRepository tokenRepository) {
        this.accountRepository = accountRepository;
        this.mailService = mailService;
        this.tokenRepository = tokenRepository;
    }

    @Override
    public List<AccountDto> findAll() {

        List<Account> accountList=accountRepository.findAll();

        List<AccountDto> accountDtoList=accountList.stream()
                .map(AccountMapper::mapAccountToAccountDto)
                .collect(Collectors.toList());
        return accountDtoList;
    }

    @Override
    public AccountDto findById(Long id) {


        Optional<Account> account=accountRepository.findById(id);

        AccountDto accountDto=AccountMapper.mapAccountToAccountDto(account.get());

        return accountDto;
    }


    @Override
    public Long addAccount(AccountDto accountDto) throws MessagingException {

        Account account=accountRepository.save(AccountMapper.mapAccountDtoToAccount(accountDto));
        mailService.sendNewAccountToken(account);

        return account.getId();


    }
}
