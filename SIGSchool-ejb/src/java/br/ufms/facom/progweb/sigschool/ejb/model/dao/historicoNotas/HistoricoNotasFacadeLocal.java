/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.historicoNotas;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.historicoNotas.HistoricoNotas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rkuninari
 */
@Local
public interface HistoricoNotasFacadeLocal
{

    void create(HistoricoNotas historicoNotas);

    void edit(HistoricoNotas historicoNotas);

    void remove(HistoricoNotas historicoNotas);

    HistoricoNotas find(Object id);
    
    HistoricoNotas findById(int id);
    
    List<HistoricoNotas> list(int idProfessorDisciplina);

    List<HistoricoNotas> findAll();

    List<HistoricoNotas> findRange(int[] range);

    int count();
    
}
