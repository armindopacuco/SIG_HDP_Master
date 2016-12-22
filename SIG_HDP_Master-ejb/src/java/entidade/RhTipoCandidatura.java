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
@Table(name = "rh_tipo_candidatura", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhTipoCandidatura.findAll", query = "SELECT r FROM RhTipoCandidatura r"),
    @NamedQuery(name = "RhTipoCandidatura.findByPkIdTipoCandidatura", query = "SELECT r FROM RhTipoCandidatura r WHERE r.pkIdTipoCandidatura = :pkIdTipoCandidatura"),
    @NamedQuery(name = "RhTipoCandidatura.findByDescricao", query = "SELECT r FROM RhTipoCandidatura r WHERE r.descricao = :descricao"),
    @NamedQuery(name = "RhTipoCandidatura.findByCodigo", query = "SELECT r FROM RhTipoCandidatura r WHERE r.codigo = :codigo"),
    @NamedQuery(name = "RhTipoCandidatura.findByEstagio", query = "SELECT r FROM RhTipoCandidatura r WHERE r.estagio = :estagio")})
public class RhTipoCandidatura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_tipo_candidatura")
    private Integer pkIdTipoCandidatura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 20)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estagio")
    private boolean estagio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdTipoCandidatura")
    private List<RhCandidato> rhCandidatoList;

    public RhTipoCandidatura() {
    }

    public RhTipoCandidatura(Integer pkIdTipoCandidatura) {
        this.pkIdTipoCandidatura = pkIdTipoCandidatura;
    }

    public RhTipoCandidatura(Integer pkIdTipoCandidatura, String descricao, boolean estagio) {
        this.pkIdTipoCandidatura = pkIdTipoCandidatura;
        this.descricao = descricao;
        this.estagio = estagio;
    }

    public Integer getPkIdTipoCandidatura() {
        return pkIdTipoCandidatura;
    }

    public void setPkIdTipoCandidatura(Integer pkIdTipoCandidatura) {
        this.pkIdTipoCandidatura = pkIdTipoCandidatura;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean getEstagio() {
        return estagio;
    }

    public void setEstagio(boolean estagio) {
        this.estagio = estagio;
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
        hash += (pkIdTipoCandidatura != null ? pkIdTipoCandidatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhTipoCandidatura)) {
            return false;
        }
        RhTipoCandidatura other = (RhTipoCandidatura) object;
        if ((this.pkIdTipoCandidatura == null && other.pkIdTipoCandidatura != null) || (this.pkIdTipoCandidatura != null && !this.pkIdTipoCandidatura.equals(other.pkIdTipoCandidatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.RhTipoCandidatura[ pkIdTipoCandidatura=" + pkIdTipoCandidatura + " ]";
    }
    
}
