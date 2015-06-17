/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageBeans;

import db.SmuUserWorkExperience;
import db.SmuUserWorkExperiencePK;
import ejbs.UserWorkExperienceLocal;
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
public class UserWorkExperience {
    
    @EJB
    private UserWorkExperienceLocal userWorkExperience;
    UserSession Usersession = null;
    public List<SmuUserWorkExperience> userWorkEx;
    public SmuUserWorkExperience selectedWorkEx;
    public SmuUserWorkExperience newWorkEx;  

    public List<SmuUserWorkExperience> getUserWorkEx() {
        return userWorkEx;
    }

    public void setUserWorkEx(List<SmuUserWorkExperience> userWorkEx) {
        this.userWorkEx = userWorkEx;
    }

    public SmuUserWorkExperience getSelectedWorkEx() {
        return selectedWorkEx;
    }

    public void setSelectedWorkEx(SmuUserWorkExperience selectedWorkEx) {
        this.selectedWorkEx = selectedWorkEx;
    }

    public SmuUserWorkExperience getNewWorkEx() {
        return newWorkEx;
    }

    public void setNewWorkEx(SmuUserWorkExperience newWorkEx) {
        this.newWorkEx = newWorkEx;
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
         userWorkEx=userWorkExperience.getUserWorkExperience(Usersession.session.getUcUserId());
         newWorkEx= new SmuUserWorkExperience(); 
    }
    
    public void deleteExperience(SmuUserWorkExperience workEx) {
        userWorkExperience.deleteExperience(workEx);
        userWorkEx=userWorkExperience.getUserWorkExperience(Usersession.session.getUcUserId());
    }
    
    public void updateExperience(){
        userWorkExperience.updateExperience(selectedWorkEx);
        userWorkEx=userWorkExperience.getUserWorkExperience(Usersession.session.getUcUserId());
        selectedWorkEx=null;
    }
   
    public void createExperience(){
        SmuUserWorkExperiencePK pk=new SmuUserWorkExperiencePK();
        pk.setUcUserId(Usersession.session.getUcUserId());
        newWorkEx.setSmuUserWorkExperiencePK(pk);
        userWorkExperience.createExperience(newWorkEx);
        newWorkEx=new SmuUserWorkExperience();
        userWorkEx=userWorkExperience.getUserWorkExperience(Usersession.session.getUcUserId());
    }   
}
