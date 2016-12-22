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
@Table(name = "inter_resultado_doenca_internamento_paciente", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterResultadoDoencaInternamentoPaciente.findAll", query = "SELECT i FROM InterResultadoDoencaInternamentoPaciente i"),
    @NamedQuery(name = "InterResultadoDoencaInternamentoPaciente.findByPkIdResultadoDoencaIntercorrente", query = "SELECT i FROM InterResultadoDoencaInternamentoPaciente i WHERE i.pkIdResultadoDoencaIntercorrente = :pkIdResultadoDoencaIntercorrente"),
    @NamedQuery(name = "InterResultadoDoencaInternamentoPaciente.findByResultadoDoenca", query = "SELECT i FROM InterResultadoDoencaInternamentoPaciente i WHERE i.resultadoDoenca = :resultadoDoenca"),
    @NamedQuery(name = "InterResultadoDoencaInternamentoPaciente.findByInformacaoAdicional", query = "SELECT i FROM InterResultadoDoencaInternamentoPaciente i WHERE i.informacaoAdicional = :informacaoAdicional"),
    @NamedQuery(name = "InterResultadoDoencaInternamentoPaciente.findByDataResultadoDoenca", query = "SELECT i FROM InterResultadoDoencaInternamentoPaciente i WHERE i.dataResultadoDoenca = :dataResultadoDoenca")})
public class InterResultadoDoencaInternamentoPaciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_id_resultado_doenca_intercorrente")
    private Integer pkIdResultadoDoencaIntercorrente;
    @Size(max = 500)
    @Column(name = "resultado_doenca")
    private String resultadoDoenca;
    @Size(max = 100)
    @Column(name = "informacao_adicional")
    private String informacaoAdicional;
    @Column(name = "data_resultado_doenca")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataResultadoDoenca;
    @JoinColumn(name = "fk_id_doenca_internamento_paciente", referencedColumnName = "pk_id_doenca_internamento_paciente")
    @ManyToOne(optional = false)
    private InterDoencaInternamentoPaciente fkIdDoencaInternamentoPaciente;

    public InterResultadoDoencaInternamentoPaciente() {
    }

    public InterResultadoDoencaInternamentoPaciente(Integer pkIdResultadoDoencaIntercorrente) {
        this.pkIdResultadoDoencaIntercorrente = pkIdResultadoDoencaIntercorrente;
    }

    public Integer getPkIdResultadoDoencaIntercorrente() {
        return pkIdResultadoDoencaIntercorrente;
    }

    public void setPkIdResultadoDoencaIntercorrente(Integer pkIdResultadoDoencaIntercorrente) {
        this.pkIdResultadoDoencaIntercorrente = pkIdResultadoDoencaIntercorrente;
    }

    public String getResultadoDoenca() {
        return resultadoDoenca;
    }

    public void setResultadoDoenca(String resultadoDoenca) {
        this.resultadoDoenca = resultadoDoenca;
    }

    public String getInformacaoAdicional() {
        return informacaoAdicional;
    }

    public void setInformacaoAdicional(String informacaoAdicional) {
        this.informacaoAdicional = informacaoAdicional;
    }

    public Date getDataResultadoDoenca() {
        return dataResultadoDoenca;
    }

    public void setDataResultadoDoenca(Date dataResultadoDoenca) {
        this.dataResultadoDoenca = dataResultadoDoenca;
    }

    public InterDoencaInternamentoPaciente getFkIdDoencaInternamentoPaciente() {
        return fkIdDoencaInternamentoPaciente;
    }

    public void setFkIdDoencaInternamentoPaciente(InterDoencaInternamentoPaciente fkIdDoencaInternamentoPaciente) {
        this.fkIdDoencaInternamentoPaciente = fkIdDoencaInternamentoPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdResultadoDoencaIntercorrente != null ? pkIdResultadoDoencaIntercorrente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterResultadoDoencaInternamentoPaciente)) {
            return false;
        }
        InterResultadoDoencaInternamentoPaciente other = (InterResultadoDoencaInternamentoPaciente) object;
        if ((this.pkIdResultadoDoencaIntercorrente == null && other.pkIdResultadoDoencaIntercorrente != null) || (this.pkIdResultadoDoencaIntercorrente != null && !this.pkIdResultadoDoencaIntercorrente.equals(other.pkIdResultadoDoencaIntercorrente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.InterResultadoDoencaInternamentoPaciente[ pkIdResultadoDoencaIntercorrente=" + pkIdResultadoDoencaIntercorrente + " ]";
    }
    
}
