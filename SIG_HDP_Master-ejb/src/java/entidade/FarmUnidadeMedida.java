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
@Table(name = "farm_unidade_medida", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmUnidadeMedida.findAll", query = "SELECT f FROM FarmUnidadeMedida f"),
    @NamedQuery(name = "FarmUnidadeMedida.findByPkIdUnidadeMedida", query = "SELECT f FROM FarmUnidadeMedida f WHERE f.pkIdUnidadeMedida = :pkIdUnidadeMedida"),
    @NamedQuery(name = "FarmUnidadeMedida.findByCodigoUnidadeMedida", query = "SELECT f FROM FarmUnidadeMedida f WHERE f.codigoUnidadeMedida = :codigoUnidadeMedida"),
    @NamedQuery(name = "FarmUnidadeMedida.findByDescricaoUnidadeMedida", query = "SELECT f FROM FarmUnidadeMedida f WHERE f.descricaoUnidadeMedida = :descricaoUnidadeMedida")})
public class FarmUnidadeMedida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_unidade_medida")
    private Integer pkIdUnidadeMedida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigo_unidade_medida")
    private String codigoUnidadeMedida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descricao_unidade_medida")
    private String descricaoUnidadeMedida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdUnidadeMedida")
    private List<FarmApresentacao> farmApresentacaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdUnidadeMedida")
    private List<FarmMaterialGastavel> farmMaterialGastavelList;

    public FarmUnidadeMedida() {
    }

    public FarmUnidadeMedida(Integer pkIdUnidadeMedida) {
        this.pkIdUnidadeMedida = pkIdUnidadeMedida;
    }

    public FarmUnidadeMedida(Integer pkIdUnidadeMedida, String codigoUnidadeMedida, String descricaoUnidadeMedida) {
        this.pkIdUnidadeMedida = pkIdUnidadeMedida;
        this.codigoUnidadeMedida = codigoUnidadeMedida;
        this.descricaoUnidadeMedida = descricaoUnidadeMedida;
    }

    public Integer getPkIdUnidadeMedida() {
        return pkIdUnidadeMedida;
    }

    public void setPkIdUnidadeMedida(Integer pkIdUnidadeMedida) {
        this.pkIdUnidadeMedida = pkIdUnidadeMedida;
    }

    public String getCodigoUnidadeMedida() {
        return codigoUnidadeMedida;
    }

    public void setCodigoUnidadeMedida(String codigoUnidadeMedida) {
        this.codigoUnidadeMedida = codigoUnidadeMedida;
    }

    public String getDescricaoUnidadeMedida() {
        return descricaoUnidadeMedida;
    }

    public void setDescricaoUnidadeMedida(String descricaoUnidadeMedida) {
        this.descricaoUnidadeMedida = descricaoUnidadeMedida;
    }

    @XmlTransient
    public List<FarmApresentacao> getFarmApresentacaoList() {
        return farmApresentacaoList;
    }

    public void setFarmApresentacaoList(List<FarmApresentacao> farmApresentacaoList) {
        this.farmApresentacaoList = farmApresentacaoList;
    }

    @XmlTransient
    public List<FarmMaterialGastavel> getFarmMaterialGastavelList() {
        return farmMaterialGastavelList;
    }

    public void setFarmMaterialGastavelList(List<FarmMaterialGastavel> farmMaterialGastavelList) {
        this.farmMaterialGastavelList = farmMaterialGastavelList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdUnidadeMedida != null ? pkIdUnidadeMedida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmUnidadeMedida)) {
            return false;
        }
        FarmUnidadeMedida other = (FarmUnidadeMedida) object;
        if ((this.pkIdUnidadeMedida == null && other.pkIdUnidadeMedida != null) || (this.pkIdUnidadeMedida != null && !this.pkIdUnidadeMedida.equals(other.pkIdUnidadeMedida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmUnidadeMedida[ pkIdUnidadeMedida=" + pkIdUnidadeMedida + " ]";
    }
    
}
