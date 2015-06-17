package db;

import db.SmuUserCredentials;
import db.SmuUserWorkExperiencePK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-24T08:43:32")
@StaticMetamodel(SmuUserWorkExperience.class)
public class SmuUserWorkExperience_ { 

    public static volatile SingularAttribute<SmuUserWorkExperience, String> uweExperienceOneLineDescription;
    public static volatile SingularAttribute<SmuUserWorkExperience, String> uweExperienceDesignation;
    public static volatile SingularAttribute<SmuUserWorkExperience, Date> uweExperienceEndDate;
    public static volatile SingularAttribute<SmuUserWorkExperience, SmuUserWorkExperiencePK> smuUserWorkExperiencePK;
    public static volatile SingularAttribute<SmuUserWorkExperience, String> uweExperienceCompanyName;
    public static volatile SingularAttribute<SmuUserWorkExperience, Date> uweExperienceStartDate;
    public static volatile SingularAttribute<SmuUserWorkExperience, SmuUserCredentials> smuUserCredentials;

}