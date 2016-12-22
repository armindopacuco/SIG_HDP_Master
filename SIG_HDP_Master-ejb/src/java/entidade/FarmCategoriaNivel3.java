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
@Table(name = "farm_categoria_nivel_3", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmCategoriaNivel3.findAll", query = "SELECT f FROM FarmCategoriaNivel3 f"),
    @NamedQuery(name = "FarmCategoriaNivel3.findByPkIdCategoriaNivel3", query = "SELECT f FROM FarmCategoriaNivel3 f WHERE f.pkIdCategoriaNivel3 = :pkIdCategoriaNivel3"),
    @NamedQuery(name = "FarmCategoriaNivel3.findByDescricao", query = "SELECT f FROM FarmCategoriaNivel3 f WHERE f.descricao = :descricao")})
public class FarmCategoriaNivel3 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_categoria_nivel_3")
    private Integer pkIdCategoriaNivel3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdPai")
    private List<FarmCategoriaNivel4> farmCategoriaNivel4List;
    @JoinColumn(name = "fk_id_pai", referencedColumnName = "pk_id_categoria_nivel_2")
    @ManyToOne(optional = false)
    private FarmCategoriaNivel2 fkIdPai;

    public FarmCategoriaNivel3() {
    }

    public FarmCategoriaNivel3(Integer pkIdCategoriaNivel3) {
        this.pkIdCategoriaNivel3 = pkIdCategoriaNivel3;
    }

    public FarmCategoriaNivel3(Integer pkIdCategoriaNivel3, String descricao) {
        this.pkIdCategoriaNivel3 = pkIdCategoriaNivel3;
        this.descricao = descricao;
    }

    public Integer getPkIdCategoriaNivel3() {
        return pkIdCategoriaNivel3;
    }

    public void setPkIdCategoriaNivel3(Integer pkIdCategoriaNivel3) {
        this.pkIdCategoriaNivel3 = pkIdCategoriaNivel3;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<FarmCategoriaNivel4> getFarmCategoriaNivel4List() {
        return farmCategoriaNivel4List;
    }

    public void setFarmCategoriaNivel4List(List<FarmCategoriaNivel4> farmCategoriaNivel4List) {
        this.farmCategoriaNivel4List = farmCategoriaNivel4List;
    }

    public FarmCategoriaNivel2 getFkIdPai() {
        return fkIdPai;
    }

    public void setFkIdPai(FarmCategoriaNivel2 fkIdPai) {
        this.fkIdPai = fkIdPai;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdCategoriaNivel3 != null ? pkIdCategoriaNivel3.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmCategoriaNivel3)) {
            return false;
        }
        FarmCategoriaNivel3 other = (FarmCategoriaNivel3) object;
        if ((this.pkIdCategoriaNivel3 == null && other.pkIdCategoriaNivel3 != null) || (this.pkIdCategoriaNivel3 != null && !this.pkIdCategoriaNivel3.equals(other.pkIdCategoriaNivel3))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmCategoriaNivel3[ pkIdCategoriaNivel3=" + pkIdCategoriaNivel3 + " ]";
    }
    
}
