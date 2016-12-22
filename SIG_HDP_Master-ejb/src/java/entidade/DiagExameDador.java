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
@Table(name = "diag_exame_dador", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagExameDador.findAll", query = "SELECT d FROM DiagExameDador d"),
    @NamedQuery(name = "DiagExameDador.findByPkIdExameDador", query = "SELECT d FROM DiagExameDador d WHERE d.pkIdExameDador = :pkIdExameDador"),
    @NamedQuery(name = "DiagExameDador.findByTa", query = "SELECT d FROM DiagExameDador d WHERE d.ta = :ta"),
    @NamedQuery(name = "DiagExameDador.findByHb", query = "SELECT d FROM DiagExameDador d WHERE d.hb = :hb"),
    @NamedQuery(name = "DiagExameDador.findByMal", query = "SELECT d FROM DiagExameDador d WHERE d.mal = :mal"),
    @NamedQuery(name = "DiagExameDador.findByVdrl", query = "SELECT d FROM DiagExameDador d WHERE d.vdrl = :vdrl"),
    @NamedQuery(name = "DiagExameDador.findByHiv", query = "SELECT d FROM DiagExameDador d WHERE d.hiv = :hiv"),
    @NamedQuery(name = "DiagExameDador.findByAghbs", query = "SELECT d FROM DiagExameDador d WHERE d.aghbs = :aghbs"),
    @NamedQuery(name = "DiagExameDador.findByHcv", query = "SELECT d FROM DiagExameDador d WHERE d.hcv = :hcv"),
    @NamedQuery(name = "DiagExameDador.findByConclusao", query = "SELECT d FROM DiagExameDador d WHERE d.conclusao = :conclusao")})
public class DiagExameDador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_exame_dador")
    private Integer pkIdExameDador;
    @Size(max = 45)
    @Column(name = "ta")
    private String ta;
    @Size(max = 45)
    @Column(name = "hb")
    private String hb;
    @Size(max = 45)
    @Column(name = "mal")
    private String mal;
    @Size(max = 45)
    @Column(name = "vdrl")
    private String vdrl;
    @Size(max = 45)
    @Column(name = "hiv")
    private String hiv;
    @Size(max = 45)
    @Column(name = "aghbs")
    private String aghbs;
    @Size(max = 45)
    @Column(name = "hcv")
    private String hcv;
    @Size(max = 45)
    @Column(name = "conclusao")
    private String conclusao;
    @JoinColumn(name = "fk_id_tecnico", referencedColumnName = "pk_id_funcionario")
    @ManyToOne
    private RhFuncionario fkIdTecnico;
    @JoinColumn(name = "fk_id_triagem", referencedColumnName = "pk_id_triagem")
    @ManyToOne(optional = false)
    private DiagTriagem fkIdTriagem;
    @JoinColumn(name = "fk_id_estado_clinico", referencedColumnName = "pk_id_estado_clinico")
    @ManyToOne(optional = false)
    private DiagEstadoClinico fkIdEstadoClinico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdExameCandidatoDador")
    private List<DiagDador> diagDadorList;

    public DiagExameDador() {
    }

    public DiagExameDador(Integer pkIdExameDador) {
        this.pkIdExameDador = pkIdExameDador;
    }

    public Integer getPkIdExameDador() {
        return pkIdExameDador;
    }

    public void setPkIdExameDador(Integer pkIdExameDador) {
        this.pkIdExameDador = pkIdExameDador;
    }

    public String getTa() {
        return ta;
    }

    public void setTa(String ta) {
        this.ta = ta;
    }

    public String getHb() {
        return hb;
    }

    public void setHb(String hb) {
        this.hb = hb;
    }

    public String getMal() {
        return mal;
    }

    public void setMal(String mal) {
        this.mal = mal;
    }

    public String getVdrl() {
        return vdrl;
    }

    public void setVdrl(String vdrl) {
        this.vdrl = vdrl;
    }

    public String getHiv() {
        return hiv;
    }

    public void setHiv(String hiv) {
        this.hiv = hiv;
    }

    public String getAghbs() {
        return aghbs;
    }

    public void setAghbs(String aghbs) {
        this.aghbs = aghbs;
    }

    public String getHcv() {
        return hcv;
    }

    public void setHcv(String hcv) {
        this.hcv = hcv;
    }

    public String getConclusao() {
        return conclusao;
    }

    public void setConclusao(String conclusao) {
        this.conclusao = conclusao;
    }

    public RhFuncionario getFkIdTecnico() {
        return fkIdTecnico;
    }

    public void setFkIdTecnico(RhFuncionario fkIdTecnico) {
        this.fkIdTecnico = fkIdTecnico;
    }

    public DiagTriagem getFkIdTriagem() {
        return fkIdTriagem;
    }

    public void setFkIdTriagem(DiagTriagem fkIdTriagem) {
        this.fkIdTriagem = fkIdTriagem;
    }

    public DiagEstadoClinico getFkIdEstadoClinico() {
        return fkIdEstadoClinico;
    }

    public void setFkIdEstadoClinico(DiagEstadoClinico fkIdEstadoClinico) {
        this.fkIdEstadoClinico = fkIdEstadoClinico;
    }

    @XmlTransient
    public List<DiagDador> getDiagDadorList() {
        return diagDadorList;
    }

    public void setDiagDadorList(List<DiagDador> diagDadorList) {
        this.diagDadorList = diagDadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdExameDador != null ? pkIdExameDador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagExameDador)) {
            return false;
        }
        DiagExameDador other = (DiagExameDador) object;
        if ((this.pkIdExameDador == null && other.pkIdExameDador != null) || (this.pkIdExameDador != null && !this.pkIdExameDador.equals(other.pkIdExameDador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.DiagExameDador[ pkIdExameDador=" + pkIdExameDador + " ]";
    }
    
}
