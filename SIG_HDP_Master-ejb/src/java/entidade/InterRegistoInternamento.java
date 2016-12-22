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
@Table(name = "inter_registo_internamento", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterRegistoInternamento.findAll", query = "SELECT i FROM InterRegistoInternamento i"),
    @NamedQuery(name = "InterRegistoInternamento.findByPkIdRegistoInternamento", query = "SELECT i FROM InterRegistoInternamento i WHERE i.pkIdRegistoInternamento = :pkIdRegistoInternamento"),
    @NamedQuery(name = "InterRegistoInternamento.findByDataRegisto", query = "SELECT i FROM InterRegistoInternamento i WHERE i.dataRegisto = :dataRegisto"),
    @NamedQuery(name = "InterRegistoInternamento.findByFkIdDoencas", query = "SELECT i FROM InterRegistoInternamento i WHERE i.fkIdDoencas = :fkIdDoencas"),
    @NamedQuery(name = "InterRegistoInternamento.findByInformacaoAdicional", query = "SELECT i FROM InterRegistoInternamento i WHERE i.informacaoAdicional = :informacaoAdicional")})
public class InterRegistoInternamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_registo_internamento")
    private Integer pkIdRegistoInternamento;
    @Column(name = "data_registo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataRegisto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_id_doencas")
    private int fkIdDoencas;
    @Size(max = 500)
    @Column(name = "informacao_adicional")
    private String informacaoAdicional;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdRegistoInternamento")
    private List<InterTratamentoSistematico> interTratamentoSistematicoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdRegistoInternamento")
    private List<InterTabelaVigilancia> interTabelaVigilanciaList;
    @JoinColumn(name = "fk_id_funcionario_enfermeiro", referencedColumnName = "pk_id_funcionario")
    @ManyToOne(optional = false)
    private RhFuncionario fkIdFuncionarioEnfermeiro;
    @JoinColumn(name = "fk_id_funcionario_medico", referencedColumnName = "pk_id_funcionario")
    @ManyToOne(optional = false)
    private RhFuncionario fkIdFuncionarioMedico;
    @JoinColumn(name = "fk_id_quarto_internamento", referencedColumnName = "pk_id_quarto_internamento")
    @ManyToOne(optional = false)
    private InterQuartoInternamento fkIdQuartoInternamento;
    @JoinColumn(name = "fk_id_inscricao_internamento", referencedColumnName = "pk_id_inscricao_internamento")
    @ManyToOne(optional = false)
    private InterInscricaoInternamento fkIdInscricaoInternamento;
    @JoinColumn(name = "fk_id_enfermaria", referencedColumnName = "pk_id_enfermaria")
    @ManyToOne(optional = false)
    private InterEnfermaria fkIdEnfermaria;
    @JoinColumn(name = "fk_id_cama_internamento", referencedColumnName = "pk_id_cama_internamento")
    @ManyToOne(optional = false)
    private InterCamaInternamento fkIdCamaInternamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdRegistoInternamento")
    private List<InterAntropometria> interAntropometriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdRegistoInternamento")
    private List<InterDietaTerapeutica> interDietaTerapeuticaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdRegistoInternamento")
    private List<InterDoencaInternamentoPaciente> interDoencaInternamentoPacienteList;
    @OneToMany(mappedBy = "fkIdRegistoInternamento")
    private List<InterConclusao> interConclusaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdRegistoInternamento")
    private List<InterAberturaFichaContrTerapeutica> interAberturaFichaContrTerapeuticaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdRegistoInternamento")
    private List<InterTituloAlta> interTituloAltaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdRegistoInternamento")
    private List<InterTratamentoEspecifico> interTratamentoEspecificoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdRegistoInternamento")
    private List<InterVacinacao> interVacinacaoList;

    public InterRegistoInternamento() {
    }

    public InterRegistoInternamento(Integer pkIdRegistoInternamento) {
        this.pkIdRegistoInternamento = pkIdRegistoInternamento;
    }

    public InterRegistoInternamento(Integer pkIdRegistoInternamento, int fkIdDoencas) {
        this.pkIdRegistoInternamento = pkIdRegistoInternamento;
        this.fkIdDoencas = fkIdDoencas;
    }

    public Integer getPkIdRegistoInternamento() {
        return pkIdRegistoInternamento;
    }

    public void setPkIdRegistoInternamento(Integer pkIdRegistoInternamento) {
        this.pkIdRegistoInternamento = pkIdRegistoInternamento;
    }

    public Date getDataRegisto() {
        return dataRegisto;
    }

    public void setDataRegisto(Date dataRegisto) {
        this.dataRegisto = dataRegisto;
    }

    public int getFkIdDoencas() {
        return fkIdDoencas;
    }

    public void setFkIdDoencas(int fkIdDoencas) {
        this.fkIdDoencas = fkIdDoencas;
    }

    public String getInformacaoAdicional() {
        return informacaoAdicional;
    }

    public void setInformacaoAdicional(String informacaoAdicional) {
        this.informacaoAdicional = informacaoAdicional;
    }

    @XmlTransient
    public List<InterTratamentoSistematico> getInterTratamentoSistematicoList() {
        return interTratamentoSistematicoList;
    }

    public void setInterTratamentoSistematicoList(List<InterTratamentoSistematico> interTratamentoSistematicoList) {
        this.interTratamentoSistematicoList = interTratamentoSistematicoList;
    }

    @XmlTransient
    public List<InterTabelaVigilancia> getInterTabelaVigilanciaList() {
        return interTabelaVigilanciaList;
    }

    public void setInterTabelaVigilanciaList(List<InterTabelaVigilancia> interTabelaVigilanciaList) {
        this.interTabelaVigilanciaList = interTabelaVigilanciaList;
    }

    public RhFuncionario getFkIdFuncionarioEnfermeiro() {
        return fkIdFuncionarioEnfermeiro;
    }

    public void setFkIdFuncionarioEnfermeiro(RhFuncionario fkIdFuncionarioEnfermeiro) {
        this.fkIdFuncionarioEnfermeiro = fkIdFuncionarioEnfermeiro;
    }

    public RhFuncionario getFkIdFuncionarioMedico() {
        return fkIdFuncionarioMedico;
    }

    public void setFkIdFuncionarioMedico(RhFuncionario fkIdFuncionarioMedico) {
        this.fkIdFuncionarioMedico = fkIdFuncionarioMedico;
    }

    public InterQuartoInternamento getFkIdQuartoInternamento() {
        return fkIdQuartoInternamento;
    }

    public void setFkIdQuartoInternamento(InterQuartoInternamento fkIdQuartoInternamento) {
        this.fkIdQuartoInternamento = fkIdQuartoInternamento;
    }

    public InterInscricaoInternamento getFkIdInscricaoInternamento() {
        return fkIdInscricaoInternamento;
    }

    public void setFkIdInscricaoInternamento(InterInscricaoInternamento fkIdInscricaoInternamento) {
        this.fkIdInscricaoInternamento = fkIdInscricaoInternamento;
    }

    public InterEnfermaria getFkIdEnfermaria() {
        return fkIdEnfermaria;
    }

    public void setFkIdEnfermaria(InterEnfermaria fkIdEnfermaria) {
        this.fkIdEnfermaria = fkIdEnfermaria;
    }

    public InterCamaInternamento getFkIdCamaInternamento() {
        return fkIdCamaInternamento;
    }

    public void setFkIdCamaInternamento(InterCamaInternamento fkIdCamaInternamento) {
        this.fkIdCamaInternamento = fkIdCamaInternamento;
    }

    @XmlTransient
    public List<InterAntropometria> getInterAntropometriaList() {
        return interAntropometriaList;
    }

    public void setInterAntropometriaList(List<InterAntropometria> interAntropometriaList) {
        this.interAntropometriaList = interAntropometriaList;
    }

    @XmlTransient
    public List<InterDietaTerapeutica> getInterDietaTerapeuticaList() {
        return interDietaTerapeuticaList;
    }

    public void setInterDietaTerapeuticaList(List<InterDietaTerapeutica> interDietaTerapeuticaList) {
        this.interDietaTerapeuticaList = interDietaTerapeuticaList;
    }

    @XmlTransient
    public List<InterDoencaInternamentoPaciente> getInterDoencaInternamentoPacienteList() {
        return interDoencaInternamentoPacienteList;
    }

    public void setInterDoencaInternamentoPacienteList(List<InterDoencaInternamentoPaciente> interDoencaInternamentoPacienteList) {
        this.interDoencaInternamentoPacienteList = interDoencaInternamentoPacienteList;
    }

    @XmlTransient
    public List<InterConclusao> getInterConclusaoList() {
        return interConclusaoList;
    }

    public void setInterConclusaoList(List<InterConclusao> interConclusaoList) {
        this.interConclusaoList = interConclusaoList;
    }

    @XmlTransient
    public List<InterAberturaFichaContrTerapeutica> getInterAberturaFichaContrTerapeuticaList() {
        return interAberturaFichaContrTerapeuticaList;
    }

    public void setInterAberturaFichaContrTerapeuticaList(List<InterAberturaFichaContrTerapeutica> interAberturaFichaContrTerapeuticaList) {
        this.interAberturaFichaContrTerapeuticaList = interAberturaFichaContrTerapeuticaList;
    }

    @XmlTransient
    public List<InterTituloAlta> getInterTituloAltaList() {
        return interTituloAltaList;
    }

    public void setInterTituloAltaList(List<InterTituloAlta> interTituloAltaList) {
        this.interTituloAltaList = interTituloAltaList;
    }

    @XmlTransient
    public List<InterTratamentoEspecifico> getInterTratamentoEspecificoList() {
        return interTratamentoEspecificoList;
    }

    public void setInterTratamentoEspecificoList(List<InterTratamentoEspecifico> interTratamentoEspecificoList) {
        this.interTratamentoEspecificoList = interTratamentoEspecificoList;
    }

    @XmlTransient
    public List<InterVacinacao> getInterVacinacaoList() {
        return interVacinacaoList;
    }

    public void setInterVacinacaoList(List<InterVacinacao> interVacinacaoList) {
        this.interVacinacaoList = interVacinacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdRegistoInternamento != null ? pkIdRegistoInternamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterRegistoInternamento)) {
            return false;
        }
        InterRegistoInternamento other = (InterRegistoInternamento) object;
        if ((this.pkIdRegistoInternamento == null && other.pkIdRegistoInternamento != null) || (this.pkIdRegistoInternamento != null && !this.pkIdRegistoInternamento.equals(other.pkIdRegistoInternamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.InterRegistoInternamento[ pkIdRegistoInternamento=" + pkIdRegistoInternamento + " ]";
    }
    
}
