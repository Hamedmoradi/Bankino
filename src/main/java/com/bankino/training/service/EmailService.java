package com.bankino.training.service;


import javax.mail.MessagingException;
import java.io.IOException;

public interface EmailService {
    void sendEmail();
    void sendEmailWithAttachment()throws MessagingException, IOException;
}
