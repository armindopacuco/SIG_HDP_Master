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
@Table(name = "farm_via_administracao", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmViaAdministracao.findAll", query = "SELECT f FROM FarmViaAdministracao f"),
    @NamedQuery(name = "FarmViaAdministracao.findByPkIdViaAdministracao", query = "SELECT f FROM FarmViaAdministracao f WHERE f.pkIdViaAdministracao = :pkIdViaAdministracao"),
    @NamedQuery(name = "FarmViaAdministracao.findByDescricaoViaAdministracao", query = "SELECT f FROM FarmViaAdministracao f WHERE f.descricaoViaAdministracao = :descricaoViaAdministracao")})
public class FarmViaAdministracao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_via_administracao")
    private Integer pkIdViaAdministracao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descricao_via_administracao")
    private String descricaoViaAdministracao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdViaAdministracao")
    private List<FarmMedicamentoGrandeVolume> farmMedicamentoGrandeVolumeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdViaAdministracao")
    private List<FarmMedicamento> farmMedicamentoList;

    public FarmViaAdministracao() {
    }

    public FarmViaAdministracao(Integer pkIdViaAdministracao) {
        this.pkIdViaAdministracao = pkIdViaAdministracao;
    }

    public FarmViaAdministracao(Integer pkIdViaAdministracao, String descricaoViaAdministracao) {
        this.pkIdViaAdministracao = pkIdViaAdministracao;
        this.descricaoViaAdministracao = descricaoViaAdministracao;
    }

    public Integer getPkIdViaAdministracao() {
        return pkIdViaAdministracao;
    }

    public void setPkIdViaAdministracao(Integer pkIdViaAdministracao) {
        this.pkIdViaAdministracao = pkIdViaAdministracao;
    }

    public String getDescricaoViaAdministracao() {
        return descricaoViaAdministracao;
    }

    public void setDescricaoViaAdministracao(String descricaoViaAdministracao) {
        this.descricaoViaAdministracao = descricaoViaAdministracao;
    }

    @XmlTransient
    public List<FarmMedicamentoGrandeVolume> getFarmMedicamentoGrandeVolumeList() {
        return farmMedicamentoGrandeVolumeList;
    }

    public void setFarmMedicamentoGrandeVolumeList(List<FarmMedicamentoGrandeVolume> farmMedicamentoGrandeVolumeList) {
        this.farmMedicamentoGrandeVolumeList = farmMedicamentoGrandeVolumeList;
    }

    @XmlTransient
    public List<FarmMedicamento> getFarmMedicamentoList() {
        return farmMedicamentoList;
    }

    public void setFarmMedicamentoList(List<FarmMedicamento> farmMedicamentoList) {
        this.farmMedicamentoList = farmMedicamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdViaAdministracao != null ? pkIdViaAdministracao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmViaAdministracao)) {
            return false;
        }
        FarmViaAdministracao other = (FarmViaAdministracao) object;
        if ((this.pkIdViaAdministracao == null && other.pkIdViaAdministracao != null) || (this.pkIdViaAdministracao != null && !this.pkIdViaAdministracao.equals(other.pkIdViaAdministracao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmViaAdministracao[ pkIdViaAdministracao=" + pkIdViaAdministracao + " ]";
    }
    
}
