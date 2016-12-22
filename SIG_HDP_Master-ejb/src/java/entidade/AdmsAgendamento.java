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
@Table(name = "adms_agendamento", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdmsAgendamento.findAll", query = "SELECT a FROM AdmsAgendamento a"),
    @NamedQuery(name = "AdmsAgendamento.findByPkIdAgendamento", query = "SELECT a FROM AdmsAgendamento a WHERE a.pkIdAgendamento = :pkIdAgendamento"),
    @NamedQuery(name = "AdmsAgendamento.findByDataAgendada", query = "SELECT a FROM AdmsAgendamento a WHERE a.dataAgendada = :dataAgendada"),
    @NamedQuery(name = "AdmsAgendamento.findByHoraAgendada", query = "SELECT a FROM AdmsAgendamento a WHERE a.horaAgendada = :horaAgendada")})
public class AdmsAgendamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_agendamento")
    private Long pkIdAgendamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_agendada")
    @Temporal(TemporalType.DATE)
    private Date dataAgendada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "hora_agendada")
    private String horaAgendada;
    @JoinColumn(name = "fk_id_servico_solicitado", referencedColumnName = "pk_id_servico_solicitado")
    @ManyToOne(optional = false)
    private AdmsServicoSolicitado fkIdServicoSolicitado;
    @JoinColumn(name = "fk_id_estado_agendamento", referencedColumnName = "pk_id_estado_agendamento")
    @ManyToOne(optional = false)
    private AdmsEstadoAgendamento fkIdEstadoAgendamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdAgendamentoAnterior")
    private List<AdmsReagendamento> admsReagendamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdAgendamento")
    private List<AdmsReagendamento> admsReagendamentoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pkIdAgendamento")
    private List<AdmsAgendamentoMedico> admsAgendamentoMedicoList;

    public AdmsAgendamento() {
    }

    public AdmsAgendamento(Long pkIdAgendamento) {
        this.pkIdAgendamento = pkIdAgendamento;
    }

    public AdmsAgendamento(Long pkIdAgendamento, Date dataAgendada, String horaAgendada) {
        this.pkIdAgendamento = pkIdAgendamento;
        this.dataAgendada = dataAgendada;
        this.horaAgendada = horaAgendada;
    }

    public Long getPkIdAgendamento() {
        return pkIdAgendamento;
    }

    public void setPkIdAgendamento(Long pkIdAgendamento) {
        this.pkIdAgendamento = pkIdAgendamento;
    }

    public Date getDataAgendada() {
        return dataAgendada;
    }

    public void setDataAgendada(Date dataAgendada) {
        this.dataAgendada = dataAgendada;
    }

    public String getHoraAgendada() {
        return horaAgendada;
    }

    public void setHoraAgendada(String horaAgendada) {
        this.horaAgendada = horaAgendada;
    }

    public AdmsServicoSolicitado getFkIdServicoSolicitado() {
        return fkIdServicoSolicitado;
    }

    public void setFkIdServicoSolicitado(AdmsServicoSolicitado fkIdServicoSolicitado) {
        this.fkIdServicoSolicitado = fkIdServicoSolicitado;
    }

    public AdmsEstadoAgendamento getFkIdEstadoAgendamento() {
        return fkIdEstadoAgendamento;
    }

    public void setFkIdEstadoAgendamento(AdmsEstadoAgendamento fkIdEstadoAgendamento) {
        this.fkIdEstadoAgendamento = fkIdEstadoAgendamento;
    }

    @XmlTransient
    public List<AdmsReagendamento> getAdmsReagendamentoList() {
        return admsReagendamentoList;
    }

    public void setAdmsReagendamentoList(List<AdmsReagendamento> admsReagendamentoList) {
        this.admsReagendamentoList = admsReagendamentoList;
    }

    @XmlTransient
    public List<AdmsReagendamento> getAdmsReagendamentoList1() {
        return admsReagendamentoList1;
    }

    public void setAdmsReagendamentoList1(List<AdmsReagendamento> admsReagendamentoList1) {
        this.admsReagendamentoList1 = admsReagendamentoList1;
    }

    @XmlTransient
    public List<AdmsAgendamentoMedico> getAdmsAgendamentoMedicoList() {
        return admsAgendamentoMedicoList;
    }

    public void setAdmsAgendamentoMedicoList(List<AdmsAgendamentoMedico> admsAgendamentoMedicoList) {
        this.admsAgendamentoMedicoList = admsAgendamentoMedicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdAgendamento != null ? pkIdAgendamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmsAgendamento)) {
            return false;
        }
        AdmsAgendamento other = (AdmsAgendamento) object;
        if ((this.pkIdAgendamento == null && other.pkIdAgendamento != null) || (this.pkIdAgendamento != null && !this.pkIdAgendamento.equals(other.pkIdAgendamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AdmsAgendamento[ pkIdAgendamento=" + pkIdAgendamento + " ]";
    }
    
}
