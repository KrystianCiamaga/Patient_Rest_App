package com.example.demo.email;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private EmailConfig emailConfig;

    public FeedbackController(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
    }

    @PostMapping
    private void sendFeedback(@RequestBody Feedback feedback, BindingResult bindingResult)  {




        JavaMailSenderImpl mailSender=new JavaMailSenderImpl();

        mailSender.setPort(emailConfig.getPort());
        mailSender.setUsername(emailConfig.getUsername());
        mailSender.setPassword(emailConfig.getPassword());
        mailSender.setHost(emailConfig.getHost());

        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom(feedback.getEmail());
        mailMessage.setTo("dupa@gmail.com");
        mailMessage.setSubject("new feedback form "+feedback.getName());
        mailMessage.setText(feedback.getFeedback());


        mailSender.send(mailMessage);


    }





}
