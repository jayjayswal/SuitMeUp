/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jay
 */
@Entity
@Table(name = "smu_user_professional_details")
@NamedQueries({
    @NamedQuery(name = "SmuUserProfessionalDetails.findAll", query = "SELECT s FROM SmuUserProfessionalDetails s"),
    @NamedQuery(name = "SmuUserProfessionalDetails.findByUcUserId", query = "SELECT s FROM SmuUserProfessionalDetails s WHERE s.ucUserId = :ucUserId"),
    @NamedQuery(name = "SmuUserProfessionalDetails.findByUpdProfessionalOneLineDescription", query = "SELECT s FROM SmuUserProfessionalDetails s WHERE s.updProfessionalOneLineDescription = :updProfessionalOneLineDescription"),
    @NamedQuery(name = "SmuUserProfessionalDetails.findByUpdProfessionalProfession", query = "SELECT s FROM SmuUserProfessionalDetails s WHERE s.updProfessionalProfession = :updProfessionalProfession"),
    @NamedQuery(name = "SmuUserProfessionalDetails.findByUpdProfessionalDescription", query = "SELECT s FROM SmuUserProfessionalDetails s WHERE s.updProfessionalDescription = :updProfessionalDescription"),
    @NamedQuery(name = "SmuUserProfessionalDetails.findByUpdProfessionalPicture", query = "SELECT s FROM SmuUserProfessionalDetails s WHERE s.updProfessionalPicture = :updProfessionalPicture")})
public class SmuUserProfessionalDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "uc_user_id")
    private Integer ucUserId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "upd_professional_one_line_description")
    private String updProfessionalOneLineDescription;
    @Size(max = 50)
    @Column(name = "upd_professional_profession")
    private String updProfessionalProfession;
    @Size(max = 800)
    @Column(name = "upd_professional_description")
    private String updProfessionalDescription;
    @Size(max = 300)
    @Column(name = "upd_professional_picture")
    private String updProfessionalPicture;
    @JoinColumn(name = "uc_user_id", referencedColumnName = "uc_user_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private SmuUserCredentials smuUserCredentials;

    public SmuUserProfessionalDetails() {
    }

    public SmuUserProfessionalDetails(Integer ucUserId) {
        this.ucUserId = ucUserId;
    }

    public SmuUserProfessionalDetails(Integer ucUserId, String updProfessionalOneLineDescription) {
        this.ucUserId = ucUserId;
        this.updProfessionalOneLineDescription = updProfessionalOneLineDescription;
    }

    public Integer getUcUserId() {
        return ucUserId;
    }

    public void setUcUserId(Integer ucUserId) {
        this.ucUserId = ucUserId;
    }

    public String getUpdProfessionalOneLineDescription() {
        return updProfessionalOneLineDescription;
    }

    public void setUpdProfessionalOneLineDescription(String updProfessionalOneLineDescription) {
        this.updProfessionalOneLineDescription = updProfessionalOneLineDescription;
    }

    public String getUpdProfessionalProfession() {
        return updProfessionalProfession;
    }

    public void setUpdProfessionalProfession(String updProfessionalProfession) {
        this.updProfessionalProfession = updProfessionalProfession;
    }

    public String getUpdProfessionalDescription() {
        return updProfessionalDescription;
    }

    public void setUpdProfessionalDescription(String updProfessionalDescription) {
        this.updProfessionalDescription = updProfessionalDescription;
    }

    public String getUpdProfessionalPicture() {
        return updProfessionalPicture;
    }

    public void setUpdProfessionalPicture(String updProfessionalPicture) {
        this.updProfessionalPicture = updProfessionalPicture;
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
        hash += (ucUserId != null ? ucUserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmuUserProfessionalDetails)) {
            return false;
        }
        SmuUserProfessionalDetails other = (SmuUserProfessionalDetails) object;
        if ((this.ucUserId == null && other.ucUserId != null) || (this.ucUserId != null && !this.ucUserId.equals(other.ucUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.SmuUserProfessionalDetails[ ucUserId=" + ucUserId + " ]";
    }
    
}
