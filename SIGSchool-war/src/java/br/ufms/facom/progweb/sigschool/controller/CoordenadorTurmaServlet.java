/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.controller;

import br.ufms.facom.progweb.sigschool.ejb.model.CoordenadorMgrBeanLocal;
import br.ufms.facom.progweb.sigschool.ejb.model.CoordenadorTurmaMgrBeanLocal;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.coordenador.Coordenador;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.coordenadorTurma.CoordenadorTurma;
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
public class CoordenadorTurmaServlet extends HttpServlet
{
    @EJB
    CoordenadorTurmaMgrBeanLocal fabricaCoordenadorTurma;
    @EJB
    CoordenadorMgrBeanLocal fabricaCoordenador;

    @Override
    public void init() throws ServletException
    {
    }

    private String listarCoordenadorTurmas(HttpServletRequest request)
    {

        String url = "/presentation.jsp";
        List coordenadorTurmas = fabricaCoordenadorTurma.listar();

        request.setAttribute("lstcoordenadorTurmas", coordenadorTurmas);
        request.setAttribute("opc", "coordenadorTurma_Listar_coordenadorTurmas");

        return url;
    }
    
    public void listarCoordenadores(HttpServletRequest request)
    {
        List coordenadores = fabricaCoordenador.listar();
        request.setAttribute("lstcoordenadores", coordenadores);
    }

    public String cadastrarCoordenadorTurma(HttpServletRequest request)
    {

        String jsp = "presentation.jsp";
        boolean status = false;

        /***************************************Cadastra Coordenador Turma*******************************************/
        //Se endereço foi cadastrado com sucesso
        //Pega Dados Passados Por Post
        int ano = Integer.parseInt(request.getParameter("ano"));
        int serie = Integer.parseInt(request.getParameter("serie"));
        int idCoordenador = Integer.parseInt(request.getParameter("coordenador"));
        
        Coordenador coordenador = fabricaCoordenador.buscar(idCoordenador);

//          CoordenadorTurma(int ano, int serie, Coordenador coordenador, Set<ProfessorDisciplina> professorDisciplinas, Set<Turma> turmas)
        CoordenadorTurma coordenadorTurma = new CoordenadorTurma(ano, serie, coordenador, null, null);

        status = fabricaCoordenadorTurma.salvar(coordenadorTurma);

        request.setAttribute("opc", "coordenadorTurma_Cadastrar_coordenadorTurma");
        request.setAttribute("status", status);

        //Se fabricaCoordenadorTurma cadastrado com sucesso
        if (status)
        {
            request.setAttribute("mensagem_retorno", "Coordenador " + coordenadorTurma.getCoordenador().getNome() + " definido na Turma " + coordenadorTurma.getAno());
        }
        else
        {
            request.setAttribute("mensagem_retorno", "Erro ao Definir o Coordenador da Turma!");
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
        if (request.getRequestURI().endsWith("/coordenadorTurma_Inicio"))
        {
            jsp = "/index.jsp";
        }
        else if (request.getRequestURI().endsWith("/coordenadorTurma_Form"))
        {
            request.setAttribute("opc", "cadastrar");
            //jsp = "/form_cadastro.jsp";
            jsp = "/presentation.jsp";
        }
        else if (request.getRequestURI().endsWith("/coordenadorTurma_Presentation"))
        {
            jsp = "/presentation.jsp";
        }
        else if (request.getRequestURI().endsWith("/coordenadorTurma_Form_cadastrar"))
        {
            listarCoordenadores(request);
            request.setAttribute("opc", "coordenadorTurma_Cadastrar_coordenadorTurma");
            jsp = "/presentation.jsp";
        }
        else if (request.getRequestURI().endsWith("/coordenadorTurma_Cadastrar_coordenadorTurma"))
        {
            jsp = cadastrarCoordenadorTurma(request);
        }
        else if (request.getRequestURI().endsWith("/coordenadorTurma_Listar_coordenadorTurmas"))
        {
            jsp = listarCoordenadorTurmas(request);
        }
        else
        {
            jsp = "/index.jsp";
        }

        if (jsp == null)
        {
            response.sendRedirect(request.getContextPath() + "/coordenadorTurma_Inicio");
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
