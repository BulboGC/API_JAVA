package com.example.teste_api.models;

import com.example.teste_api.enums.EmailStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;


@Entity
@Table(name = "TB_EMAIL")
public class EmailModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID emailId;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDateEmail;
    private EmailStatus statusEmail;

    public EmailModel(UUID emailId, String ownerRef, String emailFrom, String emailTo, String subject, String text, LocalDateTime sendDateEmail, EmailStatus statusEmail) {
        this.emailId = emailId;
        this.ownerRef = ownerRef;
        this.emailFrom = emailFrom;
        this.emailTo = emailTo;
        this.subject = subject;
        this.text = text;
        this.sendDateEmail = sendDateEmail;
        this.statusEmail = statusEmail;
    }

    public EmailModel() {
    }


    public UUID getEmailId() {
        return emailId;
    }

    public void setEmailId(UUID emailId) {
        this.emailId = emailId;
    }

    public String getOwnerRef() {
        return ownerRef;
    }

    public void setOwnerRef(String ownerRef) {
        this.ownerRef = ownerRef;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getSendDateEmail() {
        return sendDateEmail;
    }

    public void setSendDateEmail(LocalDateTime sendDateEmail) {
        this.sendDateEmail = sendDateEmail;
    }

    public EmailStatus getStatusEmail() {
        return statusEmail;
    }

    public void setStatusEmail(EmailStatus statusEmail) {
        this.statusEmail = statusEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmailModel that)) return false;
        return Objects.equals(getEmailId(), that.getEmailId()) && Objects.equals(getOwnerRef(), that.getOwnerRef()) && Objects.equals(getEmailFrom(), that.getEmailFrom()) && Objects.equals(getEmailTo(), that.getEmailTo()) && Objects.equals(getSubject(), that.getSubject()) && Objects.equals(getText(), that.getText()) && Objects.equals(getSendDateEmail(), that.getSendDateEmail()) && getStatusEmail() == that.getStatusEmail();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmailId(), getOwnerRef(), getEmailFrom(), getEmailTo(), getSubject(), getText(), getSendDateEmail(), getStatusEmail());
    }

    @Override
    public String toString() {
        return "EmailModel{" +
                "ownerRef='" + ownerRef + '\'' +
                ", emailFrom='" + emailFrom + '\'' +
                ", emailTo='" + emailTo + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", sendDateEmail=" + sendDateEmail +
                ", statusEmail=" + statusEmail +
                '}';
    }




}