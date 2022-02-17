/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema_MVC.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author corns
 */
@WebServlet(name = "LocacaoServlet", urlPatterns = {"/LocacaoServlet"})
public class LocacaoServlet extends HttpServlet {
    private String operacao;
    private int resultado;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Object [] arrayLocacao = new Object[6];
        
        arrayLocacao[0] = request.getParameter("id");
        arrayLocacao[1] = request.getParameter("tam_maquina");
        arrayLocacao[2] = request.getParameter("tipo_maquina");
        arrayLocacao[3] = request.getParameter("finalidade");
        arrayLocacao[4] = request.getParameter("qtd_maquina");
        arrayLocacao[5] = request.getParameter("tempo_locacao");
        
        if(request.getParameter("incluir").equals("Incluir")){
            LocacaoController locacaoController = new LocacaoController();
            resultado = locacaoController.incluirLocacao(arrayLocacao);
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cadastro Locacao</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet LocacaoServlet at " + request.getContextPath() + "</h1>");
            if(resultado > 0)
                out.println("<h1 align='center'>Locacao Efetuada com sucesso!</h1>");
            else
                out.println("<h1 align='center'>Erro ao Efetuar Locacao!</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
