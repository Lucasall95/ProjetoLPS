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
@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/FuncionarioServlet"})
public class FuncionarioServlet extends HttpServlet {
    private String operacao;
    private int resultado;
    //FuncionarioController funcionarioController;
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
        
        Object [] arrayFuncionario = new Object[7];
        
        arrayFuncionario[0] = request.getParameter("id");
        arrayFuncionario[1] = request.getParameter("nome");
        arrayFuncionario[2] = request.getParameter("sexo");
        arrayFuncionario[3] = request.getParameter("idade");
        arrayFuncionario[4] = request.getParameter("cargo");
        arrayFuncionario[5] = request.getParameter("cpf");
        arrayFuncionario[6] = request.getParameter("salario");
        
        if(request.getParameter("incluir").equals("Incluir")){
            FuncionarioController funcionarioController = new FuncionarioController();
            resultado = funcionarioController.incluirFuncionario(arrayFuncionario);
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FuncionarioServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet FuncionarioServlet at " + request.getContextPath() + "</h1>");
            if(resultado > 0)
                out.println("<h1 align='center'>Funcionario(a) Cadastrado com sucesso!</h1>");
            else
                out.println("<h1 align='center'>Erro ao Cadastrar Funcionario(a)!</h1>");
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
