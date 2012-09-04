/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.facom.progweb.sigschool.controller;

import br.ufms.facom.progweb.sigschool.ejb.model.AlunoMgrBeanLocal;
import br.ufms.facom.progweb.sigschool.ejb.model.EnderecoMgrBeanLocal;
import br.ufms.facom.progweb.sigschool.ejb.model.HistoricoMgrBeanLocal;
import br.ufms.facom.progweb.sigschool.ejb.model.ResponsavelMgrBeanLocal;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.aluno.Aluno;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.endereco.Endereco;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.historico.Historico;
import br.ufms.facom.progweb.sigschool.ejb.model.dao.responsavel.Responsavel;
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
 * @author rodrigo_kuninari
 */
public class AlunoServlet extends HttpServlet
{
    @EJB
    EnderecoMgrBeanLocal fabricaEndereco;
    @EJB
    AlunoMgrBeanLocal fabricaAluno;
    @EJB
    ResponsavelMgrBeanLocal fabricaResponsavel;
    @EJB
    HistoricoMgrBeanLocal fabricaHistorico;

    @Override
    public void init() throws ServletException
    {
    }

    private String listarAlunos(HttpServletRequest request)
    {

        String url = "/presentation.jsp";
        List alunos = fabricaAluno.listar();

        request.setAttribute("lstalunos", alunos);
        request.setAttribute("opc", "aluno_Listar_alunos");

        return url;
    }

    public void listarResponsaveis(HttpServletRequest request)
    {
        List responsaveis = fabricaResponsavel.listar();
        request.setAttribute("lstresponsaveis", responsaveis);
    }

    public String cadastrarAluno(HttpServletRequest request)
    {

        String jsp = "presentation.jsp";
        boolean status = false;

        /***************************************Cadastra Aluno*******************************************/
        String logradouro = request.getParameter("logradouro");
        int numero = Integer.parseInt(request.getParameter("numero"));
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");
        String cep = request.getParameter("cep");
        int idResponsavel = Integer.parseInt(request.getParameter("responsavel"));

        Responsavel responsavel = fabricaResponsavel.buscar(idResponsavel);

        //Objeto Endereço
        Endereco endereco = new Endereco(logradouro, numero, bairro, cidade, uf, cep, null, null, null, null);

        //Retorno Salvar
        boolean sucesso = fabricaEndereco.salvar(endereco);
        /***************************************Cadastra Responsavel*******************************************/
        //Se endereço foi cadastrado com sucesso
        if (sucesso)
        {
            //Pega Dados Passados Por Post
            int matricula = Integer.parseInt(request.getParameter("matricula"));
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String sexo = request.getParameter("sexo");
            String telRes = request.getParameter("telRes");
            String telCel = request.getParameter("telCel");

//          Aluno(String nome, Date dataNasc, String sexo, String telRes, String telCel, String email, boolean ativo, Endereco endereco, int matricula, Responsavel responsavel, Historico historico)
            Aluno aluno = new Aluno(nome, null, sexo, telRes, telCel, email, true, endereco, matricula, responsavel, null);

            status = fabricaAluno.salvar(aluno);

            request.setAttribute("opc", "aluno_Cadastrar_aluno");
            request.setAttribute("status", status);

            //Se fabricaAluno cadastrado com sucesso
            if (status)
            {
                Historico historico = new Historico("Esperando", aluno, null, null);
                boolean retHistorico = fabricaHistorico.salvar(historico);
                if (retHistorico)
                {
                    request.setAttribute("mensagem_retorno", "Aluno " + aluno.getNome() + " Cadastrado Com Sucesso!");
                }
                else
                {
                    request.setAttribute("mensagem_retorno", "Erro ao Cadastrar Aluno!");
                }
            }
            else
            {
                request.setAttribute("mensagem_retorno", "Erro ao Cadastrar Aluno!");
            }
        }
        else
        {
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
            throws ServletException, IOException
    {
        String jsp = null;

        //redirect for the correct method in accordance with to received uri:
        if (request.getRequestURI().endsWith("/aluno_Inicio"))
        {
            jsp = "/index.jsp";
        }
        else if (request.getRequestURI().endsWith("/aluno_Form"))
        {
            request.setAttribute("opc", "cadastrar");
            //jsp = "/form_cadastro.jsp";
            jsp = "/presentation.jsp";
        }
        else if (request.getRequestURI().endsWith("/aluno_Presentation"))
        {
            jsp = "/presentation.jsp";
        }
        else if (request.getRequestURI().endsWith("/aluno_Form_cadastrar"))
        {
            listarResponsaveis(request);
            request.setAttribute("opc", "aluno_Cadastrar_aluno");
            jsp = "/presentation.jsp";
        }
        else if (request.getRequestURI().endsWith("/aluno_Cadastrar_aluno"))
        {
            jsp = cadastrarAluno(request);
        }
        else if (request.getRequestURI().endsWith("/aluno_Listar_alunos"))
        {
            jsp = listarAlunos(request);
        }
        else
        {
            jsp = "/index.jsp";
        }

        if (jsp == null)
        {
            response.sendRedirect(request.getContextPath() + "/aluno_Inicio");
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
