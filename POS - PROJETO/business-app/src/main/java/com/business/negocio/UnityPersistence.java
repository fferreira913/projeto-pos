package com.business.negocio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Fatinha de Sousa
 */
public class UnityPersistence {

    public static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unity");
        EntityManager em = emf.createEntityManager();

        return em;
    }

}
