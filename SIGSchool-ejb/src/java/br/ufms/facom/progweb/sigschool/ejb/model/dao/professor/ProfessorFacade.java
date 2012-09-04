/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.ejb.model.dao.professor;

import br.ufms.facom.progweb.sigschool.ejb.model.dao.AbstractFacade;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rodrigo Kuninari
 */
@Stateless
public class ProfessorFacade extends AbstractFacade<Professor> implements ProfessorFacadeLocal {

    @PersistenceContext(unitName = "SIGSchool-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Professor find(String cpf) {

        Professor objeto = null;
        HashMap<String, String> par = new HashMap<String, String>();
        par.put("n", cpf);

        objeto = executeQuerySingleResult("SELECT p FROM Professor p WHERE p.cpf =:n", par);

        return objeto;

    }
    
    @Override
    public Professor find(int id) {
        Professor objeto = null;
        String consulta = "SELECT h FROM Professor h WHERE h.id = ";
        consulta = consulta + String.valueOf(id);
        System.out.println(consulta);
        objeto = executeQuerySingleResultInteger(consulta);

        return objeto;
    }

    
    public ProfessorFacade() {
        super(Professor.class);
    }

    @Override
    public List<Professor> findAll() {
        List<Professor> list = executeQuery("FROM  Professor", 0, null);
        return list;
    }

    @Override
    public List<Professor> findRange(int[] range) {
        List<Professor> list = executeQuery("FROM  Professor", 0, null);
        return list;
    }

    @Override
    public int count() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean desativar(int id_professor) {
        String update = "UPDATE Professor p SET p.ativo = 0 WHERE p.id = " + id_professor;
        executeQuerySingleUpdate(update);
        return true;
    }

    @Override
    public void update(int id_professor, Professor professor) {
        
        int matricula = professor.getMatricula();
        String nome = professor.getNome();
        String cpf = professor.getCpf();
        String rg = professor.getRg();
        String sexo = professor.getSexo();
        String email = professor.getEmail();
        String telRes = professor.getTelRes();
        String telCel = professor.getTelCel();
        Date date = professor.getDataNasc();
        
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd"); 
        String data = formatador.format(date);
        
        String update = "UPDATE Professor e SET e.matricula="+matricula+", e.nome = '"+nome+"'"+ 
                        ", e.cpf = '"+cpf+
                        "', e.rg = '"+rg+
                        "', e.sexo = '"+sexo+
                        "', e.email = '"+email+
                        "', e.telRes = '"+telRes+
                        "', e.telCel = '"+telCel+
                        "', e.dataNasc = '"+data+
                        "'  WHERE e.id = " + id_professor;
        
        executeQuerySingleUpdate(update);
    }
}
