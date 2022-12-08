/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.es.model;

import java.util.Calendar;

/**
 *
 * @author sala308b
 */
public class Crianca {

    private int codigo;
    private String nome;
    private String sexo;
    private Calendar dataNascimento;
    private String cpf;
    private byte[] fotoCrianca;
    private String responsavel;
    private String genitor;
    private String genitora;
    private String numProcesso;
    private Calendar dataAcolhimento;
    private String orgaoEncaminhador;
    private String status;
    private String naturalidade;
    private String primeiroAcolhimento;
    private String irmaosSobAcolhimento;
    private String irmaosSobAcolhimentoInfo;
    private String guiaAcolhimento;
    private String problemaSaude;
    private String problemaSaudeInfo;
    private String tipoDeficiencia;
    private String tipoDeficienciaInfo;
    private String usoMedicamento;
    private String usoMedicamentoInfo;
    private String filiacaoGenitor;
    private String filiacaoGenitora;
    private String enderecoGenitor;
    private String enderecoGenitora;
    private String enderecoResponsavel;
    private Calendar dataNascimentoGenitor;
    private Calendar dataNascimentoGenitora;
    private Calendar dataNascimentoResponsavel;
    private String outroResponsavelQual;
    private String tipoDocumentoGenitor;
    private String tipoDocumentoGenitora;
    private String tipoDocumentoResponsavel;
    private String documentoGenitor;
    private String documentoGenitora;
    private String documentoResponsavel;
    private String telefoneGenitor;
    private String telefoneGenitora;
    private String telefoneResponsavel;

    private UnidadeAcolhimento un;
    private JustificativaAcolhimento ja;
    private Parecer pa;
    private InformacoesFamiliaOrigem ifo;
    private InformacoesFamiliaExtensa ife;
    private InformacoesTerceiros it;
    private ProcedimentosUnidadeCrianca puc;
    private ProcedimentosUnidadeComFamilia pucf;
    private AvaliacaoInterdisciplinarDoCaso aidc;

    public JustificativaAcolhimento getJa() {
        return ja;
    }

    public void setJa(JustificativaAcolhimento ja) {
        this.ja = ja;
    }

    public Parecer getPa() {
        return pa;
    }

    public void setPa(Parecer pa) {
        this.pa = pa;
    }

    public InformacoesFamiliaOrigem getIfo() {
        return ifo;
    }

    public void setIfo(InformacoesFamiliaOrigem ifo) {
        this.ifo = ifo;
    }

    public InformacoesFamiliaExtensa getIfe() {
        return ife;
    }

    public void setIfe(InformacoesFamiliaExtensa ife) {
        this.ife = ife;
    }

    public InformacoesTerceiros getIt() {
        return it;
    }

    public void setIt(InformacoesTerceiros it) {
        this.it = it;
    }

    public ProcedimentosUnidadeCrianca getPuc() {
        return puc;
    }

    public void setPuc(ProcedimentosUnidadeCrianca puc) {
        this.puc = puc;
    }

    public ProcedimentosUnidadeComFamilia getPucf() {
        return pucf;
    }

    public void setPucf(ProcedimentosUnidadeComFamilia pucf) {
        this.pucf = pucf;
    }

    public AvaliacaoInterdisciplinarDoCaso getAidc() {
        return aidc;
    }

    public void setAidc(AvaliacaoInterdisciplinarDoCaso aidc) {
        this.aidc = aidc;
    }

    public UnidadeAcolhimento getUn() {
        return un;
    }

    public void setUn(UnidadeAcolhimento un) {
        this.un = un;
    }

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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public byte[] getFotoCrianca() {
        return fotoCrianca;
    }

