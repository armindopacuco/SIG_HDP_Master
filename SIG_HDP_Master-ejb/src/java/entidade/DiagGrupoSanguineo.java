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
@Table(name = "diag_grupo_sanguineo", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagGrupoSanguineo.findAll", query = "SELECT d FROM DiagGrupoSanguineo d"),
    @NamedQuery(name = "DiagGrupoSanguineo.findByPkIdGrupoSanguineo", query = "SELECT d FROM DiagGrupoSanguineo d WHERE d.pkIdGrupoSanguineo = :pkIdGrupoSanguineo"),
    @NamedQuery(name = "DiagGrupoSanguineo.findByDescricaoGrupoSanguineo", query = "SELECT d FROM DiagGrupoSanguineo d WHERE d.descricaoGrupoSanguineo = :descricaoGrupoSanguineo")})
public class DiagGrupoSanguineo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_grupo_sanguineo")
    private Integer pkIdGrupoSanguineo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao_grupo_sanguineo")
    private String descricaoGrupoSanguineo;
    @OneToMany(mappedBy = "fkIdGrupoSanguineo")
    private List<DiagTipagemDoente> diagTipagemDoenteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdGrupoSanguineo")
    private List<DiagDador> diagDadorList;

    public DiagGrupoSanguineo() {
    }

    public DiagGrupoSanguineo(Integer pkIdGrupoSanguineo) {
        this.pkIdGrupoSanguineo = pkIdGrupoSanguineo;
    }

    public DiagGrupoSanguineo(Integer pkIdGrupoSanguineo, String descricaoGrupoSanguineo) {
        this.pkIdGrupoSanguineo = pkIdGrupoSanguineo;
        this.descricaoGrupoSanguineo = descricaoGrupoSanguineo;
    }

    public Integer getPkIdGrupoSanguineo() {
        return pkIdGrupoSanguineo;
    }

    public void setPkIdGrupoSanguineo(Integer pkIdGrupoSanguineo) {
        this.pkIdGrupoSanguineo = pkIdGrupoSanguineo;
    }

    public String getDescricaoGrupoSanguineo() {
        return descricaoGrupoSanguineo;
    }

    public void setDescricaoGrupoSanguineo(String descricaoGrupoSanguineo) {
        this.descricaoGrupoSanguineo = descricaoGrupoSanguineo;
    }

    @XmlTransient
    public List<DiagTipagemDoente> getDiagTipagemDoenteList() {
        return diagTipagemDoenteList;
    }

    public void setDiagTipagemDoenteList(List<DiagTipagemDoente> diagTipagemDoenteList) {
        this.diagTipagemDoenteList = diagTipagemDoenteList;
    }

    @XmlTransient
    public List<DiagDador> getDiagDadorList() {
        return diagDadorList;
    }

    public void setDiagDadorList(List<DiagDador> diagDadorList) {
        this.diagDadorList = diagDadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdGrupoSanguineo != null ? pkIdGrupoSanguineo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagGrupoSanguineo)) {
            return false;
        }
        DiagGrupoSanguineo other = (DiagGrupoSanguineo) object;
        if ((this.pkIdGrupoSanguineo == null && other.pkIdGrupoSanguineo != null) || (this.pkIdGrupoSanguineo != null && !this.pkIdGrupoSanguineo.equals(other.pkIdGrupoSanguineo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.DiagGrupoSanguineo[ pkIdGrupoSanguineo=" + pkIdGrupoSanguineo + " ]";
    }
    
}
