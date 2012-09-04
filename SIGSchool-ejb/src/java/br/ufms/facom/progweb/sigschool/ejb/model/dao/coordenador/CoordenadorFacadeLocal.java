/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.coordenador;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Rodrigo Kuninari
 */
@Local
public interface CoordenadorFacadeLocal
{

    void create(Coordenador coordenador);

    void edit(Coordenador coordenador);

    void remove(Coordenador coordenador);

    Coordenador find(Object id);
    
    Coordenador find(int id);
    
    Coordenador find(String cpf);

    List<Coordenador> findAll();

    List<Coordenador> findRange(int[] range);

    int count();
    
}
