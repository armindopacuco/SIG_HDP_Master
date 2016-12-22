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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "supi_pontuacao", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupiPontuacao.findAll", query = "SELECT s FROM SupiPontuacao s"),
    @NamedQuery(name = "SupiPontuacao.findByPkIdPontuacao", query = "SELECT s FROM SupiPontuacao s WHERE s.pkIdPontuacao = :pkIdPontuacao"),
    @NamedQuery(name = "SupiPontuacao.findByValorInicial", query = "SELECT s FROM SupiPontuacao s WHERE s.valorInicial = :valorInicial"),
    @NamedQuery(name = "SupiPontuacao.findByValorFinal", query = "SELECT s FROM SupiPontuacao s WHERE s.valorFinal = :valorFinal")})
public class SupiPontuacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_pontuacao")
    private Integer pkIdPontuacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_inicial")
    private double valorInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_final")
    private double valorFinal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdPontuacao")
    private List<SupiCriterioAvaliacao> supiCriterioAvaliacaoList;

    public SupiPontuacao() {
    }

    public SupiPontuacao(Integer pkIdPontuacao) {
        this.pkIdPontuacao = pkIdPontuacao;
    }

    public SupiPontuacao(Integer pkIdPontuacao, double valorInicial, double valorFinal) {
        this.pkIdPontuacao = pkIdPontuacao;
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
    }

    public Integer getPkIdPontuacao() {
        return pkIdPontuacao;
    }

    public void setPkIdPontuacao(Integer pkIdPontuacao) {
        this.pkIdPontuacao = pkIdPontuacao;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    @XmlTransient
    public List<SupiCriterioAvaliacao> getSupiCriterioAvaliacaoList() {
        return supiCriterioAvaliacaoList;
    }

    public void setSupiCriterioAvaliacaoList(List<SupiCriterioAvaliacao> supiCriterioAvaliacaoList) {
        this.supiCriterioAvaliacaoList = supiCriterioAvaliacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdPontuacao != null ? pkIdPontuacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupiPontuacao)) {
            return false;
        }
        SupiPontuacao other = (SupiPontuacao) object;
        if ((this.pkIdPontuacao == null && other.pkIdPontuacao != null) || (this.pkIdPontuacao != null && !this.pkIdPontuacao.equals(other.pkIdPontuacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.SupiPontuacao[ pkIdPontuacao=" + pkIdPontuacao + " ]";
    }
    
}
