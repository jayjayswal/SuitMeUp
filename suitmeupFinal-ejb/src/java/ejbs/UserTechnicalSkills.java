/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import db.SmuUserQualification;
import db.SmuUserTechnicalSkills;
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
public class UserTechnicalSkills implements UserTechnicalSkillsLocal {
    @PersistenceContext(unitName = "suitmeupFinal-ejbPU")
    private EntityManager em;

    @Override
    public List<SmuUserTechnicalSkills> getUserTechnicalSkills(int id) {
        Query q=em.createNamedQuery("SmuUserTechnicalSkills.findByUcUserId",SmuUserTechnicalSkills.class);
        q.setParameter("ucUserId",id);
        List<SmuUserTechnicalSkills> userTechnicalSkill=(List<SmuUserTechnicalSkills>) q.getResultList();
        if(userTechnicalSkill.isEmpty()){
           userTechnicalSkill=null;
        }
        return userTechnicalSkill;
    }
    
    @Override
    public void deleteSkill(SmuUserTechnicalSkills skill){
        if(skill!=null){
            SmuUserTechnicalSkills s=em.merge(skill);
            em.remove(s); 
        }
    }
    
    @Override
    public SmuUserTechnicalSkills updateSkill(SmuUserTechnicalSkills skill){
        if(skill!=null){
            SmuUserTechnicalSkills s=em.merge(skill);
            return s;
        }
        return null;
    }
    @Override
    public void createSkill(SmuUserTechnicalSkills skill){
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
