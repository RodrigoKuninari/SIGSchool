/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.controller;

import br.ufms.facom.progweb.sigschool.ejb.model.HistoricoNotasMgrBean;
import br.ufms.facom.progweb.sigschool.ejb.model.HistoricoNotasMgrBeanLocal;
import br.ufms.facom.progweb.sigschool.ejb.model.ProfessorDisciplinaMgrBeanLocal;
import br.ufms.facom.progweb.sigschool.ejb.model.TipoAvaliacaoMgrBeanLocal;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.historicoNotas.HistoricoNotas;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.tipoAvaliacao.TipoAvaliacao;
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
public class TipoAvaliacaoServlet extends HttpServlet
{
    @EJB
    TipoAvaliacaoMgrBeanLocal fabricaTipoAvaliacao;
    @EJB
    ProfessorDisciplinaMgrBeanLocal fabricaProfessorDisciplina;
    @EJB
    HistoricoNotasMgrBeanLocal fabricaHistoricoNotas;

    @Override
    public void init() throws ServletException
    {
    }

    private String listarTipoAvaliacoes(HttpServletRequest request)
    {

        String url = "/presentation.jsp";
        List tipoAvaliacoes = fabricaTipoAvaliacao.listar();

        request.setAttribute("lsttipoAvaliacoes", tipoAvaliacoes);
        request.setAttribute("opc", "tipoAvaliacao_Listar_tipoAvaliacoes");

        return url;
    }

    public void listarProfessorDisciplinas(HttpServletRequest request)
    {
        List professorDisciplinas = fabricaProfessorDisciplina.listar();
        request.setAttribute("lstprofessorDisciplinas", professorDisciplinas);
    }

    public String cadastrarTipoAvaliacao(HttpServletRequest request)
    {

        String jsp = "presentation.jsp";
        boolean status = false;

        /***************************************Cadastra Coordenador Turma*******************************************/
        //Se endereço foi cadastrado com sucesso
        //Pega Dados Passados Por Post
        int idProfessorDisciplina = Integer.parseInt(request.getParameter("professorDisciplina"));
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");

        List listHistoricoNotas = fabricaHistoricoNotas.listarProfessorDisciplina(idProfessorDisciplina);

        for (HistoricoNotas hn : (List<HistoricoNotas>) listHistoricoNotas)
        {
            HistoricoNotas historicoNota = fabricaHistoricoNotas.buscar(hn.getId());
            //          TipoAvaliacao(Date data, String nome, String descricao, float nota, HistoricoNotas historicoNotas)
            TipoAvaliacao tipoAvaliacao = new TipoAvaliacao(null, nome, descricao, 0, historicoNota);
            boolean sucess = fabricaTipoAvaliacao.salvar(tipoAvaliacao);
        }

        listarProfessorDisciplinas(request);
        request.setAttribute("opc", "tipoAvaliacao_Cadastrar_tipoAvaliacao");
        request.setAttribute("status", status);

        status = true;
        //Se fabricaTipoAvaliacao cadastrado com sucesso
        if (status)
        {
            request.setAttribute("mensagem_retorno", "Avaliacao da Disciplina cadastrada com Sucesso!");
        }
        else
        {
            request.setAttribute("mensagem_retorno", "Erro ao cadastrar Avaliacao da Disciplina!");
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
        if (request.getRequestURI().endsWith("/tipoAvaliacao_Inicio"))
        {
            jsp = "/index.jsp";
        }
        else if (request.getRequestURI().endsWith("/tipoAvaliacao_Form"))
        {
            request.setAttribute("opc", "cadastrar");
            //jsp = "/form_cadastro.jsp";
            jsp = "/presentation.jsp";
        }
        else if (request.getRequestURI().endsWith("/tipoAvaliacao_Presentation"))
        {
            jsp = "/presentation.jsp";
        }
        else if (request.getRequestURI().endsWith("/tipoAvaliacao_Form_cadastrar"))
        {
            listarProfessorDisciplinas(request);
            request.setAttribute("opc", "tipoAvaliacao_Cadastrar_tipoAvaliacao");
            jsp = "/presentation.jsp";
        }
        else if (request.getRequestURI().endsWith("/tipoAvaliacao_Cadastrar_tipoAvaliacao"))
        {
            jsp = cadastrarTipoAvaliacao(request);
        }
        else if (request.getRequestURI().endsWith("/tipoAvaliacao_Listar_tipoAvaliacoes"))
        {
            jsp = listarTipoAvaliacoes(request);
        }
        else
        {
            jsp = "/index.jsp";
        }

        if (jsp == null)
        {
            response.sendRedirect(request.getContextPath() + "/tipoAvaliacao_Inicio");
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
