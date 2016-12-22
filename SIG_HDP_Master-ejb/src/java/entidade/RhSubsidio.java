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
@Table(name = "rh_subsidio", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhSubsidio.findAll", query = "SELECT r FROM RhSubsidio r"),
    @NamedQuery(name = "RhSubsidio.findByPkIdSubsidio", query = "SELECT r FROM RhSubsidio r WHERE r.pkIdSubsidio = :pkIdSubsidio"),
    @NamedQuery(name = "RhSubsidio.findByDescricaoSubsidio", query = "SELECT r FROM RhSubsidio r WHERE r.descricaoSubsidio = :descricaoSubsidio"),
    @NamedQuery(name = "RhSubsidio.findByObrigatorio", query = "SELECT r FROM RhSubsidio r WHERE r.obrigatorio = :obrigatorio")})
public class RhSubsidio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_subsidio")
    private Integer pkIdSubsidio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao_subsidio")
    private String descricaoSubsidio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "obrigatorio")
    private boolean obrigatorio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdSubsidio")
    private List<RhSubsidioHasRhContrato> rhSubsidioHasRhContratoList;

    public RhSubsidio() {
    }

    public RhSubsidio(Integer pkIdSubsidio) {
        this.pkIdSubsidio = pkIdSubsidio;
    }

    public RhSubsidio(Integer pkIdSubsidio, String descricaoSubsidio, boolean obrigatorio) {
        this.pkIdSubsidio = pkIdSubsidio;
        this.descricaoSubsidio = descricaoSubsidio;
        this.obrigatorio = obrigatorio;
    }

    public Integer getPkIdSubsidio() {
        return pkIdSubsidio;
    }

    public void setPkIdSubsidio(Integer pkIdSubsidio) {
        this.pkIdSubsidio = pkIdSubsidio;
    }

    public String getDescricaoSubsidio() {
        return descricaoSubsidio;
    }

    public void setDescricaoSubsidio(String descricaoSubsidio) {
        this.descricaoSubsidio = descricaoSubsidio;
    }

    public boolean getObrigatorio() {
        return obrigatorio;
    }

    public void setObrigatorio(boolean obrigatorio) {
        this.obrigatorio = obrigatorio;
    }

    @XmlTransient
    public List<RhSubsidioHasRhContrato> getRhSubsidioHasRhContratoList() {
        return rhSubsidioHasRhContratoList;
    }

    public void setRhSubsidioHasRhContratoList(List<RhSubsidioHasRhContrato> rhSubsidioHasRhContratoList) {
        this.rhSubsidioHasRhContratoList = rhSubsidioHasRhContratoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdSubsidio != null ? pkIdSubsidio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhSubsidio)) {
            return false;
        }
        RhSubsidio other = (RhSubsidio) object;
        if ((this.pkIdSubsidio == null && other.pkIdSubsidio != null) || (this.pkIdSubsidio != null && !this.pkIdSubsidio.equals(other.pkIdSubsidio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.RhSubsidio[ pkIdSubsidio=" + pkIdSubsidio + " ]";
    }
    
}
