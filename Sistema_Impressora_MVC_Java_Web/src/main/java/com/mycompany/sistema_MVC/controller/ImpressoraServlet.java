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
@WebServlet(name = "ImpressoraServlet", urlPatterns = {"/ImpressoraServlet"})
public class ImpressoraServlet extends HttpServlet {
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
        
        Object [] arrayImpressora = new Object[6];
        
        arrayImpressora[0] = request.getParameter("id");
        arrayImpressora[1] = request.getParameter("nome");
        arrayImpressora[2] = request.getParameter("tipo_impressora");
        arrayImpressora[3] = request.getParameter("marca_impressora");
        arrayImpressora[4] = request.getParameter("modelo_impressora");
        arrayImpressora[5] = request.getParameter("colorida");
        
        if(request.getParameter("incluir").equals("Incluir")){
            ImpressoraController impressoraController = new ImpressoraController();
            resultado = impressoraController.incluirImpressora(arrayImpressora);
        }
        
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cadastro Impressora</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet ImpressoraServlet at " + request.getContextPath() + "</h1>");
            if(resultado > 0)
                out.println("<h1 align='center'>Impressora Cadastrada com sucesso!</h1>");
            else
                out.println("<h1 align='center'>Erro ao Cadastrar Impressora!</h1>");
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
