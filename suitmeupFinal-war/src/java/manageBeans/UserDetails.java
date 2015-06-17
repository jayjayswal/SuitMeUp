/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageBeans;

import db.SmuUserDetails;
import ejbs.UserDetailsLocal;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author jay
 */
@ManagedBean
@RequestScoped
public class UserDetails {
    @EJB
    private UserDetailsLocal userDetails;

    public SmuUserDetails selectedUSerDetails;
    UserSession Usersession = null;
    public SmuUserDetails getSelectedUSerDetails() {
        return selectedUSerDetails;
    }

    public void setSelectedUSerDetails(SmuUserDetails selectedUSerDetails) {
        this.selectedUSerDetails = selectedUSerDetails;
    }
            
    
    public UserDetails() {
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
        selectedUSerDetails = userDetails.getUserDetails(Usersession.session.getUcUserId());    
    }
    
    
    public void updateDetails(){
       userDetails.updateUserDetails(selectedUSerDetails);
    }
    
}
