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
import javax.persistence.ManyToOne;
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
@Table(name = "supi_enfermeiro", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupiEnfermeiro.findAll", query = "SELECT s FROM SupiEnfermeiro s"),
    @NamedQuery(name = "SupiEnfermeiro.findByPkIdEnfermeiro", query = "SELECT s FROM SupiEnfermeiro s WHERE s.pkIdEnfermeiro = :pkIdEnfermeiro"),
    @NamedQuery(name = "SupiEnfermeiro.findByNumeroLicenca", query = "SELECT s FROM SupiEnfermeiro s WHERE s.numeroLicenca = :numeroLicenca")})
public class SupiEnfermeiro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_enfermeiro")
    private Integer pkIdEnfermeiro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "numero_licenca")
    private String numeroLicenca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdEnfermeiro")
    private List<SupiTurno> supiTurnoList;
    @JoinColumn(name = "fk_id_escala", referencedColumnName = "pk_id_escala")
    @ManyToOne(optional = false)
    private SupiEscala fkIdEscala;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne(optional = false)
    private RhFuncionario fkIdFuncionario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdEnfermeiro")
    private List<SupiSupervisor> supiSupervisorList;

    public SupiEnfermeiro() {
    }

    public SupiEnfermeiro(Integer pkIdEnfermeiro) {
        this.pkIdEnfermeiro = pkIdEnfermeiro;
    }

    public SupiEnfermeiro(Integer pkIdEnfermeiro, String numeroLicenca) {
        this.pkIdEnfermeiro = pkIdEnfermeiro;
        this.numeroLicenca = numeroLicenca;
    }

    public Integer getPkIdEnfermeiro() {
        return pkIdEnfermeiro;
    }

    public void setPkIdEnfermeiro(Integer pkIdEnfermeiro) {
        this.pkIdEnfermeiro = pkIdEnfermeiro;
    }

    public String getNumeroLicenca() {
        return numeroLicenca;
    }

    public void setNumeroLicenca(String numeroLicenca) {
        this.numeroLicenca = numeroLicenca;
    }

    @XmlTransient
    public List<SupiTurno> getSupiTurnoList() {
        return supiTurnoList;
    }

    public void setSupiTurnoList(List<SupiTurno> supiTurnoList) {
        this.supiTurnoList = supiTurnoList;
    }

    public SupiEscala getFkIdEscala() {
        return fkIdEscala;
    }

    public void setFkIdEscala(SupiEscala fkIdEscala) {
        this.fkIdEscala = fkIdEscala;
    }

    public RhFuncionario getFkIdFuncionario() {
        return fkIdFuncionario;
    }

    public void setFkIdFuncionario(RhFuncionario fkIdFuncionario) {
        this.fkIdFuncionario = fkIdFuncionario;
    }

    @XmlTransient
    public List<SupiSupervisor> getSupiSupervisorList() {
        return supiSupervisorList;
    }

    public void setSupiSupervisorList(List<SupiSupervisor> supiSupervisorList) {
        this.supiSupervisorList = supiSupervisorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdEnfermeiro != null ? pkIdEnfermeiro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupiEnfermeiro)) {
            return false;
        }
        SupiEnfermeiro other = (SupiEnfermeiro) object;
        if ((this.pkIdEnfermeiro == null && other.pkIdEnfermeiro != null) || (this.pkIdEnfermeiro != null && !this.pkIdEnfermeiro.equals(other.pkIdEnfermeiro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.SupiEnfermeiro[ pkIdEnfermeiro=" + pkIdEnfermeiro + " ]";
    }
    
}
