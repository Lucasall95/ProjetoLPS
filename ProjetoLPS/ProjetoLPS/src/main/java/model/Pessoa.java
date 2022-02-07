/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Scanner;

/**
 *
 * @author corns
 */
public class Pessoa {
    protected String nome;
    protected int idade;
    protected char sexo;
    protected String CPF;
    
    
    public Pessoa(){
        this.nome = "";
        this.idade = 0;
        this.sexo = ' ';
        this.CPF = "000-000-000-00";
    }

    public void preencher(){
        Scanner leitor = new Scanner(System.in);
       
        System.out.print("Nome: ");
        this.nome = leitor.next();
        System.out.print("Idade: ");
        this.idade = leitor.nextInt();
        System.out.print("Sexo: ");
        this.sexo = leitor.next().charAt(0);
        System.out.print("CPF: ");
        this.CPF = leitor.next();
        
    }
    
    public void imprimir(){
 
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("Sexo: " + this.sexo);
        System.out.println("CPF: " + this.CPF); 
       
        
    }
    
    public void copiar (Pessoa outro){
        this.nome = outro.getNome();
        this.idade = outro.getIdade();
        this.sexo = outro.getSexo();
        this.CPF = outro.getCPF();
       
    }
    
    
    
    
    
    
    
    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
