package com.example.demo.mapper;

import com.example.demo.dto.AccountDto;
import com.example.demo.entity.Account;
import com.example.demo.entity.Authority;
import org.assertj.core.util.Sets;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class AccountMapper {



    public static AccountDto mapAccountToAccountDto(Account account){

        AccountDto accountDto=new AccountDto();

        if(account.getId() != null){

            accountDto.setLogin(account.getLogin());
            accountDto.setPassword(account.getPassword());

        }

        return accountDto;

    }



    private static Account getAccount(AccountDto accountDto){

        Account account=new Account();

        account.setLogin(accountDto.getLogin());
        account.setPassword(new BCryptPasswordEncoder().encode(accountDto.getPassword()));

        Authority authority=new Authority();
        authority.setAuthority("ROLE_USER");

        Set<Authority> set=new HashSet<>();
        set.add(authority);

        account.setAuthoritySet(set);

        return account;

    }


    public static Account mapAccountDtoToAccount(AccountDto accountDto) {

        return Optional.ofNullable(accountDto)
                .map(AccountMapper::getAccount)
                .orElse(null);

    }




}
