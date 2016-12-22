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
@Table(name = "rh_status", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhStatus.findAll", query = "SELECT r FROM RhStatus r"),
    @NamedQuery(name = "RhStatus.findByPkIdStatus", query = "SELECT r FROM RhStatus r WHERE r.pkIdStatus = :pkIdStatus"),
    @NamedQuery(name = "RhStatus.findByDescricaoEstado", query = "SELECT r FROM RhStatus r WHERE r.descricaoEstado = :descricaoEstado")})
public class RhStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_status")
    private Integer pkIdStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao_estado")
    private String descricaoEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdStatus")
    private List<RhLicencaFuncionario> rhLicencaFuncionarioList;

    public RhStatus() {
    }

    public RhStatus(Integer pkIdStatus) {
        this.pkIdStatus = pkIdStatus;
    }

    public RhStatus(Integer pkIdStatus, String descricaoEstado) {
        this.pkIdStatus = pkIdStatus;
        this.descricaoEstado = descricaoEstado;
    }

    public Integer getPkIdStatus() {
        return pkIdStatus;
    }

    public void setPkIdStatus(Integer pkIdStatus) {
        this.pkIdStatus = pkIdStatus;
    }

    public String getDescricaoEstado() {
        return descricaoEstado;
    }

    public void setDescricaoEstado(String descricaoEstado) {
        this.descricaoEstado = descricaoEstado;
    }

    @XmlTransient
    public List<RhLicencaFuncionario> getRhLicencaFuncionarioList() {
        return rhLicencaFuncionarioList;
    }

    public void setRhLicencaFuncionarioList(List<RhLicencaFuncionario> rhLicencaFuncionarioList) {
        this.rhLicencaFuncionarioList = rhLicencaFuncionarioList;
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
        if (!(object instanceof RhStatus)) {
            return false;
        }
        RhStatus other = (RhStatus) object;
        if ((this.pkIdStatus == null && other.pkIdStatus != null) || (this.pkIdStatus != null && !this.pkIdStatus.equals(other.pkIdStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.RhStatus[ pkIdStatus=" + pkIdStatus + " ]";
    }
    
}
