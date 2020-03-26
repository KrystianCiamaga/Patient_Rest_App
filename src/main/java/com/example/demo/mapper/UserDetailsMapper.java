package com.example.demo.mapper;

import com.example.demo.entity.Account;
import com.example.demo.security.AccountDetails;

public class UserDetailsMapper {


    public static AccountDetails mapUserToUserDetails(Account account) {

        AccountDetails accountDetails=new AccountDetails();

        accountDetails.setLogin(account.getLogin());
        accountDetails.setPassword(account.getPassword());
        accountDetails.setAuthoritySet(account.getAuthoritySet());

        return accountDetails;



    }
}