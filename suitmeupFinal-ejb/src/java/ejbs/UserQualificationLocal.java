/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import db.SmuUserPersonalDetails;
import db.SmuUserQualification;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jay
 */
@Local
public interface UserQualificationLocal {
    public List<SmuUserQualification> getUserQualification(int id);
    public void deleteQualification(SmuUserQualification Qualification);
    public SmuUserQualification updateQualification(SmuUserQualification Qualification);
    public void createQualification(SmuUserQualification Qualification);
}
