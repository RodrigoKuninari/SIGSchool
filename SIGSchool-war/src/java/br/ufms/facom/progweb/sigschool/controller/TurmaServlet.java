/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.controller;

import br.ufms.facom.progweb.sigschool.ejb.model.AlunoMgrBeanLocal;
import br.ufms.facom.progweb.sigschool.ejb.model.CoordenadorTurmaMgrBeanLocal;
import br.ufms.facom.progweb.sigschool.ejb.model.HistoricoMgrBeanLocal;
import br.ufms.facom.progweb.sigschool.ejb.model.HistoricoNotasMgrBeanLocal;
import br.ufms.facom.progweb.sigschool.ejb.model.ProfessorDisciplinaMgrBeanLocal;
import br.ufms.facom.progweb.sigschool.ejb.model.TurmaMgrBeanLocal;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.aluno.Aluno;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.coordenadorTurma.CoordenadorTurma;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.historico.Historico;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.historicoNotas.HistoricoNotas;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.professorDisciplina.ProfessorDisciplina;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.turma.Turma;
import java.io.IOException;
import java.io.PrintWriter;
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
public class TurmaServlet extends HttpServlet
{
    @EJB
    TurmaMgrBeanLocal fabricaTurma;
    @EJB
    CoordenadorTurmaMgrBeanLocal fabricaCoordenadorTurma;
    @EJB
    HistoricoMgrBeanLocal fabricaHistorico;
    @EJB
    AlunoMgrBeanLocal fabricaAluno;
    @EJB
    ProfessorDisciplinaMgrBeanLocal fabricaProfessorDisciplina;
    @EJB
    HistoricoNotasMgrBeanLocal fabricaHistoricoNotas;

    @Override
    public void init() throws ServletException
    {
    }

    private String listarTurmas(HttpServletRequest request)
    {

        String url = "/presentation.jsp";
        List turmas = fabricaTurma.listar();

        request.setAttribute("lstturmas", turmas);
        request.setAttribute("opc", "turma_Listar_turmas");

        return url;
    }

    public void listarCoordenadorTurmas(HttpServletRequest request)
    {
        List coordenadorTurmas = fabricaCoordenadorTurma.listar();
        request.setAttribute("lstcoordenadorTurmas", coordenadorTurmas);
    }

    public void listarHistoricosSituacao(HttpServletRequest request)
    {
        List historico = fabricaHistorico.listarSituacao("Esperando");
        request.setAttribute("lsthistoricos", historico);
    }
    
    public String cadastrarTurma(HttpServletRequest request)
    {

        String jsp = "presentation.jsp";
        boolean status = false;

        /***************************************Cadastra Turma*******************************************/
        //Se endereço foi cadastrado com sucesso
        //Pega Dados Passados Por Post
        int idCoordenadorTurma = Integer.parseInt(request.getParameter("coordenadorTurma"));
        CoordenadorTurma coordenadorTurma = fabricaCoordenadorTurma.buscar(idCoordenadorTurma);
        
        List listProfessorDisciplina = fabricaProfessorDisciplina.listarCoordenadorTurma(idCoordenadorTurma);
        int qtdProfessorDisciplina = listProfessorDisciplina.size();
        
        

        String[] nomeAluno = request.getParameterValues("aluno");
        if (nomeAluno != null)
        {
            for (int i = 0; i < nomeAluno.length; i++)
            {
                int contador = 0;
                Aluno aluno = fabricaAluno.buscar(nomeAluno[i]);
                Historico historico = fabricaHistorico.buscar(aluno.getId(), "Esperando");
                //          Turma(Historico historico, CoordenadorTurma coordenadorTurma)
                Turma turma = new Turma(historico, coordenadorTurma);
                status = fabricaTurma.salvar(turma);
                
                
                for(ProfessorDisciplina pd : (List<ProfessorDisciplina>) listProfessorDisciplina)
                {
                    ProfessorDisciplina professorDisciplina = fabricaProfessorDisciplina.buscar(pd.getId());
                    HistoricoNotas historicoNotas = new HistoricoNotas(0, null, professorDisciplina, historico);
                    boolean sucess = fabricaHistoricoNotas.salvar(historicoNotas);
                }

                fabricaHistorico.atualizar(historico.getId(), "Cursando");
                
                request.setAttribute("opc", "turma_Cadastrar_turma");
                request.setAttribute("status", status);

                //Se fabricaTurma cadastrado com sucesso
                if (status)
                {
                    request.setAttribute("mensagem_retorno", "Alunos Cadastrados na Turma " + turma.getCoordenadorTurma().getAno() + " - " + turma.getCoordenadorTurma().getSerie() + " ª Série!");
                }
                else
                {
                    request.setAttribute("mensagem_retorno", "Erro ao Cadastrar Alunos na Turma!");
                }
            }
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
        if (request.getRequestURI().endsWith("/turma_Inicio"))
        {
            jsp = "/index.jsp";
        }
        else if (request.getRequestURI().endsWith("/turma_Form"))
        {
            request.setAttribute("opc", "cadastrar");
            //jsp = "/form_cadastro.jsp";
            jsp = "/presentation.jsp";
        }
        else if (request.getRequestURI().endsWith("/turma_Presentation"))
        {
            jsp = "/presentation.jsp";
        }
        else if (request.getRequestURI().endsWith("/turma_Form_cadastrar"))
        {
            listarHistoricosSituacao(request);
            listarCoordenadorTurmas(request);
            request.setAttribute("opc", "turma_Cadastrar_turma");
            jsp = "/presentation.jsp";
        }
        else if (request.getRequestURI().endsWith("/turma_Cadastrar_turma"))
        {
            jsp = cadastrarTurma(request);
        }
        else if (request.getRequestURI().endsWith("/turma_Listar_turmas"))
        {
            jsp = listarTurmas(request);
        }
        else
        {
            jsp = "/index.jsp";
        }

        if (jsp == null)
        {
            response.sendRedirect(request.getContextPath() + "/turma_Inicio");
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
