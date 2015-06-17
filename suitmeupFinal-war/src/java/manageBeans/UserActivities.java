/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageBeans;

import db.SmuUserActivities;
import db.SmuUserActivitiesPK;
import ejbs.UserActivitiesLocal;
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
public class UserActivities {
    
    @EJB
    private UserActivitiesLocal userActivities;
    UserSession Usersession = null;
    public List<SmuUserActivities> useractivities;
    public SmuUserActivities selectedActivity;
    public SmuUserActivities newActivity;

    public List<SmuUserActivities> getUseractivities() {
        return useractivities;
    }

    public void setUseractivities(List<SmuUserActivities> useractivities) {
        this.useractivities = useractivities;
    }

    public SmuUserActivities getSelectedActivity() {
        return selectedActivity;
    }

    public void setSelectedActivity(SmuUserActivities selectedActivity) {
        this.selectedActivity = selectedActivity;
    }

    public SmuUserActivities getNewActivity() {
        return newActivity;
    }

    public void setNewActivity(SmuUserActivities newActivity) {
        this.newActivity = newActivity;
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
         useractivities = userActivities.getUserTechnicalActivities(Usersession.session.getUcUserId());
         newActivity= new SmuUserActivities();
         
    }
    
    public void deleteActivities(SmuUserActivities activity) {
        userActivities.deleteActivities(activity);
        useractivities=userActivities.getUserTechnicalActivities(Usersession.session.getUcUserId());
    }
    
    public void updateActivity(){
        userActivities.updateActivities(selectedActivity);
        useractivities=userActivities.getUserTechnicalActivities(Usersession.session.getUcUserId());
        selectedActivity=null;
    }
   
    public void createActivities(){
        SmuUserActivitiesPK pk=new SmuUserActivitiesPK();
        pk.setUcUserId(Usersession.session.getUcUserId());
        newActivity.setSmuUserActivitiesPK(pk);
        userActivities.createActivities(newActivity);
        newActivity=new SmuUserActivities();
        useractivities=userActivities.getUserTechnicalActivities(Usersession.session.getUcUserId());
    }    
}
