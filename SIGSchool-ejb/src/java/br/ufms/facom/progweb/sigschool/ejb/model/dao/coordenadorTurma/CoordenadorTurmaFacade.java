/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.coordenadorTurma;

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
public class CoordenadorTurmaFacade extends AbstractFacade<CoordenadorTurma> implements CoordenadorTurmaFacadeLocal
{
    @PersistenceContext(unitName = "SIGSchool-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager()
    {
        return em;
    }

    public CoordenadorTurmaFacade()
    {
        super(CoordenadorTurma.class);
    }

    @Override
    public List<CoordenadorTurma> findAll()
    {
        List<CoordenadorTurma> list = executeQuery("FROM  CoordenadorTurma", 0, null);
        return list;
    }

    @Override
    public List<CoordenadorTurma> findRange(int[] range)
    {
        List<CoordenadorTurma> list = executeQuery("FROM  CoordenadorTurma", 0, null);
        return list;
    }

    @Override
    public int count()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public CoordenadorTurma find(int id)
    {
        CoordenadorTurma objeto = null;
        String consulta = "SELECT c FROM CoordenadorTurma c WHERE c.id = ";
        consulta = consulta + String.valueOf(id);
        System.out.println(consulta);
        objeto = executeQuerySingleResultInteger(consulta);

        return objeto;
    }
}
