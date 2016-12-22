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
@Table(name = "farm_agente_activo", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmAgenteActivo.findAll", query = "SELECT f FROM FarmAgenteActivo f"),
    @NamedQuery(name = "FarmAgenteActivo.findByPkIdAgenteActivo", query = "SELECT f FROM FarmAgenteActivo f WHERE f.pkIdAgenteActivo = :pkIdAgenteActivo"),
    @NamedQuery(name = "FarmAgenteActivo.findByDescricaoAgenteActivo", query = "SELECT f FROM FarmAgenteActivo f WHERE f.descricaoAgenteActivo = :descricaoAgenteActivo")})
public class FarmAgenteActivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_agente_activo")
    private Integer pkIdAgenteActivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descricao_agente_activo")
    private String descricaoAgenteActivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdAgenteActivo")
    private List<FarmMaterialSanitarioHasAgenteActivo> farmMaterialSanitarioHasAgenteActivoList;

    public FarmAgenteActivo() {
    }

    public FarmAgenteActivo(Integer pkIdAgenteActivo) {
        this.pkIdAgenteActivo = pkIdAgenteActivo;
    }

    public FarmAgenteActivo(Integer pkIdAgenteActivo, String descricaoAgenteActivo) {
        this.pkIdAgenteActivo = pkIdAgenteActivo;
        this.descricaoAgenteActivo = descricaoAgenteActivo;
    }

    public Integer getPkIdAgenteActivo() {
        return pkIdAgenteActivo;
    }

    public void setPkIdAgenteActivo(Integer pkIdAgenteActivo) {
        this.pkIdAgenteActivo = pkIdAgenteActivo;
    }

    public String getDescricaoAgenteActivo() {
        return descricaoAgenteActivo;
    }

    public void setDescricaoAgenteActivo(String descricaoAgenteActivo) {
        this.descricaoAgenteActivo = descricaoAgenteActivo;
    }

    @XmlTransient
    public List<FarmMaterialSanitarioHasAgenteActivo> getFarmMaterialSanitarioHasAgenteActivoList() {
        return farmMaterialSanitarioHasAgenteActivoList;
    }

    public void setFarmMaterialSanitarioHasAgenteActivoList(List<FarmMaterialSanitarioHasAgenteActivo> farmMaterialSanitarioHasAgenteActivoList) {
        this.farmMaterialSanitarioHasAgenteActivoList = farmMaterialSanitarioHasAgenteActivoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdAgenteActivo != null ? pkIdAgenteActivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmAgenteActivo)) {
            return false;
        }
        FarmAgenteActivo other = (FarmAgenteActivo) object;
        if ((this.pkIdAgenteActivo == null && other.pkIdAgenteActivo != null) || (this.pkIdAgenteActivo != null && !this.pkIdAgenteActivo.equals(other.pkIdAgenteActivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmAgenteActivo[ pkIdAgenteActivo=" + pkIdAgenteActivo + " ]";
    }
    
}
