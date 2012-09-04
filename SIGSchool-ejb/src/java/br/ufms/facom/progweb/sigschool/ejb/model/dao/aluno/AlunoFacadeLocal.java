/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.aluno;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.aluno.Aluno;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rkuninari
 */
@Local
public interface AlunoFacadeLocal
{

    void create(Aluno aluno);

    void edit(Aluno aluno);

    void remove(Aluno aluno);

    Aluno find(Object id);
    
    Aluno find(String nome);
    
    Aluno find(int id);
    
    Aluno findMatricula(int id);

    List<Aluno> findAll();

    List<Aluno> findRange(int[] range);

    int count();
    
}
