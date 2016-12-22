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
@Table(name = "grl_municipio", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrlMunicipio.findAll", query = "SELECT g FROM GrlMunicipio g"),
    @NamedQuery(name = "GrlMunicipio.findByPkIdMunicipio", query = "SELECT g FROM GrlMunicipio g WHERE g.pkIdMunicipio = :pkIdMunicipio"),
    @NamedQuery(name = "GrlMunicipio.findByNomeMunicipio", query = "SELECT g FROM GrlMunicipio g WHERE g.nomeMunicipio = :nomeMunicipio")})
public class GrlMunicipio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_municipio")
    private Integer pkIdMunicipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome_municipio")
    private String nomeMunicipio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdMunicipio")
    private List<GrlEndereco> grlEnderecoList;
    @OneToMany(mappedBy = "fkMunicipioOrigem")
    private List<DiagCandidatoDador> diagCandidatoDadorList;
    @JoinColumn(name = "fk_id_provincia", referencedColumnName = "pk_id_provincia")
    @ManyToOne(optional = false)
    private GrlProvincia fkIdProvincia;

    public GrlMunicipio() {
    }

    public GrlMunicipio(Integer pkIdMunicipio) {
        this.pkIdMunicipio = pkIdMunicipio;
    }

    public GrlMunicipio(Integer pkIdMunicipio, String nomeMunicipio) {
        this.pkIdMunicipio = pkIdMunicipio;
        this.nomeMunicipio = nomeMunicipio;
    }

    public Integer getPkIdMunicipio() {
        return pkIdMunicipio;
    }

    public void setPkIdMunicipio(Integer pkIdMunicipio) {
        this.pkIdMunicipio = pkIdMunicipio;
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    @XmlTransient
    public List<GrlEndereco> getGrlEnderecoList() {
        return grlEnderecoList;
    }

    public void setGrlEnderecoList(List<GrlEndereco> grlEnderecoList) {
        this.grlEnderecoList = grlEnderecoList;
    }

    @XmlTransient
    public List<DiagCandidatoDador> getDiagCandidatoDadorList() {
        return diagCandidatoDadorList;
    }

    public void setDiagCandidatoDadorList(List<DiagCandidatoDador> diagCandidatoDadorList) {
        this.diagCandidatoDadorList = diagCandidatoDadorList;
    }

    public GrlProvincia getFkIdProvincia() {
        return fkIdProvincia;
    }

    public void setFkIdProvincia(GrlProvincia fkIdProvincia) {
        this.fkIdProvincia = fkIdProvincia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdMunicipio != null ? pkIdMunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrlMunicipio)) {
            return false;
        }
        GrlMunicipio other = (GrlMunicipio) object;
        if ((this.pkIdMunicipio == null && other.pkIdMunicipio != null) || (this.pkIdMunicipio != null && !this.pkIdMunicipio.equals(other.pkIdMunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.GrlMunicipio[ pkIdMunicipio=" + pkIdMunicipio + " ]";
    }
    
}
