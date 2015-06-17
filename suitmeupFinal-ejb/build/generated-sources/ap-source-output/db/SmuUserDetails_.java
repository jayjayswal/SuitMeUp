package db;

import db.SmuUserCredentials;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-24T08:43:32")
@StaticMetamodel(SmuUserDetails.class)
public class SmuUserDetails_ { 

    public static volatile SingularAttribute<SmuUserDetails, String> udUserPhone;
    public static volatile SingularAttribute<SmuUserDetails, String> udUserAddressLineTwo;
    public static volatile SingularAttribute<SmuUserDetails, String> udUserTwitterProfile;
    public static volatile SingularAttribute<SmuUserDetails, String> udUserGooglePlusProfile;
    public static volatile SingularAttribute<SmuUserDetails, String> udUserCity;
    public static volatile SingularAttribute<SmuUserDetails, String> udUserAddressLineOne;
    public static volatile SingularAttribute<SmuUserDetails, String> udUserLinkedinProfile;
    public static volatile SingularAttribute<SmuUserDetails, String> udUserGender;
    public static volatile SingularAttribute<SmuUserDetails, String> udUserState;
    public static volatile SingularAttribute<SmuUserDetails, String> udUserFirstName;
    public static volatile SingularAttribute<SmuUserDetails, String> udUserCountry;
    public static volatile SingularAttribute<SmuUserDetails, String> udUserLastName;
    public static volatile SingularAttribute<SmuUserDetails, String> udUserLocationLongitude;
    public static volatile SingularAttribute<SmuUserDetails, Date> udUserDateOfBirth;
    public static volatile SingularAttribute<SmuUserDetails, Integer> ucUserId;
    public static volatile SingularAttribute<SmuUserDetails, String> udUserLocationLatitude;
    public static volatile SingularAttribute<SmuUserDetails, String> udUserFacebookProfile;
    public static volatile SingularAttribute<SmuUserDetails, SmuUserCredentials> smuUserCredentials;
    public static volatile SingularAttribute<SmuUserDetails, String> udUserPincode;

}