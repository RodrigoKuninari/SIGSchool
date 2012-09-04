/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.disciplina.Disciplina;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.disciplina.DisciplinaFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rodrigo Kuninari
 */
@Stateless
public class DisciplinaMgrBean implements DisciplinaMgrBeanLocal
{

    @EJB
    private DisciplinaFacadeLocal disciplinaBean;

    @Override
    public List listar()
    {
        System.out.println("retornando lista ...");
        return disciplinaBean.findAll();
    }

    @Override
    public boolean salvar(Disciplina novo)
    {
        if (buscar(novo.getNome()) == null)
        {
            System.out.println("Salvando...");
            disciplinaBean.create(novo);
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
    public Disciplina buscar(String nome)
    {
        System.out.println("Buscando...");
        Disciplina objeto = null;
        objeto = disciplinaBean.find(nome);
        return objeto;
    }
    
    @Override
    public Disciplina buscar(int id)
    {
        System.out.println("Buscando...");
        Disciplina objeto = null;
        objeto = disciplinaBean.find(id);
        return objeto;
    }

}
