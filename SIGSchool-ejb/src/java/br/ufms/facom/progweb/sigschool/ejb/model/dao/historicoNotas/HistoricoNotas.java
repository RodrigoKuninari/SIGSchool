/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.historicoNotas;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.historico.Historico;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.professorDisciplina.ProfessorDisciplina;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.tipoAvaliacao.TipoAvaliacao;
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
@Table(name = "tb_historico_notas")
public class HistoricoNotas implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "media", nullable = false)
    private float media;

    @OneToMany(mappedBy = "historicoNotas")
    private Set<TipoAvaliacao> tipoAvaliacoes;

    @JoinColumn(name = "professor_disciplina")
    @ManyToOne
    private ProfessorDisciplina professorDisciplina;

    @JoinColumn(name = "historico")
    @ManyToOne
    private Historico historico;

    public HistoricoNotas()
    {
    }

    public HistoricoNotas(float media, Set<TipoAvaliacao> tipoAvaliacoes, ProfessorDisciplina professorDisciplina, Historico historico)
    {
        this.media = media;
        this.tipoAvaliacoes = tipoAvaliacoes;
        this.professorDisciplina = professorDisciplina;
        this.historico = historico;
    }

    public Historico getHistorico()
    {
        return historico;
    }

    public void setHistorico(Historico historico)
    {
        this.historico = historico;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public float getMedia()
    {
        return media;
    }

    public void setMedia(float media)
    {
        this.media = media;
    }

    public ProfessorDisciplina getProfessorDisciplina()
    {
        return professorDisciplina;
    }

    public void setProfessorDisciplina(ProfessorDisciplina professorDisciplina)
    {
        this.professorDisciplina = professorDisciplina;
    }

    public Set<TipoAvaliacao> getTipoAvaliacoes()
    {
        return tipoAvaliacoes;
    }

    public void setTipoAvaliacoes(Set<TipoAvaliacao> tipoAvaliacoes)
    {
        this.tipoAvaliacoes = tipoAvaliacoes;
    }

}
