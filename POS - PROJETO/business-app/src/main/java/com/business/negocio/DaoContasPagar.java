package com.business.negocio;

import com.business.core.app.Duplicada;
import com.business.core.app.Promissoria;
import com.business.core.app.Status;
import com.business.core.app.Titulo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Fatinha de Sousa
 */
public class DaoContasPagar {

    EntityManager em = Conection.getEntityManager();

    public boolean salvarPromissoria(Promissoria promissoria) {

        try {

            em.getTransaction().begin();
            em.persist(promissoria);
            em.getTransaction().commit();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().getRollbackOnly();
            return false;
        }
    }

    public boolean salvarDuplicada(Duplicada duplicada) {

        try {

            em.getTransaction().begin();
            em.persist(duplicada);
            em.getTransaction().commit();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().getRollbackOnly();
            return false;
        }
    }

    public List<Titulo> listarTitulosPorFornecedor(String fornecedor) {
        Query query = em.createQuery("SELECT t FROM Titulo t where t.fornecedor = :fornecedor");
        query.setParameter("fornecedor", fornecedor);

        return (List<Titulo>) query.getResultList();
    }

    public List<Titulo> listarTitulosPorStatus(Status status) {

        Query query = em.createQuery("SELECT t FROM Titulo t where t.status = :status");
        query.setParameter("status", status);

        return (List<Titulo>) query.getResultList();

    }

    public boolean atualizarTitulo(Titulo titulo) {

        try {
            em.getTransaction().begin();
            em.merge(titulo);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Titulo buscarTitulo(String codigo) {
        try {
            return em.find(Titulo.class, codigo);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
}
