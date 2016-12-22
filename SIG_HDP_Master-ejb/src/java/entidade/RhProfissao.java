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
@Table(name = "rh_profissao", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhProfissao.findAll", query = "SELECT r FROM RhProfissao r"),
    @NamedQuery(name = "RhProfissao.findByPkIdProfissao", query = "SELECT r FROM RhProfissao r WHERE r.pkIdProfissao = :pkIdProfissao"),
    @NamedQuery(name = "RhProfissao.findByDescricao", query = "SELECT r FROM RhProfissao r WHERE r.descricao = :descricao"),
    @NamedQuery(name = "RhProfissao.findByTemEspecialidade", query = "SELECT r FROM RhProfissao r WHERE r.temEspecialidade = :temEspecialidade")})
public class RhProfissao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_profissao")
    private Integer pkIdProfissao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tem_especialidade")
    private boolean temEspecialidade;
    @OneToMany(mappedBy = "fkIdProfissao")
    private List<DiagCandidatoDador> diagCandidatoDadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdProfissao")
    private List<GrlEspecialidade> grlEspecialidadeList;
    @OneToMany(mappedBy = "fkIdProfissao")
    private List<RhCategoriaProfissao> rhCategoriaProfissaoList;

    public RhProfissao() {
    }

    public RhProfissao(Integer pkIdProfissao) {
        this.pkIdProfissao = pkIdProfissao;
    }

    public RhProfissao(Integer pkIdProfissao, String descricao, boolean temEspecialidade) {
        this.pkIdProfissao = pkIdProfissao;
        this.descricao = descricao;
        this.temEspecialidade = temEspecialidade;
    }

    public Integer getPkIdProfissao() {
        return pkIdProfissao;
    }

    public void setPkIdProfissao(Integer pkIdProfissao) {
        this.pkIdProfissao = pkIdProfissao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean getTemEspecialidade() {
        return temEspecialidade;
    }

    public void setTemEspecialidade(boolean temEspecialidade) {
        this.temEspecialidade = temEspecialidade;
    }

    @XmlTransient
    public List<DiagCandidatoDador> getDiagCandidatoDadorList() {
        return diagCandidatoDadorList;
    }

    public void setDiagCandidatoDadorList(List<DiagCandidatoDador> diagCandidatoDadorList) {
        this.diagCandidatoDadorList = diagCandidatoDadorList;
    }

    @XmlTransient
    public List<GrlEspecialidade> getGrlEspecialidadeList() {
        return grlEspecialidadeList;
    }

    public void setGrlEspecialidadeList(List<GrlEspecialidade> grlEspecialidadeList) {
        this.grlEspecialidadeList = grlEspecialidadeList;
    }

    @XmlTransient
    public List<RhCategoriaProfissao> getRhCategoriaProfissaoList() {
        return rhCategoriaProfissaoList;
    }

    public void setRhCategoriaProfissaoList(List<RhCategoriaProfissao> rhCategoriaProfissaoList) {
        this.rhCategoriaProfissaoList = rhCategoriaProfissaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdProfissao != null ? pkIdProfissao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhProfissao)) {
            return false;
        }
        RhProfissao other = (RhProfissao) object;
        if ((this.pkIdProfissao == null && other.pkIdProfissao != null) || (this.pkIdProfissao != null && !this.pkIdProfissao.equals(other.pkIdProfissao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.RhProfissao[ pkIdProfissao=" + pkIdProfissao + " ]";
    }
    
}
