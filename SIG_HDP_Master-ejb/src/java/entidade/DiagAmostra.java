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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "diag_amostra", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagAmostra.findAll", query = "SELECT d FROM DiagAmostra d"),
    @NamedQuery(name = "DiagAmostra.findByPkIdAmostra", query = "SELECT d FROM DiagAmostra d WHERE d.pkIdAmostra = :pkIdAmostra")})
public class DiagAmostra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_amostra")
    private Integer pkIdAmostra;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdAmostra")
    private List<DiagResultado> diagResultadoList;
    @JoinColumn(name = "fk_id_tipo_amostra", referencedColumnName = "pk_id_tipo_amostra")
    @ManyToOne(optional = false)
    private DiagTipoAmostra fkIdTipoAmostra;
    @JoinColumn(name = "fk_id_suporte", referencedColumnName = "pk_id_suporte")
    @ManyToOne(optional = false)
    private DiagSuporte fkIdSuporte;
    @JoinColumn(name = "fk_id_material", referencedColumnName = "pk_id_material")
    @ManyToOne(optional = false)
    private DiagMaterial fkIdMaterial;
    @JoinColumn(name = "fk_id_colecta", referencedColumnName = "pk_id_colecta")
    @ManyToOne(optional = false)
    private DiagColecta fkIdColecta;

    public DiagAmostra() {
    }

    public DiagAmostra(Integer pkIdAmostra) {
        this.pkIdAmostra = pkIdAmostra;
    }

    public Integer getPkIdAmostra() {
        return pkIdAmostra;
    }

    public void setPkIdAmostra(Integer pkIdAmostra) {
        this.pkIdAmostra = pkIdAmostra;
    }

    @XmlTransient
    public List<DiagResultado> getDiagResultadoList() {
        return diagResultadoList;
    }

    public void setDiagResultadoList(List<DiagResultado> diagResultadoList) {
        this.diagResultadoList = diagResultadoList;
    }

    public DiagTipoAmostra getFkIdTipoAmostra() {
        return fkIdTipoAmostra;
    }

    public void setFkIdTipoAmostra(DiagTipoAmostra fkIdTipoAmostra) {
        this.fkIdTipoAmostra = fkIdTipoAmostra;
    }

    public DiagSuporte getFkIdSuporte() {
        return fkIdSuporte;
    }

    public void setFkIdSuporte(DiagSuporte fkIdSuporte) {
        this.fkIdSuporte = fkIdSuporte;
    }

    public DiagMaterial getFkIdMaterial() {
        return fkIdMaterial;
    }

    public void setFkIdMaterial(DiagMaterial fkIdMaterial) {
        this.fkIdMaterial = fkIdMaterial;
    }

    public DiagColecta getFkIdColecta() {
        return fkIdColecta;
    }

    public void setFkIdColecta(DiagColecta fkIdColecta) {
        this.fkIdColecta = fkIdColecta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdAmostra != null ? pkIdAmostra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagAmostra)) {
            return false;
        }
        DiagAmostra other = (DiagAmostra) object;
        if ((this.pkIdAmostra == null && other.pkIdAmostra != null) || (this.pkIdAmostra != null && !this.pkIdAmostra.equals(other.pkIdAmostra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.DiagAmostra[ pkIdAmostra=" + pkIdAmostra + " ]";
    }
    
}
