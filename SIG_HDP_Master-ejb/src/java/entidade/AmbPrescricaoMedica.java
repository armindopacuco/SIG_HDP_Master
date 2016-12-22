/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "amb_prescricao_medica", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbPrescricaoMedica.findAll", query = "SELECT a FROM AmbPrescricaoMedica a"),
    @NamedQuery(name = "AmbPrescricaoMedica.findByPkIdPrescricaoMedica", query = "SELECT a FROM AmbPrescricaoMedica a WHERE a.pkIdPrescricaoMedica = :pkIdPrescricaoMedica"),
    @NamedQuery(name = "AmbPrescricaoMedica.findByDataHoraPrescricao", query = "SELECT a FROM AmbPrescricaoMedica a WHERE a.dataHoraPrescricao = :dataHoraPrescricao"),
    @NamedQuery(name = "AmbPrescricaoMedica.findByFarmaco", query = "SELECT a FROM AmbPrescricaoMedica a WHERE a.farmaco = :farmaco"),
    @NamedQuery(name = "AmbPrescricaoMedica.findByEstado", query = "SELECT a FROM AmbPrescricaoMedica a WHERE a.estado = :estado")})
public class AmbPrescricaoMedica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_prescricao_medica")
    private Integer pkIdPrescricaoMedica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_hora_prescricao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraPrescricao;
    @Size(max = 1000)
    @Column(name = "farmaco")
    private String farmaco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @JoinColumn(name = "fk_id_consulta", referencedColumnName = "pk_id_consulta")
    @ManyToOne(optional = false)
    private AmbConsulta fkIdConsulta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdPrescricaoMedica")
    private List<AmbPrescricaoMedicaAsFarmaco> ambPrescricaoMedicaAsFarmacoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdPrescricaoMedica")
    private List<AmbPrescricaoMedicaAsCuidado> ambPrescricaoMedicaAsCuidadoList;

    public AmbPrescricaoMedica() {
    }

    public AmbPrescricaoMedica(Integer pkIdPrescricaoMedica) {
        this.pkIdPrescricaoMedica = pkIdPrescricaoMedica;
    }

    public AmbPrescricaoMedica(Integer pkIdPrescricaoMedica, Date dataHoraPrescricao, int estado) {
        this.pkIdPrescricaoMedica = pkIdPrescricaoMedica;
        this.dataHoraPrescricao = dataHoraPrescricao;
        this.estado = estado;
    }

    public Integer getPkIdPrescricaoMedica() {
        return pkIdPrescricaoMedica;
    }

    public void setPkIdPrescricaoMedica(Integer pkIdPrescricaoMedica) {
        this.pkIdPrescricaoMedica = pkIdPrescricaoMedica;
    }

    public Date getDataHoraPrescricao() {
        return dataHoraPrescricao;
    }

    public void setDataHoraPrescricao(Date dataHoraPrescricao) {
        this.dataHoraPrescricao = dataHoraPrescricao;
    }

    public String getFarmaco() {
        return farmaco;
    }

    public void setFarmaco(String farmaco) {
        this.farmaco = farmaco;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public AmbConsulta getFkIdConsulta() {
        return fkIdConsulta;
    }

    public void setFkIdConsulta(AmbConsulta fkIdConsulta) {
        this.fkIdConsulta = fkIdConsulta;
    }

    @XmlTransient
    public List<AmbPrescricaoMedicaAsFarmaco> getAmbPrescricaoMedicaAsFarmacoList() {
        return ambPrescricaoMedicaAsFarmacoList;
    }

    public void setAmbPrescricaoMedicaAsFarmacoList(List<AmbPrescricaoMedicaAsFarmaco> ambPrescricaoMedicaAsFarmacoList) {
        this.ambPrescricaoMedicaAsFarmacoList = ambPrescricaoMedicaAsFarmacoList;
    }

    @XmlTransient
    public List<AmbPrescricaoMedicaAsCuidado> getAmbPrescricaoMedicaAsCuidadoList() {
        return ambPrescricaoMedicaAsCuidadoList;
    }

    public void setAmbPrescricaoMedicaAsCuidadoList(List<AmbPrescricaoMedicaAsCuidado> ambPrescricaoMedicaAsCuidadoList) {
        this.ambPrescricaoMedicaAsCuidadoList = ambPrescricaoMedicaAsCuidadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdPrescricaoMedica != null ? pkIdPrescricaoMedica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbPrescricaoMedica)) {
            return false;
        }
        AmbPrescricaoMedica other = (AmbPrescricaoMedica) object;
        if ((this.pkIdPrescricaoMedica == null && other.pkIdPrescricaoMedica != null) || (this.pkIdPrescricaoMedica != null && !this.pkIdPrescricaoMedica.equals(other.pkIdPrescricaoMedica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbPrescricaoMedica[ pkIdPrescricaoMedica=" + pkIdPrescricaoMedica + " ]";
    }
    
}
