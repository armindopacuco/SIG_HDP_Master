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
@Table(name = "diag_estado_clinico", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagEstadoClinico.findAll", query = "SELECT d FROM DiagEstadoClinico d"),
    @NamedQuery(name = "DiagEstadoClinico.findByPkIdEstadoClinico", query = "SELECT d FROM DiagEstadoClinico d WHERE d.pkIdEstadoClinico = :pkIdEstadoClinico"),
    @NamedQuery(name = "DiagEstadoClinico.findByDescricaoEstadoClinico", query = "SELECT d FROM DiagEstadoClinico d WHERE d.descricaoEstadoClinico = :descricaoEstadoClinico"),
    @NamedQuery(name = "DiagEstadoClinico.findByCodigoEstadoClinico", query = "SELECT d FROM DiagEstadoClinico d WHERE d.codigoEstadoClinico = :codigoEstadoClinico")})
public class DiagEstadoClinico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_estado_clinico")
    private Integer pkIdEstadoClinico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao_estado_clinico")
    private String descricaoEstadoClinico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigo_estado_clinico")
    private String codigoEstadoClinico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdEstadoClinico")
    private List<DiagExameDador> diagExameDadorList;

    public DiagEstadoClinico() {
    }

    public DiagEstadoClinico(Integer pkIdEstadoClinico) {
        this.pkIdEstadoClinico = pkIdEstadoClinico;
    }

    public DiagEstadoClinico(Integer pkIdEstadoClinico, String descricaoEstadoClinico, String codigoEstadoClinico) {
        this.pkIdEstadoClinico = pkIdEstadoClinico;
        this.descricaoEstadoClinico = descricaoEstadoClinico;
        this.codigoEstadoClinico = codigoEstadoClinico;
    }

    public Integer getPkIdEstadoClinico() {
        return pkIdEstadoClinico;
    }

    public void setPkIdEstadoClinico(Integer pkIdEstadoClinico) {
        this.pkIdEstadoClinico = pkIdEstadoClinico;
    }

    public String getDescricaoEstadoClinico() {
        return descricaoEstadoClinico;
    }

    public void setDescricaoEstadoClinico(String descricaoEstadoClinico) {
        this.descricaoEstadoClinico = descricaoEstadoClinico;
    }

    public String getCodigoEstadoClinico() {
        return codigoEstadoClinico;
    }

    public void setCodigoEstadoClinico(String codigoEstadoClinico) {
        this.codigoEstadoClinico = codigoEstadoClinico;
    }

    @XmlTransient
    public List<DiagExameDador> getDiagExameDadorList() {
        return diagExameDadorList;
    }

    public void setDiagExameDadorList(List<DiagExameDador> diagExameDadorList) {
        this.diagExameDadorList = diagExameDadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdEstadoClinico != null ? pkIdEstadoClinico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagEstadoClinico)) {
            return false;
        }
        DiagEstadoClinico other = (DiagEstadoClinico) object;
        if ((this.pkIdEstadoClinico == null && other.pkIdEstadoClinico != null) || (this.pkIdEstadoClinico != null && !this.pkIdEstadoClinico.equals(other.pkIdEstadoClinico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.DiagEstadoClinico[ pkIdEstadoClinico=" + pkIdEstadoClinico + " ]";
    }
    
}
