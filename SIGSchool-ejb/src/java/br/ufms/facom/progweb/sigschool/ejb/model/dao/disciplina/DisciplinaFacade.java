/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.disciplina;

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
public class DisciplinaFacade extends AbstractFacade<Disciplina> implements DisciplinaFacadeLocal
{
    @PersistenceContext(unitName = "SIGSchool-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager()
    {
        return em;
    }

    public DisciplinaFacade()
    {
        super(Disciplina.class);
    }

    @Override
    public List<Disciplina> findAll()
    {
        List<Disciplina> list = executeQuery("FROM  Disciplina", 0, null);
        return list;
    }

    @Override
    public List<Disciplina> findRange(int[] range)
    {
        List<Disciplina> list = executeQuery("FROM  Disciplina", 0, null);
        return list;
    }

    @Override
    public int count()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Disciplina find(String nome)
    {
        Disciplina objeto = null;
        HashMap<String, String> par = new HashMap<String, String>();
        par.put("n", nome);

        objeto = executeQuerySingleResult("SELECT d FROM Disciplina d WHERE d.nome =:n", par);

        return objeto;
    }

    @Override
    public Disciplina find(int id)
    {
        Disciplina objeto = null;
        String consulta = "SELECT d FROM Disciplina d WHERE d.id = ";
        consulta = consulta + String.valueOf(id);
        System.out.println(consulta);
        objeto = executeQuerySingleResultInteger(consulta);

        return objeto;
    }
}
