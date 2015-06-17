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
public class SmuUserQualificationPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "uc_user_id")
    private int ucUserId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uq_qualification_id")
    private int uqQualificationId;

    public SmuUserQualificationPK() {
    }

    public SmuUserQualificationPK(int ucUserId, int uqQualificationId) {
        this.ucUserId = ucUserId;
        this.uqQualificationId = uqQualificationId;
    }

    public int getUcUserId() {
        return ucUserId;
    }

    public void setUcUserId(int ucUserId) {
        this.ucUserId = ucUserId;
    }

    public int getUqQualificationId() {
        return uqQualificationId;
    }

    public void setUqQualificationId(int uqQualificationId) {
        this.uqQualificationId = uqQualificationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ucUserId;
        hash += (int) uqQualificationId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmuUserQualificationPK)) {
            return false;
        }
        SmuUserQualificationPK other = (SmuUserQualificationPK) object;
        if (this.ucUserId != other.ucUserId) {
            return false;
        }
        if (this.uqQualificationId != other.uqQualificationId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.SmuUserQualificationPK[ ucUserId=" + ucUserId + ", uqQualificationId=" + uqQualificationId + " ]";
    }
    
}
