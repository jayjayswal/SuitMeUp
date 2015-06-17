/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageBeans;

import db.SmuUserCredentials;
import ejbs.UserCredentialsLocal;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.PostLoad;
import javax.ws.rs.POST;

/**
 *
 * @author jay
 */
@ManagedBean(name = "userSession")
@SessionScoped
public class UserSession {
    @EJB
    private UserCredentialsLocal userCredentials;

    SmuUserCredentials session=null;
    public SmuUserCredentials logedinUser=null;
    public SmuUserCredentials newUser=new SmuUserCredentials();
    public UserSession() {
    }

    public SmuUserCredentials getLogedinUser() {
        return logedinUser;
    }

    public void setLogedinUser(SmuUserCredentials logedinUser) {
        this.logedinUser = logedinUser;
    }

    public SmuUserCredentials getNewUser() {
        return newUser;
    }

    public void setNewUser(SmuUserCredentials newUser) {
        this.newUser = newUser;
    }

    public SmuUserCredentials getSession() {
        return session;
    }

    public void setSession(SmuUserCredentials session) {
        this.session = session;
    }
    
     
    public void userLogin(){
       System.out.println("login");
       logedinUser=userCredentials.getUser(newUser.getUcUserEmail());  // gat user by email
       if(logedinUser==null){  // if user not found
            FacesMessage msg = new FacesMessage("Invalid Username or Password");
            FacesContext.getCurrentInstance().addMessage(null, msg);
       }else{ 
           String sha=null;
           sha = encryptPassword(newUser.getUcUserPassword()); // encript password wirh SHA 1
           System.out.println(new String(sha));
           System.out.println(logedinUser.getUcUserPassword());
           if(sha.equals(logedinUser.getUcUserPassword())){   //compare password
               session=logedinUser;    // create session
                FacesContext fc = FacesContext.getCurrentInstance();  // redirect to manage view
                ExternalContext ec = fc.getExternalContext();
               try {
                   ec.redirect("manage/technicalSkills.xhtml");
               } catch (IOException ex) {
                   Logger.getLogger(UserSession.class.getName()).log(Level.SEVERE, null, ex);
               }
                FacesMessage msg = new FacesMessage("valid Username or Password");
                FacesContext.getCurrentInstance().addMessage(null, msg);
           }else{
                FacesMessage msg = new FacesMessage("Invalid Username or Password");
                FacesContext.getCurrentInstance().addMessage(null, msg);
           }
       }
   }
    public void logout(){
        if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey("userSession")){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("userSession");
        }
         FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            try {
                ec.redirect(ec.getRequestContextPath()+"/index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(UserSession.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void init(){
        System.out.println("called");
        if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey("userSession")){
        System.out.println("in");
         FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            try {
                ec.redirect(ec.getRequestContextPath()+"/manage/UserTechnicalSkills.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(UserSession.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
     public static String encryptPassword(String password)
    {
        String sha1 = "";
        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(password.getBytes("UTF-8"));
            sha1 = byteToHex(crypt.digest());
        }   
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return sha1;
    }

    private static String byteToHex(final byte[] hash)
    {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
}
