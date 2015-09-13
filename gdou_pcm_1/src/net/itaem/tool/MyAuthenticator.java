package net.itaem.tool;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/*
 *  ����һ��������֤�����û��������룩
 *  @author zaopeng
 */
public class MyAuthenticator extends Authenticator{  
    String userName=null;  
    String password=null;  
       
    public MyAuthenticator(){  
    }  
    public MyAuthenticator(String username, String password) {   
        this.userName = username;   
        this.password = password;   
    }   
    protected PasswordAuthentication getPasswordAuthentication(){  
        return new PasswordAuthentication(userName, password);  
    }  
}  