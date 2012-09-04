/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.controller;

import br.ufms.facom.progweb.sigschool.ejb.model.CoordenadorMgrBeanLocal;
import br.ufms.facom.progweb.sigschool.ejb.model.EnderecoMgrBeanLocal;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.coordenador.Coordenador;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.endereco.Endereco;
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
public class CoordenadorServlet extends HttpServlet {

    @EJB
    EnderecoMgrBeanLocal fabricaEndereco;
    @EJB
    CoordenadorMgrBeanLocal fabricaCoordenador;

    @Override
    public void init() throws ServletException {
    }

    private String listarCoordenadores(HttpServletRequest request) {

        String url = "/presentation.jsp";
        List funcionarios = fabricaCoordenador.listar();

        request.setAttribute("lstcoordenadores", funcionarios);
        request.setAttribute("opc", "coordenador_Listar_coordenadores");

        return url;
    }

    public String cadastrarCoordenador(HttpServletRequest request) {

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
        /***************************************Cadastra Coordenador*******************************************/
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
            int matricula = Integer.parseInt(request.getParameter("matricula"));

//          Coordenador(String nome, Date dataNasc, String sexo, String telRes, String telCel, String email, boolean ativo, Endereco endereco, String cpf, String rg, int matricula, String curriculum, Set<Turma> turmas)
            Coordenador coordenador = new Coordenador(nome, null, sexo, telRes, telCel, email, true, endereco, cpf, rg, matricula, "curriculum", null);

            status = fabricaCoordenador.salvar(coordenador);

            request.setAttribute("opc", "coordenador_Cadastrar_coordenador");
            request.setAttribute("status", status);

            //Se fabricaCoordenador cadastrado com sucesso
            if (status) {
                request.setAttribute("mensagem_retorno", "Coordenador " + coordenador.getNome() + " Cadastrado Com Sucesso!");
            } else {
                request.setAttribute("mensagem_retorno", "Erro ao Cadastrar Coordenador!");
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
        if (request.getRequestURI().endsWith("/coordenador_Inicio")) {
            jsp = "/index.jsp";
        } else if (request.getRequestURI().endsWith("/coordenador_Form")) {
            request.setAttribute("opc", "cadastrar");
            //jsp = "/form_cadastro.jsp";
            jsp = "/presentation.jsp";
        } else if (request.getRequestURI().endsWith("/coordenador_Presentation")) {
            jsp = "/presentation.jsp";
        } else if (request.getRequestURI().endsWith("/coordenador_Form_cadastrar")) {
            request.setAttribute("opc", "coordenador_Cadastrar_coordenador");
            jsp = "/presentation.jsp";
        } else if (request.getRequestURI().endsWith("/coordenador_Cadastrar_coordenador")) {
            jsp = cadastrarCoordenador(request);
        } else if (request.getRequestURI().endsWith("/coordenador_Listar_coordenadores")) {
            jsp = listarCoordenadores(request);
        } else {
            jsp = "/index.jsp";
        }

        if (jsp == null) {
            response.sendRedirect(request.getContextPath() + "/coordenador_Inicio");
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
