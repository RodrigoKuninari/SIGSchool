/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.coordenador.Coordenador;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.coordenador.CoordenadorFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 *
 * @author Rodrigo Kuninari
 */
@Stateless
public class CoordenadorMgrBean implements CoordenadorMgrBeanLocal
{
    @EJB
    private CoordenadorFacadeLocal coordenadorBean;

    @Override
    public List listar()
    {
        System.out.println("retornando lista ...");
        return coordenadorBean.findAll();
    }

    @Override
    public boolean salvar(Coordenador novo)
    {
        if (buscar(novo.getCpf()) == null)
        {
            System.out.println("Salvando...");
            coordenadorBean.create(novo);
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public String toUpper(String entrada)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Coordenador buscar(String cpf)
    {
        System.out.println("Buscando...");
        Coordenador objeto = null;
        objeto = coordenadorBean.find(cpf);
        return objeto;
    }

    @Override
    public Coordenador buscar(int id)
    {
        System.out.println("Buscando...");
        Coordenador objeto = null;
        objeto = coordenadorBean.find(id);
        return objeto;
    }
}
