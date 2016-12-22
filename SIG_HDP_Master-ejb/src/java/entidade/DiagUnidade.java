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
@Table(name = "diag_unidade", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagUnidade.findAll", query = "SELECT d FROM DiagUnidade d"),
    @NamedQuery(name = "DiagUnidade.findByPkIdUnidade", query = "SELECT d FROM DiagUnidade d WHERE d.pkIdUnidade = :pkIdUnidade"),
    @NamedQuery(name = "DiagUnidade.findByDescricaoUnidade", query = "SELECT d FROM DiagUnidade d WHERE d.descricaoUnidade = :descricaoUnidade")})
public class DiagUnidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_unidade")
    private Integer pkIdUnidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao_unidade")
    private String descricaoUnidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdUnidade")
    private List<DiagExame> diagExameList;

    public DiagUnidade() {
    }

    public DiagUnidade(Integer pkIdUnidade) {
        this.pkIdUnidade = pkIdUnidade;
    }

    public DiagUnidade(Integer pkIdUnidade, String descricaoUnidade) {
        this.pkIdUnidade = pkIdUnidade;
        this.descricaoUnidade = descricaoUnidade;
    }

    public Integer getPkIdUnidade() {
        return pkIdUnidade;
    }

    public void setPkIdUnidade(Integer pkIdUnidade) {
        this.pkIdUnidade = pkIdUnidade;
    }

    public String getDescricaoUnidade() {
        return descricaoUnidade;
    }

    public void setDescricaoUnidade(String descricaoUnidade) {
        this.descricaoUnidade = descricaoUnidade;
    }

    @XmlTransient
    public List<DiagExame> getDiagExameList() {
        return diagExameList;
    }

    public void setDiagExameList(List<DiagExame> diagExameList) {
        this.diagExameList = diagExameList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdUnidade != null ? pkIdUnidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagUnidade)) {
            return false;
        }
        DiagUnidade other = (DiagUnidade) object;
        if ((this.pkIdUnidade == null && other.pkIdUnidade != null) || (this.pkIdUnidade != null && !this.pkIdUnidade.equals(other.pkIdUnidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.DiagUnidade[ pkIdUnidade=" + pkIdUnidade + " ]";
    }
    
}
