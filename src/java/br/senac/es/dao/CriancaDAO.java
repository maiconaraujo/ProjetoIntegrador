package br.senac.es.dao;

import br.senac.es.dao.ConexaoFactory;
import br.senac.es.model.AvaliacaoInterdisciplinarDoCaso;
import br.senac.es.model.Crianca;
import br.senac.es.model.InformacoesFamiliaExtensa;
import br.senac.es.model.InformacoesFamiliaOrigem;
import br.senac.es.model.InformacoesTerceiros;
import br.senac.es.model.JustificativaAcolhimento;
import br.senac.es.model.Parecer;
import br.senac.es.model.ProcedimentosUnidadeComFamilia;
import br.senac.es.model.ProcedimentosUnidadeCrianca;
import br.senac.es.model.ResidenciaFamiliaExtensa;
import br.senac.es.model.ResidenciaFamiliaOrigem;
import br.senac.es.model.ResidenciaTerceiros;
import br.senac.es.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author joubert.santos
 */
public class CriancaDAO {

    Connection connection = ConexaoFactory.getConnection();

    public CriancaDAO() throws SQLException, ClassNotFoundException {
        connection = ConexaoFactory.getConnection();
    }

    public ArrayList<Crianca> getlist(int codUnidadeAcolhimento) throws ClassNotFoundException, SQLException {

        ArrayList<Crianca> listaCriancas = new ArrayList<>();
        String sql = "SELECT * FROM crianca WHERE unidade_acolhimento_codigo = ? order by nome ";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, codUnidadeAcolhimento);
            ResultSet rs = stmt.executeQuery();

