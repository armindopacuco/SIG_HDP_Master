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
@Table(name = "amb_diagnostico_hipotese", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbDiagnosticoHipotese.findAll", query = "SELECT a FROM AmbDiagnosticoHipotese a"),
    @NamedQuery(name = "AmbDiagnosticoHipotese.findByPkIdDiagnosticoHipotese", query = "SELECT a FROM AmbDiagnosticoHipotese a WHERE a.pkIdDiagnosticoHipotese = :pkIdDiagnosticoHipotese"),
    @NamedQuery(name = "AmbDiagnosticoHipotese.findByDescricaoDiagnosticoHipotese", query = "SELECT a FROM AmbDiagnosticoHipotese a WHERE a.descricaoDiagnosticoHipotese = :descricaoDiagnosticoHipotese")})
public class AmbDiagnosticoHipotese implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_diagnostico_hipotese")
    private Integer pkIdDiagnosticoHipotese;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descricao_diagnostico_hipotese")
    private String descricaoDiagnosticoHipotese;
    @JoinColumn(name = "fk_id_consulta", referencedColumnName = "pk_id_consulta")
    @ManyToOne(optional = false)
    private AmbConsulta fkIdConsulta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPkIdDiagnosticoHipotese")
    private List<AmbDiagnosticoHipoteseAsDoenca> ambDiagnosticoHipoteseAsDoencaList;

    public AmbDiagnosticoHipotese() {
    }

    public AmbDiagnosticoHipotese(Integer pkIdDiagnosticoHipotese) {
        this.pkIdDiagnosticoHipotese = pkIdDiagnosticoHipotese;
    }

    public AmbDiagnosticoHipotese(Integer pkIdDiagnosticoHipotese, String descricaoDiagnosticoHipotese) {
        this.pkIdDiagnosticoHipotese = pkIdDiagnosticoHipotese;
        this.descricaoDiagnosticoHipotese = descricaoDiagnosticoHipotese;
    }

    public Integer getPkIdDiagnosticoHipotese() {
        return pkIdDiagnosticoHipotese;
    }

    public void setPkIdDiagnosticoHipotese(Integer pkIdDiagnosticoHipotese) {
        this.pkIdDiagnosticoHipotese = pkIdDiagnosticoHipotese;
    }

    public String getDescricaoDiagnosticoHipotese() {
        return descricaoDiagnosticoHipotese;
    }

    public void setDescricaoDiagnosticoHipotese(String descricaoDiagnosticoHipotese) {
        this.descricaoDiagnosticoHipotese = descricaoDiagnosticoHipotese;
    }

    public AmbConsulta getFkIdConsulta() {
        return fkIdConsulta;
    }

    public void setFkIdConsulta(AmbConsulta fkIdConsulta) {
        this.fkIdConsulta = fkIdConsulta;
    }

    @XmlTransient
    public List<AmbDiagnosticoHipoteseAsDoenca> getAmbDiagnosticoHipoteseAsDoencaList() {
        return ambDiagnosticoHipoteseAsDoencaList;
    }

    public void setAmbDiagnosticoHipoteseAsDoencaList(List<AmbDiagnosticoHipoteseAsDoenca> ambDiagnosticoHipoteseAsDoencaList) {
        this.ambDiagnosticoHipoteseAsDoencaList = ambDiagnosticoHipoteseAsDoencaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdDiagnosticoHipotese != null ? pkIdDiagnosticoHipotese.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbDiagnosticoHipotese)) {
            return false;
        }
        AmbDiagnosticoHipotese other = (AmbDiagnosticoHipotese) object;
        if ((this.pkIdDiagnosticoHipotese == null && other.pkIdDiagnosticoHipotese != null) || (this.pkIdDiagnosticoHipotese != null && !this.pkIdDiagnosticoHipotese.equals(other.pkIdDiagnosticoHipotese))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbDiagnosticoHipotese[ pkIdDiagnosticoHipotese=" + pkIdDiagnosticoHipotese + " ]";
    }
    
}
