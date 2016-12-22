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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "rh_tabela_salarial", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhTabelaSalarial.findAll", query = "SELECT r FROM RhTabelaSalarial r"),
    @NamedQuery(name = "RhTabelaSalarial.findByPkIdTabelaSalarial", query = "SELECT r FROM RhTabelaSalarial r WHERE r.pkIdTabelaSalarial = :pkIdTabelaSalarial"),
    @NamedQuery(name = "RhTabelaSalarial.findBySalarioBase", query = "SELECT r FROM RhTabelaSalarial r WHERE r.salarioBase = :salarioBase")})
public class RhTabelaSalarial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_tabela_salarial")
    private Integer pkIdTabelaSalarial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salario_base")
    private double salarioBase;
    @JoinColumn(name = "fk_id_cargo", referencedColumnName = "pk_id_cargo")
    @OneToOne(optional = false)
    private RhCargo fkIdCargo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdTabelaSalarial")
    private List<RhContrato> rhContratoList;

    public RhTabelaSalarial() {
    }

    public RhTabelaSalarial(Integer pkIdTabelaSalarial) {
        this.pkIdTabelaSalarial = pkIdTabelaSalarial;
    }

    public RhTabelaSalarial(Integer pkIdTabelaSalarial, double salarioBase) {
        this.pkIdTabelaSalarial = pkIdTabelaSalarial;
        this.salarioBase = salarioBase;
    }

    public Integer getPkIdTabelaSalarial() {
        return pkIdTabelaSalarial;
    }

    public void setPkIdTabelaSalarial(Integer pkIdTabelaSalarial) {
        this.pkIdTabelaSalarial = pkIdTabelaSalarial;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public RhCargo getFkIdCargo() {
        return fkIdCargo;
    }

    public void setFkIdCargo(RhCargo fkIdCargo) {
        this.fkIdCargo = fkIdCargo;
    }

    @XmlTransient
    public List<RhContrato> getRhContratoList() {
        return rhContratoList;
    }

    public void setRhContratoList(List<RhContrato> rhContratoList) {
        this.rhContratoList = rhContratoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdTabelaSalarial != null ? pkIdTabelaSalarial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhTabelaSalarial)) {
            return false;
        }
        RhTabelaSalarial other = (RhTabelaSalarial) object;
        if ((this.pkIdTabelaSalarial == null && other.pkIdTabelaSalarial != null) || (this.pkIdTabelaSalarial != null && !this.pkIdTabelaSalarial.equals(other.pkIdTabelaSalarial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.RhTabelaSalarial[ pkIdTabelaSalarial=" + pkIdTabelaSalarial + " ]";
    }
    
}
