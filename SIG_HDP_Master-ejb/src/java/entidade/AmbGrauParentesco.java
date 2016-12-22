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
@Table(name = "amb_grau_parentesco", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbGrauParentesco.findAll", query = "SELECT a FROM AmbGrauParentesco a"),
    @NamedQuery(name = "AmbGrauParentesco.findByPkIdGrauParentesco", query = "SELECT a FROM AmbGrauParentesco a WHERE a.pkIdGrauParentesco = :pkIdGrauParentesco"),
    @NamedQuery(name = "AmbGrauParentesco.findByDescricao", query = "SELECT a FROM AmbGrauParentesco a WHERE a.descricao = :descricao")})
public class AmbGrauParentesco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_grau_parentesco")
    private Integer pkIdGrauParentesco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdGrauParentesco")
    private List<AmbAnamneseAsGrau> ambAnamneseAsGrauList;

    public AmbGrauParentesco() {
    }

    public AmbGrauParentesco(Integer pkIdGrauParentesco) {
        this.pkIdGrauParentesco = pkIdGrauParentesco;
    }

    public AmbGrauParentesco(Integer pkIdGrauParentesco, String descricao) {
        this.pkIdGrauParentesco = pkIdGrauParentesco;
        this.descricao = descricao;
    }

    public Integer getPkIdGrauParentesco() {
        return pkIdGrauParentesco;
    }

    public void setPkIdGrauParentesco(Integer pkIdGrauParentesco) {
        this.pkIdGrauParentesco = pkIdGrauParentesco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<AmbAnamneseAsGrau> getAmbAnamneseAsGrauList() {
        return ambAnamneseAsGrauList;
    }

    public void setAmbAnamneseAsGrauList(List<AmbAnamneseAsGrau> ambAnamneseAsGrauList) {
        this.ambAnamneseAsGrauList = ambAnamneseAsGrauList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdGrauParentesco != null ? pkIdGrauParentesco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbGrauParentesco)) {
            return false;
        }
        AmbGrauParentesco other = (AmbGrauParentesco) object;
        if ((this.pkIdGrauParentesco == null && other.pkIdGrauParentesco != null) || (this.pkIdGrauParentesco != null && !this.pkIdGrauParentesco.equals(other.pkIdGrauParentesco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbGrauParentesco[ pkIdGrauParentesco=" + pkIdGrauParentesco + " ]";
    }
    
}
