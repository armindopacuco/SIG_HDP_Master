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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "inter_enfermaria", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterEnfermaria.findAll", query = "SELECT i FROM InterEnfermaria i"),
    @NamedQuery(name = "InterEnfermaria.findByPkIdEnfermaria", query = "SELECT i FROM InterEnfermaria i WHERE i.pkIdEnfermaria = :pkIdEnfermaria"),
    @NamedQuery(name = "InterEnfermaria.findByDescricao", query = "SELECT i FROM InterEnfermaria i WHERE i.descricao = :descricao"),
    @NamedQuery(name = "InterEnfermaria.findByCodigoEnfermaria", query = "SELECT i FROM InterEnfermaria i WHERE i.codigoEnfermaria = :codigoEnfermaria")})
public class InterEnfermaria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_enfermaria")
    private Integer pkIdEnfermaria;
    @Size(max = 100)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 45)
    @Column(name = "codigo_enfermaria")
    private String codigoEnfermaria;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne(optional = false)
    private RhFuncionario fkIdFuncionario;
    @JoinColumn(name = "fk_id_status", referencedColumnName = "pk_id_status")
    @ManyToOne(optional = false)
    private InterStatus fkIdStatus;
    @JoinColumn(name = "fk_id_area_internamento", referencedColumnName = "pk_id_area_internamento")
    @ManyToOne(optional = false)
    private InterAreaInternamento fkIdAreaInternamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdEnfermaria")
    private List<InterRegistoInternamento> interRegistoInternamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdEnfermaria")
    private List<InterQuartoInternamento> interQuartoInternamentoList;

    public InterEnfermaria() {
    }

    public InterEnfermaria(Integer pkIdEnfermaria) {
        this.pkIdEnfermaria = pkIdEnfermaria;
    }

    public Integer getPkIdEnfermaria() {
        return pkIdEnfermaria;
    }

    public void setPkIdEnfermaria(Integer pkIdEnfermaria) {
        this.pkIdEnfermaria = pkIdEnfermaria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoEnfermaria() {
        return codigoEnfermaria;
    }

    public void setCodigoEnfermaria(String codigoEnfermaria) {
        this.codigoEnfermaria = codigoEnfermaria;
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

    public InterAreaInternamento getFkIdAreaInternamento() {
        return fkIdAreaInternamento;
    }

    public void setFkIdAreaInternamento(InterAreaInternamento fkIdAreaInternamento) {
        this.fkIdAreaInternamento = fkIdAreaInternamento;
    }

    @XmlTransient
    public List<InterRegistoInternamento> getInterRegistoInternamentoList() {
        return interRegistoInternamentoList;
    }

    public void setInterRegistoInternamentoList(List<InterRegistoInternamento> interRegistoInternamentoList) {
        this.interRegistoInternamentoList = interRegistoInternamentoList;
    }

    @XmlTransient
    public List<InterQuartoInternamento> getInterQuartoInternamentoList() {
        return interQuartoInternamentoList;
    }

    public void setInterQuartoInternamentoList(List<InterQuartoInternamento> interQuartoInternamentoList) {
        this.interQuartoInternamentoList = interQuartoInternamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdEnfermaria != null ? pkIdEnfermaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterEnfermaria)) {
            return false;
        }
        InterEnfermaria other = (InterEnfermaria) object;
        if ((this.pkIdEnfermaria == null && other.pkIdEnfermaria != null) || (this.pkIdEnfermaria != null && !this.pkIdEnfermaria.equals(other.pkIdEnfermaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.InterEnfermaria[ pkIdEnfermaria=" + pkIdEnfermaria + " ]";
    }
    
}
