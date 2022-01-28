/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locacaoImpressoras.DAO;

import classes.Funcionario;
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
    Funcionario funcionario;
    String SQL;
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public void inserir(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
