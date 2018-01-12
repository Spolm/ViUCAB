package edu.ucab.desarrollo.viucab.domainLogicLayer.M10_Notificaciones;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Notificacion;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M10_Notificaciones.MailNotificacionDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import org.slf4j.LoggerFactory;

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


public class MailNotificacion extends Command{

    final static org.slf4j.Logger logger = LoggerFactory.getLogger(GetNotificaciones.class);

    private static Notificacion nt;

    private static Entity en;

    private static String usuarioCli;

    private static String usuarioSus;

    private static String destinatario;

    private static String cuerpo;

    private static String tema;

    private static String imagen;

    private static Properties props = new Properties();

    private static Session session = Session.getDefaultInstance(props);

    private static MimeMessage message = new MimeMessage(session);

    private static MimeMultipart multipart = new MimeMultipart("related");

    public MailNotificacion (Entity en, String usuarioCli, String usuarioSus){
        this.usuarioCli = usuarioCli;
        this.usuarioSus = usuarioSus;
        this.en = en;
        cuerpo = null;
        destinatario = null;
        tema = null;
        imagen = null;
    }

    @Override
    public void execute() {
        try {
            MailNotificacionDao dao = DaoFactory.instanciateDaoMailNotificacion();
            nt = dao.mailNotificacion(en,usuarioCli,usuarioSus);
            cuerpo = "Hola " + nt.getUsuario().get_name_user() + " nos complace notificarle que sus suscripciones han generado actividad ultimamente:\n El usuario " + nt.getUsuarioSus().get_name_user() +" ha subido un nuevo video titulado: "+ nt.getVideo().getNombre();
            destinatario = nt.getUsuario().get_email_user();
            tema = "Actividad Reciente";
            imagen = nt.getVideo().getImagen();
            enviarNotificacion(destinatario,cuerpo,tema,imagen);
        }
        catch (Exception e){
            logger.debug("Exception: {}", e);
        }
    }


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

    @Override
    public Entity Return() {
        nt.set_cadena(nt.getUsuario().get_name_user());
        return nt;
    }
}
