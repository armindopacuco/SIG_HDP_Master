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
@Table(name = "diag_tipagem_dador", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagTipagemDador.findAll", query = "SELECT d FROM DiagTipagemDador d"),
    @NamedQuery(name = "DiagTipagemDador.findByPkIdTipagemDador", query = "SELECT d FROM DiagTipagemDador d WHERE d.pkIdTipagemDador = :pkIdTipagemDador"),
    @NamedQuery(name = "DiagTipagemDador.findByConclusao", query = "SELECT d FROM DiagTipagemDador d WHERE d.conclusao = :conclusao"),
    @NamedQuery(name = "DiagTipagemDador.findByAntiA", query = "SELECT d FROM DiagTipagemDador d WHERE d.antiA = :antiA"),
    @NamedQuery(name = "DiagTipagemDador.findByAntiB", query = "SELECT d FROM DiagTipagemDador d WHERE d.antiB = :antiB"),
    @NamedQuery(name = "DiagTipagemDador.findByAntiD", query = "SELECT d FROM DiagTipagemDador d WHERE d.antiD = :antiD"),
    @NamedQuery(name = "DiagTipagemDador.findByDu", query = "SELECT d FROM DiagTipagemDador d WHERE d.du = :du"),
    @NamedQuery(name = "DiagTipagemDador.findByA1", query = "SELECT d FROM DiagTipagemDador d WHERE d.a1 = :a1"),
    @NamedQuery(name = "DiagTipagemDador.findByB", query = "SELECT d FROM DiagTipagemDador d WHERE d.b = :b"),
    @NamedQuery(name = "DiagTipagemDador.findByO", query = "SELECT d FROM DiagTipagemDador d WHERE d.o = :o"),
    @NamedQuery(name = "DiagTipagemDador.findByDataTipagem", query = "SELECT d FROM DiagTipagemDador d WHERE d.dataTipagem = :dataTipagem"),
    @NamedQuery(name = "DiagTipagemDador.findByFkIdBolsaSangue", query = "SELECT d FROM DiagTipagemDador d WHERE d.fkIdBolsaSangue = :fkIdBolsaSangue")})
public class DiagTipagemDador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_tipagem_dador")
    private Integer pkIdTipagemDador;
    @Size(max = 45)
    @Column(name = "conclusao")
    private String conclusao;
    @Size(max = 45)
    @Column(name = "anti_a")
    private String antiA;
    @Size(max = 45)
    @Column(name = "anti_b")
    private String antiB;
    @Size(max = 45)
    @Column(name = "anti_d")
    private String antiD;
    @Size(max = 45)
    @Column(name = "du")
    private String du;
    @Size(max = 45)
    @Column(name = "a1")
    private String a1;
    @Size(max = 45)
    @Column(name = "b")
    private String b;
    @Size(max = 45)
    @Column(name = "o")
    private String o;
    @Column(name = "data_tipagem")
    @Temporal(TemporalType.DATE)
    private Date dataTipagem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_id_bolsa_sangue")
    private int fkIdBolsaSangue;
    @JoinColumn(name = "fk_verificado_por", referencedColumnName = "pk_id_funcionario")
    @ManyToOne
    private RhFuncionario fkVerificadoPor;
    @JoinColumn(name = "fk_realizado_por", referencedColumnName = "pk_id_funcionario")
    @ManyToOne
    private RhFuncionario fkRealizadoPor;
    @OneToMany(mappedBy = "fkIdTipagemDador")
    private List<DiagTransfusao> diagTransfusaoList;

    public DiagTipagemDador() {
    }

    public DiagTipagemDador(Integer pkIdTipagemDador) {
        this.pkIdTipagemDador = pkIdTipagemDador;
    }

    public DiagTipagemDador(Integer pkIdTipagemDador, int fkIdBolsaSangue) {
        this.pkIdTipagemDador = pkIdTipagemDador;
        this.fkIdBolsaSangue = fkIdBolsaSangue;
    }

    public Integer getPkIdTipagemDador() {
        return pkIdTipagemDador;
    }

    public void setPkIdTipagemDador(Integer pkIdTipagemDador) {
        this.pkIdTipagemDador = pkIdTipagemDador;
    }

    public String getConclusao() {
        return conclusao;
    }

    public void setConclusao(String conclusao) {
        this.conclusao = conclusao;
    }

    public String getAntiA() {
        return antiA;
    }

    public void setAntiA(String antiA) {
        this.antiA = antiA;
    }

    public String getAntiB() {
        return antiB;
    }

    public void setAntiB(String antiB) {
        this.antiB = antiB;
    }

    public String getAntiD() {
        return antiD;
    }

    public void setAntiD(String antiD) {
        this.antiD = antiD;
    }

    public String getDu() {
        return du;
    }

    public void setDu(String du) {
        this.du = du;
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getO() {
        return o;
    }

    public void setO(String o) {
        this.o = o;
    }

    public Date getDataTipagem() {
        return dataTipagem;
    }

    public void setDataTipagem(Date dataTipagem) {
        this.dataTipagem = dataTipagem;
    }

    public int getFkIdBolsaSangue() {
        return fkIdBolsaSangue;
    }

    public void setFkIdBolsaSangue(int fkIdBolsaSangue) {
        this.fkIdBolsaSangue = fkIdBolsaSangue;
    }

    public RhFuncionario getFkVerificadoPor() {
        return fkVerificadoPor;
    }

    public void setFkVerificadoPor(RhFuncionario fkVerificadoPor) {
        this.fkVerificadoPor = fkVerificadoPor;
    }

    public RhFuncionario getFkRealizadoPor() {
        return fkRealizadoPor;
    }

    public void setFkRealizadoPor(RhFuncionario fkRealizadoPor) {
        this.fkRealizadoPor = fkRealizadoPor;
    }

    @XmlTransient
    public List<DiagTransfusao> getDiagTransfusaoList() {
        return diagTransfusaoList;
    }

    public void setDiagTransfusaoList(List<DiagTransfusao> diagTransfusaoList) {
        this.diagTransfusaoList = diagTransfusaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdTipagemDador != null ? pkIdTipagemDador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagTipagemDador)) {
            return false;
        }
        DiagTipagemDador other = (DiagTipagemDador) object;
        if ((this.pkIdTipagemDador == null && other.pkIdTipagemDador != null) || (this.pkIdTipagemDador != null && !this.pkIdTipagemDador.equals(other.pkIdTipagemDador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.DiagTipagemDador[ pkIdTipagemDador=" + pkIdTipagemDador + " ]";
    }
    
}
