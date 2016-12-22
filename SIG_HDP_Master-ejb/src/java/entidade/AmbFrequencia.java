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
@Table(name = "amb_frequencia", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbFrequencia.findAll", query = "SELECT a FROM AmbFrequencia a"),
    @NamedQuery(name = "AmbFrequencia.findByPkIdFrequencia", query = "SELECT a FROM AmbFrequencia a WHERE a.pkIdFrequencia = :pkIdFrequencia"),
    @NamedQuery(name = "AmbFrequencia.findByDescricao", query = "SELECT a FROM AmbFrequencia a WHERE a.descricao = :descricao")})
public class AmbFrequencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_frequencia")
    private Integer pkIdFrequencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFrequencia")
    private List<AmbPrescricaoMedicaAsFarmaco> ambPrescricaoMedicaAsFarmacoList;

    public AmbFrequencia() {
    }

    public AmbFrequencia(Integer pkIdFrequencia) {
        this.pkIdFrequencia = pkIdFrequencia;
    }

    public AmbFrequencia(Integer pkIdFrequencia, String descricao) {
        this.pkIdFrequencia = pkIdFrequencia;
        this.descricao = descricao;
    }

    public Integer getPkIdFrequencia() {
        return pkIdFrequencia;
    }

    public void setPkIdFrequencia(Integer pkIdFrequencia) {
        this.pkIdFrequencia = pkIdFrequencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<AmbPrescricaoMedicaAsFarmaco> getAmbPrescricaoMedicaAsFarmacoList() {
        return ambPrescricaoMedicaAsFarmacoList;
    }

    public void setAmbPrescricaoMedicaAsFarmacoList(List<AmbPrescricaoMedicaAsFarmaco> ambPrescricaoMedicaAsFarmacoList) {
        this.ambPrescricaoMedicaAsFarmacoList = ambPrescricaoMedicaAsFarmacoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdFrequencia != null ? pkIdFrequencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbFrequencia)) {
            return false;
        }
        AmbFrequencia other = (AmbFrequencia) object;
        if ((this.pkIdFrequencia == null && other.pkIdFrequencia != null) || (this.pkIdFrequencia != null && !this.pkIdFrequencia.equals(other.pkIdFrequencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbFrequencia[ pkIdFrequencia=" + pkIdFrequencia + " ]";
    }
    
}
