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
@Table(name = "grl_estado_convenio", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrlEstadoConvenio.findAll", query = "SELECT g FROM GrlEstadoConvenio g"),
    @NamedQuery(name = "GrlEstadoConvenio.findByPkIdEstadoConvenio", query = "SELECT g FROM GrlEstadoConvenio g WHERE g.pkIdEstadoConvenio = :pkIdEstadoConvenio"),
    @NamedQuery(name = "GrlEstadoConvenio.findByCodigoEstadoConvenio", query = "SELECT g FROM GrlEstadoConvenio g WHERE g.codigoEstadoConvenio = :codigoEstadoConvenio"),
    @NamedQuery(name = "GrlEstadoConvenio.findByDescricao", query = "SELECT g FROM GrlEstadoConvenio g WHERE g.descricao = :descricao")})
public class GrlEstadoConvenio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_estado_convenio")
    private Integer pkIdEstadoConvenio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigo_estado_convenio")
    private String codigoEstadoConvenio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdEstadoConvenio")
    private List<GrlConvenio> grlConvenioList;

    public GrlEstadoConvenio() {
    }

    public GrlEstadoConvenio(Integer pkIdEstadoConvenio) {
        this.pkIdEstadoConvenio = pkIdEstadoConvenio;
    }

    public GrlEstadoConvenio(Integer pkIdEstadoConvenio, String codigoEstadoConvenio, String descricao) {
        this.pkIdEstadoConvenio = pkIdEstadoConvenio;
        this.codigoEstadoConvenio = codigoEstadoConvenio;
        this.descricao = descricao;
    }

    public Integer getPkIdEstadoConvenio() {
        return pkIdEstadoConvenio;
    }

    public void setPkIdEstadoConvenio(Integer pkIdEstadoConvenio) {
        this.pkIdEstadoConvenio = pkIdEstadoConvenio;
    }

    public String getCodigoEstadoConvenio() {
        return codigoEstadoConvenio;
    }

    public void setCodigoEstadoConvenio(String codigoEstadoConvenio) {
        this.codigoEstadoConvenio = codigoEstadoConvenio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        hash += (pkIdEstadoConvenio != null ? pkIdEstadoConvenio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrlEstadoConvenio)) {
            return false;
        }
        GrlEstadoConvenio other = (GrlEstadoConvenio) object;
        if ((this.pkIdEstadoConvenio == null && other.pkIdEstadoConvenio != null) || (this.pkIdEstadoConvenio != null && !this.pkIdEstadoConvenio.equals(other.pkIdEstadoConvenio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.GrlEstadoConvenio[ pkIdEstadoConvenio=" + pkIdEstadoConvenio + " ]";
    }
    
}
