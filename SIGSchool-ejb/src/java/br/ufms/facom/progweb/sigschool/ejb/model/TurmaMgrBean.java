/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.turma.Turma;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.turma.TurmaFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rodrigo Kuninari
 */
@Stateless
public class TurmaMgrBean implements TurmaMgrBeanLocal
{
    @EJB
    private TurmaFacadeLocal turmaBean;

    @Override
    public List listar()
    {
        System.out.println("retornando lista ...");
        return turmaBean.findAll();
    }

    @Override
    public boolean salvar(Turma novo)
    {
        System.out.println("Salvando...");
        turmaBean.create(novo);
        return true;
    }

    @Override
    public String toUpper(String entrada)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
