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
@Table(name = "farm_fornecimento", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmFornecimento.findAll", query = "SELECT f FROM FarmFornecimento f"),
    @NamedQuery(name = "FarmFornecimento.findByPkIdFornecimento", query = "SELECT f FROM FarmFornecimento f WHERE f.pkIdFornecimento = :pkIdFornecimento"),
    @NamedQuery(name = "FarmFornecimento.findByQuantidade", query = "SELECT f FROM FarmFornecimento f WHERE f.quantidade = :quantidade"),
    @NamedQuery(name = "FarmFornecimento.findByPrecoUnitario", query = "SELECT f FROM FarmFornecimento f WHERE f.precoUnitario = :precoUnitario"),
    @NamedQuery(name = "FarmFornecimento.findByDataHoraCadastro", query = "SELECT f FROM FarmFornecimento f WHERE f.dataHoraCadastro = :dataHoraCadastro")})
public class FarmFornecimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_fornecimento")
    private Integer pkIdFornecimento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private int quantidade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precoUnitario")
    private double precoUnitario;
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne(optional = false)
    private RhFuncionario fkIdFuncionario;
    @JoinColumn(name = "fk_id_fornecedor", referencedColumnName = "pk_id_fornecedor")
    @ManyToOne(optional = false)
    private GrlFornecedor fkIdFornecedor;
    @JoinColumn(name = "fk_id_tipo_fornecimento", referencedColumnName = "pk_id_tipo_fornecimento")
    @ManyToOne(optional = false)
    private FarmTipoFornecimento fkIdTipoFornecimento;
    @JoinColumn(name = "fk_id_material_sanitario", referencedColumnName = "pk_id_material_sanitario")
    @ManyToOne(optional = false)
    private FarmMaterialSanitario fkIdMaterialSanitario;
    @JoinColumn(name = "fk_id_armazem_destino", referencedColumnName = "pk_id_armazenamento")
    @ManyToOne(optional = false)
    private FarmArmazenamento fkIdArmazemDestino;

    public FarmFornecimento() {
    }

    public FarmFornecimento(Integer pkIdFornecimento) {
        this.pkIdFornecimento = pkIdFornecimento;
    }

    public FarmFornecimento(Integer pkIdFornecimento, int quantidade, double precoUnitario) {
        this.pkIdFornecimento = pkIdFornecimento;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public Integer getPkIdFornecimento() {
        return pkIdFornecimento;
    }

    public void setPkIdFornecimento(Integer pkIdFornecimento) {
        this.pkIdFornecimento = pkIdFornecimento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
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

    public GrlFornecedor getFkIdFornecedor() {
        return fkIdFornecedor;
    }

    public void setFkIdFornecedor(GrlFornecedor fkIdFornecedor) {
        this.fkIdFornecedor = fkIdFornecedor;
    }

    public FarmTipoFornecimento getFkIdTipoFornecimento() {
        return fkIdTipoFornecimento;
    }

    public void setFkIdTipoFornecimento(FarmTipoFornecimento fkIdTipoFornecimento) {
        this.fkIdTipoFornecimento = fkIdTipoFornecimento;
    }

    public FarmMaterialSanitario getFkIdMaterialSanitario() {
        return fkIdMaterialSanitario;
    }

    public void setFkIdMaterialSanitario(FarmMaterialSanitario fkIdMaterialSanitario) {
        this.fkIdMaterialSanitario = fkIdMaterialSanitario;
    }

    public FarmArmazenamento getFkIdArmazemDestino() {
        return fkIdArmazemDestino;
    }

    public void setFkIdArmazemDestino(FarmArmazenamento fkIdArmazemDestino) {
        this.fkIdArmazemDestino = fkIdArmazemDestino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdFornecimento != null ? pkIdFornecimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmFornecimento)) {
            return false;
        }
        FarmFornecimento other = (FarmFornecimento) object;
        if ((this.pkIdFornecimento == null && other.pkIdFornecimento != null) || (this.pkIdFornecimento != null && !this.pkIdFornecimento.equals(other.pkIdFornecimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmFornecimento[ pkIdFornecimento=" + pkIdFornecimento + " ]";
    }
    
}
