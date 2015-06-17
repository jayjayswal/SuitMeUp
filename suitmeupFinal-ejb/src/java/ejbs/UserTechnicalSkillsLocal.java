/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import db.SmuUserQualification;
import db.SmuUserTechnicalSkills;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jay
 */
@Local
public interface UserTechnicalSkillsLocal {
    public List<SmuUserTechnicalSkills> getUserTechnicalSkills(int id);
    public void deleteSkill(SmuUserTechnicalSkills skill);
    public SmuUserTechnicalSkills updateSkill(SmuUserTechnicalSkills skill);
    public void createSkill(SmuUserTechnicalSkills skill);
}
