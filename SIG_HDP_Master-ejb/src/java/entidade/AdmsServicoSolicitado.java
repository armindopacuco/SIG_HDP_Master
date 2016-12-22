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
@Table(name = "adms_servico_solicitado", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdmsServicoSolicitado.findAll", query = "SELECT a FROM AdmsServicoSolicitado a"),
    @NamedQuery(name = "AdmsServicoSolicitado.findByPkIdServicoSolicitado", query = "SELECT a FROM AdmsServicoSolicitado a WHERE a.pkIdServicoSolicitado = :pkIdServicoSolicitado"),
    @NamedQuery(name = "AdmsServicoSolicitado.findByObservacao", query = "SELECT a FROM AdmsServicoSolicitado a WHERE a.observacao = :observacao"),
    @NamedQuery(name = "AdmsServicoSolicitado.findByFkIdClassificacaoServicoSolicitado", query = "SELECT a FROM AdmsServicoSolicitado a WHERE a.fkIdClassificacaoServicoSolicitado = :fkIdClassificacaoServicoSolicitado"),
    @NamedQuery(name = "AdmsServicoSolicitado.findByDataAtendimento", query = "SELECT a FROM AdmsServicoSolicitado a WHERE a.dataAtendimento = :dataAtendimento")})
public class AdmsServicoSolicitado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_servico_solicitado")
    private Long pkIdServicoSolicitado;
    @Size(max = 500)
    @Column(name = "observacao")
    private String observacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_id_classificacao_servico_solicitado")
    private int fkIdClassificacaoServicoSolicitado;
    @Column(name = "data_atendimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtendimento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdServicoSolicitado")
    private List<FinPagamento> finPagamentoList;
    @OneToMany(mappedBy = "fkIdServicoSolicitado")
    private List<DiagExameRealizado> diagExameRealizadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPkIdAdmsSolicitacaoServico")
    private List<AmbConsulta> ambConsultaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pkIdServicoSolicitado")
    private List<AdmsAtividadeDesconhecido> admsAtividadeDesconhecidoList;
    @JoinColumn(name = "fk_id_recepcionista", referencedColumnName = "pk_id_funcionario")
    @ManyToOne
    private RhFuncionario fkIdRecepcionista;
    @JoinColumn(name = "fk_id_preco_preco", referencedColumnName = "pk_id_preco_preco")
    @ManyToOne(optional = false)
    private FinPreco fkIdPrecoPreco;
    @JoinColumn(name = "fk_id_tipo_solicitacao", referencedColumnName = "pk_id_tipo_solicitacao")
    @ManyToOne(optional = false)
    private AdmsTipoSolicitacaoServico fkIdTipoSolicitacao;
    @JoinColumn(name = "fk_id_solicitacao", referencedColumnName = "pk_id_solicitacao")
    @ManyToOne(optional = false)
    private AdmsSolicitacao fkIdSolicitacao;
    @JoinColumn(name = "fk_id_servico", referencedColumnName = "pk_id_servico")
    @ManyToOne(optional = false)
    private AdmsServico fkIdServico;
    @JoinColumn(name = "fk_id_estado_pagamento", referencedColumnName = "pk_id_estado_pagamento")
    @ManyToOne(optional = false)
    private AdmsEstadoPagamento fkIdEstadoPagamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdServicoSolicitado")
    private List<AdmsAgendamento> admsAgendamentoList;

    public AdmsServicoSolicitado() {
    }

    public AdmsServicoSolicitado(Long pkIdServicoSolicitado) {
        this.pkIdServicoSolicitado = pkIdServicoSolicitado;
    }

    public AdmsServicoSolicitado(Long pkIdServicoSolicitado, int fkIdClassificacaoServicoSolicitado) {
        this.pkIdServicoSolicitado = pkIdServicoSolicitado;
        this.fkIdClassificacaoServicoSolicitado = fkIdClassificacaoServicoSolicitado;
    }

    public Long getPkIdServicoSolicitado() {
        return pkIdServicoSolicitado;
    }

    public void setPkIdServicoSolicitado(Long pkIdServicoSolicitado) {
        this.pkIdServicoSolicitado = pkIdServicoSolicitado;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getFkIdClassificacaoServicoSolicitado() {
        return fkIdClassificacaoServicoSolicitado;
    }

    public void setFkIdClassificacaoServicoSolicitado(int fkIdClassificacaoServicoSolicitado) {
        this.fkIdClassificacaoServicoSolicitado = fkIdClassificacaoServicoSolicitado;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    @XmlTransient
    public List<FinPagamento> getFinPagamentoList() {
        return finPagamentoList;
    }

    public void setFinPagamentoList(List<FinPagamento> finPagamentoList) {
        this.finPagamentoList = finPagamentoList;
    }

    @XmlTransient
    public List<DiagExameRealizado> getDiagExameRealizadoList() {
        return diagExameRealizadoList;
    }

    public void setDiagExameRealizadoList(List<DiagExameRealizado> diagExameRealizadoList) {
        this.diagExameRealizadoList = diagExameRealizadoList;
    }

    @XmlTransient
    public List<AmbConsulta> getAmbConsultaList() {
        return ambConsultaList;
    }

    public void setAmbConsultaList(List<AmbConsulta> ambConsultaList) {
        this.ambConsultaList = ambConsultaList;
    }

    @XmlTransient
    public List<AdmsAtividadeDesconhecido> getAdmsAtividadeDesconhecidoList() {
        return admsAtividadeDesconhecidoList;
    }

    public void setAdmsAtividadeDesconhecidoList(List<AdmsAtividadeDesconhecido> admsAtividadeDesconhecidoList) {
        this.admsAtividadeDesconhecidoList = admsAtividadeDesconhecidoList;
    }

    public RhFuncionario getFkIdRecepcionista() {
        return fkIdRecepcionista;
    }

    public void setFkIdRecepcionista(RhFuncionario fkIdRecepcionista) {
        this.fkIdRecepcionista = fkIdRecepcionista;
    }

    public FinPreco getFkIdPrecoPreco() {
        return fkIdPrecoPreco;
    }

    public void setFkIdPrecoPreco(FinPreco fkIdPrecoPreco) {
        this.fkIdPrecoPreco = fkIdPrecoPreco;
    }

    public AdmsTipoSolicitacaoServico getFkIdTipoSolicitacao() {
        return fkIdTipoSolicitacao;
    }

    public void setFkIdTipoSolicitacao(AdmsTipoSolicitacaoServico fkIdTipoSolicitacao) {
        this.fkIdTipoSolicitacao = fkIdTipoSolicitacao;
    }

    public AdmsSolicitacao getFkIdSolicitacao() {
        return fkIdSolicitacao;
    }

    public void setFkIdSolicitacao(AdmsSolicitacao fkIdSolicitacao) {
        this.fkIdSolicitacao = fkIdSolicitacao;
    }

    public AdmsServico getFkIdServico() {
        return fkIdServico;
    }

    public void setFkIdServico(AdmsServico fkIdServico) {
        this.fkIdServico = fkIdServico;
    }

    public AdmsEstadoPagamento getFkIdEstadoPagamento() {
        return fkIdEstadoPagamento;
    }

    public void setFkIdEstadoPagamento(AdmsEstadoPagamento fkIdEstadoPagamento) {
        this.fkIdEstadoPagamento = fkIdEstadoPagamento;
    }

    @XmlTransient
    public List<AdmsAgendamento> getAdmsAgendamentoList() {
        return admsAgendamentoList;
    }

    public void setAdmsAgendamentoList(List<AdmsAgendamento> admsAgendamentoList) {
        this.admsAgendamentoList = admsAgendamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdServicoSolicitado != null ? pkIdServicoSolicitado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmsServicoSolicitado)) {
            return false;
        }
        AdmsServicoSolicitado other = (AdmsServicoSolicitado) object;
        if ((this.pkIdServicoSolicitado == null && other.pkIdServicoSolicitado != null) || (this.pkIdServicoSolicitado != null && !this.pkIdServicoSolicitado.equals(other.pkIdServicoSolicitado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AdmsServicoSolicitado[ pkIdServicoSolicitado=" + pkIdServicoSolicitado + " ]";
    }
    
}
