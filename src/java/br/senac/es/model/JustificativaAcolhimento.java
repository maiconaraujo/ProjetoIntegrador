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
public class JustificativaAcolhimento {

    private int codigo;
    private String violacaoDireitos;
    private String ocorrenciaViolacaoDireitos;
    private String ocorrenciaPolicial;
    private String familiarAutorizado;
    private String familiarAutorizadoInfo;
    private String restricaoFamiliar;
    private String restricaoFamiliarInfo;
    private boolean guiaAcolhimento;
    private boolean oficioJuizado;
    private boolean oficioConselho;
    private boolean relatorioServicoSocial;
    private boolean relatorioConselhoTutelar;
    private boolean certidaoNascimento;
    private boolean cartaoVacina;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getViolacaoDireitos() {
        return violacaoDireitos;
    }

    public void setViolacaoDireitos(String violacaoDireitos) {
        this.violacaoDireitos = violacaoDireitos;
    }

    public String getOcorrenciaViolacaoDireitos() {
        return ocorrenciaViolacaoDireitos;
    }

    public void setOcorrenciaViolacaoDireitos(String ocorrenciaViolacaoDireitos) {
        this.ocorrenciaViolacaoDireitos = ocorrenciaViolacaoDireitos;
    }

    public String getOcorrenciaPolicial() {
        return ocorrenciaPolicial;
    }

    public void setOcorrenciaPolicial(String ocorrenciaPolicial) {
        this.ocorrenciaPolicial = ocorrenciaPolicial;
    }

    public String getFamiliarAutorizado() {
        return familiarAutorizado;
    }

    public void setFamiliarAutorizado(String familiarAutorizado) {
        this.familiarAutorizado = familiarAutorizado;
    }

    public String getFamiliarAutorizadoInfo() {
        return familiarAutorizadoInfo;
    }

    public void setFamiliarAutorizadoInfo(String familiarAutorizadoInfo) {
        this.familiarAutorizadoInfo = familiarAutorizadoInfo;
    }

    public String getRestricaoFamiliar() {
        return restricaoFamiliar;
    }

    public void setRestricaoFamiliar(String restricaoFamiliar) {
        this.restricaoFamiliar = restricaoFamiliar;
    }

    public String getRestricaoFamiliarInfo() {
        return restricaoFamiliarInfo;
    }

    public void setRestricaoFamiliarInfo(String restricaoFamiliarInfo) {
        this.restricaoFamiliarInfo = restricaoFamiliarInfo;
    }

    public boolean isGuiaAcolhimento() {
        return guiaAcolhimento;
    }

    public void setGuiaAcolhimento(boolean guiaAcolhimento) {
        this.guiaAcolhimento = guiaAcolhimento;
    }

    public boolean isOficioJuizado() {
        return oficioJuizado;
    }

    public void setOficioJuizado(boolean oficioJuizado) {
        this.oficioJuizado = oficioJuizado;
    }

    public boolean isOficioConselho() {
        return oficioConselho;
    }

    public void setOficioConselho(boolean oficioConselho) {
        this.oficioConselho = oficioConselho;
    }

    public boolean isRelatorioServicoSocial() {
        return relatorioServicoSocial;
    }

    public void setRelatorioServicoSocial(boolean relatorioServicoSocial) {
        this.relatorioServicoSocial = relatorioServicoSocial;
    }

    public boolean isRelatorioConselhoTutelar() {
        return relatorioConselhoTutelar;
    }

    public void setRelatorioConselhoTutelar(boolean relatorioConselhoTutelar) {
        this.relatorioConselhoTutelar = relatorioConselhoTutelar;
    }

    public boolean isCertidaoNascimento() {
        return certidaoNascimento;
    }

    public void setCertidaoNascimento(boolean certidaoNascimento) {
        this.certidaoNascimento = certidaoNascimento;
    }

    public boolean isCartaoVacina() {
        return cartaoVacina;
    }

    public void setCartaoVacina(boolean cartaoVacina) {
        this.cartaoVacina = cartaoVacina;
    }

}
