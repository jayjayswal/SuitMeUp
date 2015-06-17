/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import db.SmuUserActivities;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jay
 */
@Local
public interface UserActivitiesLocal {
    public List<db.SmuUserActivities> getUserTechnicalActivities(int id);
    public void deleteActivities(SmuUserActivities skill); public SmuUserActivities updateActivities(SmuUserActivities skill);
    public void createActivities(SmuUserActivities skill);
}
