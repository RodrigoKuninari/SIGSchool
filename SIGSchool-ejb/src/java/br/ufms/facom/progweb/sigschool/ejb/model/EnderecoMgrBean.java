/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.endereco.Endereco;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.endereco.EnderecoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rodrigo Kuninari
 */
@Stateless
public class EnderecoMgrBean implements EnderecoMgrBeanLocal
{
    //conectando com injeção de dependencia!
    @EJB
    private EnderecoFacadeLocal enderecoBean;


    /**
     * Salva uma determinado contato no sistema
     * @param novo contato a ser armazenada
     * @return true se foi salvo, e false em caso contrário
     */
    @Override
    public boolean salvar(Endereco novo) {
        System.out.println("Salvando...");
        enderecoBean.create(novo);
        return true;
    }
    
    @Override
    public boolean editar(int id_endereco,Endereco endereco)
    {
        enderecoBean.update(id_endereco,endereco);
        return true;
    }

    /**
     * Busca uma contato usando como critério o nome
     * @param nome nome da contato
     * @return um objeto contato em caso de sucesso ou null, caso contrário
     */
    @Override
    public Endereco buscar(int id_endereco) {
        System.out.println("Buscando...");
        Endereco p = null;
        p = enderecoBean.find(id_endereco);
        return p;

    }

    /**
     * Retorna a lista de contatos cadastradas no sistema
     * @return lista de contatos
     */
    @Override
    public List listar() {
        System.out.println("retornando lista ...");
        return enderecoBean.findAll();
    }

}
