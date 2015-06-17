/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;


import db.SmuUserNonTechnicalSkills;
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
public class UserNonTechnicalSkills implements UserNonTechnicalSkillsLocal {
 
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "suitmeupFinal-ejbPU")
    private EntityManager em;

    @Override
    public List<SmuUserNonTechnicalSkills> getUserTechnicalSkills(int id) {
        Query q=em.createNamedQuery("SmuUserNonTechnicalSkills.findByUcUserId",SmuUserNonTechnicalSkills.class);
        q.setParameter("ucUserId",id);
        List<SmuUserNonTechnicalSkills> userTechnicalSkill=(List<SmuUserNonTechnicalSkills>) q.getResultList();
        if(userTechnicalSkill.isEmpty()){
           userTechnicalSkill=null;
        }
        return userTechnicalSkill;
    }
    
    @Override
    public void deleteSkill(SmuUserNonTechnicalSkills skill){
        if(skill!=null){
            SmuUserNonTechnicalSkills s=em.merge(skill);
            em.remove(s); 
        }
    }
    
    @Override
    public SmuUserNonTechnicalSkills updateSkill(SmuUserNonTechnicalSkills skill){
        if(skill!=null){
            SmuUserNonTechnicalSkills s=em.merge(skill);
            return s;
        }
        return null;
    }
    @Override
    public void createSkill(SmuUserNonTechnicalSkills skill){
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
