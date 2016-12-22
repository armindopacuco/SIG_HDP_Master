/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "amb_prescricao_medica_as_farmaco", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbPrescricaoMedicaAsFarmaco.findAll", query = "SELECT a FROM AmbPrescricaoMedicaAsFarmaco a"),
    @NamedQuery(name = "AmbPrescricaoMedicaAsFarmaco.findByPkIdPrescricaoMedicaFarmaco", query = "SELECT a FROM AmbPrescricaoMedicaAsFarmaco a WHERE a.pkIdPrescricaoMedicaFarmaco = :pkIdPrescricaoMedicaFarmaco"),
    @NamedQuery(name = "AmbPrescricaoMedicaAsFarmaco.findByPosologia", query = "SELECT a FROM AmbPrescricaoMedicaAsFarmaco a WHERE a.posologia = :posologia"),
    @NamedQuery(name = "AmbPrescricaoMedicaAsFarmaco.findByInicio", query = "SELECT a FROM AmbPrescricaoMedicaAsFarmaco a WHERE a.inicio = :inicio"),
    @NamedQuery(name = "AmbPrescricaoMedicaAsFarmaco.findByTermino", query = "SELECT a FROM AmbPrescricaoMedicaAsFarmaco a WHERE a.termino = :termino")})
public class AmbPrescricaoMedicaAsFarmaco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_prescricao_medica_farmaco")
    private Integer pkIdPrescricaoMedicaFarmaco;
    @Size(max = 100)
    @Column(name = "posologia")
    private String posologia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inicio")
    @Temporal(TemporalType.DATE)
    private Date inicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "termino")
    @Temporal(TemporalType.DATE)
    private Date termino;
    @JoinColumn(name = "fk_id_farmaco", referencedColumnName = "pk_id_medicamento")
    @ManyToOne(optional = false)
    private FarmMedicamento fkIdFarmaco;
    @JoinColumn(name = "fk_id_prescricao_medica", referencedColumnName = "pk_id_prescricao_medica")
    @ManyToOne(optional = false)
    private AmbPrescricaoMedica fkIdPrescricaoMedica;
    @JoinColumn(name = "fk_id_frequencia", referencedColumnName = "pk_id_frequencia")
    @ManyToOne(optional = false)
    private AmbFrequencia fkIdFrequencia;

    public AmbPrescricaoMedicaAsFarmaco() {
    }

    public AmbPrescricaoMedicaAsFarmaco(Integer pkIdPrescricaoMedicaFarmaco) {
        this.pkIdPrescricaoMedicaFarmaco = pkIdPrescricaoMedicaFarmaco;
    }

    public AmbPrescricaoMedicaAsFarmaco(Integer pkIdPrescricaoMedicaFarmaco, Date inicio, Date termino) {
        this.pkIdPrescricaoMedicaFarmaco = pkIdPrescricaoMedicaFarmaco;
        this.inicio = inicio;
        this.termino = termino;
    }

    public Integer getPkIdPrescricaoMedicaFarmaco() {
        return pkIdPrescricaoMedicaFarmaco;
    }

    public void setPkIdPrescricaoMedicaFarmaco(Integer pkIdPrescricaoMedicaFarmaco) {
        this.pkIdPrescricaoMedicaFarmaco = pkIdPrescricaoMedicaFarmaco;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }

    public FarmMedicamento getFkIdFarmaco() {
        return fkIdFarmaco;
    }

    public void setFkIdFarmaco(FarmMedicamento fkIdFarmaco) {
        this.fkIdFarmaco = fkIdFarmaco;
    }

    public AmbPrescricaoMedica getFkIdPrescricaoMedica() {
        return fkIdPrescricaoMedica;
    }

    public void setFkIdPrescricaoMedica(AmbPrescricaoMedica fkIdPrescricaoMedica) {
        this.fkIdPrescricaoMedica = fkIdPrescricaoMedica;
    }

    public AmbFrequencia getFkIdFrequencia() {
        return fkIdFrequencia;
    }

    public void setFkIdFrequencia(AmbFrequencia fkIdFrequencia) {
        this.fkIdFrequencia = fkIdFrequencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdPrescricaoMedicaFarmaco != null ? pkIdPrescricaoMedicaFarmaco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbPrescricaoMedicaAsFarmaco)) {
            return false;
        }
        AmbPrescricaoMedicaAsFarmaco other = (AmbPrescricaoMedicaAsFarmaco) object;
        if ((this.pkIdPrescricaoMedicaFarmaco == null && other.pkIdPrescricaoMedicaFarmaco != null) || (this.pkIdPrescricaoMedicaFarmaco != null && !this.pkIdPrescricaoMedicaFarmaco.equals(other.pkIdPrescricaoMedicaFarmaco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbPrescricaoMedicaAsFarmaco[ pkIdPrescricaoMedicaFarmaco=" + pkIdPrescricaoMedicaFarmaco + " ]";
    }
    
}
