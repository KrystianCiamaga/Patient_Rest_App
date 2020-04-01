package com.example.demo.email;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;


public class MailApp {

    private MailService mailService;

    public MailApp(MailService mailService) {
        this.mailService = mailService;
    }

    public String sendMail() throws MessagingException{

        mailService.sendMail("dupa@gmail.com",   "Wygrałeś",
                "<b>1000 000 zł</b><br>:P", true);

        return "wwygrales";

    }


}
