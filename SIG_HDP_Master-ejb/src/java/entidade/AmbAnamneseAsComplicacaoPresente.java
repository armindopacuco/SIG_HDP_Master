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
@Table(name = "amb_anamnese_as_complicacao_presente", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbAnamneseAsComplicacaoPresente.findAll", query = "SELECT a FROM AmbAnamneseAsComplicacaoPresente a"),
    @NamedQuery(name = "AmbAnamneseAsComplicacaoPresente.findByPkIdAnamneseComplicacao", query = "SELECT a FROM AmbAnamneseAsComplicacaoPresente a WHERE a.pkIdAnamneseComplicacao = :pkIdAnamneseComplicacao")})
public class AmbAnamneseAsComplicacaoPresente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_anamnese_complicacao")
    private Integer pkIdAnamneseComplicacao;
    @JoinColumn(name = "fk_id_complicacao_presente", referencedColumnName = "pk_id_complicacao_presente")
    @ManyToOne(optional = false)
    private AmbComplicacaoPresente fkIdComplicacaoPresente;
    @JoinColumn(name = "fk_id_anamnese", referencedColumnName = "pk_id_anamenese")
    @ManyToOne(optional = false)
    private AmbAnamenese fkIdAnamnese;

    public AmbAnamneseAsComplicacaoPresente() {
    }

    public AmbAnamneseAsComplicacaoPresente(Integer pkIdAnamneseComplicacao) {
        this.pkIdAnamneseComplicacao = pkIdAnamneseComplicacao;
    }

    public Integer getPkIdAnamneseComplicacao() {
        return pkIdAnamneseComplicacao;
    }

    public void setPkIdAnamneseComplicacao(Integer pkIdAnamneseComplicacao) {
        this.pkIdAnamneseComplicacao = pkIdAnamneseComplicacao;
    }

    public AmbComplicacaoPresente getFkIdComplicacaoPresente() {
        return fkIdComplicacaoPresente;
    }

    public void setFkIdComplicacaoPresente(AmbComplicacaoPresente fkIdComplicacaoPresente) {
        this.fkIdComplicacaoPresente = fkIdComplicacaoPresente;
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
        hash += (pkIdAnamneseComplicacao != null ? pkIdAnamneseComplicacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbAnamneseAsComplicacaoPresente)) {
            return false;
        }
        AmbAnamneseAsComplicacaoPresente other = (AmbAnamneseAsComplicacaoPresente) object;
        if ((this.pkIdAnamneseComplicacao == null && other.pkIdAnamneseComplicacao != null) || (this.pkIdAnamneseComplicacao != null && !this.pkIdAnamneseComplicacao.equals(other.pkIdAnamneseComplicacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbAnamneseAsComplicacaoPresente[ pkIdAnamneseComplicacao=" + pkIdAnamneseComplicacao + " ]";
    }
    
}
