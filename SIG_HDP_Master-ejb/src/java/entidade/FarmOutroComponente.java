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
@Table(name = "farm_outro_componente", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmOutroComponente.findAll", query = "SELECT f FROM FarmOutroComponente f"),
    @NamedQuery(name = "FarmOutroComponente.findByPkIdComponente", query = "SELECT f FROM FarmOutroComponente f WHERE f.pkIdComponente = :pkIdComponente"),
    @NamedQuery(name = "FarmOutroComponente.findByDescricaoComponente", query = "SELECT f FROM FarmOutroComponente f WHERE f.descricaoComponente = :descricaoComponente")})
public class FarmOutroComponente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_componente")
    private Integer pkIdComponente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descricao_componente")
    private String descricaoComponente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdComponente")
    private List<FarmMaterialSanitarioHasOutroComponente> farmMaterialSanitarioHasOutroComponenteList;

    public FarmOutroComponente() {
    }

    public FarmOutroComponente(Integer pkIdComponente) {
        this.pkIdComponente = pkIdComponente;
    }

    public FarmOutroComponente(Integer pkIdComponente, String descricaoComponente) {
        this.pkIdComponente = pkIdComponente;
        this.descricaoComponente = descricaoComponente;
    }

    public Integer getPkIdComponente() {
        return pkIdComponente;
    }

    public void setPkIdComponente(Integer pkIdComponente) {
        this.pkIdComponente = pkIdComponente;
    }

    public String getDescricaoComponente() {
        return descricaoComponente;
    }

    public void setDescricaoComponente(String descricaoComponente) {
        this.descricaoComponente = descricaoComponente;
    }

    @XmlTransient
    public List<FarmMaterialSanitarioHasOutroComponente> getFarmMaterialSanitarioHasOutroComponenteList() {
        return farmMaterialSanitarioHasOutroComponenteList;
    }

    public void setFarmMaterialSanitarioHasOutroComponenteList(List<FarmMaterialSanitarioHasOutroComponente> farmMaterialSanitarioHasOutroComponenteList) {
        this.farmMaterialSanitarioHasOutroComponenteList = farmMaterialSanitarioHasOutroComponenteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdComponente != null ? pkIdComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmOutroComponente)) {
            return false;
        }
        FarmOutroComponente other = (FarmOutroComponente) object;
        if ((this.pkIdComponente == null && other.pkIdComponente != null) || (this.pkIdComponente != null && !this.pkIdComponente.equals(other.pkIdComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmOutroComponente[ pkIdComponente=" + pkIdComponente + " ]";
    }
    
}
