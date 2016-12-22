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
@Table(name = "farm_categoria_nivel_1", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmCategoriaNivel1.findAll", query = "SELECT f FROM FarmCategoriaNivel1 f"),
    @NamedQuery(name = "FarmCategoriaNivel1.findByPkIdCategoriaNivel1", query = "SELECT f FROM FarmCategoriaNivel1 f WHERE f.pkIdCategoriaNivel1 = :pkIdCategoriaNivel1"),
    @NamedQuery(name = "FarmCategoriaNivel1.findByDescricao", query = "SELECT f FROM FarmCategoriaNivel1 f WHERE f.descricao = :descricao")})
public class FarmCategoriaNivel1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_categoria_nivel_1")
    private Integer pkIdCategoriaNivel1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdPai")
    private List<FarmCategoriaNivel2> farmCategoriaNivel2List;

    public FarmCategoriaNivel1() {
    }

    public FarmCategoriaNivel1(Integer pkIdCategoriaNivel1) {
        this.pkIdCategoriaNivel1 = pkIdCategoriaNivel1;
    }

    public FarmCategoriaNivel1(Integer pkIdCategoriaNivel1, String descricao) {
        this.pkIdCategoriaNivel1 = pkIdCategoriaNivel1;
        this.descricao = descricao;
    }

    public Integer getPkIdCategoriaNivel1() {
        return pkIdCategoriaNivel1;
    }

    public void setPkIdCategoriaNivel1(Integer pkIdCategoriaNivel1) {
        this.pkIdCategoriaNivel1 = pkIdCategoriaNivel1;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<FarmCategoriaNivel2> getFarmCategoriaNivel2List() {
        return farmCategoriaNivel2List;
    }

    public void setFarmCategoriaNivel2List(List<FarmCategoriaNivel2> farmCategoriaNivel2List) {
        this.farmCategoriaNivel2List = farmCategoriaNivel2List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdCategoriaNivel1 != null ? pkIdCategoriaNivel1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmCategoriaNivel1)) {
            return false;
        }
        FarmCategoriaNivel1 other = (FarmCategoriaNivel1) object;
        if ((this.pkIdCategoriaNivel1 == null && other.pkIdCategoriaNivel1 != null) || (this.pkIdCategoriaNivel1 != null && !this.pkIdCategoriaNivel1.equals(other.pkIdCategoriaNivel1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmCategoriaNivel1[ pkIdCategoriaNivel1=" + pkIdCategoriaNivel1 + " ]";
    }
    
}
