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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "rh_universidade", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhUniversidade.findAll", query = "SELECT r FROM RhUniversidade r"),
    @NamedQuery(name = "RhUniversidade.findByPkIdUniversidade", query = "SELECT r FROM RhUniversidade r WHERE r.pkIdUniversidade = :pkIdUniversidade"),
    @NamedQuery(name = "RhUniversidade.findByFkIdInstituicao", query = "SELECT r FROM RhUniversidade r WHERE r.fkIdInstituicao = :fkIdInstituicao")})
public class RhUniversidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_universidade")
    private Integer pkIdUniversidade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_id_instituicao")
    private int fkIdInstituicao;

    public RhUniversidade() {
    }

    public RhUniversidade(Integer pkIdUniversidade) {
        this.pkIdUniversidade = pkIdUniversidade;
    }

    public RhUniversidade(Integer pkIdUniversidade, int fkIdInstituicao) {
        this.pkIdUniversidade = pkIdUniversidade;
        this.fkIdInstituicao = fkIdInstituicao;
    }

    public Integer getPkIdUniversidade() {
        return pkIdUniversidade;
    }

    public void setPkIdUniversidade(Integer pkIdUniversidade) {
        this.pkIdUniversidade = pkIdUniversidade;
    }

    public int getFkIdInstituicao() {
        return fkIdInstituicao;
    }

    public void setFkIdInstituicao(int fkIdInstituicao) {
        this.fkIdInstituicao = fkIdInstituicao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdUniversidade != null ? pkIdUniversidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhUniversidade)) {
            return false;
        }
        RhUniversidade other = (RhUniversidade) object;
        if ((this.pkIdUniversidade == null && other.pkIdUniversidade != null) || (this.pkIdUniversidade != null && !this.pkIdUniversidade.equals(other.pkIdUniversidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.RhUniversidade[ pkIdUniversidade=" + pkIdUniversidade + " ]";
    }
    
}
