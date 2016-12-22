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
@Table(name = "rh_licenca_funcionario", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhLicencaFuncionario.findAll", query = "SELECT r FROM RhLicencaFuncionario r"),
    @NamedQuery(name = "RhLicencaFuncionario.findByIdLicencaFuncionario", query = "SELECT r FROM RhLicencaFuncionario r WHERE r.idLicencaFuncionario = :idLicencaFuncionario"),
    @NamedQuery(name = "RhLicencaFuncionario.findByDataInicio", query = "SELECT r FROM RhLicencaFuncionario r WHERE r.dataInicio = :dataInicio"),
    @NamedQuery(name = "RhLicencaFuncionario.findByDataFim", query = "SELECT r FROM RhLicencaFuncionario r WHERE r.dataFim = :dataFim")})
public class RhLicencaFuncionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_licenca_funcionario")
    private Integer idLicencaFuncionario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Column(name = "data_fim")
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    @JoinColumn(name = "fk_id_tipo_licenca", referencedColumnName = "pk_id_tipo_licenca")
    @ManyToOne(optional = false)
    private RhTipoLicenca fkIdTipoLicenca;
    @JoinColumn(name = "fk_id_status", referencedColumnName = "pk_id_status")
    @ManyToOne(optional = false)
    private RhStatus fkIdStatus;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne(optional = false)
    private RhFuncionario fkIdFuncionario;

    public RhLicencaFuncionario() {
    }

    public RhLicencaFuncionario(Integer idLicencaFuncionario) {
        this.idLicencaFuncionario = idLicencaFuncionario;
    }

    public RhLicencaFuncionario(Integer idLicencaFuncionario, Date dataInicio) {
        this.idLicencaFuncionario = idLicencaFuncionario;
        this.dataInicio = dataInicio;
    }

    public Integer getIdLicencaFuncionario() {
        return idLicencaFuncionario;
    }

    public void setIdLicencaFuncionario(Integer idLicencaFuncionario) {
        this.idLicencaFuncionario = idLicencaFuncionario;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public RhTipoLicenca getFkIdTipoLicenca() {
        return fkIdTipoLicenca;
    }

    public void setFkIdTipoLicenca(RhTipoLicenca fkIdTipoLicenca) {
        this.fkIdTipoLicenca = fkIdTipoLicenca;
    }

    public RhStatus getFkIdStatus() {
        return fkIdStatus;
    }

    public void setFkIdStatus(RhStatus fkIdStatus) {
        this.fkIdStatus = fkIdStatus;
    }

    public RhFuncionario getFkIdFuncionario() {
        return fkIdFuncionario;
    }

    public void setFkIdFuncionario(RhFuncionario fkIdFuncionario) {
        this.fkIdFuncionario = fkIdFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLicencaFuncionario != null ? idLicencaFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhLicencaFuncionario)) {
            return false;
        }
        RhLicencaFuncionario other = (RhLicencaFuncionario) object;
        if ((this.idLicencaFuncionario == null && other.idLicencaFuncionario != null) || (this.idLicencaFuncionario != null && !this.idLicencaFuncionario.equals(other.idLicencaFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.RhLicencaFuncionario[ idLicencaFuncionario=" + idLicencaFuncionario + " ]";
    }
    
}
