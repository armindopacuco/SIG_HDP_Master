/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "adms_reagendamento", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdmsReagendamento.findAll", query = "SELECT a FROM AdmsReagendamento a"),
    @NamedQuery(name = "AdmsReagendamento.findByPkIdReagendamento", query = "SELECT a FROM AdmsReagendamento a WHERE a.pkIdReagendamento = :pkIdReagendamento"),
    @NamedQuery(name = "AdmsReagendamento.findByNumeroReagendamento", query = "SELECT a FROM AdmsReagendamento a WHERE a.numeroReagendamento = :numeroReagendamento")})
public class AdmsReagendamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_reagendamento")
    private Long pkIdReagendamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_reagendamento")
    private int numeroReagendamento;
    @JoinColumn(name = "fk_id_agendamento_anterior", referencedColumnName = "pk_id_agendamento")
    @ManyToOne(optional = false)
    private AdmsAgendamento fkIdAgendamentoAnterior;
    @JoinColumn(name = "fk_id_agendamento", referencedColumnName = "pk_id_agendamento")
    @ManyToOne(optional = false)
    private AdmsAgendamento fkIdAgendamento;

    public AdmsReagendamento() {
    }

    public AdmsReagendamento(Long pkIdReagendamento) {
        this.pkIdReagendamento = pkIdReagendamento;
    }

    public AdmsReagendamento(Long pkIdReagendamento, int numeroReagendamento) {
        this.pkIdReagendamento = pkIdReagendamento;
        this.numeroReagendamento = numeroReagendamento;
    }

    public Long getPkIdReagendamento() {
        return pkIdReagendamento;
    }

    public void setPkIdReagendamento(Long pkIdReagendamento) {
        this.pkIdReagendamento = pkIdReagendamento;
    }

    public int getNumeroReagendamento() {
        return numeroReagendamento;
    }

    public void setNumeroReagendamento(int numeroReagendamento) {
        this.numeroReagendamento = numeroReagendamento;
    }

    public AdmsAgendamento getFkIdAgendamentoAnterior() {
        return fkIdAgendamentoAnterior;
    }

    public void setFkIdAgendamentoAnterior(AdmsAgendamento fkIdAgendamentoAnterior) {
        this.fkIdAgendamentoAnterior = fkIdAgendamentoAnterior;
    }

    public AdmsAgendamento getFkIdAgendamento() {
        return fkIdAgendamento;
    }

    public void setFkIdAgendamento(AdmsAgendamento fkIdAgendamento) {
        this.fkIdAgendamento = fkIdAgendamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdReagendamento != null ? pkIdReagendamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmsReagendamento)) {
            return false;
        }
        AdmsReagendamento other = (AdmsReagendamento) object;
        if ((this.pkIdReagendamento == null && other.pkIdReagendamento != null) || (this.pkIdReagendamento != null && !this.pkIdReagendamento.equals(other.pkIdReagendamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AdmsReagendamento[ pkIdReagendamento=" + pkIdReagendamento + " ]";
    }
    
}
