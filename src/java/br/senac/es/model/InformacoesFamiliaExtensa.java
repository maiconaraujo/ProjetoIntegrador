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
public class InformacoesFamiliaExtensa {

    private int codigo;
    private String parentesProximos;
    private String parentesProximosInfo;
    private String contatoParentes;
    private String parentesInteressadosNaGuarda;
    private String parentesInteressadosNaGuardaInfo;
    private String situacaoSociofamiliar;
    private String opiniaoFamiliaExtensa;
    
    private ArrayList<ResidenciaFamiliaExtensa> ListaresidenciaFamiliaExtensa;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getParentesProximos() {
        return parentesProximos;
    }

    public void setParentesProximos(String parentesProximos) {
        this.parentesProximos = parentesProximos;
    }

    public String getParentesProximosInfo() {
        return parentesProximosInfo;
    }

    public void setParentesProximosInfo(String parentesProximosInfo) {
        this.parentesProximosInfo = parentesProximosInfo;
    }

    public String getContatoParentes() {
        return contatoParentes;
    }

    public void setContatoParentes(String contatoParentes) {
        this.contatoParentes = contatoParentes;
    }

    public String getParentesInteressadosNaGuarda() {
        return parentesInteressadosNaGuarda;
    }

    public void setParentesInteressadosNaGuarda(String parentesInteressadosNaGuarda) {
        this.parentesInteressadosNaGuarda = parentesInteressadosNaGuarda;
    }

    public String getParentesInteressadosNaGuardaInfo() {
        return parentesInteressadosNaGuardaInfo;
    }

    public void setParentesInteressadosNaGuardaInfo(String parentesInteressadosNaGuardaInfo) {
        this.parentesInteressadosNaGuardaInfo = parentesInteressadosNaGuardaInfo;
    }

    public String getSituacaoSociofamiliar() {
        return situacaoSociofamiliar;
    }

    public void setSituacaoSociofamiliar(String situacaoSociofamiliar) {
        this.situacaoSociofamiliar = situacaoSociofamiliar;
    }

    public String getOpiniaoFamiliaExtensa() {
        return opiniaoFamiliaExtensa;
    }

    public void setOpiniaoFamiliaExtensa(String opiniaoFamiliaExtensa) {
        this.opiniaoFamiliaExtensa = opiniaoFamiliaExtensa;
    }

    public ArrayList<ResidenciaFamiliaExtensa> getListaresidenciaFamiliaExtensa() {
        return ListaresidenciaFamiliaExtensa;
    }

    public void setListaresidenciaFamiliaExtensa(ArrayList<ResidenciaFamiliaExtensa> ListaresidenciaFamiliaExtensa) {
        this.ListaresidenciaFamiliaExtensa = ListaresidenciaFamiliaExtensa;
    }


}
