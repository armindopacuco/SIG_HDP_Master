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
@Table(name = "grl_instituicao", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrlInstituicao.findAll", query = "SELECT g FROM GrlInstituicao g"),
    @NamedQuery(name = "GrlInstituicao.findByPkIdInstituicao", query = "SELECT g FROM GrlInstituicao g WHERE g.pkIdInstituicao = :pkIdInstituicao"),
    @NamedQuery(name = "GrlInstituicao.findByCodigoInstituicao", query = "SELECT g FROM GrlInstituicao g WHERE g.codigoInstituicao = :codigoInstituicao"),
    @NamedQuery(name = "GrlInstituicao.findByDescricao", query = "SELECT g FROM GrlInstituicao g WHERE g.descricao = :descricao")})
public class GrlInstituicao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_instituicao")
    private Integer pkIdInstituicao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigo_instituicao")
    private String codigoInstituicao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdInstituicao")
    private List<FarmArmazenamento> farmArmazenamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grlInstituicao")
    private List<MorgueEntradaCorpo> morgueEntradaCorpoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdInstituicao")
    private List<GrlCentroHospitalar> grlCentroHospitalarList;
    @JoinColumn(name = "fk_id_endereco", referencedColumnName = "pk_id_endereco")
    @ManyToOne(optional = false)
    private GrlEndereco fkIdEndereco;
    @JoinColumn(name = "fk_id_contacto", referencedColumnName = "pk_id_contacto")
    @ManyToOne(optional = false)
    private GrlContacto fkIdContacto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grlInstituicao")
    private List<MorgueSaidaCorpo> morgueSaidaCorpoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdInstituicao")
    private List<GrlFornecedor> grlFornecedorList;
    @OneToMany(mappedBy = "fkIdInstituicaoUltimaDadiva")
    private List<DiagDador> diagDadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdInstituicao")
    private List<GrlConvenio> grlConvenioList;

    public GrlInstituicao() {
    }

    public GrlInstituicao(Integer pkIdInstituicao) {
        this.pkIdInstituicao = pkIdInstituicao;
    }

    public GrlInstituicao(Integer pkIdInstituicao, String codigoInstituicao, String descricao) {
        this.pkIdInstituicao = pkIdInstituicao;
        this.codigoInstituicao = codigoInstituicao;
        this.descricao = descricao;
    }

    public Integer getPkIdInstituicao() {
        return pkIdInstituicao;
    }

    public void setPkIdInstituicao(Integer pkIdInstituicao) {
        this.pkIdInstituicao = pkIdInstituicao;
    }

    public String getCodigoInstituicao() {
        return codigoInstituicao;
    }

    public void setCodigoInstituicao(String codigoInstituicao) {
        this.codigoInstituicao = codigoInstituicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<FarmArmazenamento> getFarmArmazenamentoList() {
        return farmArmazenamentoList;
    }

    public void setFarmArmazenamentoList(List<FarmArmazenamento> farmArmazenamentoList) {
        this.farmArmazenamentoList = farmArmazenamentoList;
    }

    @XmlTransient
    public List<MorgueEntradaCorpo> getMorgueEntradaCorpoList() {
        return morgueEntradaCorpoList;
    }

    public void setMorgueEntradaCorpoList(List<MorgueEntradaCorpo> morgueEntradaCorpoList) {
        this.morgueEntradaCorpoList = morgueEntradaCorpoList;
    }

    @XmlTransient
    public List<GrlCentroHospitalar> getGrlCentroHospitalarList() {
        return grlCentroHospitalarList;
    }

    public void setGrlCentroHospitalarList(List<GrlCentroHospitalar> grlCentroHospitalarList) {
        this.grlCentroHospitalarList = grlCentroHospitalarList;
    }

    public GrlEndereco getFkIdEndereco() {
        return fkIdEndereco;
    }

    public void setFkIdEndereco(GrlEndereco fkIdEndereco) {
        this.fkIdEndereco = fkIdEndereco;
    }

    public GrlContacto getFkIdContacto() {
        return fkIdContacto;
    }

    public void setFkIdContacto(GrlContacto fkIdContacto) {
        this.fkIdContacto = fkIdContacto;
    }

    @XmlTransient
    public List<MorgueSaidaCorpo> getMorgueSaidaCorpoList() {
        return morgueSaidaCorpoList;
    }

    public void setMorgueSaidaCorpoList(List<MorgueSaidaCorpo> morgueSaidaCorpoList) {
        this.morgueSaidaCorpoList = morgueSaidaCorpoList;
    }

    @XmlTransient
    public List<GrlFornecedor> getGrlFornecedorList() {
        return grlFornecedorList;
    }

    public void setGrlFornecedorList(List<GrlFornecedor> grlFornecedorList) {
        this.grlFornecedorList = grlFornecedorList;
    }

    @XmlTransient
    public List<DiagDador> getDiagDadorList() {
        return diagDadorList;
    }

    public void setDiagDadorList(List<DiagDador> diagDadorList) {
        this.diagDadorList = diagDadorList;
    }

    @XmlTransient
    public List<GrlConvenio> getGrlConvenioList() {
        return grlConvenioList;
    }

    public void setGrlConvenioList(List<GrlConvenio> grlConvenioList) {
        this.grlConvenioList = grlConvenioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdInstituicao != null ? pkIdInstituicao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrlInstituicao)) {
            return false;
        }
        GrlInstituicao other = (GrlInstituicao) object;
        if ((this.pkIdInstituicao == null && other.pkIdInstituicao != null) || (this.pkIdInstituicao != null && !this.pkIdInstituicao.equals(other.pkIdInstituicao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.GrlInstituicao[ pkIdInstituicao=" + pkIdInstituicao + " ]";
    }
    
}