            //quando abre o rs, ele não vai pro primeiro registro. é necessário usar o rs.next() para que ele vá para o primeiro e, depois, para os próximos
            while (rs.next()) {
                Crianca c = new Crianca();
                c.setNome(rs.getString("nome"));
                try {
                    Calendar Data = Calendar.getInstance();
                    Data.setTime(rs.getDate("data_nascimento"));
                    c.setDataNascimento(Data);
                } catch (Exception ex) {

                }
                c.setSexo(rs.getString("sexo"));
                c.setCodigo(rs.getInt("codigo"));
                c.setStatus(rs.getString("status"));
                c.setResponsavel(rs.getString("responsavel"));

                listaCriancas.add(c);
            }
            stmt.close();
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no acesso ao banco de dados - " + ex.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
        } finally {

            try {
                connection.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão - " + ex.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        }

        return listaCriancas;

    }

    public ArrayList<Crianca> getlistByNome(String nome, int codUnidadeAcolhimento) throws ClassNotFoundException, SQLException {

        nome = "%" + nome.trim() + "%";
        ArrayList<Crianca> listaCriancas = new ArrayList<>();
        String sql = "select * from crianca where nome ilike ? AND unidade_acolhimento_codigo = ? order by nome";
        Connection conn = ConexaoFactory.getConnection();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setInt(2, codUnidadeAcolhimento);
            ResultSet rs = stmt.executeQuery();

            //quando abre o rs, ele não vai pro primeiro registro. é necessário usar o rs.next() para que ele vá para o primeiro e, depois, para os próximos
            while (rs.next()) {

                Crianca c = new Crianca();
                c.setNome(rs.getString("nome"));

                try {
                    Calendar Data = Calendar.getInstance();
                    Data.setTime(rs.getDate("data_nascimento"));
                    c.setDataNascimento(Data);
                } catch (Exception ex) {

                }

                c.setSexo(rs.getString("sexo"));
                c.setCodigo(rs.getInt("codigo"));
                c.setStatus(rs.getString("status"));
                c.setResponsavel(rs.getString("responsavel"));

                listaCriancas.add(c);
            }
            stmt.close();
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no acesso ao banco de dados - " + ex.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
        } finally {

            try {
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão - " + ex.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        }

        return listaCriancas;

    }

    public Crianca buscar(int codigoCrianca) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        ResultSet rs = null;
        Crianca crianca = new Crianca();

        // Obtem conexao com BD
        conn = ConexaoFactory.getConnection();

        String sql = "SELECT c.codigo, c.nome, c.sexo, c.data_nascimento, c.responsavel, c.genitor, c.genitora, c.num_processo, c.data_acolhimento, c.orgao_encaminhador, c.naturalidade, c.status, c.primeiro_acolhimento, "
                + "c.irmaos_sobAcolhimento, c.irmaos_sobAcolhimento_info, c.guia_acolhimento, c.problema_saude, c.problema_saude_info, c.tipo_deficiencia, c.tipo_deficiencia_info, "
                + "c.uso_medicamento, c.uso_medicamento_info, c.filiacao_genitor, c.filiacao_genitora, c.endereco_genitor, c.endereco_genitora, c.endereco_responsavel, c.dataNasc_genitor, "
                + "c.dataNasc_genitora, c.dataNasc_responsavel, c.tipoDocumento_genitor, c.tipoDocumento_genitora, c.tipoDocumento_responsavel, c.documento_genitor, c.documento_genitora, c.documento_responsavel, "
                + "c.telefone_genitor, c.telefone_genitora, c.telefone_responsavel, c.justificativa_para_acolhimento_codigo, c.parecer_codigo, c.info_familia_origem_codigo, c.info_familia_extensa_codigo, "
                + "c.info_terceiros_codigo, c.procedimentos_unidade_acolhimento_codigo, c.procedimentos_unidade_familia_codigo, c.avaliacao_interdisciplinar_caso_codigo, c.outroResponsavel_Qual, c.cpf, c.foto, c.campo_responsavel, "
                + "p.atendimento, p.opiniaoCrianca, p.codigo,"
                + "ja.codigo, ja.violacaoDireitos, ja.ocorrencia_violacaoDireitos, ja.ocorrenciaPolicial, ja.familiarAutorizado, ja.familiarAutorizado_info, ja.restricaoDeFamiliar, ja.restricaoDeFamiliar_info, "
                + "ja.guiaAcolhimento, ja.oficioJuizado, ja.oficioConselho, ja.relatorio_servicoSocial, ja.certidaoNasc, ja.cartaoVacina, ja.relatorio_conselhoTutelar, "
                + "ifo.codigo, ifo.situacao_sociofamiliar as ifo_situacao_sociofamiliar, ifo.opiniao_familia, "
                + "ife.codigo, ife.parentesProximos, ife.parentesProximos_info, ife.contatoParentes, ife.parentesInteressadosNaGuarda, ife.parentesInteressadosNaGuarda_info, ife.situacao_socioFamiliar as ife_situacao_socioFamiliar, ife.opiniao_familiaExtensa, "
                + "it.codigo, it.vinculoTerceiros, it.vinculoTerceiros_info, it.contatoTerceiros, it.terceirosInteressadosNaGuarda, it.terceirosInteressadosNaGuarda_info, it.situacao_socioFamiliar as it_situacao_socioFamiliar, it.opiniao_terceiros, "
                + "pua.codigo, pua.saude, pua.educacao, pua.convivenciaComunitaria, pua.manutencaoVinculosFamiliares, pua.insercaoSocioassistencialMunicipio, pua.esporteLazer, pua.acompanhamentoSocial, pua.acompanhamentoPsicologico, "
                + "puf.codigo, puf.visitaDomiciliar, puf.insercaoSocioassistencialMunicipio, "
                + "aic.codigo, aic.descricao "
                + "FROM crianca c, parecer p, justificativa_para_acolhimento ja, info_familia_origem ifo, info_familia_extensa ife, info_terceiros it, "
                + "procedimentos_unidade_acolhimento pua, procedimentos_unidade_familia puf, avaliacao_interdisciplinar_caso aic "
                + "WHERE c.codigo=? AND c.parecer_codigo = p.codigo  and c.justificativa_para_acolhimento_codigo = ja.codigo and  c.info_familia_origem_codigo = ifo.codigo "
                + "and c.info_familia_extensa_codigo = ife.codigo and c.info_terceiros_codigo = it.codigo and c.procedimentos_unidade_acolhimento_codigo = pua.codigo "
                + "and c.procedimentos_unidade_familia_codigo = puf.codigo and c.avaliacao_interdisciplinar_caso_codigo = aic.codigo order by c.nome";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codigoCrianca);
            rs = stmt.executeQuery();
            
            //quando abre o rs, ele não vai pro primeiro registro. é necessário usar o rs.next() para que ele vá para o primeiro e, depois, para os próximos
            if (rs.next()) {
                crianca.setCodigo(rs.getInt("codigo"));
                crianca.setNome(rs.getString("nome"));
                crianca.setSexo(rs.getString("sexo"));
                Calendar data = Calendar.getInstance();
                try {
                    data.setTime(rs.getDate("data_nascimento"));
                    crianca.setDataNascimento(data);
                } catch (Exception ex) {

                }

                crianca.setResponsavel(rs.getString("responsavel"));
                crianca.setGenitor(rs.getString("genitor"));
                crianca.setGenitora(rs.getString("genitora"));
                crianca.setNumProcesso(rs.getString("num_processo"));
                Calendar dataAcolhimento = Calendar.getInstance();
                try {
                    dataAcolhimento.setTime(rs.getDate("data_acolhimento"));
                    crianca.setDataAcolhimento(dataAcolhimento);
                } catch (Exception ex) {

                }
                crianca.setOrgaoEncaminhador(rs.getString("orgao_encaminhador"));
                crianca.setNaturalidade(rs.getString("naturalidade"));
                crianca.setStatus(rs.getString("status"));
                crianca.setPrimeiroAcolhimento(rs.getString("primeiro_acolhimento"));
                crianca.setIrmaosSobAcolhimento(rs.getString("irmaos_sobAcolhimento"));
                crianca.setIrmaosSobAcolhimentoInfo(rs.getString("irmaos_sobAcolhimento_info"));
                crianca.setGuiaAcolhimento(rs.getString("guia_acolhimento"));
                crianca.setProblemaSaude(rs.getString("problema_saude"));
                crianca.setProblemaSaudeInfo(rs.getString("problema_saude_info"));
                crianca.setTipoDeficiencia(rs.getString("tipo_deficiencia"));
                crianca.setTipoDeficienciaInfo(rs.getString("tipo_deficiencia_info"));
                crianca.setUsoMedicamento(rs.getString("uso_medicamento"));
                crianca.setUsoMedicamentoInfo(rs.getString("uso_medicamento_info"));
                crianca.setFiliacaoGenitor(rs.getString("filiacao_genitor"));
                crianca.setFiliacaoGenitora(rs.getString("filiacao_genitora"));
                crianca.setEnderecoGenitor(rs.getString("endereco_genitor"));
                crianca.setEnderecoGenitora(rs.getString("endereco_genitora"));
                crianca.setEnderecoResponsavel(rs.getString("endereco_responsavel"));
                //crianca.setCampoResponsavel(rs.getString("campo_responsavel"));

                Calendar dataNascGenitor = Calendar.getInstance();
                try {
                    dataNascGenitor.setTime(rs.getDate("dataNasc_genitor"));
                    crianca.setDataNascimentoGenitor(dataNascGenitor);
                } catch (Exception ex) {

                }

                Calendar dataNascGenitora = Calendar.getInstance();
                try {
                    dataNascGenitora.setTime(rs.getDate("dataNasc_genitora"));
                    crianca.setDataNascimentoGenitora(dataNascGenitora);
                } catch (Exception ex) {

                }

                Calendar dataNascResp = Calendar.getInstance();
                try {
                    dataNascResp.setTime(rs.getDate("dataNasc_responsavel"));
                    crianca.setDataNascimentoResponsavel(dataNascResp);
                } catch (Exception ex) {

                }

                crianca.setTipoDocumentoGenitor(rs.getString("tipoDocumento_genitor"));
                crianca.setTipoDocumentoGenitora(rs.getString("tipoDocumento_genitora"));
                crianca.setTipoDocumentoResponsavel(rs.getString("tipoDocumento_responsavel"));
                crianca.setDocumentoGenitor(rs.getString("documento_genitor"));
                crianca.setDocumentoGenitora(rs.getString("documento_genitora"));
                crianca.setDocumentoResponsavel(rs.getString("documento_responsavel"));
                crianca.setTelefoneGenitor(rs.getString("telefone_genitor"));
                crianca.setTelefoneGenitora(rs.getString("telefone_genitora"));
                crianca.setTelefoneResponsavel(rs.getString("telefone_responsavel"));
                crianca.setCpf(rs.getString("cpf"));
                crianca.setOutroResponsavelQual(rs.getString("outroResponsavel_Qual"));
                crianca.setFotoCrianca(rs.getBytes("foto"));

                JustificativaAcolhimento ja = new JustificativaAcolhimento();
                ja.setCodigo(rs.getInt("justificativa_para_acolhimento_codigo"));
                ja.setViolacaoDireitos(rs.getString("violacaoDireitos"));
                ja.setOcorrenciaViolacaoDireitos(rs.getString("ocorrencia_violacaoDireitos"));
                ja.setOcorrenciaPolicial(rs.getString("ocorrenciaPolicial"));
                ja.setFamiliarAutorizado(rs.getString("familiarAutorizado"));
                ja.setFamiliarAutorizadoInfo(rs.getString("familiarAutorizado_info"));
                ja.setRestricaoFamiliar(rs.getString("restricaoDeFamiliar"));
                ja.setRestricaoFamiliarInfo(rs.getString("restricaoDeFamiliar_info"));
                ja.setGuiaAcolhimento(rs.getBoolean("guiaAcolhimento"));
                ja.setOficioJuizado(rs.getBoolean("oficioJuizado"));
                ja.setOficioConselho(rs.getBoolean("oficioConselho"));
                ja.setRelatorioServicoSocial(rs.getBoolean("relatorio_servicoSocial"));
                ja.setCertidaoNascimento(rs.getBoolean("certidaoNasc"));
                ja.setCartaoVacina(rs.getBoolean("cartaoVacina"));
                ja.setRelatorioConselhoTutelar(rs.getBoolean("relatorio_conselhoTutelar"));

                Parecer p = new Parecer();
                p.setCodigo(rs.getInt("parecer_codigo"));
                p.setAtendimento(rs.getString("atendimento"));
                p.setOpiniaoCrianca(rs.getString("opiniaoCrianca"));

                InformacoesFamiliaOrigem ifo = new InformacoesFamiliaOrigem();
                ifo.setCodigo(rs.getInt("info_familia_origem_codigo"));
                ifo.setSituacaoSociofamiliar(rs.getString("ifo_situacao_sociofamiliar"));
                ifo.setOpiniaoFamilia(rs.getString("opiniao_familia"));

                InformacoesFamiliaExtensa ife = new InformacoesFamiliaExtensa();
                ife.setCodigo(rs.getInt("info_familia_extensa_codigo"));
                ife.setParentesProximos(rs.getString("parentesProximos"));
                ife.setParentesProximosInfo(rs.getString("parentesProximos_info"));
                ife.setContatoParentes(rs.getString("contatoParentes"));
                ife.setParentesInteressadosNaGuarda(rs.getString("parentesInteressadosNaGuarda"));
                ife.setParentesInteressadosNaGuardaInfo(rs.getString("parentesInteressadosNaGuarda_info"));
                ife.setSituacaoSociofamiliar(rs.getString("ife_situacao_socioFamiliar"));
                ife.setOpiniaoFamiliaExtensa(rs.getString("opiniao_familiaExtensa"));

                InformacoesTerceiros it = new InformacoesTerceiros();
                it.setCodigo(rs.getInt("info_terceiros_codigo"));
                it.setVinculoTerceiros(rs.getString("vinculoTerceiros"));
                it.setVinculoTerceirosInfo(rs.getString("vinculoTerceiros_info"));
                it.setContatoTerceiros(rs.getString("contatoTerceiros"));
                it.setTerceirosInteressadosNaGuarda(rs.getString("terceirosInteressadosNaGuarda"));
                it.setTerceirosInteressadosNaGuardaInfo(rs.getString("terceirosInteressadosNaGuarda_info"));
                it.setSituacaoSociofamiliar(rs.getString("it_situacao_socioFamiliar"));
                it.setOpiniaoTerceiros(rs.getString("opiniao_terceiros"));

                ProcedimentosUnidadeComFamilia puf = new ProcedimentosUnidadeComFamilia();
                puf.setCodigo(rs.getInt("procedimentos_unidade_familia_codigo"));
                puf.setVisitaDomiciliar(rs.getString("visitaDomiciliar"));
                puf.setInsercaoSocioassistencialMunicipio(rs.getString("insercaoSocioassistencialMunicipio"));

                ProcedimentosUnidadeCrianca puc = new ProcedimentosUnidadeCrianca();
                puc.setCodigo(rs.getInt("procedimentos_unidade_acolhimento_codigo"));
                puc.setSaude(rs.getString("saude"));
                puc.setEducacao(rs.getString("educacao"));
                puc.setConvivenciaComunitaria(rs.getString("convivenciaComunitaria"));
                puc.setManutencaoVinculosFamiliares(rs.getString("manutencaoVinculosFamiliares"));
                puc.setInsercaoSocioassistencialMunicipio(rs.getString("insercaoSocioassistencialMunicipio"));
                puc.setEsporteLazer(rs.getString("esporteLazer"));
                puc.setAcompanhamentoSocial(rs.getString("acompanhamentoSocial"));
                puc.setAcompanhamentoPsicologico(rs.getString("acompanhamentoPsicologico"));

                AvaliacaoInterdisciplinarDoCaso aic = new AvaliacaoInterdisciplinarDoCaso();
                aic.setCodigo(rs.getInt("avaliacao_interdisciplinar_caso_codigo"));
                aic.setDescricao(rs.getString("descricao"));
              
                crianca.setJa(ja);
                crianca.setPa(p);
                crianca.setIfo(ifo);
                crianca.setIfe(ife);
                crianca.setIt(it);
                crianca.setPuc(puc);
                crianca.setPucf(puf);
                crianca.setAidc(aic);
        }

            stmt.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return crianca;
    }

    public ArrayList<ResidenciaFamiliaOrigem> buscarListaResidenciaFamiliaOrigem(int codigoInformacoesFamiliaOrigem) throws ClassNotFoundException {

        ArrayList<ResidenciaFamiliaOrigem> listaResidencia = new ArrayList<>();
        String sql = "select * from residencia_familia_origem WHERE info_familia_origem_codigo = ?";

        try {
            // Obtem conexao com BD
            connection = ConexaoFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, codigoInformacoesFamiliaOrigem);

            ResultSet rs = stmt.executeQuery();

            //quando abre o rs, ele não vai pro primeiro registro. é necessário usar o rs.next() para que ele vá para o primeiro e, depois, para os próximos
            while (rs.next()) {
                ResidenciaFamiliaOrigem rfo = new ResidenciaFamiliaOrigem();
                rfo.setNome(rs.getString("nome"));
                rfo.setIdade(rs.getInt("idade"));
                rfo.setParentesco(rs.getString("parentesco"));
                rfo.setOcupacao(rs.getString("ocupacao"));
                rfo.setRenda(rs.getDouble("renda"));

                listaResidencia.add(rfo);
            }
            stmt.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaResidencia;

    }

    public ArrayList<ResidenciaFamiliaExtensa> buscarListaResidenciaFamiliaExtensa(int codigoInformacoesFamiliaExtensa) throws ClassNotFoundException {

        ArrayList<ResidenciaFamiliaExtensa> listaResidencia = new ArrayList<>();
        String sql = "select * from residencia_familia_extensa WHERE info_familia_extensa_codigo = ?";

        try {
            // Obtem conexao com BD
            connection = ConexaoFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, codigoInformacoesFamiliaExtensa);

            ResultSet rs = stmt.executeQuery();

            //quando abre o rs, ele não vai pro primeiro registro. é necessário usar o rs.next() para que ele vá para o primeiro e, depois, para os próximos
            while (rs.next()) {
                ResidenciaFamiliaExtensa rfe = new ResidenciaFamiliaExtensa();
                rfe.setNome(rs.getString("nome"));
                rfe.setIdade(rs.getInt("idade"));
                rfe.setParentesco(rs.getString("parentesco"));
                rfe.setOcupacao(rs.getString("ocupacao"));
                rfe.setRenda(rs.getDouble("renda"));

                listaResidencia.add(rfe);
            }
            stmt.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaResidencia;

    }

    public ArrayList<ResidenciaTerceiros> buscarListaResidenciaTerceiros(int codigoInformacoesTerceiros) throws ClassNotFoundException {

        ArrayList<ResidenciaTerceiros> listaResidencia = new ArrayList<>();
        String sql = "select * from residencia_terceiros WHERE info_terceiros_codigo = ?";

        try {
            // Obtem conexao com BD
            connection = ConexaoFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, codigoInformacoesTerceiros);

            ResultSet rs = stmt.executeQuery();

            //quando abre o rs, ele não vai pro primeiro registro. é necessário usar o rs.next() para que ele vá para o primeiro e, depois, para os próximos
            while (rs.next()) {
                ResidenciaTerceiros rt = new ResidenciaTerceiros();
                rt.setNome(rs.getString("nome"));
                rt.setIdade(rs.getInt("idade"));
                rt.setOcupacao(rs.getString("ocupacao"));
                rt.setRenda(rs.getDouble("renda"));

                listaResidencia.add(rt);
            }
            stmt.close();
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no acesso ao banco de dados - " + ex.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
        } finally {

            try {
                connection.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão - " + ex.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        }
        return listaResidencia;

    }

    public Crianca getImagem(int codigo) throws Exception {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String SQL = "";
        //ImageIcon imagem = null;       
        // Obtem conexao com BD

        Crianca crianca = new Crianca();

        conn = ConexaoFactory.getConnection();

        // Comando SQL 
        SQL = "SELECT foto from crianca where codigo = ?";

        preparedStatement = conn.prepareStatement(SQL);
        preparedStatement.setInt(1, codigo);

        // Para buscar informações
        rs = preparedStatement.executeQuery();

        if (rs.next()) {
            crianca.setFotoCrianca(rs.getBytes("foto"));
        }

        return crianca;
    }

    public ArrayList<Crianca> getListParaMobile(Usuario usuario) throws ClassNotFoundException, SQLException {

        ArrayList<Crianca> listaCriancas = new ArrayList<>();

        String sql = "SELECT c.codigo, c.nome, c.sexo, c.data_nascimento, c.responsavel, c.genitor, c.genitora, c.num_processo, c.data_acolhimento, c.orgao_encaminhador, c.naturalidade, c.status, c.primeiro_acolhimento, "
                + "c.irmaos_sobAcolhimento, c.irmaos_sobAcolhimento_info, c.guia_acolhimento, c.problema_saude, c.problema_saude_info, c.tipo_deficiencia, c.tipo_deficiencia_info, "
                + "c.uso_medicamento, c.uso_medicamento_info, c.filiacao_genitor, c.filiacao_genitora, c.endereco_genitor, c.endereco_genitora, c.endereco_responsavel, c.dataNasc_genitor, "
                + "c.dataNasc_genitora, c.dataNasc_responsavel, c.tipoDocumento_genitor, c.tipoDocumento_genitora, c.tipoDocumento_responsavel, c.documento_genitor, c.documento_genitora, c.documento_responsavel, "
                + "c.telefone_genitor, c.telefone_genitora, c.telefone_responsavel, c.justificativa_para_acolhimento_codigo, c.parecer_codigo, c.info_familia_origem_codigo, c.info_familia_extensa_codigo, "
                + "c.info_terceiros_codigo, c.procedimentos_unidade_acolhimento_codigo, c.procedimentos_unidade_familia_codigo, c.avaliacao_interdisciplinar_caso_codigo, c.outroResponsavel_Qual, c.cpf, c.foto "
                + "FROM crianca c, usuario u, funcionario f "
                + "WHERE u.codigo = ? "
                + "AND c.unidade_acolhimento_codigo = f.unidade_acolhimento_codigo "
                + "AND u.funcionario_codigo = f.codigo order by nome";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, usuario.getCodigo());
            ResultSet rs = stmt.executeQuery();

            //quando abre o rs, ele não vai pro primeiro registro. é necessário usar o rs.next() para que ele vá para o primeiro e, depois, para os próximos
            while (rs.next()) {
                Crianca crianca = new Crianca();
                crianca.setCodigo(rs.getInt("codigo"));
                crianca.setNome(rs.getString("nome"));
                crianca.setSexo(rs.getString("sexo"));
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("data_nascimento"));
                crianca.setDataNascimento(data);

                crianca.setResponsavel(rs.getString("responsavel"));
                crianca.setGenitor(rs.getString("genitor"));
                crianca.setGenitora(rs.getString("genitora"));
                crianca.setNumProcesso(rs.getString("num_processo"));
                Calendar dataAcolhimento = Calendar.getInstance();
                dataAcolhimento.setTime(rs.getDate("data_acolhimento"));
                crianca.setDataAcolhimento(dataAcolhimento);
                crianca.setOrgaoEncaminhador(rs.getString("orgao_encaminhador"));
                crianca.setNaturalidade(rs.getString("naturalidade"));
                crianca.setStatus(rs.getString("status"));
                crianca.setPrimeiroAcolhimento(rs.getString("primeiro_acolhimento"));
                crianca.setIrmaosSobAcolhimento(rs.getString("irmaos_sobAcolhimento"));
                crianca.setIrmaosSobAcolhimentoInfo(rs.getString("irmaos_sobAcolhimento_info"));
                crianca.setGuiaAcolhimento(rs.getString("guia_acolhimento"));
                crianca.setProblemaSaude(rs.getString("problema_saude"));
                crianca.setProblemaSaudeInfo(rs.getString("problema_saude_info"));
                crianca.setTipoDeficiencia(rs.getString("tipo_deficiencia"));
                crianca.setTipoDeficienciaInfo(rs.getString("tipo_deficiencia_info"));
                crianca.setUsoMedicamento(rs.getString("uso_medicamento"));
                crianca.setUsoMedicamentoInfo(rs.getString("uso_medicamento_info"));
                crianca.setFiliacaoGenitor(rs.getString("filiacao_genitor"));
                crianca.setFiliacaoGenitora(rs.getString("filiacao_genitora"));
                crianca.setEnderecoGenitor(rs.getString("endereco_genitor"));
                crianca.setEnderecoGenitora(rs.getString("endereco_genitora"));
                crianca.setEnderecoResponsavel(rs.getString("endereco_responsavel"));

                crianca.setTipoDocumentoGenitor(rs.getString("tipoDocumento_genitor"));
                crianca.setTipoDocumentoGenitora(rs.getString("tipoDocumento_genitora"));
                crianca.setTipoDocumentoResponsavel(rs.getString("tipoDocumento_responsavel"));
                crianca.setDocumentoGenitor(rs.getString("documento_genitor"));
                crianca.setDocumentoGenitora(rs.getString("documento_genitora"));
                crianca.setDocumentoResponsavel(rs.getString("documento_responsavel"));
                crianca.setTelefoneGenitor(rs.getString("telefone_genitor"));
                crianca.setTelefoneGenitora(rs.getString("telefone_genitora"));
                crianca.setTelefoneResponsavel(rs.getString("telefone_responsavel"));
                crianca.setCpf(rs.getString("cpf"));
                crianca.setOutroResponsavelQual(rs.getString("outroResponsavel_Qual"));
                crianca.setFotoCrianca(rs.getBytes("foto"));

                listaCriancas.add(crianca);
            }
            stmt.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return listaCriancas;

    }
}
