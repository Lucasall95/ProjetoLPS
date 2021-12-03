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
public class Funcionario extends Pessoa {
    private String cargo;
    private double salario;
    private int id;

    public Funcionario() {
        super();
        this.id = 0;
        this.cargo = "";
        this.salario = 0000.00;
    }

    public void preencher(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("***********Preencher Funcionario ***********");
        super.preencher();
        System.out.print("Identicacao: ");
        this.id = Integer.parseInt(leitor.next());
        System.out.print("Cargo: ");
        this.cargo = leitor.next();
        System.out.print("Salario: ");
        this.salario = Double.parseDouble(leitor.next());
           
    }
    public void imprimir(){
        System.out.println("********Dados Funcionario ***********");
        super.imprimir();
        System.out.println("Idenficacao: " + this.id);
        System.out.println("Cargo: " + this.cargo);
        System.out.println("Salario: " + this.salario);
        System.out.println("***********************************");
        
    }
    
    
    public void copiar (Funcionario outro){
        super.copiar(outro);
        this.id = outro.getId();
        this.cargo = outro.getCargo();
        this.salario = outro.getSalario();
       
    }
    
    
    
    
    
    
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



  
    
    
    
    
}
