package com.business.negocio;

import com.business.core.app.Pedido;
import javax.persistence.EntityManager;

/**
 *
 * @author Fatinha de Sousa
 */
public class DaoPedido {
    
    EntityManager em = Conection.getEntityManager();
    
    public boolean salvarPedido(Pedido pedido){
        
        try{
            em.getTransaction().begin();
            em.persist(pedido);
            em.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().getRollbackOnly();
            return false;
        }
    }
    
    public boolean atualizarPedido(Pedido pedido){
        
        try{
            em.getTransaction().begin();
            em.merge(pedido);
            em.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().getRollbackOnly();
            return false;
        }
    }
    
}
