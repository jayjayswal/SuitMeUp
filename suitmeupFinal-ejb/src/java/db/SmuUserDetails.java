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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "smu_user_details")
@NamedQueries({
    @NamedQuery(name = "SmuUserDetails.findAll", query = "SELECT s FROM SmuUserDetails s"),
    @NamedQuery(name = "SmuUserDetails.findByUcUserId", query = "SELECT s FROM SmuUserDetails s WHERE s.ucUserId = :ucUserId"),
    @NamedQuery(name = "SmuUserDetails.findByUdUserFirstName", query = "SELECT s FROM SmuUserDetails s WHERE s.udUserFirstName = :udUserFirstName"),
    @NamedQuery(name = "SmuUserDetails.findByUdUserLastName", query = "SELECT s FROM SmuUserDetails s WHERE s.udUserLastName = :udUserLastName"),
    @NamedQuery(name = "SmuUserDetails.findByUdUserGender", query = "SELECT s FROM SmuUserDetails s WHERE s.udUserGender = :udUserGender"),
    @NamedQuery(name = "SmuUserDetails.findByUdUserDateOfBirth", query = "SELECT s FROM SmuUserDetails s WHERE s.udUserDateOfBirth = :udUserDateOfBirth"),
    @NamedQuery(name = "SmuUserDetails.findByUdUserAddressLineOne", query = "SELECT s FROM SmuUserDetails s WHERE s.udUserAddressLineOne = :udUserAddressLineOne"),
    @NamedQuery(name = "SmuUserDetails.findByUdUserAddressLineTwo", query = "SELECT s FROM SmuUserDetails s WHERE s.udUserAddressLineTwo = :udUserAddressLineTwo"),
    @NamedQuery(name = "SmuUserDetails.findByUdUserCity", query = "SELECT s FROM SmuUserDetails s WHERE s.udUserCity = :udUserCity"),
    @NamedQuery(name = "SmuUserDetails.findByUdUserState", query = "SELECT s FROM SmuUserDetails s WHERE s.udUserState = :udUserState"),
    @NamedQuery(name = "SmuUserDetails.findByUdUserCountry", query = "SELECT s FROM SmuUserDetails s WHERE s.udUserCountry = :udUserCountry"),
    @NamedQuery(name = "SmuUserDetails.findByUdUserPincode", query = "SELECT s FROM SmuUserDetails s WHERE s.udUserPincode = :udUserPincode"),
    @NamedQuery(name = "SmuUserDetails.findByUdUserPhone", query = "SELECT s FROM SmuUserDetails s WHERE s.udUserPhone = :udUserPhone"),
    @NamedQuery(name = "SmuUserDetails.findByUdUserGooglePlusProfile", query = "SELECT s FROM SmuUserDetails s WHERE s.udUserGooglePlusProfile = :udUserGooglePlusProfile"),
    @NamedQuery(name = "SmuUserDetails.findByUdUserFacebookProfile", query = "SELECT s FROM SmuUserDetails s WHERE s.udUserFacebookProfile = :udUserFacebookProfile"),
    @NamedQuery(name = "SmuUserDetails.findByUdUserLinkedinProfile", query = "SELECT s FROM SmuUserDetails s WHERE s.udUserLinkedinProfile = :udUserLinkedinProfile"),
    @NamedQuery(name = "SmuUserDetails.findByUdUserTwitterProfile", query = "SELECT s FROM SmuUserDetails s WHERE s.udUserTwitterProfile = :udUserTwitterProfile"),
    @NamedQuery(name = "SmuUserDetails.findByUdUserLocationLatitude", query = "SELECT s FROM SmuUserDetails s WHERE s.udUserLocationLatitude = :udUserLocationLatitude"),
    @NamedQuery(name = "SmuUserDetails.findByUdUserLocationLongitude", query = "SELECT s FROM SmuUserDetails s WHERE s.udUserLocationLongitude = :udUserLocationLongitude")})
