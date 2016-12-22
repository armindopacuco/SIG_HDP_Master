/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "adms_servico", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdmsServico.findAll", query = "SELECT a FROM AdmsServico a"),
    @NamedQuery(name = "AdmsServico.findByPkIdServico", query = "SELECT a FROM AdmsServico a WHERE a.pkIdServico = :pkIdServico"),
    @NamedQuery(name = "AdmsServico.findByNomeServico", query = "SELECT a FROM AdmsServico a WHERE a.nomeServico = :nomeServico"),
    @NamedQuery(name = "AdmsServico.findByPodeSerAgendado", query = "SELECT a FROM AdmsServico a WHERE a.podeSerAgendado = :podeSerAgendado")})
public class AdmsServico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_servico")
    private Integer pkIdServico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome_servico")
    private String nomeServico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pode_ser_agendado")
    private boolean podeSerAgendado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdServico")
    private List<AdmsServicoSolicitado> admsServicoSolicitadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdServico")
    private List<FinPreco> finPrecoList;
    @JoinColumn(name = "fk_id_especialidade", referencedColumnName = "pk_id_especialidade")
    @ManyToOne
    private GrlEspecialidade fkIdEspecialidade;
    @JoinColumn(name = "fk_id_area", referencedColumnName = "pk_id_area_interna")
    @ManyToOne(optional = false)
    private GrlAreaInterna fkIdArea;
    @JoinColumn(name = "fk_id_tipo_servico", referencedColumnName = "pk_id_tipo_servico")
    @ManyToOne(optional = false)
    private AdmsTipoServico fkIdTipoServico;

    public AdmsServico() {
    }

    public AdmsServico(Integer pkIdServico) {
        this.pkIdServico = pkIdServico;
    }

    public AdmsServico(Integer pkIdServico, String nomeServico, boolean podeSerAgendado) {
        this.pkIdServico = pkIdServico;
        this.nomeServico = nomeServico;
        this.podeSerAgendado = podeSerAgendado;
    }

    public Integer getPkIdServico() {
        return pkIdServico;
    }

    public void setPkIdServico(Integer pkIdServico) {
        this.pkIdServico = pkIdServico;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public boolean getPodeSerAgendado() {
        return podeSerAgendado;
    }

    public void setPodeSerAgendado(boolean podeSerAgendado) {
        this.podeSerAgendado = podeSerAgendado;
    }

    @XmlTransient
    public List<AdmsServicoSolicitado> getAdmsServicoSolicitadoList() {
        return admsServicoSolicitadoList;
    }

    public void setAdmsServicoSolicitadoList(List<AdmsServicoSolicitado> admsServicoSolicitadoList) {
        this.admsServicoSolicitadoList = admsServicoSolicitadoList;
    }

    @XmlTransient
    public List<FinPreco> getFinPrecoList() {
        return finPrecoList;
    }

    public void setFinPrecoList(List<FinPreco> finPrecoList) {
        this.finPrecoList = finPrecoList;
    }

    public GrlEspecialidade getFkIdEspecialidade() {
        return fkIdEspecialidade;
    }

    public void setFkIdEspecialidade(GrlEspecialidade fkIdEspecialidade) {
        this.fkIdEspecialidade = fkIdEspecialidade;
    }

    public GrlAreaInterna getFkIdArea() {
        return fkIdArea;
    }

    public void setFkIdArea(GrlAreaInterna fkIdArea) {
        this.fkIdArea = fkIdArea;
    }

    public AdmsTipoServico getFkIdTipoServico() {
        return fkIdTipoServico;
    }

    public void setFkIdTipoServico(AdmsTipoServico fkIdTipoServico) {
        this.fkIdTipoServico = fkIdTipoServico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdServico != null ? pkIdServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmsServico)) {
            return false;
        }
        AdmsServico other = (AdmsServico) object;
        if ((this.pkIdServico == null && other.pkIdServico != null) || (this.pkIdServico != null && !this.pkIdServico.equals(other.pkIdServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AdmsServico[ pkIdServico=" + pkIdServico + " ]";
    }
    
}
