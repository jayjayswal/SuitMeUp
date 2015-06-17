package db;

import db.SmuUserCredentials;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-24T08:43:32")
@StaticMetamodel(SmuUserPersonalDetails.class)
public class SmuUserPersonalDetails_ { 

    public static volatile SingularAttribute<SmuUserPersonalDetails, String> updPersonalProfession;
    public static volatile SingularAttribute<SmuUserPersonalDetails, String> updPersonalDescription;
    public static volatile SingularAttribute<SmuUserPersonalDetails, String> updPersonalOneLineDescription;
    public static volatile SingularAttribute<SmuUserPersonalDetails, String> updPersonalPicture;
    public static volatile SingularAttribute<SmuUserPersonalDetails, Integer> ucUserId;
    public static volatile SingularAttribute<SmuUserPersonalDetails, SmuUserCredentials> smuUserCredentials;

}