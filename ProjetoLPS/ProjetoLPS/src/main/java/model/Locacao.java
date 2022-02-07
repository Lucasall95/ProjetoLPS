/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author corns
 */
public class Locacao {
    private int id;
    private String tamanho;
    private String tipoMaquina;
    private String finalidade;
    private String tempoDeUso;
    private int qtdMaquinas;
    
    public void Locacao(){
        this.id = 0;
        this.tamanho = " ";
        this.tipoMaquina = " ";
        this.finalidade = " ";
        this.tempoDeUso = " ";
        this.qtdMaquinas = 0;
    }

    
 
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getTipoMaquina() {
        return tipoMaquina;
    }

    public void setTipoMaquina(String tipoMaquina) {
        this.tipoMaquina = tipoMaquina;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public String getTempoDeUso() {
        return tempoDeUso;
    }

    public void setTempoDeUso(String tempoDeUso) {
        this.tempoDeUso = tempoDeUso;
    }

    public int getQtdMaquinas() {
        return qtdMaquinas;
    }

    public void setQtdMaquinas(int qtdMaquinas) {
        this.qtdMaquinas = qtdMaquinas;
    }
    
    
    
    
    
}
