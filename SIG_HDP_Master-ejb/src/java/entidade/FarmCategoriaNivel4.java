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
@Table(name = "farm_categoria_nivel_4", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmCategoriaNivel4.findAll", query = "SELECT f FROM FarmCategoriaNivel4 f"),
    @NamedQuery(name = "FarmCategoriaNivel4.findByPkIdCategoriaNivel4", query = "SELECT f FROM FarmCategoriaNivel4 f WHERE f.pkIdCategoriaNivel4 = :pkIdCategoriaNivel4"),
    @NamedQuery(name = "FarmCategoriaNivel4.findByDescricao", query = "SELECT f FROM FarmCategoriaNivel4 f WHERE f.descricao = :descricao")})
public class FarmCategoriaNivel4 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_categoria_nivel_4")
    private Integer pkIdCategoriaNivel4;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdCategoria")
    private List<FarmMedicamento> farmMedicamentoList;
    @JoinColumn(name = "fk_id_pai", referencedColumnName = "pk_id_categoria_nivel_3")
    @ManyToOne(optional = false)
    private FarmCategoriaNivel3 fkIdPai;

    public FarmCategoriaNivel4() {
    }

    public FarmCategoriaNivel4(Integer pkIdCategoriaNivel4) {
        this.pkIdCategoriaNivel4 = pkIdCategoriaNivel4;
    }

    public FarmCategoriaNivel4(Integer pkIdCategoriaNivel4, String descricao) {
        this.pkIdCategoriaNivel4 = pkIdCategoriaNivel4;
        this.descricao = descricao;
    }

    public Integer getPkIdCategoriaNivel4() {
        return pkIdCategoriaNivel4;
    }

    public void setPkIdCategoriaNivel4(Integer pkIdCategoriaNivel4) {
        this.pkIdCategoriaNivel4 = pkIdCategoriaNivel4;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<FarmMedicamento> getFarmMedicamentoList() {
        return farmMedicamentoList;
    }

    public void setFarmMedicamentoList(List<FarmMedicamento> farmMedicamentoList) {
        this.farmMedicamentoList = farmMedicamentoList;
    }

    public FarmCategoriaNivel3 getFkIdPai() {
        return fkIdPai;
    }

    public void setFkIdPai(FarmCategoriaNivel3 fkIdPai) {
        this.fkIdPai = fkIdPai;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdCategoriaNivel4 != null ? pkIdCategoriaNivel4.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmCategoriaNivel4)) {
            return false;
        }
        FarmCategoriaNivel4 other = (FarmCategoriaNivel4) object;
        if ((this.pkIdCategoriaNivel4 == null && other.pkIdCategoriaNivel4 != null) || (this.pkIdCategoriaNivel4 != null && !this.pkIdCategoriaNivel4.equals(other.pkIdCategoriaNivel4))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmCategoriaNivel4[ pkIdCategoriaNivel4=" + pkIdCategoriaNivel4 + " ]";
    }
    
}
