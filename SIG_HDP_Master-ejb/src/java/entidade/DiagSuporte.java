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
@Table(name = "diag_suporte", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagSuporte.findAll", query = "SELECT d FROM DiagSuporte d"),
    @NamedQuery(name = "DiagSuporte.findByPkIdSuporte", query = "SELECT d FROM DiagSuporte d WHERE d.pkIdSuporte = :pkIdSuporte"),
    @NamedQuery(name = "DiagSuporte.findByDescricaoLote", query = "SELECT d FROM DiagSuporte d WHERE d.descricaoLote = :descricaoLote")})
public class DiagSuporte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_suporte")
    private Integer pkIdSuporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao_lote")
    private String descricaoLote;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdSuporte")
    private List<DiagAmostra> diagAmostraList;

    public DiagSuporte() {
    }

    public DiagSuporte(Integer pkIdSuporte) {
        this.pkIdSuporte = pkIdSuporte;
    }

    public DiagSuporte(Integer pkIdSuporte, String descricaoLote) {
        this.pkIdSuporte = pkIdSuporte;
        this.descricaoLote = descricaoLote;
    }

    public Integer getPkIdSuporte() {
        return pkIdSuporte;
    }

    public void setPkIdSuporte(Integer pkIdSuporte) {
        this.pkIdSuporte = pkIdSuporte;
    }

    public String getDescricaoLote() {
        return descricaoLote;
    }

    public void setDescricaoLote(String descricaoLote) {
        this.descricaoLote = descricaoLote;
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
        hash += (pkIdSuporte != null ? pkIdSuporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagSuporte)) {
            return false;
        }
        DiagSuporte other = (DiagSuporte) object;
        if ((this.pkIdSuporte == null && other.pkIdSuporte != null) || (this.pkIdSuporte != null && !this.pkIdSuporte.equals(other.pkIdSuporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.DiagSuporte[ pkIdSuporte=" + pkIdSuporte + " ]";
    }
    
}
