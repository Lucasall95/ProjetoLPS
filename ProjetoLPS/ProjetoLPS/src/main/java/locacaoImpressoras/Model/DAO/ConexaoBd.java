/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locacaoImpressoras.Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author corns
 */
public class ConexaoBd {
    private static Connection conexao;
    
    private ConexaoBd(){
        try {
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_sistemaimpressoras", "postgres", "98668115");
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static Connection conectar(){
        if(conexao == null)
            new ConexaoBd();
        return conexao;
    }
    
    public static void desconectar(){
        try {
            conexao.close();
            conexao = null;
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
