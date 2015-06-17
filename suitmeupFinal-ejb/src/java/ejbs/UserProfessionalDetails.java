/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import db.SmuUserProfessionalDetails;
import db.SmuUserDetails;
import db.SmuUserPersonalDetails;
import db.SmuUserProfessionalDetails;
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
public class UserProfessionalDetails implements UserProfessionalDetailsLocal {
    @PersistenceContext(unitName = "suitmeupFinal-ejbPU")
    private EntityManager em;

    public SmuUserProfessionalDetails getUserProfessionalDetails(int id){
        Query q=em.createNamedQuery("SmuUserProfessionalDetails.findByUcUserId",SmuUserPersonalDetails.class);
        q.setParameter("ucUserId",id);
        SmuUserProfessionalDetails userProfessional;
        try{
            userProfessional=(SmuUserProfessionalDetails) q.getSingleResult();
        }
        catch(NoResultException e){
            userProfessional=null;
        }
        return userProfessional;
    }
    
    @Override
    public void deleteProfessionalDetails(SmuUserProfessionalDetails ProfessionalDetails){
        if(ProfessionalDetails!=null){
            SmuUserProfessionalDetails s=em.merge(ProfessionalDetails);
            em.remove(s); 
        }
    }
    
    @Override
    public SmuUserProfessionalDetails updateProfessionalDetails(SmuUserProfessionalDetails ProfessionalDetails){
        if(ProfessionalDetails!=null){
            SmuUserProfessionalDetails s=em.merge(ProfessionalDetails);
            return s;
        }
        return null;
    }
    @Override
    public void createProfessionalDetails(SmuUserProfessionalDetails ProfessionalDetails){
         if(ProfessionalDetails!=null){
           em.persist(ProfessionalDetails);
        }
    }
    
    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
