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
@Table(name = "diag_tipo_doacao", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagTipoDoacao.findAll", query = "SELECT d FROM DiagTipoDoacao d"),
    @NamedQuery(name = "DiagTipoDoacao.findByPkIdTipoDoacao", query = "SELECT d FROM DiagTipoDoacao d WHERE d.pkIdTipoDoacao = :pkIdTipoDoacao"),
    @NamedQuery(name = "DiagTipoDoacao.findByDescricaoTipoDoacao", query = "SELECT d FROM DiagTipoDoacao d WHERE d.descricaoTipoDoacao = :descricaoTipoDoacao")})
public class DiagTipoDoacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_tipo_doacao")
    private Integer pkIdTipoDoacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao_tipo_doacao")
    private String descricaoTipoDoacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdTipoDoacoesSeguintes")
    private List<DiagDador> diagDadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdTipoPrimeiraDoacao")
    private List<DiagDador> diagDadorList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdTipoDoacao")
    private List<DiagDador> diagDadorList2;

    public DiagTipoDoacao() {
    }

    public DiagTipoDoacao(Integer pkIdTipoDoacao) {
        this.pkIdTipoDoacao = pkIdTipoDoacao;
    }

    public DiagTipoDoacao(Integer pkIdTipoDoacao, String descricaoTipoDoacao) {
        this.pkIdTipoDoacao = pkIdTipoDoacao;
        this.descricaoTipoDoacao = descricaoTipoDoacao;
    }

    public Integer getPkIdTipoDoacao() {
        return pkIdTipoDoacao;
    }

    public void setPkIdTipoDoacao(Integer pkIdTipoDoacao) {
        this.pkIdTipoDoacao = pkIdTipoDoacao;
    }

    public String getDescricaoTipoDoacao() {
        return descricaoTipoDoacao;
    }

    public void setDescricaoTipoDoacao(String descricaoTipoDoacao) {
        this.descricaoTipoDoacao = descricaoTipoDoacao;
    }

    @XmlTransient
    public List<DiagDador> getDiagDadorList() {
        return diagDadorList;
    }

    public void setDiagDadorList(List<DiagDador> diagDadorList) {
        this.diagDadorList = diagDadorList;
    }

    @XmlTransient
    public List<DiagDador> getDiagDadorList1() {
        return diagDadorList1;
    }

    public void setDiagDadorList1(List<DiagDador> diagDadorList1) {
        this.diagDadorList1 = diagDadorList1;
    }

    @XmlTransient
    public List<DiagDador> getDiagDadorList2() {
        return diagDadorList2;
    }

    public void setDiagDadorList2(List<DiagDador> diagDadorList2) {
        this.diagDadorList2 = diagDadorList2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdTipoDoacao != null ? pkIdTipoDoacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagTipoDoacao)) {
            return false;
        }
        DiagTipoDoacao other = (DiagTipoDoacao) object;
        if ((this.pkIdTipoDoacao == null && other.pkIdTipoDoacao != null) || (this.pkIdTipoDoacao != null && !this.pkIdTipoDoacao.equals(other.pkIdTipoDoacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.DiagTipoDoacao[ pkIdTipoDoacao=" + pkIdTipoDoacao + " ]";
    }
    
}
