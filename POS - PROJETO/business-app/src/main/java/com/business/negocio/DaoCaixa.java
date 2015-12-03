package com.business.negocio;

import com.business.core.app.Caixa;
import javax.persistence.EntityManager;

/**
 *
 * @author Fatinha de Sousa
 */
public class DaoCaixa {

    EntityManager em = Conection.getEntityManager();
    
    public boolean atualizarCaixa(Caixa caixa){
        
        try {
            em.getTransaction().begin();
            em.merge(caixa);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
            return false;
        }
    }
    
    public boolean salvarCaixa(Caixa caixa){
        try {
            em.getTransaction().begin();
            em.persist(caixa);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Caixa getCaixa(int codigo){
        
        try {
            return em.find(Caixa.class, codigo);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
}
