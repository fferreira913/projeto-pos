package com.business.negocio;

import com.business.core.app.Pedido;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Fatinha de Sousa
 */
public class DaoPedido {

    EntityManager em = Conection.getEntityManager();

    public boolean salvarPedido(Pedido pedido) {

        try {
            em.getTransaction().begin();
            em.persist(pedido);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean atualizarPedido(Pedido pedido) {

        try {
            em.getTransaction().begin();
            em.merge(pedido);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Pedido buscarPedido(int codigo) {

        try {
            return em.find(Pedido.class, codigo);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Pedido> listarPedidosPorComanda(int comanda) {
        Query query = em.createQuery("select p from Pedido p where p.comanda = :comanda");
        query.setParameter("comanda", comanda);

        return (List<Pedido>) query.getResultList();
    }

    public double totalComanda(int comanda) {
        
        List<Pedido> pedidos = listarPedidosPorComanda(comanda);
        
        double total = 0;

        for (Pedido pedido : pedidos) {
            total += pedido.getQuantidade() * pedido.getProduto().getPreco();
        }

        return total;

    }

    public boolean deletarComanda(int comanda) {
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("DELETE FROM Pedido p WHERE p.comanda = :comanda");
            query.setParameter("comanda", comanda);
            query.executeUpdate();
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            //e.getMessage();
            return false;
        }
    }
    
}
