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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "grl_endereco", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrlEndereco.findAll", query = "SELECT g FROM GrlEndereco g"),
    @NamedQuery(name = "GrlEndereco.findByPkIdEndereco", query = "SELECT g FROM GrlEndereco g WHERE g.pkIdEndereco = :pkIdEndereco"),
    @NamedQuery(name = "GrlEndereco.findByBairro", query = "SELECT g FROM GrlEndereco g WHERE g.bairro = :bairro"),
    @NamedQuery(name = "GrlEndereco.findByNumeroCasa", query = "SELECT g FROM GrlEndereco g WHERE g.numeroCasa = :numeroCasa")})
public class GrlEndereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_endereco")
    private Integer pkIdEndereco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "bairro")
    private String bairro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "numero_casa")
    private String numeroCasa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdEndereco")
    private List<GrlPessoa> grlPessoaList;
    @JoinColumn(name = "fk_id_municipio", referencedColumnName = "pk_id_municipio")
    @ManyToOne(optional = false)
    private GrlMunicipio fkIdMunicipio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdEndereco")
    private List<GrlInstituicao> grlInstituicaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdEndereco")
    private List<SupiFormacao> supiFormacaoList;

    public GrlEndereco() {
    }

    public GrlEndereco(Integer pkIdEndereco) {
        this.pkIdEndereco = pkIdEndereco;
    }

    public GrlEndereco(Integer pkIdEndereco, String bairro, String numeroCasa) {
        this.pkIdEndereco = pkIdEndereco;
        this.bairro = bairro;
        this.numeroCasa = numeroCasa;
    }

    public Integer getPkIdEndereco() {
        return pkIdEndereco;
    }

    public void setPkIdEndereco(Integer pkIdEndereco) {
        this.pkIdEndereco = pkIdEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    @XmlTransient
    public List<GrlPessoa> getGrlPessoaList() {
        return grlPessoaList;
    }

    public void setGrlPessoaList(List<GrlPessoa> grlPessoaList) {
        this.grlPessoaList = grlPessoaList;
    }

    public GrlMunicipio getFkIdMunicipio() {
        return fkIdMunicipio;
    }

    public void setFkIdMunicipio(GrlMunicipio fkIdMunicipio) {
        this.fkIdMunicipio = fkIdMunicipio;
    }

    @XmlTransient
    public List<GrlInstituicao> getGrlInstituicaoList() {
        return grlInstituicaoList;
    }

    public void setGrlInstituicaoList(List<GrlInstituicao> grlInstituicaoList) {
        this.grlInstituicaoList = grlInstituicaoList;
    }

    @XmlTransient
    public List<SupiFormacao> getSupiFormacaoList() {
        return supiFormacaoList;
    }

    public void setSupiFormacaoList(List<SupiFormacao> supiFormacaoList) {
        this.supiFormacaoList = supiFormacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdEndereco != null ? pkIdEndereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrlEndereco)) {
            return false;
        }
        GrlEndereco other = (GrlEndereco) object;
        if ((this.pkIdEndereco == null && other.pkIdEndereco != null) || (this.pkIdEndereco != null && !this.pkIdEndereco.equals(other.pkIdEndereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.GrlEndereco[ pkIdEndereco=" + pkIdEndereco + " ]";
    }
    
}
