/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema_MVC.model.DAO;

import java.util.ArrayList;

/**
 *
 * @author corns
 */
public interface InterfaceDAO {
    
    public int inserir(Object obj);
    public int alterar(Object obj);
    public int excluir(Object obj);
    public ArrayList<Object> consultar(Object obj);
   
    
    
    
}
