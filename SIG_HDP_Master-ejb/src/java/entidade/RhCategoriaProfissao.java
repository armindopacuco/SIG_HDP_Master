/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "rh_categoria_profissao", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhCategoriaProfissao.findAll", query = "SELECT r FROM RhCategoriaProfissao r"),
    @NamedQuery(name = "RhCategoriaProfissao.findByPkIdCategoriaProfissao", query = "SELECT r FROM RhCategoriaProfissao r WHERE r.pkIdCategoriaProfissao = :pkIdCategoriaProfissao"),
    @NamedQuery(name = "RhCategoriaProfissao.findByDescricao", query = "SELECT r FROM RhCategoriaProfissao r WHERE r.descricao = :descricao")})
public class RhCategoriaProfissao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_categoria_profissao")
    private Integer pkIdCategoriaProfissao;
    @Column(name = "descricao")
    private Integer descricao;
    @OneToMany(mappedBy = "fkIdCategoria")
    private List<RhCandidato> rhCandidatoList;
    @JoinColumn(name = "fk_id_profissao", referencedColumnName = "pk_id_profissao")
    @ManyToOne
    private RhProfissao fkIdProfissao;

    public RhCategoriaProfissao() {
    }

    public RhCategoriaProfissao(Integer pkIdCategoriaProfissao) {
        this.pkIdCategoriaProfissao = pkIdCategoriaProfissao;
    }

    public Integer getPkIdCategoriaProfissao() {
        return pkIdCategoriaProfissao;
    }

    public void setPkIdCategoriaProfissao(Integer pkIdCategoriaProfissao) {
        this.pkIdCategoriaProfissao = pkIdCategoriaProfissao;
    }

    public Integer getDescricao() {
        return descricao;
    }

    public void setDescricao(Integer descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<RhCandidato> getRhCandidatoList() {
        return rhCandidatoList;
    }

    public void setRhCandidatoList(List<RhCandidato> rhCandidatoList) {
        this.rhCandidatoList = rhCandidatoList;
    }

    public RhProfissao getFkIdProfissao() {
        return fkIdProfissao;
    }

    public void setFkIdProfissao(RhProfissao fkIdProfissao) {
        this.fkIdProfissao = fkIdProfissao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdCategoriaProfissao != null ? pkIdCategoriaProfissao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhCategoriaProfissao)) {
            return false;
        }
        RhCategoriaProfissao other = (RhCategoriaProfissao) object;
        if ((this.pkIdCategoriaProfissao == null && other.pkIdCategoriaProfissao != null) || (this.pkIdCategoriaProfissao != null && !this.pkIdCategoriaProfissao.equals(other.pkIdCategoriaProfissao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.RhCategoriaProfissao[ pkIdCategoriaProfissao=" + pkIdCategoriaProfissao + " ]";
    }
    
}
