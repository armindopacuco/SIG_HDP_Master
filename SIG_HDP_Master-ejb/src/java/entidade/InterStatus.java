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
@Table(name = "inter_status", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterStatus.findAll", query = "SELECT i FROM InterStatus i"),
    @NamedQuery(name = "InterStatus.findByPkIdStatus", query = "SELECT i FROM InterStatus i WHERE i.pkIdStatus = :pkIdStatus"),
    @NamedQuery(name = "InterStatus.findByDescricaoStatus", query = "SELECT i FROM InterStatus i WHERE i.descricaoStatus = :descricaoStatus")})
public class InterStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_status")
    private Integer pkIdStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao_status")
    private String descricaoStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdStatus")
    private List<InterEnfermaria> interEnfermariaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdStatus")
    private List<InterQuartoInternamento> interQuartoInternamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdStatus")
    private List<InterCamaInternamento> interCamaInternamentoList;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne
    private RhFuncionario fkIdFuncionario;

    public InterStatus() {
    }

    public InterStatus(Integer pkIdStatus) {
        this.pkIdStatus = pkIdStatus;
    }

    public InterStatus(Integer pkIdStatus, String descricaoStatus) {
        this.pkIdStatus = pkIdStatus;
        this.descricaoStatus = descricaoStatus;
    }

    public Integer getPkIdStatus() {
        return pkIdStatus;
    }

    public void setPkIdStatus(Integer pkIdStatus) {
        this.pkIdStatus = pkIdStatus;
    }

    public String getDescricaoStatus() {
        return descricaoStatus;
    }

    public void setDescricaoStatus(String descricaoStatus) {
        this.descricaoStatus = descricaoStatus;
    }

    @XmlTransient
    public List<InterEnfermaria> getInterEnfermariaList() {
        return interEnfermariaList;
    }

    public void setInterEnfermariaList(List<InterEnfermaria> interEnfermariaList) {
        this.interEnfermariaList = interEnfermariaList;
    }

    @XmlTransient
    public List<InterQuartoInternamento> getInterQuartoInternamentoList() {
        return interQuartoInternamentoList;
    }

    public void setInterQuartoInternamentoList(List<InterQuartoInternamento> interQuartoInternamentoList) {
        this.interQuartoInternamentoList = interQuartoInternamentoList;
    }

    @XmlTransient
    public List<InterCamaInternamento> getInterCamaInternamentoList() {
        return interCamaInternamentoList;
    }

    public void setInterCamaInternamentoList(List<InterCamaInternamento> interCamaInternamentoList) {
        this.interCamaInternamentoList = interCamaInternamentoList;
    }

    public RhFuncionario getFkIdFuncionario() {
        return fkIdFuncionario;
    }

    public void setFkIdFuncionario(RhFuncionario fkIdFuncionario) {
        this.fkIdFuncionario = fkIdFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdStatus != null ? pkIdStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterStatus)) {
            return false;
        }
        InterStatus other = (InterStatus) object;
        if ((this.pkIdStatus == null && other.pkIdStatus != null) || (this.pkIdStatus != null && !this.pkIdStatus.equals(other.pkIdStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.InterStatus[ pkIdStatus=" + pkIdStatus + " ]";
    }
    
}
