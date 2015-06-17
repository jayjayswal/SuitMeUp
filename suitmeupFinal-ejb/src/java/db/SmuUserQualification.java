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
@Table(name = "smu_user_qualification")
@NamedQueries({
    @NamedQuery(name = "SmuUserQualification.findAll", query = "SELECT s FROM SmuUserQualification s"),
    @NamedQuery(name = "SmuUserQualification.findByUcUserId", query = "SELECT s FROM SmuUserQualification s WHERE s.smuUserQualificationPK.ucUserId = :ucUserId ORDER BY s.uqQualificationPassingYear DESC"),
    @NamedQuery(name = "SmuUserQualification.findByUqQualificationId", query = "SELECT s FROM SmuUserQualification s WHERE s.smuUserQualificationPK.uqQualificationId = :uqQualificationId"),
    @NamedQuery(name = "SmuUserQualification.findByUqQualificationName", query = "SELECT s FROM SmuUserQualification s WHERE s.uqQualificationName = :uqQualificationName"),
    @NamedQuery(name = "SmuUserQualification.findByUqQualificationInstitute", query = "SELECT s FROM SmuUserQualification s WHERE s.uqQualificationInstitute = :uqQualificationInstitute"),
    @NamedQuery(name = "SmuUserQualification.findByUqQualificationOneLineDescription", query = "SELECT s FROM SmuUserQualification s WHERE s.uqQualificationOneLineDescription = :uqQualificationOneLineDescription"),
    @NamedQuery(name = "SmuUserQualification.findByUqQualificationPassingYear", query = "SELECT s FROM SmuUserQualification s WHERE s.uqQualificationPassingYear = :uqQualificationPassingYear"),
    @NamedQuery(name = "SmuUserQualification.findByUqQualificationPercentage", query = "SELECT s FROM SmuUserQualification s WHERE s.uqQualificationPercentage = :uqQualificationPercentage")})
public class SmuUserQualification implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SmuUserQualificationPK smuUserQualificationPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "uq_qualification_name")
    private String uqQualificationName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "uq_qualification_institute")
    private String uqQualificationInstitute;
    @Size(max = 100)
    @Column(name = "uq_qualification_one_line_description")
    private String uqQualificationOneLineDescription;
    @Column(name = "uq_qualification_passing_year")
    @Temporal(TemporalType.DATE)
    private Date uqQualificationPassingYear;
    @Column(name = "uq_qualification_percentage")
    private Integer uqQualificationPercentage;
    @JoinColumn(name = "uc_user_id", referencedColumnName = "uc_user_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SmuUserCredentials smuUserCredentials;

    public SmuUserQualification() {
    }

    public SmuUserQualification(SmuUserQualificationPK smuUserQualificationPK) {
        this.smuUserQualificationPK = smuUserQualificationPK;
    }

    public SmuUserQualification(SmuUserQualificationPK smuUserQualificationPK, String uqQualificationName, String uqQualificationInstitute) {
        this.smuUserQualificationPK = smuUserQualificationPK;
        this.uqQualificationName = uqQualificationName;
        this.uqQualificationInstitute = uqQualificationInstitute;
    }

    public SmuUserQualification(int ucUserId, int uqQualificationId) {
        this.smuUserQualificationPK = new SmuUserQualificationPK(ucUserId, uqQualificationId);
    }

    public SmuUserQualificationPK getSmuUserQualificationPK() {
        return smuUserQualificationPK;
    }

    public void setSmuUserQualificationPK(SmuUserQualificationPK smuUserQualificationPK) {
        this.smuUserQualificationPK = smuUserQualificationPK;
    }

    public String getUqQualificationName() {
        return uqQualificationName;
    }

    public void setUqQualificationName(String uqQualificationName) {
        this.uqQualificationName = uqQualificationName;
    }

    public String getUqQualificationInstitute() {
        return uqQualificationInstitute;
    }

    public void setUqQualificationInstitute(String uqQualificationInstitute) {
        this.uqQualificationInstitute = uqQualificationInstitute;
    }

    public String getUqQualificationOneLineDescription() {
        return uqQualificationOneLineDescription;
    }

    public void setUqQualificationOneLineDescription(String uqQualificationOneLineDescription) {
        this.uqQualificationOneLineDescription = uqQualificationOneLineDescription;
    }

    public Date getUqQualificationPassingYear() {
        return uqQualificationPassingYear;
    }

    public void setUqQualificationPassingYear(Date uqQualificationPassingYear) {
        this.uqQualificationPassingYear = uqQualificationPassingYear;
    }

    public Integer getUqQualificationPercentage() {
        return uqQualificationPercentage;
    }

    public void setUqQualificationPercentage(Integer uqQualificationPercentage) {
        this.uqQualificationPercentage = uqQualificationPercentage;
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
        hash += (smuUserQualificationPK != null ? smuUserQualificationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmuUserQualification)) {
            return false;
        }
        SmuUserQualification other = (SmuUserQualification) object;
        if ((this.smuUserQualificationPK == null && other.smuUserQualificationPK != null) || (this.smuUserQualificationPK != null && !this.smuUserQualificationPK.equals(other.smuUserQualificationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.SmuUserQualification[ smuUserQualificationPK=" + smuUserQualificationPK + " ]";
    }
    
}
