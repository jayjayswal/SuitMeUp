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
@Table(name = "smu_user_activities")
@NamedQueries({
    @NamedQuery(name = "SmuUserActivities.findAll", query = "SELECT s FROM SmuUserActivities s"),
    @NamedQuery(name = "SmuUserActivities.findByUaActivityId", query = "SELECT s FROM SmuUserActivities s WHERE s.smuUserActivitiesPK.uaActivityId = :uaActivityId"),
    @NamedQuery(name = "SmuUserActivities.findByUaActivityName", query = "SELECT s FROM SmuUserActivities s WHERE s.uaActivityName = :uaActivityName"),
    @NamedQuery(name = "SmuUserActivities.findByUaActivityDescription", query = "SELECT s FROM SmuUserActivities s WHERE s.uaActivityDescription = :uaActivityDescription"),
    @NamedQuery(name = "SmuUserActivities.findByUaActivityDate", query = "SELECT s FROM SmuUserActivities s WHERE s.uaActivityDate = :uaActivityDate"),
    @NamedQuery(name = "SmuUserActivities.findByUcUserId", query = "SELECT s FROM SmuUserActivities s WHERE s.smuUserActivitiesPK.ucUserId = :ucUserId")})
public class SmuUserActivities implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SmuUserActivitiesPK smuUserActivitiesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ua_activity_name")
    private String uaActivityName;
    @Size(max = 300)
    @Column(name = "ua_activity_description")
    private String uaActivityDescription;
    @Column(name = "ua_activity_date")
    @Temporal(TemporalType.DATE)
    private Date uaActivityDate;
    @JoinColumn(name = "uc_user_id", referencedColumnName = "uc_user_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SmuUserCredentials smuUserCredentials;

    public SmuUserActivities() {
    }

    public SmuUserActivities(SmuUserActivitiesPK smuUserActivitiesPK) {
        this.smuUserActivitiesPK = smuUserActivitiesPK;
    }

    public SmuUserActivities(SmuUserActivitiesPK smuUserActivitiesPK, String uaActivityName) {
        this.smuUserActivitiesPK = smuUserActivitiesPK;
        this.uaActivityName = uaActivityName;
    }

    public SmuUserActivities(int uaActivityId, int ucUserId) {
        this.smuUserActivitiesPK = new SmuUserActivitiesPK(uaActivityId, ucUserId);
    }

    public SmuUserActivitiesPK getSmuUserActivitiesPK() {
        return smuUserActivitiesPK;
    }

    public void setSmuUserActivitiesPK(SmuUserActivitiesPK smuUserActivitiesPK) {
        this.smuUserActivitiesPK = smuUserActivitiesPK;
    }

    public String getUaActivityName() {
        return uaActivityName;
    }

    public void setUaActivityName(String uaActivityName) {
        this.uaActivityName = uaActivityName;
    }

    public String getUaActivityDescription() {
        return uaActivityDescription;
    }

    public void setUaActivityDescription(String uaActivityDescription) {
        this.uaActivityDescription = uaActivityDescription;
    }

    public Date getUaActivityDate() {
        return uaActivityDate;
    }

    public void setUaActivityDate(Date uaActivityDate) {
        this.uaActivityDate = uaActivityDate;
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
        hash += (smuUserActivitiesPK != null ? smuUserActivitiesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmuUserActivities)) {
            return false;
        }
        SmuUserActivities other = (SmuUserActivities) object;
        if ((this.smuUserActivitiesPK == null && other.smuUserActivitiesPK != null) || (this.smuUserActivitiesPK != null && !this.smuUserActivitiesPK.equals(other.smuUserActivitiesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.SmuUserActivities[ smuUserActivitiesPK=" + smuUserActivitiesPK + " ]";
    }
    
}
