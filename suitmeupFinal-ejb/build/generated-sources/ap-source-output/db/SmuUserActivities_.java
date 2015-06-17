package db;

import db.SmuUserActivitiesPK;
import db.SmuUserCredentials;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-24T08:43:32")
@StaticMetamodel(SmuUserActivities.class)
public class SmuUserActivities_ { 

    public static volatile SingularAttribute<SmuUserActivities, String> uaActivityName;
    public static volatile SingularAttribute<SmuUserActivities, Date> uaActivityDate;
    public static volatile SingularAttribute<SmuUserActivities, SmuUserActivitiesPK> smuUserActivitiesPK;
    public static volatile SingularAttribute<SmuUserActivities, String> uaActivityDescription;
    public static volatile SingularAttribute<SmuUserActivities, SmuUserCredentials> smuUserCredentials;

}