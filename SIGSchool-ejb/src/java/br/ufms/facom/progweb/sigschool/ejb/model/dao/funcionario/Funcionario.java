/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.funcionario;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.endereco.Endereco;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.pessoa.Pessoa;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Rodrigo Kuninari
 */
@MappedSuperclass
public class Funcionario extends Pessoa implements Serializable
{

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "rg", nullable = false)
    private String rg;

    @Column(name = "matricula", nullable = false)
    private int matricula;

    @Column(name = "curriculum", nullable = false)
    private String curriculum;

    public Funcionario()
    {
    }

    public Funcionario(String nome, Date dataNasc, String sexo, String telRes, String telCel, String email, boolean ativo, Endereco endereco, String cpf, String rg, int matricula, String curriculum)
    {
        super(nome, dataNasc, sexo, telRes, telCel, email, ativo, endereco);
        this.cpf = cpf;
        this.rg = rg;
        this.matricula = matricula;
        this.curriculum = curriculum;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public String getCurriculum()
    {
        return curriculum;
    }

    public void setCurriculum(String curriculum)
    {
        this.curriculum = curriculum;
    }

    public int getMatricula()
    {
        return matricula;
    }

    public void setMatricula(int matricula)
    {
        this.matricula = matricula;
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
