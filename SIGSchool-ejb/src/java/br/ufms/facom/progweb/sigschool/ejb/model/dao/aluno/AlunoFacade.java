/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.aluno;

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
public class AlunoFacade extends AbstractFacade<Aluno> implements AlunoFacadeLocal
{
    @PersistenceContext(unitName = "SIGSchool-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager()
    {
        return em;
    }

    public AlunoFacade()
    {
        super(Aluno.class);
    }

    @Override
    public List<Aluno> findAll()
    {
        List<Aluno> list = executeQuery("FROM  Aluno", 0, null);
        return list;
    }

    @Override
    public List<Aluno> findRange(int[] range)
    {
        List<Aluno> list = executeQuery("FROM  Aluno", 0, null);
        return list;
    }

    @Override
    public int count()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Aluno find(String nome)
    {

        Aluno objeto = null;
        HashMap<String, String> par = new HashMap<String, String>();
        par.put("n", nome);

        objeto = executeQuerySingleResult("SELECT a FROM Aluno a WHERE a.nome =:n", par);

        return objeto;
    }

    @Override
    public Aluno find(int id)
    {
        Aluno objeto = null;
        String consulta = "SELECT a FROM Aluno a WHERE a.id = ";
        consulta = consulta + String.valueOf(id);
        System.out.println(consulta);
        objeto = executeQuerySingleResultInteger(consulta);

        return objeto;
    }

    @Override
    public Aluno findMatricula(int id)
    {
        Aluno objeto = null;
        String consulta = "SELECT a FROM Aluno a WHERE a.matricula = ";
        consulta = consulta + String.valueOf(id);
        System.out.println(consulta);
        objeto = executeQuerySingleResultInteger(consulta);

        return objeto;
    }
}
