package com.example.ebank.mail;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.stream.Collectors;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.KeySpec;
import java.util.Base64;

@Service

public class EmailService {


    @Autowired
    private  ResourceLoader resourceLoader;
        @Autowired
        private JavaMailSender mailSender;

        public void sendEmail(String to, String subject, String verificationCode) throws Exception {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            String emailContent = loadEmailTemplate()
                    .replace("{{verificationCode}}", verificationCode);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(emailContent, true);

            mailSender.send(message);
        }
    public void sendEmailtoClient(String to, String subject, String username,String identification,String password) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        String emailContent = loadEmailTemplateCreatedAccount()
                .replace("{{username}}", username)
                .replace("{{identification}}", identification)
                .replace("{{password}}", password);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(emailContent, true);

        mailSender.send(message);
    }


    private String loadEmailTemplate() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:email-template.html");
        try (InputStreamReader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        }
    }
    private String loadEmailTemplateCreatedAccount() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:Clientemail-template.html");
        try (InputStreamReader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        }
    }

    private  static final   String  SECRET_KEY = "verification"; // Replace with your actual secret key
    private static final String SALT = "your_salt"; // Replace with your actual salt

    public static String decrypt(String strToDecrypt) {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKey secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(strToDecrypt));
            return new String(decryptedBytes);
        } catch (Exception e) {
            return null;
        }
    }


    private String loadEmailTemplateContact() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:contactEmail.html");
        try (InputStreamReader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        }
    }
    private String loadEmailTemplateSuppression() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:email-controlle.html");
        try (InputStreamReader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        }
    }

    public void sendEmailContact(String to, String sujet, String text,String username) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        String emailContent = loadEmailTemplateContact()
                .replace("{{username}}", username)
                .replace("{{sujet}}", sujet)
                .replace("{{text}}", text);

        helper.setTo(to);
        helper.setSubject(sujet);
        helper.setText(emailContent, true);

        mailSender.send(message);
    }
    public void sendEmailSuppression(String to, String sujet, String response,String username) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        String emailContent = loadEmailTemplateSuppression()
                .replace("{{userName}}", username)
                .replace("{{reponse}}", response);

        helper.setTo(to);
        helper.setSubject(sujet);
        helper.setText(emailContent, true);

        mailSender.send(message);
    }


}

