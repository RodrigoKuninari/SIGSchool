/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.aluno.Aluno;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.aluno.AlunoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rodrigo Kuninari
 */
@Stateless
public class AlunoMgrBean implements AlunoMgrBeanLocal
{
    @EJB
    private AlunoFacadeLocal alunoBean;

    @Override
    public List listar()
    {
        System.out.println("retornando lista ...");
        return alunoBean.findAll();
    }

    @Override
    public boolean salvar(Aluno novo)
    {
        System.out.println("Salvando...");
        alunoBean.create(novo);
        return true;
    }

    @Override
    public String toUpper(String entrada)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Aluno buscar(String nome)
    {
        System.out.println("Buscando...");
        Aluno objeto = null;
        objeto = alunoBean.find(nome);
        return objeto;
    }

    @Override
    public Aluno buscar(int id)
    {
        System.out.println("Buscando...");
        Aluno objeto = null;
        objeto = alunoBean.find(id);
        return objeto;
    }

    @Override
    public Aluno buscarMatricula(int id)
    {
        System.out.println("Buscando...");
        Aluno objeto = null;
        objeto = alunoBean.findMatricula(id);
        return objeto;
    }
}
