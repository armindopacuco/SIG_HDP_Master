/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "rh_funcionario", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhFuncionario.findAll", query = "SELECT r FROM RhFuncionario r"),
    @NamedQuery(name = "RhFuncionario.findByPkIdFuncionario", query = "SELECT r FROM RhFuncionario r WHERE r.pkIdFuncionario = :pkIdFuncionario"),
    @NamedQuery(name = "RhFuncionario.findByNumeroGuiaTransferencia", query = "SELECT r FROM RhFuncionario r WHERE r.numeroGuiaTransferencia = :numeroGuiaTransferencia"),
    @NamedQuery(name = "RhFuncionario.findByDataAdmissao", query = "SELECT r FROM RhFuncionario r WHERE r.dataAdmissao = :dataAdmissao")})
public class RhFuncionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_funcionario")
    private Integer pkIdFuncionario;
    @Size(max = 45)
    @Column(name = "numero_guia_transferencia")
    private String numeroGuiaTransferencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_admissao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAdmissao;
    @OneToMany(mappedBy = "fkIdTecnico")
    private List<DiagExameDador> diagExameDadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionarioSolicitante")
    private List<AdmsSolicitacao> admsSolicitacaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionario")
    private List<EmgUrgencia> emgUrgenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdRecepcionista")
    private List<FinPagamento> finPagamentoList;
    @OneToMany(mappedBy = "fkIdFuncionario")
    private List<FarmFichaDeStock> farmFichaDeStockList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionario")
    private List<RhLicencaFuncionario> rhLicencaFuncionarioList;
    @OneToMany(mappedBy = "fkIdFuncionario")
    private List<InterTratamentoSistematico> interTratamentoSistematicoList;
    @OneToMany(mappedBy = "fkIdFuncionario")
    private List<DiagExameRealizado> diagExameRealizadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionarioSolicitou")
    private List<FarmMovimento> farmMovimentoList;
    @OneToMany(mappedBy = "fkIdFuncionarioEntregou")
    private List<FarmMovimento> farmMovimentoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionario")
    private List<InterEnfermaria> interEnfermariaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionario")
    private List<RhPedidoFerias> rhPedidoFeriasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionario")
    private List<SupiEnfermeiro> supiEnfermeiroList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionario")
    private List<InterTabelaVigilancia> interTabelaVigilanciaList;
    @OneToMany(mappedBy = "fkIdFuncionario")
    private List<InterSessoesEduDadas> interSessoesEduDadasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionarioCadastrou")
    private List<FarmArmazenamento> farmArmazenamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionario")
    private List<AmbTriagem> ambTriagemList;
    @OneToMany(mappedBy = "fkVerificadoPor")
    private List<DiagTipagemDador> diagTipagemDadorList;
    @OneToMany(mappedBy = "fkRealizadoPor")
    private List<DiagTipagemDador> diagTipagemDadorList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionarioEnfermeiro")
    private List<InterRegistoInternamento> interRegistoInternamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionarioMedico")
    private List<InterRegistoInternamento> interRegistoInternamentoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionario")
    private List<AmbConsulta> ambConsultaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionario")
    private List<InterInscricaoInternamento> interInscricaoInternamentoList;
    @OneToMany(mappedBy = "fkIdFuncionario")
    private List<InterAntropometria> interAntropometriaList;
    @OneToMany(mappedBy = "fkIdFuncionario")
    private List<InterDietaTerapeutica> interDietaTerapeuticaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionario")
    private List<FarmVenda> farmVendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionario")
    private List<InterQuartoInternamento> interQuartoInternamentoList;
    @OneToMany(mappedBy = "fkIdResponsavel")
    private List<MorgueEntradaCorpo> morgueEntradaCorpoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionario")
    private List<FarmFornecimento> farmFornecimentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionario")
    private List<InterDoencaInternamentoPaciente> interDoencaInternamentoPacienteList;
    @OneToMany(mappedBy = "fkIdFuncionario")
    private List<InterConclusao> interConclusaoList;
    @OneToMany(mappedBy = "fkVerificadoPor")
    private List<DiagTipagemDoente> diagTipagemDoenteList;
    @OneToMany(mappedBy = "fkRealizadoPor")
    private List<DiagTipagemDoente> diagTipagemDoenteList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionario")
    private List<RhDependente> rhDependenteList;
    @OneToMany(mappedBy = "fkIdRecepcionista")
    private List<AdmsServicoSolicitado> admsServicoSolicitadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionario")
    private List<InterRegistoSaida> interRegistoSaidaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionarioCadastrou")
    private List<FarmMaterialSanitario> farmMaterialSanitarioList;
    @OneToMany(mappedBy = "fkVerificadoPor")
    private List<DiagTransfusao> diagTransfusaoList;
    @OneToMany(mappedBy = "fkRealizadoPor")
    private List<DiagTransfusao> diagTransfusaoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionario")
    private List<InterTituloAlta> interTituloAltaList;
    @OneToMany(mappedBy = "fkIdFuncionario")
    private List<DiagColecta> diagColectaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionario")
    private List<SupiAvaliacaoDesempenho> supiAvaliacaoDesempenhoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionario")
    private List<RhFuncionarioHasRhTipoFalta> rhFuncionarioHasRhTipoFaltaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionario")
    private List<AmbDiagnostico> ambDiagnosticoList;
    @OneToMany(mappedBy = "fkIdFuncionario")
    private List<InterTratamentoEspecifico> interTratamentoEspecificoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionario")
    private List<EmgTratamento> emgTratamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdMedico")
    private List<AdmsAgendamentoMedico> admsAgendamentoMedicoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionario")
    private List<AmbConsultorioAtendimento> ambConsultorioAtendimentoList;
    @OneToMany(mappedBy = "fkIdFuncionario")
    private List<InterVacinacao> interVacinacaoList;
    @JoinColumn(name = "fk_id_tipo_funcionario", referencedColumnName = "pk_id_tipo_funcionario")
    @ManyToOne(optional = false)
    private RhTipoFuncionario fkIdTipoFuncionario;
    @JoinColumn(name = "fk_id_estado_funcionario", referencedColumnName = "pk_id_estado_funcionario")
    @ManyToOne(optional = false)
    private RhEstadoFuncionario fkIdEstadoFuncionario;
    @JoinColumn(name = "fk_id_contrato", referencedColumnName = "pk_id_contrato")
    @OneToOne
    private RhContrato fkIdContrato;
    @JoinColumn(name = "fk_id_cargo", referencedColumnName = "pk_id_cargo")
    @ManyToOne(optional = false)
    private RhCargo fkIdCargo;
    @JoinColumn(name = "fk_id_categoria", referencedColumnName = "pk_id_candidato")
    @ManyToOne(optional = false)
    private RhCandidato fkIdCategoria;
    @JoinColumn(name = "fk_id_pessoa", referencedColumnName = "pk_id_pessoa")
    @OneToOne(optional = false)
    private GrlPessoa fkIdPessoa;
    @JoinColumn(name = "fk_id_centro_hospitalar", referencedColumnName = "pk_id_centro")
    @ManyToOne(optional = false)
    private GrlCentroHospitalar fkIdCentroHospitalar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionario")
    private List<InterCamaInternamento> interCamaInternamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionario")
    private List<RhFuncionarioAsGrlEspecialidade> rhFuncionarioAsGrlEspecialidadeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFuncionario")
    private List<SupiFormador> supiFormadorList;
    @OneToMany(mappedBy = "fkIdFuncionario")
    private List<InterControloTerapeuticoPediatria> interControloTerapeuticoPediatriaList;
    @OneToMany(mappedBy = "fkIdFuncionario")
    private List<InterStatus> interStatusList;

    public RhFuncionario() {
    }

    public RhFuncionario(Integer pkIdFuncionario) {
        this.pkIdFuncionario = pkIdFuncionario;
    }

    public RhFuncionario(Integer pkIdFuncionario, Date dataAdmissao) {
        this.pkIdFuncionario = pkIdFuncionario;
        this.dataAdmissao = dataAdmissao;
    }

    public Integer getPkIdFuncionario() {
        return pkIdFuncionario;
    }

    public void setPkIdFuncionario(Integer pkIdFuncionario) {
        this.pkIdFuncionario = pkIdFuncionario;
    }

    public String getNumeroGuiaTransferencia() {
        return numeroGuiaTransferencia;
    }

    public void setNumeroGuiaTransferencia(String numeroGuiaTransferencia) {
        this.numeroGuiaTransferencia = numeroGuiaTransferencia;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    @XmlTransient
    public List<DiagExameDador> getDiagExameDadorList() {
        return diagExameDadorList;
    }

    public void setDiagExameDadorList(List<DiagExameDador> diagExameDadorList) {
        this.diagExameDadorList = diagExameDadorList;
    }

    @XmlTransient
    public List<AdmsSolicitacao> getAdmsSolicitacaoList() {
        return admsSolicitacaoList;
    }

    public void setAdmsSolicitacaoList(List<AdmsSolicitacao> admsSolicitacaoList) {
        this.admsSolicitacaoList = admsSolicitacaoList;
    }

    @XmlTransient
    public List<EmgUrgencia> getEmgUrgenciaList() {
        return emgUrgenciaList;
    }

    public void setEmgUrgenciaList(List<EmgUrgencia> emgUrgenciaList) {
        this.emgUrgenciaList = emgUrgenciaList;
    }

    @XmlTransient
    public List<FinPagamento> getFinPagamentoList() {
        return finPagamentoList;
    }

    public void setFinPagamentoList(List<FinPagamento> finPagamentoList) {
        this.finPagamentoList = finPagamentoList;
    }

    @XmlTransient
    public List<FarmFichaDeStock> getFarmFichaDeStockList() {
        return farmFichaDeStockList;
    }

    public void setFarmFichaDeStockList(List<FarmFichaDeStock> farmFichaDeStockList) {
        this.farmFichaDeStockList = farmFichaDeStockList;
    }

    @XmlTransient
    public List<RhLicencaFuncionario> getRhLicencaFuncionarioList() {
        return rhLicencaFuncionarioList;
    }

    public void setRhLicencaFuncionarioList(List<RhLicencaFuncionario> rhLicencaFuncionarioList) {
        this.rhLicencaFuncionarioList = rhLicencaFuncionarioList;
    }

    @XmlTransient
    public List<InterTratamentoSistematico> getInterTratamentoSistematicoList() {
        return interTratamentoSistematicoList;
    }

    public void setInterTratamentoSistematicoList(List<InterTratamentoSistematico> interTratamentoSistematicoList) {
        this.interTratamentoSistematicoList = interTratamentoSistematicoList;
    }

    @XmlTransient
    public List<DiagExameRealizado> getDiagExameRealizadoList() {
        return diagExameRealizadoList;
    }

    public void setDiagExameRealizadoList(List<DiagExameRealizado> diagExameRealizadoList) {
        this.diagExameRealizadoList = diagExameRealizadoList;
    }

    @XmlTransient
    public List<FarmMovimento> getFarmMovimentoList() {
        return farmMovimentoList;
    }

    public void setFarmMovimentoList(List<FarmMovimento> farmMovimentoList) {
        this.farmMovimentoList = farmMovimentoList;
    }

    @XmlTransient
    public List<FarmMovimento> getFarmMovimentoList1() {
        return farmMovimentoList1;
    }

    public void setFarmMovimentoList1(List<FarmMovimento> farmMovimentoList1) {
        this.farmMovimentoList1 = farmMovimentoList1;
    }

    @XmlTransient
    public List<InterEnfermaria> getInterEnfermariaList() {
        return interEnfermariaList;
    }

    public void setInterEnfermariaList(List<InterEnfermaria> interEnfermariaList) {
        this.interEnfermariaList = interEnfermariaList;
    }

    @XmlTransient
    public List<RhPedidoFerias> getRhPedidoFeriasList() {
        return rhPedidoFeriasList;
    }

    public void setRhPedidoFeriasList(List<RhPedidoFerias> rhPedidoFeriasList) {
        this.rhPedidoFeriasList = rhPedidoFeriasList;
    }

    @XmlTransient
    public List<SupiEnfermeiro> getSupiEnfermeiroList() {
        return supiEnfermeiroList;
    }

    public void setSupiEnfermeiroList(List<SupiEnfermeiro> supiEnfermeiroList) {
        this.supiEnfermeiroList = supiEnfermeiroList;
    }

    @XmlTransient
    public List<InterTabelaVigilancia> getInterTabelaVigilanciaList() {
        return interTabelaVigilanciaList;
    }

    public void setInterTabelaVigilanciaList(List<InterTabelaVigilancia> interTabelaVigilanciaList) {
        this.interTabelaVigilanciaList = interTabelaVigilanciaList;
    }

    @XmlTransient
    public List<InterSessoesEduDadas> getInterSessoesEduDadasList() {
        return interSessoesEduDadasList;
    }

    public void setInterSessoesEduDadasList(List<InterSessoesEduDadas> interSessoesEduDadasList) {
        this.interSessoesEduDadasList = interSessoesEduDadasList;
    }

    @XmlTransient
    public List<FarmArmazenamento> getFarmArmazenamentoList() {
        return farmArmazenamentoList;
    }

    public void setFarmArmazenamentoList(List<FarmArmazenamento> farmArmazenamentoList) {
        this.farmArmazenamentoList = farmArmazenamentoList;
    }

    @XmlTransient
    public List<AmbTriagem> getAmbTriagemList() {
        return ambTriagemList;
    }

    public void setAmbTriagemList(List<AmbTriagem> ambTriagemList) {
        this.ambTriagemList = ambTriagemList;
    }

    @XmlTransient
    public List<DiagTipagemDador> getDiagTipagemDadorList() {
        return diagTipagemDadorList;
    }

    public void setDiagTipagemDadorList(List<DiagTipagemDador> diagTipagemDadorList) {
        this.diagTipagemDadorList = diagTipagemDadorList;
    }

    @XmlTransient
    public List<DiagTipagemDador> getDiagTipagemDadorList1() {
        return diagTipagemDadorList1;
    }

    public void setDiagTipagemDadorList1(List<DiagTipagemDador> diagTipagemDadorList1) {
        this.diagTipagemDadorList1 = diagTipagemDadorList1;
    }

    @XmlTransient
    public List<InterRegistoInternamento> getInterRegistoInternamentoList() {
        return interRegistoInternamentoList;
    }

    public void setInterRegistoInternamentoList(List<InterRegistoInternamento> interRegistoInternamentoList) {
        this.interRegistoInternamentoList = interRegistoInternamentoList;
    }

    @XmlTransient
    public List<InterRegistoInternamento> getInterRegistoInternamentoList1() {
        return interRegistoInternamentoList1;
    }

    public void setInterRegistoInternamentoList1(List<InterRegistoInternamento> interRegistoInternamentoList1) {
        this.interRegistoInternamentoList1 = interRegistoInternamentoList1;
    }

    @XmlTransient
    public List<AmbConsulta> getAmbConsultaList() {
        return ambConsultaList;
    }

    public void setAmbConsultaList(List<AmbConsulta> ambConsultaList) {
        this.ambConsultaList = ambConsultaList;
    }

    @XmlTransient
    public List<InterInscricaoInternamento> getInterInscricaoInternamentoList() {
        return interInscricaoInternamentoList;
    }

    public void setInterInscricaoInternamentoList(List<InterInscricaoInternamento> interInscricaoInternamentoList) {
        this.interInscricaoInternamentoList = interInscricaoInternamentoList;
    }

    @XmlTransient
    public List<InterAntropometria> getInterAntropometriaList() {
        return interAntropometriaList;
    }

    public void setInterAntropometriaList(List<InterAntropometria> interAntropometriaList) {
        this.interAntropometriaList = interAntropometriaList;
    }

    @XmlTransient
    public List<InterDietaTerapeutica> getInterDietaTerapeuticaList() {
        return interDietaTerapeuticaList;
    }

    public void setInterDietaTerapeuticaList(List<InterDietaTerapeutica> interDietaTerapeuticaList) {
        this.interDietaTerapeuticaList = interDietaTerapeuticaList;
    }

    @XmlTransient
    public List<FarmVenda> getFarmVendaList() {
        return farmVendaList;
    }

    public void setFarmVendaList(List<FarmVenda> farmVendaList) {
        this.farmVendaList = farmVendaList;
    }

    @XmlTransient
    public List<InterQuartoInternamento> getInterQuartoInternamentoList() {
        return interQuartoInternamentoList;
    }

    public void setInterQuartoInternamentoList(List<InterQuartoInternamento> interQuartoInternamentoList) {
        this.interQuartoInternamentoList = interQuartoInternamentoList;
    }

    @XmlTransient
    public List<MorgueEntradaCorpo> getMorgueEntradaCorpoList() {
        return morgueEntradaCorpoList;
    }

    public void setMorgueEntradaCorpoList(List<MorgueEntradaCorpo> morgueEntradaCorpoList) {
        this.morgueEntradaCorpoList = morgueEntradaCorpoList;
    }

    @XmlTransient
    public List<FarmFornecimento> getFarmFornecimentoList() {
        return farmFornecimentoList;
    }

    public void setFarmFornecimentoList(List<FarmFornecimento> farmFornecimentoList) {
        this.farmFornecimentoList = farmFornecimentoList;
    }

    @XmlTransient
    public List<InterDoencaInternamentoPaciente> getInterDoencaInternamentoPacienteList() {
        return interDoencaInternamentoPacienteList;
    }

    public void setInterDoencaInternamentoPacienteList(List<InterDoencaInternamentoPaciente> interDoencaInternamentoPacienteList) {
        this.interDoencaInternamentoPacienteList = interDoencaInternamentoPacienteList;
    }

    @XmlTransient
    public List<InterConclusao> getInterConclusaoList() {
        return interConclusaoList;
    }

    public void setInterConclusaoList(List<InterConclusao> interConclusaoList) {
        this.interConclusaoList = interConclusaoList;
    }

    @XmlTransient
    public List<DiagTipagemDoente> getDiagTipagemDoenteList() {
        return diagTipagemDoenteList;
    }

    public void setDiagTipagemDoenteList(List<DiagTipagemDoente> diagTipagemDoenteList) {
        this.diagTipagemDoenteList = diagTipagemDoenteList;
    }

    @XmlTransient
    public List<DiagTipagemDoente> getDiagTipagemDoenteList1() {
        return diagTipagemDoenteList1;
    }

    public void setDiagTipagemDoenteList1(List<DiagTipagemDoente> diagTipagemDoenteList1) {
        this.diagTipagemDoenteList1 = diagTipagemDoenteList1;
    }

    @XmlTransient
    public List<RhDependente> getRhDependenteList() {
        return rhDependenteList;
    }

    public void setRhDependenteList(List<RhDependente> rhDependenteList) {
        this.rhDependenteList = rhDependenteList;
    }

    @XmlTransient
    public List<AdmsServicoSolicitado> getAdmsServicoSolicitadoList() {
        return admsServicoSolicitadoList;
    }

    public void setAdmsServicoSolicitadoList(List<AdmsServicoSolicitado> admsServicoSolicitadoList) {
        this.admsServicoSolicitadoList = admsServicoSolicitadoList;
    }

    @XmlTransient
    public List<InterRegistoSaida> getInterRegistoSaidaList() {
        return interRegistoSaidaList;
    }

    public void setInterRegistoSaidaList(List<InterRegistoSaida> interRegistoSaidaList) {
        this.interRegistoSaidaList = interRegistoSaidaList;
    }

    @XmlTransient
    public List<FarmMaterialSanitario> getFarmMaterialSanitarioList() {
        return farmMaterialSanitarioList;
    }

    public void setFarmMaterialSanitarioList(List<FarmMaterialSanitario> farmMaterialSanitarioList) {
        this.farmMaterialSanitarioList = farmMaterialSanitarioList;
    }

    @XmlTransient
    public List<DiagTransfusao> getDiagTransfusaoList() {
        return diagTransfusaoList;
    }

    public void setDiagTransfusaoList(List<DiagTransfusao> diagTransfusaoList) {
        this.diagTransfusaoList = diagTransfusaoList;
    }

    @XmlTransient
    public List<DiagTransfusao> getDiagTransfusaoList1() {
        return diagTransfusaoList1;
    }

    public void setDiagTransfusaoList1(List<DiagTransfusao> diagTransfusaoList1) {
        this.diagTransfusaoList1 = diagTransfusaoList1;
    }

    @XmlTransient
    public List<InterTituloAlta> getInterTituloAltaList() {
        return interTituloAltaList;
    }

    public void setInterTituloAltaList(List<InterTituloAlta> interTituloAltaList) {
        this.interTituloAltaList = interTituloAltaList;
    }

    @XmlTransient
    public List<DiagColecta> getDiagColectaList() {
        return diagColectaList;
    }

    public void setDiagColectaList(List<DiagColecta> diagColectaList) {
        this.diagColectaList = diagColectaList;
    }

    @XmlTransient
    public List<SupiAvaliacaoDesempenho> getSupiAvaliacaoDesempenhoList() {
        return supiAvaliacaoDesempenhoList;
    }

    public void setSupiAvaliacaoDesempenhoList(List<SupiAvaliacaoDesempenho> supiAvaliacaoDesempenhoList) {
        this.supiAvaliacaoDesempenhoList = supiAvaliacaoDesempenhoList;
    }

    @XmlTransient
    public List<RhFuncionarioHasRhTipoFalta> getRhFuncionarioHasRhTipoFaltaList() {
        return rhFuncionarioHasRhTipoFaltaList;
    }

    public void setRhFuncionarioHasRhTipoFaltaList(List<RhFuncionarioHasRhTipoFalta> rhFuncionarioHasRhTipoFaltaList) {
        this.rhFuncionarioHasRhTipoFaltaList = rhFuncionarioHasRhTipoFaltaList;
    }

    @XmlTransient
    public List<AmbDiagnostico> getAmbDiagnosticoList() {
        return ambDiagnosticoList;
    }

    public void setAmbDiagnosticoList(List<AmbDiagnostico> ambDiagnosticoList) {
        this.ambDiagnosticoList = ambDiagnosticoList;
    }

    @XmlTransient
    public List<InterTratamentoEspecifico> getInterTratamentoEspecificoList() {
        return interTratamentoEspecificoList;
    }

    public void setInterTratamentoEspecificoList(List<InterTratamentoEspecifico> interTratamentoEspecificoList) {
        this.interTratamentoEspecificoList = interTratamentoEspecificoList;
    }

    @XmlTransient
    public List<EmgTratamento> getEmgTratamentoList() {
        return emgTratamentoList;
    }

    public void setEmgTratamentoList(List<EmgTratamento> emgTratamentoList) {
        this.emgTratamentoList = emgTratamentoList;
    }

    @XmlTransient
    public List<AdmsAgendamentoMedico> getAdmsAgendamentoMedicoList() {
        return admsAgendamentoMedicoList;
    }

    public void setAdmsAgendamentoMedicoList(List<AdmsAgendamentoMedico> admsAgendamentoMedicoList) {
        this.admsAgendamentoMedicoList = admsAgendamentoMedicoList;
    }

    @XmlTransient
    public List<AmbConsultorioAtendimento> getAmbConsultorioAtendimentoList() {
        return ambConsultorioAtendimentoList;
    }

    public void setAmbConsultorioAtendimentoList(List<AmbConsultorioAtendimento> ambConsultorioAtendimentoList) {
        this.ambConsultorioAtendimentoList = ambConsultorioAtendimentoList;
    }

    @XmlTransient
    public List<InterVacinacao> getInterVacinacaoList() {
        return interVacinacaoList;
    }

    public void setInterVacinacaoList(List<InterVacinacao> interVacinacaoList) {
        this.interVacinacaoList = interVacinacaoList;
    }

    public RhTipoFuncionario getFkIdTipoFuncionario() {
        return fkIdTipoFuncionario;
    }

    public void setFkIdTipoFuncionario(RhTipoFuncionario fkIdTipoFuncionario) {
        this.fkIdTipoFuncionario = fkIdTipoFuncionario;
    }

    public RhEstadoFuncionario getFkIdEstadoFuncionario() {
        return fkIdEstadoFuncionario;
    }

    public void setFkIdEstadoFuncionario(RhEstadoFuncionario fkIdEstadoFuncionario) {
        this.fkIdEstadoFuncionario = fkIdEstadoFuncionario;
    }

    public RhContrato getFkIdContrato() {
        return fkIdContrato;
    }

    public void setFkIdContrato(RhContrato fkIdContrato) {
        this.fkIdContrato = fkIdContrato;
    }

    public RhCargo getFkIdCargo() {
        return fkIdCargo;
    }

    public void setFkIdCargo(RhCargo fkIdCargo) {
        this.fkIdCargo = fkIdCargo;
    }

    public RhCandidato getFkIdCategoria() {
        return fkIdCategoria;
    }

    public void setFkIdCategoria(RhCandidato fkIdCategoria) {
        this.fkIdCategoria = fkIdCategoria;
    }

    public GrlPessoa getFkIdPessoa() {
        return fkIdPessoa;
    }

    public void setFkIdPessoa(GrlPessoa fkIdPessoa) {
        this.fkIdPessoa = fkIdPessoa;
    }

    public GrlCentroHospitalar getFkIdCentroHospitalar() {
        return fkIdCentroHospitalar;
    }

    public void setFkIdCentroHospitalar(GrlCentroHospitalar fkIdCentroHospitalar) {
        this.fkIdCentroHospitalar = fkIdCentroHospitalar;
    }

    @XmlTransient
    public List<InterCamaInternamento> getInterCamaInternamentoList() {
        return interCamaInternamentoList;
    }

    public void setInterCamaInternamentoList(List<InterCamaInternamento> interCamaInternamentoList) {
        this.interCamaInternamentoList = interCamaInternamentoList;
    }

    @XmlTransient
    public List<RhFuncionarioAsGrlEspecialidade> getRhFuncionarioAsGrlEspecialidadeList() {
        return rhFuncionarioAsGrlEspecialidadeList;
    }

    public void setRhFuncionarioAsGrlEspecialidadeList(List<RhFuncionarioAsGrlEspecialidade> rhFuncionarioAsGrlEspecialidadeList) {
        this.rhFuncionarioAsGrlEspecialidadeList = rhFuncionarioAsGrlEspecialidadeList;
    }

    @XmlTransient
    public List<SupiFormador> getSupiFormadorList() {
        return supiFormadorList;
    }

    public void setSupiFormadorList(List<SupiFormador> supiFormadorList) {
        this.supiFormadorList = supiFormadorList;
    }

    @XmlTransient
    public List<InterControloTerapeuticoPediatria> getInterControloTerapeuticoPediatriaList() {
        return interControloTerapeuticoPediatriaList;
    }

    public void setInterControloTerapeuticoPediatriaList(List<InterControloTerapeuticoPediatria> interControloTerapeuticoPediatriaList) {
        this.interControloTerapeuticoPediatriaList = interControloTerapeuticoPediatriaList;
    }

    @XmlTransient
    public List<InterStatus> getInterStatusList() {
        return interStatusList;
    }

    public void setInterStatusList(List<InterStatus> interStatusList) {
        this.interStatusList = interStatusList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdFuncionario != null ? pkIdFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhFuncionario)) {
            return false;
        }
        RhFuncionario other = (RhFuncionario) object;
        if ((this.pkIdFuncionario == null && other.pkIdFuncionario != null) || (this.pkIdFuncionario != null && !this.pkIdFuncionario.equals(other.pkIdFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.RhFuncionario[ pkIdFuncionario=" + pkIdFuncionario + " ]";
    }
    
}
