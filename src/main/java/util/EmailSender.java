package util;

import entities.Etudiant;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.List;
import java.util.Properties;

class GMailAuthenticator extends Authenticator {
    String user;
    String pw;

    public GMailAuthenticator (String username, String password)
    {
        super();
        this.user = username;
        this.pw = password;
    }
    public PasswordAuthentication getPasswordAuthentication()
    {
        return new PasswordAuthentication(user, pw);
    }
}

public class EmailSender{

    String user = "";
    String pw = "";


    public void sendEmail(List<Etudiant> studentList, String entrepriseName, String competences) throws MessagingException {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
//        prop.put("mail.smtp.ssl.trust", "smtp.com.io");

        Session session = Session.getInstance(prop, new GMailAuthenticator(user,pw));


        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(user));

        for(Etudiant student : studentList) {
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(student.getMail()));
            message.setSubject("New offer from " + entrepriseName);

            String msg = "A new internship offer was added by " + entrepriseName + "\n\n Competences : \n" + competences;

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            Transport.send(message);
        }
    }
}
