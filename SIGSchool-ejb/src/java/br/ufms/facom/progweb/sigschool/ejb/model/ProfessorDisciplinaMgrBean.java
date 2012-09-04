/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.professorDisciplina.ProfessorDisciplina;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.professorDisciplina.ProfessorDisciplinaFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rkuninari
 */
@Stateless
public class ProfessorDisciplinaMgrBean implements ProfessorDisciplinaMgrBeanLocal
{
    @EJB
    private ProfessorDisciplinaFacadeLocal professorDisciplinaBean;

    @Override
    public List listar()
    {
        System.out.println("retornando lista ...");
        return professorDisciplinaBean.findAll();
    }

    @Override
    public boolean salvar(ProfessorDisciplina novo)
    {
        System.out.println("Salvando...");
        professorDisciplinaBean.create(novo);
        return true;
    }

    @Override
    public String toUpper(String entrada)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List listarCoordenadorTurma(int coordenadorTurma)
    {
        System.out.println("retornando lista coordenador turma...");
        return professorDisciplinaBean.find(coordenadorTurma);
    }
    
    @Override
    public ProfessorDisciplina buscar(Object id)
    {
        return professorDisciplinaBean.find(id);
    }
    
    @Override
    public ProfessorDisciplina buscarId(int id)
    {
        System.out.println("retornando professor disciplina por id...");
        return professorDisciplinaBean.findById(id);
    }
}
