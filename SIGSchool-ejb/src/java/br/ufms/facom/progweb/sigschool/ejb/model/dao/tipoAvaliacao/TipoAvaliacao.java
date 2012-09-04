/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.tipoAvaliacao;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.historicoNotas.HistoricoNotas;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Rodrigo Kuninari
 */
@Entity
@Table(name = "tb_tipo_avaliacao")
public class TipoAvaliacao implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "data_avaliacao", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "nota")
    private float nota;

    @JoinColumn(name = "historico_notas")
    @ManyToOne
    private HistoricoNotas historicoNotas;

    public TipoAvaliacao()
    {
    }

    public TipoAvaliacao(Date data, String nome, String descricao, float nota, HistoricoNotas historicoNotas)
    {
        this.data = data;
        this.nome = nome;
        this.descricao = descricao;
        this.nota = nota;
        this.historicoNotas = historicoNotas;
    }

    public Date getData()
    {
        return data;
    }

    public void setData(Date data)
    {
        this.data = data;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public HistoricoNotas getHistoricoNotas()
    {
        return historicoNotas;
    }

    public void setHistoricoNotas(HistoricoNotas historicoNotas)
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

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public float getNota()
    {
        return nota;
    }

    public void setNota(float nota)
    {
        this.nota = nota;
    }

}
