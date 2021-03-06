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
public class SmuUserTechnicalSkillsPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "uts_skill_id")
    private int utsSkillId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uc_user_id")
    private int ucUserId;

    public SmuUserTechnicalSkillsPK() {
    }

    public SmuUserTechnicalSkillsPK(int utsSkillId, int ucUserId) {
        this.utsSkillId = utsSkillId;
        this.ucUserId = ucUserId;
    }

    public int getUtsSkillId() {
        return utsSkillId;
    }

    public void setUtsSkillId(int utsSkillId) {
        this.utsSkillId = utsSkillId;
    }

    public int getUcUserId() {
        return ucUserId;
    }

    public void setUcUserId(int ucUserId) {
        this.ucUserId = ucUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) utsSkillId;
        hash += (int) ucUserId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmuUserTechnicalSkillsPK)) {
            return false;
        }
        SmuUserTechnicalSkillsPK other = (SmuUserTechnicalSkillsPK) object;
        if (this.utsSkillId != other.utsSkillId) {
            return false;
        }
        if (this.ucUserId != other.ucUserId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.SmuUserTechnicalSkillsPK[ utsSkillId=" + utsSkillId + ", ucUserId=" + ucUserId + " ]";
    }
    
}
