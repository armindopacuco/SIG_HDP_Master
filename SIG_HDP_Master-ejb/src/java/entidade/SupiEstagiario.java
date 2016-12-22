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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "supi_estagiario", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupiEstagiario.findAll", query = "SELECT s FROM SupiEstagiario s"),
    @NamedQuery(name = "SupiEstagiario.findByPkIdEstagiario", query = "SELECT s FROM SupiEstagiario s WHERE s.pkIdEstagiario = :pkIdEstagiario")})
public class SupiEstagiario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_estagiario")
    private Integer pkIdEstagiario;
    @JoinColumn(name = "fk_id_candidato", referencedColumnName = "pk_id_candidato")
    @ManyToOne(optional = false)
    private RhCandidato fkIdCandidato;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdEstagiario")
    private List<SupiFormacaoEstagiario> supiFormacaoEstagiarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdEstagiario")
    private List<SupiAvaliacaoDesempenho> supiAvaliacaoDesempenhoList;

    public SupiEstagiario() {
    }

    public SupiEstagiario(Integer pkIdEstagiario) {
        this.pkIdEstagiario = pkIdEstagiario;
    }

    public Integer getPkIdEstagiario() {
        return pkIdEstagiario;
    }

    public void setPkIdEstagiario(Integer pkIdEstagiario) {
        this.pkIdEstagiario = pkIdEstagiario;
    }

    public RhCandidato getFkIdCandidato() {
        return fkIdCandidato;
    }

    public void setFkIdCandidato(RhCandidato fkIdCandidato) {
        this.fkIdCandidato = fkIdCandidato;
    }

    @XmlTransient
    public List<SupiFormacaoEstagiario> getSupiFormacaoEstagiarioList() {
        return supiFormacaoEstagiarioList;
    }

    public void setSupiFormacaoEstagiarioList(List<SupiFormacaoEstagiario> supiFormacaoEstagiarioList) {
        this.supiFormacaoEstagiarioList = supiFormacaoEstagiarioList;
    }

    @XmlTransient
    public List<SupiAvaliacaoDesempenho> getSupiAvaliacaoDesempenhoList() {
        return supiAvaliacaoDesempenhoList;
    }

    public void setSupiAvaliacaoDesempenhoList(List<SupiAvaliacaoDesempenho> supiAvaliacaoDesempenhoList) {
        this.supiAvaliacaoDesempenhoList = supiAvaliacaoDesempenhoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdEstagiario != null ? pkIdEstagiario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupiEstagiario)) {
            return false;
        }
        SupiEstagiario other = (SupiEstagiario) object;
        if ((this.pkIdEstagiario == null && other.pkIdEstagiario != null) || (this.pkIdEstagiario != null && !this.pkIdEstagiario.equals(other.pkIdEstagiario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.SupiEstagiario[ pkIdEstagiario=" + pkIdEstagiario + " ]";
    }
    
}
