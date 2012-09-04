/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.coordenador;

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
public class CoordenadorFacade extends AbstractFacade<Coordenador> implements CoordenadorFacadeLocal
{
    @PersistenceContext(unitName = "SIGSchool-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager()
    {
        return em;
    }

    public CoordenadorFacade()
    {
        super(Coordenador.class);
    }

    @Override
    public List<Coordenador> findAll()
    {
        List<Coordenador> list = executeQuery("FROM  Coordenador", 0, null);
        return list;
    }

    @Override
    public List<Coordenador> findRange(int[] range)
    {
        List<Coordenador> list = executeQuery("FROM  Coordenador", 0, null);
        return list;
    }

    @Override
    public int count()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Coordenador find(String cpf)
    {
        Coordenador objeto = null;
        HashMap<String, String> par = new HashMap<String, String>();
        par.put("n", cpf);

        objeto = executeQuerySingleResult("SELECT c FROM Coordenador c WHERE c.cpf =:n", par);

        return objeto;
    }

    @Override
    public Coordenador find(int id)
    {
        Coordenador objeto = null;
        String consulta = "SELECT c FROM Coordenador c WHERE c.id = ";
        consulta = consulta + String.valueOf(id);
        System.out.println(consulta);
        objeto = executeQuerySingleResultInteger(consulta);

        return objeto;
    }
}
