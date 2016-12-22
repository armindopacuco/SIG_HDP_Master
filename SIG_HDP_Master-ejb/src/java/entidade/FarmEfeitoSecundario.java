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
@Table(name = "farm_efeito_secundario", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmEfeitoSecundario.findAll", query = "SELECT f FROM FarmEfeitoSecundario f"),
    @NamedQuery(name = "FarmEfeitoSecundario.findByPkIdEfeitoSecundario", query = "SELECT f FROM FarmEfeitoSecundario f WHERE f.pkIdEfeitoSecundario = :pkIdEfeitoSecundario"),
    @NamedQuery(name = "FarmEfeitoSecundario.findByDescricaoEfeitoSecundario", query = "SELECT f FROM FarmEfeitoSecundario f WHERE f.descricaoEfeitoSecundario = :descricaoEfeitoSecundario")})
public class FarmEfeitoSecundario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_efeito_secundario")
    private Integer pkIdEfeitoSecundario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descricao_efeito_secundario")
    private String descricaoEfeitoSecundario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdEfeitoSecundario")
    private List<FarmMaterialSanitarioHasEfeitoSecundario> farmMaterialSanitarioHasEfeitoSecundarioList;

    public FarmEfeitoSecundario() {
    }

    public FarmEfeitoSecundario(Integer pkIdEfeitoSecundario) {
        this.pkIdEfeitoSecundario = pkIdEfeitoSecundario;
    }

    public FarmEfeitoSecundario(Integer pkIdEfeitoSecundario, String descricaoEfeitoSecundario) {
        this.pkIdEfeitoSecundario = pkIdEfeitoSecundario;
        this.descricaoEfeitoSecundario = descricaoEfeitoSecundario;
    }

    public Integer getPkIdEfeitoSecundario() {
        return pkIdEfeitoSecundario;
    }

    public void setPkIdEfeitoSecundario(Integer pkIdEfeitoSecundario) {
        this.pkIdEfeitoSecundario = pkIdEfeitoSecundario;
    }

    public String getDescricaoEfeitoSecundario() {
        return descricaoEfeitoSecundario;
    }

    public void setDescricaoEfeitoSecundario(String descricaoEfeitoSecundario) {
        this.descricaoEfeitoSecundario = descricaoEfeitoSecundario;
    }

    @XmlTransient
    public List<FarmMaterialSanitarioHasEfeitoSecundario> getFarmMaterialSanitarioHasEfeitoSecundarioList() {
        return farmMaterialSanitarioHasEfeitoSecundarioList;
    }

    public void setFarmMaterialSanitarioHasEfeitoSecundarioList(List<FarmMaterialSanitarioHasEfeitoSecundario> farmMaterialSanitarioHasEfeitoSecundarioList) {
        this.farmMaterialSanitarioHasEfeitoSecundarioList = farmMaterialSanitarioHasEfeitoSecundarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdEfeitoSecundario != null ? pkIdEfeitoSecundario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmEfeitoSecundario)) {
            return false;
        }
        FarmEfeitoSecundario other = (FarmEfeitoSecundario) object;
        if ((this.pkIdEfeitoSecundario == null && other.pkIdEfeitoSecundario != null) || (this.pkIdEfeitoSecundario != null && !this.pkIdEfeitoSecundario.equals(other.pkIdEfeitoSecundario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmEfeitoSecundario[ pkIdEfeitoSecundario=" + pkIdEfeitoSecundario + " ]";
    }
    
}
