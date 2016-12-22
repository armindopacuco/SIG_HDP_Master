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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "diag_colecta", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagColecta.findAll", query = "SELECT d FROM DiagColecta d"),
    @NamedQuery(name = "DiagColecta.findByPkIdColecta", query = "SELECT d FROM DiagColecta d WHERE d.pkIdColecta = :pkIdColecta"),
    @NamedQuery(name = "DiagColecta.findByDataColecta", query = "SELECT d FROM DiagColecta d WHERE d.dataColecta = :dataColecta"),
    @NamedQuery(name = "DiagColecta.findByFkIdItemExameSolicitacao", query = "SELECT d FROM DiagColecta d WHERE d.fkIdItemExameSolicitacao = :fkIdItemExameSolicitacao")})
public class DiagColecta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_colecta")
    private Integer pkIdColecta;
    @Column(name = "data_colecta")
    @Temporal(TemporalType.DATE)
    private Date dataColecta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_id_item_exame_solicitacao")
    private int fkIdItemExameSolicitacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdColecta")
    private List<DiagAmostra> diagAmostraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdColecta")
    private List<DiagImagem> diagImagemList;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne
    private RhFuncionario fkIdFuncionario;
    @JoinColumn(name = "fk_id_centro", referencedColumnName = "pk_id_centro")
    @ManyToOne
    private GrlCentroHospitalar fkIdCentro;

    public DiagColecta() {
    }

    public DiagColecta(Integer pkIdColecta) {
        this.pkIdColecta = pkIdColecta;
    }

    public DiagColecta(Integer pkIdColecta, int fkIdItemExameSolicitacao) {
        this.pkIdColecta = pkIdColecta;
        this.fkIdItemExameSolicitacao = fkIdItemExameSolicitacao;
    }

    public Integer getPkIdColecta() {
        return pkIdColecta;
    }

    public void setPkIdColecta(Integer pkIdColecta) {
        this.pkIdColecta = pkIdColecta;
    }

    public Date getDataColecta() {
        return dataColecta;
    }

    public void setDataColecta(Date dataColecta) {
        this.dataColecta = dataColecta;
    }

    public int getFkIdItemExameSolicitacao() {
        return fkIdItemExameSolicitacao;
    }

    public void setFkIdItemExameSolicitacao(int fkIdItemExameSolicitacao) {
        this.fkIdItemExameSolicitacao = fkIdItemExameSolicitacao;
    }

    @XmlTransient
    public List<DiagAmostra> getDiagAmostraList() {
        return diagAmostraList;
    }

    public void setDiagAmostraList(List<DiagAmostra> diagAmostraList) {
        this.diagAmostraList = diagAmostraList;
    }

    @XmlTransient
    public List<DiagImagem> getDiagImagemList() {
        return diagImagemList;
    }

    public void setDiagImagemList(List<DiagImagem> diagImagemList) {
        this.diagImagemList = diagImagemList;
    }

    public RhFuncionario getFkIdFuncionario() {
        return fkIdFuncionario;
    }

    public void setFkIdFuncionario(RhFuncionario fkIdFuncionario) {
        this.fkIdFuncionario = fkIdFuncionario;
    }

    public GrlCentroHospitalar getFkIdCentro() {
        return fkIdCentro;
    }

    public void setFkIdCentro(GrlCentroHospitalar fkIdCentro) {
        this.fkIdCentro = fkIdCentro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdColecta != null ? pkIdColecta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagColecta)) {
            return false;
        }
        DiagColecta other = (DiagColecta) object;
        if ((this.pkIdColecta == null && other.pkIdColecta != null) || (this.pkIdColecta != null && !this.pkIdColecta.equals(other.pkIdColecta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.DiagColecta[ pkIdColecta=" + pkIdColecta + " ]";
    }
    
}
