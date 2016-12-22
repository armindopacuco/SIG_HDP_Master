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
@Table(name = "grl_pessoa", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrlPessoa.findAll", query = "SELECT g FROM GrlPessoa g"),
    @NamedQuery(name = "GrlPessoa.findByPkIdPessoa", query = "SELECT g FROM GrlPessoa g WHERE g.pkIdPessoa = :pkIdPessoa"),
    @NamedQuery(name = "GrlPessoa.findByNomeCompleto", query = "SELECT g FROM GrlPessoa g WHERE g.nomeCompleto = :nomeCompleto"),
    @NamedQuery(name = "GrlPessoa.findByDataNascimento", query = "SELECT g FROM GrlPessoa g WHERE g.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "GrlPessoa.findByNomePai", query = "SELECT g FROM GrlPessoa g WHERE g.nomePai = :nomePai"),
    @NamedQuery(name = "GrlPessoa.findByDataNascimentoPai", query = "SELECT g FROM GrlPessoa g WHERE g.dataNascimentoPai = :dataNascimentoPai"),
    @NamedQuery(name = "GrlPessoa.findByNomeMae", query = "SELECT g FROM GrlPessoa g WHERE g.nomeMae = :nomeMae"),
    @NamedQuery(name = "GrlPessoa.findByDataNascimentoMae", query = "SELECT g FROM GrlPessoa g WHERE g.dataNascimentoMae = :dataNascimentoMae"),
    @NamedQuery(name = "GrlPessoa.findByNumeroPessoa", query = "SELECT g FROM GrlPessoa g WHERE g.numeroPessoa = :numeroPessoa"),
    @NamedQuery(name = "GrlPessoa.findByDataCadastro", query = "SELECT g FROM GrlPessoa g WHERE g.dataCadastro = :dataCadastro")})
