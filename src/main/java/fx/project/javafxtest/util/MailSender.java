package fx.project.javafxtest.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MailSender {

    private static final String PROPERTY = "src/main/resources/email.properties";
    private static final String HOST = "smtp.gmail.com";
    private static final String SMTPPORT = "465";

    public void sendMail(String subject, String text, String recipient) throws IOException {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", HOST);
        properties.put("mail.smtp.port", SMTPPORT);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Properties emailAuthProperties = new Properties();
        emailAuthProperties.load(new FileInputStream(PROPERTY));
        String login = emailAuthProperties.getProperty("username");
        String password = emailAuthProperties.getProperty("password");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(login, password);
            }
        });

        session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress((login)));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
