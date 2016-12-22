/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "rh_curso", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhCurso.findAll", query = "SELECT r FROM RhCurso r"),
    @NamedQuery(name = "RhCurso.findByPkIdCurso", query = "SELECT r FROM RhCurso r WHERE r.pkIdCurso = :pkIdCurso"),
    @NamedQuery(name = "RhCurso.findByDescricao", query = "SELECT r FROM RhCurso r WHERE r.descricao = :descricao")})
public class RhCurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_curso")
    private Integer pkIdCurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "fk_id_faculdade", referencedColumnName = "pk_id_faculdade")
    @ManyToOne(optional = false)
    private RhFaculdade fkIdFaculdade;
    @OneToMany(mappedBy = "fkIdCurso")
    private List<RhCandidato> rhCandidatoList;

    public RhCurso() {
    }

    public RhCurso(Integer pkIdCurso) {
        this.pkIdCurso = pkIdCurso;
    }

    public RhCurso(Integer pkIdCurso, String descricao) {
        this.pkIdCurso = pkIdCurso;
        this.descricao = descricao;
    }

    public Integer getPkIdCurso() {
        return pkIdCurso;
    }

    public void setPkIdCurso(Integer pkIdCurso) {
        this.pkIdCurso = pkIdCurso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public RhFaculdade getFkIdFaculdade() {
        return fkIdFaculdade;
    }

    public void setFkIdFaculdade(RhFaculdade fkIdFaculdade) {
        this.fkIdFaculdade = fkIdFaculdade;
    }

    @XmlTransient
    public List<RhCandidato> getRhCandidatoList() {
        return rhCandidatoList;
    }

    public void setRhCandidatoList(List<RhCandidato> rhCandidatoList) {
        this.rhCandidatoList = rhCandidatoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdCurso != null ? pkIdCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhCurso)) {
            return false;
        }
        RhCurso other = (RhCurso) object;
        if ((this.pkIdCurso == null && other.pkIdCurso != null) || (this.pkIdCurso != null && !this.pkIdCurso.equals(other.pkIdCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.RhCurso[ pkIdCurso=" + pkIdCurso + " ]";
    }
    
}
