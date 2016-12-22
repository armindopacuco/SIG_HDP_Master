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
@Table(name = "amb_tipo_cuidado", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbTipoCuidado.findAll", query = "SELECT a FROM AmbTipoCuidado a"),
    @NamedQuery(name = "AmbTipoCuidado.findByPkIdTipoCuidado", query = "SELECT a FROM AmbTipoCuidado a WHERE a.pkIdTipoCuidado = :pkIdTipoCuidado"),
    @NamedQuery(name = "AmbTipoCuidado.findByDescricao", query = "SELECT a FROM AmbTipoCuidado a WHERE a.descricao = :descricao")})
public class AmbTipoCuidado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_tipo_cuidado")
    private Integer pkIdTipoCuidado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdTipoCuidado")
    private List<AmbCuidado> ambCuidadoList;

    public AmbTipoCuidado() {
    }

    public AmbTipoCuidado(Integer pkIdTipoCuidado) {
        this.pkIdTipoCuidado = pkIdTipoCuidado;
    }

    public AmbTipoCuidado(Integer pkIdTipoCuidado, String descricao) {
        this.pkIdTipoCuidado = pkIdTipoCuidado;
        this.descricao = descricao;
    }

    public Integer getPkIdTipoCuidado() {
        return pkIdTipoCuidado;
    }

    public void setPkIdTipoCuidado(Integer pkIdTipoCuidado) {
        this.pkIdTipoCuidado = pkIdTipoCuidado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<AmbCuidado> getAmbCuidadoList() {
        return ambCuidadoList;
    }

    public void setAmbCuidadoList(List<AmbCuidado> ambCuidadoList) {
        this.ambCuidadoList = ambCuidadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdTipoCuidado != null ? pkIdTipoCuidado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbTipoCuidado)) {
            return false;
        }
        AmbTipoCuidado other = (AmbTipoCuidado) object;
        if ((this.pkIdTipoCuidado == null && other.pkIdTipoCuidado != null) || (this.pkIdTipoCuidado != null && !this.pkIdTipoCuidado.equals(other.pkIdTipoCuidado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbTipoCuidado[ pkIdTipoCuidado=" + pkIdTipoCuidado + " ]";
    }
    
}
