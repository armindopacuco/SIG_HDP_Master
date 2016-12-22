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
import javax.persistence.OneToOne;
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
@Table(name = "rh_candidato", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhCandidato.findAll", query = "SELECT r FROM RhCandidato r"),
    @NamedQuery(name = "RhCandidato.findByPkIdCandidato", query = "SELECT r FROM RhCandidato r WHERE r.pkIdCandidato = :pkIdCandidato"),
    @NamedQuery(name = "RhCandidato.findByUltimoEmprego", query = "SELECT r FROM RhCandidato r WHERE r.ultimoEmprego = :ultimoEmprego"),
    @NamedQuery(name = "RhCandidato.findByObservacoes", query = "SELECT r FROM RhCandidato r WHERE r.observacoes = :observacoes"),
    @NamedQuery(name = "RhCandidato.findByDataCadastro", query = "SELECT r FROM RhCandidato r WHERE r.dataCadastro = :dataCadastro"),
    @NamedQuery(name = "RhCandidato.findByFkIdComprovativoMedico", query = "SELECT r FROM RhCandidato r WHERE r.fkIdComprovativoMedico = :fkIdComprovativoMedico"),
    @NamedQuery(name = "RhCandidato.findByFkIdAtestadoMedico", query = "SELECT r FROM RhCandidato r WHERE r.fkIdAtestadoMedico = :fkIdAtestadoMedico"),
    @NamedQuery(name = "RhCandidato.findByNumeroCandidato", query = "SELECT r FROM RhCandidato r WHERE r.numeroCandidato = :numeroCandidato"),
    @NamedQuery(name = "RhCandidato.findByAnoInicioEstudos", query = "SELECT r FROM RhCandidato r WHERE r.anoInicioEstudos = :anoInicioEstudos"),
    @NamedQuery(name = "RhCandidato.findByAnoFimEstudos", query = "SELECT r FROM RhCandidato r WHERE r.anoFimEstudos = :anoFimEstudos"),
    @NamedQuery(name = "RhCandidato.findByOrigem", query = "SELECT r FROM RhCandidato r WHERE r.origem = :origem")})
