/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import db.SmuUserWorkExperience;
import db.SmuUserWorkExperience;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jay
 */
@Stateless
public class UserWorkExperience implements UserWorkExperienceLocal {
    @PersistenceContext(unitName = "suitmeupFinal-ejbPU")
    private EntityManager em;

    @Override
    public List<SmuUserWorkExperience> getUserWorkExperience(int id) {
        Query q=em.createNamedQuery("SmuUserWorkExperience.findByUcUserId",SmuUserWorkExperience.class);
        q.setParameter("ucUserId",id);
        List<SmuUserWorkExperience> userWorkExp=(List<SmuUserWorkExperience>) q.getResultList();
        if(userWorkExp.isEmpty()){
           userWorkExp=null;
        }
        return userWorkExp;
    }
    
      @Override
    public void deleteExperience(SmuUserWorkExperience Experience){
        if(Experience!=null){
            SmuUserWorkExperience s=em.merge(Experience);
            em.remove(s); 
        }
    }
    
    @Override
    public SmuUserWorkExperience updateExperience(SmuUserWorkExperience Experience){
        if(Experience!=null){
            SmuUserWorkExperience s=em.merge(Experience);
            return s;
        }
        return null;
    }
    @Override 
    public void createExperience(SmuUserWorkExperience Experience){
         if(Experience!=null){
           em.persist(Experience);
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }
}
