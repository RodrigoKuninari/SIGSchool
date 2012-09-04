/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.professor;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.endereco.Endereco;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.funcionario.Funcionario;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.professorDisciplina.ProfessorDisciplina;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo Kuninari
 */
@Entity
@Table(name = "tb_professor")
public class Professor extends Funcionario implements Serializable
{

    @OneToMany(mappedBy = "professor")
    private Set<ProfessorDisciplina> professorDisciplinas;

    public Professor()
    {
    }

    public Professor(String nome, Date dataNasc, String sexo, String telRes, String telCel, String email, boolean ativo, Endereco endereco, String cpf, String rg, int matricula, String curriculum, Set<ProfessorDisciplina> professorDisciplinas)
    {
        super(nome, dataNasc, sexo, telRes, telCel, email, ativo, endereco, cpf, rg, matricula, curriculum);
        this.professorDisciplinas = professorDisciplinas;
    }

    public Set<ProfessorDisciplina> getProfessorDisciplinas()
    {
        return professorDisciplinas;
    }

    public void setProfessorDisciplinas(Set<ProfessorDisciplina> professorDisciplinas)
    {
        this.professorDisciplinas = professorDisciplinas;
    }

}
