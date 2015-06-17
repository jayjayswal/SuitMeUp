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
@Table(name = "smu_user_cover_picture")
@NamedQueries({
    @NamedQuery(name = "SmuUserCoverPicture.findAll", query = "SELECT s FROM SmuUserCoverPicture s"),
    @NamedQuery(name = "SmuUserCoverPicture.findByUcUserId", query = "SELECT s FROM SmuUserCoverPicture s WHERE s.smuUserCoverPicturePK.ucUserId = :ucUserId"),
    @NamedQuery(name = "SmuUserCoverPicture.findByUcpCoverId", query = "SELECT s FROM SmuUserCoverPicture s WHERE s.smuUserCoverPicturePK.ucpCoverId = :ucpCoverId"),
    @NamedQuery(name = "SmuUserCoverPicture.findByUcpCoverPicturePath", query = "SELECT s FROM SmuUserCoverPicture s WHERE s.ucpCoverPicturePath = :ucpCoverPicturePath")})
public class SmuUserCoverPicture implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SmuUserCoverPicturePK smuUserCoverPicturePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "ucp_cover_picture_path")
    private String ucpCoverPicturePath;
    @JoinColumn(name = "uc_user_id", referencedColumnName = "uc_user_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SmuUserCredentials smuUserCredentials;

    public SmuUserCoverPicture() {
    }

    public SmuUserCoverPicture(SmuUserCoverPicturePK smuUserCoverPicturePK) {
        this.smuUserCoverPicturePK = smuUserCoverPicturePK;
    }

    public SmuUserCoverPicture(SmuUserCoverPicturePK smuUserCoverPicturePK, String ucpCoverPicturePath) {
        this.smuUserCoverPicturePK = smuUserCoverPicturePK;
        this.ucpCoverPicturePath = ucpCoverPicturePath;
    }

    public SmuUserCoverPicture(int ucUserId, int ucpCoverId) {
        this.smuUserCoverPicturePK = new SmuUserCoverPicturePK(ucUserId, ucpCoverId);
    }

    public SmuUserCoverPicturePK getSmuUserCoverPicturePK() {
        return smuUserCoverPicturePK;
    }

    public void setSmuUserCoverPicturePK(SmuUserCoverPicturePK smuUserCoverPicturePK) {
        this.smuUserCoverPicturePK = smuUserCoverPicturePK;
    }

    public String getUcpCoverPicturePath() {
        return ucpCoverPicturePath;
    }

    public void setUcpCoverPicturePath(String ucpCoverPicturePath) {
        this.ucpCoverPicturePath = ucpCoverPicturePath;
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
        hash += (smuUserCoverPicturePK != null ? smuUserCoverPicturePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmuUserCoverPicture)) {
            return false;
        }
        SmuUserCoverPicture other = (SmuUserCoverPicture) object;
        if ((this.smuUserCoverPicturePK == null && other.smuUserCoverPicturePK != null) || (this.smuUserCoverPicturePK != null && !this.smuUserCoverPicturePK.equals(other.smuUserCoverPicturePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.SmuUserCoverPicture[ smuUserCoverPicturePK=" + smuUserCoverPicturePK + " ]";
    }
    
}
