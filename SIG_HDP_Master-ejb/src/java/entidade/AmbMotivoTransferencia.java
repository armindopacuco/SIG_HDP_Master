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
@Table(name = "amb_motivo_transferencia", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbMotivoTransferencia.findAll", query = "SELECT a FROM AmbMotivoTransferencia a"),
    @NamedQuery(name = "AmbMotivoTransferencia.findByPkIdMotivoTransferencia", query = "SELECT a FROM AmbMotivoTransferencia a WHERE a.pkIdMotivoTransferencia = :pkIdMotivoTransferencia"),
    @NamedQuery(name = "AmbMotivoTransferencia.findByDescricao", query = "SELECT a FROM AmbMotivoTransferencia a WHERE a.descricao = :descricao")})
public class AmbMotivoTransferencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_motivo_transferencia")
    private Integer pkIdMotivoTransferencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descricao")
    private String descricao;

    public AmbMotivoTransferencia() {
    }

    public AmbMotivoTransferencia(Integer pkIdMotivoTransferencia) {
        this.pkIdMotivoTransferencia = pkIdMotivoTransferencia;
    }

    public AmbMotivoTransferencia(Integer pkIdMotivoTransferencia, String descricao) {
        this.pkIdMotivoTransferencia = pkIdMotivoTransferencia;
        this.descricao = descricao;
    }

    public Integer getPkIdMotivoTransferencia() {
        return pkIdMotivoTransferencia;
    }

    public void setPkIdMotivoTransferencia(Integer pkIdMotivoTransferencia) {
        this.pkIdMotivoTransferencia = pkIdMotivoTransferencia;
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
        hash += (pkIdMotivoTransferencia != null ? pkIdMotivoTransferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbMotivoTransferencia)) {
            return false;
        }
        AmbMotivoTransferencia other = (AmbMotivoTransferencia) object;
        if ((this.pkIdMotivoTransferencia == null && other.pkIdMotivoTransferencia != null) || (this.pkIdMotivoTransferencia != null && !this.pkIdMotivoTransferencia.equals(other.pkIdMotivoTransferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbMotivoTransferencia[ pkIdMotivoTransferencia=" + pkIdMotivoTransferencia + " ]";
    }
    
}
