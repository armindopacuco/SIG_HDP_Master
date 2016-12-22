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
@Table(name = "amb_antecedente_pessoal", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbAntecedentePessoal.findAll", query = "SELECT a FROM AmbAntecedentePessoal a"),
    @NamedQuery(name = "AmbAntecedentePessoal.findByPkIdAntecedentePessoal", query = "SELECT a FROM AmbAntecedentePessoal a WHERE a.pkIdAntecedentePessoal = :pkIdAntecedentePessoal"),
    @NamedQuery(name = "AmbAntecedentePessoal.findByDescricaoAp", query = "SELECT a FROM AmbAntecedentePessoal a WHERE a.descricaoAp = :descricaoAp")})
public class AmbAntecedentePessoal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_antecedente_pessoal")
    private Integer pkIdAntecedentePessoal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descricao_ap")
    private String descricaoAp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdAntecedentePessoal")
    private List<AmbAnamneseAsAntecedentePessoal> ambAnamneseAsAntecedentePessoalList;

    public AmbAntecedentePessoal() {
    }

    public AmbAntecedentePessoal(Integer pkIdAntecedentePessoal) {
        this.pkIdAntecedentePessoal = pkIdAntecedentePessoal;
    }

    public AmbAntecedentePessoal(Integer pkIdAntecedentePessoal, String descricaoAp) {
        this.pkIdAntecedentePessoal = pkIdAntecedentePessoal;
        this.descricaoAp = descricaoAp;
    }

    public Integer getPkIdAntecedentePessoal() {
        return pkIdAntecedentePessoal;
    }

    public void setPkIdAntecedentePessoal(Integer pkIdAntecedentePessoal) {
        this.pkIdAntecedentePessoal = pkIdAntecedentePessoal;
    }

    public String getDescricaoAp() {
        return descricaoAp;
    }

    public void setDescricaoAp(String descricaoAp) {
        this.descricaoAp = descricaoAp;
    }

    @XmlTransient
    public List<AmbAnamneseAsAntecedentePessoal> getAmbAnamneseAsAntecedentePessoalList() {
        return ambAnamneseAsAntecedentePessoalList;
    }

    public void setAmbAnamneseAsAntecedentePessoalList(List<AmbAnamneseAsAntecedentePessoal> ambAnamneseAsAntecedentePessoalList) {
        this.ambAnamneseAsAntecedentePessoalList = ambAnamneseAsAntecedentePessoalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdAntecedentePessoal != null ? pkIdAntecedentePessoal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbAntecedentePessoal)) {
            return false;
        }
        AmbAntecedentePessoal other = (AmbAntecedentePessoal) object;
        if ((this.pkIdAntecedentePessoal == null && other.pkIdAntecedentePessoal != null) || (this.pkIdAntecedentePessoal != null && !this.pkIdAntecedentePessoal.equals(other.pkIdAntecedentePessoal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbAntecedentePessoal[ pkIdAntecedentePessoal=" + pkIdAntecedentePessoal + " ]";
    }
    
}
