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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "inter_cama_internamento", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterCamaInternamento.findAll", query = "SELECT i FROM InterCamaInternamento i"),
    @NamedQuery(name = "InterCamaInternamento.findByPkIdCamaInternamento", query = "SELECT i FROM InterCamaInternamento i WHERE i.pkIdCamaInternamento = :pkIdCamaInternamento"),
    @NamedQuery(name = "InterCamaInternamento.findByDescricaoCamaInternamento", query = "SELECT i FROM InterCamaInternamento i WHERE i.descricaoCamaInternamento = :descricaoCamaInternamento"),
    @NamedQuery(name = "InterCamaInternamento.findBySiglaCamaInternamento", query = "SELECT i FROM InterCamaInternamento i WHERE i.siglaCamaInternamento = :siglaCamaInternamento")})
public class InterCamaInternamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_cama_internamento")
    private Integer pkIdCamaInternamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descricao_cama_internamento")
    private String descricaoCamaInternamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sigla_cama_internamento")
    private String siglaCamaInternamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdCamaInternamento")
    private List<InterRegistoInternamento> interRegistoInternamentoList;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne(optional = false)
    private RhFuncionario fkIdFuncionario;
    @JoinColumn(name = "fk_id_status", referencedColumnName = "pk_id_status")
    @ManyToOne(optional = false)
    private InterStatus fkIdStatus;
    @JoinColumn(name = "fk_id_quarto_cama_internamento", referencedColumnName = "pk_id_quarto_internamento")
    @ManyToOne(optional = false)
    private InterQuartoInternamento fkIdQuartoCamaInternamento;

    public InterCamaInternamento() {
    }

    public InterCamaInternamento(Integer pkIdCamaInternamento) {
        this.pkIdCamaInternamento = pkIdCamaInternamento;
    }

    public InterCamaInternamento(Integer pkIdCamaInternamento, String descricaoCamaInternamento, String siglaCamaInternamento) {
        this.pkIdCamaInternamento = pkIdCamaInternamento;
        this.descricaoCamaInternamento = descricaoCamaInternamento;
        this.siglaCamaInternamento = siglaCamaInternamento;
    }

    public Integer getPkIdCamaInternamento() {
        return pkIdCamaInternamento;
    }

    public void setPkIdCamaInternamento(Integer pkIdCamaInternamento) {
        this.pkIdCamaInternamento = pkIdCamaInternamento;
    }

    public String getDescricaoCamaInternamento() {
        return descricaoCamaInternamento;
    }

    public void setDescricaoCamaInternamento(String descricaoCamaInternamento) {
        this.descricaoCamaInternamento = descricaoCamaInternamento;
    }

    public String getSiglaCamaInternamento() {
        return siglaCamaInternamento;
    }

    public void setSiglaCamaInternamento(String siglaCamaInternamento) {
        this.siglaCamaInternamento = siglaCamaInternamento;
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

    public InterStatus getFkIdStatus() {
        return fkIdStatus;
    }

    public void setFkIdStatus(InterStatus fkIdStatus) {
        this.fkIdStatus = fkIdStatus;
    }

    public InterQuartoInternamento getFkIdQuartoCamaInternamento() {
        return fkIdQuartoCamaInternamento;
    }

    public void setFkIdQuartoCamaInternamento(InterQuartoInternamento fkIdQuartoCamaInternamento) {
        this.fkIdQuartoCamaInternamento = fkIdQuartoCamaInternamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdCamaInternamento != null ? pkIdCamaInternamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterCamaInternamento)) {
            return false;
        }
        InterCamaInternamento other = (InterCamaInternamento) object;
        if ((this.pkIdCamaInternamento == null && other.pkIdCamaInternamento != null) || (this.pkIdCamaInternamento != null && !this.pkIdCamaInternamento.equals(other.pkIdCamaInternamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.InterCamaInternamento[ pkIdCamaInternamento=" + pkIdCamaInternamento + " ]";
    }
    
}
