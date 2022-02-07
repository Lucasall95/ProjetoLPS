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
public class Impressora {
    private int id;
    private String nome;
    private String modelo;
    private String marca;
    private String tipo;
    private boolean colorida;

    public Impressora(){
        this.id = 0;
        this.nome = "";
        this.modelo = "simples";
        this.marca = "hp";
        this.tipo = "impressao-dupla";
        this.colorida = false;
    }
    public void preencher(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("***********Preencher Impressora***********");
        System.out.print("ID: ");
        this.id = Integer.parseInt(leitor.next());
        System.out.print("Nome: ");
        this.nome = leitor.next();
        System.out.print("Modelo: ");
        this.modelo = leitor.next();
        System.out.print("Marca: ");
        this.marca = leitor.next();
        System.out.print("Tipo: ");
        this.tipo = leitor.next();
        System.out.print("Colorida: ");
        this.colorida = leitor.hasNext();
           
    }
    public void imprimir(){
        System.out.println("********Dados Impressora ***********");
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Marca: " + this.marca);
        System.out.println("Tipo: " + this.tipo);
        if(this.colorida == true)
            System.out.println("Colorida");
        else
            System.out.println("Não é Colorida");
        System.out.println("***********************************");
        
    }
    public void copiar (Impressora outro){
        this.id = outro.getId();
        this.nome = outro.getNome();
        this.modelo = outro.getModelo();
        this.marca= outro.getMarca();
        this.tipo = outro.getTipo();
        this.colorida = outro.isColorida();
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isColorida() {
        return colorida;
    }

    public void setColorida(boolean colorida) {
        this.colorida = colorida;
    }
    
    
    
    
}
