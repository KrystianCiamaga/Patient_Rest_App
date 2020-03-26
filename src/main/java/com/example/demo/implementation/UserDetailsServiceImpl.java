package com.example.demo.implementation;

import com.example.demo.entity.Account;
import com.example.demo.mapper.UserDetailsMapper;
import com.example.demo.repository.AccountRepository;
import com.example.demo.security.AccountDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private AccountRepository accountRepository;

    public UserDetailsServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {


        Account account=accountRepository.findByLogin(s);

        if(account == null){

            throw new UsernameNotFoundException("invalid username or password");
        }


        AccountDetails accountDetails = UserDetailsMapper.mapUserToUserDetails(account);



        return accountDetails;




    }




}
