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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "amb_prescricao_medica_as_cuidado", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbPrescricaoMedicaAsCuidado.findAll", query = "SELECT a FROM AmbPrescricaoMedicaAsCuidado a"),
    @NamedQuery(name = "AmbPrescricaoMedicaAsCuidado.findByPkIdPrescricaoMedicaCuidado", query = "SELECT a FROM AmbPrescricaoMedicaAsCuidado a WHERE a.pkIdPrescricaoMedicaCuidado = :pkIdPrescricaoMedicaCuidado")})
public class AmbPrescricaoMedicaAsCuidado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_prescricao_medica_cuidado")
    private Integer pkIdPrescricaoMedicaCuidado;
    @JoinColumn(name = "fk_id_prescricao_medica", referencedColumnName = "pk_id_prescricao_medica")
    @ManyToOne(optional = false)
    private AmbPrescricaoMedica fkIdPrescricaoMedica;
    @JoinColumn(name = "fk_id_cuidado", referencedColumnName = "pk_id_cuidado")
    @ManyToOne(optional = false)
    private AmbCuidado fkIdCuidado;

    public AmbPrescricaoMedicaAsCuidado() {
    }

    public AmbPrescricaoMedicaAsCuidado(Integer pkIdPrescricaoMedicaCuidado) {
        this.pkIdPrescricaoMedicaCuidado = pkIdPrescricaoMedicaCuidado;
    }

    public Integer getPkIdPrescricaoMedicaCuidado() {
        return pkIdPrescricaoMedicaCuidado;
    }

    public void setPkIdPrescricaoMedicaCuidado(Integer pkIdPrescricaoMedicaCuidado) {
        this.pkIdPrescricaoMedicaCuidado = pkIdPrescricaoMedicaCuidado;
    }

    public AmbPrescricaoMedica getFkIdPrescricaoMedica() {
        return fkIdPrescricaoMedica;
    }

    public void setFkIdPrescricaoMedica(AmbPrescricaoMedica fkIdPrescricaoMedica) {
        this.fkIdPrescricaoMedica = fkIdPrescricaoMedica;
    }

    public AmbCuidado getFkIdCuidado() {
        return fkIdCuidado;
    }

    public void setFkIdCuidado(AmbCuidado fkIdCuidado) {
        this.fkIdCuidado = fkIdCuidado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdPrescricaoMedicaCuidado != null ? pkIdPrescricaoMedicaCuidado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbPrescricaoMedicaAsCuidado)) {
            return false;
        }
        AmbPrescricaoMedicaAsCuidado other = (AmbPrescricaoMedicaAsCuidado) object;
        if ((this.pkIdPrescricaoMedicaCuidado == null && other.pkIdPrescricaoMedicaCuidado != null) || (this.pkIdPrescricaoMedicaCuidado != null && !this.pkIdPrescricaoMedicaCuidado.equals(other.pkIdPrescricaoMedicaCuidado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbPrescricaoMedicaAsCuidado[ pkIdPrescricaoMedicaCuidado=" + pkIdPrescricaoMedicaCuidado + " ]";
    }
    
}
