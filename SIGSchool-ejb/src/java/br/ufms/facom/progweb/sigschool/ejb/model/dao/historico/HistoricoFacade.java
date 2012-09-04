/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.historico;

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
public class HistoricoFacade extends AbstractFacade<Historico> implements HistoricoFacadeLocal
{
    @PersistenceContext(unitName = "SIGSchool-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager()
    {
        return em;
    }

    public HistoricoFacade()
    {
        super(Historico.class);
    }

    @Override
    public List<Historico> findAll()
    {
        List<Historico> list = executeQuery("FROM  Historico", 0, null);
        return list;
    }

    @Override
    public List<Historico> findRange(int[] range)
    {
        List<Historico> list = executeQuery("FROM  Historico", 0, null);
        return list;
    }

    @Override
    public int count()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Historico find(int id)
    {
        Historico objeto = null;
        String consulta = "SELECT h FROM Historico h WHERE h.id = ";
        consulta = consulta + String.valueOf(id);
        System.out.println(consulta);
        objeto = executeQuerySingleResultInteger(consulta);

        return objeto;
    }

    @Override
    public Historico find(String nome)
    {

        Historico objeto = null;
        HashMap<String, String> par = new HashMap<String, String>();
        par.put("n", nome);

        objeto = executeQuerySingleResult("SELECT h FROM Historico h WHERE h.situacao =:n", par);

        return objeto;
    }

    @Override
    public Historico find(Long aluno, String situacao)
    {
        Historico objeto = null;
        String consulta = "SELECT h FROM Historico h WHERE h.aluno.id = ";
        consulta = consulta + String.valueOf(aluno) + " AND h.situacao = '" + situacao + "'";
        System.out.println(consulta);
        objeto = executeQuerySingleResultInteger(consulta);

        return objeto;
    }

    @Override
    public void update(Long id, String situacao)
    {
        String update = "UPDATE Historico h SET h.situacao = '" + situacao + "' WHERE h.id = " + String.valueOf(id);
        executeQuerySingleUpdate(update);
    }

    @Override
    public List<Historico> findAllSituacao(String situacao)
    {
        String select = "Select h FROM Historico h WHERE h.situacao = '" + situacao + "'";
        List<Historico> list = executeQuerySingleList(select);
        return list;
    }
}
