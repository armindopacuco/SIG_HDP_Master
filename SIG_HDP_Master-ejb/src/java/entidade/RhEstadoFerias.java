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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "rh_estado_ferias", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhEstadoFerias.findAll", query = "SELECT r FROM RhEstadoFerias r"),
    @NamedQuery(name = "RhEstadoFerias.findByPkIdEstadoFerias", query = "SELECT r FROM RhEstadoFerias r WHERE r.pkIdEstadoFerias = :pkIdEstadoFerias"),
    @NamedQuery(name = "RhEstadoFerias.findByDescricao", query = "SELECT r FROM RhEstadoFerias r WHERE r.descricao = :descricao")})
public class RhEstadoFerias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_estado_ferias")
    private Integer pkIdEstadoFerias;
    @Size(max = 50)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdEstadoFerias")
    private List<RhFerias> rhFeriasList;

    public RhEstadoFerias() {
    }

    public RhEstadoFerias(Integer pkIdEstadoFerias) {
        this.pkIdEstadoFerias = pkIdEstadoFerias;
    }

    public Integer getPkIdEstadoFerias() {
        return pkIdEstadoFerias;
    }

    public void setPkIdEstadoFerias(Integer pkIdEstadoFerias) {
        this.pkIdEstadoFerias = pkIdEstadoFerias;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<RhFerias> getRhFeriasList() {
        return rhFeriasList;
    }

    public void setRhFeriasList(List<RhFerias> rhFeriasList) {
        this.rhFeriasList = rhFeriasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdEstadoFerias != null ? pkIdEstadoFerias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhEstadoFerias)) {
            return false;
        }
        RhEstadoFerias other = (RhEstadoFerias) object;
        if ((this.pkIdEstadoFerias == null && other.pkIdEstadoFerias != null) || (this.pkIdEstadoFerias != null && !this.pkIdEstadoFerias.equals(other.pkIdEstadoFerias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.RhEstadoFerias[ pkIdEstadoFerias=" + pkIdEstadoFerias + " ]";
    }
    
}
