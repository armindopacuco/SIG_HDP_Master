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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "rh_funcionario_as_grl_especialidade", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhFuncionarioAsGrlEspecialidade.findAll", query = "SELECT r FROM RhFuncionarioAsGrlEspecialidade r"),
    @NamedQuery(name = "RhFuncionarioAsGrlEspecialidade.findByPkIdFuncionarioAsEspecialidade", query = "SELECT r FROM RhFuncionarioAsGrlEspecialidade r WHERE r.pkIdFuncionarioAsEspecialidade = :pkIdFuncionarioAsEspecialidade")})
public class RhFuncionarioAsGrlEspecialidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_funcionario_as_especialidade")
    private Integer pkIdFuncionarioAsEspecialidade;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne(optional = false)
    private RhFuncionario fkIdFuncionario;
    @JoinColumn(name = "fk_id_especialidade", referencedColumnName = "pk_id_especialidade")
    @ManyToOne(optional = false)
    private GrlEspecialidade fkIdEspecialidade;

    public RhFuncionarioAsGrlEspecialidade() {
    }

    public RhFuncionarioAsGrlEspecialidade(Integer pkIdFuncionarioAsEspecialidade) {
        this.pkIdFuncionarioAsEspecialidade = pkIdFuncionarioAsEspecialidade;
    }

    public Integer getPkIdFuncionarioAsEspecialidade() {
        return pkIdFuncionarioAsEspecialidade;
    }

    public void setPkIdFuncionarioAsEspecialidade(Integer pkIdFuncionarioAsEspecialidade) {
        this.pkIdFuncionarioAsEspecialidade = pkIdFuncionarioAsEspecialidade;
    }

    public RhFuncionario getFkIdFuncionario() {
        return fkIdFuncionario;
    }

    public void setFkIdFuncionario(RhFuncionario fkIdFuncionario) {
        this.fkIdFuncionario = fkIdFuncionario;
    }

    public GrlEspecialidade getFkIdEspecialidade() {
        return fkIdEspecialidade;
    }

    public void setFkIdEspecialidade(GrlEspecialidade fkIdEspecialidade) {
        this.fkIdEspecialidade = fkIdEspecialidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdFuncionarioAsEspecialidade != null ? pkIdFuncionarioAsEspecialidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhFuncionarioAsGrlEspecialidade)) {
            return false;
        }
        RhFuncionarioAsGrlEspecialidade other = (RhFuncionarioAsGrlEspecialidade) object;
        if ((this.pkIdFuncionarioAsEspecialidade == null && other.pkIdFuncionarioAsEspecialidade != null) || (this.pkIdFuncionarioAsEspecialidade != null && !this.pkIdFuncionarioAsEspecialidade.equals(other.pkIdFuncionarioAsEspecialidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.RhFuncionarioAsGrlEspecialidade[ pkIdFuncionarioAsEspecialidade=" + pkIdFuncionarioAsEspecialidade + " ]";
    }
    
}
