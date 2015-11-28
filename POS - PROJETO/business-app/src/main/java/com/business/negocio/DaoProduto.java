package com.business.negocio;

import com.business.core.app.Produto;
import javax.persistence.EntityManager;

/**
 *
 * @author Fatinha de Sousa
 */
public class DaoProduto {

    EntityManager em = UnityPersistence.getEntityManager();

    public boolean salvarProduto(Produto produto) {

        try {
            em.getTransaction().begin();
            em.persist(produto);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        }
    }
    
    public boolean atualizarEstoque(Produto produto) {
        
        try {
            em.getTransaction().begin();
            em.merge(produto);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        }
    }
}