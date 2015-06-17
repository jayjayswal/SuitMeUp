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
@Table(name = "smu_user_personal_details")
@NamedQueries({
    @NamedQuery(name = "SmuUserPersonalDetails.findAll", query = "SELECT s FROM SmuUserPersonalDetails s"),
    @NamedQuery(name = "SmuUserPersonalDetails.findByUcUserId", query = "SELECT s FROM SmuUserPersonalDetails s WHERE s.ucUserId = :ucUserId"),
    @NamedQuery(name = "SmuUserPersonalDetails.findByUpdPersonalOneLineDescription", query = "SELECT s FROM SmuUserPersonalDetails s WHERE s.updPersonalOneLineDescription = :updPersonalOneLineDescription"),
    @NamedQuery(name = "SmuUserPersonalDetails.findByUpdPersonalProfession", query = "SELECT s FROM SmuUserPersonalDetails s WHERE s.updPersonalProfession = :updPersonalProfession"),
    @NamedQuery(name = "SmuUserPersonalDetails.findByUpdPersonalDescription", query = "SELECT s FROM SmuUserPersonalDetails s WHERE s.updPersonalDescription = :updPersonalDescription"),
    @NamedQuery(name = "SmuUserPersonalDetails.findByUpdPersonalPicture", query = "SELECT s FROM SmuUserPersonalDetails s WHERE s.updPersonalPicture = :updPersonalPicture")})
public class SmuUserPersonalDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "uc_user_id")
    private Integer ucUserId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "upd_personal_one_line_description")
    private String updPersonalOneLineDescription;
    @Size(max = 50)
    @Column(name = "upd_personal_profession")
    private String updPersonalProfession;
    @Size(max = 800)
    @Column(name = "upd_personal_description")
    private String updPersonalDescription;
    @Size(max = 300)
    @Column(name = "upd_personal_picture")
    private String updPersonalPicture;
    @JoinColumn(name = "uc_user_id", referencedColumnName = "uc_user_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private SmuUserCredentials smuUserCredentials;

    public SmuUserPersonalDetails() {
    }

    public SmuUserPersonalDetails(Integer ucUserId) {
        this.ucUserId = ucUserId;
    }

    public SmuUserPersonalDetails(Integer ucUserId, String updPersonalOneLineDescription) {
        this.ucUserId = ucUserId;
        this.updPersonalOneLineDescription = updPersonalOneLineDescription;
    }

    public Integer getUcUserId() {
        return ucUserId;
    }

    public void setUcUserId(Integer ucUserId) {
        this.ucUserId = ucUserId;
    }

    public String getUpdPersonalOneLineDescription() {
        return updPersonalOneLineDescription;
    }

    public void setUpdPersonalOneLineDescription(String updPersonalOneLineDescription) {
        this.updPersonalOneLineDescription = updPersonalOneLineDescription;
    }

    public String getUpdPersonalProfession() {
        return updPersonalProfession;
    }

    public void setUpdPersonalProfession(String updPersonalProfession) {
        this.updPersonalProfession = updPersonalProfession;
    }

    public String getUpdPersonalDescription() {
        return updPersonalDescription;
    }

    public void setUpdPersonalDescription(String updPersonalDescription) {
        this.updPersonalDescription = updPersonalDescription;
    }

    public String getUpdPersonalPicture() {
        return updPersonalPicture;
    }

    public void setUpdPersonalPicture(String updPersonalPicture) {
        this.updPersonalPicture = updPersonalPicture;
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
        if (!(object instanceof SmuUserPersonalDetails)) {
            return false;
        }
        SmuUserPersonalDetails other = (SmuUserPersonalDetails) object;
        if ((this.ucUserId == null && other.ucUserId != null) || (this.ucUserId != null && !this.ucUserId.equals(other.ucUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.SmuUserPersonalDetails[ ucUserId=" + ucUserId + " ]";
    }
    
}
