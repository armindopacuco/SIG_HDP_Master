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
@Table(name = "farm_movimento", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmMovimento.findAll", query = "SELECT f FROM FarmMovimento f"),
    @NamedQuery(name = "FarmMovimento.findByDataSaida", query = "SELECT f FROM FarmMovimento f WHERE f.dataSaida = :dataSaida"),
    @NamedQuery(name = "FarmMovimento.findByQuantidadeMovimentada", query = "SELECT f FROM FarmMovimento f WHERE f.quantidadeMovimentada = :quantidadeMovimentada"),
    @NamedQuery(name = "FarmMovimento.findByFlagEstadoMovimento", query = "SELECT f FROM FarmMovimento f WHERE f.flagEstadoMovimento = :flagEstadoMovimento"),
    @NamedQuery(name = "FarmMovimento.findByPkIdMovimento", query = "SELECT f FROM FarmMovimento f WHERE f.pkIdMovimento = :pkIdMovimento")})
public class FarmMovimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_saida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataSaida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade_movimentada")
    private int quantidadeMovimentada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flag_estado_movimento")
    private int flagEstadoMovimento;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_movimento")
    private Long pkIdMovimento;
    @JoinColumn(name = "fk_id_funcionario_solicitou", referencedColumnName = "pk_id_funcionario")
    @ManyToOne(optional = false)
    private RhFuncionario fkIdFuncionarioSolicitou;
    @JoinColumn(name = "fk_id_funcionario_entregou", referencedColumnName = "pk_id_funcionario")
    @ManyToOne
    private RhFuncionario fkIdFuncionarioEntregou;
    @JoinColumn(name = "fk_id_material_sanitario", referencedColumnName = "pk_id_material_sanitario")
    @ManyToOne(optional = false)
    private FarmMaterialSanitario fkIdMaterialSanitario;
    @JoinColumn(name = "fk_id_armazenamento_saida", referencedColumnName = "pk_id_armazenamento")
    @ManyToOne(optional = false)
    private FarmArmazenamento fkIdArmazenamentoSaida;
    @JoinColumn(name = "fk_id_armazenamento_entrada", referencedColumnName = "pk_id_armazenamento")
    @ManyToOne(optional = false)
    private FarmArmazenamento fkIdArmazenamentoEntrada;

    public FarmMovimento() {
    }

    public FarmMovimento(Long pkIdMovimento) {
        this.pkIdMovimento = pkIdMovimento;
    }

    public FarmMovimento(Long pkIdMovimento, Date dataSaida, int quantidadeMovimentada, int flagEstadoMovimento) {
        this.pkIdMovimento = pkIdMovimento;
        this.dataSaida = dataSaida;
        this.quantidadeMovimentada = quantidadeMovimentada;
        this.flagEstadoMovimento = flagEstadoMovimento;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public int getQuantidadeMovimentada() {
        return quantidadeMovimentada;
    }

    public void setQuantidadeMovimentada(int quantidadeMovimentada) {
        this.quantidadeMovimentada = quantidadeMovimentada;
    }

    public int getFlagEstadoMovimento() {
        return flagEstadoMovimento;
    }

    public void setFlagEstadoMovimento(int flagEstadoMovimento) {
        this.flagEstadoMovimento = flagEstadoMovimento;
    }

    public Long getPkIdMovimento() {
        return pkIdMovimento;
    }

    public void setPkIdMovimento(Long pkIdMovimento) {
        this.pkIdMovimento = pkIdMovimento;
    }

    public RhFuncionario getFkIdFuncionarioSolicitou() {
        return fkIdFuncionarioSolicitou;
    }

    public void setFkIdFuncionarioSolicitou(RhFuncionario fkIdFuncionarioSolicitou) {
        this.fkIdFuncionarioSolicitou = fkIdFuncionarioSolicitou;
    }

    public RhFuncionario getFkIdFuncionarioEntregou() {
        return fkIdFuncionarioEntregou;
    }

    public void setFkIdFuncionarioEntregou(RhFuncionario fkIdFuncionarioEntregou) {
        this.fkIdFuncionarioEntregou = fkIdFuncionarioEntregou;
    }

    public FarmMaterialSanitario getFkIdMaterialSanitario() {
        return fkIdMaterialSanitario;
    }

    public void setFkIdMaterialSanitario(FarmMaterialSanitario fkIdMaterialSanitario) {
        this.fkIdMaterialSanitario = fkIdMaterialSanitario;
    }

    public FarmArmazenamento getFkIdArmazenamentoSaida() {
        return fkIdArmazenamentoSaida;
    }

    public void setFkIdArmazenamentoSaida(FarmArmazenamento fkIdArmazenamentoSaida) {
        this.fkIdArmazenamentoSaida = fkIdArmazenamentoSaida;
    }

    public FarmArmazenamento getFkIdArmazenamentoEntrada() {
        return fkIdArmazenamentoEntrada;
    }

    public void setFkIdArmazenamentoEntrada(FarmArmazenamento fkIdArmazenamentoEntrada) {
        this.fkIdArmazenamentoEntrada = fkIdArmazenamentoEntrada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdMovimento != null ? pkIdMovimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmMovimento)) {
            return false;
        }
        FarmMovimento other = (FarmMovimento) object;
        if ((this.pkIdMovimento == null && other.pkIdMovimento != null) || (this.pkIdMovimento != null && !this.pkIdMovimento.equals(other.pkIdMovimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmMovimento[ pkIdMovimento=" + pkIdMovimento + " ]";
    }
    
}
