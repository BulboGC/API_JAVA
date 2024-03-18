package com.example.teste_api.services;

import com.example.teste_api.enums.EmailStatus;
import com.example.teste_api.models.EmailModel;
import com.example.teste_api.repositories.EmailRepository;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private JavaMailSender mailSender;

    @Transactional
    public EmailModel sendEmail(@NotNull EmailModel emailModel){

            emailModel.setSendDateEmail(LocalDateTime.now());
            try{
                SimpleMailMessage message = new SimpleMailMessage();
                message.setFrom(emailModel.getEmailFrom());
                message.setTo(emailModel.getEmailTo());
                message.setSubject(emailModel.getSubject());
                message.setText(emailModel.getText());
                mailSender.send(message);
                emailModel.setStatusEmail(EmailStatus.SENT);
            }catch (MailException e){
                emailModel.setStatusEmail(EmailStatus.ERROR);
            }finally {
                return emailRepository.save(emailModel);           }



    }


}
