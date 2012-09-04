/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.tipoAvaliacao;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.tipoAvaliacao.TipoAvaliacao;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rkuninari
 */
@Local
public interface TipoAvaliacaoFacadeLocal
{

    void create(TipoAvaliacao tipoAvaliacao);

    void edit(TipoAvaliacao tipoAvaliacao);

    void remove(TipoAvaliacao tipoAvaliacao);

    TipoAvaliacao find(Object id);
    
    TipoAvaliacao find(String descricao);
    
    List<TipoAvaliacao> find(int idHistoricoNotas);

    List<TipoAvaliacao> findAll();

    List<TipoAvaliacao> findRange(int[] range);

    int count();
    
}
