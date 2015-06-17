/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jay
 */
@Entity
@Table(name = "smu_user_achievements")
@NamedQueries({
    @NamedQuery(name = "SmuUserAchievements.findAll", query = "SELECT s FROM SmuUserAchievements s"),
    @NamedQuery(name = "SmuUserAchievements.findByUcUserId", query = "SELECT s FROM SmuUserAchievements s WHERE s.smuUserAchievementsPK.ucUserId = :ucUserId"),
    @NamedQuery(name = "SmuUserAchievements.findByUaAchievementId", query = "SELECT s FROM SmuUserAchievements s WHERE s.smuUserAchievementsPK.uaAchievementId = :uaAchievementId"),
    @NamedQuery(name = "SmuUserAchievements.findByUaAchievementName", query = "SELECT s FROM SmuUserAchievements s WHERE s.uaAchievementName = :uaAchievementName"),
    @NamedQuery(name = "SmuUserAchievements.findByUaAchievementDescription", query = "SELECT s FROM SmuUserAchievements s WHERE s.uaAchievementDescription = :uaAchievementDescription"),
    @NamedQuery(name = "SmuUserAchievements.findByUaAchievementDate", query = "SELECT s FROM SmuUserAchievements s WHERE s.uaAchievementDate = :uaAchievementDate")})
public class SmuUserAchievements implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SmuUserAchievementsPK smuUserAchievementsPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ua_achievement_name")
    private String uaAchievementName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "ua_achievement_description")
    private String uaAchievementDescription;
    @Column(name = "ua_achievement_date")
    @Temporal(TemporalType.DATE)
    private Date uaAchievementDate;
    @JoinColumn(name = "uc_user_id", referencedColumnName = "uc_user_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SmuUserCredentials smuUserCredentials;

    public SmuUserAchievements() {
    }

    public SmuUserAchievements(SmuUserAchievementsPK smuUserAchievementsPK) {
        this.smuUserAchievementsPK = smuUserAchievementsPK;
    }

    public SmuUserAchievements(SmuUserAchievementsPK smuUserAchievementsPK, String uaAchievementName, String uaAchievementDescription) {
        this.smuUserAchievementsPK = smuUserAchievementsPK;
        this.uaAchievementName = uaAchievementName;
        this.uaAchievementDescription = uaAchievementDescription;
    }

    public SmuUserAchievements(int ucUserId, int uaAchievementId) {
        this.smuUserAchievementsPK = new SmuUserAchievementsPK(ucUserId, uaAchievementId);
    }

    public SmuUserAchievementsPK getSmuUserAchievementsPK() {
        return smuUserAchievementsPK;
    }

    public void setSmuUserAchievementsPK(SmuUserAchievementsPK smuUserAchievementsPK) {
        this.smuUserAchievementsPK = smuUserAchievementsPK;
    }

    public String getUaAchievementName() {
        return uaAchievementName;
    }

    public void setUaAchievementName(String uaAchievementName) {
        this.uaAchievementName = uaAchievementName;
    }

    public String getUaAchievementDescription() {
        return uaAchievementDescription;
    }

    public void setUaAchievementDescription(String uaAchievementDescription) {
        this.uaAchievementDescription = uaAchievementDescription;
    }

    public Date getUaAchievementDate() {
        return uaAchievementDate;
    }

    public void setUaAchievementDate(Date uaAchievementDate) {
        this.uaAchievementDate = uaAchievementDate;
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
        hash += (smuUserAchievementsPK != null ? smuUserAchievementsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmuUserAchievements)) {
            return false;
        }
        SmuUserAchievements other = (SmuUserAchievements) object;
        if ((this.smuUserAchievementsPK == null && other.smuUserAchievementsPK != null) || (this.smuUserAchievementsPK != null && !this.smuUserAchievementsPK.equals(other.smuUserAchievementsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.SmuUserAchievements[ smuUserAchievementsPK=" + smuUserAchievementsPK + " ]";
    }
    
}
