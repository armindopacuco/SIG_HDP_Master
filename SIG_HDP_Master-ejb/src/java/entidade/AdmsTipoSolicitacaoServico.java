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
@Table(name = "adms_tipo_solicitacao_servico", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdmsTipoSolicitacaoServico.findAll", query = "SELECT a FROM AdmsTipoSolicitacaoServico a"),
    @NamedQuery(name = "AdmsTipoSolicitacaoServico.findByPkIdTipoSolicitacao", query = "SELECT a FROM AdmsTipoSolicitacaoServico a WHERE a.pkIdTipoSolicitacao = :pkIdTipoSolicitacao"),
    @NamedQuery(name = "AdmsTipoSolicitacaoServico.findByDescricaoTipoSolicitacaoServico", query = "SELECT a FROM AdmsTipoSolicitacaoServico a WHERE a.descricaoTipoSolicitacaoServico = :descricaoTipoSolicitacaoServico")})
public class AdmsTipoSolicitacaoServico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_tipo_solicitacao")
    private Integer pkIdTipoSolicitacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descricao_tipo_solicitacao_servico")
    private String descricaoTipoSolicitacaoServico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdTipoSolicitacao")
    private List<AdmsServicoSolicitado> admsServicoSolicitadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdTipoSolicitacao")
    private List<FinPreco> finPrecoList;

    public AdmsTipoSolicitacaoServico() {
    }

    public AdmsTipoSolicitacaoServico(Integer pkIdTipoSolicitacao) {
        this.pkIdTipoSolicitacao = pkIdTipoSolicitacao;
    }

    public AdmsTipoSolicitacaoServico(Integer pkIdTipoSolicitacao, String descricaoTipoSolicitacaoServico) {
        this.pkIdTipoSolicitacao = pkIdTipoSolicitacao;
        this.descricaoTipoSolicitacaoServico = descricaoTipoSolicitacaoServico;
    }

    public Integer getPkIdTipoSolicitacao() {
        return pkIdTipoSolicitacao;
    }

    public void setPkIdTipoSolicitacao(Integer pkIdTipoSolicitacao) {
        this.pkIdTipoSolicitacao = pkIdTipoSolicitacao;
    }

    public String getDescricaoTipoSolicitacaoServico() {
        return descricaoTipoSolicitacaoServico;
    }

    public void setDescricaoTipoSolicitacaoServico(String descricaoTipoSolicitacaoServico) {
        this.descricaoTipoSolicitacaoServico = descricaoTipoSolicitacaoServico;
    }

    @XmlTransient
    public List<AdmsServicoSolicitado> getAdmsServicoSolicitadoList() {
        return admsServicoSolicitadoList;
    }

    public void setAdmsServicoSolicitadoList(List<AdmsServicoSolicitado> admsServicoSolicitadoList) {
        this.admsServicoSolicitadoList = admsServicoSolicitadoList;
    }

    @XmlTransient
    public List<FinPreco> getFinPrecoList() {
        return finPrecoList;
    }

    public void setFinPrecoList(List<FinPreco> finPrecoList) {
        this.finPrecoList = finPrecoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdTipoSolicitacao != null ? pkIdTipoSolicitacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmsTipoSolicitacaoServico)) {
            return false;
        }
        AdmsTipoSolicitacaoServico other = (AdmsTipoSolicitacaoServico) object;
        if ((this.pkIdTipoSolicitacao == null && other.pkIdTipoSolicitacao != null) || (this.pkIdTipoSolicitacao != null && !this.pkIdTipoSolicitacao.equals(other.pkIdTipoSolicitacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AdmsTipoSolicitacaoServico[ pkIdTipoSolicitacao=" + pkIdTipoSolicitacao + " ]";
    }
    
}
