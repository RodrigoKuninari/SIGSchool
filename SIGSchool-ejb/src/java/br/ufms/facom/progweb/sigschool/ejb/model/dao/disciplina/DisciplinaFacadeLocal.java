/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.disciplina;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.disciplina.Disciplina;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rkuninari
 */
@Local
public interface DisciplinaFacadeLocal
{

    void create(Disciplina disciplina);

    void edit(Disciplina disciplina);

    void remove(Disciplina disciplina);

    Disciplina find(Object id);
    
    Disciplina find(int id);
    
    Disciplina find (String nome);

    List<Disciplina> findAll();

    List<Disciplina> findRange(int[] range);

    int count();
    
}
