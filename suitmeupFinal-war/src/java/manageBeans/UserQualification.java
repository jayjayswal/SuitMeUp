/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageBeans;

import db.SmuUserQualification;
import db.SmuUserQualificationPK;
import ejbs.UserQualificationLocal;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author manali
 */
@ManagedBean
@ViewScoped
public class UserQualification {
    
    @EJB
    private UserQualificationLocal userQualification;

    public List<SmuUserQualification> userqualification;
    public SmuUserQualification selectedQualification;
    public SmuUserQualification newQualification;   
    UserSession Usersession = null;
    public List<SmuUserQualification> getUserqualification() {
        return userqualification;
    }

    public void setUserqualification(List<SmuUserQualification> userqualification) {
        this.userqualification = userqualification;
    }

    public SmuUserQualification getSelectedQualification() {
        return selectedQualification;
    }

    public void setSelectedQualification(SmuUserQualification selectedQualification) {
        this.selectedQualification = selectedQualification;
    }

    public SmuUserQualification getNewQualification() {
        return newQualification;
    }

    public void setNewQualification(SmuUserQualification newQualification) {
        this.newQualification = newQualification;
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
         userqualification=userQualification.getUserQualification(Usersession.session.getUcUserId());
         newQualification= new SmuUserQualification(); 
    }
    
    public void deleteQualification(SmuUserQualification qualification) {
        userQualification.deleteQualification(qualification);
        userqualification=userQualification.getUserQualification(Usersession.session.getUcUserId());
    }
    
    public void updateQualification(){
        userQualification.updateQualification(selectedQualification);
        userqualification=userQualification.getUserQualification(Usersession.session.getUcUserId());
        selectedQualification=null;
    }
   
    public void createQualification(){
        SmuUserQualificationPK pk=new SmuUserQualificationPK();
        pk.setUcUserId(Usersession.session.getUcUserId());
        newQualification.setSmuUserQualificationPK(pk);
        userQualification.createQualification(newQualification);
        newQualification=new SmuUserQualification();
        userqualification=userQualification.getUserQualification(Usersession.session.getUcUserId());
    }  
}
