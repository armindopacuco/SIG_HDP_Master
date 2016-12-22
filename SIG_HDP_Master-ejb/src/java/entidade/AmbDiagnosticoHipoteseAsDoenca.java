/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "amb_diagnostico_hipotese_as_doenca", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbDiagnosticoHipoteseAsDoenca.findAll", query = "SELECT a FROM AmbDiagnosticoHipoteseAsDoenca a"),
    @NamedQuery(name = "AmbDiagnosticoHipoteseAsDoenca.findByPkIdDiagnosticoHipoteseDoenca", query = "SELECT a FROM AmbDiagnosticoHipoteseAsDoenca a WHERE a.pkIdDiagnosticoHipoteseDoenca = :pkIdDiagnosticoHipoteseDoenca"),
    @NamedQuery(name = "AmbDiagnosticoHipoteseAsDoenca.findByDoencas", query = "SELECT a FROM AmbDiagnosticoHipoteseAsDoenca a WHERE a.doencas = :doencas")})
public class AmbDiagnosticoHipoteseAsDoenca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_diagnostico_hipotese_doenca")
    private Integer pkIdDiagnosticoHipoteseDoenca;
    @Size(max = 500)
    @Column(name = "doencas")
    private String doencas;
    @JoinColumn(name = "fk_pk_id_diagnostico_hipotese", referencedColumnName = "pk_id_diagnostico_hipotese")
    @ManyToOne(optional = false)
    private AmbDiagnosticoHipotese fkPkIdDiagnosticoHipotese;

    public AmbDiagnosticoHipoteseAsDoenca() {
    }

    public AmbDiagnosticoHipoteseAsDoenca(Integer pkIdDiagnosticoHipoteseDoenca) {
        this.pkIdDiagnosticoHipoteseDoenca = pkIdDiagnosticoHipoteseDoenca;
    }

    public Integer getPkIdDiagnosticoHipoteseDoenca() {
        return pkIdDiagnosticoHipoteseDoenca;
    }

    public void setPkIdDiagnosticoHipoteseDoenca(Integer pkIdDiagnosticoHipoteseDoenca) {
        this.pkIdDiagnosticoHipoteseDoenca = pkIdDiagnosticoHipoteseDoenca;
    }

    public String getDoencas() {
        return doencas;
    }

    public void setDoencas(String doencas) {
        this.doencas = doencas;
    }

    public AmbDiagnosticoHipotese getFkPkIdDiagnosticoHipotese() {
        return fkPkIdDiagnosticoHipotese;
    }

    public void setFkPkIdDiagnosticoHipotese(AmbDiagnosticoHipotese fkPkIdDiagnosticoHipotese) {
        this.fkPkIdDiagnosticoHipotese = fkPkIdDiagnosticoHipotese;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdDiagnosticoHipoteseDoenca != null ? pkIdDiagnosticoHipoteseDoenca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbDiagnosticoHipoteseAsDoenca)) {
            return false;
        }
        AmbDiagnosticoHipoteseAsDoenca other = (AmbDiagnosticoHipoteseAsDoenca) object;
        if ((this.pkIdDiagnosticoHipoteseDoenca == null && other.pkIdDiagnosticoHipoteseDoenca != null) || (this.pkIdDiagnosticoHipoteseDoenca != null && !this.pkIdDiagnosticoHipoteseDoenca.equals(other.pkIdDiagnosticoHipoteseDoenca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbDiagnosticoHipoteseAsDoenca[ pkIdDiagnosticoHipoteseDoenca=" + pkIdDiagnosticoHipoteseDoenca + " ]";
    }
    
}
