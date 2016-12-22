/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "adms_classificacao_servico_solicitado", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdmsClassificacaoServicoSolicitado.findAll", query = "SELECT a FROM AdmsClassificacaoServicoSolicitado a"),
    @NamedQuery(name = "AdmsClassificacaoServicoSolicitado.findByPkIdClassificacaoServicoSolicitado", query = "SELECT a FROM AdmsClassificacaoServicoSolicitado a WHERE a.pkIdClassificacaoServicoSolicitado = :pkIdClassificacaoServicoSolicitado"),
    @NamedQuery(name = "AdmsClassificacaoServicoSolicitado.findByDescricaoClassificacaoServicoSolicitado", query = "SELECT a FROM AdmsClassificacaoServicoSolicitado a WHERE a.descricaoClassificacaoServicoSolicitado = :descricaoClassificacaoServicoSolicitado")})
public class AdmsClassificacaoServicoSolicitado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_classificacao_servico_solicitado")
    private Integer pkIdClassificacaoServicoSolicitado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descricao_classificacao_servico_solicitado")
    private String descricaoClassificacaoServicoSolicitado;

    public AdmsClassificacaoServicoSolicitado() {
    }

    public AdmsClassificacaoServicoSolicitado(Integer pkIdClassificacaoServicoSolicitado) {
        this.pkIdClassificacaoServicoSolicitado = pkIdClassificacaoServicoSolicitado;
    }

    public AdmsClassificacaoServicoSolicitado(Integer pkIdClassificacaoServicoSolicitado, String descricaoClassificacaoServicoSolicitado) {
        this.pkIdClassificacaoServicoSolicitado = pkIdClassificacaoServicoSolicitado;
        this.descricaoClassificacaoServicoSolicitado = descricaoClassificacaoServicoSolicitado;
    }

    public Integer getPkIdClassificacaoServicoSolicitado() {
        return pkIdClassificacaoServicoSolicitado;
    }

    public void setPkIdClassificacaoServicoSolicitado(Integer pkIdClassificacaoServicoSolicitado) {
        this.pkIdClassificacaoServicoSolicitado = pkIdClassificacaoServicoSolicitado;
    }

    public String getDescricaoClassificacaoServicoSolicitado() {
        return descricaoClassificacaoServicoSolicitado;
    }

    public void setDescricaoClassificacaoServicoSolicitado(String descricaoClassificacaoServicoSolicitado) {
        this.descricaoClassificacaoServicoSolicitado = descricaoClassificacaoServicoSolicitado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdClassificacaoServicoSolicitado != null ? pkIdClassificacaoServicoSolicitado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmsClassificacaoServicoSolicitado)) {
            return false;
        }
        AdmsClassificacaoServicoSolicitado other = (AdmsClassificacaoServicoSolicitado) object;
        if ((this.pkIdClassificacaoServicoSolicitado == null && other.pkIdClassificacaoServicoSolicitado != null) || (this.pkIdClassificacaoServicoSolicitado != null && !this.pkIdClassificacaoServicoSolicitado.equals(other.pkIdClassificacaoServicoSolicitado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AdmsClassificacaoServicoSolicitado[ pkIdClassificacaoServicoSolicitado=" + pkIdClassificacaoServicoSolicitado + " ]";
    }
    
}