public class SmuUserDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "uc_user_id")
    private Integer ucUserId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ud_user_first_name")
    private String udUserFirstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ud_user_last_name")
    private String udUserLastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "ud_user_gender")
    private String udUserGender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ud_user_date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date udUserDateOfBirth;
    @Size(max = 150)
    @Column(name = "ud_user_address_line_one")
    private String udUserAddressLineOne;
    @Size(max = 150)
    @Column(name = "ud_user_address_line_two")
    private String udUserAddressLineTwo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ud_user_city")
    private String udUserCity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ud_user_state")
    private String udUserState;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ud_user_country")
    private String udUserCountry;
    @Size(max = 10)
    @Column(name = "ud_user_pincode")
    private String udUserPincode;
    @Size(max = 10)
    @Column(name = "ud_user_phone")
    private String udUserPhone;
    @Size(max = 300)
    @Column(name = "ud_user_google_plus_profile")
    private String udUserGooglePlusProfile;
    @Size(max = 300)
    @Column(name = "ud_user_facebook_profile")
    private String udUserFacebookProfile;
    @Size(max = 300)
    @Column(name = "ud_user_linkedin_profile")
    private String udUserLinkedinProfile;
    @Size(max = 300)
    @Column(name = "ud_user_twitter_profile")
    private String udUserTwitterProfile;
    @Size(max = 15)
    @Column(name = "ud_user_location_latitude")
    private String udUserLocationLatitude;
    @Size(max = 15)
    @Column(name = "ud_user_location_longitude")
    private String udUserLocationLongitude;
    @JoinColumn(name = "uc_user_id", referencedColumnName = "uc_user_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private SmuUserCredentials smuUserCredentials;

    public SmuUserDetails() {
    }

    public SmuUserDetails(Integer ucUserId) {
        this.ucUserId = ucUserId;
    }

    public SmuUserDetails(Integer ucUserId, String udUserFirstName, String udUserLastName, String udUserGender, Date udUserDateOfBirth, String udUserCity, String udUserState, String udUserCountry) {
        this.ucUserId = ucUserId;
        this.udUserFirstName = udUserFirstName;
        this.udUserLastName = udUserLastName;
        this.udUserGender = udUserGender;
        this.udUserDateOfBirth = udUserDateOfBirth;
        this.udUserCity = udUserCity;
        this.udUserState = udUserState;
        this.udUserCountry = udUserCountry;
    }

    public Integer getUcUserId() {
        return ucUserId;
    }

    public void setUcUserId(Integer ucUserId) {
        this.ucUserId = ucUserId;
    }

    public String getUdUserFirstName() {
        return udUserFirstName;
    }

    public void setUdUserFirstName(String udUserFirstName) {
        this.udUserFirstName = udUserFirstName;
    }

    public String getUdUserLastName() {
        return udUserLastName;
    }

    public void setUdUserLastName(String udUserLastName) {
        this.udUserLastName = udUserLastName;
    }

    public String getUdUserGender() {
        return udUserGender;
    }

    public void setUdUserGender(String udUserGender) {
        this.udUserGender = udUserGender;
    }

    public Date getUdUserDateOfBirth() {
        return udUserDateOfBirth;
    }

    public void setUdUserDateOfBirth(Date udUserDateOfBirth) {
        this.udUserDateOfBirth = udUserDateOfBirth;
    }

    public String getUdUserAddressLineOne() {
        return udUserAddressLineOne;
    }

    public void setUdUserAddressLineOne(String udUserAddressLineOne) {
        this.udUserAddressLineOne = udUserAddressLineOne;
    }

    public String getUdUserAddressLineTwo() {
        return udUserAddressLineTwo;
    }

    public void setUdUserAddressLineTwo(String udUserAddressLineTwo) {
        this.udUserAddressLineTwo = udUserAddressLineTwo;
    }

    public String getUdUserCity() {
        return udUserCity;
    }

    public void setUdUserCity(String udUserCity) {
        this.udUserCity = udUserCity;
    }

    public String getUdUserState() {
        return udUserState;
    }

    public void setUdUserState(String udUserState) {
        this.udUserState = udUserState;
    }

    public String getUdUserCountry() {
        return udUserCountry;
    }

    public void setUdUserCountry(String udUserCountry) {
        this.udUserCountry = udUserCountry;
    }

    public String getUdUserPincode() {
        return udUserPincode;
    }

    public void setUdUserPincode(String udUserPincode) {
        this.udUserPincode = udUserPincode;
    }

    public String getUdUserPhone() {
        return udUserPhone;
    }

    public void setUdUserPhone(String udUserPhone) {
        this.udUserPhone = udUserPhone;
    }

    public String getUdUserGooglePlusProfile() {
        return udUserGooglePlusProfile;
    }

    public void setUdUserGooglePlusProfile(String udUserGooglePlusProfile) {
        this.udUserGooglePlusProfile = udUserGooglePlusProfile;
    }

    public String getUdUserFacebookProfile() {
        return udUserFacebookProfile;
    }

    public void setUdUserFacebookProfile(String udUserFacebookProfile) {
        this.udUserFacebookProfile = udUserFacebookProfile;
    }

    public String getUdUserLinkedinProfile() {
        return udUserLinkedinProfile;
    }

    public void setUdUserLinkedinProfile(String udUserLinkedinProfile) {
        this.udUserLinkedinProfile = udUserLinkedinProfile;
    }

    public String getUdUserTwitterProfile() {
        return udUserTwitterProfile;
    }

    public void setUdUserTwitterProfile(String udUserTwitterProfile) {
        this.udUserTwitterProfile = udUserTwitterProfile;
    }

    public String getUdUserLocationLatitude() {
        return udUserLocationLatitude;
    }

    public void setUdUserLocationLatitude(String udUserLocationLatitude) {
        this.udUserLocationLatitude = udUserLocationLatitude;
    }

    public String getUdUserLocationLongitude() {
        return udUserLocationLongitude;
    }

    public void setUdUserLocationLongitude(String udUserLocationLongitude) {
        this.udUserLocationLongitude = udUserLocationLongitude;
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
        if (!(object instanceof SmuUserDetails)) {
            return false;
        }
        SmuUserDetails other = (SmuUserDetails) object;
        if ((this.ucUserId == null && other.ucUserId != null) || (this.ucUserId != null && !this.ucUserId.equals(other.ucUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.SmuUserDetails[ ucUserId=" + ucUserId + " ]";
    }
    
}
