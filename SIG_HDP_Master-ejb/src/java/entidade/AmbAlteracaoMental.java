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
@Table(name = "amb_alteracao_mental", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbAlteracaoMental.findAll", query = "SELECT a FROM AmbAlteracaoMental a"),
    @NamedQuery(name = "AmbAlteracaoMental.findByPkIdAlteracaoMental", query = "SELECT a FROM AmbAlteracaoMental a WHERE a.pkIdAlteracaoMental = :pkIdAlteracaoMental"),
    @NamedQuery(name = "AmbAlteracaoMental.findByDescricao", query = "SELECT a FROM AmbAlteracaoMental a WHERE a.descricao = :descricao")})
public class AmbAlteracaoMental implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_alteracao_mental")
    private Integer pkIdAlteracaoMental;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descricao")
    private String descricao;

    public AmbAlteracaoMental() {
    }

    public AmbAlteracaoMental(Integer pkIdAlteracaoMental) {
        this.pkIdAlteracaoMental = pkIdAlteracaoMental;
    }

    public AmbAlteracaoMental(Integer pkIdAlteracaoMental, String descricao) {
        this.pkIdAlteracaoMental = pkIdAlteracaoMental;
        this.descricao = descricao;
    }

    public Integer getPkIdAlteracaoMental() {
        return pkIdAlteracaoMental;
    }

    public void setPkIdAlteracaoMental(Integer pkIdAlteracaoMental) {
        this.pkIdAlteracaoMental = pkIdAlteracaoMental;
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
        hash += (pkIdAlteracaoMental != null ? pkIdAlteracaoMental.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbAlteracaoMental)) {
            return false;
        }
        AmbAlteracaoMental other = (AmbAlteracaoMental) object;
        if ((this.pkIdAlteracaoMental == null && other.pkIdAlteracaoMental != null) || (this.pkIdAlteracaoMental != null && !this.pkIdAlteracaoMental.equals(other.pkIdAlteracaoMental))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbAlteracaoMental[ pkIdAlteracaoMental=" + pkIdAlteracaoMental + " ]";
    }
    
}
