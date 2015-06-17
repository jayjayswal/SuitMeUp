package manageBeans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import db.SmuUserDetails;
import db.SmuUserPersonalDetails_;
import db.SmuUserProfessionalDetails;
import db.SmuUserQualification;
import db.SmuUserTechnicalSkills;
import db.SmuUserWorkExperience;
import ejbs.UserCredentialsLocal;
import ejbs.UserDetailsLocal;
import ejbs.UserProfessionalDetailsLocal;
import ejbs.UserQualificationLocal;
import ejbs.UserTechnicalSkillsLocal;
import ejbs.UserWorkExperienceLocal;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jay
 */
@ManagedBean(name = "UserProfession")
@RequestScoped
public class UserProfessionPage {
    @EJB
    private UserWorkExperienceLocal userWorkExperience;
    @EJB
    private UserTechnicalSkillsLocal userTechnicalSkills;
    @EJB
    private UserQualificationLocal userQualification;
    @EJB
    private UserProfessionalDetailsLocal userProfessionalDetails;
    @EJB
    private UserDetailsLocal userDetails;
    @EJB
    private UserCredentialsLocal userCredentials;
    int userId=0;
    public SmuUserDetails userdetails;

    public SmuUserDetails getUserdetails() {
        return userdetails;
    }

    public void setUserdetails(SmuUserDetails userdetails) {
        this.userdetails = userdetails;
    }

    public SmuUserProfessionalDetails getUserprodetails() {
        return userprodetails;
    }

    public void setUserprodetails(SmuUserProfessionalDetails userprodetails) {
        this.userprodetails = userprodetails;
    }

    public List<SmuUserQualification> getUserqualification() {
        return userqualification;
    }

    public void setUserqualification(List<SmuUserQualification> userqualification) {
        this.userqualification = userqualification;
    }

    public List<SmuUserTechnicalSkills> getUsertechskills() {
        return usertechskills;
    }

    public void setUsertechskills(List<SmuUserTechnicalSkills> usertechskills) {
        this.usertechskills = usertechskills;
    }

    public List<SmuUserWorkExperience> getUserworkexp() {
        return userworkexp;
    }

    public void setUserworkexp(List<SmuUserWorkExperience> userworkexp) {
        this.userworkexp = userworkexp;
    }
    public SmuUserProfessionalDetails userprodetails;
    public List<SmuUserQualification> userqualification;
    public List<SmuUserTechnicalSkills> usertechskills;
    public List<SmuUserWorkExperience> userworkexp;
    public UserProfessionPage() {
        
    }
    
    public void setValues(){
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        userId=(Integer)request.getAttribute("userId");
        System.out.println(userId);
        userdetails=userDetails.getUserDetails(userId);
        userprodetails=userProfessionalDetails.getUserProfessionalDetails(userId);
        userqualification=userQualification.getUserQualification(userId);
        usertechskills=userTechnicalSkills.getUserTechnicalSkills(userId);
        userworkexp=userWorkExperience.getUserWorkExperience(userId);
        //System.out.println(userqualification.size());
        
    }
    
    
}
