/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import db.SmuUserAchievements;
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
public class UserAchievements implements UserAchievementsLocal {
    @PersistenceContext(unitName = "suitmeupFinal-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    /**
     * get ALL Achievements
     * @param id
     * @return 
     */
    @Override
    public List<SmuUserAchievements> getUserAchievements(int id) {
        Query q=em.createNamedQuery("SmuUserAchievements.findByUcUserId",db.SmuUserAchievements.class);
        q.setParameter("ucUserId",id);
        List<SmuUserAchievements> userAchievements;
        userAchievements=(List<SmuUserAchievements>) q.getResultList();
        if(userAchievements.isEmpty()){
            userAchievements=null;
        }
        return userAchievements;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    /**
     * delete achievements
     * @param Achievements 
     */
    @Override
    public void deleteAchievements(SmuUserAchievements Achievements){
        if(Achievements!=null){
            SmuUserAchievements s=em.merge(Achievements);
            em.remove(s); 
        }
    }
    /**
     * update achievement
     * @param Achievements
     * @return 
     */
    @Override
    public SmuUserAchievements updateAchievements(SmuUserAchievements Achievements){
        if(Achievements!=null){
            SmuUserAchievements s=em.merge(Achievements);
            return s;
        }
        return null;
    }
    
    /**
     * create new achievement
     * @param Achievements 
     */
    @Override
    public void createAchievements(SmuUserAchievements Achievements){
        System.out.println("hello");
         if(Achievements!=null){
           em.persist(Achievements);
        }
    }
}
