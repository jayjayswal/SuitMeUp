package manageBeans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ejbs.UserCredentialsLocal;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author jay
 */
@ManagedBean
@RequestScoped
public class testBean {
    @EJB
    private UserCredentialsLocal userCredentials;

    /**
     * Creates a new instance of testBean
     */
    
    public testBean() {
    }
    public String hell(){
        return userCredentials.hell();
    }
    
}
