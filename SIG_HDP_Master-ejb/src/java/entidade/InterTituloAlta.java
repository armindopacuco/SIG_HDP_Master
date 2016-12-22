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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "inter_titulo_alta", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterTituloAlta.findAll", query = "SELECT i FROM InterTituloAlta i"),
    @NamedQuery(name = "InterTituloAlta.findByPkIdTituloAlta", query = "SELECT i FROM InterTituloAlta i WHERE i.pkIdTituloAlta = :pkIdTituloAlta"),
    @NamedQuery(name = "InterTituloAlta.findByResumoClinico", query = "SELECT i FROM InterTituloAlta i WHERE i.resumoClinico = :resumoClinico"),
    @NamedQuery(name = "InterTituloAlta.findByDiagnosticoAlta", query = "SELECT i FROM InterTituloAlta i WHERE i.diagnosticoAlta = :diagnosticoAlta"),
    @NamedQuery(name = "InterTituloAlta.findByDataAlta", query = "SELECT i FROM InterTituloAlta i WHERE i.dataAlta = :dataAlta"),
    @NamedQuery(name = "InterTituloAlta.findByResultadoDoencaPrincipal", query = "SELECT i FROM InterTituloAlta i WHERE i.resultadoDoencaPrincipal = :resultadoDoencaPrincipal")})
public class InterTituloAlta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_titulo_alta")
    private Integer pkIdTituloAlta;
    @Size(max = 1000)
    @Column(name = "resumo_clinico")
    private String resumoClinico;
    @Size(max = 1000)
    @Column(name = "diagnostico_alta")
    private String diagnosticoAlta;
    @Column(name = "data_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAlta;
    @Size(max = 1000)
    @Column(name = "resultado_doenca_principal")
    private String resultadoDoencaPrincipal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdTituloAlta")
    private List<InterConclusao> interConclusaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdTituloAlta")
    private List<InterRegistoSaida> interRegistoSaidaList;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne(optional = false)
    private RhFuncionario fkIdFuncionario;
    @JoinColumn(name = "fk_id_registo_internamento", referencedColumnName = "pk_id_registo_internamento")
    @ManyToOne(optional = false)
    private InterRegistoInternamento fkIdRegistoInternamento;

    public InterTituloAlta() {
    }

    public InterTituloAlta(Integer pkIdTituloAlta) {
        this.pkIdTituloAlta = pkIdTituloAlta;
    }

    public Integer getPkIdTituloAlta() {
        return pkIdTituloAlta;
    }

    public void setPkIdTituloAlta(Integer pkIdTituloAlta) {
        this.pkIdTituloAlta = pkIdTituloAlta;
    }

    public String getResumoClinico() {
        return resumoClinico;
    }

    public void setResumoClinico(String resumoClinico) {
        this.resumoClinico = resumoClinico;
    }

    public String getDiagnosticoAlta() {
        return diagnosticoAlta;
    }

    public void setDiagnosticoAlta(String diagnosticoAlta) {
        this.diagnosticoAlta = diagnosticoAlta;
    }

    public Date getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(Date dataAlta) {
        this.dataAlta = dataAlta;
    }

    public String getResultadoDoencaPrincipal() {
        return resultadoDoencaPrincipal;
    }

    public void setResultadoDoencaPrincipal(String resultadoDoencaPrincipal) {
        this.resultadoDoencaPrincipal = resultadoDoencaPrincipal;
    }

    @XmlTransient
    public List<InterConclusao> getInterConclusaoList() {
        return interConclusaoList;
    }

    public void setInterConclusaoList(List<InterConclusao> interConclusaoList) {
        this.interConclusaoList = interConclusaoList;
    }

    @XmlTransient
    public List<InterRegistoSaida> getInterRegistoSaidaList() {
        return interRegistoSaidaList;
    }

    public void setInterRegistoSaidaList(List<InterRegistoSaida> interRegistoSaidaList) {
        this.interRegistoSaidaList = interRegistoSaidaList;
    }

    public RhFuncionario getFkIdFuncionario() {
        return fkIdFuncionario;
    }

    public void setFkIdFuncionario(RhFuncionario fkIdFuncionario) {
        this.fkIdFuncionario = fkIdFuncionario;
    }

    public InterRegistoInternamento getFkIdRegistoInternamento() {
        return fkIdRegistoInternamento;
    }

    public void setFkIdRegistoInternamento(InterRegistoInternamento fkIdRegistoInternamento) {
        this.fkIdRegistoInternamento = fkIdRegistoInternamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdTituloAlta != null ? pkIdTituloAlta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterTituloAlta)) {
            return false;
        }
        InterTituloAlta other = (InterTituloAlta) object;
        if ((this.pkIdTituloAlta == null && other.pkIdTituloAlta != null) || (this.pkIdTituloAlta != null && !this.pkIdTituloAlta.equals(other.pkIdTituloAlta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.InterTituloAlta[ pkIdTituloAlta=" + pkIdTituloAlta + " ]";
    }
    
}
