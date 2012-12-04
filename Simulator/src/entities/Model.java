/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Nacer Khalil
 */
public class Model {

    private static final EntityManager manager = Persistence.createEntityManagerFactory("SimulatorPU").createEntityManager();

    public Model() {
    }
    
     
    public void save()
    {
        EntityTransaction tr = manager.getTransaction();
        tr.begin();
        manager.persist(this);

        tr.commit();
    }
    
    public void remove()
    {
        EntityTransaction tr = manager.getTransaction();
        tr.begin();
        manager.remove(this);
        tr.commit();
    }
    
    public static EntityManager getEntityManager()
    {
        return manager;
    }
    
    public void refresh()
    {
        EntityTransaction tr = manager.getTransaction();
        tr.begin();
        manager.refresh(this);
        tr.commit();
    }
    
    public void update()
    {
        EntityTransaction tr = manager.getTransaction();
        tr.begin();
        manager.merge(this);
        tr.commit();
    }
}
