/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageBeans;

import db.SmuUserAchievements;
import db.SmuUserAchievementsPK;
import ejbs.UserAchievementsLocal;
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
public class UserAchievements {
    @EJB
    private UserAchievementsLocal userAchievements;
   
    UserSession Usersession = null;

    public List<SmuUserAchievements> usertechAchievements;
    public SmuUserAchievements selectedAchievements;
    public SmuUserAchievements newAchievements;

    public List<SmuUserAchievements> getUsertechAchievements() {
        return usertechAchievements;
    }

    public void setUsertechAchievements(List<SmuUserAchievements> usertechAchievements) {
        this.usertechAchievements = usertechAchievements;
    }

    public SmuUserAchievements getSelectedAchievements() {
        return selectedAchievements;
    }

    public void setSelectedAchievements(SmuUserAchievements selectedAchievements) {
        this.selectedAchievements = selectedAchievements;
    }

    public SmuUserAchievements getNewAchievements() {
        return newAchievements;
    }

    public void setNewAchievements(SmuUserAchievements newAchievements) {
        this.newAchievements = newAchievements;
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
         usertechAchievements=userAchievements.getUserAchievements(Usersession.session.getUcUserId());
         newAchievements= new SmuUserAchievements(); 
         
    }
    
    public void deleteAchievement(SmuUserAchievements skill) {
        userAchievements.deleteAchievements(skill);
        usertechAchievements=userAchievements.getUserAchievements(Usersession.session.getUcUserId());
    }
    
    public void updateAchievement(){
        userAchievements.updateAchievements(selectedAchievements);
        usertechAchievements=userAchievements.getUserAchievements(Usersession.session.getUcUserId());
        selectedAchievements=null;
    }
   
    public void createAchievement(){
        SmuUserAchievementsPK pk=new SmuUserAchievementsPK();
        pk.setUcUserId(Usersession.session.getUcUserId());
        newAchievements.setSmuUserAchievementsPK(pk);
        userAchievements.createAchievements(newAchievements);
        newAchievements=new SmuUserAchievements();
        usertechAchievements=userAchievements.getUserAchievements(Usersession.session.getUcUserId());
    }
    
    /**
     * Creates a new instance of UserAchievements
     */
    public UserAchievements() {
    }
    
}
