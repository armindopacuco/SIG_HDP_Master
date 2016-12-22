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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "supi_troca_turno", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupiTrocaTurno.findAll", query = "SELECT s FROM SupiTrocaTurno s"),
    @NamedQuery(name = "SupiTrocaTurno.findByPkIdTrocaTurno", query = "SELECT s FROM SupiTrocaTurno s WHERE s.pkIdTrocaTurno = :pkIdTrocaTurno"),
    @NamedQuery(name = "SupiTrocaTurno.findByDataTroca", query = "SELECT s FROM SupiTrocaTurno s WHERE s.dataTroca = :dataTroca")})
public class SupiTrocaTurno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_troca_turno")
    private Long pkIdTrocaTurno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_troca")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataTroca;

    public SupiTrocaTurno() {
    }

    public SupiTrocaTurno(Long pkIdTrocaTurno) {
        this.pkIdTrocaTurno = pkIdTrocaTurno;
    }

    public SupiTrocaTurno(Long pkIdTrocaTurno, Date dataTroca) {
        this.pkIdTrocaTurno = pkIdTrocaTurno;
        this.dataTroca = dataTroca;
    }

    public Long getPkIdTrocaTurno() {
        return pkIdTrocaTurno;
    }

    public void setPkIdTrocaTurno(Long pkIdTrocaTurno) {
        this.pkIdTrocaTurno = pkIdTrocaTurno;
    }

    public Date getDataTroca() {
        return dataTroca;
    }

    public void setDataTroca(Date dataTroca) {
        this.dataTroca = dataTroca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdTrocaTurno != null ? pkIdTrocaTurno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupiTrocaTurno)) {
            return false;
        }
        SupiTrocaTurno other = (SupiTrocaTurno) object;
        if ((this.pkIdTrocaTurno == null && other.pkIdTrocaTurno != null) || (this.pkIdTrocaTurno != null && !this.pkIdTrocaTurno.equals(other.pkIdTrocaTurno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.SupiTrocaTurno[ pkIdTrocaTurno=" + pkIdTrocaTurno + " ]";
    }
    
}
