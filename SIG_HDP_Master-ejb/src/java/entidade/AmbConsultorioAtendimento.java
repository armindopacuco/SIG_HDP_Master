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
@Table(name = "amb_consultorio_atendimento", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbConsultorioAtendimento.findAll", query = "SELECT a FROM AmbConsultorioAtendimento a"),
    @NamedQuery(name = "AmbConsultorioAtendimento.findByPkIdConsultorioAtendimento", query = "SELECT a FROM AmbConsultorioAtendimento a WHERE a.pkIdConsultorioAtendimento = :pkIdConsultorioAtendimento"),
    @NamedQuery(name = "AmbConsultorioAtendimento.findByDataHoraCadastro", query = "SELECT a FROM AmbConsultorioAtendimento a WHERE a.dataHoraCadastro = :dataHoraCadastro")})
public class AmbConsultorioAtendimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_consultorio_atendimento")
    private Integer pkIdConsultorioAtendimento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne(optional = false)
    private RhFuncionario fkIdFuncionario;
    @JoinColumn(name = "fk_pk_id_consultorio", referencedColumnName = "pk_id_consultorio")
    @ManyToOne(optional = false)
    private AmbConsultorio fkPkIdConsultorio;

    public AmbConsultorioAtendimento() {
    }

    public AmbConsultorioAtendimento(Integer pkIdConsultorioAtendimento) {
        this.pkIdConsultorioAtendimento = pkIdConsultorioAtendimento;
    }

    public AmbConsultorioAtendimento(Integer pkIdConsultorioAtendimento, Date dataHoraCadastro) {
        this.pkIdConsultorioAtendimento = pkIdConsultorioAtendimento;
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public Integer getPkIdConsultorioAtendimento() {
        return pkIdConsultorioAtendimento;
    }

    public void setPkIdConsultorioAtendimento(Integer pkIdConsultorioAtendimento) {
        this.pkIdConsultorioAtendimento = pkIdConsultorioAtendimento;
    }

    public Date getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(Date dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public RhFuncionario getFkIdFuncionario() {
        return fkIdFuncionario;
    }

    public void setFkIdFuncionario(RhFuncionario fkIdFuncionario) {
        this.fkIdFuncionario = fkIdFuncionario;
    }

    public AmbConsultorio getFkPkIdConsultorio() {
        return fkPkIdConsultorio;
    }

    public void setFkPkIdConsultorio(AmbConsultorio fkPkIdConsultorio) {
        this.fkPkIdConsultorio = fkPkIdConsultorio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdConsultorioAtendimento != null ? pkIdConsultorioAtendimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbConsultorioAtendimento)) {
            return false;
        }
        AmbConsultorioAtendimento other = (AmbConsultorioAtendimento) object;
        if ((this.pkIdConsultorioAtendimento == null && other.pkIdConsultorioAtendimento != null) || (this.pkIdConsultorioAtendimento != null && !this.pkIdConsultorioAtendimento.equals(other.pkIdConsultorioAtendimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbConsultorioAtendimento[ pkIdConsultorioAtendimento=" + pkIdConsultorioAtendimento + " ]";
    }
    
}
