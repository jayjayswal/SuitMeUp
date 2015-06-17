package db;

import db.SmuUserCredentials;
import db.SmuUserQualificationPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-24T08:43:32")
@StaticMetamodel(SmuUserQualification.class)
public class SmuUserQualification_ { 

    public static volatile SingularAttribute<SmuUserQualification, String> uqQualificationName;
    public static volatile SingularAttribute<SmuUserQualification, String> uqQualificationInstitute;
    public static volatile SingularAttribute<SmuUserQualification, String> uqQualificationOneLineDescription;
    public static volatile SingularAttribute<SmuUserQualification, SmuUserQualificationPK> smuUserQualificationPK;
    public static volatile SingularAttribute<SmuUserQualification, Date> uqQualificationPassingYear;
    public static volatile SingularAttribute<SmuUserQualification, Integer> uqQualificationPercentage;
    public static volatile SingularAttribute<SmuUserQualification, SmuUserCredentials> smuUserCredentials;

}