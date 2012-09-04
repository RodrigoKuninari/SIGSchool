/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.coordenadorTurma;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rkuninari
 */
@Local
public interface CoordenadorTurmaFacadeLocal
{

    void create(CoordenadorTurma coordenadorTurma);

    void edit(CoordenadorTurma coordenadorTurma);

    void remove(CoordenadorTurma coordenadorTurma);

    CoordenadorTurma find(Object id);
    
    CoordenadorTurma find(int id);

    List<CoordenadorTurma> findAll();

    List<CoordenadorTurma> findRange(int[] range);

    int count();
    
}
