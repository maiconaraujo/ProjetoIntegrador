/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.es.model;

import util.Utilidades;

/**
 *
 * @author sala308b
 */
public class ResidenciaFamiliaExtensa {

    private int codigo;
    private String nome;
    private int idade;
    private String parentesco;
    private String ocupacao;
    private double renda;
    private InformacoesFamiliaExtensa informacoesFamiliaExtensa;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public InformacoesFamiliaExtensa getInformacoesFamiliaExtensa() {
        return informacoesFamiliaExtensa;
    }

    public void setInformacoesFamiliaExtensa(InformacoesFamiliaExtensa informacoesFamiliaExtensa) {
        this.informacoesFamiliaExtensa = informacoesFamiliaExtensa;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | Idade: " + idade
                + " | Parentesco: " + parentesco + " | Ocupação: " + ocupacao
                + " | Renda: " + Utilidades.converteDoubleParaCampoMoeda(renda);
    }

}
