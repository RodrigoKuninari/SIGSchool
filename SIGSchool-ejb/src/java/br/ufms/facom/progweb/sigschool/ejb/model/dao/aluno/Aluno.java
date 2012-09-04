/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.aluno;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.endereco.Endereco;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.historico.Historico;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.pessoa.Pessoa;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.responsavel.Responsavel;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo Kuninari
 */
@Entity
@Table(name = "tb_aluno")
public class Aluno extends Pessoa implements Serializable
{
    @Column(name = "matricula", nullable = false)
    private int matricula;
    @JoinColumn(name = "responsavel")
    @ManyToOne
    private Responsavel responsavel;
    @OneToOne(mappedBy = "aluno")
    private Historico historico;

    public Aluno()
    {
    }

    public Aluno(String nome, Date dataNasc, String sexo, String telRes, String telCel, String email, boolean ativo, Endereco endereco, int matricula, Responsavel responsavel, Historico historico)
    {
        super(nome, dataNasc, sexo, telRes, telCel, email, ativo, endereco);
        this.matricula = matricula;
        this.responsavel = responsavel;
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

    public Responsavel getResponsavel()
    {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel)
    {
        this.responsavel = responsavel;
    }

    public int getMatricula()
    {
        return matricula;
    }

    public void setMatricula(int matricula)
    {
        this.matricula = matricula;
    }
    
    
}
