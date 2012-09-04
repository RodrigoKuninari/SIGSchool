/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.responsavel;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.endereco.Endereco;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.pessoa.Pessoa;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.aluno.Aluno;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo Kuninari
 */
@Entity
@Table(name = "tb_responsavel")
public class Responsavel extends Pessoa implements Serializable
{

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "rg", nullable = false)
    private String rg;

    @OneToMany(mappedBy = "responsavel")
    private Set<Aluno> alunos;
    
    public Responsavel()
    {
    }

    public Responsavel(String nome, Date dataNasc, String sexo, String telRes, String telCel, String email, boolean ativo, Endereco endereco, String cpf, String rg, Set<Aluno> alunos)
    {
        super(nome, dataNasc, sexo, telRes, telCel, email, ativo, endereco);
        this.cpf = cpf;
        this.rg = rg;
        this.alunos = alunos;
    }

    public Set<Aluno> getAlunos()
    {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos)
    {
        this.alunos = alunos;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public String getRg()
    {
        return rg;
    }

    public void setRg(String rg)
    {
        this.rg = rg;
    }

}
