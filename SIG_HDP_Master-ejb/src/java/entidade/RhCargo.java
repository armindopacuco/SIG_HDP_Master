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
import javax.persistence.OneToOne;
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
@Table(name = "rh_cargo", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhCargo.findAll", query = "SELECT r FROM RhCargo r"),
    @NamedQuery(name = "RhCargo.findByPkIdCargo", query = "SELECT r FROM RhCargo r WHERE r.pkIdCargo = :pkIdCargo"),
    @NamedQuery(name = "RhCargo.findByDescricao", query = "SELECT r FROM RhCargo r WHERE r.descricao = :descricao")})
public class RhCargo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_cargo")
    private Integer pkIdCargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "fk_id_seccao_trabalho", referencedColumnName = "pk_id_seccao_trabalho")
    @ManyToOne(optional = false)
    private RhSeccaoTrabalho fkIdSeccaoTrabalho;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "fkIdCargo")
    private RhTabelaSalarial rhTabelaSalarial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdCargo")
    private List<RhFuncionario> rhFuncionarioList;

    public RhCargo() {
    }

    public RhCargo(Integer pkIdCargo) {
        this.pkIdCargo = pkIdCargo;
    }

    public RhCargo(Integer pkIdCargo, String descricao) {
        this.pkIdCargo = pkIdCargo;
        this.descricao = descricao;
    }

    public Integer getPkIdCargo() {
        return pkIdCargo;
    }

    public void setPkIdCargo(Integer pkIdCargo) {
        this.pkIdCargo = pkIdCargo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public RhSeccaoTrabalho getFkIdSeccaoTrabalho() {
        return fkIdSeccaoTrabalho;
    }

    public void setFkIdSeccaoTrabalho(RhSeccaoTrabalho fkIdSeccaoTrabalho) {
        this.fkIdSeccaoTrabalho = fkIdSeccaoTrabalho;
    }

    public RhTabelaSalarial getRhTabelaSalarial() {
        return rhTabelaSalarial;
    }

    public void setRhTabelaSalarial(RhTabelaSalarial rhTabelaSalarial) {
        this.rhTabelaSalarial = rhTabelaSalarial;
    }

    @XmlTransient
    public List<RhFuncionario> getRhFuncionarioList() {
        return rhFuncionarioList;
    }

    public void setRhFuncionarioList(List<RhFuncionario> rhFuncionarioList) {
        this.rhFuncionarioList = rhFuncionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdCargo != null ? pkIdCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhCargo)) {
            return false;
        }
        RhCargo other = (RhCargo) object;
        if ((this.pkIdCargo == null && other.pkIdCargo != null) || (this.pkIdCargo != null && !this.pkIdCargo.equals(other.pkIdCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.RhCargo[ pkIdCargo=" + pkIdCargo + " ]";
    }
    
}
