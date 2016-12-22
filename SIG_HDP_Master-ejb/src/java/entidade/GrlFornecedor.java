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
@Table(name = "grl_fornecedor", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrlFornecedor.findAll", query = "SELECT g FROM GrlFornecedor g"),
    @NamedQuery(name = "GrlFornecedor.findByPkIdFornecedor", query = "SELECT g FROM GrlFornecedor g WHERE g.pkIdFornecedor = :pkIdFornecedor"),
    @NamedQuery(name = "GrlFornecedor.findByCodigoFornecedor", query = "SELECT g FROM GrlFornecedor g WHERE g.codigoFornecedor = :codigoFornecedor"),
    @NamedQuery(name = "GrlFornecedor.findByDescricao", query = "SELECT g FROM GrlFornecedor g WHERE g.descricao = :descricao"),
    @NamedQuery(name = "GrlFornecedor.findByNumeroContribuinte", query = "SELECT g FROM GrlFornecedor g WHERE g.numeroContribuinte = :numeroContribuinte")})
public class GrlFornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_fornecedor")
    private Integer pkIdFornecedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigo_fornecedor")
    private String codigoFornecedor;
    @Size(max = 100)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "numero_contribuinte")
    private String numeroContribuinte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFornecedor")
    private List<FarmFornecimento> farmFornecimentoList;
    @JoinColumn(name = "fk_id_instituicao", referencedColumnName = "pk_id_instituicao")
    @ManyToOne(optional = false)
    private GrlInstituicao fkIdInstituicao;

    public GrlFornecedor() {
    }

    public GrlFornecedor(Integer pkIdFornecedor) {
        this.pkIdFornecedor = pkIdFornecedor;
    }

    public GrlFornecedor(Integer pkIdFornecedor, String codigoFornecedor, String numeroContribuinte) {
        this.pkIdFornecedor = pkIdFornecedor;
        this.codigoFornecedor = codigoFornecedor;
        this.numeroContribuinte = numeroContribuinte;
    }

    public Integer getPkIdFornecedor() {
        return pkIdFornecedor;
    }

    public void setPkIdFornecedor(Integer pkIdFornecedor) {
        this.pkIdFornecedor = pkIdFornecedor;
    }

    public String getCodigoFornecedor() {
        return codigoFornecedor;
    }

    public void setCodigoFornecedor(String codigoFornecedor) {
        this.codigoFornecedor = codigoFornecedor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNumeroContribuinte() {
        return numeroContribuinte;
    }

    public void setNumeroContribuinte(String numeroContribuinte) {
        this.numeroContribuinte = numeroContribuinte;
    }

    @XmlTransient
    public List<FarmFornecimento> getFarmFornecimentoList() {
        return farmFornecimentoList;
    }

    public void setFarmFornecimentoList(List<FarmFornecimento> farmFornecimentoList) {
        this.farmFornecimentoList = farmFornecimentoList;
    }

    public GrlInstituicao getFkIdInstituicao() {
        return fkIdInstituicao;
    }

    public void setFkIdInstituicao(GrlInstituicao fkIdInstituicao) {
        this.fkIdInstituicao = fkIdInstituicao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdFornecedor != null ? pkIdFornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrlFornecedor)) {
            return false;
        }
        GrlFornecedor other = (GrlFornecedor) object;
        if ((this.pkIdFornecedor == null && other.pkIdFornecedor != null) || (this.pkIdFornecedor != null && !this.pkIdFornecedor.equals(other.pkIdFornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.GrlFornecedor[ pkIdFornecedor=" + pkIdFornecedor + " ]";
    }
    
}
