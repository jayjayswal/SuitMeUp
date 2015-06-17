/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import db.SmuUserAchievements;
import db.SmuUserQualification;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jay
 */
@Local
public interface UserAchievementsLocal {
     public List<SmuUserAchievements> getUserAchievements(int id);
     public void deleteAchievements(SmuUserAchievements Achievements);
     public SmuUserAchievements updateAchievements(SmuUserAchievements Achievements);
     public void createAchievements(SmuUserAchievements Achievements);
}
