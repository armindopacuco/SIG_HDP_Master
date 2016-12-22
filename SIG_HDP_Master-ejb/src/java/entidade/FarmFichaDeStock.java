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
@Table(name = "farm_ficha_de_stock", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmFichaDeStock.findAll", query = "SELECT f FROM FarmFichaDeStock f"),
    @NamedQuery(name = "FarmFichaDeStock.findByPkIdFichaStock", query = "SELECT f FROM FarmFichaDeStock f WHERE f.pkIdFichaStock = :pkIdFichaStock"),
    @NamedQuery(name = "FarmFichaDeStock.findByDataMovimento", query = "SELECT f FROM FarmFichaDeStock f WHERE f.dataMovimento = :dataMovimento"),
    @NamedQuery(name = "FarmFichaDeStock.findByQuantidade", query = "SELECT f FROM FarmFichaDeStock f WHERE f.quantidade = :quantidade"),
    @NamedQuery(name = "FarmFichaDeStock.findByQuantidadeExistente", query = "SELECT f FROM FarmFichaDeStock f WHERE f.quantidadeExistente = :quantidadeExistente")})
public class FarmFichaDeStock implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_ficha_stock")
    private Long pkIdFichaStock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_movimento")
    @Temporal(TemporalType.DATE)
    private Date dataMovimento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private int quantidade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade_existente")
    private int quantidadeExistente;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne
    private RhFuncionario fkIdFuncionario;
    @JoinColumn(name = "fk_id_material_sanitario", referencedColumnName = "pk_id_material_sanitario")
    @ManyToOne(optional = false)
    private FarmMaterialSanitario fkIdMaterialSanitario;
    @JoinColumn(name = "fk_id_armazenamento_origem", referencedColumnName = "pk_id_armazenamento")
    @ManyToOne
    private FarmArmazenamento fkIdArmazenamentoOrigem;
    @JoinColumn(name = "fk_id_armazenamento_destino", referencedColumnName = "pk_id_armazenamento")
    @ManyToOne
    private FarmArmazenamento fkIdArmazenamentoDestino;

    public FarmFichaDeStock() {
    }

    public FarmFichaDeStock(Long pkIdFichaStock) {
        this.pkIdFichaStock = pkIdFichaStock;
    }

    public FarmFichaDeStock(Long pkIdFichaStock, Date dataMovimento, int quantidade, int quantidadeExistente) {
        this.pkIdFichaStock = pkIdFichaStock;
        this.dataMovimento = dataMovimento;
        this.quantidade = quantidade;
        this.quantidadeExistente = quantidadeExistente;
    }

    public Long getPkIdFichaStock() {
        return pkIdFichaStock;
    }

    public void setPkIdFichaStock(Long pkIdFichaStock) {
        this.pkIdFichaStock = pkIdFichaStock;
    }

    public Date getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(Date dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidadeExistente() {
        return quantidadeExistente;
    }

    public void setQuantidadeExistente(int quantidadeExistente) {
        this.quantidadeExistente = quantidadeExistente;
    }

    public RhFuncionario getFkIdFuncionario() {
        return fkIdFuncionario;
    }

    public void setFkIdFuncionario(RhFuncionario fkIdFuncionario) {
        this.fkIdFuncionario = fkIdFuncionario;
    }

    public FarmMaterialSanitario getFkIdMaterialSanitario() {
        return fkIdMaterialSanitario;
    }

    public void setFkIdMaterialSanitario(FarmMaterialSanitario fkIdMaterialSanitario) {
        this.fkIdMaterialSanitario = fkIdMaterialSanitario;
    }

    public FarmArmazenamento getFkIdArmazenamentoOrigem() {
        return fkIdArmazenamentoOrigem;
    }

    public void setFkIdArmazenamentoOrigem(FarmArmazenamento fkIdArmazenamentoOrigem) {
        this.fkIdArmazenamentoOrigem = fkIdArmazenamentoOrigem;
    }

    public FarmArmazenamento getFkIdArmazenamentoDestino() {
        return fkIdArmazenamentoDestino;
    }

    public void setFkIdArmazenamentoDestino(FarmArmazenamento fkIdArmazenamentoDestino) {
        this.fkIdArmazenamentoDestino = fkIdArmazenamentoDestino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdFichaStock != null ? pkIdFichaStock.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmFichaDeStock)) {
            return false;
        }
        FarmFichaDeStock other = (FarmFichaDeStock) object;
        if ((this.pkIdFichaStock == null && other.pkIdFichaStock != null) || (this.pkIdFichaStock != null && !this.pkIdFichaStock.equals(other.pkIdFichaStock))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmFichaDeStock[ pkIdFichaStock=" + pkIdFichaStock + " ]";
    }
    
}
