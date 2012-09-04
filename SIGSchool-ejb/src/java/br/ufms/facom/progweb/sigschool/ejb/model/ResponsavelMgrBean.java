/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.responsavel.Responsavel;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.responsavel.ResponsavelFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 *
 * @author Rodrigo Kuninari
 */
@Stateless
public class ResponsavelMgrBean implements ResponsavelMgrBeanLocal {

    @EJB
    private ResponsavelFacadeLocal responsavelBean;

    @Override
    public List listar() {
        System.out.println("retornando lista ...");
        return responsavelBean.findAll();
    }

    @Override
    public boolean salvar(Responsavel novo) {
        if (buscar(novo.getCpf()) == null) {
            System.out.println("Salvando...");
            responsavelBean.create(novo);
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
    public Responsavel buscar(String cpf) {
        System.out.println("Buscando...");
        Responsavel objeto = null;
        objeto = responsavelBean.find(cpf);
        return objeto;
    }

    @Override
    public Responsavel buscar(int id) {
        System.out.println("Buscando...");
        Responsavel objeto = null;
        objeto = responsavelBean.find(id);
        return objeto;
    }
}
