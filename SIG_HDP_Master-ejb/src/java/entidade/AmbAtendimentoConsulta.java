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
@Table(name = "amb_atendimento_consulta", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbAtendimentoConsulta.findAll", query = "SELECT a FROM AmbAtendimentoConsulta a"),
    @NamedQuery(name = "AmbAtendimentoConsulta.findByPkIdAtendimentoConsulta", query = "SELECT a FROM AmbAtendimentoConsulta a WHERE a.pkIdAtendimentoConsulta = :pkIdAtendimentoConsulta"),
    @NamedQuery(name = "AmbAtendimentoConsulta.findByFkPkIdAdmsSolicitacaoServico", query = "SELECT a FROM AmbAtendimentoConsulta a WHERE a.fkPkIdAdmsSolicitacaoServico = :fkPkIdAdmsSolicitacaoServico")})
public class AmbAtendimentoConsulta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_atendimento_consulta")
    private Integer pkIdAtendimentoConsulta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_pk_id_adms__solicitacao_servico")
    private int fkPkIdAdmsSolicitacaoServico;

    public AmbAtendimentoConsulta() {
    }

    public AmbAtendimentoConsulta(Integer pkIdAtendimentoConsulta) {
        this.pkIdAtendimentoConsulta = pkIdAtendimentoConsulta;
    }

    public AmbAtendimentoConsulta(Integer pkIdAtendimentoConsulta, int fkPkIdAdmsSolicitacaoServico) {
        this.pkIdAtendimentoConsulta = pkIdAtendimentoConsulta;
        this.fkPkIdAdmsSolicitacaoServico = fkPkIdAdmsSolicitacaoServico;
    }

    public Integer getPkIdAtendimentoConsulta() {
        return pkIdAtendimentoConsulta;
    }

    public void setPkIdAtendimentoConsulta(Integer pkIdAtendimentoConsulta) {
        this.pkIdAtendimentoConsulta = pkIdAtendimentoConsulta;
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
        hash += (pkIdAtendimentoConsulta != null ? pkIdAtendimentoConsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbAtendimentoConsulta)) {
            return false;
        }
        AmbAtendimentoConsulta other = (AmbAtendimentoConsulta) object;
        if ((this.pkIdAtendimentoConsulta == null && other.pkIdAtendimentoConsulta != null) || (this.pkIdAtendimentoConsulta != null && !this.pkIdAtendimentoConsulta.equals(other.pkIdAtendimentoConsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbAtendimentoConsulta[ pkIdAtendimentoConsulta=" + pkIdAtendimentoConsulta + " ]";
    }
    
}
