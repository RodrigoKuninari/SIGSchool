/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.controller;

import br.ufms.facom.progweb.sigschool.ejb.model.DisciplinaMgrBeanLocal;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.disciplina.Disciplina;
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
public class DisciplinaServlet extends HttpServlet {

    @EJB
    DisciplinaMgrBeanLocal fabricaDisciplina;

    @Override
    public void init() throws ServletException
    {
    }

    private String listarDisciplinas(HttpServletRequest request)
    {

        String url = "/presentation.jsp";
        List disciplinas = fabricaDisciplina.listar();

        request.setAttribute("lstdisciplinas", disciplinas);
        request.setAttribute("opc", "disciplina_Listar_disciplinas");

        return url;
    }

    public String cadastrarDisciplina(HttpServletRequest request)
    {

        String jsp = "presentation.jsp";
        boolean status = false;

        /***************************************Cadastra Disciplina*******************************************/
        //Se endereço foi cadastrado com sucesso
        //Pega Dados Passados Por Post
        String nome = request.getParameter("nome");

//          Disciplina(String nome, Set<ProfessorDisciplina> professorDisciplinas)
        Disciplina disciplina = new Disciplina(nome, null);

        status = fabricaDisciplina.salvar(disciplina);

        request.setAttribute("opc", "disciplina_Cadastrar_disciplina");
        request.setAttribute("status", status);

        //Se fabricaDisciplina cadastrado com sucesso
        if (status)
        {
            request.setAttribute("mensagem_retorno", "Disciplina " + disciplina.getNome() + " Cadastrada Com Sucesso!");
        }
        else
        {
            request.setAttribute("mensagem_retorno", "Erro ao Cadastrar Disciplina!");
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
        if (request.getRequestURI().endsWith("/disciplina_Inicio"))
        {
            jsp = "/index.jsp";
        }
        else if (request.getRequestURI().endsWith("/disciplina_Form"))
        {
            request.setAttribute("opc", "cadastrar");
            //jsp = "/form_cadastro.jsp";
            jsp = "/presentation.jsp";
        }
        else if (request.getRequestURI().endsWith("/disciplina_Presentation"))
        {
            jsp = "/presentation.jsp";
        }
        else if (request.getRequestURI().endsWith("/disciplina_Form_cadastrar"))
        {
            request.setAttribute("opc", "disciplina_Cadastrar_disciplina");
            jsp = "/presentation.jsp";
        }
        else if (request.getRequestURI().endsWith("/disciplina_Cadastrar_disciplina"))
        {
            jsp = cadastrarDisciplina(request);
        }
        else if (request.getRequestURI().endsWith("/disciplina_Listar_disciplinas"))
        {
            jsp = listarDisciplinas(request);
        }
        else
        {
            jsp = "/index.jsp";
        }

        if (jsp == null)
        {
            response.sendRedirect(request.getContextPath() + "/disciplina_Inicio");
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
            throws ServletException, IOException {
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
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
