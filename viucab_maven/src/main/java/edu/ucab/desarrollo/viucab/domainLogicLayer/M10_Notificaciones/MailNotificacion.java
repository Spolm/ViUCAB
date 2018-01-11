package edu.ucab.desarrollo.viucab.domainLogicLayer.M10_Notificaciones;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;


public class MailNotificacion {
    Properties props = new Properties();

    Session session = Session.getDefaultInstance(props);

    MimeMessage message = new MimeMessage(session);

    MimeMultipart multipart = new MimeMultipart("related");

    public void enviarNotificacion (String recipient, String body, String subject, String image){

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

            BodyPart messageBodyPart = new MimeBodyPart();
            message.setFrom(new InternetAddress ("arkantostheapp@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));;
            message.setSubject(subject);
            String htmlText = "<H1>"+body+"</H1><a href=\"https://www.youtube.com\"><img src = \"cid:image\"/></a>";
            messageBodyPart.setContent(htmlText, "text/html");
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            DataSource fds = new FileDataSource(
                    "C:/Users/vladimir/Documents/GitHub/ViUCAB/IonicProject/src/"+image);

            messageBodyPart.setDataHandler(new DataHandler(fds));
            messageBodyPart.setHeader("Content-ID", "<image>");
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);

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
