package com.app.employeemanagementsystem.service;

import jakarta.mail.MessagingException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.app.employeemanagementsystem.model.User;


@Service
public class MailSenderService {

    private final JavaMailSender javaMailSender;


    public MailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void send(User user, String mailBodyString) throws MessagingException {

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(javaMailSender.createMimeMessage(), true);
        mimeMessageHelper.setFrom("tset4598t@gmail.com");
        mimeMessageHelper.setTo(user.getEmail());
        mimeMessageHelper.setSubject("verify Otp");

        mimeMessageHelper.setText("Hi "+user.getName());

        String mailBody = "<h3>Hi "+user.getName()+",</h3><br/>"+"<h3>Click on the below link to verify email</h3><br/><br/><a href='http://localhost:8000/api/v1/users/verify-otp/"+mailBodyString+"/"+user.getEmail()+"'>Click to Verify</a>";

        mimeMessageHelper.setText(mailBody, true);
        javaMailSender.send(mimeMessageHelper.getMimeMessage());
        System.out.println("Mail sent successfully");

    }

    public void sendForPasswordReset(User user, String mailBodyString) throws MessagingException {

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(javaMailSender.createMimeMessage(), true);
        mimeMessageHelper.setFrom("tset4598t@gmail.com");
        mimeMessageHelper.setTo(user.getEmail());
        mimeMessageHelper.setSubject("verify Otp");

        mimeMessageHelper.setText("Hi "+user.getName());

        String mailBody = "<h3>Hi "+user.getName()+",</h3><br/>"+"<h3>Click on the below link to verify password reset</h3><br/><br/><a href='http://localhost:8000/api/v1/users/verify-otp-password/"+mailBodyString+"/"+user.getEmail()+"'>Click to Verify</a>";

        mimeMessageHelper.setText(mailBody, true);
        javaMailSender.send(mimeMessageHelper.getMimeMessage());
        System.out.println("Mail sent successfully");

    }

    private String generateMailBody(String verificationUrl, User  user){
        return "<h4>Hi " +user.getEmail()+", </h4><br>"+
                "<h5>Please click on below button to verify the user account</h5>"+
                "<a href="+verificationUrl+"><button style='color: 'blue''>Verify Account</button></a><br>"+
                "<h5>Warm Regards</h5>"+
                "<h5>Rateberg</h5>";
    }
}
