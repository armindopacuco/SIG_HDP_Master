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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "amb_criterio_clinico", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbCriterioClinico.findAll", query = "SELECT a FROM AmbCriterioClinico a"),
    @NamedQuery(name = "AmbCriterioClinico.findByPkIdCriterioClinico", query = "SELECT a FROM AmbCriterioClinico a WHERE a.pkIdCriterioClinico = :pkIdCriterioClinico"),
    @NamedQuery(name = "AmbCriterioClinico.findByDescricao", query = "SELECT a FROM AmbCriterioClinico a WHERE a.descricao = :descricao")})
public class AmbCriterioClinico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_criterio_clinico")
    private Integer pkIdCriterioClinico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descricao")
    private String descricao;

    public AmbCriterioClinico() {
    }

    public AmbCriterioClinico(Integer pkIdCriterioClinico) {
        this.pkIdCriterioClinico = pkIdCriterioClinico;
    }

    public AmbCriterioClinico(Integer pkIdCriterioClinico, String descricao) {
        this.pkIdCriterioClinico = pkIdCriterioClinico;
        this.descricao = descricao;
    }

    public Integer getPkIdCriterioClinico() {
        return pkIdCriterioClinico;
    }

    public void setPkIdCriterioClinico(Integer pkIdCriterioClinico) {
        this.pkIdCriterioClinico = pkIdCriterioClinico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdCriterioClinico != null ? pkIdCriterioClinico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbCriterioClinico)) {
            return false;
        }
        AmbCriterioClinico other = (AmbCriterioClinico) object;
        if ((this.pkIdCriterioClinico == null && other.pkIdCriterioClinico != null) || (this.pkIdCriterioClinico != null && !this.pkIdCriterioClinico.equals(other.pkIdCriterioClinico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbCriterioClinico[ pkIdCriterioClinico=" + pkIdCriterioClinico + " ]";
    }
    
}
