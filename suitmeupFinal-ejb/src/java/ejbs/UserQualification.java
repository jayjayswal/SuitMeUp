/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import db.SmuUserPersonalDetails;
import db.SmuUserQualification;
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
public class UserQualification implements UserQualificationLocal {
    @PersistenceContext(unitName = "suitmeupFinal-ejbPU")
    private EntityManager em;

    
    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<SmuUserQualification> getUserQualification(int id) {
        Query q=em.createNamedQuery("SmuUserQualification.findByUcUserId",SmuUserQualification.class);
        q.setParameter("ucUserId",id);
        List<SmuUserQualification> userQualification;
        userQualification=(List<SmuUserQualification>) q.getResultList();
        if(userQualification.isEmpty()){
            userQualification=null;
        }
        return userQualification;
    }
    
     @Override
    public void deleteQualification(SmuUserQualification Qualification){
        if(Qualification!=null){
            SmuUserQualification s=em.merge(Qualification);
            em.remove(s); 
        }
    }
    
    @Override
    public SmuUserQualification updateQualification(SmuUserQualification Qualification){
        if(Qualification!=null){
            SmuUserQualification s=em.merge(Qualification);
            return s;
        }
        return null;
    }
    @Override 
    public void createQualification(SmuUserQualification Qualification){
         if(Qualification!=null){
           em.persist(Qualification);
        }
    }

}
