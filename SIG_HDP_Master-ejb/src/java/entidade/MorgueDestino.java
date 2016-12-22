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
@Table(name = "morgue_destino", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MorgueDestino.findAll", query = "SELECT m FROM MorgueDestino m"),
    @NamedQuery(name = "MorgueDestino.findByPkIdDestino", query = "SELECT m FROM MorgueDestino m WHERE m.pkIdDestino = :pkIdDestino"),
    @NamedQuery(name = "MorgueDestino.findByDescricao", query = "SELECT m FROM MorgueDestino m WHERE m.descricao = :descricao")})
public class MorgueDestino implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_destino")
    private Integer pkIdDestino;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "morgueDestino")
    private List<MorgueSaidaCorpo> morgueSaidaCorpoList;

    public MorgueDestino() {
    }

    public MorgueDestino(Integer pkIdDestino) {
        this.pkIdDestino = pkIdDestino;
    }

    public MorgueDestino(Integer pkIdDestino, String descricao) {
        this.pkIdDestino = pkIdDestino;
        this.descricao = descricao;
    }

    public Integer getPkIdDestino() {
        return pkIdDestino;
    }

    public void setPkIdDestino(Integer pkIdDestino) {
        this.pkIdDestino = pkIdDestino;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<MorgueSaidaCorpo> getMorgueSaidaCorpoList() {
        return morgueSaidaCorpoList;
    }

    public void setMorgueSaidaCorpoList(List<MorgueSaidaCorpo> morgueSaidaCorpoList) {
        this.morgueSaidaCorpoList = morgueSaidaCorpoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdDestino != null ? pkIdDestino.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MorgueDestino)) {
            return false;
        }
        MorgueDestino other = (MorgueDestino) object;
        if ((this.pkIdDestino == null && other.pkIdDestino != null) || (this.pkIdDestino != null && !this.pkIdDestino.equals(other.pkIdDestino))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.MorgueDestino[ pkIdDestino=" + pkIdDestino + " ]";
    }
    
}
