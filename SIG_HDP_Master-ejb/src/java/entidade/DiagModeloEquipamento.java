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
@Table(name = "diag_modelo_equipamento", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagModeloEquipamento.findAll", query = "SELECT d FROM DiagModeloEquipamento d"),
    @NamedQuery(name = "DiagModeloEquipamento.findByPkIdModeloEquipamento", query = "SELECT d FROM DiagModeloEquipamento d WHERE d.pkIdModeloEquipamento = :pkIdModeloEquipamento"),
    @NamedQuery(name = "DiagModeloEquipamento.findByDescricaoModeloEquipamento", query = "SELECT d FROM DiagModeloEquipamento d WHERE d.descricaoModeloEquipamento = :descricaoModeloEquipamento")})
public class DiagModeloEquipamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_modelo_equipamento")
    private Integer pkIdModeloEquipamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao_modelo_equipamento")
    private String descricaoModeloEquipamento;
    @JoinColumn(name = "fk_id_equipamento", referencedColumnName = "pk_id_equipamento")
    @ManyToOne(optional = false)
    private DiagEquipamento fkIdEquipamento;

    public DiagModeloEquipamento() {
    }

    public DiagModeloEquipamento(Integer pkIdModeloEquipamento) {
        this.pkIdModeloEquipamento = pkIdModeloEquipamento;
    }

    public DiagModeloEquipamento(Integer pkIdModeloEquipamento, String descricaoModeloEquipamento) {
        this.pkIdModeloEquipamento = pkIdModeloEquipamento;
        this.descricaoModeloEquipamento = descricaoModeloEquipamento;
    }

    public Integer getPkIdModeloEquipamento() {
        return pkIdModeloEquipamento;
    }

    public void setPkIdModeloEquipamento(Integer pkIdModeloEquipamento) {
        this.pkIdModeloEquipamento = pkIdModeloEquipamento;
    }

    public String getDescricaoModeloEquipamento() {
        return descricaoModeloEquipamento;
    }

    public void setDescricaoModeloEquipamento(String descricaoModeloEquipamento) {
        this.descricaoModeloEquipamento = descricaoModeloEquipamento;
    }

    public DiagEquipamento getFkIdEquipamento() {
        return fkIdEquipamento;
    }

    public void setFkIdEquipamento(DiagEquipamento fkIdEquipamento) {
        this.fkIdEquipamento = fkIdEquipamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdModeloEquipamento != null ? pkIdModeloEquipamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagModeloEquipamento)) {
            return false;
        }
        DiagModeloEquipamento other = (DiagModeloEquipamento) object;
        if ((this.pkIdModeloEquipamento == null && other.pkIdModeloEquipamento != null) || (this.pkIdModeloEquipamento != null && !this.pkIdModeloEquipamento.equals(other.pkIdModeloEquipamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.DiagModeloEquipamento[ pkIdModeloEquipamento=" + pkIdModeloEquipamento + " ]";
    }
    
}
