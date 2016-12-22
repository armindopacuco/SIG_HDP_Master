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
@Table(name = "diag_material", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagMaterial.findAll", query = "SELECT d FROM DiagMaterial d"),
    @NamedQuery(name = "DiagMaterial.findByPkIdMaterial", query = "SELECT d FROM DiagMaterial d WHERE d.pkIdMaterial = :pkIdMaterial"),
    @NamedQuery(name = "DiagMaterial.findByDescricaoMaterial", query = "SELECT d FROM DiagMaterial d WHERE d.descricaoMaterial = :descricaoMaterial")})
public class DiagMaterial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_material")
    private Integer pkIdMaterial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao_material")
    private String descricaoMaterial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdMaterial")
    private List<DiagAmostra> diagAmostraList;

    public DiagMaterial() {
    }

    public DiagMaterial(Integer pkIdMaterial) {
        this.pkIdMaterial = pkIdMaterial;
    }

    public DiagMaterial(Integer pkIdMaterial, String descricaoMaterial) {
        this.pkIdMaterial = pkIdMaterial;
        this.descricaoMaterial = descricaoMaterial;
    }

    public Integer getPkIdMaterial() {
        return pkIdMaterial;
    }

    public void setPkIdMaterial(Integer pkIdMaterial) {
        this.pkIdMaterial = pkIdMaterial;
    }

    public String getDescricaoMaterial() {
        return descricaoMaterial;
    }

    public void setDescricaoMaterial(String descricaoMaterial) {
        this.descricaoMaterial = descricaoMaterial;
    }

    @XmlTransient
    public List<DiagAmostra> getDiagAmostraList() {
        return diagAmostraList;
    }

    public void setDiagAmostraList(List<DiagAmostra> diagAmostraList) {
        this.diagAmostraList = diagAmostraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdMaterial != null ? pkIdMaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagMaterial)) {
            return false;
        }
        DiagMaterial other = (DiagMaterial) object;
        if ((this.pkIdMaterial == null && other.pkIdMaterial != null) || (this.pkIdMaterial != null && !this.pkIdMaterial.equals(other.pkIdMaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.DiagMaterial[ pkIdMaterial=" + pkIdMaterial + " ]";
    }
    
}
