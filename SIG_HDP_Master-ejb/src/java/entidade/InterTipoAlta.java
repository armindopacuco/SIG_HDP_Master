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
@Table(name = "inter_tipo_alta", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterTipoAlta.findAll", query = "SELECT i FROM InterTipoAlta i"),
    @NamedQuery(name = "InterTipoAlta.findByPkIdTipoAlta", query = "SELECT i FROM InterTipoAlta i WHERE i.pkIdTipoAlta = :pkIdTipoAlta"),
    @NamedQuery(name = "InterTipoAlta.findByDescricao", query = "SELECT i FROM InterTipoAlta i WHERE i.descricao = :descricao")})
public class InterTipoAlta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_tipo_alta")
    private Integer pkIdTipoAlta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descricao")
    private String descricao;

    public InterTipoAlta() {
    }

    public InterTipoAlta(Integer pkIdTipoAlta) {
        this.pkIdTipoAlta = pkIdTipoAlta;
    }

    public InterTipoAlta(Integer pkIdTipoAlta, String descricao) {
        this.pkIdTipoAlta = pkIdTipoAlta;
        this.descricao = descricao;
    }

    public Integer getPkIdTipoAlta() {
        return pkIdTipoAlta;
    }

    public void setPkIdTipoAlta(Integer pkIdTipoAlta) {
        this.pkIdTipoAlta = pkIdTipoAlta;
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
        hash += (pkIdTipoAlta != null ? pkIdTipoAlta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterTipoAlta)) {
            return false;
        }
        InterTipoAlta other = (InterTipoAlta) object;
        if ((this.pkIdTipoAlta == null && other.pkIdTipoAlta != null) || (this.pkIdTipoAlta != null && !this.pkIdTipoAlta.equals(other.pkIdTipoAlta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.InterTipoAlta[ pkIdTipoAlta=" + pkIdTipoAlta + " ]";
    }
    
}
