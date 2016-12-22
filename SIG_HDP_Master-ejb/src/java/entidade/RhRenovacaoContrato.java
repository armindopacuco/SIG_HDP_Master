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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "rh_renovacao_contrato", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhRenovacaoContrato.findAll", query = "SELECT r FROM RhRenovacaoContrato r"),
    @NamedQuery(name = "RhRenovacaoContrato.findByPkIdRenovacaoContrato", query = "SELECT r FROM RhRenovacaoContrato r WHERE r.pkIdRenovacaoContrato = :pkIdRenovacaoContrato")})
public class RhRenovacaoContrato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_renovacao_contrato")
    private Integer pkIdRenovacaoContrato;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_tipo_funcionario")
    @ManyToOne(optional = false)
    private RhTipoFuncionario fkIdFuncionario;
    @JoinColumn(name = "fk_id_contrato", referencedColumnName = "pk_id_contrato")
    @ManyToOne(optional = false)
    private RhContrato fkIdContrato;
    @JoinColumn(name = "fk_id_contrato_anterior", referencedColumnName = "pk_id_contrato")
    @OneToOne(optional = false)
    private RhContrato fkIdContratoAnterior;

    public RhRenovacaoContrato() {
    }

    public RhRenovacaoContrato(Integer pkIdRenovacaoContrato) {
        this.pkIdRenovacaoContrato = pkIdRenovacaoContrato;
    }

    public Integer getPkIdRenovacaoContrato() {
        return pkIdRenovacaoContrato;
    }

    public void setPkIdRenovacaoContrato(Integer pkIdRenovacaoContrato) {
        this.pkIdRenovacaoContrato = pkIdRenovacaoContrato;
    }

    public RhTipoFuncionario getFkIdFuncionario() {
        return fkIdFuncionario;
    }

    public void setFkIdFuncionario(RhTipoFuncionario fkIdFuncionario) {
        this.fkIdFuncionario = fkIdFuncionario;
    }

    public RhContrato getFkIdContrato() {
        return fkIdContrato;
    }

    public void setFkIdContrato(RhContrato fkIdContrato) {
        this.fkIdContrato = fkIdContrato;
    }

    public RhContrato getFkIdContratoAnterior() {
        return fkIdContratoAnterior;
    }

    public void setFkIdContratoAnterior(RhContrato fkIdContratoAnterior) {
        this.fkIdContratoAnterior = fkIdContratoAnterior;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdRenovacaoContrato != null ? pkIdRenovacaoContrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhRenovacaoContrato)) {
            return false;
        }
        RhRenovacaoContrato other = (RhRenovacaoContrato) object;
        if ((this.pkIdRenovacaoContrato == null && other.pkIdRenovacaoContrato != null) || (this.pkIdRenovacaoContrato != null && !this.pkIdRenovacaoContrato.equals(other.pkIdRenovacaoContrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.RhRenovacaoContrato[ pkIdRenovacaoContrato=" + pkIdRenovacaoContrato + " ]";
    }
    
}
