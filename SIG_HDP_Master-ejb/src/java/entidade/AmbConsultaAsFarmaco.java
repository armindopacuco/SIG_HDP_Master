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
@Table(name = "amb_consulta_as_farmaco", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbConsultaAsFarmaco.findAll", query = "SELECT a FROM AmbConsultaAsFarmaco a"),
    @NamedQuery(name = "AmbConsultaAsFarmaco.findByPkIdConsultaFarmaco", query = "SELECT a FROM AmbConsultaAsFarmaco a WHERE a.pkIdConsultaFarmaco = :pkIdConsultaFarmaco"),
    @NamedQuery(name = "AmbConsultaAsFarmaco.findByOutroFarmaco", query = "SELECT a FROM AmbConsultaAsFarmaco a WHERE a.outroFarmaco = :outroFarmaco")})
public class AmbConsultaAsFarmaco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_consulta_farmaco")
    private Integer pkIdConsultaFarmaco;
    @Size(max = 100)
    @Column(name = "outro_farmaco")
    private String outroFarmaco;
    @JoinColumn(name = "fk_id_farmaco", referencedColumnName = "pk_id_medicamento")
    @ManyToOne(optional = false)
    private FarmMedicamento fkIdFarmaco;
    @JoinColumn(name = "fk_id_consulta", referencedColumnName = "pk_id_consulta")
    @ManyToOne(optional = false)
    private AmbConsulta fkIdConsulta;

    public AmbConsultaAsFarmaco() {
    }

    public AmbConsultaAsFarmaco(Integer pkIdConsultaFarmaco) {
        this.pkIdConsultaFarmaco = pkIdConsultaFarmaco;
    }

    public Integer getPkIdConsultaFarmaco() {
        return pkIdConsultaFarmaco;
    }

    public void setPkIdConsultaFarmaco(Integer pkIdConsultaFarmaco) {
        this.pkIdConsultaFarmaco = pkIdConsultaFarmaco;
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

    public AmbConsulta getFkIdConsulta() {
        return fkIdConsulta;
    }

    public void setFkIdConsulta(AmbConsulta fkIdConsulta) {
        this.fkIdConsulta = fkIdConsulta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdConsultaFarmaco != null ? pkIdConsultaFarmaco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbConsultaAsFarmaco)) {
            return false;
        }
        AmbConsultaAsFarmaco other = (AmbConsultaAsFarmaco) object;
        if ((this.pkIdConsultaFarmaco == null && other.pkIdConsultaFarmaco != null) || (this.pkIdConsultaFarmaco != null && !this.pkIdConsultaFarmaco.equals(other.pkIdConsultaFarmaco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbConsultaAsFarmaco[ pkIdConsultaFarmaco=" + pkIdConsultaFarmaco + " ]";
    }
    
}
