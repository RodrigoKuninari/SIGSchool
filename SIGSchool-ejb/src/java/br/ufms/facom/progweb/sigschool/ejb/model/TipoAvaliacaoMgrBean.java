/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.tipoAvaliacao.TipoAvaliacao;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.tipoAvaliacao.TipoAvaliacaoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rkuninari
 */
@Stateless
public class TipoAvaliacaoMgrBean implements TipoAvaliacaoMgrBeanLocal
{
    @EJB
    private TipoAvaliacaoFacadeLocal tipoAvaliacaoBean;

    @Override
    public List listar()
    {
        System.out.println("retornando lista ...");
        return tipoAvaliacaoBean.findAll();
    }

    @Override
    public boolean salvar(TipoAvaliacao novo)
    {
        System.out.println("Salvando...");
        tipoAvaliacaoBean.create(novo);
        return true;
    }

    @Override
    public String toUpper(String entrada)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TipoAvaliacao buscar(String descricao)
    {
        System.out.println("Buscando...");
        TipoAvaliacao objeto = null;
        objeto = tipoAvaliacaoBean.find(descricao);
        return objeto;
    }

    @Override
    public List listarHistoricoNotas(int idHistoricoNotas)
    {
        System.out.println("retornando lista historico notas...");
        return tipoAvaliacaoBean.find(idHistoricoNotas);
    }
}
