/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageBeans;

import db.SmuUserCredentials;
import db.SmuUserTechnicalSkills;
import db.SmuUserTechnicalSkillsPK;
import ejbs.UserCredentialsLocal;
import ejbs.UserTechnicalSkillsLocal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author jay
 */
@ManagedBean
@ViewScoped
public class UserTechnicalSkills {

    @EJB
    private UserCredentialsLocal userCredentials;

    /**
     * Creates a new instance of UserTechnicalSkills
     */
    @EJB
    private UserTechnicalSkillsLocal userTechnicalSkills;

    UserSession Usersession = new UserSession();

    public List<SmuUserTechnicalSkills> usertechskills;
    public SmuUserTechnicalSkills selectedSkill;
    public SmuUserTechnicalSkills newSkill;

    public SmuUserTechnicalSkills getSelectedSkill() {
        return selectedSkill;
    }

    public void setSelectedSkill(SmuUserTechnicalSkills selectedSkill) {
        this.selectedSkill = selectedSkill;
    }

    public SmuUserTechnicalSkills getNewSkill() {
        return newSkill;
    }

    public void setNewSkill(SmuUserTechnicalSkills newSkill) {
        this.newSkill = newSkill;
    }

    public UserTechnicalSkills() {
        System.out.println("count");
    }

    public List<SmuUserTechnicalSkills> getUsertechskills() {
        return usertechskills;
    }

    public void setUsertechskills(List<SmuUserTechnicalSkills> usertechskills) {
        this.usertechskills = usertechskills;
    }

    @PostConstruct
    public void init() {
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
        usertechskills = userTechnicalSkills.getUserTechnicalSkills(Usersession.session.getUcUserId());
        newSkill = new SmuUserTechnicalSkills();
    }

    public void deleteSkill(SmuUserTechnicalSkills skill) {

        userTechnicalSkills.deleteSkill(skill);
        usertechskills = userTechnicalSkills.getUserTechnicalSkills(Usersession.session.getUcUserId());
    }

    public void update() {
        userTechnicalSkills.updateSkill(selectedSkill);
        usertechskills = userTechnicalSkills.getUserTechnicalSkills(Usersession.session.getUcUserId());
        selectedSkill = null;
    }

    public void createSkill() {
        SmuUserTechnicalSkillsPK pk = new SmuUserTechnicalSkillsPK();
        pk.setUcUserId(Usersession.session.getUcUserId());
        newSkill.setSmuUserTechnicalSkillsPK(pk);
        userTechnicalSkills.createSkill(newSkill);  
        newSkill=new SmuUserTechnicalSkills();
        usertechskills = userTechnicalSkills.getUserTechnicalSkills(Usersession.session.getUcUserId());
    }
}
