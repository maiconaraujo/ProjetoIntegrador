/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.es.model;

/**
 *
 * @author sala308b
 */
public class Parecer {

    private int codigo;
    private String atendimento;
    private String opiniaoCrianca;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(String atendimento) {
        this.atendimento = atendimento;
    }

    public String getOpiniaoCrianca() {
        return opiniaoCrianca;
    }

    public void setOpiniaoCrianca(String opiniaoCrianca) {
        this.opiniaoCrianca = opiniaoCrianca;
    }

}
