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
@Table(name = "supi_escala", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupiEscala.findAll", query = "SELECT s FROM SupiEscala s"),
    @NamedQuery(name = "SupiEscala.findByPkIdEscala", query = "SELECT s FROM SupiEscala s WHERE s.pkIdEscala = :pkIdEscala"),
    @NamedQuery(name = "SupiEscala.findByDataEscala", query = "SELECT s FROM SupiEscala s WHERE s.dataEscala = :dataEscala"),
    @NamedQuery(name = "SupiEscala.findByCargaHorariaMensal", query = "SELECT s FROM SupiEscala s WHERE s.cargaHorariaMensal = :cargaHorariaMensal")})
public class SupiEscala implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_escala")
    private Long pkIdEscala;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_escala")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEscala;
    @Basic(optional = false)
    @NotNull
    @Column(name = "carga_horaria_mensal")
    private int cargaHorariaMensal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdEscala")
    private List<SupiEnfermeiro> supiEnfermeiroList;
    @JoinColumn(name = "fk_id_seccao", referencedColumnName = "pk_id_seccao")
    @ManyToOne(optional = false)
    private SupiSeccao fkIdSeccao;

    public SupiEscala() {
    }

    public SupiEscala(Long pkIdEscala) {
        this.pkIdEscala = pkIdEscala;
    }

    public SupiEscala(Long pkIdEscala, Date dataEscala, int cargaHorariaMensal) {
        this.pkIdEscala = pkIdEscala;
        this.dataEscala = dataEscala;
        this.cargaHorariaMensal = cargaHorariaMensal;
    }

    public Long getPkIdEscala() {
        return pkIdEscala;
    }

    public void setPkIdEscala(Long pkIdEscala) {
        this.pkIdEscala = pkIdEscala;
    }

    public Date getDataEscala() {
        return dataEscala;
    }

    public void setDataEscala(Date dataEscala) {
        this.dataEscala = dataEscala;
    }

    public int getCargaHorariaMensal() {
        return cargaHorariaMensal;
    }

    public void setCargaHorariaMensal(int cargaHorariaMensal) {
        this.cargaHorariaMensal = cargaHorariaMensal;
    }

    @XmlTransient
    public List<SupiEnfermeiro> getSupiEnfermeiroList() {
        return supiEnfermeiroList;
    }

    public void setSupiEnfermeiroList(List<SupiEnfermeiro> supiEnfermeiroList) {
        this.supiEnfermeiroList = supiEnfermeiroList;
    }

    public SupiSeccao getFkIdSeccao() {
        return fkIdSeccao;
    }

    public void setFkIdSeccao(SupiSeccao fkIdSeccao) {
        this.fkIdSeccao = fkIdSeccao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdEscala != null ? pkIdEscala.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupiEscala)) {
            return false;
        }
        SupiEscala other = (SupiEscala) object;
        if ((this.pkIdEscala == null && other.pkIdEscala != null) || (this.pkIdEscala != null && !this.pkIdEscala.equals(other.pkIdEscala))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.SupiEscala[ pkIdEscala=" + pkIdEscala + " ]";
    }
    
}
