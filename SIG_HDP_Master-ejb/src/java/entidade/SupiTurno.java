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
@Table(name = "supi_turno", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupiTurno.findAll", query = "SELECT s FROM SupiTurno s"),
    @NamedQuery(name = "SupiTurno.findByPkIdTurno", query = "SELECT s FROM SupiTurno s WHERE s.pkIdTurno = :pkIdTurno"),
    @NamedQuery(name = "SupiTurno.findByDescricaoTurno", query = "SELECT s FROM SupiTurno s WHERE s.descricaoTurno = :descricaoTurno")})
public class SupiTurno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_turno")
    private Integer pkIdTurno;
    @Size(max = 2147483647)
    @Column(name = "descricao_turno")
    private String descricaoTurno;
    @JoinColumn(name = "fk_id_enfermeiro", referencedColumnName = "pk_id_enfermeiro")
    @ManyToOne(optional = false)
    private SupiEnfermeiro fkIdEnfermeiro;

    public SupiTurno() {
    }

    public SupiTurno(Integer pkIdTurno) {
        this.pkIdTurno = pkIdTurno;
    }

    public Integer getPkIdTurno() {
        return pkIdTurno;
    }

    public void setPkIdTurno(Integer pkIdTurno) {
        this.pkIdTurno = pkIdTurno;
    }

    public String getDescricaoTurno() {
        return descricaoTurno;
    }

    public void setDescricaoTurno(String descricaoTurno) {
        this.descricaoTurno = descricaoTurno;
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
        hash += (pkIdTurno != null ? pkIdTurno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupiTurno)) {
            return false;
        }
        SupiTurno other = (SupiTurno) object;
        if ((this.pkIdTurno == null && other.pkIdTurno != null) || (this.pkIdTurno != null && !this.pkIdTurno.equals(other.pkIdTurno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.SupiTurno[ pkIdTurno=" + pkIdTurno + " ]";
    }
    
}
