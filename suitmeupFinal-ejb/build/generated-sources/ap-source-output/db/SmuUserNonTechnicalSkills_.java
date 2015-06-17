package db;

import db.SmuUserCredentials;
import db.SmuUserNonTechnicalSkillsPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-24T08:43:32")
@StaticMetamodel(SmuUserNonTechnicalSkills.class)
public class SmuUserNonTechnicalSkills_ { 

    public static volatile SingularAttribute<SmuUserNonTechnicalSkills, SmuUserNonTechnicalSkillsPK> smuUserNonTechnicalSkillsPK;
    public static volatile SingularAttribute<SmuUserNonTechnicalSkills, Integer> untsSkillPercentage;
    public static volatile SingularAttribute<SmuUserNonTechnicalSkills, String> untsSkillName;
    public static volatile SingularAttribute<SmuUserNonTechnicalSkills, String> untsSkillOneLineDescription;
    public static volatile SingularAttribute<SmuUserNonTechnicalSkills, SmuUserCredentials> smuUserCredentials;

}