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
public class SmuUserActivitiesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ua_activity_id")
    private int uaActivityId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uc_user_id")
    private int ucUserId;

    public SmuUserActivitiesPK() {
    }

    public SmuUserActivitiesPK(int uaActivityId, int ucUserId) {
        this.uaActivityId = uaActivityId;
        this.ucUserId = ucUserId;
    }

    public int getUaActivityId() {
        return uaActivityId;
    }

    public void setUaActivityId(int uaActivityId) {
        this.uaActivityId = uaActivityId;
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
        hash += (int) uaActivityId;
        hash += (int) ucUserId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmuUserActivitiesPK)) {
            return false;
        }
        SmuUserActivitiesPK other = (SmuUserActivitiesPK) object;
        if (this.uaActivityId != other.uaActivityId) {
            return false;
        }
        if (this.ucUserId != other.ucUserId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.SmuUserActivitiesPK[ uaActivityId=" + uaActivityId + ", ucUserId=" + ucUserId + " ]";
    }
    
}
