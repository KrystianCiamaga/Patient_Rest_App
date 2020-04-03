package com.example.demo.security;

import com.example.demo.dto.AccountDto;
import com.example.demo.entity.Account;
import com.example.demo.entity.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class AccountDetails  extends Account implements UserDetails {


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> list=new ArrayList<>();

        this.getAuthoritySet().stream()
                .forEach(s ->list.add(new SimpleGrantedAuthority(s.getAuthority())));

        return list;
    }



    @Override
    public String getUsername() {
        return this.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.isActive();
    }
}
