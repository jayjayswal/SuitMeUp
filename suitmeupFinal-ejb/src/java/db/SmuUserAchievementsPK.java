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
public class SmuUserAchievementsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "uc_user_id")
    private int ucUserId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ua_achievement_id")
    private int uaAchievementId;

    public SmuUserAchievementsPK() {
    }

    public SmuUserAchievementsPK(int ucUserId, int uaAchievementId) {
        this.ucUserId = ucUserId;
        this.uaAchievementId = uaAchievementId;
    }

    public int getUcUserId() {
        return ucUserId;
    }

    public void setUcUserId(int ucUserId) {
        this.ucUserId = ucUserId;
    }

    public int getUaAchievementId() {
        return uaAchievementId;
    }

    public void setUaAchievementId(int uaAchievementId) {
        this.uaAchievementId = uaAchievementId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ucUserId;
        hash += (int) uaAchievementId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmuUserAchievementsPK)) {
            return false;
        }
        SmuUserAchievementsPK other = (SmuUserAchievementsPK) object;
        if (this.ucUserId != other.ucUserId) {
            return false;
        }
        if (this.uaAchievementId != other.uaAchievementId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.SmuUserAchievementsPK[ ucUserId=" + ucUserId + ", uaAchievementId=" + uaAchievementId + " ]";
    }
    
}
