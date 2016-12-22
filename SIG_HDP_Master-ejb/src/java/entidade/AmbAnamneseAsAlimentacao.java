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
@Table(name = "amb_anamnese_as_alimentacao", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbAnamneseAsAlimentacao.findAll", query = "SELECT a FROM AmbAnamneseAsAlimentacao a"),
    @NamedQuery(name = "AmbAnamneseAsAlimentacao.findByPkIdAnamneseAlimentacao", query = "SELECT a FROM AmbAnamneseAsAlimentacao a WHERE a.pkIdAnamneseAlimentacao = :pkIdAnamneseAlimentacao"),
    @NamedQuery(name = "AmbAnamneseAsAlimentacao.findByOutraAlimentacao", query = "SELECT a FROM AmbAnamneseAsAlimentacao a WHERE a.outraAlimentacao = :outraAlimentacao")})
public class AmbAnamneseAsAlimentacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_anamnese_alimentacao")
    private Integer pkIdAnamneseAlimentacao;
    @Size(max = 100)
    @Column(name = "outra_alimentacao")
    private String outraAlimentacao;
    @JoinColumn(name = "fk_id_alimentacao", referencedColumnName = "pk_id_alimentacao")
    @ManyToOne(optional = false)
    private AmbAlimentacao fkIdAlimentacao;
    @JoinColumn(name = "fk_id_anamnese", referencedColumnName = "pk_id_alimentacao")
    @ManyToOne(optional = false)
    private AmbAlimentacao fkIdAnamnese;

    public AmbAnamneseAsAlimentacao() {
    }

    public AmbAnamneseAsAlimentacao(Integer pkIdAnamneseAlimentacao) {
        this.pkIdAnamneseAlimentacao = pkIdAnamneseAlimentacao;
    }

    public Integer getPkIdAnamneseAlimentacao() {
        return pkIdAnamneseAlimentacao;
    }

    public void setPkIdAnamneseAlimentacao(Integer pkIdAnamneseAlimentacao) {
        this.pkIdAnamneseAlimentacao = pkIdAnamneseAlimentacao;
    }

    public String getOutraAlimentacao() {
        return outraAlimentacao;
    }

    public void setOutraAlimentacao(String outraAlimentacao) {
        this.outraAlimentacao = outraAlimentacao;
    }

    public AmbAlimentacao getFkIdAlimentacao() {
        return fkIdAlimentacao;
    }

    public void setFkIdAlimentacao(AmbAlimentacao fkIdAlimentacao) {
        this.fkIdAlimentacao = fkIdAlimentacao;
    }

    public AmbAlimentacao getFkIdAnamnese() {
        return fkIdAnamnese;
    }

    public void setFkIdAnamnese(AmbAlimentacao fkIdAnamnese) {
        this.fkIdAnamnese = fkIdAnamnese;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdAnamneseAlimentacao != null ? pkIdAnamneseAlimentacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbAnamneseAsAlimentacao)) {
            return false;
        }
        AmbAnamneseAsAlimentacao other = (AmbAnamneseAsAlimentacao) object;
        if ((this.pkIdAnamneseAlimentacao == null && other.pkIdAnamneseAlimentacao != null) || (this.pkIdAnamneseAlimentacao != null && !this.pkIdAnamneseAlimentacao.equals(other.pkIdAnamneseAlimentacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbAnamneseAsAlimentacao[ pkIdAnamneseAlimentacao=" + pkIdAnamneseAlimentacao + " ]";
    }
    
}
