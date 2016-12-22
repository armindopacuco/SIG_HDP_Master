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
@Table(name = "rh_assiduidade_mensal", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhAssiduidadeMensal.findAll", query = "SELECT r FROM RhAssiduidadeMensal r"),
    @NamedQuery(name = "RhAssiduidadeMensal.findByPkIdAssiduidadeMensal", query = "SELECT r FROM RhAssiduidadeMensal r WHERE r.pkIdAssiduidadeMensal = :pkIdAssiduidadeMensal"),
    @NamedQuery(name = "RhAssiduidadeMensal.findByAno", query = "SELECT r FROM RhAssiduidadeMensal r WHERE r.ano = :ano"),
    @NamedQuery(name = "RhAssiduidadeMensal.findByMes", query = "SELECT r FROM RhAssiduidadeMensal r WHERE r.mes = :mes")})
public class RhAssiduidadeMensal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_assiduidade_mensal")
    private Integer pkIdAssiduidadeMensal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano")
    private int ano;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mes")
    private int mes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdAssiduidadeMensal")
    private List<RhCandidatoHasRhTipoFalta> rhCandidatoHasRhTipoFaltaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdAssiduidadeMensal")
    private List<RhFuncionarioHasRhTipoFalta> rhFuncionarioHasRhTipoFaltaList;

    public RhAssiduidadeMensal() {
    }

    public RhAssiduidadeMensal(Integer pkIdAssiduidadeMensal) {
        this.pkIdAssiduidadeMensal = pkIdAssiduidadeMensal;
    }

    public RhAssiduidadeMensal(Integer pkIdAssiduidadeMensal, int ano, int mes) {
        this.pkIdAssiduidadeMensal = pkIdAssiduidadeMensal;
        this.ano = ano;
        this.mes = mes;
    }

    public Integer getPkIdAssiduidadeMensal() {
        return pkIdAssiduidadeMensal;
    }

    public void setPkIdAssiduidadeMensal(Integer pkIdAssiduidadeMensal) {
        this.pkIdAssiduidadeMensal = pkIdAssiduidadeMensal;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    @XmlTransient
    public List<RhCandidatoHasRhTipoFalta> getRhCandidatoHasRhTipoFaltaList() {
        return rhCandidatoHasRhTipoFaltaList;
    }

    public void setRhCandidatoHasRhTipoFaltaList(List<RhCandidatoHasRhTipoFalta> rhCandidatoHasRhTipoFaltaList) {
        this.rhCandidatoHasRhTipoFaltaList = rhCandidatoHasRhTipoFaltaList;
    }

    @XmlTransient
    public List<RhFuncionarioHasRhTipoFalta> getRhFuncionarioHasRhTipoFaltaList() {
        return rhFuncionarioHasRhTipoFaltaList;
    }

    public void setRhFuncionarioHasRhTipoFaltaList(List<RhFuncionarioHasRhTipoFalta> rhFuncionarioHasRhTipoFaltaList) {
        this.rhFuncionarioHasRhTipoFaltaList = rhFuncionarioHasRhTipoFaltaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdAssiduidadeMensal != null ? pkIdAssiduidadeMensal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhAssiduidadeMensal)) {
            return false;
        }
        RhAssiduidadeMensal other = (RhAssiduidadeMensal) object;
        if ((this.pkIdAssiduidadeMensal == null && other.pkIdAssiduidadeMensal != null) || (this.pkIdAssiduidadeMensal != null && !this.pkIdAssiduidadeMensal.equals(other.pkIdAssiduidadeMensal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.RhAssiduidadeMensal[ pkIdAssiduidadeMensal=" + pkIdAssiduidadeMensal + " ]";
    }
    
}
