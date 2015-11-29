package com.business.negocio;

import com.business.core.app.Comanda;
import javax.persistence.EntityManager;

/**
 *
 * @author Fatinha de Sousa
 */
public class DaoComanda {

    EntityManager em = Conection.getEntityManager();

    public boolean salvarComanda(Comanda comanda) {

        try {
            em.getTransaction().begin();
            em.persist(comanda);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().getRollbackOnly();
            return false;
        }

    }

    public boolean atualizarComanda(Comanda comanda) {
 
        try {
            em.getTransaction().begin();
            em.merge(comanda);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().getRollbackOnly();
            return false;
        }
    }

}
