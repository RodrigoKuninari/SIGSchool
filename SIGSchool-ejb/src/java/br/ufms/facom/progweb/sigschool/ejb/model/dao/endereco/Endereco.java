/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.endereco;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.aluno.Aluno;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.coordenador.Coordenador;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.professor.Professor;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.responsavel.Responsavel;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo Kuninari
 */
@Entity
@Table(name = "tb_endereco")
public class Endereco implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "logradouro", nullable = false)
    private String logradouro;

    @Column(name = "numero", nullable = false)
    private int numero;

    @Column(name = "bairro", nullable = false)
    private String bairro;

    @Column(name = "cidade", nullable = false)
    private String cidade;

    @Column(name = "uf", nullable = false)
    private String uf;

    @Column(name = "cep", nullable = false)
    private String cep;

    @OneToMany(mappedBy = "endereco")
    private Set<Aluno> alunos;

    @OneToMany(mappedBy = "endereco")
    private Set<Responsavel> responsaveis;

    @OneToMany(mappedBy = "endereco")
    private Set<Coordenador> coordenadores;

    @OneToMany(mappedBy = "endereco")
    private Set<Professor> professores;

    public Endereco()
    {
    }

    public Endereco(String logradouro, int numero, String bairro, String cidade, String uf, String cep, Set<Aluno> alunos, Set<Responsavel> responsaveis, Set<Coordenador> coordenadores, Set<Professor> professores)
    {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.alunos = alunos;
        this.responsaveis = responsaveis;
        this.coordenadores = coordenadores;
        this.professores = professores;
    }

    public Set<Aluno> getAlunos()
    {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos)
    {
        this.alunos = alunos;
    }

    public String getBairro()
    {
        return bairro;
    }

    public void setBairro(String bairro)
    {
        this.bairro = bairro;
    }

    public String getCep()
    {
        return cep;
    }

    public void setCep(String cep)
    {
        this.cep = cep;
    }

    public String getCidade()
    {
        return cidade;
    }

    public void setCidade(String cidade)
    {
        this.cidade = cidade;
    }

    public Set<Coordenador> getCoordenadores()
    {
        return coordenadores;
    }

    public void setCoordenadores(Set<Coordenador> coordenadores)
    {
        this.coordenadores = coordenadores;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getLogradouro()
    {
        return logradouro;
    }

    public void setLogradouro(String logradouro)
    {
        this.logradouro = logradouro;
    }

    public int getNumero()
    {
        return numero;
    }

    public void setNumero(int numero)
    {
        this.numero = numero;
    }

    public Set<Professor> getProfessores()
    {
        return professores;
    }

    public void setProfessores(Set<Professor> professores)
    {
        this.professores = professores;
    }

    public Set<Responsavel> getResponsaveis()
    {
        return responsaveis;
    }

    public void setResponsaveis(Set<Responsavel> responsaveis)
    {
        this.responsaveis = responsaveis;
    }

    public String getUf()
    {
        return uf;
    }

    public void setUf(String uf)
    {
        this.uf = uf;
    }

}
