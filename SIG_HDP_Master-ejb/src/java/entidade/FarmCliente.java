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
@Table(name = "farm_cliente", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmCliente.findAll", query = "SELECT f FROM FarmCliente f"),
    @NamedQuery(name = "FarmCliente.findByPkIdCliente", query = "SELECT f FROM FarmCliente f WHERE f.pkIdCliente = :pkIdCliente"),
    @NamedQuery(name = "FarmCliente.findByFkIdPaciente", query = "SELECT f FROM FarmCliente f WHERE f.fkIdPaciente = :fkIdPaciente"),
    @NamedQuery(name = "FarmCliente.findByNumeroCliente", query = "SELECT f FROM FarmCliente f WHERE f.numeroCliente = :numeroCliente")})
public class FarmCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_cliente")
    private Integer pkIdCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_id_paciente")
    private int fkIdPaciente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numero_cliente")
    private String numeroCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdCliente")
    private List<FarmVenda> farmVendaList;

    public FarmCliente() {
    }

    public FarmCliente(Integer pkIdCliente) {
        this.pkIdCliente = pkIdCliente;
    }

    public FarmCliente(Integer pkIdCliente, int fkIdPaciente, String numeroCliente) {
        this.pkIdCliente = pkIdCliente;
        this.fkIdPaciente = fkIdPaciente;
        this.numeroCliente = numeroCliente;
    }

    public Integer getPkIdCliente() {
        return pkIdCliente;
    }

    public void setPkIdCliente(Integer pkIdCliente) {
        this.pkIdCliente = pkIdCliente;
    }

    public int getFkIdPaciente() {
        return fkIdPaciente;
    }

    public void setFkIdPaciente(int fkIdPaciente) {
        this.fkIdPaciente = fkIdPaciente;
    }

    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    @XmlTransient
    public List<FarmVenda> getFarmVendaList() {
        return farmVendaList;
    }

    public void setFarmVendaList(List<FarmVenda> farmVendaList) {
        this.farmVendaList = farmVendaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdCliente != null ? pkIdCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmCliente)) {
            return false;
        }
        FarmCliente other = (FarmCliente) object;
        if ((this.pkIdCliente == null && other.pkIdCliente != null) || (this.pkIdCliente != null && !this.pkIdCliente.equals(other.pkIdCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmCliente[ pkIdCliente=" + pkIdCliente + " ]";
    }
    
}
