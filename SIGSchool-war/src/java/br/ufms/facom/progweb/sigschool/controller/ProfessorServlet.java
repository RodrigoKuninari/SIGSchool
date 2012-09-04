/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.controller;

import br.ufms.facom.progweb.sigschool.ejb.model.EnderecoMgrBeanLocal;
import br.ufms.facom.progweb.sigschool.ejb.model.ProfessorMgrBeanLocal;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.endereco.Endereco;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.professor.Professor;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rodrigo Kuninari
 */
public class ProfessorServlet extends HttpServlet {

    @EJB
    EnderecoMgrBeanLocal fabricaEndereco;
    @EJB
    ProfessorMgrBeanLocal fabricaProfessor;

    @Override
    public void init() throws ServletException {
    }

    //Desativar Professor
    private String desativarProfessor(int id_professor, HttpServletRequest request) {

        String url = "/presentation.jsp";

        //Retorno Salvar
        boolean sucesso = fabricaProfessor.desativar(id_professor);

        List professores = fabricaProfessor.listar();
        request.setAttribute("lstprofessores", professores);
        request.setAttribute("opc", "professor_Listar_professores");

        return url;
    }

    //Editar Professor
    private String editarProfessor(HttpServletRequest request) {

        String url = "/presentation.jsp";

        /***************************************Editar Endereço*******************************************/
        int id_endereco = Integer.parseInt(request.getParameter("id_endereco"));
        String logradouro = request.getParameter("logradouro");
        int numero = Integer.parseInt(request.getParameter("numero"));
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");
        String cep = request.getParameter("cep");

        //Objeto Endereço
        Endereco endereco = new Endereco(logradouro, numero, bairro, cidade, uf, cep, null, null, null, null);

        //Retorno Salvar
        boolean sucesso = fabricaEndereco.editar(id_endereco, endereco);

        List professores = fabricaProfessor.listar();
        request.setAttribute("lstprofessores", professores);
        request.setAttribute("opc", "professor_Listar_professores");
        
        /***************************************Editar Professor******************************************/
        //Pega Dados Passados Por Post
        int id_professor = Integer.parseInt(request.getParameter("id_professor"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String sexo = request.getParameter("sexo");
        String telRes = request.getParameter("telRes");
        String telCel = request.getParameter("telCel");
        String rg = request.getParameter("rg");
        String cpf = request.getParameter("cpf");
        String dataNasc = request.getParameter("dataNasc");
        int matricula = Integer.parseInt(request.getParameter("matricula"));

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;

        try {
            date = (Date) formatter.parse(dataNasc);
        } catch (ParseException ex) {
            date = null;
        }

        //Todo professor é cadastrado como ativo
        boolean ativo = true;

        Professor prof = new Professor(nome, date, sexo, telRes, telCel, email, ativo, endereco, cpf, rg, matricula, "curriculum", null);

        boolean status = fabricaProfessor.editar(id_professor,prof);

        return url;
    }

    private String listarProfessores(HttpServletRequest request) {

        String url = "/presentation.jsp";
        List funcionarios = fabricaProfessor.listar();

        request.setAttribute("lstprofessores", funcionarios);
        request.setAttribute("opc", "professor_Listar_professores");

        return url;
    }

    public String cadastrarProfessor(HttpServletRequest request) {

        String jsp = "/presentation.jsp";
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
        /***************************************Cadastra Professor*******************************************/
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
            String dataNasc = request.getParameter("dataNasc");
            int matricula = Integer.parseInt(request.getParameter("matricula"));

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = null;

            try {
                date = (Date) formatter.parse(dataNasc);
            } catch (ParseException ex) {
                date = null;
            }

            //Todo professor é cadastrado como ativo
            boolean ativo = true;

            Professor prof = new Professor(nome, date, sexo, telRes, telCel, email, ativo, endereco, cpf, rg, matricula, "curriculum", null);

            status = fabricaProfessor.salvar(prof);

            List funcionarios = fabricaProfessor.listar();

            request.setAttribute("lstprofessores", funcionarios);
            request.setAttribute("opc", "professor_Listar_professores");
            request.setAttribute("status", status);

            //Se fabricaProfessor cadastrado com sucesso
            if (status) {
                request.setAttribute("mensagem_retorno", "Professor " + prof.getNome() + " Cadastrado Com Sucesso!");
            } else {
                request.setAttribute("mensagem_retorno", "Erro ao Cadastrar Professor!");
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
        if (request.getRequestURI().endsWith("/professor_Inicio")) {
            jsp = "/index.jsp";
        } else if (request.getRequestURI().endsWith("/professor_Form")) {
            request.setAttribute("opc", "cadastrar");
            //jsp = "/form_cadastro.jsp";
            jsp = "/presentation.jsp";
        } else if (request.getRequestURI().endsWith("/professor_Presentation")) {
            request.setAttribute("opc", "");
            jsp = "/presentation.jsp";
        } else if (request.getRequestURI().endsWith("/professor_Form_cadastrar")) {
            request.setAttribute("opc", "professor_Cadastrar_professor");
            jsp = "/presentation.jsp";

        } else if (request.getRequestURI().endsWith("/professor_Cadastrar_professor")) {
            jsp = cadastrarProfessor(request);
        } else if (request.getRequestURI().endsWith("/professor_Listar_professores")) {
            jsp = listarProfessores(request);
        } else if (request.getRequestURI().endsWith("/professor_Editar_professor")) {
            jsp = editarProfessor(request);
        } else if (request.getRequestURI().endsWith("/professor_Desativar_professor")) {
            //Pega o id do professor passado por get
            int id_professor = Integer.parseInt(request.getParameter("id_professor"));

            jsp = desativarProfessor(id_professor, request);
        } else if (request.getRequestURI().endsWith("/professor_Form_editar")) {

            //Pega o id do professor passado por get
            int id_professor = Integer.parseInt(request.getParameter("id_professor"));

            //Busca dados do professor pelo id
            Professor professor = fabricaProfessor.buscar(id_professor);

            //Seta dados do professor nas variáveis
            int matricula = professor.getMatricula();
            String nome = professor.getNome();
            String cpf = professor.getCpf();
            String rg = professor.getRg();
            String sexo = professor.getSexo();
            String email = professor.getEmail();
            String telRes = professor.getTelRes();
            String telCel = professor.getTelCel();
            Date dataNasc = professor.getDataNasc();

            //Formata data
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String date = simpleDateFormat.format(dataNasc);

            //Seta dados no formulário de edição
            request.setAttribute("id_professor", id_professor);
            request.setAttribute("matricula", matricula);
            request.setAttribute("nome", nome);
            request.setAttribute("cpf", cpf);
            request.setAttribute("rg", rg);
            request.setAttribute("sexo", sexo);
            request.setAttribute("email", email);
            request.setAttribute("telRes", telRes);
            request.setAttribute("telCel", telCel);
            request.setAttribute("dataNasc", date);

            /************************************Endereço*******************************/
            //Pega endereço do professor
            Endereco endereco = professor.getEndereco();

            long id_endereco = endereco.getId();
            String logradouro = endereco.getLogradouro();
            int numero = endereco.getNumero();
            String bairro = endereco.getBairro();
            String cidade = endereco.getCidade();
            String uf = endereco.getUf();
            String cep = endereco.getCep();

            request.setAttribute("opc", "professor_Editar_professor");
            request.setAttribute("id_endereco", id_endereco);
            request.setAttribute("logradouro", logradouro);
            request.setAttribute("numero", numero);
            request.setAttribute("bairro", bairro);
            request.setAttribute("cidade", cidade);
            request.setAttribute("uf", uf);
            request.setAttribute("cep", cep);

            jsp = "/presentation.jsp";
        } else {
            jsp = "/index.jsp";
        }

        if (jsp == null) {
            response.sendRedirect(request.getContextPath() + "/professor_Inicio");
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
