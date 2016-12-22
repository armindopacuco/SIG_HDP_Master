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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "inter_sessoes_edu_dadas", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterSessoesEduDadas.findAll", query = "SELECT i FROM InterSessoesEduDadas i"),
    @NamedQuery(name = "InterSessoesEduDadas.findByPkIdSessao", query = "SELECT i FROM InterSessoesEduDadas i WHERE i.pkIdSessao = :pkIdSessao"),
    @NamedQuery(name = "InterSessoesEduDadas.findByFkIdRegistoInternamento", query = "SELECT i FROM InterSessoesEduDadas i WHERE i.fkIdRegistoInternamento = :fkIdRegistoInternamento"),
    @NamedQuery(name = "InterSessoesEduDadas.findByData", query = "SELECT i FROM InterSessoesEduDadas i WHERE i.data = :data")})
public class InterSessoesEduDadas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_sessao")
    private Integer pkIdSessao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_id_registo_internamento")
    private int fkIdRegistoInternamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne
    private RhFuncionario fkIdFuncionario;
    @JoinColumn(name = "fk_id_sessao_edu_saude", referencedColumnName = "pk_id_sessoes_edu_saude")
    @ManyToOne(optional = false)
    private InterSessoesEduSaude fkIdSessaoEduSaude;

    public InterSessoesEduDadas() {
    }

    public InterSessoesEduDadas(Integer pkIdSessao) {
        this.pkIdSessao = pkIdSessao;
    }

    public InterSessoesEduDadas(Integer pkIdSessao, int fkIdRegistoInternamento, Date data) {
        this.pkIdSessao = pkIdSessao;
        this.fkIdRegistoInternamento = fkIdRegistoInternamento;
        this.data = data;
    }

    public Integer getPkIdSessao() {
        return pkIdSessao;
    }

    public void setPkIdSessao(Integer pkIdSessao) {
        this.pkIdSessao = pkIdSessao;
    }

    public int getFkIdRegistoInternamento() {
        return fkIdRegistoInternamento;
    }

    public void setFkIdRegistoInternamento(int fkIdRegistoInternamento) {
        this.fkIdRegistoInternamento = fkIdRegistoInternamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public RhFuncionario getFkIdFuncionario() {
        return fkIdFuncionario;
    }

    public void setFkIdFuncionario(RhFuncionario fkIdFuncionario) {
        this.fkIdFuncionario = fkIdFuncionario;
    }

    public InterSessoesEduSaude getFkIdSessaoEduSaude() {
        return fkIdSessaoEduSaude;
    }

    public void setFkIdSessaoEduSaude(InterSessoesEduSaude fkIdSessaoEduSaude) {
        this.fkIdSessaoEduSaude = fkIdSessaoEduSaude;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdSessao != null ? pkIdSessao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterSessoesEduDadas)) {
            return false;
        }
        InterSessoesEduDadas other = (InterSessoesEduDadas) object;
        if ((this.pkIdSessao == null && other.pkIdSessao != null) || (this.pkIdSessao != null && !this.pkIdSessao.equals(other.pkIdSessao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.InterSessoesEduDadas[ pkIdSessao=" + pkIdSessao + " ]";
    }
    
}
