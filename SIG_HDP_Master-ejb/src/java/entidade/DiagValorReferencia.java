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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "diag_valor_referencia", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagValorReferencia.findAll", query = "SELECT d FROM DiagValorReferencia d"),
    @NamedQuery(name = "DiagValorReferencia.findByPkIdValorReferencia", query = "SELECT d FROM DiagValorReferencia d WHERE d.pkIdValorReferencia = :pkIdValorReferencia"),
    @NamedQuery(name = "DiagValorReferencia.findByValorMinimo", query = "SELECT d FROM DiagValorReferencia d WHERE d.valorMinimo = :valorMinimo"),
    @NamedQuery(name = "DiagValorReferencia.findByValorMaximo", query = "SELECT d FROM DiagValorReferencia d WHERE d.valorMaximo = :valorMaximo")})
public class DiagValorReferencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_valor_referencia")
    private Integer pkIdValorReferencia;
    @Size(max = 45)
    @Column(name = "valor_minimo")
    private String valorMinimo;
    @Size(max = 45)
    @Column(name = "valor_maximo")
    private String valorMaximo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdValorReferencia")
    private List<DiagExame> diagExameList;

    public DiagValorReferencia() {
    }

    public DiagValorReferencia(Integer pkIdValorReferencia) {
        this.pkIdValorReferencia = pkIdValorReferencia;
    }

    public Integer getPkIdValorReferencia() {
        return pkIdValorReferencia;
    }

    public void setPkIdValorReferencia(Integer pkIdValorReferencia) {
        this.pkIdValorReferencia = pkIdValorReferencia;
    }

    public String getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(String valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public String getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(String valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    @XmlTransient
    public List<DiagExame> getDiagExameList() {
        return diagExameList;
    }

    public void setDiagExameList(List<DiagExame> diagExameList) {
        this.diagExameList = diagExameList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdValorReferencia != null ? pkIdValorReferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagValorReferencia)) {
            return false;
        }
        DiagValorReferencia other = (DiagValorReferencia) object;
        if ((this.pkIdValorReferencia == null && other.pkIdValorReferencia != null) || (this.pkIdValorReferencia != null && !this.pkIdValorReferencia.equals(other.pkIdValorReferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.DiagValorReferencia[ pkIdValorReferencia=" + pkIdValorReferencia + " ]";
    }
    
}
