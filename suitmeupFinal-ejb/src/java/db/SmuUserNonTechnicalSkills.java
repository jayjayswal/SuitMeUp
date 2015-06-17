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
@Table(name = "smu_user_non_technical_skills")
@NamedQueries({
    @NamedQuery(name = "SmuUserNonTechnicalSkills.findAll", query = "SELECT s FROM SmuUserNonTechnicalSkills s"),
    @NamedQuery(name = "SmuUserNonTechnicalSkills.findByUcUserId", query = "SELECT s FROM SmuUserNonTechnicalSkills s WHERE s.smuUserNonTechnicalSkillsPK.ucUserId = :ucUserId"),
    @NamedQuery(name = "SmuUserNonTechnicalSkills.findByUntsSkillId", query = "SELECT s FROM SmuUserNonTechnicalSkills s WHERE s.smuUserNonTechnicalSkillsPK.untsSkillId = :untsSkillId"),
    @NamedQuery(name = "SmuUserNonTechnicalSkills.findByUntsSkillName", query = "SELECT s FROM SmuUserNonTechnicalSkills s WHERE s.untsSkillName = :untsSkillName"),
    @NamedQuery(name = "SmuUserNonTechnicalSkills.findByUntsSkillOneLineDescription", query = "SELECT s FROM SmuUserNonTechnicalSkills s WHERE s.untsSkillOneLineDescription = :untsSkillOneLineDescription"),
    @NamedQuery(name = "SmuUserNonTechnicalSkills.findByUntsSkillPercentage", query = "SELECT s FROM SmuUserNonTechnicalSkills s WHERE s.untsSkillPercentage = :untsSkillPercentage")})
public class SmuUserNonTechnicalSkills implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SmuUserNonTechnicalSkillsPK smuUserNonTechnicalSkillsPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "unts_skill_name")
    private String untsSkillName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "unts_skill_one_line_description")
    private String untsSkillOneLineDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unts_skill_percentage")
    private int untsSkillPercentage;
    @JoinColumn(name = "uc_user_id", referencedColumnName = "uc_user_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SmuUserCredentials smuUserCredentials;

    public SmuUserNonTechnicalSkills() {
    }

    public SmuUserNonTechnicalSkills(SmuUserNonTechnicalSkillsPK smuUserNonTechnicalSkillsPK) {
        this.smuUserNonTechnicalSkillsPK = smuUserNonTechnicalSkillsPK;
    }

    public SmuUserNonTechnicalSkills(SmuUserNonTechnicalSkillsPK smuUserNonTechnicalSkillsPK, String untsSkillName, String untsSkillOneLineDescription, int untsSkillPercentage) {
        this.smuUserNonTechnicalSkillsPK = smuUserNonTechnicalSkillsPK;
        this.untsSkillName = untsSkillName;
        this.untsSkillOneLineDescription = untsSkillOneLineDescription;
        this.untsSkillPercentage = untsSkillPercentage;
    }

    public SmuUserNonTechnicalSkills(int ucUserId, int untsSkillId) {
        this.smuUserNonTechnicalSkillsPK = new SmuUserNonTechnicalSkillsPK(ucUserId, untsSkillId);
    }

    public SmuUserNonTechnicalSkillsPK getSmuUserNonTechnicalSkillsPK() {
        return smuUserNonTechnicalSkillsPK;
    }

    public void setSmuUserNonTechnicalSkillsPK(SmuUserNonTechnicalSkillsPK smuUserNonTechnicalSkillsPK) {
        this.smuUserNonTechnicalSkillsPK = smuUserNonTechnicalSkillsPK;
    }

    public String getUntsSkillName() {
        return untsSkillName;
    }

    public void setUntsSkillName(String untsSkillName) {
        this.untsSkillName = untsSkillName;
    }

    public String getUntsSkillOneLineDescription() {
        return untsSkillOneLineDescription;
    }

    public void setUntsSkillOneLineDescription(String untsSkillOneLineDescription) {
        this.untsSkillOneLineDescription = untsSkillOneLineDescription;
    }

    public int getUntsSkillPercentage() {
        return untsSkillPercentage;
    }

    public void setUntsSkillPercentage(int untsSkillPercentage) {
        this.untsSkillPercentage = untsSkillPercentage;
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
        hash += (smuUserNonTechnicalSkillsPK != null ? smuUserNonTechnicalSkillsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmuUserNonTechnicalSkills)) {
            return false;
        }
        SmuUserNonTechnicalSkills other = (SmuUserNonTechnicalSkills) object;
        if ((this.smuUserNonTechnicalSkillsPK == null && other.smuUserNonTechnicalSkillsPK != null) || (this.smuUserNonTechnicalSkillsPK != null && !this.smuUserNonTechnicalSkillsPK.equals(other.smuUserNonTechnicalSkillsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.SmuUserNonTechnicalSkills[ smuUserNonTechnicalSkillsPK=" + smuUserNonTechnicalSkillsPK + " ]";
    }
    
}
