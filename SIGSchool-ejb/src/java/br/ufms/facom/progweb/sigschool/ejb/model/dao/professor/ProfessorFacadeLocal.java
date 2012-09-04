/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.professor;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Rodrigo Kuninari
 */
@Local
public interface ProfessorFacadeLocal {

    void create(Professor usuario);

    void edit(Professor usuario);

    void remove(Professor usuario);

    Professor find(Object id);

    Professor find(String cpf);
    
    Professor find(int id_professor);

    List<Professor> findAll();

    List<Professor> findRange(int[] range);

    boolean desativar(int id_professor);
    int count();

    public void update(int id_professor, Professor professor);
}
