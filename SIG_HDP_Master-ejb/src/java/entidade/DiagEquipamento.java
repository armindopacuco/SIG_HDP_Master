/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "diag_equipamento", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagEquipamento.findAll", query = "SELECT d FROM DiagEquipamento d"),
    @NamedQuery(name = "DiagEquipamento.findByPkIdEquipamento", query = "SELECT d FROM DiagEquipamento d WHERE d.pkIdEquipamento = :pkIdEquipamento"),
    @NamedQuery(name = "DiagEquipamento.findByDescricaoEquipamento", query = "SELECT d FROM DiagEquipamento d WHERE d.descricaoEquipamento = :descricaoEquipamento")})
public class DiagEquipamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_equipamento")
    private Integer pkIdEquipamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao_equipamento")
    private String descricaoEquipamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdEquipamento")
    private List<DiagModeloEquipamento> diagModeloEquipamentoList;

    public DiagEquipamento() {
    }

    public DiagEquipamento(Integer pkIdEquipamento) {
        this.pkIdEquipamento = pkIdEquipamento;
    }

    public DiagEquipamento(Integer pkIdEquipamento, String descricaoEquipamento) {
        this.pkIdEquipamento = pkIdEquipamento;
        this.descricaoEquipamento = descricaoEquipamento;
    }

    public Integer getPkIdEquipamento() {
        return pkIdEquipamento;
    }

    public void setPkIdEquipamento(Integer pkIdEquipamento) {
        this.pkIdEquipamento = pkIdEquipamento;
    }

    public String getDescricaoEquipamento() {
        return descricaoEquipamento;
    }

    public void setDescricaoEquipamento(String descricaoEquipamento) {
        this.descricaoEquipamento = descricaoEquipamento;
    }

    @XmlTransient
    public List<DiagModeloEquipamento> getDiagModeloEquipamentoList() {
        return diagModeloEquipamentoList;
    }

    public void setDiagModeloEquipamentoList(List<DiagModeloEquipamento> diagModeloEquipamentoList) {
        this.diagModeloEquipamentoList = diagModeloEquipamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdEquipamento != null ? pkIdEquipamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagEquipamento)) {
            return false;
        }
        DiagEquipamento other = (DiagEquipamento) object;
        if ((this.pkIdEquipamento == null && other.pkIdEquipamento != null) || (this.pkIdEquipamento != null && !this.pkIdEquipamento.equals(other.pkIdEquipamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.DiagEquipamento[ pkIdEquipamento=" + pkIdEquipamento + " ]";
    }
    
}
