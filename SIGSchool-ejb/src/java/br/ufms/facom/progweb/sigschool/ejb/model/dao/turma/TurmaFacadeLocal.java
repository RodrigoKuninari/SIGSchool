/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.turma;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.turma.Turma;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rkuninari
 */
@Local
public interface TurmaFacadeLocal
{

    void create(Turma turma);

    void edit(Turma turma);

    void remove(Turma turma);

    Turma find(Object id);

    List<Turma> findAll();

    List<Turma> findRange(int[] range);

    int count();
    
}
