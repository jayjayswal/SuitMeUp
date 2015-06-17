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
public class SmuUserCoverPicturePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "uc_user_id")
    private int ucUserId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ucp_cover_id")
    private int ucpCoverId;

    public SmuUserCoverPicturePK() {
    }

    public SmuUserCoverPicturePK(int ucUserId, int ucpCoverId) {
        this.ucUserId = ucUserId;
        this.ucpCoverId = ucpCoverId;
    }

    public int getUcUserId() {
        return ucUserId;
    }

    public void setUcUserId(int ucUserId) {
        this.ucUserId = ucUserId;
    }

    public int getUcpCoverId() {
        return ucpCoverId;
    }

    public void setUcpCoverId(int ucpCoverId) {
        this.ucpCoverId = ucpCoverId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ucUserId;
        hash += (int) ucpCoverId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmuUserCoverPicturePK)) {
            return false;
        }
        SmuUserCoverPicturePK other = (SmuUserCoverPicturePK) object;
        if (this.ucUserId != other.ucUserId) {
            return false;
        }
        if (this.ucpCoverId != other.ucpCoverId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.SmuUserCoverPicturePK[ ucUserId=" + ucUserId + ", ucpCoverId=" + ucpCoverId + " ]";
    }
    
}
