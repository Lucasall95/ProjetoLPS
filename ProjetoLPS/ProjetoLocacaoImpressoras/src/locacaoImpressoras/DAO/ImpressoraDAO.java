/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locacaoImpressoras.DAO;

import classes.Impressora;
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
    Impressora impressora;
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
