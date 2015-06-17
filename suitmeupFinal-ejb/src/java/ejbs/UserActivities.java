/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import db.SmuUserQualification;
import db.SmuUserActivities;
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
public class UserActivities implements UserActivitiesLocal {
 @PersistenceContext(unitName = "suitmeupFinal-ejbPU")
    private EntityManager em;

    @Override
    public List<db.SmuUserActivities> getUserTechnicalActivities(int id) {
        Query q=em.createNamedQuery("SmuUserActivities.findByUcUserId",SmuUserActivities.class);
        q.setParameter("ucUserId",id);
        List<SmuUserActivities> userTechnicalActivities=(List<SmuUserActivities>) q.getResultList();
        if(userTechnicalActivities.isEmpty()){
           userTechnicalActivities=null;
        }
        return userTechnicalActivities;
    }
    
    @Override
    public void deleteActivities(SmuUserActivities skill){
        if(skill!=null){
            SmuUserActivities s=em.merge(skill);
            em.remove(s); 
        }
    }
    
    @Override
    public SmuUserActivities updateActivities(SmuUserActivities skill){
        if(skill!=null){
            SmuUserActivities s=em.merge(skill);
            return s;
        }
        return null;
    }
    @Override
    public void createActivities(SmuUserActivities skill){
         if(skill!=null){
           em.persist(skill);
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }
}
