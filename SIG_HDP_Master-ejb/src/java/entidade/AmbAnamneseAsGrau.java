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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "amb_anamnese_as_grau", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbAnamneseAsGrau.findAll", query = "SELECT a FROM AmbAnamneseAsGrau a"),
    @NamedQuery(name = "AmbAnamneseAsGrau.findByPkIdAnamneseGrau", query = "SELECT a FROM AmbAnamneseAsGrau a WHERE a.pkIdAnamneseGrau = :pkIdAnamneseGrau")})
public class AmbAnamneseAsGrau implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_anamnese_grau")
    private Integer pkIdAnamneseGrau;
    @JoinColumn(name = "fk_id_grau_parentesco", referencedColumnName = "pk_id_grau_parentesco")
    @ManyToOne(optional = false)
    private AmbGrauParentesco fkIdGrauParentesco;
    @JoinColumn(name = "fk_id_anamnese", referencedColumnName = "pk_id_anamenese")
    @ManyToOne(optional = false)
    private AmbAnamenese fkIdAnamnese;

    public AmbAnamneseAsGrau() {
    }

    public AmbAnamneseAsGrau(Integer pkIdAnamneseGrau) {
        this.pkIdAnamneseGrau = pkIdAnamneseGrau;
    }

    public Integer getPkIdAnamneseGrau() {
        return pkIdAnamneseGrau;
    }

    public void setPkIdAnamneseGrau(Integer pkIdAnamneseGrau) {
        this.pkIdAnamneseGrau = pkIdAnamneseGrau;
    }

    public AmbGrauParentesco getFkIdGrauParentesco() {
        return fkIdGrauParentesco;
    }

    public void setFkIdGrauParentesco(AmbGrauParentesco fkIdGrauParentesco) {
        this.fkIdGrauParentesco = fkIdGrauParentesco;
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
        hash += (pkIdAnamneseGrau != null ? pkIdAnamneseGrau.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbAnamneseAsGrau)) {
            return false;
        }
        AmbAnamneseAsGrau other = (AmbAnamneseAsGrau) object;
        if ((this.pkIdAnamneseGrau == null && other.pkIdAnamneseGrau != null) || (this.pkIdAnamneseGrau != null && !this.pkIdAnamneseGrau.equals(other.pkIdAnamneseGrau))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbAnamneseAsGrau[ pkIdAnamneseGrau=" + pkIdAnamneseGrau + " ]";
    }
    
}
