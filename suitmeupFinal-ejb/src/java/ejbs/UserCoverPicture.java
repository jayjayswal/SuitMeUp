/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import db.SmuUserCoverPicture;
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
public class UserCoverPicture implements UserCoverPictureLocal {
@PersistenceContext(unitName = "suitmeupFinal-ejbPU")
    private EntityManager em;

    @Override
    public List<db.SmuUserCoverPicture> getUserCoverPicture(int id) {
        Query q=em.createNamedQuery("SmuUserCoverPicture.findByUcUserId",SmuUserCoverPicture.class);
        q.setParameter("ucUserId",id);
        List<SmuUserCoverPicture> userCoverPicture=(List<SmuUserCoverPicture>) q.getResultList();
        if(userCoverPicture.isEmpty()){
           userCoverPicture=null;
        }
        return userCoverPicture;
    }
    
    @Override
    public void deleteCoverPicture(SmuUserCoverPicture CoverPicture){
        if(CoverPicture!=null){
            SmuUserCoverPicture s=em.merge(CoverPicture);
            em.remove(s); 
        }
    }
    
    @Override
    public SmuUserCoverPicture updateCoverPicture(SmuUserCoverPicture CoverPicture){
        if(CoverPicture!=null){
            SmuUserCoverPicture s=em.merge(CoverPicture);
            return s;
        }
        return null;
    }
    @Override
    public void createCoverPicture(SmuUserCoverPicture CoverPicture){
         if(CoverPicture!=null){
           em.persist(CoverPicture);
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }
}
