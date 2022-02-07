/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locacaoImpressoras.Model.DAO;

import model.Cliente;
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
public class ClienteDAO implements InterfaceDAO {
    private Cliente cliente;
    private String SQL;
    private PreparedStatement ps;
    private ResultSet rs;
    private int resultado;
    
    
    @Override
    public int inserir(Object obj) {
        resultado = -1;
        cliente = (Cliente) obj;
        SQL = "Insert into cliente (nome, idade, sexo, cpf, senha, email) values (?,?,?,?,?,?)";
        try {
            
            ps = ConexaoBd.conectar().prepareStatement(SQL);
            //ps.setInt(1, cliente.getId());
            ps.setString(1, cliente.getNome());
            ps.setInt(2,cliente.getIdade());
            ps.setString(3,String.valueOf(cliente.getSexo()));
            ps.setString(4, cliente.getCPF());
            ps.setString(5, cliente.getSenha());
            ps.setString(6, cliente.getEmail());
            
            resultado = ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public int alterar(Object obj) {
        resultado = -1;
        cliente = (Cliente) obj;
        SQL = "Update cliente set nome =?, idade =?, sexo =?, cpf =?, senha =?, email =? where id =?";
        try {
            
            ps = ConexaoBd.conectar().prepareStatement(SQL);
            ps.setString(1, cliente.getNome());
            ps.setInt(2, cliente.getIdade());
            ps.setString(3, String.valueOf(cliente.getSexo()));
            ps.setString(4, cliente.getCPF());
            ps.setString(5, cliente.getSenha());
            ps.setString(6, cliente.getEmail());
            ps.setInt(7, cliente.getId());
            resultado = ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public int excluir(Object obj) {
        resultado = -1;
        SQL = "Delete from cliente where id = " + obj;
        try {
            ps = ConexaoBd.conectar().prepareStatement(SQL);
            resultado = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public ArrayList<Object> consultar(Object obj) {
        ArrayList<Object> arrayObj = new ArrayList();
       
        if(obj == null)
            SQL = "Select * from cliente";
        else
            SQL = "Select * from cliente where upper(nome) like upper ('%" + (Cliente)obj + "%')";
        
        try {
            ps = ConexaoBd.conectar().prepareStatement(SQL);
            rs = ps.executeQuery();
            
            while(rs.next()){
                cliente = new Cliente();
                
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setSexo(rs.getString("sexo").charAt(0));
                cliente.setIdade(rs.getInt("idade"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCPF(rs.getString("cpf"));
                cliente.setSenha(rs.getString("senha"));
                
                arrayObj.add(cliente);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBd.desconectar();
        }
      
        return arrayObj;
        
    }
    
     
}
