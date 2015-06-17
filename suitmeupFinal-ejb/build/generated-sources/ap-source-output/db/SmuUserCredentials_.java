package db;

import db.SmuUserAchievements;
import db.SmuUserActivities;
import db.SmuUserCoverPicture;
import db.SmuUserDetails;
import db.SmuUserNonTechnicalSkills;
import db.SmuUserPersonalDetails;
import db.SmuUserProfessionalDetails;
import db.SmuUserQualification;
import db.SmuUserTechnicalSkills;
import db.SmuUserWorkExperience;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-24T08:43:32")
@StaticMetamodel(SmuUserCredentials.class)
public class SmuUserCredentials_ { 

    public static volatile CollectionAttribute<SmuUserCredentials, SmuUserCoverPicture> smuUserCoverPictureCollection;
    public static volatile SingularAttribute<SmuUserCredentials, String> ucUserPassword;
    public static volatile CollectionAttribute<SmuUserCredentials, SmuUserNonTechnicalSkills> smuUserNonTechnicalSkillsCollection;
    public static volatile SingularAttribute<SmuUserCredentials, String> ucUserUserName;
    public static volatile CollectionAttribute<SmuUserCredentials, SmuUserAchievements> smuUserAchievementsCollection;
    public static volatile CollectionAttribute<SmuUserCredentials, SmuUserTechnicalSkills> smuUserTechnicalSkillsCollection;
    public static volatile SingularAttribute<SmuUserCredentials, SmuUserProfessionalDetails> smuUserProfessionalDetails;
    public static volatile SingularAttribute<SmuUserCredentials, SmuUserDetails> smuUserDetails;
    public static volatile SingularAttribute<SmuUserCredentials, SmuUserPersonalDetails> smuUserPersonalDetails;
    public static volatile CollectionAttribute<SmuUserCredentials, SmuUserQualification> smuUserQualificationCollection;
    public static volatile CollectionAttribute<SmuUserCredentials, SmuUserActivities> smuUserActivitiesCollection;
    public static volatile SingularAttribute<SmuUserCredentials, Integer> ucUserId;
    public static volatile CollectionAttribute<SmuUserCredentials, SmuUserWorkExperience> smuUserWorkExperienceCollection;
    public static volatile SingularAttribute<SmuUserCredentials, String> ucUserEmail;

}