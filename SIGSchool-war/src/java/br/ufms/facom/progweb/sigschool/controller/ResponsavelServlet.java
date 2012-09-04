/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.controller;

import br.ufms.facom.progweb.sigschool.ejb.model.EnderecoMgrBeanLocal;
import br.ufms.facom.progweb.sigschool.ejb.model.ResponsavelMgrBeanLocal;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.endereco.Endereco;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.responsavel.Responsavel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Rodrigo Kuninari
 */
public class ResponsavelServlet extends HttpServlet {

    @EJB
    EnderecoMgrBeanLocal fabricaEndereco;
    @EJB
    ResponsavelMgrBeanLocal fabricaResponsavel;

    @Override
    public void init() throws ServletException {
    }

    private String listarResponsaveis(HttpServletRequest request) {

        String url = "/presentation.jsp";
        List funcionarios = fabricaResponsavel.listar();

        request.setAttribute("lstresponsaveis", funcionarios);
        request.setAttribute("opc", "responsavel_Listar_responsaveis");

        return url;
    }

    public String cadastrarResponsavel(HttpServletRequest request) {

        String jsp = "presentation.jsp";
        boolean status = false;

        /***************************************Cadastra Endereço*******************************************/
        String logradouro = request.getParameter("logradouro");
        int numero = Integer.parseInt(request.getParameter("numero"));
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");
        String cep = request.getParameter("cep");

        //Objeto Endereço
        Endereco endereco = new Endereco(logradouro, numero, bairro, cidade, uf, cep, null, null, null, null);

        //Retorno Salvar
        boolean sucesso = fabricaEndereco.salvar(endereco);
        /***************************************Cadastra Responsavel*******************************************/
        //Se endereço foi cadastrado com sucesso
        if (sucesso) {
            //Pega Dados Passados Por Post
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String sexo = request.getParameter("sexo");
            String telRes = request.getParameter("telRes");
            String telCel = request.getParameter("telCel");
            String rg = request.getParameter("rg");
            String cpf = request.getParameter("cpf");

//          Responsavel(String nome, Date dataNasc, String sexo, String telRes, String telCel, String email, boolean ativo, Endereco endereco, String cpf, String rg, Set<Aluno> alunos)
            Responsavel responsavel = new Responsavel(nome, null, sexo, telRes, telCel, email, true, endereco, cpf, rg, null);

            status = fabricaResponsavel.salvar(responsavel);

            request.setAttribute("opc", "responsavel_Cadastrar_responsavel");
            request.setAttribute("status", status);

            //Se fabricaResponsavel cadastrado com sucesso
            if (status) {
                request.setAttribute("mensagem_retorno", "Responsável " + responsavel.getNome() + " Cadastrado Com Sucesso!");
            } else {
                request.setAttribute("mensagem_retorno", "Erro ao Cadastrar Responsável!");
            }
        } else {
            request.setAttribute("mensagem_retorno", "Erro ao Cadastrar Endereço!");
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
            throws ServletException, IOException {
        String jsp = null;

        //redirect for the correct method in accordance with to received uri:
        if (request.getRequestURI().endsWith("/responsavel_Inicio")) {
            jsp = "/index.jsp";
        } else if (request.getRequestURI().endsWith("/responsavel_Form")) {
            request.setAttribute("opc", "cadastrar");
            //jsp = "/form_cadastro.jsp";
            jsp = "/presentation.jsp";
        } else if (request.getRequestURI().endsWith("/responsavel_Presentation")) {
            jsp = "/presentation.jsp";
        } else if (request.getRequestURI().endsWith("/responsavel_Form_cadastrar")) {
            request.setAttribute("opc", "responsavel_Cadastrar_responsavel");
            jsp = "/presentation.jsp";
        } else if (request.getRequestURI().endsWith("/responsavel_Cadastrar_responsavel")) {
            jsp = cadastrarResponsavel(request);
        } else if (request.getRequestURI().endsWith("/responsavel_Listar_responsaveis")) {
            jsp = listarResponsaveis(request);
        } else {
            jsp = "/index.jsp";
        }

        if (jsp == null) {
            response.sendRedirect(request.getContextPath() + "/responsavel_Inicio");
        } else if (!"empty".equals(jsp)) {
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
