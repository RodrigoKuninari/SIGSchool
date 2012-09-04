/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.historicoNotas.HistoricoNotas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rkuninari
 */
@Local
public interface HistoricoNotasMgrBeanLocal
{
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
    public boolean salvar(HistoricoNotas novo);

    /**
     * Retorna a lista de pessoas cadastradas no sistema
     * @return lista de pessoas
     */
    public List listar();
    
    public List listarProfessorDisciplina(int id);
    
    public HistoricoNotas buscarId(int id);
    
    public HistoricoNotas buscar(Object id);
}
