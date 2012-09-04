/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.pessoa;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.endereco.Endereco;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;

/**
 *
 * @author Rodrigo Kuninari
 */
@MappedSuperclass
public abstract class Pessoa implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "dataNasc", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNasc;

    @Column(name = "sexo", nullable = false)
    private String sexo;

    @Column(name = "telRes", nullable = false)
    private String telRes;

    @Column(name = "telCel", nullable = false)
    private String telCel;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    @JoinColumn(name = "endereco")
    @ManyToOne
    private Endereco endereco;

    public Pessoa()
    {
    }

    public Pessoa(String nome, Date dataNasc, String sexo, String telRes, String telCel, String email, boolean ativo, Endereco endereco)
    {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.sexo = sexo;
        this.telRes = telRes;
        this.telCel = telCel;
        this.email = email;
        this.ativo = ativo;
        this.endereco = endereco;
    }

    public boolean isAtivo()
    {
        return ativo;
    }

    public void setAtivo(boolean ativo)
    {
        this.ativo = ativo;
    }

    public Date getDataNasc()
    {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc)
    {
        this.dataNasc = dataNasc;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Endereco getEndereco()
    {
        return endereco;
    }

    public void setEndereco(Endereco endereco)
    {
        this.endereco = endereco;
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

    public String isSexo()
    {
        return sexo;
    }

    public void setSexo(String sexo)
    {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public String getTelCel()
    {
        return telCel;
    }

    public void setTelCel(String telCel)
    {
        this.telCel = telCel;
    }

    public String getTelRes()
    {
        return telRes;
    }

    public void setTelRes(String telRes)
    {
        this.telRes = telRes;
    }

}
