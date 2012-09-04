/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.tipoAvaliacao;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.AbstractFacade;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rkuninari
 */
@Stateless
public class TipoAvaliacaoFacade extends AbstractFacade<TipoAvaliacao> implements TipoAvaliacaoFacadeLocal
{
    @PersistenceContext(unitName = "SIGSchool-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager()
    {
        return em;
    }

    public TipoAvaliacaoFacade()
    {
        super(TipoAvaliacao.class);
    }

    @Override
    public List<TipoAvaliacao> findAll()
    {
        List<TipoAvaliacao> list = executeQuery("FROM  TipoAvaliacao", 0, null);
        return list;
    }

    @Override
    public List<TipoAvaliacao> findRange(int[] range)
    {
        List<TipoAvaliacao> list = executeQuery("FROM  TipoAvaliacao", 0, null);
        return list;
    }

    @Override
    public int count()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TipoAvaliacao find(String descricao)
    {

        TipoAvaliacao objeto = null;
        HashMap<String, String> par = new HashMap<String, String>();
        par.put("n", descricao);

        objeto = executeQuerySingleResult("SELECT t FROM TipoAvaliacao t WHERE t.descricao =:n", par);

        return objeto;
    }

    @Override
    public List<TipoAvaliacao> find(int idHistoricoNotas)
    {
        String select = "Select t FROM TipoAvaliacao t WHERE t.historicoNotas.id= " + idHistoricoNotas;
        List<TipoAvaliacao> list = executeQuerySingleList(select);
        return list;
    }
}
