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
@Table(name = "amb_diagnostico_as_doenca", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbDiagnosticoAsDoenca.findAll", query = "SELECT a FROM AmbDiagnosticoAsDoenca a"),
    @NamedQuery(name = "AmbDiagnosticoAsDoenca.findByPkIdDiagnosticoDoenca", query = "SELECT a FROM AmbDiagnosticoAsDoenca a WHERE a.pkIdDiagnosticoDoenca = :pkIdDiagnosticoDoenca"),
    @NamedQuery(name = "AmbDiagnosticoAsDoenca.findByDoencas", query = "SELECT a FROM AmbDiagnosticoAsDoenca a WHERE a.doencas = :doencas")})
public class AmbDiagnosticoAsDoenca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_diagnostico_doenca")
    private Integer pkIdDiagnosticoDoenca;
    @Size(max = 500)
    @Column(name = "doencas")
    private String doencas;
    @JoinColumn(name = "fk_pk_id_diagnostico", referencedColumnName = "pk_id_diagnostico")
    @ManyToOne(optional = false)
    private AmbDiagnostico fkPkIdDiagnostico;

    public AmbDiagnosticoAsDoenca() {
    }

    public AmbDiagnosticoAsDoenca(Integer pkIdDiagnosticoDoenca) {
        this.pkIdDiagnosticoDoenca = pkIdDiagnosticoDoenca;
    }

    public Integer getPkIdDiagnosticoDoenca() {
        return pkIdDiagnosticoDoenca;
    }

    public void setPkIdDiagnosticoDoenca(Integer pkIdDiagnosticoDoenca) {
        this.pkIdDiagnosticoDoenca = pkIdDiagnosticoDoenca;
    }

    public String getDoencas() {
        return doencas;
    }

    public void setDoencas(String doencas) {
        this.doencas = doencas;
    }

    public AmbDiagnostico getFkPkIdDiagnostico() {
        return fkPkIdDiagnostico;
    }

    public void setFkPkIdDiagnostico(AmbDiagnostico fkPkIdDiagnostico) {
        this.fkPkIdDiagnostico = fkPkIdDiagnostico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdDiagnosticoDoenca != null ? pkIdDiagnosticoDoenca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbDiagnosticoAsDoenca)) {
            return false;
        }
        AmbDiagnosticoAsDoenca other = (AmbDiagnosticoAsDoenca) object;
        if ((this.pkIdDiagnosticoDoenca == null && other.pkIdDiagnosticoDoenca != null) || (this.pkIdDiagnosticoDoenca != null && !this.pkIdDiagnosticoDoenca.equals(other.pkIdDiagnosticoDoenca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbDiagnosticoAsDoenca[ pkIdDiagnosticoDoenca=" + pkIdDiagnosticoDoenca + " ]";
    }
    
}
