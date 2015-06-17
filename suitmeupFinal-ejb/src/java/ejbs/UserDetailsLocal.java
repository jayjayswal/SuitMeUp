/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import db.SmuUserDetails;
import javax.ejb.Local;

/**
 *
 * @author jay
 */
@Local
public interface UserDetailsLocal {
      public SmuUserDetails getUserDetails(int id);
      public SmuUserDetails updateUserDetails(SmuUserDetails UserDetails);
      public void createUserDetails(SmuUserDetails UserDetails);
}
