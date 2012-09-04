/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.historico.Historico;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.historico.HistoricoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rodrigo Kuninari
 */
@Stateless
public class HistoricoMgrBean implements HistoricoMgrBeanLocal
{
    @EJB
    private HistoricoFacadeLocal historicoBean;

    @Override
    public List listar()
    {
        System.out.println("retornando lista ...");
        return historicoBean.findAll();
    }

    @Override
    public boolean salvar(Historico novo)
    {
        System.out.println("Salvando...");
        historicoBean.create(novo);
        return true;
    }

    @Override
    public String toUpper(String entrada)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Historico buscar(int id)
    {
        System.out.println("Buscando...");
        Historico objeto = null;
        objeto = historicoBean.find(id);
        return objeto;
    }

    @Override
    public Historico buscar(Long aluno, String situacao)
    {
        System.out.println("Buscando...");
        Historico objeto = null;
        objeto = historicoBean.find(aluno, situacao);
        return objeto;
    }

    @Override
    public void atualizar(Long id, String situacao)
    {
        System.out.println("Atualizando...");
        historicoBean.update(id, situacao);
    }

    @Override
    public List listarSituacao(String situacao)
    {
        System.out.println("retornando lista situacao ...");
        return historicoBean.findAllSituacao(situacao);
    }
}
