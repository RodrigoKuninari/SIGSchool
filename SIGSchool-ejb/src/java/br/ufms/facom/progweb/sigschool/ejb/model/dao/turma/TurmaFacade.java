/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.turma;

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
public class TurmaFacade extends AbstractFacade<Turma> implements TurmaFacadeLocal
{

    @PersistenceContext(unitName = "SIGSchool-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager()
    {
        return em;
    }

    public TurmaFacade()
    {
        super(Turma.class);
    }

    @Override
    public List<Turma> findAll()
    {
        List<Turma> list = executeQuery("FROM  Turma", 0, null);
        return list;
    }

    @Override
    public List<Turma> findRange(int[] range)
    {
        List<Turma> list = executeQuery("FROM  Turma", 0, null);
        return list;
    }

    @Override
    public int count()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
