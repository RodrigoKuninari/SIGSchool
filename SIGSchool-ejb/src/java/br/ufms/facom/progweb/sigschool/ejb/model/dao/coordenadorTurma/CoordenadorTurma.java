/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.coordenadorTurma;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.coordenador.Coordenador;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.professorDisciplina.ProfessorDisciplina;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.turma.Turma;
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
@Table(name = "tb_coordenador_turma")
public class CoordenadorTurma implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "ano", nullable = false)
    private int ano;

    @Column(name = "serie", nullable = false)
    private int serie;

    @JoinColumn(name = "coordenador")
    @ManyToOne
    private Coordenador coordenador;

    @OneToMany(mappedBy = "coordenadorTurma")
    private Set<ProfessorDisciplina> professorDisciplinas;

    @OneToMany(mappedBy = "coordenadorTurma")
    private Set<Turma> turmas;

    public CoordenadorTurma()
    {
    }

    public CoordenadorTurma(int ano, int serie, Coordenador coordenador, Set<ProfessorDisciplina> professorDisciplinas, Set<Turma> turmas)
    {
        this.ano = ano;
        this.serie = serie;
        this.coordenador = coordenador;
        this.professorDisciplinas = professorDisciplinas;
        this.turmas = turmas;
    }

    public int getAno()
    {
        return ano;
    }

    public void setAno(int ano)
    {
        this.ano = ano;
    }

    public Coordenador getCoordenador()
    {
        return coordenador;
    }

    public void setCoordenador(Coordenador coordenador)
    {
        this.coordenador = coordenador;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Set<ProfessorDisciplina> getProfessorDisciplinas()
    {
        return professorDisciplinas;
    }

    public void setProfessorDisciplinas(Set<ProfessorDisciplina> professorDisciplinas)
    {
        this.professorDisciplinas = professorDisciplinas;
    }

    public int getSerie()
    {
        return serie;
    }

    public void setSerie(int serie)
    {
        this.serie = serie;
    }

    public Set<Turma> getTurmas()
    {
        return turmas;
    }

    public void setTurmas(Set<Turma> turmas)
    {
        this.turmas = turmas;
    }

}
