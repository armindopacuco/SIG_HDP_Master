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
@Table(name = "amb_anamnese_as_doenca", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbAnamneseAsDoenca.findAll", query = "SELECT a FROM AmbAnamneseAsDoenca a"),
    @NamedQuery(name = "AmbAnamneseAsDoenca.findByPkIdAnamneseAsDoenca", query = "SELECT a FROM AmbAnamneseAsDoenca a WHERE a.pkIdAnamneseAsDoenca = :pkIdAnamneseAsDoenca"),
    @NamedQuery(name = "AmbAnamneseAsDoenca.findByDoencas", query = "SELECT a FROM AmbAnamneseAsDoenca a WHERE a.doencas = :doencas")})
public class AmbAnamneseAsDoenca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_anamnese_as_doenca")
    private Integer pkIdAnamneseAsDoenca;
    @Size(max = 500)
    @Column(name = "doencas")
    private String doencas;
    @JoinColumn(name = "fk_id_anamnese", referencedColumnName = "pk_id_anamenese")
    @ManyToOne(optional = false)
    private AmbAnamenese fkIdAnamnese;

    public AmbAnamneseAsDoenca() {
    }

    public AmbAnamneseAsDoenca(Integer pkIdAnamneseAsDoenca) {
        this.pkIdAnamneseAsDoenca = pkIdAnamneseAsDoenca;
    }

    public Integer getPkIdAnamneseAsDoenca() {
        return pkIdAnamneseAsDoenca;
    }

    public void setPkIdAnamneseAsDoenca(Integer pkIdAnamneseAsDoenca) {
        this.pkIdAnamneseAsDoenca = pkIdAnamneseAsDoenca;
    }

    public String getDoencas() {
        return doencas;
    }

    public void setDoencas(String doencas) {
        this.doencas = doencas;
    }

    public AmbAnamenese getFkIdAnamnese() {
        return fkIdAnamnese;
    }

    public void setFkIdAnamnese(AmbAnamenese fkIdAnamnese) {
        this.fkIdAnamnese = fkIdAnamnese;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdAnamneseAsDoenca != null ? pkIdAnamneseAsDoenca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbAnamneseAsDoenca)) {
            return false;
        }
        AmbAnamneseAsDoenca other = (AmbAnamneseAsDoenca) object;
        if ((this.pkIdAnamneseAsDoenca == null && other.pkIdAnamneseAsDoenca != null) || (this.pkIdAnamneseAsDoenca != null && !this.pkIdAnamneseAsDoenca.equals(other.pkIdAnamneseAsDoenca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbAnamneseAsDoenca[ pkIdAnamneseAsDoenca=" + pkIdAnamneseAsDoenca + " ]";
    }
    
}
