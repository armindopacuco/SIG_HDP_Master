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
@Table(name = "supi_formador", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupiFormador.findAll", query = "SELECT s FROM SupiFormador s"),
    @NamedQuery(name = "SupiFormador.findByPkIdFormador", query = "SELECT s FROM SupiFormador s WHERE s.pkIdFormador = :pkIdFormador"),
    @NamedQuery(name = "SupiFormador.findByNome", query = "SELECT s FROM SupiFormador s WHERE s.nome = :nome"),
    @NamedQuery(name = "SupiFormador.findByDataNascimento", query = "SELECT s FROM SupiFormador s WHERE s.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "SupiFormador.findByDataCadastro", query = "SELECT s FROM SupiFormador s WHERE s.dataCadastro = :dataCadastro")})
public class SupiFormador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_formador")
    private Integer pkIdFormador;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFormador")
    private List<SupiFormacao> supiFormacaoList;
    @JoinColumn(name = "fk_id_tipo_formador", referencedColumnName = "pk_id_tipo_formador")
    @ManyToOne(optional = false)
    private SupiTipoFormador fkIdTipoFormador;
    @JoinColumn(name = "fk_id_area_formacao", referencedColumnName = "pk_id_area_formacao")
    @ManyToOne(optional = false)
    private SupiAreaFormacao fkIdAreaFormacao;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne(optional = false)
    private RhFuncionario fkIdFuncionario;

    public SupiFormador() {
    }

    public SupiFormador(Integer pkIdFormador) {
        this.pkIdFormador = pkIdFormador;
    }

    public SupiFormador(Integer pkIdFormador, Date dataCadastro) {
        this.pkIdFormador = pkIdFormador;
        this.dataCadastro = dataCadastro;
    }

    public Integer getPkIdFormador() {
        return pkIdFormador;
    }

    public void setPkIdFormador(Integer pkIdFormador) {
        this.pkIdFormador = pkIdFormador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @XmlTransient
    public List<SupiFormacao> getSupiFormacaoList() {
        return supiFormacaoList;
    }

    public void setSupiFormacaoList(List<SupiFormacao> supiFormacaoList) {
        this.supiFormacaoList = supiFormacaoList;
    }

    public SupiTipoFormador getFkIdTipoFormador() {
        return fkIdTipoFormador;
    }

    public void setFkIdTipoFormador(SupiTipoFormador fkIdTipoFormador) {
        this.fkIdTipoFormador = fkIdTipoFormador;
    }

    public SupiAreaFormacao getFkIdAreaFormacao() {
        return fkIdAreaFormacao;
    }

    public void setFkIdAreaFormacao(SupiAreaFormacao fkIdAreaFormacao) {
        this.fkIdAreaFormacao = fkIdAreaFormacao;
    }

    public RhFuncionario getFkIdFuncionario() {
        return fkIdFuncionario;
    }

    public void setFkIdFuncionario(RhFuncionario fkIdFuncionario) {
        this.fkIdFuncionario = fkIdFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdFormador != null ? pkIdFormador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupiFormador)) {
            return false;
        }
        SupiFormador other = (SupiFormador) object;
        if ((this.pkIdFormador == null && other.pkIdFormador != null) || (this.pkIdFormador != null && !this.pkIdFormador.equals(other.pkIdFormador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.SupiFormador[ pkIdFormador=" + pkIdFormador + " ]";
    }
    
}
