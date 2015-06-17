/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import db.SmuUserPersonalDetails;
import javax.ejb.Local;

/**
 *
 * @author jay
 */
@Local
public interface UserPersonalDetailsLocal {
    public SmuUserPersonalDetails getUserPersonalDetails(int id);
    public void deletePersonalDetails(SmuUserPersonalDetails PersonalDetails);
    public SmuUserPersonalDetails updatePersonalDetails(SmuUserPersonalDetails PersonalDetails);
    public void createPersonalDetails(SmuUserPersonalDetails PersonalDetails);
}
