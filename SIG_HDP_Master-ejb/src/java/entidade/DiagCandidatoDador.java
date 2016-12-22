/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "diag_candidato_dador", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagCandidatoDador.findAll", query = "SELECT d FROM DiagCandidatoDador d"),
    @NamedQuery(name = "DiagCandidatoDador.findByPkIdCandidatoDador", query = "SELECT d FROM DiagCandidatoDador d WHERE d.pkIdCandidatoDador = :pkIdCandidatoDador"),
    @NamedQuery(name = "DiagCandidatoDador.findByPeso", query = "SELECT d FROM DiagCandidatoDador d WHERE d.peso = :peso"),
    @NamedQuery(name = "DiagCandidatoDador.findByLocalTrabalho", query = "SELECT d FROM DiagCandidatoDador d WHERE d.localTrabalho = :localTrabalho"),
    @NamedQuery(name = "DiagCandidatoDador.findByProfissao", query = "SELECT d FROM DiagCandidatoDador d WHERE d.profissao = :profissao"),
    @NamedQuery(name = "DiagCandidatoDador.findByNomeCompleto", query = "SELECT d FROM DiagCandidatoDador d WHERE d.nomeCompleto = :nomeCompleto"),
    @NamedQuery(name = "DiagCandidatoDador.findByTelefone", query = "SELECT d FROM DiagCandidatoDador d WHERE d.telefone = :telefone"),
    @NamedQuery(name = "DiagCandidatoDador.findByTelemovel", query = "SELECT d FROM DiagCandidatoDador d WHERE d.telemovel = :telemovel")})
public class DiagCandidatoDador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_candidato_dador")
    private Integer pkIdCandidatoDador;
    @Column(name = "peso")
    private Integer peso;
    @Size(max = 45)
    @Column(name = "local_trabalho")
    private String localTrabalho;
    @Size(max = 45)
    @Column(name = "profissao")
    private String profissao;
    @Size(max = 100)
    @Column(name = "nome_completo")
    private String nomeCompleto;
    @Size(max = 2147483647)
    @Column(name = "telefone")
    private String telefone;
    @Size(max = 2147483647)
    @Column(name = "telemovel")
    private String telemovel;
    @JoinColumn(name = "fk_id_profissao", referencedColumnName = "pk_id_profissao")
    @ManyToOne
    private RhProfissao fkIdProfissao;
    @JoinColumn(name = "fk_id_sexo", referencedColumnName = "pk_id_sexo")
    @ManyToOne
    private GrlSexo fkIdSexo;
    @JoinColumn(name = "fk_id_religiao", referencedColumnName = "pk_id_religiao")
    @ManyToOne
    private GrlReligiao fkIdReligiao;
    @JoinColumn(name = "fk_municipio_origem", referencedColumnName = "pk_id_municipio")
    @ManyToOne
    private GrlMunicipio fkMunicipioOrigem;
    @JoinColumn(name = "fk_id_estado_civil", referencedColumnName = "pk_id_estado_civil")
    @ManyToOne
    private GrlEstadoCivil fkIdEstadoCivil;

    public DiagCandidatoDador() {
    }

    public DiagCandidatoDador(Integer pkIdCandidatoDador) {
        this.pkIdCandidatoDador = pkIdCandidatoDador;
    }

    public Integer getPkIdCandidatoDador() {
        return pkIdCandidatoDador;
    }

    public void setPkIdCandidatoDador(Integer pkIdCandidatoDador) {
        this.pkIdCandidatoDador = pkIdCandidatoDador;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public String getLocalTrabalho() {
        return localTrabalho;
    }

    public void setLocalTrabalho(String localTrabalho) {
        this.localTrabalho = localTrabalho;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }

    public RhProfissao getFkIdProfissao() {
        return fkIdProfissao;
    }

    public void setFkIdProfissao(RhProfissao fkIdProfissao) {
        this.fkIdProfissao = fkIdProfissao;
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

    public GrlMunicipio getFkMunicipioOrigem() {
        return fkMunicipioOrigem;
    }

    public void setFkMunicipioOrigem(GrlMunicipio fkMunicipioOrigem) {
        this.fkMunicipioOrigem = fkMunicipioOrigem;
    }

    public GrlEstadoCivil getFkIdEstadoCivil() {
        return fkIdEstadoCivil;
    }

    public void setFkIdEstadoCivil(GrlEstadoCivil fkIdEstadoCivil) {
        this.fkIdEstadoCivil = fkIdEstadoCivil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdCandidatoDador != null ? pkIdCandidatoDador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagCandidatoDador)) {
            return false;
        }
        DiagCandidatoDador other = (DiagCandidatoDador) object;
        if ((this.pkIdCandidatoDador == null && other.pkIdCandidatoDador != null) || (this.pkIdCandidatoDador != null && !this.pkIdCandidatoDador.equals(other.pkIdCandidatoDador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.DiagCandidatoDador[ pkIdCandidatoDador=" + pkIdCandidatoDador + " ]";
    }
    
}
