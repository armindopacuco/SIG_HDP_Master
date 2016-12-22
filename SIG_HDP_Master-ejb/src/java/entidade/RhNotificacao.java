/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "rh_notificacao", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhNotificacao.findAll", query = "SELECT r FROM RhNotificacao r"),
    @NamedQuery(name = "RhNotificacao.findByPkIdNotificacao", query = "SELECT r FROM RhNotificacao r WHERE r.pkIdNotificacao = :pkIdNotificacao"),
    @NamedQuery(name = "RhNotificacao.findByTitulo", query = "SELECT r FROM RhNotificacao r WHERE r.titulo = :titulo"),
    @NamedQuery(name = "RhNotificacao.findByDescricao", query = "SELECT r FROM RhNotificacao r WHERE r.descricao = :descricao"),
    @NamedQuery(name = "RhNotificacao.findByDataNotificacao", query = "SELECT r FROM RhNotificacao r WHERE r.dataNotificacao = :dataNotificacao")})
public class RhNotificacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_notificacao")
    private Integer pkIdNotificacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_notificacao")
    @Temporal(TemporalType.DATE)
    private Date dataNotificacao;
    @JoinColumn(name = "fk_id_estado_notificacao", referencedColumnName = "pk_id_estado_notificacao")
    @ManyToOne(optional = false)
    private RhEstadoNotificacao fkIdEstadoNotificacao;

    public RhNotificacao() {
    }

    public RhNotificacao(Integer pkIdNotificacao) {
        this.pkIdNotificacao = pkIdNotificacao;
    }

    public RhNotificacao(Integer pkIdNotificacao, String titulo, Date dataNotificacao) {
        this.pkIdNotificacao = pkIdNotificacao;
        this.titulo = titulo;
        this.dataNotificacao = dataNotificacao;
    }

    public Integer getPkIdNotificacao() {
        return pkIdNotificacao;
    }

    public void setPkIdNotificacao(Integer pkIdNotificacao) {
        this.pkIdNotificacao = pkIdNotificacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataNotificacao() {
        return dataNotificacao;
    }

    public void setDataNotificacao(Date dataNotificacao) {
        this.dataNotificacao = dataNotificacao;
    }

    public RhEstadoNotificacao getFkIdEstadoNotificacao() {
        return fkIdEstadoNotificacao;
    }

    public void setFkIdEstadoNotificacao(RhEstadoNotificacao fkIdEstadoNotificacao) {
        this.fkIdEstadoNotificacao = fkIdEstadoNotificacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdNotificacao != null ? pkIdNotificacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhNotificacao)) {
            return false;
        }
        RhNotificacao other = (RhNotificacao) object;
        if ((this.pkIdNotificacao == null && other.pkIdNotificacao != null) || (this.pkIdNotificacao != null && !this.pkIdNotificacao.equals(other.pkIdNotificacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.RhNotificacao[ pkIdNotificacao=" + pkIdNotificacao + " ]";
    }
    
}
