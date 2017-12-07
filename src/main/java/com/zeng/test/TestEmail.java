package com.zeng.test;

import java.util.Calendar;  
import java.util.Properties;  
  
import javax.mail.Authenticator;  
import javax.mail.MessagingException;  
import javax.mail.PasswordAuthentication;  
import javax.mail.Session;  
import javax.mail.Transport;  
import javax.mail.Message.RecipientType;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage;  
  
public class TestEmail{  
    @SuppressWarnings("static-access")  
    public static void sendMessage(String smtpHost, String from,  
            String fromUserPassword, String to, String subject,  
            String messageText, String messageType) throws MessagingException {  
        // ��һ��������javax.mail.Session����  
        System.out.println("Ϊ" + smtpHost + "����mail session����");  
          
          
        Properties props = new Properties();  
        props.put("mail.smtp.host", smtpHost);  
        props.put("mail.smtp.starttls.enable","true");//ʹ�� STARTTLS��ȫ����  
        //props.put("mail.smtp.port", "25");             //googleʹ��465��587�˿�  
        props.put("mail.smtp.auth", "true");        // ʹ����֤  
        //props.put("mail.debug", "true");  
        Session mailSession = Session.getInstance(props,new MyAuthenticator(from,fromUserPassword));  
  
        // �ڶ�������д��Ϣ  
        System.out.println("��д��Ϣfrom����to:" + from + "����" + to);  
  
        InternetAddress fromAddress = new InternetAddress(from);  
        InternetAddress toAddress = new InternetAddress(to);  
  
        MimeMessage message = new MimeMessage(mailSession);  
  
        message.setFrom(fromAddress);  
        message.addRecipient(RecipientType.TO, toAddress);  
  
        message.setSentDate(Calendar.getInstance().getTime());  
        message.setSubject(subject);  
        message.setContent(messageText, messageType);  
  
        // ��������������Ϣ  
        Transport transport = mailSession.getTransport("smtp");  
        transport.connect(smtpHost,"chaofeng19861126", fromUserPassword);  
        transport.send(message, message.getRecipients(RecipientType.TO));  
        System.out.println("message yes");  
    }  
  
    public static void main(String[] args) {  
        try {  
            TestEmail.sendMessage("smtp.qq.com", "931463136@qq.com",  
                    "ojupbsocbsqobchd", "1318012135@qq.com", "nihao",  
                    "---------------wrwe-----------",  
                    "text/html;charset=gb2312");  
        } catch (MessagingException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
}  
class MyAuthenticator extends Authenticator{  
    String userName="";  
    String password="";  
    public MyAuthenticator(){  
          
    }  
    public MyAuthenticator(String userName,String password){  
        this.userName=userName;  
        this.password=password;  
    }  
     protected PasswordAuthentication getPasswordAuthentication(){     
        return new PasswordAuthentication(userName, password);     
     }   
}  
