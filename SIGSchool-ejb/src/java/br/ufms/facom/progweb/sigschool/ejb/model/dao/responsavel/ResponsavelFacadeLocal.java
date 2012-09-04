/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.responsavel;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Rodrigo Kuninari
 */
@Local
public interface ResponsavelFacadeLocal
{

    void create(Responsavel responsavel);

    void edit(Responsavel responsavel);

    void remove(Responsavel responsavel);

    Responsavel find(Object id);
    
    Responsavel find(int id);
    
    Responsavel find(String cpf);

    List<Responsavel> findAll();

    List<Responsavel> findRange(int[] range);

    int count();
    
}
