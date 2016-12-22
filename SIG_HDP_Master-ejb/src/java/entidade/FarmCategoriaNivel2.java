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
@Table(name = "farm_categoria_nivel_2", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmCategoriaNivel2.findAll", query = "SELECT f FROM FarmCategoriaNivel2 f"),
    @NamedQuery(name = "FarmCategoriaNivel2.findByPkIdCategoriaNivel2", query = "SELECT f FROM FarmCategoriaNivel2 f WHERE f.pkIdCategoriaNivel2 = :pkIdCategoriaNivel2"),
    @NamedQuery(name = "FarmCategoriaNivel2.findByDescricao", query = "SELECT f FROM FarmCategoriaNivel2 f WHERE f.descricao = :descricao")})
public class FarmCategoriaNivel2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_categoria_nivel_2")
    private Integer pkIdCategoriaNivel2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "fk_id_pai", referencedColumnName = "pk_id_categoria_nivel_1")
    @ManyToOne(optional = false)
    private FarmCategoriaNivel1 fkIdPai;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdPai")
    private List<FarmCategoriaNivel3> farmCategoriaNivel3List;

    public FarmCategoriaNivel2() {
    }

    public FarmCategoriaNivel2(Integer pkIdCategoriaNivel2) {
        this.pkIdCategoriaNivel2 = pkIdCategoriaNivel2;
    }

    public FarmCategoriaNivel2(Integer pkIdCategoriaNivel2, String descricao) {
        this.pkIdCategoriaNivel2 = pkIdCategoriaNivel2;
        this.descricao = descricao;
    }

    public Integer getPkIdCategoriaNivel2() {
        return pkIdCategoriaNivel2;
    }

    public void setPkIdCategoriaNivel2(Integer pkIdCategoriaNivel2) {
        this.pkIdCategoriaNivel2 = pkIdCategoriaNivel2;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public FarmCategoriaNivel1 getFkIdPai() {
        return fkIdPai;
    }

    public void setFkIdPai(FarmCategoriaNivel1 fkIdPai) {
        this.fkIdPai = fkIdPai;
    }

    @XmlTransient
    public List<FarmCategoriaNivel3> getFarmCategoriaNivel3List() {
        return farmCategoriaNivel3List;
    }

    public void setFarmCategoriaNivel3List(List<FarmCategoriaNivel3> farmCategoriaNivel3List) {
        this.farmCategoriaNivel3List = farmCategoriaNivel3List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdCategoriaNivel2 != null ? pkIdCategoriaNivel2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmCategoriaNivel2)) {
            return false;
        }
        FarmCategoriaNivel2 other = (FarmCategoriaNivel2) object;
        if ((this.pkIdCategoriaNivel2 == null && other.pkIdCategoriaNivel2 != null) || (this.pkIdCategoriaNivel2 != null && !this.pkIdCategoriaNivel2.equals(other.pkIdCategoriaNivel2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmCategoriaNivel2[ pkIdCategoriaNivel2=" + pkIdCategoriaNivel2 + " ]";
    }
    
}
