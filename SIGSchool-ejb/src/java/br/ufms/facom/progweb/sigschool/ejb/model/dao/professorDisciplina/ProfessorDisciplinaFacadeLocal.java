/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.professorDisciplina;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.professorDisciplina.ProfessorDisciplina;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rkuninari
 */
@Local
public interface ProfessorDisciplinaFacadeLocal
{

    void create(ProfessorDisciplina professorDisciplina);

    void edit(ProfessorDisciplina professorDisciplina);

    void remove(ProfessorDisciplina professorDisciplina);

    ProfessorDisciplina find(Object id);
    
    ProfessorDisciplina findById(int id);

    List<ProfessorDisciplina> findAll();

    List<ProfessorDisciplina> findRange(int[] range);
    
    List<ProfessorDisciplina> find(int coordenadorTurma);

    int count();
    
}
