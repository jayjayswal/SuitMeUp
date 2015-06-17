/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import db.SmuUserPersonalDetails;
import db.SmuUserProfessionalDetails;
import javax.ejb.Local;

/**
 *
 * @author jay
 */
@Local
public interface UserProfessionalDetailsLocal {
    public SmuUserProfessionalDetails getUserProfessionalDetails(int id);
    public void deleteProfessionalDetails(SmuUserProfessionalDetails ProfessionalDetails);
    public SmuUserProfessionalDetails updateProfessionalDetails(SmuUserProfessionalDetails ProfessionalDetails);
    public void createProfessionalDetails(SmuUserProfessionalDetails ProfessionalDetails);
}
