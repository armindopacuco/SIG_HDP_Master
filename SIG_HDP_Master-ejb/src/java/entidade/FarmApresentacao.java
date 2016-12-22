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
@Table(name = "farm_apresentacao", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmApresentacao.findAll", query = "SELECT f FROM FarmApresentacao f"),
    @NamedQuery(name = "FarmApresentacao.findByPkIdApresentacao", query = "SELECT f FROM FarmApresentacao f WHERE f.pkIdApresentacao = :pkIdApresentacao"),
    @NamedQuery(name = "FarmApresentacao.findByDosagem", query = "SELECT f FROM FarmApresentacao f WHERE f.dosagem = :dosagem"),
    @NamedQuery(name = "FarmApresentacao.findByDescricaoApresentacao", query = "SELECT f FROM FarmApresentacao f WHERE f.descricaoApresentacao = :descricaoApresentacao")})
public class FarmApresentacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_apresentacao")
    private Integer pkIdApresentacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dosagem")
    private int dosagem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "descricao_apresentacao")
    private String descricaoApresentacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdApresentacao")
    private List<FarmMedicamentoGrandeVolume> farmMedicamentoGrandeVolumeList;
    @JoinColumn(name = "fk_id_unidade_medida", referencedColumnName = "pk_id_unidade_medida")
    @ManyToOne(optional = false)
    private FarmUnidadeMedida fkIdUnidadeMedida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdApesentacao")
    private List<FarmMedicamento> farmMedicamentoList;

    public FarmApresentacao() {
    }

    public FarmApresentacao(Integer pkIdApresentacao) {
        this.pkIdApresentacao = pkIdApresentacao;
    }

    public FarmApresentacao(Integer pkIdApresentacao, int dosagem, String descricaoApresentacao) {
        this.pkIdApresentacao = pkIdApresentacao;
        this.dosagem = dosagem;
        this.descricaoApresentacao = descricaoApresentacao;
    }

    public Integer getPkIdApresentacao() {
        return pkIdApresentacao;
    }

    public void setPkIdApresentacao(Integer pkIdApresentacao) {
        this.pkIdApresentacao = pkIdApresentacao;
    }

    public int getDosagem() {
        return dosagem;
    }

    public void setDosagem(int dosagem) {
        this.dosagem = dosagem;
    }

    public String getDescricaoApresentacao() {
        return descricaoApresentacao;
    }

    public void setDescricaoApresentacao(String descricaoApresentacao) {
        this.descricaoApresentacao = descricaoApresentacao;
    }

    @XmlTransient
    public List<FarmMedicamentoGrandeVolume> getFarmMedicamentoGrandeVolumeList() {
        return farmMedicamentoGrandeVolumeList;
    }

    public void setFarmMedicamentoGrandeVolumeList(List<FarmMedicamentoGrandeVolume> farmMedicamentoGrandeVolumeList) {
        this.farmMedicamentoGrandeVolumeList = farmMedicamentoGrandeVolumeList;
    }

    public FarmUnidadeMedida getFkIdUnidadeMedida() {
        return fkIdUnidadeMedida;
    }

    public void setFkIdUnidadeMedida(FarmUnidadeMedida fkIdUnidadeMedida) {
        this.fkIdUnidadeMedida = fkIdUnidadeMedida;
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
        hash += (pkIdApresentacao != null ? pkIdApresentacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmApresentacao)) {
            return false;
        }
        FarmApresentacao other = (FarmApresentacao) object;
        if ((this.pkIdApresentacao == null && other.pkIdApresentacao != null) || (this.pkIdApresentacao != null && !this.pkIdApresentacao.equals(other.pkIdApresentacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmApresentacao[ pkIdApresentacao=" + pkIdApresentacao + " ]";
    }
    
}
