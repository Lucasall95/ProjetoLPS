/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locacaoImpressoras.DAO;

import java.util.ArrayList;

/**
 *
 * @author corns
 */
public interface InterfaceDAO {
    
    public void inserir(Object obj);
    public void alterar(Object obj);
    public void excluir(Object obj);
    public ArrayList<Object> consultar(Object obj);
   
    
    
    
}
