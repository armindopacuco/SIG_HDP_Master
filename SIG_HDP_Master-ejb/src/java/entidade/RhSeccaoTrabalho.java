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
@Table(name = "rh_seccao_trabalho", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhSeccaoTrabalho.findAll", query = "SELECT r FROM RhSeccaoTrabalho r"),
    @NamedQuery(name = "RhSeccaoTrabalho.findByPkIdSeccaoTrabalho", query = "SELECT r FROM RhSeccaoTrabalho r WHERE r.pkIdSeccaoTrabalho = :pkIdSeccaoTrabalho"),
    @NamedQuery(name = "RhSeccaoTrabalho.findByDescricao", query = "SELECT r FROM RhSeccaoTrabalho r WHERE r.descricao = :descricao")})
public class RhSeccaoTrabalho implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_seccao_trabalho")
    private Integer pkIdSeccaoTrabalho;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdSeccaoTrabalho")
    private List<RhCargo> rhCargoList;
    @JoinColumn(name = "fk_id_departamento", referencedColumnName = "pk_id_departamento")
    @ManyToOne(optional = false)
    private RhDepartamento fkIdDepartamento;

    public RhSeccaoTrabalho() {
    }

    public RhSeccaoTrabalho(Integer pkIdSeccaoTrabalho) {
        this.pkIdSeccaoTrabalho = pkIdSeccaoTrabalho;
    }

    public RhSeccaoTrabalho(Integer pkIdSeccaoTrabalho, String descricao) {
        this.pkIdSeccaoTrabalho = pkIdSeccaoTrabalho;
        this.descricao = descricao;
    }

    public Integer getPkIdSeccaoTrabalho() {
        return pkIdSeccaoTrabalho;
    }

    public void setPkIdSeccaoTrabalho(Integer pkIdSeccaoTrabalho) {
        this.pkIdSeccaoTrabalho = pkIdSeccaoTrabalho;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<RhCargo> getRhCargoList() {
        return rhCargoList;
    }

    public void setRhCargoList(List<RhCargo> rhCargoList) {
        this.rhCargoList = rhCargoList;
    }

    public RhDepartamento getFkIdDepartamento() {
        return fkIdDepartamento;
    }

    public void setFkIdDepartamento(RhDepartamento fkIdDepartamento) {
        this.fkIdDepartamento = fkIdDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdSeccaoTrabalho != null ? pkIdSeccaoTrabalho.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhSeccaoTrabalho)) {
            return false;
        }
        RhSeccaoTrabalho other = (RhSeccaoTrabalho) object;
        if ((this.pkIdSeccaoTrabalho == null && other.pkIdSeccaoTrabalho != null) || (this.pkIdSeccaoTrabalho != null && !this.pkIdSeccaoTrabalho.equals(other.pkIdSeccaoTrabalho))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.RhSeccaoTrabalho[ pkIdSeccaoTrabalho=" + pkIdSeccaoTrabalho + " ]";
    }
    
}
