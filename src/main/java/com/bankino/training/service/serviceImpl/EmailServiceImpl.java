package com.bankino.training.service.serviceImpl;


import com.bankino.training.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import org.springframework.core.io.ClassPathResource;




@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("to_1@gmail.com", "to_2@gmail.com", "to_3@yahoo.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);

    }
    public void sendEmailWithAttachment() throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);

        helper.setTo("to_@email");

        helper.setSubject("Testing from Spring Boot");

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        helper.setText("<h1>Check attachment for image!</h1>", true);

        // hard coded a file path
        //FileSystemResource file = new FileSystemResource(new File("path/android.png"));

        helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

        javaMailSender.send(msg);

    }

//
//    @Autowired
//    public JavaMailSender emailSender;
//
//    @Override
//    public void sendSimpleMessage(String to, String subject, String text) {
//
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(text);
//        emailSender.send(message);
//
//    }
//
//
//    @Override
//    public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) throws MessagingException {
//        MimeMessage message = emailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//
//        helper.setTo(to);
//        helper.setSubject(subject);
//        helper.setText(text);
//
//        FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
//        helper.addAttachment("Invoice", file);
//        emailSender.send(message);
//    }
//

}
