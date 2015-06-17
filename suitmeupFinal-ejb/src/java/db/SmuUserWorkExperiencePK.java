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
public class SmuUserWorkExperiencePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "uc_user_id")
    private int ucUserId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uwe_experience_id")
    private int uweExperienceId;

    public SmuUserWorkExperiencePK() {
    }

    public SmuUserWorkExperiencePK(int ucUserId, int uweExperienceId) {
        this.ucUserId = ucUserId;
        this.uweExperienceId = uweExperienceId;
    }

    public int getUcUserId() {
        return ucUserId;
    }

    public void setUcUserId(int ucUserId) {
        this.ucUserId = ucUserId;
    }

    public int getUweExperienceId() {
        return uweExperienceId;
    }

    public void setUweExperienceId(int uweExperienceId) {
        this.uweExperienceId = uweExperienceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ucUserId;
        hash += (int) uweExperienceId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmuUserWorkExperiencePK)) {
            return false;
        }
        SmuUserWorkExperiencePK other = (SmuUserWorkExperiencePK) object;
        if (this.ucUserId != other.ucUserId) {
            return false;
        }
        if (this.uweExperienceId != other.uweExperienceId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.SmuUserWorkExperiencePK[ ucUserId=" + ucUserId + ", uweExperienceId=" + uweExperienceId + " ]";
    }
    
}
