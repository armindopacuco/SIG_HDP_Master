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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "supi_supervisor", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupiSupervisor.findAll", query = "SELECT s FROM SupiSupervisor s"),
    @NamedQuery(name = "SupiSupervisor.findByPkIdSupervisor", query = "SELECT s FROM SupiSupervisor s WHERE s.pkIdSupervisor = :pkIdSupervisor"),
    @NamedQuery(name = "SupiSupervisor.findByObservacao", query = "SELECT s FROM SupiSupervisor s WHERE s.observacao = :observacao")})
public class SupiSupervisor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_supervisor")
    private Integer pkIdSupervisor;
    @Size(max = 100)
    @Column(name = "observacao")
    private String observacao;
    @JoinColumn(name = "fk_id_enfermeiro", referencedColumnName = "pk_id_enfermeiro")
    @ManyToOne(optional = false)
    private SupiEnfermeiro fkIdEnfermeiro;

    public SupiSupervisor() {
    }

    public SupiSupervisor(Integer pkIdSupervisor) {
        this.pkIdSupervisor = pkIdSupervisor;
    }

    public Integer getPkIdSupervisor() {
        return pkIdSupervisor;
    }

    public void setPkIdSupervisor(Integer pkIdSupervisor) {
        this.pkIdSupervisor = pkIdSupervisor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public SupiEnfermeiro getFkIdEnfermeiro() {
        return fkIdEnfermeiro;
    }

    public void setFkIdEnfermeiro(SupiEnfermeiro fkIdEnfermeiro) {
        this.fkIdEnfermeiro = fkIdEnfermeiro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdSupervisor != null ? pkIdSupervisor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupiSupervisor)) {
            return false;
        }
        SupiSupervisor other = (SupiSupervisor) object;
        if ((this.pkIdSupervisor == null && other.pkIdSupervisor != null) || (this.pkIdSupervisor != null && !this.pkIdSupervisor.equals(other.pkIdSupervisor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.SupiSupervisor[ pkIdSupervisor=" + pkIdSupervisor + " ]";
    }
    
}
