/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "fin_preco", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinPreco.findAll", query = "SELECT f FROM FinPreco f"),
    @NamedQuery(name = "FinPreco.findByPkIdPrecoPreco", query = "SELECT f FROM FinPreco f WHERE f.pkIdPrecoPreco = :pkIdPrecoPreco"),
    @NamedQuery(name = "FinPreco.findByValor", query = "SELECT f FROM FinPreco f WHERE f.valor = :valor"),
    @NamedQuery(name = "FinPreco.findByDataCadastro", query = "SELECT f FROM FinPreco f WHERE f.dataCadastro = :dataCadastro")})
public class FinPreco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_preco_preco")
    private Integer pkIdPrecoPreco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdPrecoPreco")
    private List<AdmsServicoSolicitado> admsServicoSolicitadoList;
    @JoinColumn(name = "fk_id_tipo_solicitacao", referencedColumnName = "pk_id_tipo_solicitacao")
    @ManyToOne(optional = false)
    private AdmsTipoSolicitacaoServico fkIdTipoSolicitacao;
    @JoinColumn(name = "fk_id_servico", referencedColumnName = "pk_id_servico")
    @ManyToOne(optional = false)
    private AdmsServico fkIdServico;

    public FinPreco() {
    }

    public FinPreco(Integer pkIdPrecoPreco) {
        this.pkIdPrecoPreco = pkIdPrecoPreco;
    }

    public FinPreco(Integer pkIdPrecoPreco, double valor, Date dataCadastro) {
        this.pkIdPrecoPreco = pkIdPrecoPreco;
        this.valor = valor;
        this.dataCadastro = dataCadastro;
    }

    public Integer getPkIdPrecoPreco() {
        return pkIdPrecoPreco;
    }

    public void setPkIdPrecoPreco(Integer pkIdPrecoPreco) {
        this.pkIdPrecoPreco = pkIdPrecoPreco;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @XmlTransient
    public List<AdmsServicoSolicitado> getAdmsServicoSolicitadoList() {
        return admsServicoSolicitadoList;
    }

    public void setAdmsServicoSolicitadoList(List<AdmsServicoSolicitado> admsServicoSolicitadoList) {
        this.admsServicoSolicitadoList = admsServicoSolicitadoList;
    }

    public AdmsTipoSolicitacaoServico getFkIdTipoSolicitacao() {
        return fkIdTipoSolicitacao;
    }

    public void setFkIdTipoSolicitacao(AdmsTipoSolicitacaoServico fkIdTipoSolicitacao) {
        this.fkIdTipoSolicitacao = fkIdTipoSolicitacao;
    }

    public AdmsServico getFkIdServico() {
        return fkIdServico;
    }

    public void setFkIdServico(AdmsServico fkIdServico) {
        this.fkIdServico = fkIdServico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdPrecoPreco != null ? pkIdPrecoPreco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinPreco)) {
            return false;
        }
        FinPreco other = (FinPreco) object;
        if ((this.pkIdPrecoPreco == null && other.pkIdPrecoPreco != null) || (this.pkIdPrecoPreco != null && !this.pkIdPrecoPreco.equals(other.pkIdPrecoPreco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FinPreco[ pkIdPrecoPreco=" + pkIdPrecoPreco + " ]";
    }
    
}
