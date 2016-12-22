/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "grl_especialidade", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrlEspecialidade.findAll", query = "SELECT g FROM GrlEspecialidade g"),
    @NamedQuery(name = "GrlEspecialidade.findByPkIdEspecialidade", query = "SELECT g FROM GrlEspecialidade g WHERE g.pkIdEspecialidade = :pkIdEspecialidade"),
    @NamedQuery(name = "GrlEspecialidade.findByDescricao", query = "SELECT g FROM GrlEspecialidade g WHERE g.descricao = :descricao"),
    @NamedQuery(name = "GrlEspecialidade.findBySiglaEspecialidade", query = "SELECT g FROM GrlEspecialidade g WHERE g.siglaEspecialidade = :siglaEspecialidade"),
    @NamedQuery(name = "GrlEspecialidade.findByFlagMedica", query = "SELECT g FROM GrlEspecialidade g WHERE g.flagMedica = :flagMedica")})
public class GrlEspecialidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_especialidade")
    private Integer pkIdEspecialidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 45)
    @Column(name = "sigla_especialidade")
    private String siglaEspecialidade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flag_medica")
    private boolean flagMedica;
    @JoinColumn(name = "fk_id_profissao", referencedColumnName = "pk_id_profissao")
    @ManyToOne(optional = false)
    private RhProfissao fkIdProfissao;
    @OneToMany(mappedBy = "fkIdEspecialidade")
    private List<AdmsServico> admsServicoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdEspecialidade")
    private List<RhFuncionarioAsGrlEspecialidade> rhFuncionarioAsGrlEspecialidadeList;

    public GrlEspecialidade() {
    }

    public GrlEspecialidade(Integer pkIdEspecialidade) {
        this.pkIdEspecialidade = pkIdEspecialidade;
    }

    public GrlEspecialidade(Integer pkIdEspecialidade, String descricao, boolean flagMedica) {
        this.pkIdEspecialidade = pkIdEspecialidade;
        this.descricao = descricao;
        this.flagMedica = flagMedica;
    }

    public Integer getPkIdEspecialidade() {
        return pkIdEspecialidade;
    }

    public void setPkIdEspecialidade(Integer pkIdEspecialidade) {
        this.pkIdEspecialidade = pkIdEspecialidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSiglaEspecialidade() {
        return siglaEspecialidade;
    }

    public void setSiglaEspecialidade(String siglaEspecialidade) {
        this.siglaEspecialidade = siglaEspecialidade;
    }

    public boolean getFlagMedica() {
        return flagMedica;
    }

    public void setFlagMedica(boolean flagMedica) {
        this.flagMedica = flagMedica;
    }

    public RhProfissao getFkIdProfissao() {
        return fkIdProfissao;
    }

    public void setFkIdProfissao(RhProfissao fkIdProfissao) {
        this.fkIdProfissao = fkIdProfissao;
    }

    @XmlTransient
    public List<AdmsServico> getAdmsServicoList() {
        return admsServicoList;
    }

    public void setAdmsServicoList(List<AdmsServico> admsServicoList) {
        this.admsServicoList = admsServicoList;
    }

    @XmlTransient
    public List<RhFuncionarioAsGrlEspecialidade> getRhFuncionarioAsGrlEspecialidadeList() {
        return rhFuncionarioAsGrlEspecialidadeList;
    }

    public void setRhFuncionarioAsGrlEspecialidadeList(List<RhFuncionarioAsGrlEspecialidade> rhFuncionarioAsGrlEspecialidadeList) {
        this.rhFuncionarioAsGrlEspecialidadeList = rhFuncionarioAsGrlEspecialidadeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdEspecialidade != null ? pkIdEspecialidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrlEspecialidade)) {
            return false;
        }
        GrlEspecialidade other = (GrlEspecialidade) object;
        if ((this.pkIdEspecialidade == null && other.pkIdEspecialidade != null) || (this.pkIdEspecialidade != null && !this.pkIdEspecialidade.equals(other.pkIdEspecialidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.GrlEspecialidade[ pkIdEspecialidade=" + pkIdEspecialidade + " ]";
    }
    
}