    public void setFotoCrianca(byte[] fotoCrianca) {
        this.fotoCrianca = fotoCrianca;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getOutroResponsavelQual() {
        return outroResponsavelQual;
    }

    public void setOutroResponsavelQual(String outroResponsavelQual) {
        this.outroResponsavelQual = outroResponsavelQual;
    }

    public String getGenitor() {
        return genitor;
    }

    public void setGenitor(String genitor) {
        this.genitor = genitor;
    }

    public String getGenitora() {
        return genitora;
    }

    public void setGenitora(String genitora) {
        this.genitora = genitora;
    }

    public String getNumProcesso() {
        return numProcesso;
    }

    public void setNumProcesso(String numProcesso) {
        this.numProcesso = numProcesso;
    }

    public Calendar getDataAcolhimento() {
        return dataAcolhimento;
    }

    public void setDataAcolhimento(Calendar dataAcolhimento) {
        this.dataAcolhimento = dataAcolhimento;
    }

    public String getOrgaoEncaminhador() {
        return orgaoEncaminhador;
    }

    public void setOrgaoEncaminhador(String orgaoEncaminhador) {
        this.orgaoEncaminhador = orgaoEncaminhador;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getPrimeiroAcolhimento() {
        return primeiroAcolhimento;
    }

    public void setPrimeiroAcolhimento(String primeiroAcolhimento) {
        this.primeiroAcolhimento = primeiroAcolhimento;
    }

    public String getIrmaosSobAcolhimento() {
        return irmaosSobAcolhimento;
    }

    public void setIrmaosSobAcolhimento(String irmaosSobAcolhimento) {
        this.irmaosSobAcolhimento = irmaosSobAcolhimento;
    }

    public String getIrmaosSobAcolhimentoInfo() {
        return irmaosSobAcolhimentoInfo;
    }

    public void setIrmaosSobAcolhimentoInfo(String irmaosSobAcolhimentoInfo) {
        this.irmaosSobAcolhimentoInfo = irmaosSobAcolhimentoInfo;
    }

    public String getGuiaAcolhimento() {
        return guiaAcolhimento;
    }

    public void setGuiaAcolhimento(String guiaAcolhimento) {
        this.guiaAcolhimento = guiaAcolhimento;
    }

    public String getProblemaSaude() {
        return problemaSaude;
    }

    public void setProblemaSaude(String problemaSaude) {
        this.problemaSaude = problemaSaude;
    }

    public String getProblemaSaudeInfo() {
        return problemaSaudeInfo;
    }

    public void setProblemaSaudeInfo(String problemaSaudeInfo) {
        this.problemaSaudeInfo = problemaSaudeInfo;
    }

    public String getTipoDeficiencia() {
        return tipoDeficiencia;
    }

    public void setTipoDeficiencia(String tipoDeficiencia) {
        this.tipoDeficiencia = tipoDeficiencia;
    }

    public String getTipoDeficienciaInfo() {
        return tipoDeficienciaInfo;
    }

    public void setTipoDeficienciaInfo(String tipoDeficienciaInfo) {
        this.tipoDeficienciaInfo = tipoDeficienciaInfo;
    }

    public String getUsoMedicamento() {
        return usoMedicamento;
    }

    public void setUsoMedicamento(String usoMedicamento) {
        this.usoMedicamento = usoMedicamento;
    }

    public String getUsoMedicamentoInfo() {
        return usoMedicamentoInfo;
    }

    public void setUsoMedicamentoInfo(String usoMedicamentoInfo) {
        this.usoMedicamentoInfo = usoMedicamentoInfo;
    }

    public String getFiliacaoGenitor() {
        return filiacaoGenitor;
    }

    public void setFiliacaoGenitor(String filiacaoGenitor) {
        this.filiacaoGenitor = filiacaoGenitor;
    }

    public String getFiliacaoGenitora() {
        return filiacaoGenitora;
    }

    public void setFiliacaoGenitora(String filiacaoGenitora) {
        this.filiacaoGenitora = filiacaoGenitora;
    }

    public String getEnderecoGenitor() {
        return enderecoGenitor;
    }

    public void setEnderecoGenitor(String enderecoGenitor) {
        this.enderecoGenitor = enderecoGenitor;
    }

    public String getEnderecoGenitora() {
        return enderecoGenitora;
    }

    public void setEnderecoGenitora(String enderecoGenitora) {
        this.enderecoGenitora = enderecoGenitora;
    }

    public String getEnderecoResponsavel() {
        return enderecoResponsavel;
    }

    public void setEnderecoResponsavel(String enderecoResponsavel) {
        this.enderecoResponsavel = enderecoResponsavel;
    }

    public Calendar getDataNascimentoGenitor() {
        return dataNascimentoGenitor;
    }

    public void setDataNascimentoGenitor(Calendar dataNascimentoGenitor) {
        this.dataNascimentoGenitor = dataNascimentoGenitor;
    }

    public Calendar getDataNascimentoGenitora() {
        return dataNascimentoGenitora;
    }

    public void setDataNascimentoGenitora(Calendar dataNascimentoGenitora) {
        this.dataNascimentoGenitora = dataNascimentoGenitora;
    }

    public Calendar getDataNascimentoResponsavel() {
        return dataNascimentoResponsavel;
    }

    public void setDataNascimentoResponsavel(Calendar dataNascimentoResponsavel) {
        this.dataNascimentoResponsavel = dataNascimentoResponsavel;
    }

    public String getTipoDocumentoGenitor() {
        return tipoDocumentoGenitor;
    }

    public void setTipoDocumentoGenitor(String tipoDocumentoGenitor) {
        this.tipoDocumentoGenitor = tipoDocumentoGenitor;
    }

    public String getTipoDocumentoGenitora() {
        return tipoDocumentoGenitora;
    }

    public void setTipoDocumentoGenitora(String tipoDocumentoGenitora) {
        this.tipoDocumentoGenitora = tipoDocumentoGenitora;
    }

    public String getTipoDocumentoResponsavel() {
        return tipoDocumentoResponsavel;
    }

    public void setTipoDocumentoResponsavel(String tipoDocumentoResponsavel) {
        this.tipoDocumentoResponsavel = tipoDocumentoResponsavel;
    }

    public String getDocumentoGenitor() {
        return documentoGenitor;
    }

    public void setDocumentoGenitor(String documentoGenitor) {
        this.documentoGenitor = documentoGenitor;
    }

    public String getDocumentoGenitora() {
        return documentoGenitora;
    }

    public void setDocumentoGenitora(String documentoGenitora) {
        this.documentoGenitora = documentoGenitora;
    }

    public String getDocumentoResponsavel() {
        return documentoResponsavel;
    }

    public void setDocumentoResponsavel(String documentoResponsavel) {
        this.documentoResponsavel = documentoResponsavel;
    }

    public String getTelefoneGenitor() {
        return telefoneGenitor;
    }

    public void setTelefoneGenitor(String telefoneGenitor) {
        this.telefoneGenitor = telefoneGenitor;
    }

    public String getTelefoneGenitora() {
        return telefoneGenitora;
    }

    public void setTelefoneGenitora(String telefoneGenitora) {
        this.telefoneGenitora = telefoneGenitora;
    }

    public String getTelefoneResponsavel() {
        return telefoneResponsavel;
    }

    public void setTelefoneResponsavel(String telefoneResponsavel) {
        this.telefoneResponsavel = telefoneResponsavel;
    }

}
