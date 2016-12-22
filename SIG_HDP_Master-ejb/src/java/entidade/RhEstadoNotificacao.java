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
@Table(name = "rh_estado_notificacao", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhEstadoNotificacao.findAll", query = "SELECT r FROM RhEstadoNotificacao r"),
    @NamedQuery(name = "RhEstadoNotificacao.findByPkIdEstadoNotificacao", query = "SELECT r FROM RhEstadoNotificacao r WHERE r.pkIdEstadoNotificacao = :pkIdEstadoNotificacao"),
    @NamedQuery(name = "RhEstadoNotificacao.findByDescricao", query = "SELECT r FROM RhEstadoNotificacao r WHERE r.descricao = :descricao")})
public class RhEstadoNotificacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_estado_notificacao")
    private Integer pkIdEstadoNotificacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdEstadoNotificacao")
    private List<RhNotificacao> rhNotificacaoList;

    public RhEstadoNotificacao() {
    }

    public RhEstadoNotificacao(Integer pkIdEstadoNotificacao) {
        this.pkIdEstadoNotificacao = pkIdEstadoNotificacao;
    }

    public RhEstadoNotificacao(Integer pkIdEstadoNotificacao, String descricao) {
        this.pkIdEstadoNotificacao = pkIdEstadoNotificacao;
        this.descricao = descricao;
    }

    public Integer getPkIdEstadoNotificacao() {
        return pkIdEstadoNotificacao;
    }

    public void setPkIdEstadoNotificacao(Integer pkIdEstadoNotificacao) {
        this.pkIdEstadoNotificacao = pkIdEstadoNotificacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<RhNotificacao> getRhNotificacaoList() {
        return rhNotificacaoList;
    }

    public void setRhNotificacaoList(List<RhNotificacao> rhNotificacaoList) {
        this.rhNotificacaoList = rhNotificacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdEstadoNotificacao != null ? pkIdEstadoNotificacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhEstadoNotificacao)) {
            return false;
        }
        RhEstadoNotificacao other = (RhEstadoNotificacao) object;
        if ((this.pkIdEstadoNotificacao == null && other.pkIdEstadoNotificacao != null) || (this.pkIdEstadoNotificacao != null && !this.pkIdEstadoNotificacao.equals(other.pkIdEstadoNotificacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.RhEstadoNotificacao[ pkIdEstadoNotificacao=" + pkIdEstadoNotificacao + " ]";
    }
    
}
