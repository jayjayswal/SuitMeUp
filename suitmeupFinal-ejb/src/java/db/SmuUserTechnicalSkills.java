/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jay
 */
@Entity
@Table(name = "smu_user_technical_skills")
@NamedQueries({
    @NamedQuery(name = "SmuUserTechnicalSkills.findAll", query = "SELECT s FROM SmuUserTechnicalSkills s"),
    @NamedQuery(name = "SmuUserTechnicalSkills.findByUtsSkillId", query = "SELECT s FROM SmuUserTechnicalSkills s WHERE s.smuUserTechnicalSkillsPK.utsSkillId = :utsSkillId"),
    @NamedQuery(name = "SmuUserTechnicalSkills.findByUcUserId", query = "SELECT s FROM SmuUserTechnicalSkills s WHERE s.smuUserTechnicalSkillsPK.ucUserId = :ucUserId"),
    @NamedQuery(name = "SmuUserTechnicalSkills.findByUtsSkillName", query = "SELECT s FROM SmuUserTechnicalSkills s WHERE s.utsSkillName = :utsSkillName"),
    @NamedQuery(name = "SmuUserTechnicalSkills.findByUtsSkillOneLineDescription", query = "SELECT s FROM SmuUserTechnicalSkills s WHERE s.utsSkillOneLineDescription = :utsSkillOneLineDescription"),
    @NamedQuery(name = "SmuUserTechnicalSkills.findByUtsSkillPercentage", query = "SELECT s FROM SmuUserTechnicalSkills s WHERE s.utsSkillPercentage = :utsSkillPercentage")})
public class SmuUserTechnicalSkills implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SmuUserTechnicalSkillsPK smuUserTechnicalSkillsPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "uts_skill_name")
    private String utsSkillName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "uts_skill_one_line_description")
    private String utsSkillOneLineDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uts_skill_percentage")
    private int utsSkillPercentage;
    @JoinColumn(name = "uc_user_id", referencedColumnName = "uc_user_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SmuUserCredentials smuUserCredentials;

    public SmuUserTechnicalSkills() {
    }

    public SmuUserTechnicalSkills(SmuUserTechnicalSkillsPK smuUserTechnicalSkillsPK) {
        this.smuUserTechnicalSkillsPK = smuUserTechnicalSkillsPK;
    }

    public SmuUserTechnicalSkills(SmuUserTechnicalSkillsPK smuUserTechnicalSkillsPK, String utsSkillName, String utsSkillOneLineDescription, int utsSkillPercentage) {
        this.smuUserTechnicalSkillsPK = smuUserTechnicalSkillsPK;
        this.utsSkillName = utsSkillName;
        this.utsSkillOneLineDescription = utsSkillOneLineDescription;
        this.utsSkillPercentage = utsSkillPercentage;
    }

    public SmuUserTechnicalSkills(int utsSkillId, int ucUserId) {
        this.smuUserTechnicalSkillsPK = new SmuUserTechnicalSkillsPK(utsSkillId, ucUserId);
    }

    public SmuUserTechnicalSkillsPK getSmuUserTechnicalSkillsPK() {
        return smuUserTechnicalSkillsPK;
    }

    public void setSmuUserTechnicalSkillsPK(SmuUserTechnicalSkillsPK smuUserTechnicalSkillsPK) {
        this.smuUserTechnicalSkillsPK = smuUserTechnicalSkillsPK;
    }

    public String getUtsSkillName() {
        return utsSkillName;
    }

    public void setUtsSkillName(String utsSkillName) {
        this.utsSkillName = utsSkillName;
    }

    public String getUtsSkillOneLineDescription() {
        return utsSkillOneLineDescription;
    }

    public void setUtsSkillOneLineDescription(String utsSkillOneLineDescription) {
        this.utsSkillOneLineDescription = utsSkillOneLineDescription;
    }

    public int getUtsSkillPercentage() {
        return utsSkillPercentage;
    }

    public void setUtsSkillPercentage(int utsSkillPercentage) {
        this.utsSkillPercentage = utsSkillPercentage;
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
        hash += (smuUserTechnicalSkillsPK != null ? smuUserTechnicalSkillsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmuUserTechnicalSkills)) {
            return false;
        }
        SmuUserTechnicalSkills other = (SmuUserTechnicalSkills) object;
        if ((this.smuUserTechnicalSkillsPK == null && other.smuUserTechnicalSkillsPK != null) || (this.smuUserTechnicalSkillsPK != null && !this.smuUserTechnicalSkillsPK.equals(other.smuUserTechnicalSkillsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.SmuUserTechnicalSkills[ smuUserTechnicalSkillsPK=" + smuUserTechnicalSkillsPK + " ]";
    }
    
}
