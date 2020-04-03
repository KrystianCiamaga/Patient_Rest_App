package com.example.demo.email;

import com.example.demo.dto.VisitDto;
import com.example.demo.entity.Account;
import com.example.demo.entity.Patient;
import com.example.demo.entity.Token;
import com.example.demo.exception.PatientException.PatientNotFoundException;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.repository.TokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MailService {


    private JavaMailSender javaMailSender;
    private PatientRepository patientRepository;
    private TokenRepository tokenRepository;


    public void sendMail(String to,
                         String subject,
                         String text,
                         boolean isHtmlContent) throws MessagingException {


        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(text,isHtmlContent);
        javaMailSender.send(mimeMessage);

    }



    public void sendNewVisit(String userName, VisitDto visitDto) throws MessagingException {

        Patient patient = patientRepository.findByAccount_Login(userName).orElseThrow(PatientNotFoundException::new);
        String mailContent = "Hello "+patient.getFirst_name()+" "+patient.getLast_name()+".\n"+
                "We registered new visit "+"\n"+"Information about visit. "+visitDto.getInformations();


        sendMail(patient.getEmail(),"You have a new visit.",
                mailContent,true);

    }

    public void sendNewAccountToken(Account account) throws MessagingException {

        String tokenValue= UUID.randomUUID().toString();

        Token token = new Token();
        token.setValue(tokenValue);
        token.setAccount(account);
        tokenRepository.save(token);

        String url="http://localhost:8080/accounts/token?value="+tokenValue;

        sendMail(account.getEmail(),"Confirm registration",url,false);





    }





}
