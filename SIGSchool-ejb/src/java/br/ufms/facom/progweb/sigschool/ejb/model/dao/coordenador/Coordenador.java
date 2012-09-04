/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.coordenador;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.coordenadorTurma.CoordenadorTurma;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.endereco.Endereco;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.funcionario.Funcionario;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo Kuninari
 */
@Entity
@Table(name = "tb_coordenador")
public class Coordenador extends Funcionario implements Serializable
{

    @OneToMany(mappedBy = "coordenador")
    private Set<CoordenadorTurma> coordenadorTurmas;

    public Coordenador()
    {
    }

    public Coordenador(String nome, Date dataNasc, String sexo, String telRes, String telCel, String email, boolean ativo, Endereco endereco, String cpf, String rg, int matricula, String curriculum, Set<CoordenadorTurma> coordenadorTurmas)
    {
        super(nome, dataNasc, sexo, telRes, telCel, email, ativo, endereco, cpf, rg, matricula, curriculum);
        this.coordenadorTurmas = coordenadorTurmas;
    }

    public Set<CoordenadorTurma> getCoordenadorTurmas()
    {
        return coordenadorTurmas;
    }

    public void setCoordenadorTurmas(Set<CoordenadorTurma> coordenadorTurmas)
    {
        this.coordenadorTurmas = coordenadorTurmas;
    }

}
