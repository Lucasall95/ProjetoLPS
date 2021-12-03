/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Scanner;

/**
 *
 * @author corns
 */
public class Cliente extends Pessoa{
    private String senha;
    private String email;
    
    public Cliente(){
        super();
        this.senha = "*******";
        this.email = "ninguem@ninguem.com";
    }

    
    public void preencher(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("***********Preencher Cliente ***********");
        super.preencher();
        System.out.print("Senha: ");
        this.senha = leitor.next();
        System.out.print("Digite o seu e-mail: ");
        this.email = leitor.next();
           
    }
    
    public void imprimir(){
        System.out.println("********Dados Cliente ***********");
        super.imprimir();
        System.out.println("Senha: " + this.senha);
        System.out.println("Email: " + this.email);
        System.out.println("***********************************");
        
    }
    
    public void copiar (Cliente outro){
        super.copiar(outro);
        this.senha = outro.getSenha();
        this.email = outro.getEmail();
       
    }
    
    
    
    
    
    
    
    
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
    
   
    
}
