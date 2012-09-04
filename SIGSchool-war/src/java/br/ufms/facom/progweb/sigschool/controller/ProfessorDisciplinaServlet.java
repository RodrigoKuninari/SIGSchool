/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.controller;

import br.ufms.facom.progweb.sigschool.ejb.model.CoordenadorTurmaMgrBeanLocal;
import br.ufms.facom.progweb.sigschool.ejb.model.DisciplinaMgrBeanLocal;
import br.ufms.facom.progweb.sigschool.ejb.model.ProfessorDisciplinaMgrBeanLocal;
import br.ufms.facom.progweb.sigschool.ejb.model.ProfessorMgrBeanLocal;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.coordenadorTurma.CoordenadorTurma;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.disciplina.Disciplina;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.professor.Professor;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.professorDisciplina.ProfessorDisciplina;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rodrigo Kuninari
 */
public class ProfessorDisciplinaServlet extends HttpServlet
{
    @EJB
    ProfessorDisciplinaMgrBeanLocal fabricaProfessorDisciplina;
    
    @EJB
    ProfessorMgrBeanLocal fabricaProfessor;
    
    @EJB
    DisciplinaMgrBeanLocal fabricaDisciplina;
    
    @EJB
    CoordenadorTurmaMgrBeanLocal fabricaCoordenadorTurma;

    @Override
    public void init() throws ServletException
    {
    }

    private String listarProfessorDisciplinas(HttpServletRequest request)
    {

        String url = "/presentation.jsp";
        List professorDisciplinas = fabricaProfessorDisciplina.listar();

        request.setAttribute("lstprofessorDisciplinas", professorDisciplinas);
        request.setAttribute("opc", "professorDisciplina_Listar_professorDisciplinas");

        return url;
    }
    
    public void listarProfessores(HttpServletRequest request)
    {
        List professores = fabricaProfessor.listar();
        request.setAttribute("lstprofessores", professores);
    }
    
    public void listarDisciplinas(HttpServletRequest request)
    {
        List disciplinas = fabricaDisciplina.listar();
        request.setAttribute("lstdisciplinas", disciplinas);
    }
    
    public void listarCoordenadorTurmas(HttpServletRequest request)
    {
        List coordenadorTurmas = fabricaCoordenadorTurma.listar();
        request.setAttribute("lstcoordenadorTurmas", coordenadorTurmas);
    }

    public String cadastrarProfessorDisciplina(HttpServletRequest request)
    {

        String jsp = "presentation.jsp";
        boolean status = false;

        /***************************************Cadastra Coordenador Turma*******************************************/
        //Se endereço foi cadastrado com sucesso
        //Pega Dados Passados Por Post
        int idProfessor = Integer.parseInt(request.getParameter("professor"));
        int idDisciplina = Integer.parseInt(request.getParameter("disciplina"));
        int idCoordenadorTurma = Integer.parseInt(request.getParameter("coordenadorTurma"));
        
        Professor professor = fabricaProfessor.buscar(idProfessor);
        Disciplina disciplina = fabricaDisciplina.buscar(idDisciplina);
        CoordenadorTurma coordenadorTurma = fabricaCoordenadorTurma.buscar(idCoordenadorTurma);

//          ProfessorDisciplina(Professor professor, Disciplina disciplina, CoordenadorTurma coordenadorTurma, Set<HistoricoNotas> historicoNotas)
        ProfessorDisciplina professorDisciplina = new ProfessorDisciplina(professor, disciplina, coordenadorTurma, null);

        status = fabricaProfessorDisciplina.salvar(professorDisciplina);

        listarProfessores(request);
        listarDisciplinas(request);
        listarCoordenadorTurmas(request);
        
        request.setAttribute("opc", "professorDisciplina_Cadastrar_professorDisciplina");
        request.setAttribute("status", status);

        //Se fabricaProfessorDisciplina cadastrado com sucesso
        if (status)
        {
            request.setAttribute("mensagem_retorno", "Professor " + professorDisciplina.getProfessor().getNome() + " definido na Disciplina " + professorDisciplina.getDisciplina().getNome());
        }
        else
        {
            request.setAttribute("mensagem_retorno", "Erro ao Definir a Disciplina do Professor!");
        }


        return jsp;
    }

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String jsp = null;

        //redirect for the correct method in accordance with to received uri:
        if (request.getRequestURI().endsWith("/professorDisciplina_Inicio"))
        {
            jsp = "/index.jsp";
        }
        else if (request.getRequestURI().endsWith("/professorDisciplina_Form"))
        {
            request.setAttribute("opc", "cadastrar");
            //jsp = "/form_cadastro.jsp";
            jsp = "/presentation.jsp";
        }
        else if (request.getRequestURI().endsWith("/professorDisciplina_Presentation"))
        {
            jsp = "/presentation.jsp";
        }
        else if (request.getRequestURI().endsWith("/professorDisciplina_Form_cadastrar"))
        {
            listarProfessores(request);
            listarDisciplinas(request);
            listarCoordenadorTurmas(request);
            request.setAttribute("opc", "professorDisciplina_Cadastrar_professorDisciplina");
            jsp = "/presentation.jsp";
        }
        else if (request.getRequestURI().endsWith("/professorDisciplina_Cadastrar_professorDisciplina"))
        {
            jsp = cadastrarProfessorDisciplina(request);
        }
        else if (request.getRequestURI().endsWith("/professorDisciplina_Listar_professorDisciplinas"))
        {
            jsp = listarProfessorDisciplinas(request);
        }
        else
        {
            jsp = "/index.jsp";
        }

        if (jsp == null)
        {
            response.sendRedirect(request.getContextPath() + "/professorDisciplina_Inicio");
        }
        else if (!"empty".equals(jsp))
        {
            request.getRequestDispatcher(jsp).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>
}
