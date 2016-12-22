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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "inter_inscricao_internamento", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterInscricaoInternamento.findAll", query = "SELECT i FROM InterInscricaoInternamento i"),
    @NamedQuery(name = "InterInscricaoInternamento.findByPkIdInscricaoInternamento", query = "SELECT i FROM InterInscricaoInternamento i WHERE i.pkIdInscricaoInternamento = :pkIdInscricaoInternamento"),
    @NamedQuery(name = "InterInscricaoInternamento.findByFkIdPaciente", query = "SELECT i FROM InterInscricaoInternamento i WHERE i.fkIdPaciente = :fkIdPaciente"),
    @NamedQuery(name = "InterInscricaoInternamento.findByDataInscricao", query = "SELECT i FROM InterInscricaoInternamento i WHERE i.dataInscricao = :dataInscricao"),
    @NamedQuery(name = "InterInscricaoInternamento.findByFkIdServicoSolicitado", query = "SELECT i FROM InterInscricaoInternamento i WHERE i.fkIdServicoSolicitado = :fkIdServicoSolicitado")})
public class InterInscricaoInternamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_inscricao_internamento")
    private Integer pkIdInscricaoInternamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_id_paciente")
    private int fkIdPaciente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_inscricao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInscricao;
    @Column(name = "fk_id_servico_solicitado")
    private Integer fkIdServicoSolicitado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdInscricaoInternamento")
    private List<InterRegistoInternamento> interRegistoInternamentoList;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne(optional = false)
    private RhFuncionario fkIdFuncionario;
    @JoinColumn(name = "fk_id_area_internamento", referencedColumnName = "pk_id_area_internamento")
    @ManyToOne(optional = false)
    private InterAreaInternamento fkIdAreaInternamento;

    public InterInscricaoInternamento() {
    }

    public InterInscricaoInternamento(Integer pkIdInscricaoInternamento) {
        this.pkIdInscricaoInternamento = pkIdInscricaoInternamento;
    }

    public InterInscricaoInternamento(Integer pkIdInscricaoInternamento, int fkIdPaciente, Date dataInscricao) {
        this.pkIdInscricaoInternamento = pkIdInscricaoInternamento;
        this.fkIdPaciente = fkIdPaciente;
        this.dataInscricao = dataInscricao;
    }

    public Integer getPkIdInscricaoInternamento() {
        return pkIdInscricaoInternamento;
    }

    public void setPkIdInscricaoInternamento(Integer pkIdInscricaoInternamento) {
        this.pkIdInscricaoInternamento = pkIdInscricaoInternamento;
    }

    public int getFkIdPaciente() {
        return fkIdPaciente;
    }

    public void setFkIdPaciente(int fkIdPaciente) {
        this.fkIdPaciente = fkIdPaciente;
    }

    public Date getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(Date dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public Integer getFkIdServicoSolicitado() {
        return fkIdServicoSolicitado;
    }

    public void setFkIdServicoSolicitado(Integer fkIdServicoSolicitado) {
        this.fkIdServicoSolicitado = fkIdServicoSolicitado;
    }

    @XmlTransient
    public List<InterRegistoInternamento> getInterRegistoInternamentoList() {
        return interRegistoInternamentoList;
    }

    public void setInterRegistoInternamentoList(List<InterRegistoInternamento> interRegistoInternamentoList) {
        this.interRegistoInternamentoList = interRegistoInternamentoList;
    }

    public RhFuncionario getFkIdFuncionario() {
        return fkIdFuncionario;
    }

    public void setFkIdFuncionario(RhFuncionario fkIdFuncionario) {
        this.fkIdFuncionario = fkIdFuncionario;
    }

    public InterAreaInternamento getFkIdAreaInternamento() {
        return fkIdAreaInternamento;
    }

    public void setFkIdAreaInternamento(InterAreaInternamento fkIdAreaInternamento) {
        this.fkIdAreaInternamento = fkIdAreaInternamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdInscricaoInternamento != null ? pkIdInscricaoInternamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterInscricaoInternamento)) {
            return false;
        }
        InterInscricaoInternamento other = (InterInscricaoInternamento) object;
        if ((this.pkIdInscricaoInternamento == null && other.pkIdInscricaoInternamento != null) || (this.pkIdInscricaoInternamento != null && !this.pkIdInscricaoInternamento.equals(other.pkIdInscricaoInternamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.InterInscricaoInternamento[ pkIdInscricaoInternamento=" + pkIdInscricaoInternamento + " ]";
    }
    
}
