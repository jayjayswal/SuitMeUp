/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jay
 */
@Entity
@Table(name = "smu_user_credentials")
@NamedQueries({
    @NamedQuery(name = "SmuUserCredentials.findAll", query = "SELECT s FROM SmuUserCredentials s"),
    @NamedQuery(name = "SmuUserCredentials.findByUcUserId", query = "SELECT s FROM SmuUserCredentials s WHERE s.ucUserId = :ucUserId"),
    @NamedQuery(name = "SmuUserCredentials.findByUcUserUserName", query = "SELECT s FROM SmuUserCredentials s WHERE s.ucUserUserName = :ucUserUserName"),
    @NamedQuery(name = "SmuUserCredentials.findByUcUserEmail", query = "SELECT s FROM SmuUserCredentials s WHERE s.ucUserEmail = :ucUserEmail"),
    @NamedQuery(name = "SmuUserCredentials.findByUcUserPassword", query = "SELECT s FROM SmuUserCredentials s WHERE s.ucUserPassword = :ucUserPassword")})
public class SmuUserCredentials implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uc_user_id")
    private Integer ucUserId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "uc_user_user_name")
    private String ucUserUserName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "uc_user_email")
    private String ucUserEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "uc_user_password")
    private String ucUserPassword;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "smuUserCredentials")
    private Collection<SmuUserAchievements> smuUserAchievementsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "smuUserCredentials")
    private Collection<SmuUserQualification> smuUserQualificationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "smuUserCredentials")
    private Collection<SmuUserTechnicalSkills> smuUserTechnicalSkillsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "smuUserCredentials")
    private Collection<SmuUserActivities> smuUserActivitiesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "smuUserCredentials")
    private Collection<SmuUserNonTechnicalSkills> smuUserNonTechnicalSkillsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "smuUserCredentials")
    private Collection<SmuUserCoverPicture> smuUserCoverPictureCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "smuUserCredentials")
    private Collection<SmuUserWorkExperience> smuUserWorkExperienceCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "smuUserCredentials")
    private SmuUserPersonalDetails smuUserPersonalDetails;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "smuUserCredentials")
    private SmuUserDetails smuUserDetails;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "smuUserCredentials")
    private SmuUserProfessionalDetails smuUserProfessionalDetails;

    public SmuUserCredentials() {
    }

    public SmuUserCredentials(Integer ucUserId) {
        this.ucUserId = ucUserId;
    }

    public SmuUserCredentials(Integer ucUserId, String ucUserUserName, String ucUserEmail, String ucUserPassword) {
        this.ucUserId = ucUserId;
        this.ucUserUserName = ucUserUserName;
        this.ucUserEmail = ucUserEmail;
        this.ucUserPassword = ucUserPassword;
    }

    public Integer getUcUserId() {
        return ucUserId;
    }

    public void setUcUserId(Integer ucUserId) {
        this.ucUserId = ucUserId;
    }

    public String getUcUserUserName() {
        return ucUserUserName;
    }

    public void setUcUserUserName(String ucUserUserName) {
        this.ucUserUserName = ucUserUserName;
    }

    public String getUcUserEmail() {
        return ucUserEmail;
    }

    public void setUcUserEmail(String ucUserEmail) {
        this.ucUserEmail = ucUserEmail;
    }

    public String getUcUserPassword() {
        return ucUserPassword;
    }

    public void setUcUserPassword(String ucUserPassword) {
        this.ucUserPassword = ucUserPassword;
    }

    public Collection<SmuUserAchievements> getSmuUserAchievementsCollection() {
        return smuUserAchievementsCollection;
    }

    public void setSmuUserAchievementsCollection(Collection<SmuUserAchievements> smuUserAchievementsCollection) {
        this.smuUserAchievementsCollection = smuUserAchievementsCollection;
    }

    public Collection<SmuUserQualification> getSmuUserQualificationCollection() {
        return smuUserQualificationCollection;
    }

    public void setSmuUserQualificationCollection(Collection<SmuUserQualification> smuUserQualificationCollection) {
        this.smuUserQualificationCollection = smuUserQualificationCollection;
    }

    public Collection<SmuUserTechnicalSkills> getSmuUserTechnicalSkillsCollection() {
        return smuUserTechnicalSkillsCollection;
    }

    public void setSmuUserTechnicalSkillsCollection(Collection<SmuUserTechnicalSkills> smuUserTechnicalSkillsCollection) {
        this.smuUserTechnicalSkillsCollection = smuUserTechnicalSkillsCollection;
    }

    public Collection<SmuUserActivities> getSmuUserActivitiesCollection() {
        return smuUserActivitiesCollection;
    }

    public void setSmuUserActivitiesCollection(Collection<SmuUserActivities> smuUserActivitiesCollection) {
        this.smuUserActivitiesCollection = smuUserActivitiesCollection;
    }

    public Collection<SmuUserNonTechnicalSkills> getSmuUserNonTechnicalSkillsCollection() {
        return smuUserNonTechnicalSkillsCollection;
    }

    public void setSmuUserNonTechnicalSkillsCollection(Collection<SmuUserNonTechnicalSkills> smuUserNonTechnicalSkillsCollection) {
        this.smuUserNonTechnicalSkillsCollection = smuUserNonTechnicalSkillsCollection;
    }

    public Collection<SmuUserCoverPicture> getSmuUserCoverPictureCollection() {
        return smuUserCoverPictureCollection;
    }

    public void setSmuUserCoverPictureCollection(Collection<SmuUserCoverPicture> smuUserCoverPictureCollection) {
        this.smuUserCoverPictureCollection = smuUserCoverPictureCollection;
    }

    public Collection<SmuUserWorkExperience> getSmuUserWorkExperienceCollection() {
        return smuUserWorkExperienceCollection;
    }

    public void setSmuUserWorkExperienceCollection(Collection<SmuUserWorkExperience> smuUserWorkExperienceCollection) {
        this.smuUserWorkExperienceCollection = smuUserWorkExperienceCollection;
    }

    public SmuUserPersonalDetails getSmuUserPersonalDetails() {
        return smuUserPersonalDetails;
    }

    public void setSmuUserPersonalDetails(SmuUserPersonalDetails smuUserPersonalDetails) {
        this.smuUserPersonalDetails = smuUserPersonalDetails;
    }

    public SmuUserDetails getSmuUserDetails() {
        return smuUserDetails;
    }

    public void setSmuUserDetails(SmuUserDetails smuUserDetails) {
        this.smuUserDetails = smuUserDetails;
    }

    public SmuUserProfessionalDetails getSmuUserProfessionalDetails() {
        return smuUserProfessionalDetails;
    }

    public void setSmuUserProfessionalDetails(SmuUserProfessionalDetails smuUserProfessionalDetails) {
        this.smuUserProfessionalDetails = smuUserProfessionalDetails;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ucUserId != null ? ucUserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmuUserCredentials)) {
            return false;
        }
        SmuUserCredentials other = (SmuUserCredentials) object;
        if ((this.ucUserId == null && other.ucUserId != null) || (this.ucUserId != null && !this.ucUserId.equals(other.ucUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.SmuUserCredentials[ ucUserId=" + ucUserId + " ]";
    }
    
}
