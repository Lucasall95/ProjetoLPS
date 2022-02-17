/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema_MVC.model.DAO;

import com.mycompany.sistema_MVC.model.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author corns
 */
public class FuncionarioDAO implements InterfaceDAO {
    private Funcionario funcionario;
    private String SQL;
    private PreparedStatement ps;
    private ResultSet rs;
    private int resultado;
    
    @Override
    public int inserir(Object obj) {
        resultado = -1;
        funcionario = (Funcionario) obj;
        SQL = "Insert into funcionario (nome, sexo, idade, cargo, cpf, salario) values (?,?,?,?,?,?)";
        try {
            
            ps = ConexaoBd.conectar().prepareStatement(SQL);
            ps.setString(1, funcionario.getNome());
            ps.setString(2,String.valueOf(funcionario.getSexo()));
            ps.setInt(3,funcionario.getIdade());
            ps.setString(4, funcionario.getCargo());
            ps.setString(5, funcionario.getCPF());
            ps.setDouble(6, funcionario.getSalario());
            
            resultado = ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public int alterar(Object obj) {
        resultado = -1;
        funcionario = (Funcionario) obj;
        SQL = "Update funcionario set nome =?, sexo =?, idade =?, cargo =?, cpf =?, salario =? where id =?";
        try {
            
            ps = ConexaoBd.conectar().prepareStatement(SQL);
            ps.setString(1, funcionario.getNome());
            ps.setString(2,String.valueOf(funcionario.getSexo()));
            ps.setInt(3,funcionario.getIdade());
            ps.setString(4, funcionario.getCargo());
            ps.setString(5, funcionario.getCPF());
            ps.setDouble(6, funcionario.getSalario());
            ps.setInt(7, funcionario.getId());
           
            resultado = ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public int excluir(Object obj) {
        resultado = -1;
        SQL = "Delete from funcionario where id = " + obj;
        try {
            ps = ConexaoBd.conectar().prepareStatement(SQL);
            resultado = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public ArrayList<Object> consultar(Object obj) {
        ArrayList<Object> arrayObj = new ArrayList();
       
        if(obj == null)
            SQL = "Select * from funcionario";
        else
            SQL = "Select * from funcionario where upper(nome) like upper ('%" + (Funcionario)obj + "%')";
        
        try {
            ps = ConexaoBd.conectar().prepareStatement(SQL);
            rs = ps.executeQuery();
            
            while(rs.next()){
                funcionario = new Funcionario();
                
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setSexo(rs.getString("sexo").charAt(0));
                funcionario.setIdade(rs.getInt("idade"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setCPF(rs.getString("cpf"));
                funcionario.setSalario(rs.getDouble("salario"));
                
                arrayObj.add(funcionario);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBd.desconectar();
        }
      
        return arrayObj;
        
    }
    
}
