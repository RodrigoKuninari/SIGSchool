/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.endereco;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.AbstractFacade;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rodrigo Kuninari
 */
@Stateless
public class EnderecoFacade extends AbstractFacade<Endereco> implements EnderecoFacadeLocal
{

    @PersistenceContext(unitName = "SIGSchool-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public EnderecoFacade()
    {
        super(Endereco.class);
    }

    @Override
    public List<Endereco> findAll() {
        List<Endereco> list = executeQuery("FROM  Endereco", 0, null);
        return list;
    }

    @Override
    public List<Endereco> findRange(int[] range) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int count() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Endereco find(int id) {
        Endereco objeto = null;
        String consulta = "SELECT h FROM Endereco h WHERE h.id = ";
        consulta = consulta + String.valueOf(id);
        System.out.println(consulta);
        objeto = executeQuerySingleResultInteger(consulta);

        return objeto;
    }

    @Override
    public void update(int id_endereco, Endereco endereco) {
        
       // long id = endereco.getId();
        String logradouro = endereco.getLogradouro();
        int numero = endereco.getNumero();
        String bairro = endereco.getBairro();
        String cidade = endereco.getCidade();
        String uf = endereco.getUf();
        String cep = endereco.getCep();
        
        String update = "UPDATE Endereco e SET e.logradouro = '" + logradouro + "' "+ 
                        ", e.numero = "+numero+
                        ", e.bairro = '"+bairro+
                        "', e.cidade = '"+cidade+
                        "', e.uf = '"+uf+
                        "', e.cep = '"+cep+
                        "' WHERE e.id = " + String.valueOf(id_endereco);
        
        executeQuerySingleUpdate(update);
    }
    
}