/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageBeans;

import db.SmuUserAchievements;
import db.SmuUserActivities;
import db.SmuUserDetails;
import db.SmuUserNonTechnicalSkills;
import db.SmuUserPersonalDetails;
import db.SmuUserProfessionalDetails;
import db.SmuUserQualification;
import db.SmuUserTechnicalSkills;
import db.SmuUserWorkExperience;
import ejbs.UserAchievementsLocal;
import ejbs.UserActivitiesLocal;
import ejbs.UserCredentialsLocal;
import ejbs.UserDetailsLocal;
import ejbs.UserNonTechnicalSkillsLocal;
import ejbs.UserPersonalDetailsLocal;
import ejbs.UserQualificationLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jay
 */
@ManagedBean(name = "UserLife")
@RequestScoped
public class UserLifePage {
    @EJB
    private UserCredentialsLocal userCredentials;
    @EJB
    private UserDetailsLocal userDetails;
    @EJB
    private UserQualificationLocal userQualification;
    @EJB
    private UserPersonalDetailsLocal userPersonalDetails;
    @EJB
    private UserNonTechnicalSkillsLocal userNonTechnicalSkills;
    @EJB
    private UserActivitiesLocal userActivities;
    @EJB
    private UserAchievementsLocal userAchievements;
    
    int userId=0;
    public SmuUserDetails userdetails;
    public SmuUserPersonalDetails userperdetails;
    public List<SmuUserQualification> userqualification;
    public List<SmuUserNonTechnicalSkills> usernontechskills;
    public List<SmuUserAchievements> userachievements;
    public List<SmuUserActivities> useractivities;

    public SmuUserDetails getUserdetails() {
        return userdetails;
    }

    public void setUserdetails(SmuUserDetails userdetails) {
        this.userdetails = userdetails;
    }

    public SmuUserPersonalDetails getUserperdetails() {
        return userperdetails;
    }

    public void setUserperdetails(SmuUserPersonalDetails userperdetails) {
        this.userperdetails = userperdetails;
    }

    public List<SmuUserQualification> getUserqualification() {
        return userqualification;
    }

    public void setUserqualification(List<SmuUserQualification> userqualification) {
        this.userqualification = userqualification;
    }

    public List<SmuUserNonTechnicalSkills> getUsernontechskills() {
        return usernontechskills;
    }

    public void setUsernontechskills(List<SmuUserNonTechnicalSkills> usernontechskills) {
        this.usernontechskills = usernontechskills;
    }

    public List<SmuUserAchievements> getUserachievements() {
        return userachievements;
    }

    public void setUserachievements(List<SmuUserAchievements> userachievements) {
        this.userachievements = userachievements;
    }

    public List<SmuUserActivities> getUseractivities() {
        return useractivities;
    }

    public void setUseractivities(List<SmuUserActivities> useractivities) {
        this.useractivities = useractivities;
    }
    
    public UserLifePage() {
    }
    public void setValues(){
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        userId=(Integer)request.getAttribute("userId");
        System.out.println(userId);
        userdetails=userDetails.getUserDetails(userId);
        userperdetails=userPersonalDetails.getUserPersonalDetails(userId);
        userqualification=userQualification.getUserQualification(userId);
        usernontechskills=userNonTechnicalSkills.getUserTechnicalSkills(userId);
        useractivities=userActivities.getUserTechnicalActivities(userId);
        userachievements=userAchievements.getUserAchievements(userId);
    }
}
