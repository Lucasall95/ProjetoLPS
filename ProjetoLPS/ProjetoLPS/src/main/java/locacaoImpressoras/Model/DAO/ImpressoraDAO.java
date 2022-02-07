/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locacaoImpressoras.Model.DAO;

import model.Impressora;
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
public class ImpressoraDAO implements InterfaceDAO {
    private Impressora impressora;
    private String SQL;
    private PreparedStatement ps;
    private ResultSet rs;
    private int resultado;
    
    @Override
    public int inserir(Object obj) {
        resultado = -1;
        impressora = (Impressora) obj;
        SQL = "Insert into impressora (nome, tipo_impressora, marca_impressora, modelo_impressora, colorida) values (?,?,?,?,?)";
        try {
            
            ps = ConexaoBd.conectar().prepareStatement(SQL);
            ps.setString(1, impressora.getNome());
            ps.setString(2, impressora.getTipo());
            ps.setString(3,impressora.getMarca());
            ps.setString(4, impressora.getModelo());
            ps.setBoolean(5,(impressora.isColorida()));
            resultado = ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ImpressoraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public int alterar(Object obj) {
        resultado = -1;
        impressora = (Impressora) obj;
        SQL = "Update impressora set nome =?, tipo_impressora =?, marca_impressora =?, modelo_impressora =?, colorida =? where id =?";
        try {
            
            ps = ConexaoBd.conectar().prepareStatement(SQL);
            ps.setString(1, impressora.getNome());
            ps.setString(2, impressora.getTipo());
            ps.setString(3,impressora.getMarca());
            ps.setString(4, impressora.getModelo());
            ps.setBoolean(5,(impressora.isColorida()));
            ps.setInt(6, impressora.getId());
            
            resultado = ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ImpressoraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public int excluir(Object obj) {
        resultado = -1;
        SQL = "Delete from impressora where id = " + obj;
        try {
            ps = ConexaoBd.conectar().prepareStatement(SQL);
            resultado = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ImpressoraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public ArrayList<Object> consultar(Object obj) {
        ArrayList<Object> arrayObj = new ArrayList();
       
        if(obj == null)
            SQL = "Select * from impressora";
        else
            SQL = "Select * from impressora where upper(nome) like upper ('%" + (Impressora)obj + "%')";
        
        try {
            ps = ConexaoBd.conectar().prepareStatement(SQL);
            rs = ps.executeQuery();
            
            while(rs.next()){
                impressora = new Impressora();
                
                impressora.setId(rs.getInt("id"));
                impressora.setNome(rs.getString("nome"));
                impressora.setTipo(rs.getString("tipo_impressora"));
                impressora.setMarca(rs.getString("marca_impressora"));
                impressora.setModelo(rs.getString("modelo_impressora"));
                impressora.setColorida(rs.getBoolean("colorida"));
                
                arrayObj.add(impressora);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ImpressoraDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBd.desconectar();
        }
      
        return arrayObj;
    }
    
}
