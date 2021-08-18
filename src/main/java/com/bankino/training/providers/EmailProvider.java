package com.bankino.training.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class EmailProvider extends AbstractProviderService {

    //    @Autowired
    //    public SimpleMailMessage template;
    @Autowired
    public JavaMailSender emailSender;



    public EmailProvider(String to, String subject, String text) {
        super(to, subject, text);
    }
    public EmailProvider() {
    }
    @Override
    public void sendSimpleMessage(String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);

    }


    @Override
    public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) throws MessagingException {
        // ...
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text);

        FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
        helper.addAttachment("Invoice", file);
        emailSender.send(message);
        // ...
    }

//    @Bean
//    public SimpleMailMessage templateSimpleMessage() {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setText(
//                "This is the test email template for your email:\n%s\n");
//        return message;
//    }
//
//    String text = String.format(template.getText(), templateArgs);
//    sendSimpleMessage(to,     subject, text);
}
