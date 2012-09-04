/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.historicoNotas.HistoricoNotas;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.historicoNotas.HistoricoNotasFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rkuninari
 */
@Stateless
public class HistoricoNotasMgrBean implements HistoricoNotasMgrBeanLocal
{
    @EJB
    private HistoricoNotasFacadeLocal historicoNotasBean;

    @Override
    public List listar()
    {
        System.out.println("retornando lista ...");
        return historicoNotasBean.findAll();
    }

    @Override
    public boolean salvar(HistoricoNotas novo)
    {
        System.out.println("Salvando...");
        historicoNotasBean.create(novo);
        return true;
    }

    @Override
    public String toUpper(String entrada)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List listarProfessorDisciplina(int id)
    {
        System.out.println("retornando lista professor disciplina...");
        return historicoNotasBean.list(id);
    }

    @Override
    public HistoricoNotas buscarId(int id)
    {
        System.out.println("retornando historico notas por id...");
        return historicoNotasBean.findById(id);
    }

    @Override
    public HistoricoNotas buscar(Object id)
    {
        return historicoNotasBean.find(id);
    }
}
