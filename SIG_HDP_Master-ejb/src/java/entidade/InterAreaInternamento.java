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
@Table(name = "inter_area_internamento", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterAreaInternamento.findAll", query = "SELECT i FROM InterAreaInternamento i"),
    @NamedQuery(name = "InterAreaInternamento.findByPkIdAreaInternamento", query = "SELECT i FROM InterAreaInternamento i WHERE i.pkIdAreaInternamento = :pkIdAreaInternamento"),
    @NamedQuery(name = "InterAreaInternamento.findByDescricaoAreaInternamento", query = "SELECT i FROM InterAreaInternamento i WHERE i.descricaoAreaInternamento = :descricaoAreaInternamento"),
    @NamedQuery(name = "InterAreaInternamento.findByCodigoAreaInternamento", query = "SELECT i FROM InterAreaInternamento i WHERE i.codigoAreaInternamento = :codigoAreaInternamento")})
public class InterAreaInternamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_id_area_internamento")
    private Integer pkIdAreaInternamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descricao_area_internamento")
    private Serializable descricaoAreaInternamento;
    @Column(name = "codigo_area_internamento")
    private Serializable codigoAreaInternamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdAreaInternamento")
    private List<InterEnfermaria> interEnfermariaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdAreaInternamento")
    private List<InterInscricaoInternamento> interInscricaoInternamentoList;

    public InterAreaInternamento() {
    }

    public InterAreaInternamento(Integer pkIdAreaInternamento) {
        this.pkIdAreaInternamento = pkIdAreaInternamento;
    }

    public InterAreaInternamento(Integer pkIdAreaInternamento, Serializable descricaoAreaInternamento) {
        this.pkIdAreaInternamento = pkIdAreaInternamento;
        this.descricaoAreaInternamento = descricaoAreaInternamento;
    }

    public Integer getPkIdAreaInternamento() {
        return pkIdAreaInternamento;
    }

    public void setPkIdAreaInternamento(Integer pkIdAreaInternamento) {
        this.pkIdAreaInternamento = pkIdAreaInternamento;
    }

    public Serializable getDescricaoAreaInternamento() {
        return descricaoAreaInternamento;
    }

    public void setDescricaoAreaInternamento(Serializable descricaoAreaInternamento) {
        this.descricaoAreaInternamento = descricaoAreaInternamento;
    }

    public Serializable getCodigoAreaInternamento() {
        return codigoAreaInternamento;
    }

    public void setCodigoAreaInternamento(Serializable codigoAreaInternamento) {
        this.codigoAreaInternamento = codigoAreaInternamento;
    }

    @XmlTransient
    public List<InterEnfermaria> getInterEnfermariaList() {
        return interEnfermariaList;
    }

    public void setInterEnfermariaList(List<InterEnfermaria> interEnfermariaList) {
        this.interEnfermariaList = interEnfermariaList;
    }

    @XmlTransient
    public List<InterInscricaoInternamento> getInterInscricaoInternamentoList() {
        return interInscricaoInternamentoList;
    }

    public void setInterInscricaoInternamentoList(List<InterInscricaoInternamento> interInscricaoInternamentoList) {
        this.interInscricaoInternamentoList = interInscricaoInternamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdAreaInternamento != null ? pkIdAreaInternamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterAreaInternamento)) {
            return false;
        }
        InterAreaInternamento other = (InterAreaInternamento) object;
        if ((this.pkIdAreaInternamento == null && other.pkIdAreaInternamento != null) || (this.pkIdAreaInternamento != null && !this.pkIdAreaInternamento.equals(other.pkIdAreaInternamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.InterAreaInternamento[ pkIdAreaInternamento=" + pkIdAreaInternamento + " ]";
    }
    
}
