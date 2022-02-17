/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema_MVC.controller;

import java.util.ArrayList;
import com.mycompany.sistema_MVC.model.DAO.ImpressoraDAO;
import com.mycompany.sistema_MVC.model.Impressora;
import com.mycompany.sistema_MVC.view.ImpressoraView;

/**
 *
 * @author corns
 */
public class ImpressoraController {
    private Impressora impressora;
    private ImpressoraDAO impressoraDAO;
    
    public ImpressoraController(){
        impressoraDAO = new ImpressoraDAO();
    }
    
    public void abrirCadImpressora(){
        ImpressoraView telaImpressora = new ImpressoraView(this);
        telaImpressora.setVisible(true);
    }
    
    public ArrayList<Object []> buscarImpressora(){
        ArrayList<Object []> arrayObjImpressora = new ArrayList<>();
        ArrayList<Object> arrayObj = impressoraDAO.consultar(null);
        
        for(int i=0; i<arrayObj.size(); i++){
           Object[] arrayObjAl = new Object [6];
           arrayObjAl[0] = ((Impressora)arrayObj.get(i)).getId();
           arrayObjAl[1] = ((Impressora)arrayObj.get(i)).getNome();
           arrayObjAl[2] = ((Impressora)arrayObj.get(i)).getTipo();
           arrayObjAl[3] = ((Impressora)arrayObj.get(i)).getMarca();
           arrayObjAl[4] = ((Impressora)arrayObj.get(i)).getModelo();
           arrayObjAl[5] = ((Impressora)arrayObj.get(i)).isColorida();
           
           arrayObjImpressora.add(arrayObjAl);
       }
       return arrayObjImpressora;
    }
    
    public int removerImpressora(Object [] arrayImpressora){
        return impressoraDAO.excluir(arrayImpressora[0]);
    }
    
    public int incluirImpressora(Object [] arrayImpressora){
        impressora = new Impressora();
        
        impressora.setNome(arrayImpressora[1].toString());
        impressora.setTipo(arrayImpressora[2].toString());
        impressora.setMarca(arrayImpressora[3].toString());
        impressora.setModelo(arrayImpressora[4].toString());
        impressora.setColorida(Boolean.parseBoolean(arrayImpressora[5].toString()));
        
       
        return impressoraDAO.inserir(impressora);
    }
    
    public int modificarImpressora(Object [] arrayImpressora){
        impressora = new Impressora();
        
        impressora.setId(Integer.parseInt(arrayImpressora[0].toString()));
        impressora.setNome(arrayImpressora[1].toString());
        impressora.setTipo(arrayImpressora[2].toString());
        impressora.setMarca(arrayImpressora[3].toString());
        impressora.setModelo(arrayImpressora[4].toString());
        impressora.setColorida(Boolean.parseBoolean(arrayImpressora[5].toString()));
        
       
        return impressoraDAO.alterar(impressora);
    }
}
