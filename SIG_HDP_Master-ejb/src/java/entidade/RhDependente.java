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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "rh_dependente", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhDependente.findAll", query = "SELECT r FROM RhDependente r"),
    @NamedQuery(name = "RhDependente.findByPkIdDependente", query = "SELECT r FROM RhDependente r WHERE r.pkIdDependente = :pkIdDependente"),
    @NamedQuery(name = "RhDependente.findByDataNascimento", query = "SELECT r FROM RhDependente r WHERE r.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "RhDependente.findByNomeCompleto", query = "SELECT r FROM RhDependente r WHERE r.nomeCompleto = :nomeCompleto")})
public class RhDependente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_dependente")
    private Integer pkIdDependente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nome_completo")
    private String nomeCompleto;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne(optional = false)
    private RhFuncionario fkIdFuncionario;

    public RhDependente() {
    }

    public RhDependente(Integer pkIdDependente) {
        this.pkIdDependente = pkIdDependente;
    }

    public RhDependente(Integer pkIdDependente, Date dataNascimento, String nomeCompleto) {
        this.pkIdDependente = pkIdDependente;
        this.dataNascimento = dataNascimento;
        this.nomeCompleto = nomeCompleto;
    }

    public Integer getPkIdDependente() {
        return pkIdDependente;
    }

    public void setPkIdDependente(Integer pkIdDependente) {
        this.pkIdDependente = pkIdDependente;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
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
        hash += (pkIdDependente != null ? pkIdDependente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhDependente)) {
            return false;
        }
        RhDependente other = (RhDependente) object;
        if ((this.pkIdDependente == null && other.pkIdDependente != null) || (this.pkIdDependente != null && !this.pkIdDependente.equals(other.pkIdDependente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.RhDependente[ pkIdDependente=" + pkIdDependente + " ]";
    }
    
}
