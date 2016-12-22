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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "amb_consulta_retorno", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbConsultaRetorno.findAll", query = "SELECT a FROM AmbConsultaRetorno a"),
    @NamedQuery(name = "AmbConsultaRetorno.findByPkIdConsultaRetorno", query = "SELECT a FROM AmbConsultaRetorno a WHERE a.pkIdConsultaRetorno = :pkIdConsultaRetorno"),
    @NamedQuery(name = "AmbConsultaRetorno.findByDescricao", query = "SELECT a FROM AmbConsultaRetorno a WHERE a.descricao = :descricao")})
public class AmbConsultaRetorno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_consulta_retorno")
    private Integer pkIdConsultaRetorno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "fk_id_consulta", referencedColumnName = "pk_id_consulta")
    @ManyToOne(optional = false)
    private AmbConsulta fkIdConsulta;

    public AmbConsultaRetorno() {
    }

    public AmbConsultaRetorno(Integer pkIdConsultaRetorno) {
        this.pkIdConsultaRetorno = pkIdConsultaRetorno;
    }

    public AmbConsultaRetorno(Integer pkIdConsultaRetorno, String descricao) {
        this.pkIdConsultaRetorno = pkIdConsultaRetorno;
        this.descricao = descricao;
    }

    public Integer getPkIdConsultaRetorno() {
        return pkIdConsultaRetorno;
    }

    public void setPkIdConsultaRetorno(Integer pkIdConsultaRetorno) {
        this.pkIdConsultaRetorno = pkIdConsultaRetorno;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public AmbConsulta getFkIdConsulta() {
        return fkIdConsulta;
    }

    public void setFkIdConsulta(AmbConsulta fkIdConsulta) {
        this.fkIdConsulta = fkIdConsulta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdConsultaRetorno != null ? pkIdConsultaRetorno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbConsultaRetorno)) {
            return false;
        }
        AmbConsultaRetorno other = (AmbConsultaRetorno) object;
        if ((this.pkIdConsultaRetorno == null && other.pkIdConsultaRetorno != null) || (this.pkIdConsultaRetorno != null && !this.pkIdConsultaRetorno.equals(other.pkIdConsultaRetorno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbConsultaRetorno[ pkIdConsultaRetorno=" + pkIdConsultaRetorno + " ]";
    }
    
}
