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
@Table(name = "farm_marca_material_sanitario", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmMarcaMaterialSanitario.findAll", query = "SELECT f FROM FarmMarcaMaterialSanitario f"),
    @NamedQuery(name = "FarmMarcaMaterialSanitario.findByPkIdMarca", query = "SELECT f FROM FarmMarcaMaterialSanitario f WHERE f.pkIdMarca = :pkIdMarca"),
    @NamedQuery(name = "FarmMarcaMaterialSanitario.findByCodigoMarca", query = "SELECT f FROM FarmMarcaMaterialSanitario f WHERE f.codigoMarca = :codigoMarca"),
    @NamedQuery(name = "FarmMarcaMaterialSanitario.findByDescricaoMarca", query = "SELECT f FROM FarmMarcaMaterialSanitario f WHERE f.descricaoMarca = :descricaoMarca")})
public class FarmMarcaMaterialSanitario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_marca")
    private Integer pkIdMarca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigo_marca")
    private String codigoMarca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descricao_marca")
    private String descricaoMarca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdMarca")
    private List<FarmMaterialSanitario> farmMaterialSanitarioList;

    public FarmMarcaMaterialSanitario() {
    }

    public FarmMarcaMaterialSanitario(Integer pkIdMarca) {
        this.pkIdMarca = pkIdMarca;
    }

    public FarmMarcaMaterialSanitario(Integer pkIdMarca, String codigoMarca, String descricaoMarca) {
        this.pkIdMarca = pkIdMarca;
        this.codigoMarca = codigoMarca;
        this.descricaoMarca = descricaoMarca;
    }

    public Integer getPkIdMarca() {
        return pkIdMarca;
    }

    public void setPkIdMarca(Integer pkIdMarca) {
        this.pkIdMarca = pkIdMarca;
    }

    public String getCodigoMarca() {
        return codigoMarca;
    }

    public void setCodigoMarca(String codigoMarca) {
        this.codigoMarca = codigoMarca;
    }

    public String getDescricaoMarca() {
        return descricaoMarca;
    }

    public void setDescricaoMarca(String descricaoMarca) {
        this.descricaoMarca = descricaoMarca;
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
        hash += (pkIdMarca != null ? pkIdMarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmMarcaMaterialSanitario)) {
            return false;
        }
        FarmMarcaMaterialSanitario other = (FarmMarcaMaterialSanitario) object;
        if ((this.pkIdMarca == null && other.pkIdMarca != null) || (this.pkIdMarca != null && !this.pkIdMarca.equals(other.pkIdMarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmMarcaMaterialSanitario[ pkIdMarca=" + pkIdMarca + " ]";
    }
    
}
