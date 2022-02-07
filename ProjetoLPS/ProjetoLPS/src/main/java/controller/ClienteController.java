/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import locacaoImpressoras.Model.DAO.ClienteDAO;
import model.Cliente;
import view.ClienteView;

/**
 *
 * @author corns
 */
public class ClienteController {
    private Cliente cliente;
    private ClienteDAO clienteDAO;
    
    public ClienteController(){
        clienteDAO = new ClienteDAO();
    }
    
    public void abrirCadCliente(){
        ClienteView telaCliente = new ClienteView(this);
        telaCliente.setVisible(true);
    }
    
    public ArrayList<Object []> buscarCliente(){
       
       ArrayList<Object []> arrayObjCliente = new ArrayList<>();
       ArrayList<Object> arrayObj = clienteDAO.consultar(null);
       
       for(int i=0; i<arrayObj.size(); i++){
           Object[] arrayObjAl = new Object [7];
           arrayObjAl[0] = ((Cliente)arrayObj.get(i)).getId();
           arrayObjAl[1] = ((Cliente)arrayObj.get(i)).getNome();
           arrayObjAl[2] = ((Cliente)arrayObj.get(i)).getSexo();
           arrayObjAl[3] = ((Cliente)arrayObj.get(i)).getIdade();
           arrayObjAl[4] = ((Cliente)arrayObj.get(i)).getEmail();
           arrayObjAl[5] = ((Cliente)arrayObj.get(i)).getCPF();
           arrayObjAl[6] = ((Cliente)arrayObj.get(i)).getSenha();
           
           arrayObjCliente.add(arrayObjAl);
       }
       return arrayObjCliente;
    }
    
    public int removerCliente(Object [] arrayCliente){
        return clienteDAO.excluir(arrayCliente[0]);
    }
    
    public int incluirCliente(Object [] arrayCliente){
        cliente = new Cliente();
        
        cliente.setNome(arrayCliente[1].toString());
        cliente.setIdade(Integer.parseInt(arrayCliente[2].toString()));
        cliente.setSexo(arrayCliente[3].toString().toCharArray()[0]);
        cliente.setCPF(arrayCliente[4].toString());
        cliente.setSenha(arrayCliente[5].toString());
        cliente.setEmail(arrayCliente[6].toString());
       
        return clienteDAO.inserir(cliente);
    }
    
    public int modificarCliente(Object [] arrayCliente){
        cliente = new Cliente();
        
        cliente.setId(Integer.parseInt(arrayCliente[0].toString()));
        cliente.setNome(arrayCliente[1].toString());
        cliente.setIdade(Integer.parseInt(arrayCliente[2].toString()));
        cliente.setSexo(arrayCliente[3].toString().toCharArray()[0]);
        cliente.setCPF(arrayCliente[4].toString());
        cliente.setSenha(arrayCliente[5].toString());
        cliente.setEmail(arrayCliente[6].toString());
        
        return clienteDAO.alterar(cliente);
    }
}
