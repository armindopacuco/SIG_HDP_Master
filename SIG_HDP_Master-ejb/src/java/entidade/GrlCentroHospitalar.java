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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "grl_centro_hospitalar", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrlCentroHospitalar.findAll", query = "SELECT g FROM GrlCentroHospitalar g"),
    @NamedQuery(name = "GrlCentroHospitalar.findByPkIdCentro", query = "SELECT g FROM GrlCentroHospitalar g WHERE g.pkIdCentro = :pkIdCentro"),
    @NamedQuery(name = "GrlCentroHospitalar.findByCodigoCentro", query = "SELECT g FROM GrlCentroHospitalar g WHERE g.codigoCentro = :codigoCentro")})
public class GrlCentroHospitalar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_centro")
    private Integer pkIdCentro;
    @Size(max = 5)
    @Column(name = "codigo_centro")
    private String codigoCentro;
    @OneToMany(mappedBy = "fkIdCentro")
    private List<AdmsSolicitacao> admsSolicitacaoList;
    @JoinColumn(name = "fk_id_instituicao", referencedColumnName = "pk_id_instituicao")
    @ManyToOne(optional = false)
    private GrlInstituicao fkIdInstituicao;
    @OneToMany(mappedBy = "fkIdCentro")
    private List<DiagColecta> diagColectaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdCentroHospitalar")
    private List<RhFuncionario> rhFuncionarioList;

    public GrlCentroHospitalar() {
    }

    public GrlCentroHospitalar(Integer pkIdCentro) {
        this.pkIdCentro = pkIdCentro;
    }

    public Integer getPkIdCentro() {
        return pkIdCentro;
    }

    public void setPkIdCentro(Integer pkIdCentro) {
        this.pkIdCentro = pkIdCentro;
    }

    public String getCodigoCentro() {
        return codigoCentro;
    }

    public void setCodigoCentro(String codigoCentro) {
        this.codigoCentro = codigoCentro;
    }

    @XmlTransient
    public List<AdmsSolicitacao> getAdmsSolicitacaoList() {
        return admsSolicitacaoList;
    }

    public void setAdmsSolicitacaoList(List<AdmsSolicitacao> admsSolicitacaoList) {
        this.admsSolicitacaoList = admsSolicitacaoList;
    }

    public GrlInstituicao getFkIdInstituicao() {
        return fkIdInstituicao;
    }

    public void setFkIdInstituicao(GrlInstituicao fkIdInstituicao) {
        this.fkIdInstituicao = fkIdInstituicao;
    }

    @XmlTransient
    public List<DiagColecta> getDiagColectaList() {
        return diagColectaList;
    }

    public void setDiagColectaList(List<DiagColecta> diagColectaList) {
        this.diagColectaList = diagColectaList;
    }

    @XmlTransient
    public List<RhFuncionario> getRhFuncionarioList() {
        return rhFuncionarioList;
    }

    public void setRhFuncionarioList(List<RhFuncionario> rhFuncionarioList) {
        this.rhFuncionarioList = rhFuncionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdCentro != null ? pkIdCentro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrlCentroHospitalar)) {
            return false;
        }
        GrlCentroHospitalar other = (GrlCentroHospitalar) object;
        if ((this.pkIdCentro == null && other.pkIdCentro != null) || (this.pkIdCentro != null && !this.pkIdCentro.equals(other.pkIdCentro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.GrlCentroHospitalar[ pkIdCentro=" + pkIdCentro + " ]";
    }
    
}
