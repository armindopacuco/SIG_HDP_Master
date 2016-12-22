/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "amb_anamnese_as_farmaco", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbAnamneseAsFarmaco.findAll", query = "SELECT a FROM AmbAnamneseAsFarmaco a"),
    @NamedQuery(name = "AmbAnamneseAsFarmaco.findByPkIdAnamneseFarmaco", query = "SELECT a FROM AmbAnamneseAsFarmaco a WHERE a.pkIdAnamneseFarmaco = :pkIdAnamneseFarmaco"),
    @NamedQuery(name = "AmbAnamneseAsFarmaco.findByOutroFarmaco", query = "SELECT a FROM AmbAnamneseAsFarmaco a WHERE a.outroFarmaco = :outroFarmaco")})
public class AmbAnamneseAsFarmaco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_anamnese_farmaco")
    private Integer pkIdAnamneseFarmaco;
    @Size(max = 100)
    @Column(name = "outro_farmaco")
    private String outroFarmaco;
    @JoinColumn(name = "fk_id_farmaco", referencedColumnName = "pk_id_medicamento")
    @ManyToOne(optional = false)
    private FarmMedicamento fkIdFarmaco;
    @JoinColumn(name = "fk_id_anamnese", referencedColumnName = "pk_id_anamenese")
    @ManyToOne(optional = false)
    private AmbAnamenese fkIdAnamnese;

    public AmbAnamneseAsFarmaco() {
    }

    public AmbAnamneseAsFarmaco(Integer pkIdAnamneseFarmaco) {
        this.pkIdAnamneseFarmaco = pkIdAnamneseFarmaco;
    }

    public Integer getPkIdAnamneseFarmaco() {
        return pkIdAnamneseFarmaco;
    }

    public void setPkIdAnamneseFarmaco(Integer pkIdAnamneseFarmaco) {
        this.pkIdAnamneseFarmaco = pkIdAnamneseFarmaco;
    }

    public String getOutroFarmaco() {
        return outroFarmaco;
    }

    public void setOutroFarmaco(String outroFarmaco) {
        this.outroFarmaco = outroFarmaco;
    }

    public FarmMedicamento getFkIdFarmaco() {
        return fkIdFarmaco;
    }

    public void setFkIdFarmaco(FarmMedicamento fkIdFarmaco) {
        this.fkIdFarmaco = fkIdFarmaco;
    }

    public AmbAnamenese getFkIdAnamnese() {
        return fkIdAnamnese;
    }

    public void setFkIdAnamnese(AmbAnamenese fkIdAnamnese) {
        this.fkIdAnamnese = fkIdAnamnese;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdAnamneseFarmaco != null ? pkIdAnamneseFarmaco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbAnamneseAsFarmaco)) {
            return false;
        }
        AmbAnamneseAsFarmaco other = (AmbAnamneseAsFarmaco) object;
        if ((this.pkIdAnamneseFarmaco == null && other.pkIdAnamneseFarmaco != null) || (this.pkIdAnamneseFarmaco != null && !this.pkIdAnamneseFarmaco.equals(other.pkIdAnamneseFarmaco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbAnamneseAsFarmaco[ pkIdAnamneseFarmaco=" + pkIdAnamneseFarmaco + " ]";
    }
    
}
