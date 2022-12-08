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
public class InformacoesFamiliaOrigem {

    private int codigo;
    private String situacaoSociofamiliar;
    private String opiniaoFamilia;
    
    private ArrayList<ResidenciaFamiliaOrigem> ListaresidenciaFamiliaOrigem;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getSituacaoSociofamiliar() {
        return situacaoSociofamiliar;
    }

    public void setSituacaoSociofamiliar(String situacaoSociofamiliar) {
        this.situacaoSociofamiliar = situacaoSociofamiliar;
    }

    public String getOpiniaoFamilia() {
        return opiniaoFamilia;
    }

    public void setOpiniaoFamilia(String opiniaoFamilia) {
        this.opiniaoFamilia = opiniaoFamilia;
    }

    public ArrayList<ResidenciaFamiliaOrigem> getListaresidenciaFamiliaOrigem() {
        return ListaresidenciaFamiliaOrigem;
    }

    public void setListaresidenciaFamiliaOrigem(ArrayList<ResidenciaFamiliaOrigem> ListaresidenciaFamiliaOrigem) {
        this.ListaresidenciaFamiliaOrigem = ListaresidenciaFamiliaOrigem;
    }

    
}
