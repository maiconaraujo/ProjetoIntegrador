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
public class ProcedimentosUnidadeComFamilia {

    private int codigo;
    private String visitaDomiciliar;
    private String insercaoSocioassistencialMunicipio;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getVisitaDomiciliar() {
        return visitaDomiciliar;
    }

    public void setVisitaDomiciliar(String visitaDomiciliar) {
        this.visitaDomiciliar = visitaDomiciliar;
    }

    public String getInsercaoSocioassistencialMunicipio() {
        return insercaoSocioassistencialMunicipio;
    }

    public void setInsercaoSocioassistencialMunicipio(String insercaoSocioassistencialMunicipio) {
        this.insercaoSocioassistencialMunicipio = insercaoSocioassistencialMunicipio;
    }

}
