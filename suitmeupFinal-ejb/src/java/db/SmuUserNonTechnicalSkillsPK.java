/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jay
 */
@Embeddable
public class SmuUserNonTechnicalSkillsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "uc_user_id")
    private int ucUserId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unts_skill_id")
    private int untsSkillId;

    public SmuUserNonTechnicalSkillsPK() {
    }

    public SmuUserNonTechnicalSkillsPK(int ucUserId, int untsSkillId) {
        this.ucUserId = ucUserId;
        this.untsSkillId = untsSkillId;
    }

    public int getUcUserId() {
        return ucUserId;
    }

    public void setUcUserId(int ucUserId) {
        this.ucUserId = ucUserId;
    }

    public int getUntsSkillId() {
        return untsSkillId;
    }

    public void setUntsSkillId(int untsSkillId) {
        this.untsSkillId = untsSkillId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ucUserId;
        hash += (int) untsSkillId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmuUserNonTechnicalSkillsPK)) {
            return false;
        }
        SmuUserNonTechnicalSkillsPK other = (SmuUserNonTechnicalSkillsPK) object;
        if (this.ucUserId != other.ucUserId) {
            return false;
        }
        if (this.untsSkillId != other.untsSkillId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.SmuUserNonTechnicalSkillsPK[ ucUserId=" + ucUserId + ", untsSkillId=" + untsSkillId + " ]";
    }
    
}
