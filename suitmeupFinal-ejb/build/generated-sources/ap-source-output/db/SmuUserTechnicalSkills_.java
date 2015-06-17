package db;

import db.SmuUserCredentials;
import db.SmuUserTechnicalSkillsPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-24T08:43:32")
@StaticMetamodel(SmuUserTechnicalSkills.class)
public class SmuUserTechnicalSkills_ { 

    public static volatile SingularAttribute<SmuUserTechnicalSkills, String> utsSkillOneLineDescription;
    public static volatile SingularAttribute<SmuUserTechnicalSkills, String> utsSkillName;
    public static volatile SingularAttribute<SmuUserTechnicalSkills, Integer> utsSkillPercentage;
    public static volatile SingularAttribute<SmuUserTechnicalSkills, SmuUserCredentials> smuUserCredentials;
    public static volatile SingularAttribute<SmuUserTechnicalSkills, SmuUserTechnicalSkillsPK> smuUserTechnicalSkillsPK;

}