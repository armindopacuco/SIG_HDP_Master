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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "inter_doenca_internamento_paciente", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterDoencaInternamentoPaciente.findAll", query = "SELECT i FROM InterDoencaInternamentoPaciente i"),
    @NamedQuery(name = "InterDoencaInternamentoPaciente.findByPkIdDoencaInternamentoPaciente", query = "SELECT i FROM InterDoencaInternamentoPaciente i WHERE i.pkIdDoencaInternamentoPaciente = :pkIdDoencaInternamentoPaciente"),
    @NamedQuery(name = "InterDoencaInternamentoPaciente.findByInformacaoAdicional", query = "SELECT i FROM InterDoencaInternamentoPaciente i WHERE i.informacaoAdicional = :informacaoAdicional"),
    @NamedQuery(name = "InterDoencaInternamentoPaciente.findByDataDiagnostico", query = "SELECT i FROM InterDoencaInternamentoPaciente i WHERE i.dataDiagnostico = :dataDiagnostico")})
public class InterDoencaInternamentoPaciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_doenca_internamento_paciente")
    private Integer pkIdDoencaInternamentoPaciente;
    @Size(max = 200)
    @Column(name = "informacao_adicional")
    private String informacaoAdicional;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_diagnostico")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDiagnostico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdDoencaInternamentoPaciente")
    private List<InterResultadoDoencaInternamentoPaciente> interResultadoDoencaInternamentoPacienteList;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne(optional = false)
    private RhFuncionario fkIdFuncionario;
    @JoinColumn(name = "fk_id_tipo_doenca_intenamento", referencedColumnName = "pk_id_tipo_doenca_internamento")
    @ManyToOne(optional = false)
    private InterTipoDoencaInternamento fkIdTipoDoencaIntenamento;
    @JoinColumn(name = "fk_id_registo_internamento", referencedColumnName = "pk_id_registo_internamento")
    @ManyToOne(optional = false)
    private InterRegistoInternamento fkIdRegistoInternamento;
    @JoinColumn(name = "fk_id_doenca", referencedColumnName = "pk_id_doenca")
    @ManyToOne(optional = false)
    private AmbDoenca fkIdDoenca;

    public InterDoencaInternamentoPaciente() {
    }

    public InterDoencaInternamentoPaciente(Integer pkIdDoencaInternamentoPaciente) {
        this.pkIdDoencaInternamentoPaciente = pkIdDoencaInternamentoPaciente;
    }

    public InterDoencaInternamentoPaciente(Integer pkIdDoencaInternamentoPaciente, Date dataDiagnostico) {
        this.pkIdDoencaInternamentoPaciente = pkIdDoencaInternamentoPaciente;
        this.dataDiagnostico = dataDiagnostico;
    }

    public Integer getPkIdDoencaInternamentoPaciente() {
        return pkIdDoencaInternamentoPaciente;
    }

    public void setPkIdDoencaInternamentoPaciente(Integer pkIdDoencaInternamentoPaciente) {
        this.pkIdDoencaInternamentoPaciente = pkIdDoencaInternamentoPaciente;
    }

    public String getInformacaoAdicional() {
        return informacaoAdicional;
    }

    public void setInformacaoAdicional(String informacaoAdicional) {
        this.informacaoAdicional = informacaoAdicional;
    }

    public Date getDataDiagnostico() {
        return dataDiagnostico;
    }

    public void setDataDiagnostico(Date dataDiagnostico) {
        this.dataDiagnostico = dataDiagnostico;
    }

    @XmlTransient
    public List<InterResultadoDoencaInternamentoPaciente> getInterResultadoDoencaInternamentoPacienteList() {
        return interResultadoDoencaInternamentoPacienteList;
    }

    public void setInterResultadoDoencaInternamentoPacienteList(List<InterResultadoDoencaInternamentoPaciente> interResultadoDoencaInternamentoPacienteList) {
        this.interResultadoDoencaInternamentoPacienteList = interResultadoDoencaInternamentoPacienteList;
    }

    public RhFuncionario getFkIdFuncionario() {
        return fkIdFuncionario;
    }

    public void setFkIdFuncionario(RhFuncionario fkIdFuncionario) {
        this.fkIdFuncionario = fkIdFuncionario;
    }

    public InterTipoDoencaInternamento getFkIdTipoDoencaIntenamento() {
        return fkIdTipoDoencaIntenamento;
    }

    public void setFkIdTipoDoencaIntenamento(InterTipoDoencaInternamento fkIdTipoDoencaIntenamento) {
        this.fkIdTipoDoencaIntenamento = fkIdTipoDoencaIntenamento;
    }

    public InterRegistoInternamento getFkIdRegistoInternamento() {
        return fkIdRegistoInternamento;
    }

    public void setFkIdRegistoInternamento(InterRegistoInternamento fkIdRegistoInternamento) {
        this.fkIdRegistoInternamento = fkIdRegistoInternamento;
    }

    public AmbDoenca getFkIdDoenca() {
        return fkIdDoenca;
    }

    public void setFkIdDoenca(AmbDoenca fkIdDoenca) {
        this.fkIdDoenca = fkIdDoenca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdDoencaInternamentoPaciente != null ? pkIdDoencaInternamentoPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterDoencaInternamentoPaciente)) {
            return false;
        }
        InterDoencaInternamentoPaciente other = (InterDoencaInternamentoPaciente) object;
        if ((this.pkIdDoencaInternamentoPaciente == null && other.pkIdDoencaInternamentoPaciente != null) || (this.pkIdDoencaInternamentoPaciente != null && !this.pkIdDoencaInternamentoPaciente.equals(other.pkIdDoencaInternamentoPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.InterDoencaInternamentoPaciente[ pkIdDoencaInternamentoPaciente=" + pkIdDoencaInternamentoPaciente + " ]";
    }
    
}
