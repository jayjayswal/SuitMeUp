/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageBeans;

import com.sun.xml.ws.security.impl.policy.Constants;
import db.SmuUserCredentials;
import ejbs.UserCredentialsLocal;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author jay
 */
@ManagedBean
@RequestScoped
public class UserCredentical {
    @EJB
    private UserCredentialsLocal userCredentials;
    public String currentPass;
    public String newPass;
    public SmuUserCredentials logedinUser;
    UserSession Usersession = null;
    
    public UserCredentialsLocal getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(UserCredentialsLocal userCredentials) {
        this.userCredentials = userCredentials;
    }


    public String getCurrentPass() {
        return currentPass;
    }

    public void setCurrentPass(String currentPass) {
        this.currentPass = currentPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public SmuUserCredentials getLogedinUser() {
        return logedinUser;
    }

    public void setLogedinUser(SmuUserCredentials logedinUser) {
        this.logedinUser = logedinUser;
    }
    
    public UserCredentical() {
    }

    @PostConstruct
    public void init(){
        Usersession = (UserSession) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userSession");
        if(Usersession==null){
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            try {
                ec.redirect(ec.getRequestContextPath()+"/index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(UserSession.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }
        if(Usersession.session==null){
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            try {
                ec.redirect(ec.getRequestContextPath()+"/index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(UserSession.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }
        logedinUser = userCredentials.getUser(Usersession.session.getUcUserId());    
    }
    public void updateUserCredential(){
        if(currentPass.equals(logedinUser.getUcUserPassword())){
            logedinUser.setUcUserPassword(newPass);
            userCredentials.updateCredentials(logedinUser);
        }
    }
     
   
}
