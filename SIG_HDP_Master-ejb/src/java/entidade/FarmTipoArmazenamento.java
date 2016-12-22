/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "farm_tipo_armazenamento", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmTipoArmazenamento.findAll", query = "SELECT f FROM FarmTipoArmazenamento f"),
    @NamedQuery(name = "FarmTipoArmazenamento.findByPkIdTipoArmazenamento", query = "SELECT f FROM FarmTipoArmazenamento f WHERE f.pkIdTipoArmazenamento = :pkIdTipoArmazenamento"),
    @NamedQuery(name = "FarmTipoArmazenamento.findByDescricaoTipoArmazenamento", query = "SELECT f FROM FarmTipoArmazenamento f WHERE f.descricaoTipoArmazenamento = :descricaoTipoArmazenamento")})
public class FarmTipoArmazenamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_id_tipo_armazenamento")
    private Integer pkIdTipoArmazenamento;
    @Size(max = 100)
    @Column(name = "descricao_tipo_armazenamento")
    private String descricaoTipoArmazenamento;
    @OneToMany(mappedBy = "fkIdTipoArmazenamento")
    private List<FarmArmazenamento> farmArmazenamentoList;

    public FarmTipoArmazenamento() {
    }

    public FarmTipoArmazenamento(Integer pkIdTipoArmazenamento) {
        this.pkIdTipoArmazenamento = pkIdTipoArmazenamento;
    }

    public Integer getPkIdTipoArmazenamento() {
        return pkIdTipoArmazenamento;
    }

    public void setPkIdTipoArmazenamento(Integer pkIdTipoArmazenamento) {
        this.pkIdTipoArmazenamento = pkIdTipoArmazenamento;
    }

    public String getDescricaoTipoArmazenamento() {
        return descricaoTipoArmazenamento;
    }

    public void setDescricaoTipoArmazenamento(String descricaoTipoArmazenamento) {
        this.descricaoTipoArmazenamento = descricaoTipoArmazenamento;
    }

    @XmlTransient
    public List<FarmArmazenamento> getFarmArmazenamentoList() {
        return farmArmazenamentoList;
    }

    public void setFarmArmazenamentoList(List<FarmArmazenamento> farmArmazenamentoList) {
        this.farmArmazenamentoList = farmArmazenamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdTipoArmazenamento != null ? pkIdTipoArmazenamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmTipoArmazenamento)) {
            return false;
        }
        FarmTipoArmazenamento other = (FarmTipoArmazenamento) object;
        if ((this.pkIdTipoArmazenamento == null && other.pkIdTipoArmazenamento != null) || (this.pkIdTipoArmazenamento != null && !this.pkIdTipoArmazenamento.equals(other.pkIdTipoArmazenamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmTipoArmazenamento[ pkIdTipoArmazenamento=" + pkIdTipoArmazenamento + " ]";
    }
    
}
