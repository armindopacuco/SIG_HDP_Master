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
@Table(name = "amb_complicacao_presente", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbComplicacaoPresente.findAll", query = "SELECT a FROM AmbComplicacaoPresente a"),
    @NamedQuery(name = "AmbComplicacaoPresente.findByPkIdComplicacaoPresente", query = "SELECT a FROM AmbComplicacaoPresente a WHERE a.pkIdComplicacaoPresente = :pkIdComplicacaoPresente"),
    @NamedQuery(name = "AmbComplicacaoPresente.findByDescricaoCp", query = "SELECT a FROM AmbComplicacaoPresente a WHERE a.descricaoCp = :descricaoCp")})
public class AmbComplicacaoPresente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_complicacao_presente")
    private Integer pkIdComplicacaoPresente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descricao_cp")
    private String descricaoCp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdComplicacaoPresente")
    private List<AmbAnamneseAsComplicacaoPresente> ambAnamneseAsComplicacaoPresenteList;

    public AmbComplicacaoPresente() {
    }

    public AmbComplicacaoPresente(Integer pkIdComplicacaoPresente) {
        this.pkIdComplicacaoPresente = pkIdComplicacaoPresente;
    }

    public AmbComplicacaoPresente(Integer pkIdComplicacaoPresente, String descricaoCp) {
        this.pkIdComplicacaoPresente = pkIdComplicacaoPresente;
        this.descricaoCp = descricaoCp;
    }

    public Integer getPkIdComplicacaoPresente() {
        return pkIdComplicacaoPresente;
    }

    public void setPkIdComplicacaoPresente(Integer pkIdComplicacaoPresente) {
        this.pkIdComplicacaoPresente = pkIdComplicacaoPresente;
    }

    public String getDescricaoCp() {
        return descricaoCp;
    }

    public void setDescricaoCp(String descricaoCp) {
        this.descricaoCp = descricaoCp;
    }

    @XmlTransient
    public List<AmbAnamneseAsComplicacaoPresente> getAmbAnamneseAsComplicacaoPresenteList() {
        return ambAnamneseAsComplicacaoPresenteList;
    }

    public void setAmbAnamneseAsComplicacaoPresenteList(List<AmbAnamneseAsComplicacaoPresente> ambAnamneseAsComplicacaoPresenteList) {
        this.ambAnamneseAsComplicacaoPresenteList = ambAnamneseAsComplicacaoPresenteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdComplicacaoPresente != null ? pkIdComplicacaoPresente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbComplicacaoPresente)) {
            return false;
        }
        AmbComplicacaoPresente other = (AmbComplicacaoPresente) object;
        if ((this.pkIdComplicacaoPresente == null && other.pkIdComplicacaoPresente != null) || (this.pkIdComplicacaoPresente != null && !this.pkIdComplicacaoPresente.equals(other.pkIdComplicacaoPresente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbComplicacaoPresente[ pkIdComplicacaoPresente=" + pkIdComplicacaoPresente + " ]";
    }
    
}
