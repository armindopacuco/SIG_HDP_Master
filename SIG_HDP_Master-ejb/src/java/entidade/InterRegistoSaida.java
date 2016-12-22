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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "inter_registo_saida", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterRegistoSaida.findAll", query = "SELECT i FROM InterRegistoSaida i"),
    @NamedQuery(name = "InterRegistoSaida.findByPkIdRegistoSaida", query = "SELECT i FROM InterRegistoSaida i WHERE i.pkIdRegistoSaida = :pkIdRegistoSaida"),
    @NamedQuery(name = "InterRegistoSaida.findByDiagnosticoDefinitivo", query = "SELECT i FROM InterRegistoSaida i WHERE i.diagnosticoDefinitivo = :diagnosticoDefinitivo"),
    @NamedQuery(name = "InterRegistoSaida.findByDiasHospitalizado", query = "SELECT i FROM InterRegistoSaida i WHERE i.diasHospitalizado = :diasHospitalizado"),
    @NamedQuery(name = "InterRegistoSaida.findByDataRegistoSaida", query = "SELECT i FROM InterRegistoSaida i WHERE i.dataRegistoSaida = :dataRegistoSaida")})
public class InterRegistoSaida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_registo_saida")
    private Integer pkIdRegistoSaida;
    @Size(max = 200)
    @Column(name = "diagnostico_definitivo")
    private String diagnosticoDefinitivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dias_hospitalizado")
    private int diasHospitalizado;
    @Column(name = "data_registo_saida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataRegistoSaida;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne(optional = false)
    private RhFuncionario fkIdFuncionario;
    @JoinColumn(name = "fk_id_titulo_alta", referencedColumnName = "pk_id_titulo_alta")
    @ManyToOne(optional = false)
    private InterTituloAlta fkIdTituloAlta;

    public InterRegistoSaida() {
    }

    public InterRegistoSaida(Integer pkIdRegistoSaida) {
        this.pkIdRegistoSaida = pkIdRegistoSaida;
    }

    public InterRegistoSaida(Integer pkIdRegistoSaida, int diasHospitalizado) {
        this.pkIdRegistoSaida = pkIdRegistoSaida;
        this.diasHospitalizado = diasHospitalizado;
    }

    public Integer getPkIdRegistoSaida() {
        return pkIdRegistoSaida;
    }

    public void setPkIdRegistoSaida(Integer pkIdRegistoSaida) {
        this.pkIdRegistoSaida = pkIdRegistoSaida;
    }

    public String getDiagnosticoDefinitivo() {
        return diagnosticoDefinitivo;
    }

    public void setDiagnosticoDefinitivo(String diagnosticoDefinitivo) {
        this.diagnosticoDefinitivo = diagnosticoDefinitivo;
    }

    public int getDiasHospitalizado() {
        return diasHospitalizado;
    }

    public void setDiasHospitalizado(int diasHospitalizado) {
        this.diasHospitalizado = diasHospitalizado;
    }

    public Date getDataRegistoSaida() {
        return dataRegistoSaida;
    }

    public void setDataRegistoSaida(Date dataRegistoSaida) {
        this.dataRegistoSaida = dataRegistoSaida;
    }

    public RhFuncionario getFkIdFuncionario() {
        return fkIdFuncionario;
    }

    public void setFkIdFuncionario(RhFuncionario fkIdFuncionario) {
        this.fkIdFuncionario = fkIdFuncionario;
    }

    public InterTituloAlta getFkIdTituloAlta() {
        return fkIdTituloAlta;
    }

    public void setFkIdTituloAlta(InterTituloAlta fkIdTituloAlta) {
        this.fkIdTituloAlta = fkIdTituloAlta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdRegistoSaida != null ? pkIdRegistoSaida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterRegistoSaida)) {
            return false;
        }
        InterRegistoSaida other = (InterRegistoSaida) object;
        if ((this.pkIdRegistoSaida == null && other.pkIdRegistoSaida != null) || (this.pkIdRegistoSaida != null && !this.pkIdRegistoSaida.equals(other.pkIdRegistoSaida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.InterRegistoSaida[ pkIdRegistoSaida=" + pkIdRegistoSaida + " ]";
    }
    
}
