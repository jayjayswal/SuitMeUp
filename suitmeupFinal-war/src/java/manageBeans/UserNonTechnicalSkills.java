/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageBeans;

import db.SmuUserNonTechnicalSkills;
import db.SmuUserNonTechnicalSkillsPK;
import ejbs.UserNonTechnicalSkillsLocal;
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
public class UserNonTechnicalSkills {
    
    @EJB
    private UserNonTechnicalSkillsLocal userNonTechnicalSkills;

    public List<SmuUserNonTechnicalSkills> userNonTechSkills;
    public SmuUserNonTechnicalSkills selectedNonTechSkill;
    public SmuUserNonTechnicalSkills newNonTechSkill;
    UserSession Usersession = null;
    public List<SmuUserNonTechnicalSkills> getUserNonTechSkills() {
        return userNonTechSkills;
    }

    public void setUserNonTechSkills(List<SmuUserNonTechnicalSkills> userNonTechSkills) {
        this.userNonTechSkills = userNonTechSkills;
    }

    public SmuUserNonTechnicalSkills getSelectedNonTechSkill() {
        return selectedNonTechSkill;
    }

    public void setSelectedNonTechSkill(SmuUserNonTechnicalSkills selectedNonTechSkill) {
        this.selectedNonTechSkill = selectedNonTechSkill;
    }

    public SmuUserNonTechnicalSkills getNewNonTechSkill() {
        return newNonTechSkill;
    }

    public void setNewNonTechSkill(SmuUserNonTechnicalSkills newNonTechSkill) {
        this.newNonTechSkill = newNonTechSkill;
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
         userNonTechSkills=userNonTechnicalSkills.getUserTechnicalSkills(Usersession.session.getUcUserId());
         newNonTechSkill= new SmuUserNonTechnicalSkills(); 
    }
    
    public void deleteNonTechSkill(SmuUserNonTechnicalSkills skill) {
        userNonTechnicalSkills.deleteSkill(skill);
        userNonTechSkills=userNonTechnicalSkills.getUserTechnicalSkills(Usersession.session.getUcUserId());
    }
    
    public void updateNonTechSkill(){
        userNonTechnicalSkills.updateSkill(selectedNonTechSkill);
        userNonTechSkills=userNonTechnicalSkills.getUserTechnicalSkills(Usersession.session.getUcUserId());
        selectedNonTechSkill=null;
    }
   
    public void createNonTechSkill(){
        SmuUserNonTechnicalSkillsPK pk=new SmuUserNonTechnicalSkillsPK();
        pk.setUcUserId(Usersession.session.getUcUserId());
        newNonTechSkill.setSmuUserNonTechnicalSkillsPK(pk);
        userNonTechnicalSkills.createSkill(newNonTechSkill);
        newNonTechSkill=new SmuUserNonTechnicalSkills();
        userNonTechSkills=userNonTechnicalSkills.getUserTechnicalSkills(Usersession.session.getUcUserId());
    }
}