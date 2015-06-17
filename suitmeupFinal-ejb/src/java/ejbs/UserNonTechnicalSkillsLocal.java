/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import db.SmuUserNonTechnicalSkills;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jay
 */
@Local
public interface UserNonTechnicalSkillsLocal {
     public List<SmuUserNonTechnicalSkills> getUserTechnicalSkills(int id);
     public void deleteSkill(SmuUserNonTechnicalSkills skill);
     public SmuUserNonTechnicalSkills updateSkill(SmuUserNonTechnicalSkills skill);
    public void createSkill(SmuUserNonTechnicalSkills skill);
}
