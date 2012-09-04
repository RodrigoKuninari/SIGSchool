/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.controller;

import br.ufms.facom.progweb.sigschool.ejb.model.HistoricoNotasMgrBeanLocal;
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
public class HistoricoNotasServlet extends HttpServlet
{
    @EJB
    HistoricoNotasMgrBeanLocal fabricaHistoricoNota;


    @Override
    public void init() throws ServletException
    {
    }

    private String listarHistoricoNota(HttpServletRequest request)
    {

        String url = "/presentation.jsp";
        List historicoNotas = fabricaHistoricoNota.listar();

        request.setAttribute("lsthistoricoNotas", historicoNotas);
        request.setAttribute("opc", "historicoNota_Listar_historicoNotas");

        return url;
    }

//    public void listarProfessores(HttpServletRequest request)
//    {
//        List professores = fabricaProfessor.listar();
//        request.setAttribute("lstprofessores", professores);
//    }
//
//    public void listarDisciplinas(HttpServletRequest request)
//    {
//        List disciplinas = fabricaDisciplina.listar();
//        request.setAttribute("lstdisciplinas", disciplinas);
//    }
//
//    public void listarCoordenadorTurmas(HttpServletRequest request)
//    {
//        List coordenadorTurmas = fabricaCoordenadorTurma.listar();
//        request.setAttribute("lstcoordenadorTurmas", coordenadorTurmas);
//    }

    public String cadastrarHistoricoNota(HttpServletRequest request)
    {
        return "";
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
        if (request.getRequestURI().endsWith("/historicoNota_Inicio"))
        {
            jsp = "/index.jsp";
        }
        else if (request.getRequestURI().endsWith("/historicoNota_Form"))
        {
            request.setAttribute("opc", "cadastrar");
            //jsp = "/form_cadastro.jsp";
            jsp = "/presentation.jsp";
        }
        else if (request.getRequestURI().endsWith("/historicoNota_Presentation"))
        {
            jsp = "/presentation.jsp";
        }
        else if (request.getRequestURI().endsWith("/historicoNota_Form_cadastrar"))
        {
            request.setAttribute("opc", "historicoNota_Cadastrar_historicoNota");
            jsp = "/presentation.jsp";
        }
        else if (request.getRequestURI().endsWith("/historicoNota_Cadastrar_historicoNota"))
        {
            jsp = cadastrarHistoricoNota(request);
        }
        else if (request.getRequestURI().endsWith("/historicoNota_Listar_historicoNotas"))
        {
            jsp = listarHistoricoNota(request);
        }
        else
        {
            jsp = "/index.jsp";
        }

        if (jsp == null)
        {
            response.sendRedirect(request.getContextPath() + "/historicoNota_Inicio");
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
