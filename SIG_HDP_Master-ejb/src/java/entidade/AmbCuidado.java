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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "amb_cuidado", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbCuidado.findAll", query = "SELECT a FROM AmbCuidado a"),
    @NamedQuery(name = "AmbCuidado.findByPkIdCuidado", query = "SELECT a FROM AmbCuidado a WHERE a.pkIdCuidado = :pkIdCuidado"),
    @NamedQuery(name = "AmbCuidado.findByDescricao", query = "SELECT a FROM AmbCuidado a WHERE a.descricao = :descricao"),
    @NamedQuery(name = "AmbCuidado.findByObservacoes", query = "SELECT a FROM AmbCuidado a WHERE a.observacoes = :observacoes")})
public class AmbCuidado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_cuidado")
    private Integer pkIdCuidado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 500)
    @Column(name = "observacoes")
    private String observacoes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdCuidado")
    private List<AmbPrescricaoMedicaAsCuidado> ambPrescricaoMedicaAsCuidadoList;
    @JoinColumn(name = "fk_id_tipo_cuidado", referencedColumnName = "pk_id_tipo_cuidado")
    @ManyToOne(optional = false)
    private AmbTipoCuidado fkIdTipoCuidado;

    public AmbCuidado() {
    }

    public AmbCuidado(Integer pkIdCuidado) {
        this.pkIdCuidado = pkIdCuidado;
    }

    public AmbCuidado(Integer pkIdCuidado, String descricao) {
        this.pkIdCuidado = pkIdCuidado;
        this.descricao = descricao;
    }

    public Integer getPkIdCuidado() {
        return pkIdCuidado;
    }

    public void setPkIdCuidado(Integer pkIdCuidado) {
        this.pkIdCuidado = pkIdCuidado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @XmlTransient
    public List<AmbPrescricaoMedicaAsCuidado> getAmbPrescricaoMedicaAsCuidadoList() {
        return ambPrescricaoMedicaAsCuidadoList;
    }

    public void setAmbPrescricaoMedicaAsCuidadoList(List<AmbPrescricaoMedicaAsCuidado> ambPrescricaoMedicaAsCuidadoList) {
        this.ambPrescricaoMedicaAsCuidadoList = ambPrescricaoMedicaAsCuidadoList;
    }

    public AmbTipoCuidado getFkIdTipoCuidado() {
        return fkIdTipoCuidado;
    }

    public void setFkIdTipoCuidado(AmbTipoCuidado fkIdTipoCuidado) {
        this.fkIdTipoCuidado = fkIdTipoCuidado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdCuidado != null ? pkIdCuidado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbCuidado)) {
            return false;
        }
        AmbCuidado other = (AmbCuidado) object;
        if ((this.pkIdCuidado == null && other.pkIdCuidado != null) || (this.pkIdCuidado != null && !this.pkIdCuidado.equals(other.pkIdCuidado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbCuidado[ pkIdCuidado=" + pkIdCuidado + " ]";
    }
    
}
