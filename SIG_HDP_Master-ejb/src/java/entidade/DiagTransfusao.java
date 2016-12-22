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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "diag_transfusao", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagTransfusao.findAll", query = "SELECT d FROM DiagTransfusao d"),
    @NamedQuery(name = "DiagTransfusao.findByPkIdTransfusao", query = "SELECT d FROM DiagTransfusao d WHERE d.pkIdTransfusao = :pkIdTransfusao"),
    @NamedQuery(name = "DiagTransfusao.findByProvaSoroFisiologico", query = "SELECT d FROM DiagTransfusao d WHERE d.provaSoroFisiologico = :provaSoroFisiologico"),
    @NamedQuery(name = "DiagTransfusao.findByTesteCoombs", query = "SELECT d FROM DiagTransfusao d WHERE d.testeCoombs = :testeCoombs"),
    @NamedQuery(name = "DiagTransfusao.findByQuantidade", query = "SELECT d FROM DiagTransfusao d WHERE d.quantidade = :quantidade"),
    @NamedQuery(name = "DiagTransfusao.findByDataTransfusao", query = "SELECT d FROM DiagTransfusao d WHERE d.dataTransfusao = :dataTransfusao")})
public class DiagTransfusao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_transfusao")
    private Integer pkIdTransfusao;
    @Size(max = 45)
    @Column(name = "prova_soro_fisiologico")
    private String provaSoroFisiologico;
    @Size(max = 45)
    @Column(name = "teste_coombs")
    private String testeCoombs;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Column(name = "data_transfusao")
    @Temporal(TemporalType.DATE)
    private Date dataTransfusao;
    @JoinColumn(name = "fk_verificado_por", referencedColumnName = "pk_id_funcionario")
    @ManyToOne
    private RhFuncionario fkVerificadoPor;
    @JoinColumn(name = "fk_realizado_por", referencedColumnName = "pk_id_funcionario")
    @ManyToOne
    private RhFuncionario fkRealizadoPor;
    @JoinColumn(name = "fk_area_destino", referencedColumnName = "pk_id_area_interna")
    @ManyToOne
    private GrlAreaInterna fkAreaDestino;
    @JoinColumn(name = "fk_id_tipagem_doente", referencedColumnName = "pk_id_tipagem_doente")
    @ManyToOne
    private DiagTipagemDoente fkIdTipagemDoente;
    @JoinColumn(name = "fk_id_tipagem_dador", referencedColumnName = "pk_id_tipagem_dador")
    @ManyToOne
    private DiagTipagemDador fkIdTipagemDador;

    public DiagTransfusao() {
    }

    public DiagTransfusao(Integer pkIdTransfusao) {
        this.pkIdTransfusao = pkIdTransfusao;
    }

    public Integer getPkIdTransfusao() {
        return pkIdTransfusao;
    }

    public void setPkIdTransfusao(Integer pkIdTransfusao) {
        this.pkIdTransfusao = pkIdTransfusao;
    }

    public String getProvaSoroFisiologico() {
        return provaSoroFisiologico;
    }

    public void setProvaSoroFisiologico(String provaSoroFisiologico) {
        this.provaSoroFisiologico = provaSoroFisiologico;
    }

    public String getTesteCoombs() {
        return testeCoombs;
    }

    public void setTesteCoombs(String testeCoombs) {
        this.testeCoombs = testeCoombs;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataTransfusao() {
        return dataTransfusao;
    }

    public void setDataTransfusao(Date dataTransfusao) {
        this.dataTransfusao = dataTransfusao;
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

    public GrlAreaInterna getFkAreaDestino() {
        return fkAreaDestino;
    }

    public void setFkAreaDestino(GrlAreaInterna fkAreaDestino) {
        this.fkAreaDestino = fkAreaDestino;
    }

    public DiagTipagemDoente getFkIdTipagemDoente() {
        return fkIdTipagemDoente;
    }

    public void setFkIdTipagemDoente(DiagTipagemDoente fkIdTipagemDoente) {
        this.fkIdTipagemDoente = fkIdTipagemDoente;
    }

    public DiagTipagemDador getFkIdTipagemDador() {
        return fkIdTipagemDador;
    }

    public void setFkIdTipagemDador(DiagTipagemDador fkIdTipagemDador) {
        this.fkIdTipagemDador = fkIdTipagemDador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdTransfusao != null ? pkIdTransfusao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagTransfusao)) {
            return false;
        }
        DiagTransfusao other = (DiagTransfusao) object;
        if ((this.pkIdTransfusao == null && other.pkIdTransfusao != null) || (this.pkIdTransfusao != null && !this.pkIdTransfusao.equals(other.pkIdTransfusao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.DiagTransfusao[ pkIdTransfusao=" + pkIdTransfusao + " ]";
    }
    
}
