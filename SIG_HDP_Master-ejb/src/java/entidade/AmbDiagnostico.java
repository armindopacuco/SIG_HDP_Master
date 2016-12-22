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
@Table(name = "amb_diagnostico", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbDiagnostico.findAll", query = "SELECT a FROM AmbDiagnostico a"),
    @NamedQuery(name = "AmbDiagnostico.findByPkIdDiagnostico", query = "SELECT a FROM AmbDiagnostico a WHERE a.pkIdDiagnostico = :pkIdDiagnostico"),
    @NamedQuery(name = "AmbDiagnostico.findByObservacoes", query = "SELECT a FROM AmbDiagnostico a WHERE a.observacoes = :observacoes"),
    @NamedQuery(name = "AmbDiagnostico.findByDescricaoDiagnostico", query = "SELECT a FROM AmbDiagnostico a WHERE a.descricaoDiagnostico = :descricaoDiagnostico"),
    @NamedQuery(name = "AmbDiagnostico.findByDataHoraDiagnostico", query = "SELECT a FROM AmbDiagnostico a WHERE a.dataHoraDiagnostico = :dataHoraDiagnostico")})
public class AmbDiagnostico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_diagnostico")
    private Integer pkIdDiagnostico;
    @Size(max = 500)
    @Column(name = "observacoes")
    private String observacoes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descricao_diagnostico")
    private String descricaoDiagnostico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_hora_diagnostico")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraDiagnostico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPkIdDiagnostico")
    private List<AmbDiagnosticoAsDoenca> ambDiagnosticoAsDoencaList;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne(optional = false)
    private RhFuncionario fkIdFuncionario;
    @JoinColumn(name = "fk_id_consulta", referencedColumnName = "pk_id_consulta")
    @ManyToOne(optional = false)
    private AmbConsulta fkIdConsulta;

    public AmbDiagnostico() {
    }

    public AmbDiagnostico(Integer pkIdDiagnostico) {
        this.pkIdDiagnostico = pkIdDiagnostico;
    }

    public AmbDiagnostico(Integer pkIdDiagnostico, String descricaoDiagnostico, Date dataHoraDiagnostico) {
        this.pkIdDiagnostico = pkIdDiagnostico;
        this.descricaoDiagnostico = descricaoDiagnostico;
        this.dataHoraDiagnostico = dataHoraDiagnostico;
    }

    public Integer getPkIdDiagnostico() {
        return pkIdDiagnostico;
    }

    public void setPkIdDiagnostico(Integer pkIdDiagnostico) {
        this.pkIdDiagnostico = pkIdDiagnostico;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getDescricaoDiagnostico() {
        return descricaoDiagnostico;
    }

    public void setDescricaoDiagnostico(String descricaoDiagnostico) {
        this.descricaoDiagnostico = descricaoDiagnostico;
    }

    public Date getDataHoraDiagnostico() {
        return dataHoraDiagnostico;
    }

    public void setDataHoraDiagnostico(Date dataHoraDiagnostico) {
        this.dataHoraDiagnostico = dataHoraDiagnostico;
    }

    @XmlTransient
    public List<AmbDiagnosticoAsDoenca> getAmbDiagnosticoAsDoencaList() {
        return ambDiagnosticoAsDoencaList;
    }

    public void setAmbDiagnosticoAsDoencaList(List<AmbDiagnosticoAsDoenca> ambDiagnosticoAsDoencaList) {
        this.ambDiagnosticoAsDoencaList = ambDiagnosticoAsDoencaList;
    }

    public RhFuncionario getFkIdFuncionario() {
        return fkIdFuncionario;
    }

    public void setFkIdFuncionario(RhFuncionario fkIdFuncionario) {
        this.fkIdFuncionario = fkIdFuncionario;
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
        hash += (pkIdDiagnostico != null ? pkIdDiagnostico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbDiagnostico)) {
            return false;
        }
        AmbDiagnostico other = (AmbDiagnostico) object;
        if ((this.pkIdDiagnostico == null && other.pkIdDiagnostico != null) || (this.pkIdDiagnostico != null && !this.pkIdDiagnostico.equals(other.pkIdDiagnostico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbDiagnostico[ pkIdDiagnostico=" + pkIdDiagnostico + " ]";
    }
    
}
