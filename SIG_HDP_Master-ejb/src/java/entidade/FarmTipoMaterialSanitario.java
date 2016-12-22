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
@Table(name = "farm_tipo_material_sanitario", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmTipoMaterialSanitario.findAll", query = "SELECT f FROM FarmTipoMaterialSanitario f"),
    @NamedQuery(name = "FarmTipoMaterialSanitario.findByPkIdTipoMaterial", query = "SELECT f FROM FarmTipoMaterialSanitario f WHERE f.pkIdTipoMaterial = :pkIdTipoMaterial"),
    @NamedQuery(name = "FarmTipoMaterialSanitario.findByCodigoTpoMaterial", query = "SELECT f FROM FarmTipoMaterialSanitario f WHERE f.codigoTpoMaterial = :codigoTpoMaterial"),
    @NamedQuery(name = "FarmTipoMaterialSanitario.findByDescricaoTipoMaterial", query = "SELECT f FROM FarmTipoMaterialSanitario f WHERE f.descricaoTipoMaterial = :descricaoTipoMaterial")})
public class FarmTipoMaterialSanitario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_tipo_material")
    private Integer pkIdTipoMaterial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigo_tpo_material")
    private String codigoTpoMaterial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descricao_tipo_material")
    private String descricaoTipoMaterial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdTipoMaterial")
    private List<FarmMaterialSanitario> farmMaterialSanitarioList;

    public FarmTipoMaterialSanitario() {
    }

    public FarmTipoMaterialSanitario(Integer pkIdTipoMaterial) {
        this.pkIdTipoMaterial = pkIdTipoMaterial;
    }

    public FarmTipoMaterialSanitario(Integer pkIdTipoMaterial, String codigoTpoMaterial, String descricaoTipoMaterial) {
        this.pkIdTipoMaterial = pkIdTipoMaterial;
        this.codigoTpoMaterial = codigoTpoMaterial;
        this.descricaoTipoMaterial = descricaoTipoMaterial;
    }

    public Integer getPkIdTipoMaterial() {
        return pkIdTipoMaterial;
    }

    public void setPkIdTipoMaterial(Integer pkIdTipoMaterial) {
        this.pkIdTipoMaterial = pkIdTipoMaterial;
    }

    public String getCodigoTpoMaterial() {
        return codigoTpoMaterial;
    }

    public void setCodigoTpoMaterial(String codigoTpoMaterial) {
        this.codigoTpoMaterial = codigoTpoMaterial;
    }

    public String getDescricaoTipoMaterial() {
        return descricaoTipoMaterial;
    }

    public void setDescricaoTipoMaterial(String descricaoTipoMaterial) {
        this.descricaoTipoMaterial = descricaoTipoMaterial;
    }

    @XmlTransient
    public List<FarmMaterialSanitario> getFarmMaterialSanitarioList() {
        return farmMaterialSanitarioList;
    }

    public void setFarmMaterialSanitarioList(List<FarmMaterialSanitario> farmMaterialSanitarioList) {
        this.farmMaterialSanitarioList = farmMaterialSanitarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdTipoMaterial != null ? pkIdTipoMaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmTipoMaterialSanitario)) {
            return false;
        }
        FarmTipoMaterialSanitario other = (FarmTipoMaterialSanitario) object;
        if ((this.pkIdTipoMaterial == null && other.pkIdTipoMaterial != null) || (this.pkIdTipoMaterial != null && !this.pkIdTipoMaterial.equals(other.pkIdTipoMaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmTipoMaterialSanitario[ pkIdTipoMaterial=" + pkIdTipoMaterial + " ]";
    }
    
}
