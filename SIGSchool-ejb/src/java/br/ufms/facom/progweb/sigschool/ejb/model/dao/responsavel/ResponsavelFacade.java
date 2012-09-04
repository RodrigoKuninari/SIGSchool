/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.responsavel;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.AbstractFacade;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rodrigo Kuninari
 */
@Stateless
public class ResponsavelFacade extends AbstractFacade<Responsavel> implements ResponsavelFacadeLocal
{

    @PersistenceContext(unitName = "SIGSchool-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager()
    {
        return em;
    }

    public ResponsavelFacade()
    {
        super(Responsavel.class);
    }

    @Override
    public List<Responsavel> findAll() {
        List<Responsavel> list = executeQuery("FROM  Responsavel", 0, null);
        return list;
    }

    @Override
    public List<Responsavel> findRange(int[] range) {
        List<Responsavel> list = executeQuery("FROM  Responsavel", 0, null);
        return list;
    }

    @Override
    public int count() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Responsavel find(String cpf) {
        
        Responsavel objeto = null;
        HashMap<String, String> par = new HashMap<String, String>();
        par.put("n", cpf);

        objeto = executeQuerySingleResult("SELECT r FROM Responsavel r WHERE r.cpf =:n", par);

        return objeto;
    }
    
        @Override
    public Responsavel find(int id)
    {
        Responsavel objeto = null;
        String consulta = "SELECT r FROM Responsavel r WHERE r.id = ";
        consulta = consulta + String.valueOf(id);
        System.out.println(consulta);
        objeto = executeQuerySingleResultInteger(consulta);

        return objeto;
    }
}
