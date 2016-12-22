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
@Table(name = "amb_anamnese_as_antecedente_pessoal", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbAnamneseAsAntecedentePessoal.findAll", query = "SELECT a FROM AmbAnamneseAsAntecedentePessoal a"),
    @NamedQuery(name = "AmbAnamneseAsAntecedentePessoal.findByPkIdAnamneseAntecedente", query = "SELECT a FROM AmbAnamneseAsAntecedentePessoal a WHERE a.pkIdAnamneseAntecedente = :pkIdAnamneseAntecedente")})
public class AmbAnamneseAsAntecedentePessoal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_anamnese_antecedente")
    private Integer pkIdAnamneseAntecedente;
    @JoinColumn(name = "fk_id_antecedente_pessoal", referencedColumnName = "pk_id_antecedente_pessoal")
    @ManyToOne(optional = false)
    private AmbAntecedentePessoal fkIdAntecedentePessoal;
    @JoinColumn(name = "fk_id_anamnese", referencedColumnName = "pk_id_anamenese")
    @ManyToOne(optional = false)
    private AmbAnamenese fkIdAnamnese;

    public AmbAnamneseAsAntecedentePessoal() {
    }

    public AmbAnamneseAsAntecedentePessoal(Integer pkIdAnamneseAntecedente) {
        this.pkIdAnamneseAntecedente = pkIdAnamneseAntecedente;
    }

    public Integer getPkIdAnamneseAntecedente() {
        return pkIdAnamneseAntecedente;
    }

    public void setPkIdAnamneseAntecedente(Integer pkIdAnamneseAntecedente) {
        this.pkIdAnamneseAntecedente = pkIdAnamneseAntecedente;
    }

    public AmbAntecedentePessoal getFkIdAntecedentePessoal() {
        return fkIdAntecedentePessoal;
    }

    public void setFkIdAntecedentePessoal(AmbAntecedentePessoal fkIdAntecedentePessoal) {
        this.fkIdAntecedentePessoal = fkIdAntecedentePessoal;
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
        hash += (pkIdAnamneseAntecedente != null ? pkIdAnamneseAntecedente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbAnamneseAsAntecedentePessoal)) {
            return false;
        }
        AmbAnamneseAsAntecedentePessoal other = (AmbAnamneseAsAntecedentePessoal) object;
        if ((this.pkIdAnamneseAntecedente == null && other.pkIdAnamneseAntecedente != null) || (this.pkIdAnamneseAntecedente != null && !this.pkIdAnamneseAntecedente.equals(other.pkIdAnamneseAntecedente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbAnamneseAsAntecedentePessoal[ pkIdAnamneseAntecedente=" + pkIdAnamneseAntecedente + " ]";
    }
    
}
