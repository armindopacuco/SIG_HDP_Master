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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "rh_contrato", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhContrato.findAll", query = "SELECT r FROM RhContrato r"),
    @NamedQuery(name = "RhContrato.findByPkIdContrato", query = "SELECT r FROM RhContrato r WHERE r.pkIdContrato = :pkIdContrato"),
    @NamedQuery(name = "RhContrato.findByDuracaoMeses", query = "SELECT r FROM RhContrato r WHERE r.duracaoMeses = :duracaoMeses"),
    @NamedQuery(name = "RhContrato.findByDataInicio", query = "SELECT r FROM RhContrato r WHERE r.dataInicio = :dataInicio"),
    @NamedQuery(name = "RhContrato.findByDataTermino", query = "SELECT r FROM RhContrato r WHERE r.dataTermino = :dataTermino"),
    @NamedQuery(name = "RhContrato.findByDataCadastro", query = "SELECT r FROM RhContrato r WHERE r.dataCadastro = :dataCadastro")})
public class RhContrato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_contrato")
    private Integer pkIdContrato;
    @Column(name = "duracao_meses")
    private Integer duracaoMeses;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Column(name = "data_termino")
    @Temporal(TemporalType.DATE)
    private Date dataTermino;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIME)
    private Date dataCadastro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdContrato")
    private List<RhRenovacaoContrato> rhRenovacaoContratoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "fkIdContratoAnterior")
    private RhRenovacaoContrato rhRenovacaoContrato;
    @JoinColumn(name = "fk_id_tipo_contrato", referencedColumnName = "pk_id_tipo_contrato")
    @ManyToOne
    private RhTipoContrato fkIdTipoContrato;
    @JoinColumn(name = "fk_id_tabela_salarial", referencedColumnName = "pk_id_tabela_salarial")
    @ManyToOne(optional = false)
    private RhTabelaSalarial fkIdTabelaSalarial;
    @JoinColumn(name = "fk_id_forma_pagamento", referencedColumnName = "pk_id_forma_pagamento")
    @ManyToOne(optional = false)
    private RhFormaPagamento fkIdFormaPagamento;
    @JoinColumn(name = "fk_id_estado_contrato", referencedColumnName = "pk_id_estado_contrato")
    @ManyToOne(optional = false)
    private RhEstadoContrato fkIdEstadoContrato;
    @JoinColumn(name = "fk_id_candidato", referencedColumnName = "pk_id_candidato")
    @ManyToOne
    private RhCandidato fkIdCandidato;
    @OneToOne(mappedBy = "fkIdContrato")
    private RhFuncionario rhFuncionario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdContrato")
    private List<RhSubsidioHasRhContrato> rhSubsidioHasRhContratoList;

    public RhContrato() {
    }

    public RhContrato(Integer pkIdContrato) {
        this.pkIdContrato = pkIdContrato;
    }

    public RhContrato(Integer pkIdContrato, Date dataInicio, Date dataCadastro) {
        this.pkIdContrato = pkIdContrato;
        this.dataInicio = dataInicio;
        this.dataCadastro = dataCadastro;
    }

    public Integer getPkIdContrato() {
        return pkIdContrato;
    }

    public void setPkIdContrato(Integer pkIdContrato) {
        this.pkIdContrato = pkIdContrato;
    }

    public Integer getDuracaoMeses() {
        return duracaoMeses;
    }

    public void setDuracaoMeses(Integer duracaoMeses) {
        this.duracaoMeses = duracaoMeses;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @XmlTransient
    public List<RhRenovacaoContrato> getRhRenovacaoContratoList() {
        return rhRenovacaoContratoList;
    }

    public void setRhRenovacaoContratoList(List<RhRenovacaoContrato> rhRenovacaoContratoList) {
        this.rhRenovacaoContratoList = rhRenovacaoContratoList;
    }

    public RhRenovacaoContrato getRhRenovacaoContrato() {
        return rhRenovacaoContrato;
    }

    public void setRhRenovacaoContrato(RhRenovacaoContrato rhRenovacaoContrato) {
        this.rhRenovacaoContrato = rhRenovacaoContrato;
    }

    public RhTipoContrato getFkIdTipoContrato() {
        return fkIdTipoContrato;
    }

    public void setFkIdTipoContrato(RhTipoContrato fkIdTipoContrato) {
        this.fkIdTipoContrato = fkIdTipoContrato;
    }

    public RhTabelaSalarial getFkIdTabelaSalarial() {
        return fkIdTabelaSalarial;
    }

    public void setFkIdTabelaSalarial(RhTabelaSalarial fkIdTabelaSalarial) {
        this.fkIdTabelaSalarial = fkIdTabelaSalarial;
    }

    public RhFormaPagamento getFkIdFormaPagamento() {
        return fkIdFormaPagamento;
    }

    public void setFkIdFormaPagamento(RhFormaPagamento fkIdFormaPagamento) {
        this.fkIdFormaPagamento = fkIdFormaPagamento;
    }

    public RhEstadoContrato getFkIdEstadoContrato() {
        return fkIdEstadoContrato;
    }

    public void setFkIdEstadoContrato(RhEstadoContrato fkIdEstadoContrato) {
        this.fkIdEstadoContrato = fkIdEstadoContrato;
    }

    public RhCandidato getFkIdCandidato() {
        return fkIdCandidato;
    }

    public void setFkIdCandidato(RhCandidato fkIdCandidato) {
        this.fkIdCandidato = fkIdCandidato;
    }

    public RhFuncionario getRhFuncionario() {
        return rhFuncionario;
    }

    public void setRhFuncionario(RhFuncionario rhFuncionario) {
        this.rhFuncionario = rhFuncionario;
    }

    @XmlTransient
    public List<RhSubsidioHasRhContrato> getRhSubsidioHasRhContratoList() {
        return rhSubsidioHasRhContratoList;
    }

    public void setRhSubsidioHasRhContratoList(List<RhSubsidioHasRhContrato> rhSubsidioHasRhContratoList) {
        this.rhSubsidioHasRhContratoList = rhSubsidioHasRhContratoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdContrato != null ? pkIdContrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhContrato)) {
            return false;
        }
        RhContrato other = (RhContrato) object;
        if ((this.pkIdContrato == null && other.pkIdContrato != null) || (this.pkIdContrato != null && !this.pkIdContrato.equals(other.pkIdContrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.RhContrato[ pkIdContrato=" + pkIdContrato + " ]";
    }
    
}
