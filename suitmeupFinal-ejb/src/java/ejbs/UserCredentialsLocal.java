/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import db.SmuUserCredentials;
import javax.ejb.Local;

/**
 *
 * @author jay
 */
@Local
public interface UserCredentialsLocal {
     public String hell();

    int getUserId(String Uname);
    public SmuUserCredentials getUser(int id);
    public SmuUserCredentials getUser(String email);
    public void deleteCredentials(SmuUserCredentials Credentials);
    public SmuUserCredentials updateCredentials(SmuUserCredentials Credentials);
    public void createCredentials(SmuUserCredentials Credentials);
}
