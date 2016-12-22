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
@Table(name = "farm_armazenamento", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmArmazenamento.findAll", query = "SELECT f FROM FarmArmazenamento f"),
    @NamedQuery(name = "FarmArmazenamento.findByPkIdArmazenamento", query = "SELECT f FROM FarmArmazenamento f WHERE f.pkIdArmazenamento = :pkIdArmazenamento"),
    @NamedQuery(name = "FarmArmazenamento.findByCodigoArmazenamento", query = "SELECT f FROM FarmArmazenamento f WHERE f.codigoArmazenamento = :codigoArmazenamento"),
    @NamedQuery(name = "FarmArmazenamento.findByDescricaoArmazenamento", query = "SELECT f FROM FarmArmazenamento f WHERE f.descricaoArmazenamento = :descricaoArmazenamento"),
    @NamedQuery(name = "FarmArmazenamento.findByCapacidadeAlocacao", query = "SELECT f FROM FarmArmazenamento f WHERE f.capacidadeAlocacao = :capacidadeAlocacao"),
    @NamedQuery(name = "FarmArmazenamento.findByDataHoraCadastro", query = "SELECT f FROM FarmArmazenamento f WHERE f.dataHoraCadastro = :dataHoraCadastro")})
public class FarmArmazenamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_armazenamento")
    private Integer pkIdArmazenamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigo_armazenamento")
    private String codigoArmazenamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descricao_armazenamento")
    private String descricaoArmazenamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "capacidade_alocacao")
    private int capacidadeAlocacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @OneToMany(mappedBy = "fkIdArmazenamentoOrigem")
    private List<FarmFichaDeStock> farmFichaDeStockList;
    @OneToMany(mappedBy = "fkIdArmazenamentoDestino")
    private List<FarmFichaDeStock> farmFichaDeStockList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdArmazenamentoSaida")
    private List<FarmMovimento> farmMovimentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdArmazenamentoEntrada")
    private List<FarmMovimento> farmMovimentoList1;
    @JoinColumn(name = "fk_id_funcionario_cadastrou", referencedColumnName = "pk_id_funcionario")
    @ManyToOne(optional = false)
    private RhFuncionario fkIdFuncionarioCadastrou;
    @JoinColumn(name = "fk_id_instituicao", referencedColumnName = "pk_id_instituicao")
    @ManyToOne(optional = false)
    private GrlInstituicao fkIdInstituicao;
    @JoinColumn(name = "fk_id_tipo_armazenamento", referencedColumnName = "pk_id_tipo_armazenamento")
    @ManyToOne
    private FarmTipoArmazenamento fkIdTipoArmazenamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdArmazenamento")
    private List<FarmVenda> farmVendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdArmazemDestino")
    private List<FarmFornecimento> farmFornecimentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdArmazenamento")
    private List<FarmArmazenamentoHasMaterialSanitario> farmArmazenamentoHasMaterialSanitarioList;

    public FarmArmazenamento() {
    }

    public FarmArmazenamento(Integer pkIdArmazenamento) {
        this.pkIdArmazenamento = pkIdArmazenamento;
    }

    public FarmArmazenamento(Integer pkIdArmazenamento, String codigoArmazenamento, String descricaoArmazenamento, int capacidadeAlocacao, Date dataHoraCadastro) {
        this.pkIdArmazenamento = pkIdArmazenamento;
        this.codigoArmazenamento = codigoArmazenamento;
        this.descricaoArmazenamento = descricaoArmazenamento;
        this.capacidadeAlocacao = capacidadeAlocacao;
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public Integer getPkIdArmazenamento() {
        return pkIdArmazenamento;
    }

    public void setPkIdArmazenamento(Integer pkIdArmazenamento) {
        this.pkIdArmazenamento = pkIdArmazenamento;
    }

    public String getCodigoArmazenamento() {
        return codigoArmazenamento;
    }

    public void setCodigoArmazenamento(String codigoArmazenamento) {
        this.codigoArmazenamento = codigoArmazenamento;
    }

    public String getDescricaoArmazenamento() {
        return descricaoArmazenamento;
    }

    public void setDescricaoArmazenamento(String descricaoArmazenamento) {
        this.descricaoArmazenamento = descricaoArmazenamento;
    }

    public int getCapacidadeAlocacao() {
        return capacidadeAlocacao;
    }

    public void setCapacidadeAlocacao(int capacidadeAlocacao) {
        this.capacidadeAlocacao = capacidadeAlocacao;
    }

    public Date getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(Date dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    @XmlTransient
    public List<FarmFichaDeStock> getFarmFichaDeStockList() {
        return farmFichaDeStockList;
    }

    public void setFarmFichaDeStockList(List<FarmFichaDeStock> farmFichaDeStockList) {
        this.farmFichaDeStockList = farmFichaDeStockList;
    }

    @XmlTransient
    public List<FarmFichaDeStock> getFarmFichaDeStockList1() {
        return farmFichaDeStockList1;
    }

    public void setFarmFichaDeStockList1(List<FarmFichaDeStock> farmFichaDeStockList1) {
        this.farmFichaDeStockList1 = farmFichaDeStockList1;
    }

    @XmlTransient
    public List<FarmMovimento> getFarmMovimentoList() {
        return farmMovimentoList;
    }

    public void setFarmMovimentoList(List<FarmMovimento> farmMovimentoList) {
        this.farmMovimentoList = farmMovimentoList;
    }

    @XmlTransient
    public List<FarmMovimento> getFarmMovimentoList1() {
        return farmMovimentoList1;
    }

    public void setFarmMovimentoList1(List<FarmMovimento> farmMovimentoList1) {
        this.farmMovimentoList1 = farmMovimentoList1;
    }

    public RhFuncionario getFkIdFuncionarioCadastrou() {
        return fkIdFuncionarioCadastrou;
    }

    public void setFkIdFuncionarioCadastrou(RhFuncionario fkIdFuncionarioCadastrou) {
        this.fkIdFuncionarioCadastrou = fkIdFuncionarioCadastrou;
    }

    public GrlInstituicao getFkIdInstituicao() {
        return fkIdInstituicao;
    }

    public void setFkIdInstituicao(GrlInstituicao fkIdInstituicao) {
        this.fkIdInstituicao = fkIdInstituicao;
    }

    public FarmTipoArmazenamento getFkIdTipoArmazenamento() {
        return fkIdTipoArmazenamento;
    }

    public void setFkIdTipoArmazenamento(FarmTipoArmazenamento fkIdTipoArmazenamento) {
        this.fkIdTipoArmazenamento = fkIdTipoArmazenamento;
    }

    @XmlTransient
    public List<FarmVenda> getFarmVendaList() {
        return farmVendaList;
    }

    public void setFarmVendaList(List<FarmVenda> farmVendaList) {
        this.farmVendaList = farmVendaList;
    }

    @XmlTransient
    public List<FarmFornecimento> getFarmFornecimentoList() {
        return farmFornecimentoList;
    }

    public void setFarmFornecimentoList(List<FarmFornecimento> farmFornecimentoList) {
        this.farmFornecimentoList = farmFornecimentoList;
    }

    @XmlTransient
    public List<FarmArmazenamentoHasMaterialSanitario> getFarmArmazenamentoHasMaterialSanitarioList() {
        return farmArmazenamentoHasMaterialSanitarioList;
    }

    public void setFarmArmazenamentoHasMaterialSanitarioList(List<FarmArmazenamentoHasMaterialSanitario> farmArmazenamentoHasMaterialSanitarioList) {
        this.farmArmazenamentoHasMaterialSanitarioList = farmArmazenamentoHasMaterialSanitarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdArmazenamento != null ? pkIdArmazenamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmArmazenamento)) {
            return false;
        }
        FarmArmazenamento other = (FarmArmazenamento) object;
        if ((this.pkIdArmazenamento == null && other.pkIdArmazenamento != null) || (this.pkIdArmazenamento != null && !this.pkIdArmazenamento.equals(other.pkIdArmazenamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmArmazenamento[ pkIdArmazenamento=" + pkIdArmazenamento + " ]";
    }
    
}
