/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.endereco;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Rodrigo Kuninari
 */
@Local
public interface EnderecoFacadeLocal
{

    void create(Endereco endereco);

    void update(int id_endereco,Endereco endereco);

    void remove(Endereco endereco);

    Endereco find(Object id);
    
    Endereco find(int id);

    List<Endereco> findAll();

    List<Endereco> findRange(int[] range);

    int count();
    
    //public Endereco find(int logradouro);
    
}
