/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.historico;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.historico.Historico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rkuninari
 */
@Local
public interface HistoricoFacadeLocal
{

    void create(Historico historico);

    void edit(Historico historico);

    void remove(Historico historico);

    Historico find(Object id);
    
    Historico find(int id);
    
    Historico find(String situacao);
    
    Historico find(Long aluno, String situacao);
    
    void update(Long id, String situacao);

    List<Historico> findAll();

    List<Historico> findRange(int[] range);
    
    List<Historico> findAllSituacao(String situacao);

    int count();
    
}
