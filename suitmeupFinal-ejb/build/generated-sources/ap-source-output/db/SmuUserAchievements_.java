package db;

import db.SmuUserAchievementsPK;
import db.SmuUserCredentials;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-24T08:43:32")
@StaticMetamodel(SmuUserAchievements.class)
public class SmuUserAchievements_ { 

    public static volatile SingularAttribute<SmuUserAchievements, SmuUserAchievementsPK> smuUserAchievementsPK;
    public static volatile SingularAttribute<SmuUserAchievements, String> uaAchievementName;
    public static volatile SingularAttribute<SmuUserAchievements, String> uaAchievementDescription;
    public static volatile SingularAttribute<SmuUserAchievements, Date> uaAchievementDate;
    public static volatile SingularAttribute<SmuUserAchievements, SmuUserCredentials> smuUserCredentials;

}