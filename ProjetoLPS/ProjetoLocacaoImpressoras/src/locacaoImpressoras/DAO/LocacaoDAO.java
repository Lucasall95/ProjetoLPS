/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locacaoImpressoras.DAO;

import classes.Locacao;
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
    Locacao locacao;
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
            SQL = "Select * from locacao";
        else
            SQL = "Select * from locacao where upper(id) like upper ('%" + (Locacao)obj + "%')";
        
        try {
            ps = ConexaoBd.conectar().prepareStatement(SQL);
            rs = ps.executeQuery();
            
            while(rs.next()){
                locacao = new Locacao();
                
                locacao.setId(rs.getInt("id"));
                locacao.setTamanho(rs.getString("tamanho"));
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
