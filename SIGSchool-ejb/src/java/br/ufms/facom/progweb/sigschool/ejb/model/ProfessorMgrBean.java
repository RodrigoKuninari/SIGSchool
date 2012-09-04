/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.professor.Professor;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.professor.ProfessorFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rodrigo Kuninari
 */
@Stateless
public class ProfessorMgrBean implements ProfessorMgrBeanLocal {

    @EJB
    private ProfessorFacadeLocal professorBean;

    @Override
    public List listar() {
        System.out.println("retornando lista ...");
        return professorBean.findAll();
    }

    @Override
    public boolean salvar(Professor novo) { 
        if (buscar(novo.getCpf()) == null) {
            System.out.println("Salvando...");
            professorBean.create(novo);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toUpper(String entrada) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Professor buscar(String cpf) {
        System.out.println("Buscando...");
        Professor objeto = null;
        objeto = professorBean.find(cpf);
        return objeto;
    }
    
    @Override
    public Professor buscar(int id_professor) {
        System.out.println("Buscando...");
        Professor objeto = null;
        objeto = professorBean.find(id_professor);
        return objeto;
    }

    @Override
    public boolean desativar(int id_professor) {
        boolean retorno=true;
        
        professorBean.desativar(id_professor);
        
        return retorno;
    }

    @Override
    public boolean editar(int id_professor, Professor professor) {
        
//        professorBean.edit(professor);
        professorBean.update(id_professor,professor);
        return true;
    }
}
