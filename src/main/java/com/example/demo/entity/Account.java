package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String login;

    private String password;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private Patient patient;

    @OneToMany(mappedBy = "account",fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Authority> authoritySet;

    private boolean isEnabled;





}
