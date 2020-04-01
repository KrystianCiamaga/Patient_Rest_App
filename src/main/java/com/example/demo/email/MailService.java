package com.example.demo.email;

import com.example.demo.dto.VisitDto;
import com.example.demo.entity.Patient;
import com.example.demo.exception.PatientException.PatientNotFoundException;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MailService {


    private JavaMailSender javaMailSender;
    private PatientRepository patientRepository;



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

    public String sendNewVisit(String userName, VisitDto visitDto) throws MessagingException {

        Patient patient = patientRepository.findByAccount_Login(userName).orElseThrow(PatientNotFoundException::new);
        String mailContent = "Hello "+patient.getFirst_name()+" "+patient.getLast_name()+".\n"+
                "We registered new visit "+"\n"+"Information about visit. "+visitDto.getInformations();


        sendMail(patient.getEmail(),"You have a new visit.",
                mailContent,true);

        return "Mailed";

    }


}
