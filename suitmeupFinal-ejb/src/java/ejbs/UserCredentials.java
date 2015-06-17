/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import db.SmuUserCredentials;
import db.SmuUserCredentials;
import db.SmuUserDetails;
import java.sql.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jay
 */
@Stateless
public class UserCredentials implements UserCredentialsLocal {
    @PersistenceContext(unitName = "suitmeupFinal-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public String hell(){
        return em.createNamedQuery("SmuUserCredentials.findAll",SmuUserCredentials.class).getResultList().get(0).getUcUserEmail();
    }
    @Override
    public int getUserId(String Uname) {
        Query q=em.createNamedQuery("SmuUserCredentials.findByUcUserUserName",SmuUserCredentials.class);
        q.setParameter("ucUserUserName",Uname);
        SmuUserCredentials user;
        try{
            user=(SmuUserCredentials) q.getSingleResult();
        }
        catch(NoResultException e){
            user=null;
        }
        if(user!=null){
            return user.getUcUserId();
        }
        else{
            return -1;
        }
        
    }
    
     
    @Override
    public void deleteCredentials(SmuUserCredentials Credentials){
        if(Credentials!=null){
            SmuUserCredentials s=em.merge(Credentials);
            em.remove(s); 
        }
    }
    
    @Override
    public SmuUserCredentials updateCredentials(SmuUserCredentials Credentials){
        if(Credentials!=null){
            SmuUserCredentials s=em.merge(Credentials);
            return s;
        }
        return null;
    }
    @Override
    public void createCredentials(SmuUserCredentials Credentials){
         if(Credentials!=null){
           em.persist(Credentials);
        }
    }
    public SmuUserCredentials getUser(int id){
        return em.find(SmuUserCredentials.class, id);
    }

    @Override
    public SmuUserCredentials getUser(String email) {
        Query q=em.createNamedQuery("SmuUserCredentials.findByUcUserEmail",SmuUserCredentials.class);
        q.setParameter("ucUserEmail",email);
        SmuUserCredentials user;
        try{
            user=(SmuUserCredentials) q.getSingleResult();
        }
        catch(NoResultException e){
            user=null;
        }
        return user;
    }
}
