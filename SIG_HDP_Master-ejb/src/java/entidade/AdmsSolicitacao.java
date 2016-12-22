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
@Table(name = "adms_solicitacao", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdmsSolicitacao.findAll", query = "SELECT a FROM AdmsSolicitacao a"),
    @NamedQuery(name = "AdmsSolicitacao.findByPkIdSolicitacao", query = "SELECT a FROM AdmsSolicitacao a WHERE a.pkIdSolicitacao = :pkIdSolicitacao"),
    @NamedQuery(name = "AdmsSolicitacao.findByCodigoNaAreaSolicitante", query = "SELECT a FROM AdmsSolicitacao a WHERE a.codigoNaAreaSolicitante = :codigoNaAreaSolicitante"),
    @NamedQuery(name = "AdmsSolicitacao.findByData", query = "SELECT a FROM AdmsSolicitacao a WHERE a.data = :data"),
    @NamedQuery(name = "AdmsSolicitacao.findByObservacao", query = "SELECT a FROM AdmsSolicitacao a WHERE a.observacao = :observacao"),
    @NamedQuery(name = "AdmsSolicitacao.findByResponsavel", query = "SELECT a FROM AdmsSolicitacao a WHERE a.responsavel = :responsavel")})
public class AdmsSolicitacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_solicitacao")
    private Long pkIdSolicitacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "codigo_na_area_solicitante")
    private String codigoNaAreaSolicitante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Size(max = 500)
    @Column(name = "observacao")
    private String observacao;
    @Size(max = 100)
    @Column(name = "responsavel")
    private String responsavel;
    @JoinColumn(name = "fk_id_funcionario_solicitante", referencedColumnName = "pk_id_funcionario")
    @ManyToOne(optional = false)
    private RhFuncionario fkIdFuncionarioSolicitante;
    @JoinColumn(name = "fk_id_centro", referencedColumnName = "pk_id_centro")
    @ManyToOne
    private GrlCentroHospitalar fkIdCentro;
    @JoinColumn(name = "fk_id_area_solicitou", referencedColumnName = "pk_id_area_interna")
    @ManyToOne(optional = false)
    private GrlAreaInterna fkIdAreaSolicitou;
    @JoinColumn(name = "fk_id_paciente", referencedColumnName = "pk_id_paciente")
    @ManyToOne(optional = false)
    private AdmsPaciente fkIdPaciente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdSolicitacao")
    private List<AdmsServicoSolicitado> admsServicoSolicitadoList;

    public AdmsSolicitacao() {
    }

    public AdmsSolicitacao(Long pkIdSolicitacao) {
        this.pkIdSolicitacao = pkIdSolicitacao;
    }

    public AdmsSolicitacao(Long pkIdSolicitacao, String codigoNaAreaSolicitante, Date data) {
        this.pkIdSolicitacao = pkIdSolicitacao;
        this.codigoNaAreaSolicitante = codigoNaAreaSolicitante;
        this.data = data;
    }

    public Long getPkIdSolicitacao() {
        return pkIdSolicitacao;
    }

    public void setPkIdSolicitacao(Long pkIdSolicitacao) {
        this.pkIdSolicitacao = pkIdSolicitacao;
    }

    public String getCodigoNaAreaSolicitante() {
        return codigoNaAreaSolicitante;
    }

    public void setCodigoNaAreaSolicitante(String codigoNaAreaSolicitante) {
        this.codigoNaAreaSolicitante = codigoNaAreaSolicitante;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public RhFuncionario getFkIdFuncionarioSolicitante() {
        return fkIdFuncionarioSolicitante;
    }

    public void setFkIdFuncionarioSolicitante(RhFuncionario fkIdFuncionarioSolicitante) {
        this.fkIdFuncionarioSolicitante = fkIdFuncionarioSolicitante;
    }

    public GrlCentroHospitalar getFkIdCentro() {
        return fkIdCentro;
    }

    public void setFkIdCentro(GrlCentroHospitalar fkIdCentro) {
        this.fkIdCentro = fkIdCentro;
    }

    public GrlAreaInterna getFkIdAreaSolicitou() {
        return fkIdAreaSolicitou;
    }

    public void setFkIdAreaSolicitou(GrlAreaInterna fkIdAreaSolicitou) {
        this.fkIdAreaSolicitou = fkIdAreaSolicitou;
    }

    public AdmsPaciente getFkIdPaciente() {
        return fkIdPaciente;
    }

    public void setFkIdPaciente(AdmsPaciente fkIdPaciente) {
        this.fkIdPaciente = fkIdPaciente;
    }

    @XmlTransient
    public List<AdmsServicoSolicitado> getAdmsServicoSolicitadoList() {
        return admsServicoSolicitadoList;
    }

    public void setAdmsServicoSolicitadoList(List<AdmsServicoSolicitado> admsServicoSolicitadoList) {
        this.admsServicoSolicitadoList = admsServicoSolicitadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdSolicitacao != null ? pkIdSolicitacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmsSolicitacao)) {
            return false;
        }
        AdmsSolicitacao other = (AdmsSolicitacao) object;
        if ((this.pkIdSolicitacao == null && other.pkIdSolicitacao != null) || (this.pkIdSolicitacao != null && !this.pkIdSolicitacao.equals(other.pkIdSolicitacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AdmsSolicitacao[ pkIdSolicitacao=" + pkIdSolicitacao + " ]";
    }
    
}
