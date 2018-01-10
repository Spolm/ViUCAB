package edu.ucab.desarrollo.viucab.domainLogicLayer.M10_Notificaciones;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class MailNotificacion {
    Properties props = new Properties();

    Session session = Session.getDefaultInstance(props);

    MimeMessage message = new MimeMessage(session);

    public void enviarNotificacion (String recipient, String body, String subject){

        try{

            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port","465");
            props.setProperty("mail.smtp.user", "arkantostheapp@gmail.com");
            props.setProperty("mail.smtp.auth", "true");
            props.put("mail.smtp.socketFactory.port", "587");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");

            session.setDebug(true);

            message.setFrom(new InternetAddress ("arkantostheapp@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));;
            message.setSubject(subject);
            message.setText(body);

            Transport t = session.getTransport("smtp");
            t.connect("arkantostheapp@gmail.com","arkantos13*");
            t.sendMessage(message,message.getAllRecipients());
            t.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
