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
@Table(name = "rh_ferias", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhFerias.findAll", query = "SELECT r FROM RhFerias r"),
    @NamedQuery(name = "RhFerias.findByPkIdFerias", query = "SELECT r FROM RhFerias r WHERE r.pkIdFerias = :pkIdFerias"),
    @NamedQuery(name = "RhFerias.findByDataInicio", query = "SELECT r FROM RhFerias r WHERE r.dataInicio = :dataInicio"),
    @NamedQuery(name = "RhFerias.findByDataTermino", query = "SELECT r FROM RhFerias r WHERE r.dataTermino = :dataTermino"),
    @NamedQuery(name = "RhFerias.findByDataAprovacao", query = "SELECT r FROM RhFerias r WHERE r.dataAprovacao = :dataAprovacao"),
    @NamedQuery(name = "RhFerias.findByDiasDescontados", query = "SELECT r FROM RhFerias r WHERE r.diasDescontados = :diasDescontados"),
    @NamedQuery(name = "RhFerias.findByObservacao", query = "SELECT r FROM RhFerias r WHERE r.observacao = :observacao"),
    @NamedQuery(name = "RhFerias.findByDuracaoDias", query = "SELECT r FROM RhFerias r WHERE r.duracaoDias = :duracaoDias")})
public class RhFerias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_ferias")
    private Integer pkIdFerias;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Column(name = "data_termino")
    @Temporal(TemporalType.DATE)
    private Date dataTermino;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_aprovacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAprovacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dias_descontados")
    private int diasDescontados;
    @Size(max = 500)
    @Column(name = "observacao")
    private String observacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracao_dias")
    private int duracaoDias;
    @JoinColumn(name = "fk_id_pedido_ferias", referencedColumnName = "pk_id_pedido_ferias")
    @ManyToOne(optional = false)
    private RhPedidoFerias fkIdPedidoFerias;
    @JoinColumn(name = "fk_id_estado_ferias", referencedColumnName = "pk_id_estado_ferias")
    @ManyToOne(optional = false)
    private RhEstadoFerias fkIdEstadoFerias;

    public RhFerias() {
    }

    public RhFerias(Integer pkIdFerias) {
        this.pkIdFerias = pkIdFerias;
    }

    public RhFerias(Integer pkIdFerias, Date dataInicio, Date dataAprovacao, int diasDescontados, int duracaoDias) {
        this.pkIdFerias = pkIdFerias;
        this.dataInicio = dataInicio;
        this.dataAprovacao = dataAprovacao;
        this.diasDescontados = diasDescontados;
        this.duracaoDias = duracaoDias;
    }

    public Integer getPkIdFerias() {
        return pkIdFerias;
    }

    public void setPkIdFerias(Integer pkIdFerias) {
        this.pkIdFerias = pkIdFerias;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Date getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(Date dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    public int getDiasDescontados() {
        return diasDescontados;
    }

    public void setDiasDescontados(int diasDescontados) {
        this.diasDescontados = diasDescontados;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getDuracaoDias() {
        return duracaoDias;
    }

    public void setDuracaoDias(int duracaoDias) {
        this.duracaoDias = duracaoDias;
    }

    public RhPedidoFerias getFkIdPedidoFerias() {
        return fkIdPedidoFerias;
    }

    public void setFkIdPedidoFerias(RhPedidoFerias fkIdPedidoFerias) {
        this.fkIdPedidoFerias = fkIdPedidoFerias;
    }

    public RhEstadoFerias getFkIdEstadoFerias() {
        return fkIdEstadoFerias;
    }

    public void setFkIdEstadoFerias(RhEstadoFerias fkIdEstadoFerias) {
        this.fkIdEstadoFerias = fkIdEstadoFerias;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdFerias != null ? pkIdFerias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhFerias)) {
            return false;
        }
        RhFerias other = (RhFerias) object;
        if ((this.pkIdFerias == null && other.pkIdFerias != null) || (this.pkIdFerias != null && !this.pkIdFerias.equals(other.pkIdFerias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.RhFerias[ pkIdFerias=" + pkIdFerias + " ]";
    }
    
}
