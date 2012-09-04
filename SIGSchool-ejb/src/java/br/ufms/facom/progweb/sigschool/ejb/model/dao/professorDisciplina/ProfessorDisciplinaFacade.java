/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.professorDisciplina;

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
public class ProfessorDisciplinaFacade extends AbstractFacade<ProfessorDisciplina> implements ProfessorDisciplinaFacadeLocal
{
    @PersistenceContext(unitName = "SIGSchool-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager()
    {
        return em;
    }

    public ProfessorDisciplinaFacade()
    {
        super(ProfessorDisciplina.class);
    }

    @Override
    public List<ProfessorDisciplina> findAll()
    {
        List<ProfessorDisciplina> list = executeQuery("FROM  ProfessorDisciplina", 0, null);
        return list;
    }

    @Override
    public List<ProfessorDisciplina> findRange(int[] range)
    {
        List<ProfessorDisciplina> list = executeQuery("FROM  ProfessorDisciplina", 0, null);
        return list;
    }

    @Override
    public int count()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ProfessorDisciplina> find(int coodenadorTurma)
    {
        String select = "Select p FROM ProfessorDisciplina p WHERE p.coordenadorTurma.id = " + String.valueOf(coodenadorTurma);
        List<ProfessorDisciplina> list = executeQuerySingleList(select);
        return list;
    }

    @Override
    public ProfessorDisciplina findById(int id)
    {
        ProfessorDisciplina objeto = null;
        String consulta = "SELECT p FROM ProfessorDisciplina p WHERE p.id = ";
        consulta = consulta + String.valueOf(id);
        System.out.println(consulta);
        objeto = executeQuerySingleResultInteger(consulta);

        return objeto;
    }
}
