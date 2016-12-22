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
@Table(name = "rh_tipo_licenca", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhTipoLicenca.findAll", query = "SELECT r FROM RhTipoLicenca r"),
    @NamedQuery(name = "RhTipoLicenca.findByPkIdTipoLicenca", query = "SELECT r FROM RhTipoLicenca r WHERE r.pkIdTipoLicenca = :pkIdTipoLicenca"),
    @NamedQuery(name = "RhTipoLicenca.findByDescricao", query = "SELECT r FROM RhTipoLicenca r WHERE r.descricao = :descricao")})
public class RhTipoLicenca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_tipo_licenca")
    private Integer pkIdTipoLicenca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdTipoLicenca")
    private List<RhLicencaFuncionario> rhLicencaFuncionarioList;

    public RhTipoLicenca() {
    }

    public RhTipoLicenca(Integer pkIdTipoLicenca) {
        this.pkIdTipoLicenca = pkIdTipoLicenca;
    }

    public RhTipoLicenca(Integer pkIdTipoLicenca, String descricao) {
        this.pkIdTipoLicenca = pkIdTipoLicenca;
        this.descricao = descricao;
    }

    public Integer getPkIdTipoLicenca() {
        return pkIdTipoLicenca;
    }

    public void setPkIdTipoLicenca(Integer pkIdTipoLicenca) {
        this.pkIdTipoLicenca = pkIdTipoLicenca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        hash += (pkIdTipoLicenca != null ? pkIdTipoLicenca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhTipoLicenca)) {
            return false;
        }
        RhTipoLicenca other = (RhTipoLicenca) object;
        if ((this.pkIdTipoLicenca == null && other.pkIdTipoLicenca != null) || (this.pkIdTipoLicenca != null && !this.pkIdTipoLicenca.equals(other.pkIdTipoLicenca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.RhTipoLicenca[ pkIdTipoLicenca=" + pkIdTipoLicenca + " ]";
    }
    
}
