/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.es.model;

import java.util.ArrayList;

/**
 *
 * @author sala308b
 */
public class InformacoesTerceiros {

    private int codigo;
    private String vinculoTerceiros;
    private String vinculoTerceirosInfo;
    private String contatoTerceiros;
    private String terceirosInteressadosNaGuarda;
    private String terceirosInteressadosNaGuardaInfo;
    private String situacaoSociofamiliar;
    private String opiniaoTerceiros;
    
    private ArrayList<ResidenciaTerceiros> ListaresidenciaTerceiros;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getVinculoTerceiros() {
        return vinculoTerceiros;
    }

    public void setVinculoTerceiros(String vinculoTerceiros) {
        this.vinculoTerceiros = vinculoTerceiros;
    }

    public String getVinculoTerceirosInfo() {
        return vinculoTerceirosInfo;
    }

    public void setVinculoTerceirosInfo(String vinculoTerceirosInfo) {
        this.vinculoTerceirosInfo = vinculoTerceirosInfo;
    }

    public String getContatoTerceiros() {
        return contatoTerceiros;
    }

    public void setContatoTerceiros(String contatoTerceiros) {
        this.contatoTerceiros = contatoTerceiros;
    }

    public String getTerceirosInteressadosNaGuarda() {
        return terceirosInteressadosNaGuarda;
    }

    public void setTerceirosInteressadosNaGuarda(String terceirosInteressadosNaGuarda) {
        this.terceirosInteressadosNaGuarda = terceirosInteressadosNaGuarda;
    }

    public String getTerceirosInteressadosNaGuardaInfo() {
        return terceirosInteressadosNaGuardaInfo;
    }

    public void setTerceirosInteressadosNaGuardaInfo(String terceirosInteressadosNaGuardaInfo) {
        this.terceirosInteressadosNaGuardaInfo = terceirosInteressadosNaGuardaInfo;
    }

    public String getSituacaoSociofamiliar() {
        return situacaoSociofamiliar;
    }

    public void setSituacaoSociofamiliar(String situacaoSociofamiliar) {
        this.situacaoSociofamiliar = situacaoSociofamiliar;
    }

    public String getOpiniaoTerceiros() {
        return opiniaoTerceiros;
    }

    public void setOpiniaoTerceiros(String opiniaoTerceiros) {
        this.opiniaoTerceiros = opiniaoTerceiros;
    }

    public ArrayList<ResidenciaTerceiros> getListaresidenciaTerceiros() {
        return ListaresidenciaTerceiros;
    }

    public void setListaresidenciaTerceiros(ArrayList<ResidenciaTerceiros> ListaresidenciaTerceiros) {
        this.ListaresidenciaTerceiros = ListaresidenciaTerceiros;
    }

}
