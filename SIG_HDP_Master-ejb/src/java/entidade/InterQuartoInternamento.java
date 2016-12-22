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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "inter_quarto_internamento", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterQuartoInternamento.findAll", query = "SELECT i FROM InterQuartoInternamento i"),
    @NamedQuery(name = "InterQuartoInternamento.findByPkIdQuartoInternamento", query = "SELECT i FROM InterQuartoInternamento i WHERE i.pkIdQuartoInternamento = :pkIdQuartoInternamento"),
    @NamedQuery(name = "InterQuartoInternamento.findByDescricaoQuartoInternamento", query = "SELECT i FROM InterQuartoInternamento i WHERE i.descricaoQuartoInternamento = :descricaoQuartoInternamento"),
    @NamedQuery(name = "InterQuartoInternamento.findByCodigoQuartoInternamento", query = "SELECT i FROM InterQuartoInternamento i WHERE i.codigoQuartoInternamento = :codigoQuartoInternamento")})
public class InterQuartoInternamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_quarto_internamento")
    private Integer pkIdQuartoInternamento;
    @Size(max = 100)
    @Column(name = "descricao_quarto_internamento")
    private String descricaoQuartoInternamento;
    @Size(max = 45)
    @Column(name = "codigo_quarto_internamento")
    private String codigoQuartoInternamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdQuartoInternamento")
    private List<InterRegistoInternamento> interRegistoInternamentoList;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne(optional = false)
    private RhFuncionario fkIdFuncionario;
    @JoinColumn(name = "fk_id_status", referencedColumnName = "pk_id_status")
    @ManyToOne(optional = false)
    private InterStatus fkIdStatus;
    @JoinColumn(name = "fk_id_enfermaria", referencedColumnName = "pk_id_enfermaria")
    @ManyToOne(optional = false)
    private InterEnfermaria fkIdEnfermaria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdQuartoCamaInternamento")
    private List<InterCamaInternamento> interCamaInternamentoList;

    public InterQuartoInternamento() {
    }

    public InterQuartoInternamento(Integer pkIdQuartoInternamento) {
        this.pkIdQuartoInternamento = pkIdQuartoInternamento;
    }

    public Integer getPkIdQuartoInternamento() {
        return pkIdQuartoInternamento;
    }

    public void setPkIdQuartoInternamento(Integer pkIdQuartoInternamento) {
        this.pkIdQuartoInternamento = pkIdQuartoInternamento;
    }

    public String getDescricaoQuartoInternamento() {
        return descricaoQuartoInternamento;
    }

    public void setDescricaoQuartoInternamento(String descricaoQuartoInternamento) {
        this.descricaoQuartoInternamento = descricaoQuartoInternamento;
    }

    public String getCodigoQuartoInternamento() {
        return codigoQuartoInternamento;
    }

    public void setCodigoQuartoInternamento(String codigoQuartoInternamento) {
        this.codigoQuartoInternamento = codigoQuartoInternamento;
    }

    @XmlTransient
    public List<InterRegistoInternamento> getInterRegistoInternamentoList() {
        return interRegistoInternamentoList;
    }

    public void setInterRegistoInternamentoList(List<InterRegistoInternamento> interRegistoInternamentoList) {
        this.interRegistoInternamentoList = interRegistoInternamentoList;
    }

    public RhFuncionario getFkIdFuncionario() {
        return fkIdFuncionario;
    }

    public void setFkIdFuncionario(RhFuncionario fkIdFuncionario) {
        this.fkIdFuncionario = fkIdFuncionario;
    }

    public InterStatus getFkIdStatus() {
        return fkIdStatus;
    }

    public void setFkIdStatus(InterStatus fkIdStatus) {
        this.fkIdStatus = fkIdStatus;
    }

    public InterEnfermaria getFkIdEnfermaria() {
        return fkIdEnfermaria;
    }

    public void setFkIdEnfermaria(InterEnfermaria fkIdEnfermaria) {
        this.fkIdEnfermaria = fkIdEnfermaria;
    }

    @XmlTransient
    public List<InterCamaInternamento> getInterCamaInternamentoList() {
        return interCamaInternamentoList;
    }

    public void setInterCamaInternamentoList(List<InterCamaInternamento> interCamaInternamentoList) {
        this.interCamaInternamentoList = interCamaInternamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdQuartoInternamento != null ? pkIdQuartoInternamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterQuartoInternamento)) {
            return false;
        }
        InterQuartoInternamento other = (InterQuartoInternamento) object;
        if ((this.pkIdQuartoInternamento == null && other.pkIdQuartoInternamento != null) || (this.pkIdQuartoInternamento != null && !this.pkIdQuartoInternamento.equals(other.pkIdQuartoInternamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.InterQuartoInternamento[ pkIdQuartoInternamento=" + pkIdQuartoInternamento + " ]";
    }
    
}
