/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import db.SmuUserPersonalDetails;
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
public class UserPersonalDetails implements UserPersonalDetailsLocal {
@PersistenceContext(unitName = "suitmeupFinal-ejbPU")
    private EntityManager em;

    public SmuUserPersonalDetails getUserPersonalDetails(int id){
        Query q=em.createNamedQuery("SmuUserPersonalDetails.findByUcUserId",SmuUserPersonalDetails.class);
        q.setParameter("ucUserId",id);
        SmuUserPersonalDetails userPersonal;
        try{
            userPersonal=(SmuUserPersonalDetails) q.getSingleResult();
        }
        catch(NoResultException e){
            userPersonal=null;
        }
        return userPersonal;
    }
    
    @Override
    public void deletePersonalDetails(SmuUserPersonalDetails PersonalDetails){
        if(PersonalDetails!=null){
            SmuUserPersonalDetails s=em.merge(PersonalDetails);
            em.remove(s); 
        }
    }
    
    @Override
    public SmuUserPersonalDetails updatePersonalDetails(SmuUserPersonalDetails PersonalDetails){
        if(PersonalDetails!=null){
            SmuUserPersonalDetails s=em.merge(PersonalDetails);
            return s;
        }
        return null;
    }
    @Override
    public void createPersonalDetails(SmuUserPersonalDetails PersonalDetails){
         if(PersonalDetails!=null){
           em.persist(PersonalDetails);
        }
    }
    
    public void persist(Object object) {
        em.persist(object);
    }
}
