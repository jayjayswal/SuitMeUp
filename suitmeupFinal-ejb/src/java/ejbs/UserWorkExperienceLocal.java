/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import db.SmuUserTechnicalSkills;
import db.SmuUserWorkExperience;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jay
 */
@Local
public interface UserWorkExperienceLocal {
     public List<SmuUserWorkExperience> getUserWorkExperience(int id);
     public void deleteExperience(SmuUserWorkExperience Experience);
      public void createExperience(SmuUserWorkExperience Experience);
       public SmuUserWorkExperience updateExperience(SmuUserWorkExperience Experience);
}
