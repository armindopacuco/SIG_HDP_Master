/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "farm_info_fabrico_material_sanitario", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmInfoFabricoMaterialSanitario.findAll", query = "SELECT f FROM FarmInfoFabricoMaterialSanitario f"),
    @NamedQuery(name = "FarmInfoFabricoMaterialSanitario.findByPkIdInfoFabrico", query = "SELECT f FROM FarmInfoFabricoMaterialSanitario f WHERE f.pkIdInfoFabrico = :pkIdInfoFabrico"),
    @NamedQuery(name = "FarmInfoFabricoMaterialSanitario.findByDataFabrico", query = "SELECT f FROM FarmInfoFabricoMaterialSanitario f WHERE f.dataFabrico = :dataFabrico"),
    @NamedQuery(name = "FarmInfoFabricoMaterialSanitario.findByDataValidade", query = "SELECT f FROM FarmInfoFabricoMaterialSanitario f WHERE f.dataValidade = :dataValidade"),
    @NamedQuery(name = "FarmInfoFabricoMaterialSanitario.findByNumeroLote", query = "SELECT f FROM FarmInfoFabricoMaterialSanitario f WHERE f.numeroLote = :numeroLote")})
public class FarmInfoFabricoMaterialSanitario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_info_fabrico")
    private Integer pkIdInfoFabrico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_fabrico")
    @Temporal(TemporalType.DATE)
    private Date dataFabrico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_validade")
    @Temporal(TemporalType.DATE)
    private Date dataValidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "numero_lote")
    private String numeroLote;
    @JoinColumn(name = "fk_id_material_sanitario", referencedColumnName = "pk_id_material_sanitario")
    @ManyToOne(optional = false)
    private FarmMaterialSanitario fkIdMaterialSanitario;

    public FarmInfoFabricoMaterialSanitario() {
    }

    public FarmInfoFabricoMaterialSanitario(Integer pkIdInfoFabrico) {
        this.pkIdInfoFabrico = pkIdInfoFabrico;
    }

    public FarmInfoFabricoMaterialSanitario(Integer pkIdInfoFabrico, Date dataFabrico, Date dataValidade, String numeroLote) {
        this.pkIdInfoFabrico = pkIdInfoFabrico;
        this.dataFabrico = dataFabrico;
        this.dataValidade = dataValidade;
        this.numeroLote = numeroLote;
    }

    public Integer getPkIdInfoFabrico() {
        return pkIdInfoFabrico;
    }

    public void setPkIdInfoFabrico(Integer pkIdInfoFabrico) {
        this.pkIdInfoFabrico = pkIdInfoFabrico;
    }

    public Date getDataFabrico() {
        return dataFabrico;
    }

    public void setDataFabrico(Date dataFabrico) {
        this.dataFabrico = dataFabrico;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
    }

    public FarmMaterialSanitario getFkIdMaterialSanitario() {
        return fkIdMaterialSanitario;
    }

    public void setFkIdMaterialSanitario(FarmMaterialSanitario fkIdMaterialSanitario) {
        this.fkIdMaterialSanitario = fkIdMaterialSanitario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdInfoFabrico != null ? pkIdInfoFabrico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmInfoFabricoMaterialSanitario)) {
            return false;
        }
        FarmInfoFabricoMaterialSanitario other = (FarmInfoFabricoMaterialSanitario) object;
        if ((this.pkIdInfoFabrico == null && other.pkIdInfoFabrico != null) || (this.pkIdInfoFabrico != null && !this.pkIdInfoFabrico.equals(other.pkIdInfoFabrico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmInfoFabricoMaterialSanitario[ pkIdInfoFabrico=" + pkIdInfoFabrico + " ]";
    }
    
}
