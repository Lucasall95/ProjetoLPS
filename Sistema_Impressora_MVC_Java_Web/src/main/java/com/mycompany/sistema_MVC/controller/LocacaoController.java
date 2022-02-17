/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema_MVC.controller;

import java.text.ParseException;
import java.util.ArrayList;
import com.mycompany.sistema_MVC.model.DAO.LocacaoDAO;
import com.mycompany.sistema_MVC.model.Locacao;
import com.mycompany.sistema_MVC.view.LocacaoView;

/**
 *
 * @author corns
 */
public class LocacaoController {
    private Locacao locacao;
    private LocacaoDAO locacaoDAO;
    
    public LocacaoController(){
        locacaoDAO = new LocacaoDAO();
    }
    
    public void abrirCadLocacao(){
        LocacaoView telaLocacao = new LocacaoView(this);
        telaLocacao.setVisible(true);
    }
    
    public ArrayList<Object []> buscarLocacao(){
        ArrayList<Object []> arrayObjLocacao = new ArrayList<>();
        ArrayList<Object> arrayObj = locacaoDAO.consultar(null);
        
        for(int i=0; i<arrayObj.size(); i++){
           Object[] arrayObjAl = new Object [6];
           arrayObjAl[0] = ((Locacao)arrayObj.get(i)).getId();
           arrayObjAl[1] = ((Locacao)arrayObj.get(i)).getTamanho();
           arrayObjAl[2] = ((Locacao)arrayObj.get(i)).getTipoMaquina();
           arrayObjAl[3] = ((Locacao)arrayObj.get(i)).getFinalidade();
           arrayObjAl[4] = ((Locacao)arrayObj.get(i)).getQtdMaquinas();
           arrayObjAl[5] = ((Locacao)arrayObj.get(i)).getTempoDeUso();
           
           arrayObjLocacao.add(arrayObjAl);
       }
       return arrayObjLocacao;
    }
    
    public int removerLocacao(Object [] arrayLocacao){
        return locacaoDAO.excluir(arrayLocacao[0]);
    }
    
    public int incluirLocacao(Object [] arrayLocacao){
        locacao = new Locacao();
        
        locacao.setTamanho(arrayLocacao[1].toString());
        locacao.setTipoMaquina(arrayLocacao[2].toString());
        locacao.setFinalidade(arrayLocacao[3].toString());
        locacao.setQtdMaquinas(Integer.parseInt(arrayLocacao[4].toString()));
        locacao.setTempoDeUso(arrayLocacao[5].toString());
        
       
        return locacaoDAO.inserir(locacao);
    }
    
    public int modificarLocacao(Object [] arrayLocacao){
        locacao = new Locacao();
       
        locacao.setId(Integer.parseInt(arrayLocacao[0].toString()));
        locacao.setTamanho(arrayLocacao[1].toString());
        locacao.setTipoMaquina(arrayLocacao[2].toString());
        locacao.setFinalidade(arrayLocacao[3].toString());
        locacao.setQtdMaquinas(Integer.parseInt(arrayLocacao[4].toString()));
        locacao.setTempoDeUso(arrayLocacao[5].toString());
        
       
        return locacaoDAO.alterar(locacao);
    }
}
