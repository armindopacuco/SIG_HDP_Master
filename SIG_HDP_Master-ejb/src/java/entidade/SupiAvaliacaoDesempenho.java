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
@Table(name = "supi_avaliacao_desempenho", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupiAvaliacaoDesempenho.findAll", query = "SELECT s FROM SupiAvaliacaoDesempenho s"),
    @NamedQuery(name = "SupiAvaliacaoDesempenho.findByPkIdAvaliacaoDesempenho", query = "SELECT s FROM SupiAvaliacaoDesempenho s WHERE s.pkIdAvaliacaoDesempenho = :pkIdAvaliacaoDesempenho"),
    @NamedQuery(name = "SupiAvaliacaoDesempenho.findByDataAvaliacao", query = "SELECT s FROM SupiAvaliacaoDesempenho s WHERE s.dataAvaliacao = :dataAvaliacao"),
    @NamedQuery(name = "SupiAvaliacaoDesempenho.findByTotalMensal", query = "SELECT s FROM SupiAvaliacaoDesempenho s WHERE s.totalMensal = :totalMensal"),
    @NamedQuery(name = "SupiAvaliacaoDesempenho.findByObservacao", query = "SELECT s FROM SupiAvaliacaoDesempenho s WHERE s.observacao = :observacao")})
public class SupiAvaliacaoDesempenho implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_avaliacao_desempenho")
    private Integer pkIdAvaliacaoDesempenho;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_avaliacao")
    @Temporal(TemporalType.DATE)
    private Date dataAvaliacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_mensal")
    private double totalMensal;
    @Size(max = 100)
    @Column(name = "observacao")
    private String observacao;
    @JoinColumn(name = "fk_id_estagiario", referencedColumnName = "pk_id_estagiario")
    @ManyToOne(optional = false)
    private SupiEstagiario fkIdEstagiario;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne(optional = false)
    private RhFuncionario fkIdFuncionario;

    public SupiAvaliacaoDesempenho() {
    }

    public SupiAvaliacaoDesempenho(Integer pkIdAvaliacaoDesempenho) {
        this.pkIdAvaliacaoDesempenho = pkIdAvaliacaoDesempenho;
    }

    public SupiAvaliacaoDesempenho(Integer pkIdAvaliacaoDesempenho, Date dataAvaliacao, double totalMensal) {
        this.pkIdAvaliacaoDesempenho = pkIdAvaliacaoDesempenho;
        this.dataAvaliacao = dataAvaliacao;
        this.totalMensal = totalMensal;
    }

    public Integer getPkIdAvaliacaoDesempenho() {
        return pkIdAvaliacaoDesempenho;
    }

    public void setPkIdAvaliacaoDesempenho(Integer pkIdAvaliacaoDesempenho) {
        this.pkIdAvaliacaoDesempenho = pkIdAvaliacaoDesempenho;
    }

    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public double getTotalMensal() {
        return totalMensal;
    }

    public void setTotalMensal(double totalMensal) {
        this.totalMensal = totalMensal;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public SupiEstagiario getFkIdEstagiario() {
        return fkIdEstagiario;
    }

    public void setFkIdEstagiario(SupiEstagiario fkIdEstagiario) {
        this.fkIdEstagiario = fkIdEstagiario;
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
        hash += (pkIdAvaliacaoDesempenho != null ? pkIdAvaliacaoDesempenho.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupiAvaliacaoDesempenho)) {
            return false;
        }
        SupiAvaliacaoDesempenho other = (SupiAvaliacaoDesempenho) object;
        if ((this.pkIdAvaliacaoDesempenho == null && other.pkIdAvaliacaoDesempenho != null) || (this.pkIdAvaliacaoDesempenho != null && !this.pkIdAvaliacaoDesempenho.equals(other.pkIdAvaliacaoDesempenho))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.SupiAvaliacaoDesempenho[ pkIdAvaliacaoDesempenho=" + pkIdAvaliacaoDesempenho + " ]";
    }
    
}
