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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "supi_criterio_avaliacao", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupiCriterioAvaliacao.findAll", query = "SELECT s FROM SupiCriterioAvaliacao s"),
    @NamedQuery(name = "SupiCriterioAvaliacao.findByPkIdCriterioAvaliacao", query = "SELECT s FROM SupiCriterioAvaliacao s WHERE s.pkIdCriterioAvaliacao = :pkIdCriterioAvaliacao"),
    @NamedQuery(name = "SupiCriterioAvaliacao.findByDescricaoCriterio", query = "SELECT s FROM SupiCriterioAvaliacao s WHERE s.descricaoCriterio = :descricaoCriterio")})
public class SupiCriterioAvaliacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_criterio_avaliacao")
    private Integer pkIdCriterioAvaliacao;
    @Size(max = 100)
    @Column(name = "descricao_criterio")
    private String descricaoCriterio;
    @JoinColumn(name = "fk_id_pontuacao", referencedColumnName = "pk_id_pontuacao")
    @ManyToOne(optional = false)
    private SupiPontuacao fkIdPontuacao;

    public SupiCriterioAvaliacao() {
    }

    public SupiCriterioAvaliacao(Integer pkIdCriterioAvaliacao) {
        this.pkIdCriterioAvaliacao = pkIdCriterioAvaliacao;
    }

    public Integer getPkIdCriterioAvaliacao() {
        return pkIdCriterioAvaliacao;
    }

    public void setPkIdCriterioAvaliacao(Integer pkIdCriterioAvaliacao) {
        this.pkIdCriterioAvaliacao = pkIdCriterioAvaliacao;
    }

    public String getDescricaoCriterio() {
        return descricaoCriterio;
    }

    public void setDescricaoCriterio(String descricaoCriterio) {
        this.descricaoCriterio = descricaoCriterio;
    }

    public SupiPontuacao getFkIdPontuacao() {
        return fkIdPontuacao;
    }

    public void setFkIdPontuacao(SupiPontuacao fkIdPontuacao) {
        this.fkIdPontuacao = fkIdPontuacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdCriterioAvaliacao != null ? pkIdCriterioAvaliacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupiCriterioAvaliacao)) {
            return false;
        }
        SupiCriterioAvaliacao other = (SupiCriterioAvaliacao) object;
        if ((this.pkIdCriterioAvaliacao == null && other.pkIdCriterioAvaliacao != null) || (this.pkIdCriterioAvaliacao != null && !this.pkIdCriterioAvaliacao.equals(other.pkIdCriterioAvaliacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.SupiCriterioAvaliacao[ pkIdCriterioAvaliacao=" + pkIdCriterioAvaliacao + " ]";
    }
    
}
