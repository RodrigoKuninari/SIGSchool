/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Classe Abstrata com os principais metodos para persistencia de objetos.
 * @author Profa.Jane Eleuterio
 * @version 1.0
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    /**
     * Persiste o objeto no banco de dados (Insert)
     * @param entity  objeto a ser inserido
     */
    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    /**
     * Atualiza os dados do objeto no banco de dados (Update)
     * @param entity objeto a ser atualizado
     */
    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    /**
     * Remove o objeto do banco de dados.
     * @param entity objeto a ser removido
     */
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    /**
     * Busca o objeto pelo identificador
     * @param id identificador do objeto
     * @return objeto encontrado ou null
     */
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    /**
     * Executa uma consulta com um resultado simples (�nico resultado)
     * @param jpQuery consulta em JPQL com seus parametros
     * @param maxResults n�mero m�ximo de resultados esperados. Para n�o
     * utilizar, deve definir o n�mero m�ximo como 0 (zero)
     * @param parameters Map com os nomes dos par�metros e seus valores. OBS:
     * esses par�metros devem ser citados na consulta
     * @return o objeto encontrado ou null
     */
    public List<T> executeQuery(String jpQuery, int maxResults,
            HashMap<String, String> parameters) {
        //Cria a consulta
        Query query = getEntityManager().createQuery(jpQuery);

        //Seta os par�metros
        if (parameters != null && parameters.size() > 0) {
            Set<String> keys = parameters.keySet();
            Iterator<String> iterator = keys.iterator();
            while (iterator.hasNext()) {
                String k = iterator.next();
                if (k != null) {
                    query.setParameter(k, parameters.get(k));
                }
            }
        }
        //Seta o n�mero m�ximo de resultados desejado
        if (maxResults > 0) {
            query.setMaxResults(maxResults);
        }
        //Executa a consulta
        List<T> list;
        try {
            list = query.getResultList();
        } catch (NoResultException e) {
            list = null;
        }
        return list;
    }

    /**
     * Executa uma consulta com um resultado simples (�nico resultado)
     * @param jpQuery consulta em JPQL com seus parametros
     * @param parameters Map com os nomes dos par�metros e seus valores. OBS:
     * esses par�metros devem ser citados na consulta
     * @return o objeto encontrado ou null
     */
    public T executeQuerySingleResult(String jpQuery,
            HashMap<String, String> parameters) {
        //Cria a consulta
        Query query = getEntityManager().createQuery(jpQuery);

        //Seta os par�metros
        Set<String> keys = parameters.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String k = iterator.next();
            if (k != null) {
                query.setParameter(k, parameters.get(k));
            }
        }
        //Executa a consulta
        try {
            return (T) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public T executeQuerySingleResultInteger(String jpQuery) {
        //Cria a consulta
        Query query = getEntityManager().createQuery(jpQuery);

        //Executa a consulta
        try {
            return (T) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public void executeQuerySingleUpdate(String jpQuery)
    {
        Query query = getEntityManager().createQuery(jpQuery);
        query.executeUpdate();
    }
    
    public List<T> executeQuerySingleList(String jpQuery)
    {
        Query query = getEntityManager().createQuery(jpQuery);
        return query.getResultList();
    }
}
