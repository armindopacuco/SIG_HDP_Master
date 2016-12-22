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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "farm_venda_has_medicamento", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmVendaHasMedicamento.findAll", query = "SELECT f FROM FarmVendaHasMedicamento f"),
    @NamedQuery(name = "FarmVendaHasMedicamento.findByPkIdVendaHasMedicamento", query = "SELECT f FROM FarmVendaHasMedicamento f WHERE f.pkIdVendaHasMedicamento = :pkIdVendaHasMedicamento"),
    @NamedQuery(name = "FarmVendaHasMedicamento.findByQuantidade", query = "SELECT f FROM FarmVendaHasMedicamento f WHERE f.quantidade = :quantidade"),
    @NamedQuery(name = "FarmVendaHasMedicamento.findByFlagEstado", query = "SELECT f FROM FarmVendaHasMedicamento f WHERE f.flagEstado = :flagEstado")})
public class FarmVendaHasMedicamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_venda_has_medicamento")
    private Integer pkIdVendaHasMedicamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private int quantidade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flag_estado")
    private int flagEstado;
    @JoinColumn(name = "fk_id_venda", referencedColumnName = "pk_id_venda")
    @ManyToOne(optional = false)
    private FarmVenda fkIdVenda;
    @JoinColumn(name = "fk_id_material_sanitario", referencedColumnName = "pk_id_material_sanitario")
    @ManyToOne(optional = false)
    private FarmMaterialSanitario fkIdMaterialSanitario;

    public FarmVendaHasMedicamento() {
    }

    public FarmVendaHasMedicamento(Integer pkIdVendaHasMedicamento) {
        this.pkIdVendaHasMedicamento = pkIdVendaHasMedicamento;
    }

    public FarmVendaHasMedicamento(Integer pkIdVendaHasMedicamento, int quantidade, int flagEstado) {
        this.pkIdVendaHasMedicamento = pkIdVendaHasMedicamento;
        this.quantidade = quantidade;
        this.flagEstado = flagEstado;
    }

    public Integer getPkIdVendaHasMedicamento() {
        return pkIdVendaHasMedicamento;
    }

    public void setPkIdVendaHasMedicamento(Integer pkIdVendaHasMedicamento) {
        this.pkIdVendaHasMedicamento = pkIdVendaHasMedicamento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getFlagEstado() {
        return flagEstado;
    }

    public void setFlagEstado(int flagEstado) {
        this.flagEstado = flagEstado;
    }

    public FarmVenda getFkIdVenda() {
        return fkIdVenda;
    }

    public void setFkIdVenda(FarmVenda fkIdVenda) {
        this.fkIdVenda = fkIdVenda;
    }

    public FarmMaterialSanitario getFkIdMaterialSanitario() {
        return fkIdMaterialSanitario;
    }

    public void setFkIdMaterialSanitario(FarmMaterialSanitario fkIdMaterialSanitario) {
        this.fkIdMaterialSanitario = fkIdMaterialSanitario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdVendaHasMedicamento != null ? pkIdVendaHasMedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmVendaHasMedicamento)) {
            return false;
        }
        FarmVendaHasMedicamento other = (FarmVendaHasMedicamento) object;
        if ((this.pkIdVendaHasMedicamento == null && other.pkIdVendaHasMedicamento != null) || (this.pkIdVendaHasMedicamento != null && !this.pkIdVendaHasMedicamento.equals(other.pkIdVendaHasMedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmVendaHasMedicamento[ pkIdVendaHasMedicamento=" + pkIdVendaHasMedicamento + " ]";
    }
    
}
