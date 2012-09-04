/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.professorDisciplina;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.coordenadorTurma.CoordenadorTurma;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.disciplina.Disciplina;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.historicoNotas.HistoricoNotas;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.professor.Professor;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author rkuninari
 */
@Entity
@Table(name = "tb_professor_disciplina")
public class ProfessorDisciplina implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @JoinColumn(name = "professor")
    @ManyToOne
    private Professor professor;

    @JoinColumn(name = "disciplina")
    @ManyToOne
    private Disciplina disciplina;

    @JoinColumn(name = "coordenador_turma")
    @ManyToOne
    private CoordenadorTurma coordenadorTurma;

    @OneToMany(mappedBy = "professorDisciplina")
    private Set<HistoricoNotas> historicoNotas;

    public ProfessorDisciplina()
    {
    }

    public ProfessorDisciplina(Professor professor, Disciplina disciplina, CoordenadorTurma coordenadorTurma, Set<HistoricoNotas> historicoNotas)
    {
        this.professor = professor;
        this.disciplina = disciplina;
        this.coordenadorTurma = coordenadorTurma;
        this.historicoNotas = historicoNotas;
    }

    public CoordenadorTurma getCoordenadorTurma()
    {
        return coordenadorTurma;
    }

    public void setCoordenadorTurma(CoordenadorTurma coordenadorTurma)
    {
        this.coordenadorTurma = coordenadorTurma;
    }

    public Disciplina getDisciplina()
    {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina)
    {
        this.disciplina = disciplina;
    }

    public Set<HistoricoNotas> getHistoricoNotas()
    {
        return historicoNotas;
    }

    public void setHistoricoNotas(Set<HistoricoNotas> historicoNotas)
    {
        this.historicoNotas = historicoNotas;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Professor getProfessor()
    {
        return professor;
    }

    public void setProfessor(Professor professor)
    {
        this.professor = professor;
    }

}
