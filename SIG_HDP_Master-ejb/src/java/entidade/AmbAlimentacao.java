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
@Table(name = "amb_alimentacao", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbAlimentacao.findAll", query = "SELECT a FROM AmbAlimentacao a"),
    @NamedQuery(name = "AmbAlimentacao.findByPkIdAlimentacao", query = "SELECT a FROM AmbAlimentacao a WHERE a.pkIdAlimentacao = :pkIdAlimentacao"),
    @NamedQuery(name = "AmbAlimentacao.findByDescricao", query = "SELECT a FROM AmbAlimentacao a WHERE a.descricao = :descricao")})
public class AmbAlimentacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_alimentacao")
    private Integer pkIdAlimentacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdAlimentacao")
    private List<AmbAnamneseAsAlimentacao> ambAnamneseAsAlimentacaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdAnamnese")
    private List<AmbAnamneseAsAlimentacao> ambAnamneseAsAlimentacaoList1;

    public AmbAlimentacao() {
    }

    public AmbAlimentacao(Integer pkIdAlimentacao) {
        this.pkIdAlimentacao = pkIdAlimentacao;
    }

    public AmbAlimentacao(Integer pkIdAlimentacao, String descricao) {
        this.pkIdAlimentacao = pkIdAlimentacao;
        this.descricao = descricao;
    }

    public Integer getPkIdAlimentacao() {
        return pkIdAlimentacao;
    }

    public void setPkIdAlimentacao(Integer pkIdAlimentacao) {
        this.pkIdAlimentacao = pkIdAlimentacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<AmbAnamneseAsAlimentacao> getAmbAnamneseAsAlimentacaoList() {
        return ambAnamneseAsAlimentacaoList;
    }

    public void setAmbAnamneseAsAlimentacaoList(List<AmbAnamneseAsAlimentacao> ambAnamneseAsAlimentacaoList) {
        this.ambAnamneseAsAlimentacaoList = ambAnamneseAsAlimentacaoList;
    }

    @XmlTransient
    public List<AmbAnamneseAsAlimentacao> getAmbAnamneseAsAlimentacaoList1() {
        return ambAnamneseAsAlimentacaoList1;
    }

    public void setAmbAnamneseAsAlimentacaoList1(List<AmbAnamneseAsAlimentacao> ambAnamneseAsAlimentacaoList1) {
        this.ambAnamneseAsAlimentacaoList1 = ambAnamneseAsAlimentacaoList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdAlimentacao != null ? pkIdAlimentacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbAlimentacao)) {
            return false;
        }
        AmbAlimentacao other = (AmbAlimentacao) object;
        if ((this.pkIdAlimentacao == null && other.pkIdAlimentacao != null) || (this.pkIdAlimentacao != null && !this.pkIdAlimentacao.equals(other.pkIdAlimentacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbAlimentacao[ pkIdAlimentacao=" + pkIdAlimentacao + " ]";
    }
    
}
