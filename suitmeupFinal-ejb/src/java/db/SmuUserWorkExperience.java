/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jay
 */
@Entity
@Table(name = "smu_user_work_experience")
@NamedQueries({
    @NamedQuery(name = "SmuUserWorkExperience.findAll", query = "SELECT s FROM SmuUserWorkExperience s"),
    @NamedQuery(name = "SmuUserWorkExperience.findByUcUserId", query = "SELECT s FROM SmuUserWorkExperience s WHERE s.smuUserWorkExperiencePK.ucUserId = :ucUserId ORDER BY s.uweExperienceStartDate DESC"),
    @NamedQuery(name = "SmuUserWorkExperience.findByUweExperienceId", query = "SELECT s FROM SmuUserWorkExperience s WHERE s.smuUserWorkExperiencePK.uweExperienceId = :uweExperienceId"),
    @NamedQuery(name = "SmuUserWorkExperience.findByUweExperienceCompanyName", query = "SELECT s FROM SmuUserWorkExperience s WHERE s.uweExperienceCompanyName = :uweExperienceCompanyName"),
    @NamedQuery(name = "SmuUserWorkExperience.findByUweExperienceOneLineDescription", query = "SELECT s FROM SmuUserWorkExperience s WHERE s.uweExperienceOneLineDescription = :uweExperienceOneLineDescription"),
    @NamedQuery(name = "SmuUserWorkExperience.findByUweExperienceDesignation", query = "SELECT s FROM SmuUserWorkExperience s WHERE s.uweExperienceDesignation = :uweExperienceDesignation"),
    @NamedQuery(name = "SmuUserWorkExperience.findByUweExperienceStartDate", query = "SELECT s FROM SmuUserWorkExperience s WHERE s.uweExperienceStartDate = :uweExperienceStartDate"),
    @NamedQuery(name = "SmuUserWorkExperience.findByUweExperienceEndDate", query = "SELECT s FROM SmuUserWorkExperience s WHERE s.uweExperienceEndDate = :uweExperienceEndDate")})
public class SmuUserWorkExperience implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SmuUserWorkExperiencePK smuUserWorkExperiencePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "uwe_experience_company_name")
    private String uweExperienceCompanyName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "uwe_experience_one_line_description")
    private String uweExperienceOneLineDescription;
    @Size(max = 50)
    @Column(name = "uwe_experience_designation")
    private String uweExperienceDesignation;
    @Column(name = "uwe_experience_start_date")
    @Temporal(TemporalType.DATE)
    private Date uweExperienceStartDate;
    @Column(name = "uwe_experience_end_date")
    @Temporal(TemporalType.DATE)
    private Date uweExperienceEndDate;
    @JoinColumn(name = "uc_user_id", referencedColumnName = "uc_user_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SmuUserCredentials smuUserCredentials;

    public SmuUserWorkExperience() {
    }

    public SmuUserWorkExperience(SmuUserWorkExperiencePK smuUserWorkExperiencePK) {
        this.smuUserWorkExperiencePK = smuUserWorkExperiencePK;
    }

    public SmuUserWorkExperience(SmuUserWorkExperiencePK smuUserWorkExperiencePK, String uweExperienceCompanyName, String uweExperienceOneLineDescription) {
        this.smuUserWorkExperiencePK = smuUserWorkExperiencePK;
        this.uweExperienceCompanyName = uweExperienceCompanyName;
        this.uweExperienceOneLineDescription = uweExperienceOneLineDescription;
    }

    public SmuUserWorkExperience(int ucUserId, int uweExperienceId) {
        this.smuUserWorkExperiencePK = new SmuUserWorkExperiencePK(ucUserId, uweExperienceId);
    }

    public SmuUserWorkExperiencePK getSmuUserWorkExperiencePK() {
        return smuUserWorkExperiencePK;
    }

    public void setSmuUserWorkExperiencePK(SmuUserWorkExperiencePK smuUserWorkExperiencePK) {
        this.smuUserWorkExperiencePK = smuUserWorkExperiencePK;
    }

    public String getUweExperienceCompanyName() {
        return uweExperienceCompanyName;
    }

    public void setUweExperienceCompanyName(String uweExperienceCompanyName) {
        this.uweExperienceCompanyName = uweExperienceCompanyName;
    }

    public String getUweExperienceOneLineDescription() {
        return uweExperienceOneLineDescription;
    }

    public void setUweExperienceOneLineDescription(String uweExperienceOneLineDescription) {
        this.uweExperienceOneLineDescription = uweExperienceOneLineDescription;
    }

    public String getUweExperienceDesignation() {
        return uweExperienceDesignation;
    }

    public void setUweExperienceDesignation(String uweExperienceDesignation) {
        this.uweExperienceDesignation = uweExperienceDesignation;
    }

    public Date getUweExperienceStartDate() {
        return uweExperienceStartDate;
    }

    public void setUweExperienceStartDate(Date uweExperienceStartDate) {
        this.uweExperienceStartDate = uweExperienceStartDate;
    }

    public Date getUweExperienceEndDate() {
        return uweExperienceEndDate;
    }

    public void setUweExperienceEndDate(Date uweExperienceEndDate) {
        this.uweExperienceEndDate = uweExperienceEndDate;
    }

    public SmuUserCredentials getSmuUserCredentials() {
        return smuUserCredentials;
    }

    public void setSmuUserCredentials(SmuUserCredentials smuUserCredentials) {
        this.smuUserCredentials = smuUserCredentials;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (smuUserWorkExperiencePK != null ? smuUserWorkExperiencePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmuUserWorkExperience)) {
            return false;
        }
        SmuUserWorkExperience other = (SmuUserWorkExperience) object;
        if ((this.smuUserWorkExperiencePK == null && other.smuUserWorkExperiencePK != null) || (this.smuUserWorkExperiencePK != null && !this.smuUserWorkExperiencePK.equals(other.smuUserWorkExperiencePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.SmuUserWorkExperience[ smuUserWorkExperiencePK=" + smuUserWorkExperiencePK + " ]";
    }
    
}
