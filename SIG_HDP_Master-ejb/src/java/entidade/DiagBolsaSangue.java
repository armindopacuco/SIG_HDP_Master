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
@Table(name = "diag_bolsa_sangue", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagBolsaSangue.findAll", query = "SELECT d FROM DiagBolsaSangue d"),
    @NamedQuery(name = "DiagBolsaSangue.findByPkIdBolsaSangue", query = "SELECT d FROM DiagBolsaSangue d WHERE d.pkIdBolsaSangue = :pkIdBolsaSangue"),
    @NamedQuery(name = "DiagBolsaSangue.findByQuantidadeColhida", query = "SELECT d FROM DiagBolsaSangue d WHERE d.quantidadeColhida = :quantidadeColhida"),
    @NamedQuery(name = "DiagBolsaSangue.findByNumeroColheita", query = "SELECT d FROM DiagBolsaSangue d WHERE d.numeroColheita = :numeroColheita"),
    @NamedQuery(name = "DiagBolsaSangue.findByDataValida", query = "SELECT d FROM DiagBolsaSangue d WHERE d.dataValida = :dataValida"),
    @NamedQuery(name = "DiagBolsaSangue.findByDataExpiracao", query = "SELECT d FROM DiagBolsaSangue d WHERE d.dataExpiracao = :dataExpiracao")})
public class DiagBolsaSangue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_bolsa_sangue")
    private Integer pkIdBolsaSangue;
    @Size(max = 45)
    @Column(name = "quantidade_colhida")
    private String quantidadeColhida;
    @Size(max = 45)
    @Column(name = "numero_colheita")
    private String numeroColheita;
    @Column(name = "data_valida")
    @Temporal(TemporalType.DATE)
    private Date dataValida;
    @Column(name = "data_expiracao")
    @Temporal(TemporalType.DATE)
    private Date dataExpiracao;
    @JoinColumn(name = "fk_id_dador", referencedColumnName = "pk_id_dador")
    @ManyToOne(optional = false)
    private DiagDador fkIdDador;

    public DiagBolsaSangue() {
    }

    public DiagBolsaSangue(Integer pkIdBolsaSangue) {
        this.pkIdBolsaSangue = pkIdBolsaSangue;
    }

    public Integer getPkIdBolsaSangue() {
        return pkIdBolsaSangue;
    }

    public void setPkIdBolsaSangue(Integer pkIdBolsaSangue) {
        this.pkIdBolsaSangue = pkIdBolsaSangue;
    }

    public String getQuantidadeColhida() {
        return quantidadeColhida;
    }

    public void setQuantidadeColhida(String quantidadeColhida) {
        this.quantidadeColhida = quantidadeColhida;
    }

    public String getNumeroColheita() {
        return numeroColheita;
    }

    public void setNumeroColheita(String numeroColheita) {
        this.numeroColheita = numeroColheita;
    }

    public Date getDataValida() {
        return dataValida;
    }

    public void setDataValida(Date dataValida) {
        this.dataValida = dataValida;
    }

    public Date getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(Date dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public DiagDador getFkIdDador() {
        return fkIdDador;
    }

    public void setFkIdDador(DiagDador fkIdDador) {
        this.fkIdDador = fkIdDador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdBolsaSangue != null ? pkIdBolsaSangue.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagBolsaSangue)) {
            return false;
        }
        DiagBolsaSangue other = (DiagBolsaSangue) object;
        if ((this.pkIdBolsaSangue == null && other.pkIdBolsaSangue != null) || (this.pkIdBolsaSangue != null && !this.pkIdBolsaSangue.equals(other.pkIdBolsaSangue))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.DiagBolsaSangue[ pkIdBolsaSangue=" + pkIdBolsaSangue + " ]";
    }
    
}
