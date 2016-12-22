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
@Table(name = "amb_consulta_paga", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbConsultaPaga.findAll", query = "SELECT a FROM AmbConsultaPaga a"),
    @NamedQuery(name = "AmbConsultaPaga.findByPkIdConsultaPaga", query = "SELECT a FROM AmbConsultaPaga a WHERE a.pkIdConsultaPaga = :pkIdConsultaPaga"),
    @NamedQuery(name = "AmbConsultaPaga.findByFkPkIdAdmsSolicitacaoServico", query = "SELECT a FROM AmbConsultaPaga a WHERE a.fkPkIdAdmsSolicitacaoServico = :fkPkIdAdmsSolicitacaoServico")})
public class AmbConsultaPaga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_consulta_paga")
    private Integer pkIdConsultaPaga;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_pk_id_adms_solicitacao_servico")
    private int fkPkIdAdmsSolicitacaoServico;

    public AmbConsultaPaga() {
    }

    public AmbConsultaPaga(Integer pkIdConsultaPaga) {
        this.pkIdConsultaPaga = pkIdConsultaPaga;
    }

    public AmbConsultaPaga(Integer pkIdConsultaPaga, int fkPkIdAdmsSolicitacaoServico) {
        this.pkIdConsultaPaga = pkIdConsultaPaga;
        this.fkPkIdAdmsSolicitacaoServico = fkPkIdAdmsSolicitacaoServico;
    }

    public Integer getPkIdConsultaPaga() {
        return pkIdConsultaPaga;
    }

    public void setPkIdConsultaPaga(Integer pkIdConsultaPaga) {
        this.pkIdConsultaPaga = pkIdConsultaPaga;
    }

    public int getFkPkIdAdmsSolicitacaoServico() {
        return fkPkIdAdmsSolicitacaoServico;
    }

    public void setFkPkIdAdmsSolicitacaoServico(int fkPkIdAdmsSolicitacaoServico) {
        this.fkPkIdAdmsSolicitacaoServico = fkPkIdAdmsSolicitacaoServico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdConsultaPaga != null ? pkIdConsultaPaga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbConsultaPaga)) {
            return false;
        }
        AmbConsultaPaga other = (AmbConsultaPaga) object;
        if ((this.pkIdConsultaPaga == null && other.pkIdConsultaPaga != null) || (this.pkIdConsultaPaga != null && !this.pkIdConsultaPaga.equals(other.pkIdConsultaPaga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbConsultaPaga[ pkIdConsultaPaga=" + pkIdConsultaPaga + " ]";
    }
    
}
