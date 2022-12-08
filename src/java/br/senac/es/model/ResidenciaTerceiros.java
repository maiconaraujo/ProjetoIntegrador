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
public class ResidenciaTerceiros {

    private int codigo;
    private String nome;
    private int idade;
    private String ocupacao;
    private double renda;
    private InformacoesTerceiros informacoesTerceiros;

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

    public InformacoesTerceiros getInformacoesTerceiros() {
        return informacoesTerceiros;
    }

    public void setInformacoesTerceiros(InformacoesTerceiros informacoesTerceiros) {
        this.informacoesTerceiros = informacoesTerceiros;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | Idade: " + idade
                + " | Ocupação: " + ocupacao
                + " | Renda: " + Utilidades.converteDoubleParaCampoMoeda(renda);
    }

}
