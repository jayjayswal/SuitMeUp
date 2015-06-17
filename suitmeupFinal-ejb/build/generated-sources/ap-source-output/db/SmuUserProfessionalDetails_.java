package db;

import db.SmuUserCredentials;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-24T08:43:32")
@StaticMetamodel(SmuUserProfessionalDetails.class)
public class SmuUserProfessionalDetails_ { 

    public static volatile SingularAttribute<SmuUserProfessionalDetails, String> updProfessionalDescription;
    public static volatile SingularAttribute<SmuUserProfessionalDetails, String> updProfessionalPicture;
    public static volatile SingularAttribute<SmuUserProfessionalDetails, Integer> ucUserId;
    public static volatile SingularAttribute<SmuUserProfessionalDetails, String> updProfessionalProfession;
    public static volatile SingularAttribute<SmuUserProfessionalDetails, String> updProfessionalOneLineDescription;
    public static volatile SingularAttribute<SmuUserProfessionalDetails, SmuUserCredentials> smuUserCredentials;

}