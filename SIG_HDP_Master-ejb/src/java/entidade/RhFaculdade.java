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
@Table(name = "rh_faculdade", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhFaculdade.findAll", query = "SELECT r FROM RhFaculdade r"),
    @NamedQuery(name = "RhFaculdade.findByPkIdFaculdade", query = "SELECT r FROM RhFaculdade r WHERE r.pkIdFaculdade = :pkIdFaculdade"),
    @NamedQuery(name = "RhFaculdade.findByDescricao", query = "SELECT r FROM RhFaculdade r WHERE r.descricao = :descricao")})
public class RhFaculdade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_faculdade")
    private Integer pkIdFaculdade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFaculdade")
    private List<RhCurso> rhCursoList;

    public RhFaculdade() {
    }

    public RhFaculdade(Integer pkIdFaculdade) {
        this.pkIdFaculdade = pkIdFaculdade;
    }

    public RhFaculdade(Integer pkIdFaculdade, String descricao) {
        this.pkIdFaculdade = pkIdFaculdade;
        this.descricao = descricao;
    }

    public Integer getPkIdFaculdade() {
        return pkIdFaculdade;
    }

    public void setPkIdFaculdade(Integer pkIdFaculdade) {
        this.pkIdFaculdade = pkIdFaculdade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<RhCurso> getRhCursoList() {
        return rhCursoList;
    }

    public void setRhCursoList(List<RhCurso> rhCursoList) {
        this.rhCursoList = rhCursoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdFaculdade != null ? pkIdFaculdade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhFaculdade)) {
            return false;
        }
        RhFaculdade other = (RhFaculdade) object;
        if ((this.pkIdFaculdade == null && other.pkIdFaculdade != null) || (this.pkIdFaculdade != null && !this.pkIdFaculdade.equals(other.pkIdFaculdade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.RhFaculdade[ pkIdFaculdade=" + pkIdFaculdade + " ]";
    }
    
}
