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
@Table(name = "morgue_corpo", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MorgueCorpo.findAll", query = "SELECT m FROM MorgueCorpo m"),
    @NamedQuery(name = "MorgueCorpo.findByPkIdCorpo", query = "SELECT m FROM MorgueCorpo m WHERE m.pkIdCorpo = :pkIdCorpo")})
public class MorgueCorpo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_corpo")
    private Integer pkIdCorpo;
    @JoinColumn(name = "fk_id_paciente", referencedColumnName = "pk_id_paciente")
    @ManyToOne(optional = false)
    private AdmsPaciente fkIdPaciente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "morgueCorpo")
    private List<MorgueEntradaCorpo> morgueEntradaCorpoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "morgueCorpo")
    private List<MorgueSaidaCorpo> morgueSaidaCorpoList;

    public MorgueCorpo() {
    }

    public MorgueCorpo(Integer pkIdCorpo) {
        this.pkIdCorpo = pkIdCorpo;
    }

    public Integer getPkIdCorpo() {
        return pkIdCorpo;
    }

    public void setPkIdCorpo(Integer pkIdCorpo) {
        this.pkIdCorpo = pkIdCorpo;
    }

    public AdmsPaciente getFkIdPaciente() {
        return fkIdPaciente;
    }

    public void setFkIdPaciente(AdmsPaciente fkIdPaciente) {
        this.fkIdPaciente = fkIdPaciente;
    }

    @XmlTransient
    public List<MorgueEntradaCorpo> getMorgueEntradaCorpoList() {
        return morgueEntradaCorpoList;
    }

    public void setMorgueEntradaCorpoList(List<MorgueEntradaCorpo> morgueEntradaCorpoList) {
        this.morgueEntradaCorpoList = morgueEntradaCorpoList;
    }

    @XmlTransient
    public List<MorgueSaidaCorpo> getMorgueSaidaCorpoList() {
        return morgueSaidaCorpoList;
    }

    public void setMorgueSaidaCorpoList(List<MorgueSaidaCorpo> morgueSaidaCorpoList) {
        this.morgueSaidaCorpoList = morgueSaidaCorpoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdCorpo != null ? pkIdCorpo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MorgueCorpo)) {
            return false;
        }
        MorgueCorpo other = (MorgueCorpo) object;
        if ((this.pkIdCorpo == null && other.pkIdCorpo != null) || (this.pkIdCorpo != null && !this.pkIdCorpo.equals(other.pkIdCorpo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.MorgueCorpo[ pkIdCorpo=" + pkIdCorpo + " ]";
    }
    
}
