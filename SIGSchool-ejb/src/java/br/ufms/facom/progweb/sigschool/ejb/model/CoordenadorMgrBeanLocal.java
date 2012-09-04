/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.coordenador.Coordenador;
import javax.ejb.Local;
import java.util.List;

/**
 *
 * @author Rodrigo Kuninari
 */
@Local
public interface CoordenadorMgrBeanLocal {

    /**
     * Recebe um texto e retorna a mesmo texto em maiúsculas.
     * @param entrada texto de entrada
     * @return texto em letras maíusculas
     */
    public String toUpper(String entrada);

    /**
     * Salva uma determinado pessoa no sistema
     * @param novo pessoa a ser armazenada
     * @return true se foi salvo, e false em caso contrário
     */
    public boolean salvar(Coordenador novo);

    /**
     * Busca uma pessoa usando como critério o nome
     * @param nome nome da pessoa
     * @return um objeto pessoa em caso de sucesso ou null, caso contrário
     */
    public Coordenador buscar(String cpf);
    
    public Coordenador buscar(int id);

    /**
     * Retorna a lista de pessoas cadastradas no sistema
     * @return lista de pessoas
     */
    public List listar();
}
