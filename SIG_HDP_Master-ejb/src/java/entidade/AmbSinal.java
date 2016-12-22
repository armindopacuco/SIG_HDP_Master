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
@Table(name = "amb_sinal", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbSinal.findAll", query = "SELECT a FROM AmbSinal a"),
    @NamedQuery(name = "AmbSinal.findByPkIdSinal", query = "SELECT a FROM AmbSinal a WHERE a.pkIdSinal = :pkIdSinal"),
    @NamedQuery(name = "AmbSinal.findByDescricao", query = "SELECT a FROM AmbSinal a WHERE a.descricao = :descricao")})
public class AmbSinal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_sinal")
    private Integer pkIdSinal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdSinal")
    private List<AmbTriagemAsSinal> ambTriagemAsSinalList;

    public AmbSinal() {
    }

    public AmbSinal(Integer pkIdSinal) {
        this.pkIdSinal = pkIdSinal;
    }

    public AmbSinal(Integer pkIdSinal, String descricao) {
        this.pkIdSinal = pkIdSinal;
        this.descricao = descricao;
    }

    public Integer getPkIdSinal() {
        return pkIdSinal;
    }

    public void setPkIdSinal(Integer pkIdSinal) {
        this.pkIdSinal = pkIdSinal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<AmbTriagemAsSinal> getAmbTriagemAsSinalList() {
        return ambTriagemAsSinalList;
    }

    public void setAmbTriagemAsSinalList(List<AmbTriagemAsSinal> ambTriagemAsSinalList) {
        this.ambTriagemAsSinalList = ambTriagemAsSinalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdSinal != null ? pkIdSinal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbSinal)) {
            return false;
        }
        AmbSinal other = (AmbSinal) object;
        if ((this.pkIdSinal == null && other.pkIdSinal != null) || (this.pkIdSinal != null && !this.pkIdSinal.equals(other.pkIdSinal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbSinal[ pkIdSinal=" + pkIdSinal + " ]";
    }
    
}
