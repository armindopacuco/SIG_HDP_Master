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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "rh_subsidio_has_rh_contrato", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhSubsidioHasRhContrato.findAll", query = "SELECT r FROM RhSubsidioHasRhContrato r"),
    @NamedQuery(name = "RhSubsidioHasRhContrato.findByPkIdSubsidioHasContrato", query = "SELECT r FROM RhSubsidioHasRhContrato r WHERE r.pkIdSubsidioHasContrato = :pkIdSubsidioHasContrato"),
    @NamedQuery(name = "RhSubsidioHasRhContrato.findByValorSubsidio", query = "SELECT r FROM RhSubsidioHasRhContrato r WHERE r.valorSubsidio = :valorSubsidio")})
public class RhSubsidioHasRhContrato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_subsidio_has_contrato")
    private Integer pkIdSubsidioHasContrato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_subsidio")
    private double valorSubsidio;
    @JoinColumn(name = "fk_id_subsidio", referencedColumnName = "pk_id_subsidio")
    @ManyToOne(optional = false)
    private RhSubsidio fkIdSubsidio;
    @JoinColumn(name = "fk_id_contrato", referencedColumnName = "pk_id_contrato")
    @ManyToOne(optional = false)
    private RhContrato fkIdContrato;

    public RhSubsidioHasRhContrato() {
    }

    public RhSubsidioHasRhContrato(Integer pkIdSubsidioHasContrato) {
        this.pkIdSubsidioHasContrato = pkIdSubsidioHasContrato;
    }

    public RhSubsidioHasRhContrato(Integer pkIdSubsidioHasContrato, double valorSubsidio) {
        this.pkIdSubsidioHasContrato = pkIdSubsidioHasContrato;
        this.valorSubsidio = valorSubsidio;
    }

    public Integer getPkIdSubsidioHasContrato() {
        return pkIdSubsidioHasContrato;
    }

    public void setPkIdSubsidioHasContrato(Integer pkIdSubsidioHasContrato) {
        this.pkIdSubsidioHasContrato = pkIdSubsidioHasContrato;
    }

    public double getValorSubsidio() {
        return valorSubsidio;
    }

    public void setValorSubsidio(double valorSubsidio) {
        this.valorSubsidio = valorSubsidio;
    }

    public RhSubsidio getFkIdSubsidio() {
        return fkIdSubsidio;
    }

    public void setFkIdSubsidio(RhSubsidio fkIdSubsidio) {
        this.fkIdSubsidio = fkIdSubsidio;
    }

    public RhContrato getFkIdContrato() {
        return fkIdContrato;
    }

    public void setFkIdContrato(RhContrato fkIdContrato) {
        this.fkIdContrato = fkIdContrato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdSubsidioHasContrato != null ? pkIdSubsidioHasContrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhSubsidioHasRhContrato)) {
            return false;
        }
        RhSubsidioHasRhContrato other = (RhSubsidioHasRhContrato) object;
        if ((this.pkIdSubsidioHasContrato == null && other.pkIdSubsidioHasContrato != null) || (this.pkIdSubsidioHasContrato != null && !this.pkIdSubsidioHasContrato.equals(other.pkIdSubsidioHasContrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.RhSubsidioHasRhContrato[ pkIdSubsidioHasContrato=" + pkIdSubsidioHasContrato + " ]";
    }
    
}
