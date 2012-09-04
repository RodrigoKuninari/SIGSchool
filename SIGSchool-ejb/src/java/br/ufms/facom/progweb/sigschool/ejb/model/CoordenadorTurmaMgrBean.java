/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.coordenadorTurma.CoordenadorTurma;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.coordenadorTurma.CoordenadorTurmaFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rkuninari
 */
@Stateless
public class CoordenadorTurmaMgrBean implements CoordenadorTurmaMgrBeanLocal
{
    @EJB
    private CoordenadorTurmaFacadeLocal coordenadorTurmaBean;

    @Override
    public List listar()
    {
        System.out.println("retornando lista ...");
        return coordenadorTurmaBean.findAll();
    }

    @Override
    public boolean salvar(CoordenadorTurma novo)
    {
        System.out.println("Salvando...");
        coordenadorTurmaBean.create(novo);
        return true;
    }

    @Override
    public String toUpper(String entrada)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public CoordenadorTurma buscar(int id)
    {
        System.out.println("Buscando...");
        CoordenadorTurma objeto = null;
        objeto = coordenadorTurmaBean.find(id);
        return objeto;
    }
}
