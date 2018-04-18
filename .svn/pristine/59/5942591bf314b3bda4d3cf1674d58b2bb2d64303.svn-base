package ua.nure.kibkalo.utils;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailServlet {

    /*Метод отправки сообщения на почту, входящие параметры: тема String, текст сообщения String,
     *адрес почты String, пароль String*/
    public static void generateAndSendEmailAdmin(String subject, String text, String email, String password) throws MessagingException {

        Properties properties = System.getProperties();
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(properties, null);
        MimeMessage message = new MimeMessage(session);
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("sanja380662924204@gmail.com"));
        message.addRecipient(Message.RecipientType.CC, new InternetAddress("sanja380662924204@gmail.com"));
        message.setSubject(subject);
        message.setContent(text, "text/html");

        Transport transport = session.getTransport("smtp");

        transport.connect("smtp.gmail.com", email, password);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    /*Метод отправки сообщения на почту при регистрации автомобиля, входящие параметры: текст сообщения String,
     *адрес почты String, количество дней на которые заказан автомобиль Integer, модель автомобиля String*/
    public static void sendMessageSuccessfullyRegistration(String email, String name, String model, Integer amount_of_day) throws MessagingException {

        Properties properties = System.getProperties();
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(properties, null);
        MimeMessage message = new MimeMessage(session);
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        message.addRecipient(Message.RecipientType.CC, new InternetAddress(email));
        message.setSubject("AutoRENTAL.ua");
        message.setContent("Hi, " + name + " , your car: " + model + " is taken for " + amount_of_day.toString()
                + " days! Pleasant use! For all questions, please contact us by e-mail: sanja380662924204@gmail.com", "text/html");

        Transport transport = session.getTransport("smtp");

        transport.connect("smtp.gmail.com", "sanja380662924204@gmail.com", "alex_winner2015-2020");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}