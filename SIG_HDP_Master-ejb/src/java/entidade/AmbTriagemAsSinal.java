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
@Table(name = "amb_triagem_as_sinal", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbTriagemAsSinal.findAll", query = "SELECT a FROM AmbTriagemAsSinal a"),
    @NamedQuery(name = "AmbTriagemAsSinal.findByPkIdTriagemSinal", query = "SELECT a FROM AmbTriagemAsSinal a WHERE a.pkIdTriagemSinal = :pkIdTriagemSinal")})
public class AmbTriagemAsSinal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_triagem_sinal")
    private Integer pkIdTriagemSinal;
    @JoinColumn(name = "fk_pk_id_triagem", referencedColumnName = "pk_id_triagem")
    @ManyToOne(optional = false)
    private AmbTriagem fkPkIdTriagem;
    @JoinColumn(name = "fk_id_sinal", referencedColumnName = "pk_id_sinal")
    @ManyToOne(optional = false)
    private AmbSinal fkIdSinal;

    public AmbTriagemAsSinal() {
    }

    public AmbTriagemAsSinal(Integer pkIdTriagemSinal) {
        this.pkIdTriagemSinal = pkIdTriagemSinal;
    }

    public Integer getPkIdTriagemSinal() {
        return pkIdTriagemSinal;
    }

    public void setPkIdTriagemSinal(Integer pkIdTriagemSinal) {
        this.pkIdTriagemSinal = pkIdTriagemSinal;
    }

    public AmbTriagem getFkPkIdTriagem() {
        return fkPkIdTriagem;
    }

    public void setFkPkIdTriagem(AmbTriagem fkPkIdTriagem) {
        this.fkPkIdTriagem = fkPkIdTriagem;
    }

    public AmbSinal getFkIdSinal() {
        return fkIdSinal;
    }

    public void setFkIdSinal(AmbSinal fkIdSinal) {
        this.fkIdSinal = fkIdSinal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdTriagemSinal != null ? pkIdTriagemSinal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbTriagemAsSinal)) {
            return false;
        }
        AmbTriagemAsSinal other = (AmbTriagemAsSinal) object;
        if ((this.pkIdTriagemSinal == null && other.pkIdTriagemSinal != null) || (this.pkIdTriagemSinal != null && !this.pkIdTriagemSinal.equals(other.pkIdTriagemSinal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbTriagemAsSinal[ pkIdTriagemSinal=" + pkIdTriagemSinal + " ]";
    }
    
}
