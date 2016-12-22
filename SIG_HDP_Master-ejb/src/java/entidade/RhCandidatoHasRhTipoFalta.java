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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "rh_candidato_has_rh_tipo_falta", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhCandidatoHasRhTipoFalta.findAll", query = "SELECT r FROM RhCandidatoHasRhTipoFalta r"),
    @NamedQuery(name = "RhCandidatoHasRhTipoFalta.findByPkIdCandidatoHasTipoFalta", query = "SELECT r FROM RhCandidatoHasRhTipoFalta r WHERE r.pkIdCandidatoHasTipoFalta = :pkIdCandidatoHasTipoFalta"),
    @NamedQuery(name = "RhCandidatoHasRhTipoFalta.findByData", query = "SELECT r FROM RhCandidatoHasRhTipoFalta r WHERE r.data = :data")})
public class RhCandidatoHasRhTipoFalta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_candidato_has_tipo_falta")
    private Integer pkIdCandidatoHasTipoFalta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @JoinColumn(name = "fk_id_tipo_falta", referencedColumnName = "pk_id_tipo_falta")
    @ManyToOne(optional = false)
    private RhTipoFalta fkIdTipoFalta;
    @JoinColumn(name = "fk_id_candidato", referencedColumnName = "pk_id_candidato")
    @ManyToOne(optional = false)
    private RhCandidato fkIdCandidato;
    @JoinColumn(name = "fk_id_assiduidade_mensal", referencedColumnName = "pk_id_assiduidade_mensal")
    @ManyToOne(optional = false)
    private RhAssiduidadeMensal fkIdAssiduidadeMensal;

    public RhCandidatoHasRhTipoFalta() {
    }

    public RhCandidatoHasRhTipoFalta(Integer pkIdCandidatoHasTipoFalta) {
        this.pkIdCandidatoHasTipoFalta = pkIdCandidatoHasTipoFalta;
    }

    public RhCandidatoHasRhTipoFalta(Integer pkIdCandidatoHasTipoFalta, Date data) {
        this.pkIdCandidatoHasTipoFalta = pkIdCandidatoHasTipoFalta;
        this.data = data;
    }

    public Integer getPkIdCandidatoHasTipoFalta() {
        return pkIdCandidatoHasTipoFalta;
    }

    public void setPkIdCandidatoHasTipoFalta(Integer pkIdCandidatoHasTipoFalta) {
        this.pkIdCandidatoHasTipoFalta = pkIdCandidatoHasTipoFalta;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public RhTipoFalta getFkIdTipoFalta() {
        return fkIdTipoFalta;
    }

    public void setFkIdTipoFalta(RhTipoFalta fkIdTipoFalta) {
        this.fkIdTipoFalta = fkIdTipoFalta;
    }

    public RhCandidato getFkIdCandidato() {
        return fkIdCandidato;
    }

    public void setFkIdCandidato(RhCandidato fkIdCandidato) {
        this.fkIdCandidato = fkIdCandidato;
    }

    public RhAssiduidadeMensal getFkIdAssiduidadeMensal() {
        return fkIdAssiduidadeMensal;
    }

    public void setFkIdAssiduidadeMensal(RhAssiduidadeMensal fkIdAssiduidadeMensal) {
        this.fkIdAssiduidadeMensal = fkIdAssiduidadeMensal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdCandidatoHasTipoFalta != null ? pkIdCandidatoHasTipoFalta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhCandidatoHasRhTipoFalta)) {
            return false;
        }
        RhCandidatoHasRhTipoFalta other = (RhCandidatoHasRhTipoFalta) object;
        if ((this.pkIdCandidatoHasTipoFalta == null && other.pkIdCandidatoHasTipoFalta != null) || (this.pkIdCandidatoHasTipoFalta != null && !this.pkIdCandidatoHasTipoFalta.equals(other.pkIdCandidatoHasTipoFalta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.RhCandidatoHasRhTipoFalta[ pkIdCandidatoHasTipoFalta=" + pkIdCandidatoHasTipoFalta + " ]";
    }
    
}
