/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "rh_pedido_ferias", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhPedidoFerias.findAll", query = "SELECT r FROM RhPedidoFerias r"),
    @NamedQuery(name = "RhPedidoFerias.findByPkIdPedidoFerias", query = "SELECT r FROM RhPedidoFerias r WHERE r.pkIdPedidoFerias = :pkIdPedidoFerias"),
    @NamedQuery(name = "RhPedidoFerias.findByAprovado", query = "SELECT r FROM RhPedidoFerias r WHERE r.aprovado = :aprovado"),
    @NamedQuery(name = "RhPedidoFerias.findByDataPedido", query = "SELECT r FROM RhPedidoFerias r WHERE r.dataPedido = :dataPedido")})
public class RhPedidoFerias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_pedido_ferias")
    private Integer pkIdPedidoFerias;
    @Column(name = "aprovado")
    private Boolean aprovado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_pedido")
    @Temporal(TemporalType.DATE)
    private Date dataPedido;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne(optional = false)
    private RhFuncionario fkIdFuncionario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdPedidoFerias")
    private List<RhFerias> rhFeriasList;

    public RhPedidoFerias() {
    }

    public RhPedidoFerias(Integer pkIdPedidoFerias) {
        this.pkIdPedidoFerias = pkIdPedidoFerias;
    }

    public RhPedidoFerias(Integer pkIdPedidoFerias, Date dataPedido) {
        this.pkIdPedidoFerias = pkIdPedidoFerias;
        this.dataPedido = dataPedido;
    }

    public Integer getPkIdPedidoFerias() {
        return pkIdPedidoFerias;
    }

    public void setPkIdPedidoFerias(Integer pkIdPedidoFerias) {
        this.pkIdPedidoFerias = pkIdPedidoFerias;
    }

    public Boolean getAprovado() {
        return aprovado;
    }

    public void setAprovado(Boolean aprovado) {
        this.aprovado = aprovado;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public RhFuncionario getFkIdFuncionario() {
        return fkIdFuncionario;
    }

    public void setFkIdFuncionario(RhFuncionario fkIdFuncionario) {
        this.fkIdFuncionario = fkIdFuncionario;
    }

    @XmlTransient
    public List<RhFerias> getRhFeriasList() {
        return rhFeriasList;
    }

    public void setRhFeriasList(List<RhFerias> rhFeriasList) {
        this.rhFeriasList = rhFeriasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdPedidoFerias != null ? pkIdPedidoFerias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhPedidoFerias)) {
            return false;
        }
        RhPedidoFerias other = (RhPedidoFerias) object;
        if ((this.pkIdPedidoFerias == null && other.pkIdPedidoFerias != null) || (this.pkIdPedidoFerias != null && !this.pkIdPedidoFerias.equals(other.pkIdPedidoFerias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.RhPedidoFerias[ pkIdPedidoFerias=" + pkIdPedidoFerias + " ]";
    }
    
}
