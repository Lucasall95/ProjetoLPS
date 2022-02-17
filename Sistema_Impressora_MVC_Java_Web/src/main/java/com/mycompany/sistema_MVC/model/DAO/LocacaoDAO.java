/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema_MVC.model.DAO;

import com.mycompany.sistema_MVC.model.Locacao;
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
public class LocacaoDAO implements InterfaceDAO {
    private Locacao locacao;
    private String SQL;
    private PreparedStatement ps;
    private ResultSet rs;
    private int resultado;
    
    @Override
    public int inserir(Object obj) {
        resultado = -1;
        locacao = (Locacao) obj;
        SQL = "Insert into locacao (tam_maquina, tipo_maquina, finalidade, qtd_maquina, tempo_locacao) values (?,?,?,?,?)";
        try {
            
            ps = ConexaoBd.conectar().prepareStatement(SQL);
            ps.setString(1, locacao.getTamanho());
            ps.setString(2, locacao.getTipoMaquina());
            ps.setString(3,locacao.getFinalidade());
            ps.setInt(4, locacao.getQtdMaquinas());
            ps.setString(5,locacao.getTempoDeUso());
            resultado = ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public int alterar(Object obj) {
        resultado = -1;
        locacao = (Locacao) obj;
        SQL = "Update locacao set tam_maquina =?, tipo_maquina =?, finalidade =?, qtd_maquina =?, tempo_locacao =? where id =?";
        try {
            
            ps = ConexaoBd.conectar().prepareStatement(SQL);
            ps.setString(1, locacao.getTamanho());
            ps.setString(2, locacao.getTipoMaquina());
            ps.setString(3,locacao.getFinalidade());
            ps.setInt(4, locacao.getQtdMaquinas());
            ps.setString(5,locacao.getTempoDeUso());
            ps.setInt(6, locacao.getId());
            
            resultado = ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public int excluir(Object obj) {
        resultado = -1;
        SQL = "Delete from locacao where id = " + obj;
        try {
            ps = ConexaoBd.conectar().prepareStatement(SQL);
            resultado = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public ArrayList<Object> consultar(Object obj) {
        ArrayList<Object> arrayObj = new ArrayList();
       
        if(obj == null)
            SQL = "Select * from locacao";
        else
            SQL = "Select * from locacao where upper(id) like upper ('%" + (Locacao)obj + "%')";
        
        try {
            ps = ConexaoBd.conectar().prepareStatement(SQL);
            rs = ps.executeQuery();
            
            while(rs.next()){
                locacao = new Locacao();
                
                locacao.setId(rs.getInt("id"));
                locacao.setTamanho(rs.getString("tam_maquina"));
                locacao.setTipoMaquina(rs.getString("tipo_maquina"));
                locacao.setFinalidade(rs.getString("finalidade"));
                locacao.setQtdMaquinas(rs.getInt("qtd_maquina"));
                locacao.setTempoDeUso(rs.getString("tempo_locacao"));
                
                arrayObj.add(locacao);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBd.desconectar();
        }
      
        return arrayObj;
    }
    
}
