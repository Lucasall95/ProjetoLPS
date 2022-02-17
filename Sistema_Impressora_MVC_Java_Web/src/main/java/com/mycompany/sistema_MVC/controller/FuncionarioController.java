/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema_MVC.controller;

import java.util.ArrayList;
import com.mycompany.sistema_MVC.model.DAO.FuncionarioDAO;
import com.mycompany.sistema_MVC.model.Funcionario;
import com.mycompany.sistema_MVC.view.FuncionarioView;

/**
 *
 * @author corns
 */
public class FuncionarioController {
    private Funcionario funcionario;
    private FuncionarioDAO funcionarioDAO;
    
    public FuncionarioController(){
        funcionarioDAO = new FuncionarioDAO();
    }
    
    public void abrirCadFuncionario(){
        FuncionarioView telaFuncionario = new FuncionarioView(this);
        telaFuncionario.setVisible(true);
    }
    
    public ArrayList<Object []> buscarFuncionario(){
        ArrayList<Object []> arrayObjFuncionario = new ArrayList<>();
        ArrayList<Object> arrayObj = funcionarioDAO.consultar(null);
        
        for(int i=0; i<arrayObj.size(); i++){
           Object[] arrayObjAl = new Object [7];
           arrayObjAl[0] = ((Funcionario)arrayObj.get(i)).getId();
           arrayObjAl[1] = ((Funcionario)arrayObj.get(i)).getNome();
           arrayObjAl[2] = ((Funcionario)arrayObj.get(i)).getSexo();
           arrayObjAl[3] = ((Funcionario)arrayObj.get(i)).getIdade();
           arrayObjAl[4] = ((Funcionario)arrayObj.get(i)).getCargo();
           arrayObjAl[5] = ((Funcionario)arrayObj.get(i)).getCPF();
           arrayObjAl[6] = ((Funcionario)arrayObj.get(i)).getSalario();
           
           arrayObjFuncionario.add(arrayObjAl);
       }
       return arrayObjFuncionario;
    }
    
    public int removerFuncionario(Object [] arrayFuncionario){
        return funcionarioDAO.excluir(arrayFuncionario[0]);
    }
    
    public int incluirFuncionario(Object [] arrayFuncionario){
        funcionario = new Funcionario();
        
        funcionario.setNome(arrayFuncionario[1].toString());
        funcionario.setSexo(arrayFuncionario[2].toString().toCharArray()[0]);
        funcionario.setIdade(Integer.parseInt(arrayFuncionario[3].toString()));
        funcionario.setCargo(arrayFuncionario[4].toString());
        funcionario.setCPF(arrayFuncionario[5].toString());
        funcionario.setSalario(Double.parseDouble(arrayFuncionario[6].toString()));
       
        return funcionarioDAO.inserir(funcionario);
    }
    
    public int modificarFuncionario(Object [] arrayFuncionario){
        funcionario = new Funcionario();
        
        funcionario.setId(Integer.parseInt(arrayFuncionario[0].toString()));
        funcionario.setNome(arrayFuncionario[1].toString());
        funcionario.setSexo(arrayFuncionario[2].toString().toCharArray()[0]);
        funcionario.setIdade(Integer.parseInt(arrayFuncionario[3].toString()));
        funcionario.setCargo(arrayFuncionario[4].toString());
        funcionario.setCPF(arrayFuncionario[5].toString());
        funcionario.setSalario(Double.parseDouble(arrayFuncionario[6].toString()));
       
        return funcionarioDAO.alterar(funcionario);
    }
}