public class RhCandidato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_candidato")
    private Integer pkIdCandidato;
    @Size(max = 45)
    @Column(name = "ultimo_emprego")
    private String ultimoEmprego;
    @Size(max = 45)
    @Column(name = "observacoes")
    private String observacoes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_id_comprovativo_medico")
    private int fkIdComprovativoMedico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_id_atestado_medico")
    private int fkIdAtestadoMedico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numero_candidato")
    private String numeroCandidato;
    @Column(name = "ano_inicio_estudos")
    private Integer anoInicioEstudos;
    @Column(name = "ano_fim_estudos")
    private Integer anoFimEstudos;
    @Size(max = 60)
    @Column(name = "origem")
    private String origem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdCandidato")
    private List<RhCandidatoHasRhTipoFalta> rhCandidatoHasRhTipoFaltaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdCandidato")
    private List<SupiEstagiario> supiEstagiarioList;
    @JoinColumn(name = "fk_id_tipo_candidatura", referencedColumnName = "pk_id_tipo_candidatura")
    @ManyToOne(optional = false)
    private RhTipoCandidatura fkIdTipoCandidatura;
    @JoinColumn(name = "fk_id_nivel_academico", referencedColumnName = "pk_id_nivel_academico")
    @ManyToOne(optional = false)
    private RhNivelAcademico fkIdNivelAcademico;
    @JoinColumn(name = "fk_id_estado_candidato", referencedColumnName = "pk_id_estado_candidato")
    @ManyToOne(optional = false)
    private RhEstadoCandidato fkIdEstadoCandidato;
    @JoinColumn(name = "fk_id_curso", referencedColumnName = "pk_id_curso")
    @ManyToOne
    private RhCurso fkIdCurso;
    @JoinColumn(name = "fk_id_categoria", referencedColumnName = "pk_id_categoria_profissao")
    @ManyToOne
    private RhCategoriaProfissao fkIdCategoria;
    @JoinColumn(name = "fk_id_pessoa", referencedColumnName = "pk_id_pessoa")
    @OneToOne(optional = false)
    private GrlPessoa fkIdPessoa;
    @JoinColumn(name = "fk_id_bi", referencedColumnName = "pk_id_ficheiro_anexado")
    @ManyToOne(optional = false)
    private GrlFicheiroAnexado fkIdBi;
    @JoinColumn(name = "fk_id_doc_militar", referencedColumnName = "pk_id_ficheiro_anexado")
    @ManyToOne(optional = false)
    private GrlFicheiroAnexado fkIdDocMilitar;
    @JoinColumn(name = "fk_id_curriculum_vitae", referencedColumnName = "pk_id_ficheiro_anexado")
    @ManyToOne(optional = false)
    private GrlFicheiroAnexado fkIdCurriculumVitae;
    @JoinColumn(name = "fk_id_certificado_habilitacoes", referencedColumnName = "pk_id_ficheiro_anexado")
    @ManyToOne(optional = false)
    private GrlFicheiroAnexado fkIdCertificadoHabilitacoes;
    @JoinColumn(name = "fk_id_cedula_carteira", referencedColumnName = "pk_id_ficheiro_anexado")
    @ManyToOne(optional = false)
    private GrlFicheiroAnexado fkIdCedulaCarteira;
    @JoinColumn(name = "fk_registo_criminal", referencedColumnName = "pk_id_ficheiro_anexado")
    @ManyToOne(optional = false)
    private GrlFicheiroAnexado fkRegistoCriminal;
    @OneToMany(mappedBy = "fkIdCandidato")
    private List<RhContrato> rhContratoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdCategoria")
    private List<RhFuncionario> rhFuncionarioList;

    public RhCandidato() {
    }

    public RhCandidato(Integer pkIdCandidato) {
        this.pkIdCandidato = pkIdCandidato;
    }

    public RhCandidato(Integer pkIdCandidato, Date dataCadastro, int fkIdComprovativoMedico, int fkIdAtestadoMedico, String numeroCandidato) {
        this.pkIdCandidato = pkIdCandidato;
        this.dataCadastro = dataCadastro;
        this.fkIdComprovativoMedico = fkIdComprovativoMedico;
        this.fkIdAtestadoMedico = fkIdAtestadoMedico;
        this.numeroCandidato = numeroCandidato;
    }

    public Integer getPkIdCandidato() {
        return pkIdCandidato;
    }

    public void setPkIdCandidato(Integer pkIdCandidato) {
        this.pkIdCandidato = pkIdCandidato;
    }

    public String getUltimoEmprego() {
        return ultimoEmprego;
    }

    public void setUltimoEmprego(String ultimoEmprego) {
        this.ultimoEmprego = ultimoEmprego;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public int getFkIdComprovativoMedico() {
        return fkIdComprovativoMedico;
    }

    public void setFkIdComprovativoMedico(int fkIdComprovativoMedico) {
        this.fkIdComprovativoMedico = fkIdComprovativoMedico;
    }

    public int getFkIdAtestadoMedico() {
        return fkIdAtestadoMedico;
    }

    public void setFkIdAtestadoMedico(int fkIdAtestadoMedico) {
        this.fkIdAtestadoMedico = fkIdAtestadoMedico;
    }

    public String getNumeroCandidato() {
        return numeroCandidato;
    }

    public void setNumeroCandidato(String numeroCandidato) {
        this.numeroCandidato = numeroCandidato;
    }

    public Integer getAnoInicioEstudos() {
        return anoInicioEstudos;
    }

    public void setAnoInicioEstudos(Integer anoInicioEstudos) {
        this.anoInicioEstudos = anoInicioEstudos;
    }

    public Integer getAnoFimEstudos() {
        return anoFimEstudos;
    }

    public void setAnoFimEstudos(Integer anoFimEstudos) {
        this.anoFimEstudos = anoFimEstudos;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    @XmlTransient
    public List<RhCandidatoHasRhTipoFalta> getRhCandidatoHasRhTipoFaltaList() {
        return rhCandidatoHasRhTipoFaltaList;
    }

    public void setRhCandidatoHasRhTipoFaltaList(List<RhCandidatoHasRhTipoFalta> rhCandidatoHasRhTipoFaltaList) {
        this.rhCandidatoHasRhTipoFaltaList = rhCandidatoHasRhTipoFaltaList;
    }

    @XmlTransient
    public List<SupiEstagiario> getSupiEstagiarioList() {
        return supiEstagiarioList;
    }

    public void setSupiEstagiarioList(List<SupiEstagiario> supiEstagiarioList) {
        this.supiEstagiarioList = supiEstagiarioList;
    }

    public RhTipoCandidatura getFkIdTipoCandidatura() {
        return fkIdTipoCandidatura;
    }

    public void setFkIdTipoCandidatura(RhTipoCandidatura fkIdTipoCandidatura) {
        this.fkIdTipoCandidatura = fkIdTipoCandidatura;
    }

    public RhNivelAcademico getFkIdNivelAcademico() {
        return fkIdNivelAcademico;
    }

    public void setFkIdNivelAcademico(RhNivelAcademico fkIdNivelAcademico) {
        this.fkIdNivelAcademico = fkIdNivelAcademico;
    }

    public RhEstadoCandidato getFkIdEstadoCandidato() {
        return fkIdEstadoCandidato;
    }

    public void setFkIdEstadoCandidato(RhEstadoCandidato fkIdEstadoCandidato) {
        this.fkIdEstadoCandidato = fkIdEstadoCandidato;
    }

    public RhCurso getFkIdCurso() {
        return fkIdCurso;
    }

    public void setFkIdCurso(RhCurso fkIdCurso) {
        this.fkIdCurso = fkIdCurso;
    }

    public RhCategoriaProfissao getFkIdCategoria() {
        return fkIdCategoria;
    }

    public void setFkIdCategoria(RhCategoriaProfissao fkIdCategoria) {
        this.fkIdCategoria = fkIdCategoria;
    }

    public GrlPessoa getFkIdPessoa() {
        return fkIdPessoa;
    }

    public void setFkIdPessoa(GrlPessoa fkIdPessoa) {
        this.fkIdPessoa = fkIdPessoa;
    }

    public GrlFicheiroAnexado getFkIdBi() {
        return fkIdBi;
    }

    public void setFkIdBi(GrlFicheiroAnexado fkIdBi) {
        this.fkIdBi = fkIdBi;
    }

    public GrlFicheiroAnexado getFkIdDocMilitar() {
        return fkIdDocMilitar;
    }

    public void setFkIdDocMilitar(GrlFicheiroAnexado fkIdDocMilitar) {
        this.fkIdDocMilitar = fkIdDocMilitar;
    }

    public GrlFicheiroAnexado getFkIdCurriculumVitae() {
        return fkIdCurriculumVitae;
    }

    public void setFkIdCurriculumVitae(GrlFicheiroAnexado fkIdCurriculumVitae) {
        this.fkIdCurriculumVitae = fkIdCurriculumVitae;
    }

    public GrlFicheiroAnexado getFkIdCertificadoHabilitacoes() {
        return fkIdCertificadoHabilitacoes;
    }

    public void setFkIdCertificadoHabilitacoes(GrlFicheiroAnexado fkIdCertificadoHabilitacoes) {
        this.fkIdCertificadoHabilitacoes = fkIdCertificadoHabilitacoes;
    }

    public GrlFicheiroAnexado getFkIdCedulaCarteira() {
        return fkIdCedulaCarteira;
    }

    public void setFkIdCedulaCarteira(GrlFicheiroAnexado fkIdCedulaCarteira) {
        this.fkIdCedulaCarteira = fkIdCedulaCarteira;
    }

    public GrlFicheiroAnexado getFkRegistoCriminal() {
        return fkRegistoCriminal;
    }

    public void setFkRegistoCriminal(GrlFicheiroAnexado fkRegistoCriminal) {
        this.fkRegistoCriminal = fkRegistoCriminal;
    }

    @XmlTransient
    public List<RhContrato> getRhContratoList() {
        return rhContratoList;
    }

    public void setRhContratoList(List<RhContrato> rhContratoList) {
        this.rhContratoList = rhContratoList;
    }

    @XmlTransient
    public List<RhFuncionario> getRhFuncionarioList() {
        return rhFuncionarioList;
    }

    public void setRhFuncionarioList(List<RhFuncionario> rhFuncionarioList) {
        this.rhFuncionarioList = rhFuncionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdCandidato != null ? pkIdCandidato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhCandidato)) {
            return false;
        }
        RhCandidato other = (RhCandidato) object;
        if ((this.pkIdCandidato == null && other.pkIdCandidato != null) || (this.pkIdCandidato != null && !this.pkIdCandidato.equals(other.pkIdCandidato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.RhCandidato[ pkIdCandidato=" + pkIdCandidato + " ]";
    }
    
}
