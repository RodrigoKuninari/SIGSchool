/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.endereco.Endereco;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Rodrigo Kuninari
 */
@Local
public interface EnderecoMgrBeanLocal
{
    /**
     * Salva uma determinado contato no sistema
     * @param novo contato a ser armazenada
     * @return true se foi salvo, e false em caso contrário
     */
    public boolean salvar(Endereco novo);
    
    public boolean editar(int id_endereco,Endereco endereco);

    /**
     * Busca uma contato usando como critério o email
     * @param email e-mail da contato
     * @return um objeto contato em caso de sucesso ou null, caso contrário
     */
    public Endereco buscar(int logradouro);

    /**
     * Retorna a lista de contatos cadastrados no sistema
     * @return lista de contatos
     */
    public List listar();
}
