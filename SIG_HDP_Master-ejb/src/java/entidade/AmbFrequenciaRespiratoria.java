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
@Table(name = "amb_frequencia_respiratoria", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbFrequenciaRespiratoria.findAll", query = "SELECT a FROM AmbFrequenciaRespiratoria a"),
    @NamedQuery(name = "AmbFrequenciaRespiratoria.findByPkIdFrequenciaRespiratoria", query = "SELECT a FROM AmbFrequenciaRespiratoria a WHERE a.pkIdFrequenciaRespiratoria = :pkIdFrequenciaRespiratoria"),
    @NamedQuery(name = "AmbFrequenciaRespiratoria.findByDescricao", query = "SELECT a FROM AmbFrequenciaRespiratoria a WHERE a.descricao = :descricao")})
public class AmbFrequenciaRespiratoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_frequencia_respiratoria")
    private Integer pkIdFrequenciaRespiratoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descricao")
    private String descricao;

    public AmbFrequenciaRespiratoria() {
    }

    public AmbFrequenciaRespiratoria(Integer pkIdFrequenciaRespiratoria) {
        this.pkIdFrequenciaRespiratoria = pkIdFrequenciaRespiratoria;
    }

    public AmbFrequenciaRespiratoria(Integer pkIdFrequenciaRespiratoria, String descricao) {
        this.pkIdFrequenciaRespiratoria = pkIdFrequenciaRespiratoria;
        this.descricao = descricao;
    }

    public Integer getPkIdFrequenciaRespiratoria() {
        return pkIdFrequenciaRespiratoria;
    }

    public void setPkIdFrequenciaRespiratoria(Integer pkIdFrequenciaRespiratoria) {
        this.pkIdFrequenciaRespiratoria = pkIdFrequenciaRespiratoria;
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
        hash += (pkIdFrequenciaRespiratoria != null ? pkIdFrequenciaRespiratoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbFrequenciaRespiratoria)) {
            return false;
        }
        AmbFrequenciaRespiratoria other = (AmbFrequenciaRespiratoria) object;
        if ((this.pkIdFrequenciaRespiratoria == null && other.pkIdFrequenciaRespiratoria != null) || (this.pkIdFrequenciaRespiratoria != null && !this.pkIdFrequenciaRespiratoria.equals(other.pkIdFrequenciaRespiratoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbFrequenciaRespiratoria[ pkIdFrequenciaRespiratoria=" + pkIdFrequenciaRespiratoria + " ]";
    }
    
}
