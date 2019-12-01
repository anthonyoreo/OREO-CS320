package sample;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


//maven repository input
/*
<!-- https://mvnrepository.com/artifact/javax.mail/javax.mail-api -->
<dependency>
<groupId>javax.mail</groupId>
<artifactId>javax.mail-api</artifactId>
<version>1.6.0</version>
</dependency>
*/


//import javax.mail.Authenticator;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;

//pulled code from tutorial https://www.youtube.com/watch?v=A7HAB5whD6I
//to add a jar file ie javax.mail, refer to the fourth classentry line in classpath
//additionally ensure that you have moved the jar to the lib directory in project folder


public class javaMail
{
    String who;
    public javaMail(String who) {
        this.who = who;
	}


    public static void sendMail(String recipient) throws MessagingException {
        Properties properties = new Properties();

        //authenication == true
        properties.put("mail.smtp.auth", "true");
        //start ttls comms enable
        properties.put("mail.smtp.startttls.enable", "true");
        //below both entries are required to enable Gmail sending
        //host name for gmail
        properties.put("mail.smtp.host", "smtp.gmail.com");
        //port num for gmail
        properties.put("mail.smtp.port","587");

        //below address must be either a forwarding address
        //or an address input by user that is their email
        //must login with gmail; additional steps required
        //to reduce security measures on sender account
        String myAccountEmail = "oreocs3201.gmail.com";
        String password = "OREOcs3201";


        //below is instance for sending email
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        

        Message message = prepareMessage(session, myAccountEmail, recipient);

        Transport.send(message);
    }

        private static Message prepareMessage(Session session, String myAccountEmail,
        String recipient) {
            try{
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(myAccountEmail));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
                message.setSubject("My first java email app");
                message.setText("Hey there, \n look my email");
                return message;
            } catch (Exception e)
            {
                Logger.getLogger(javaMail.class.getName()).log(Level.SEVERE, null, e);
            }
            return null;
            
        }      
    }
