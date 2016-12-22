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
@Table(name = "inter_antropometria", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterAntropometria.findAll", query = "SELECT i FROM InterAntropometria i"),
    @NamedQuery(name = "InterAntropometria.findByPkIdAtropomentria", query = "SELECT i FROM InterAntropometria i WHERE i.pkIdAtropomentria = :pkIdAtropomentria"),
    @NamedQuery(name = "InterAntropometria.findByData", query = "SELECT i FROM InterAntropometria i WHERE i.data = :data"),
    @NamedQuery(name = "InterAntropometria.findByAlturaCm", query = "SELECT i FROM InterAntropometria i WHERE i.alturaCm = :alturaCm"),
    @NamedQuery(name = "InterAntropometria.findByPesoKg", query = "SELECT i FROM InterAntropometria i WHERE i.pesoKg = :pesoKg"),
    @NamedQuery(name = "InterAntropometria.findByPA", query = "SELECT i FROM InterAntropometria i WHERE i.pA = :pA"),
    @NamedQuery(name = "InterAntropometria.findByPbMm", query = "SELECT i FROM InterAntropometria i WHERE i.pbMm = :pbMm"),
    @NamedQuery(name = "InterAntropometria.findByEdemas", query = "SELECT i FROM InterAntropometria i WHERE i.edemas = :edemas"),
    @NamedQuery(name = "InterAntropometria.findByPesoAlvo", query = "SELECT i FROM InterAntropometria i WHERE i.pesoAlvo = :pesoAlvo")})
public class InterAntropometria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_atropomentria")
    private Integer pkIdAtropomentria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Column(name = "altura_cm")
    private float alturaCm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso_kg")
    private float pesoKg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "p_a")
    private float pA;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pb_mm")
    private float pbMm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "edemas")
    private String edemas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso_alvo")
    private float pesoAlvo;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne
    private RhFuncionario fkIdFuncionario;
    @JoinColumn(name = "fk_id_registo_internamento", referencedColumnName = "pk_id_registo_internamento")
    @ManyToOne(optional = false)
    private InterRegistoInternamento fkIdRegistoInternamento;

    public InterAntropometria() {
    }

    public InterAntropometria(Integer pkIdAtropomentria) {
        this.pkIdAtropomentria = pkIdAtropomentria;
    }

    public InterAntropometria(Integer pkIdAtropomentria, Date data, float alturaCm, float pesoKg, float pA, float pbMm, String edemas, float pesoAlvo) {
        this.pkIdAtropomentria = pkIdAtropomentria;
        this.data = data;
        this.alturaCm = alturaCm;
        this.pesoKg = pesoKg;
        this.pA = pA;
        this.pbMm = pbMm;
        this.edemas = edemas;
        this.pesoAlvo = pesoAlvo;
    }

    public Integer getPkIdAtropomentria() {
        return pkIdAtropomentria;
    }

    public void setPkIdAtropomentria(Integer pkIdAtropomentria) {
        this.pkIdAtropomentria = pkIdAtropomentria;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getAlturaCm() {
        return alturaCm;
    }

    public void setAlturaCm(float alturaCm) {
        this.alturaCm = alturaCm;
    }

    public float getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(float pesoKg) {
        this.pesoKg = pesoKg;
    }

    public float getPA() {
        return pA;
    }

    public void setPA(float pA) {
        this.pA = pA;
    }

    public float getPbMm() {
        return pbMm;
    }

    public void setPbMm(float pbMm) {
        this.pbMm = pbMm;
    }

    public String getEdemas() {
        return edemas;
    }

    public void setEdemas(String edemas) {
        this.edemas = edemas;
    }

    public float getPesoAlvo() {
        return pesoAlvo;
    }

    public void setPesoAlvo(float pesoAlvo) {
        this.pesoAlvo = pesoAlvo;
    }

    public RhFuncionario getFkIdFuncionario() {
        return fkIdFuncionario;
    }

    public void setFkIdFuncionario(RhFuncionario fkIdFuncionario) {
        this.fkIdFuncionario = fkIdFuncionario;
    }

    public InterRegistoInternamento getFkIdRegistoInternamento() {
        return fkIdRegistoInternamento;
    }

    public void setFkIdRegistoInternamento(InterRegistoInternamento fkIdRegistoInternamento) {
        this.fkIdRegistoInternamento = fkIdRegistoInternamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdAtropomentria != null ? pkIdAtropomentria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterAntropometria)) {
            return false;
        }
        InterAntropometria other = (InterAntropometria) object;
        if ((this.pkIdAtropomentria == null && other.pkIdAtropomentria != null) || (this.pkIdAtropomentria != null && !this.pkIdAtropomentria.equals(other.pkIdAtropomentria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.InterAntropometria[ pkIdAtropomentria=" + pkIdAtropomentria + " ]";
    }
    
}