public class GrlPessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_pessoa")
    private Integer pkIdPessoa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nome_completo")
    private String nomeCompleto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Size(max = 45)
    @Column(name = "nome_pai")
    private String nomePai;
    @Column(name = "data_nascimento_pai")
    @Temporal(TemporalType.DATE)
    private Date dataNascimentoPai;
    @Size(max = 45)
    @Column(name = "nome_mae")
    private String nomeMae;
    @Column(name = "data_nascimento_mae")
    @Temporal(TemporalType.DATE)
    private Date dataNascimentoMae;
    @Column(name = "numero_pessoa")
    private Integer numeroPessoa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdPessoa")
    private List<AdmsPaciente> admsPacienteList;
    @JoinColumn(name = "fk_id_sexo", referencedColumnName = "pk_id_sexo")
    @ManyToOne(optional = false)
    private GrlSexo fkIdSexo;
    @JoinColumn(name = "fk_id_religiao", referencedColumnName = "pk_id_religiao")
    @ManyToOne(optional = false)
    private GrlReligiao fkIdReligiao;
    @JoinColumn(name = "fk_id_nacionalidade", referencedColumnName = "pk_id_pais")
    @ManyToOne
    private GrlPais fkIdNacionalidade;
    @JoinColumn(name = "fk_id_foto", referencedColumnName = "pk_id_ficheiro_anexado")
    @ManyToOne(optional = false)
    private GrlFicheiroAnexado fkIdFoto;
    @JoinColumn(name = "fk_id_estado_civil", referencedColumnName = "pk_id_estado_civil")
    @ManyToOne(optional = false)
    private GrlEstadoCivil fkIdEstadoCivil;
    @JoinColumn(name = "fk_id_endereco", referencedColumnName = "pk_id_endereco")
    @ManyToOne(optional = false)
    private GrlEndereco fkIdEndereco;
    @JoinColumn(name = "fk_id_documento_identificacao", referencedColumnName = "pk_id_documento")
    @ManyToOne(optional = false)
    private GrlDocumentoIdentificacao fkIdDocumentoIdentificacao;
    @JoinColumn(name = "fk_id_contacto", referencedColumnName = "pk_id_contacto")
    @ManyToOne(optional = false)
    private GrlContacto fkIdContacto;
    @JoinColumn(name = "fk_id_conjuge_pessoa", referencedColumnName = "pk_id_conjuge_pessoa")
    @ManyToOne(optional = false)
    private GrlConjugePessoa fkIdConjugePessoa;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "fkIdPessoa")
    private RhCandidato rhCandidato;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "fkIdPessoa")
    private RhFuncionario rhFuncionario;

    public GrlPessoa() {
    }

    public GrlPessoa(Integer pkIdPessoa) {
        this.pkIdPessoa = pkIdPessoa;
    }

    public GrlPessoa(Integer pkIdPessoa, String nomeCompleto, Date dataNascimento, Date dataCadastro) {
        this.pkIdPessoa = pkIdPessoa;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dataCadastro;
    }

    public Integer getPkIdPessoa() {
        return pkIdPessoa;
    }

    public void setPkIdPessoa(Integer pkIdPessoa) {
        this.pkIdPessoa = pkIdPessoa;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public Date getDataNascimentoPai() {
        return dataNascimentoPai;
    }

    public void setDataNascimentoPai(Date dataNascimentoPai) {
        this.dataNascimentoPai = dataNascimentoPai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public Date getDataNascimentoMae() {
        return dataNascimentoMae;
    }

    public void setDataNascimentoMae(Date dataNascimentoMae) {
        this.dataNascimentoMae = dataNascimentoMae;
    }

    public Integer getNumeroPessoa() {
        return numeroPessoa;
    }

    public void setNumeroPessoa(Integer numeroPessoa) {
        this.numeroPessoa = numeroPessoa;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @XmlTransient
    public List<AdmsPaciente> getAdmsPacienteList() {
        return admsPacienteList;
    }

    public void setAdmsPacienteList(List<AdmsPaciente> admsPacienteList) {
        this.admsPacienteList = admsPacienteList;
    }

    public GrlSexo getFkIdSexo() {
        return fkIdSexo;
    }

    public void setFkIdSexo(GrlSexo fkIdSexo) {
        this.fkIdSexo = fkIdSexo;
    }

    public GrlReligiao getFkIdReligiao() {
        return fkIdReligiao;
    }

    public void setFkIdReligiao(GrlReligiao fkIdReligiao) {
        this.fkIdReligiao = fkIdReligiao;
    }

    public GrlPais getFkIdNacionalidade() {
        return fkIdNacionalidade;
    }

    public void setFkIdNacionalidade(GrlPais fkIdNacionalidade) {
        this.fkIdNacionalidade = fkIdNacionalidade;
    }

    public GrlFicheiroAnexado getFkIdFoto() {
        return fkIdFoto;
    }

    public void setFkIdFoto(GrlFicheiroAnexado fkIdFoto) {
        this.fkIdFoto = fkIdFoto;
    }

    public GrlEstadoCivil getFkIdEstadoCivil() {
        return fkIdEstadoCivil;
    }

    public void setFkIdEstadoCivil(GrlEstadoCivil fkIdEstadoCivil) {
        this.fkIdEstadoCivil = fkIdEstadoCivil;
    }

    public GrlEndereco getFkIdEndereco() {
        return fkIdEndereco;
    }

    public void setFkIdEndereco(GrlEndereco fkIdEndereco) {
        this.fkIdEndereco = fkIdEndereco;
    }

    public GrlDocumentoIdentificacao getFkIdDocumentoIdentificacao() {
        return fkIdDocumentoIdentificacao;
    }

    public void setFkIdDocumentoIdentificacao(GrlDocumentoIdentificacao fkIdDocumentoIdentificacao) {
        this.fkIdDocumentoIdentificacao = fkIdDocumentoIdentificacao;
    }

    public GrlContacto getFkIdContacto() {
        return fkIdContacto;
    }

    public void setFkIdContacto(GrlContacto fkIdContacto) {
        this.fkIdContacto = fkIdContacto;
    }

    public GrlConjugePessoa getFkIdConjugePessoa() {
        return fkIdConjugePessoa;
    }

    public void setFkIdConjugePessoa(GrlConjugePessoa fkIdConjugePessoa) {
        this.fkIdConjugePessoa = fkIdConjugePessoa;
    }

    public RhCandidato getRhCandidato() {
        return rhCandidato;
    }

    public void setRhCandidato(RhCandidato rhCandidato) {
        this.rhCandidato = rhCandidato;
    }

    public RhFuncionario getRhFuncionario() {
        return rhFuncionario;
    }

    public void setRhFuncionario(RhFuncionario rhFuncionario) {
        this.rhFuncionario = rhFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdPessoa != null ? pkIdPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrlPessoa)) {
            return false;
        }
        GrlPessoa other = (GrlPessoa) object;
        if ((this.pkIdPessoa == null && other.pkIdPessoa != null) || (this.pkIdPessoa != null && !this.pkIdPessoa.equals(other.pkIdPessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.GrlPessoa[ pkIdPessoa=" + pkIdPessoa + " ]";
    }
    
}
