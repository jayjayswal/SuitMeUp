/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import db.SmuUserCredentials;
import db.SmuUserDetails;
import db.SmuUserPersonalDetails;
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
public class UserDetails implements UserDetailsLocal {
    @PersistenceContext(unitName = "suitmeupFinal-ejbPU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public SmuUserDetails getUserDetails(int id){
        Query q=em.createNamedQuery("SmuUserDetails.findByUcUserId",SmuUserDetails.class);
        q.setParameter("ucUserId",id);
        SmuUserDetails user;
        try{
            user=(SmuUserDetails) q.getSingleResult();
        }
        catch(NoResultException e){
            user=null;
        }
        return user;
    }
    @Override
    public SmuUserDetails updateUserDetails(SmuUserDetails UserDetails){
        if(UserDetails!=null){
            SmuUserDetails s=em.merge(UserDetails);
            return s;
        }
        return null;
    }
    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public void createUserDetails(SmuUserDetails UserDetails) {
         if(UserDetails!=null){
           em.persist(UserDetails);
        }
    }
}
