/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.historico;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.turma.Turma;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.aluno.Aluno;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.historicoNotas.HistoricoNotas;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo Kuninari
 */
@Entity
@Table(name = "tb_historico")
public class Historico implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "situacao", nullable = false)
    private String situacao;

    @JoinColumn(name = "aluno")
    @OneToOne
    private Aluno aluno;

    @OneToMany(mappedBy = "historico")
    private Set<Turma> turmas;

    @OneToMany(mappedBy = "historico")
    private Set<HistoricoNotas> historicoNotas;

    public Historico()
    {
    }

    public Historico(String situacao, Aluno aluno, Set<Turma> turmas, Set<HistoricoNotas> historicoNotas)
    {
        this.situacao = situacao;
        this.aluno = aluno;
        this.turmas = turmas;
        this.historicoNotas = historicoNotas;
    }

    public Aluno getAluno()
    {
        return aluno;
    }

    public void setAluno(Aluno aluno)
    {
        this.aluno = aluno;
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

    public String isSituacao()
    {
        return situacao;
    }

    public void setSituacao(String situacao)
    {
        this.situacao = situacao;
    }

    public Set<Turma> getTurmas()
    {
        return turmas;
    }

    public void setTurmas(Set<Turma> turmas)
    {
        this.turmas = turmas;
    }

    public String getSituacao()
    {
        return situacao;
    }

}
