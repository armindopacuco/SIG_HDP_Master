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
@Table(name = "morgue_proveniencia", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MorgueProveniencia.findAll", query = "SELECT m FROM MorgueProveniencia m"),
    @NamedQuery(name = "MorgueProveniencia.findByPkIdProveniencia", query = "SELECT m FROM MorgueProveniencia m WHERE m.pkIdProveniencia = :pkIdProveniencia"),
    @NamedQuery(name = "MorgueProveniencia.findByDescricao", query = "SELECT m FROM MorgueProveniencia m WHERE m.descricao = :descricao")})
public class MorgueProveniencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_proveniencia")
    private Integer pkIdProveniencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "morgueProveniencia")
    private List<MorgueEntradaCorpo> morgueEntradaCorpoList;

    public MorgueProveniencia() {
    }

    public MorgueProveniencia(Integer pkIdProveniencia) {
        this.pkIdProveniencia = pkIdProveniencia;
    }

    public MorgueProveniencia(Integer pkIdProveniencia, String descricao) {
        this.pkIdProveniencia = pkIdProveniencia;
        this.descricao = descricao;
    }

    public Integer getPkIdProveniencia() {
        return pkIdProveniencia;
    }

    public void setPkIdProveniencia(Integer pkIdProveniencia) {
        this.pkIdProveniencia = pkIdProveniencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<MorgueEntradaCorpo> getMorgueEntradaCorpoList() {
        return morgueEntradaCorpoList;
    }

    public void setMorgueEntradaCorpoList(List<MorgueEntradaCorpo> morgueEntradaCorpoList) {
        this.morgueEntradaCorpoList = morgueEntradaCorpoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdProveniencia != null ? pkIdProveniencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MorgueProveniencia)) {
            return false;
        }
        MorgueProveniencia other = (MorgueProveniencia) object;
        if ((this.pkIdProveniencia == null && other.pkIdProveniencia != null) || (this.pkIdProveniencia != null && !this.pkIdProveniencia.equals(other.pkIdProveniencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.MorgueProveniencia[ pkIdProveniencia=" + pkIdProveniencia + " ]";
    }
    
}
