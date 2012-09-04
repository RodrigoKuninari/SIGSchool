/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.historicoNotas;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.AbstractFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rkuninari
 */
@Stateless
public class HistoricoNotasFacade extends AbstractFacade<HistoricoNotas> implements HistoricoNotasFacadeLocal
{
    @PersistenceContext(unitName = "SIGSchool-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager()
    {
        return em;
    }

    public HistoricoNotasFacade()
    {
        super(HistoricoNotas.class);
    }

    @Override
    public List<HistoricoNotas> findAll()
    {
        List<HistoricoNotas> list = executeQuery("FROM  HistoricoNotas", 0, null);
        return list;
    }

    @Override
    public List<HistoricoNotas> findRange(int[] range)
    {
        List<HistoricoNotas> list = executeQuery("FROM  HistoricoNotas", 0, null);
        return list;
    }

    @Override
    public int count()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<HistoricoNotas> list(int idProfessorDisciplina)
    {
        String select = "Select h FROM HistoricoNotas h WHERE h.professorDisciplina.id = " + idProfessorDisciplina;
        List<HistoricoNotas> list = executeQuerySingleList(select);
        return list;
    }

    @Override
    public HistoricoNotas findById(int id)
    {
        HistoricoNotas objeto = null;
        String consulta = "SELECT hn FROM HistoricoNotas hn WHERE hn.id = ";
        consulta = consulta + String.valueOf(id);
        System.out.println(consulta);
        objeto = executeQuerySingleResultInteger(consulta);

        return objeto;
    }
}
