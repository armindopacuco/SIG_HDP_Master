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
@Table(name = "grl_pais", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrlPais.findAll", query = "SELECT g FROM GrlPais g"),
    @NamedQuery(name = "GrlPais.findByPkIdPais", query = "SELECT g FROM GrlPais g WHERE g.pkIdPais = :pkIdPais"),
    @NamedQuery(name = "GrlPais.findByNomePais", query = "SELECT g FROM GrlPais g WHERE g.nomePais = :nomePais")})
public class GrlPais implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_pais")
    private Integer pkIdPais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome_pais")
    private String nomePais;
    @OneToMany(mappedBy = "fkIdNacionalidade")
    private List<GrlPessoa> grlPessoaList;
    @OneToMany(mappedBy = "fkIdPais")
    private List<GrlFabricante> grlFabricanteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdPais")
    private List<GrlProvincia> grlProvinciaList;

    public GrlPais() {
    }

    public GrlPais(Integer pkIdPais) {
        this.pkIdPais = pkIdPais;
    }

    public GrlPais(Integer pkIdPais, String nomePais) {
        this.pkIdPais = pkIdPais;
        this.nomePais = nomePais;
    }

    public Integer getPkIdPais() {
        return pkIdPais;
    }

    public void setPkIdPais(Integer pkIdPais) {
        this.pkIdPais = pkIdPais;
    }

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }

    @XmlTransient
    public List<GrlPessoa> getGrlPessoaList() {
        return grlPessoaList;
    }

    public void setGrlPessoaList(List<GrlPessoa> grlPessoaList) {
        this.grlPessoaList = grlPessoaList;
    }

    @XmlTransient
    public List<GrlFabricante> getGrlFabricanteList() {
        return grlFabricanteList;
    }

    public void setGrlFabricanteList(List<GrlFabricante> grlFabricanteList) {
        this.grlFabricanteList = grlFabricanteList;
    }

    @XmlTransient
    public List<GrlProvincia> getGrlProvinciaList() {
        return grlProvinciaList;
    }

    public void setGrlProvinciaList(List<GrlProvincia> grlProvinciaList) {
        this.grlProvinciaList = grlProvinciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdPais != null ? pkIdPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrlPais)) {
            return false;
        }
        GrlPais other = (GrlPais) object;
        if ((this.pkIdPais == null && other.pkIdPais != null) || (this.pkIdPais != null && !this.pkIdPais.equals(other.pkIdPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.GrlPais[ pkIdPais=" + pkIdPais + " ]";
    }
    
}
