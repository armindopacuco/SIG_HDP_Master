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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "farm_armazenamento_has_material_sanitario", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmArmazenamentoHasMaterialSanitario.findAll", query = "SELECT f FROM FarmArmazenamentoHasMaterialSanitario f"),
    @NamedQuery(name = "FarmArmazenamentoHasMaterialSanitario.findByPkIdArmazenamentoHasMaterialSanitario", query = "SELECT f FROM FarmArmazenamentoHasMaterialSanitario f WHERE f.pkIdArmazenamentoHasMaterialSanitario = :pkIdArmazenamentoHasMaterialSanitario"),
    @NamedQuery(name = "FarmArmazenamentoHasMaterialSanitario.findByPrateleira", query = "SELECT f FROM FarmArmazenamentoHasMaterialSanitario f WHERE f.prateleira = :prateleira"),
    @NamedQuery(name = "FarmArmazenamentoHasMaterialSanitario.findByFila", query = "SELECT f FROM FarmArmazenamentoHasMaterialSanitario f WHERE f.fila = :fila"),
    @NamedQuery(name = "FarmArmazenamentoHasMaterialSanitario.findByPosicao", query = "SELECT f FROM FarmArmazenamentoHasMaterialSanitario f WHERE f.posicao = :posicao"),
    @NamedQuery(name = "FarmArmazenamentoHasMaterialSanitario.findByQuantidadeMaximaPermitida", query = "SELECT f FROM FarmArmazenamentoHasMaterialSanitario f WHERE f.quantidadeMaximaPermitida = :quantidadeMaximaPermitida"),
    @NamedQuery(name = "FarmArmazenamentoHasMaterialSanitario.findByQuantidadeMinimaPermitida", query = "SELECT f FROM FarmArmazenamentoHasMaterialSanitario f WHERE f.quantidadeMinimaPermitida = :quantidadeMinimaPermitida"),
    @NamedQuery(name = "FarmArmazenamentoHasMaterialSanitario.findByQuantidadeMaximaStock", query = "SELECT f FROM FarmArmazenamentoHasMaterialSanitario f WHERE f.quantidadeMaximaStock = :quantidadeMaximaStock")})
public class FarmArmazenamentoHasMaterialSanitario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_armazenamento_has_material_sanitario")
    private Integer pkIdArmazenamentoHasMaterialSanitario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "prateleira")
    private String prateleira;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "fila")
    private String fila;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "posicao")
    private String posicao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade_maxima_permitida")
    private int quantidadeMaximaPermitida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade_minima_permitida")
    private int quantidadeMinimaPermitida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade_maxima_stock")
    private int quantidadeMaximaStock;
    @JoinColumn(name = "fk_id_material_sanitario", referencedColumnName = "pk_id_material_sanitario")
    @ManyToOne(optional = false)
    private FarmMaterialSanitario fkIdMaterialSanitario;
    @JoinColumn(name = "fk_id_armazenamento", referencedColumnName = "pk_id_armazenamento")
    @ManyToOne(optional = false)
    private FarmArmazenamento fkIdArmazenamento;

    public FarmArmazenamentoHasMaterialSanitario() {
    }

    public FarmArmazenamentoHasMaterialSanitario(Integer pkIdArmazenamentoHasMaterialSanitario) {
        this.pkIdArmazenamentoHasMaterialSanitario = pkIdArmazenamentoHasMaterialSanitario;
    }

    public FarmArmazenamentoHasMaterialSanitario(Integer pkIdArmazenamentoHasMaterialSanitario, String prateleira, String fila, String posicao, int quantidadeMaximaPermitida, int quantidadeMinimaPermitida, int quantidadeMaximaStock) {
        this.pkIdArmazenamentoHasMaterialSanitario = pkIdArmazenamentoHasMaterialSanitario;
        this.prateleira = prateleira;
        this.fila = fila;
        this.posicao = posicao;
        this.quantidadeMaximaPermitida = quantidadeMaximaPermitida;
        this.quantidadeMinimaPermitida = quantidadeMinimaPermitida;
        this.quantidadeMaximaStock = quantidadeMaximaStock;
    }

    public Integer getPkIdArmazenamentoHasMaterialSanitario() {
        return pkIdArmazenamentoHasMaterialSanitario;
    }

    public void setPkIdArmazenamentoHasMaterialSanitario(Integer pkIdArmazenamentoHasMaterialSanitario) {
        this.pkIdArmazenamentoHasMaterialSanitario = pkIdArmazenamentoHasMaterialSanitario;
    }

    public String getPrateleira() {
        return prateleira;
    }

    public void setPrateleira(String prateleira) {
        this.prateleira = prateleira;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public int getQuantidadeMaximaPermitida() {
        return quantidadeMaximaPermitida;
    }

    public void setQuantidadeMaximaPermitida(int quantidadeMaximaPermitida) {
        this.quantidadeMaximaPermitida = quantidadeMaximaPermitida;
    }

    public int getQuantidadeMinimaPermitida() {
        return quantidadeMinimaPermitida;
    }

    public void setQuantidadeMinimaPermitida(int quantidadeMinimaPermitida) {
        this.quantidadeMinimaPermitida = quantidadeMinimaPermitida;
    }

    public int getQuantidadeMaximaStock() {
        return quantidadeMaximaStock;
    }

    public void setQuantidadeMaximaStock(int quantidadeMaximaStock) {
        this.quantidadeMaximaStock = quantidadeMaximaStock;
    }

    public FarmMaterialSanitario getFkIdMaterialSanitario() {
        return fkIdMaterialSanitario;
    }

    public void setFkIdMaterialSanitario(FarmMaterialSanitario fkIdMaterialSanitario) {
        this.fkIdMaterialSanitario = fkIdMaterialSanitario;
    }

    public FarmArmazenamento getFkIdArmazenamento() {
        return fkIdArmazenamento;
    }

    public void setFkIdArmazenamento(FarmArmazenamento fkIdArmazenamento) {
        this.fkIdArmazenamento = fkIdArmazenamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdArmazenamentoHasMaterialSanitario != null ? pkIdArmazenamentoHasMaterialSanitario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmArmazenamentoHasMaterialSanitario)) {
            return false;
        }
        FarmArmazenamentoHasMaterialSanitario other = (FarmArmazenamentoHasMaterialSanitario) object;
        if ((this.pkIdArmazenamentoHasMaterialSanitario == null && other.pkIdArmazenamentoHasMaterialSanitario != null) || (this.pkIdArmazenamentoHasMaterialSanitario != null && !this.pkIdArmazenamentoHasMaterialSanitario.equals(other.pkIdArmazenamentoHasMaterialSanitario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmArmazenamentoHasMaterialSanitario[ pkIdArmazenamentoHasMaterialSanitario=" + pkIdArmazenamentoHasMaterialSanitario + " ]";
    }
    
}
