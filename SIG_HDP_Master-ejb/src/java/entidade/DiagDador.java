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
@Table(name = "diag_dador", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagDador.findAll", query = "SELECT d FROM DiagDador d"),
    @NamedQuery(name = "DiagDador.findByPkIdDador", query = "SELECT d FROM DiagDador d WHERE d.pkIdDador = :pkIdDador"),
    @NamedQuery(name = "DiagDador.findByLocalTrabalho", query = "SELECT d FROM DiagDador d WHERE d.localTrabalho = :localTrabalho"),
    @NamedQuery(name = "DiagDador.findByDadivaAnterior", query = "SELECT d FROM DiagDador d WHERE d.dadivaAnterior = :dadivaAnterior"),
    @NamedQuery(name = "DiagDador.findByDataUltimaDadiva", query = "SELECT d FROM DiagDador d WHERE d.dataUltimaDadiva = :dataUltimaDadiva"),
    @NamedQuery(name = "DiagDador.findByLocalColheita", query = "SELECT d FROM DiagDador d WHERE d.localColheita = :localColheita")})
public class DiagDador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_dador")
    private Integer pkIdDador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "local_trabalho")
    private String localTrabalho;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dadiva_anterior")
    private int dadivaAnterior;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_ultima_dadiva")
    @Temporal(TemporalType.DATE)
    private Date dataUltimaDadiva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "local_colheita")
    private String localColheita;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdDador")
    private List<DiagBolsaSangue> diagBolsaSangueList;
    @JoinColumn(name = "fk_id_instituicao_ultima_dadiva", referencedColumnName = "pk_id_instituicao")
    @ManyToOne
    private GrlInstituicao fkIdInstituicaoUltimaDadiva;
    @JoinColumn(name = "fk_id_triagem", referencedColumnName = "pk_id_triagem")
    @ManyToOne
    private DiagTriagem fkIdTriagem;
    @JoinColumn(name = "fk_id_tipo_doacoes_seguintes", referencedColumnName = "pk_id_tipo_doacao")
    @ManyToOne(optional = false)
    private DiagTipoDoacao fkIdTipoDoacoesSeguintes;
    @JoinColumn(name = "fk_id_tipo_primeira_doacao", referencedColumnName = "pk_id_tipo_doacao")
    @ManyToOne(optional = false)
    private DiagTipoDoacao fkIdTipoPrimeiraDoacao;
    @JoinColumn(name = "fk_id_tipo_doacao", referencedColumnName = "pk_id_tipo_doacao")
    @ManyToOne(optional = false)
    private DiagTipoDoacao fkIdTipoDoacao;
    @JoinColumn(name = "fk_id_grupo_sanguineo", referencedColumnName = "pk_id_grupo_sanguineo")
    @ManyToOne(optional = false)
    private DiagGrupoSanguineo fkIdGrupoSanguineo;
    @JoinColumn(name = "fk_id_exame_candidato_dador", referencedColumnName = "pk_id_exame_dador")
    @ManyToOne(optional = false)
    private DiagExameDador fkIdExameCandidatoDador;

    public DiagDador() {
    }

    public DiagDador(Integer pkIdDador) {
        this.pkIdDador = pkIdDador;
    }

    public DiagDador(Integer pkIdDador, String localTrabalho, int dadivaAnterior, Date dataUltimaDadiva, String localColheita) {
        this.pkIdDador = pkIdDador;
        this.localTrabalho = localTrabalho;
        this.dadivaAnterior = dadivaAnterior;
        this.dataUltimaDadiva = dataUltimaDadiva;
        this.localColheita = localColheita;
    }

    public Integer getPkIdDador() {
        return pkIdDador;
    }

    public void setPkIdDador(Integer pkIdDador) {
        this.pkIdDador = pkIdDador;
    }

    public String getLocalTrabalho() {
        return localTrabalho;
    }

    public void setLocalTrabalho(String localTrabalho) {
        this.localTrabalho = localTrabalho;
    }

    public int getDadivaAnterior() {
        return dadivaAnterior;
    }

    public void setDadivaAnterior(int dadivaAnterior) {
        this.dadivaAnterior = dadivaAnterior;
    }

    public Date getDataUltimaDadiva() {
        return dataUltimaDadiva;
    }

    public void setDataUltimaDadiva(Date dataUltimaDadiva) {
        this.dataUltimaDadiva = dataUltimaDadiva;
    }

    public String getLocalColheita() {
        return localColheita;
    }

    public void setLocalColheita(String localColheita) {
        this.localColheita = localColheita;
    }

    @XmlTransient
    public List<DiagBolsaSangue> getDiagBolsaSangueList() {
        return diagBolsaSangueList;
    }

    public void setDiagBolsaSangueList(List<DiagBolsaSangue> diagBolsaSangueList) {
        this.diagBolsaSangueList = diagBolsaSangueList;
    }

    public GrlInstituicao getFkIdInstituicaoUltimaDadiva() {
        return fkIdInstituicaoUltimaDadiva;
    }

    public void setFkIdInstituicaoUltimaDadiva(GrlInstituicao fkIdInstituicaoUltimaDadiva) {
        this.fkIdInstituicaoUltimaDadiva = fkIdInstituicaoUltimaDadiva;
    }

    public DiagTriagem getFkIdTriagem() {
        return fkIdTriagem;
    }

    public void setFkIdTriagem(DiagTriagem fkIdTriagem) {
        this.fkIdTriagem = fkIdTriagem;
    }

    public DiagTipoDoacao getFkIdTipoDoacoesSeguintes() {
        return fkIdTipoDoacoesSeguintes;
    }

    public void setFkIdTipoDoacoesSeguintes(DiagTipoDoacao fkIdTipoDoacoesSeguintes) {
        this.fkIdTipoDoacoesSeguintes = fkIdTipoDoacoesSeguintes;
    }

    public DiagTipoDoacao getFkIdTipoPrimeiraDoacao() {
        return fkIdTipoPrimeiraDoacao;
    }

    public void setFkIdTipoPrimeiraDoacao(DiagTipoDoacao fkIdTipoPrimeiraDoacao) {
        this.fkIdTipoPrimeiraDoacao = fkIdTipoPrimeiraDoacao;
    }

    public DiagTipoDoacao getFkIdTipoDoacao() {
        return fkIdTipoDoacao;
    }

    public void setFkIdTipoDoacao(DiagTipoDoacao fkIdTipoDoacao) {
        this.fkIdTipoDoacao = fkIdTipoDoacao;
    }

    public DiagGrupoSanguineo getFkIdGrupoSanguineo() {
        return fkIdGrupoSanguineo;
    }

    public void setFkIdGrupoSanguineo(DiagGrupoSanguineo fkIdGrupoSanguineo) {
        this.fkIdGrupoSanguineo = fkIdGrupoSanguineo;
    }

    public DiagExameDador getFkIdExameCandidatoDador() {
        return fkIdExameCandidatoDador;
    }

    public void setFkIdExameCandidatoDador(DiagExameDador fkIdExameCandidatoDador) {
        this.fkIdExameCandidatoDador = fkIdExameCandidatoDador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdDador != null ? pkIdDador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagDador)) {
            return false;
        }
        DiagDador other = (DiagDador) object;
        if ((this.pkIdDador == null && other.pkIdDador != null) || (this.pkIdDador != null && !this.pkIdDador.equals(other.pkIdDador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.DiagDador[ pkIdDador=" + pkIdDador + " ]";
    }
    
}
