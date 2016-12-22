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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "inter_tipo_doenca_internamento", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterTipoDoencaInternamento.findAll", query = "SELECT i FROM InterTipoDoencaInternamento i"),
    @NamedQuery(name = "InterTipoDoencaInternamento.findByPkIdTipoDoencaInternamento", query = "SELECT i FROM InterTipoDoencaInternamento i WHERE i.pkIdTipoDoencaInternamento = :pkIdTipoDoencaInternamento"),
    @NamedQuery(name = "InterTipoDoencaInternamento.findByDescricao", query = "SELECT i FROM InterTipoDoencaInternamento i WHERE i.descricao = :descricao")})
public class InterTipoDoencaInternamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_tipo_doenca_internamento")
    private Integer pkIdTipoDoencaInternamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdTipoDoencaIntenamento")
    private List<InterDoencaInternamentoPaciente> interDoencaInternamentoPacienteList;

    public InterTipoDoencaInternamento() {
    }

    public InterTipoDoencaInternamento(Integer pkIdTipoDoencaInternamento) {
        this.pkIdTipoDoencaInternamento = pkIdTipoDoencaInternamento;
    }

    public InterTipoDoencaInternamento(Integer pkIdTipoDoencaInternamento, String descricao) {
        this.pkIdTipoDoencaInternamento = pkIdTipoDoencaInternamento;
        this.descricao = descricao;
    }

    public Integer getPkIdTipoDoencaInternamento() {
        return pkIdTipoDoencaInternamento;
    }

    public void setPkIdTipoDoencaInternamento(Integer pkIdTipoDoencaInternamento) {
        this.pkIdTipoDoencaInternamento = pkIdTipoDoencaInternamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<InterDoencaInternamentoPaciente> getInterDoencaInternamentoPacienteList() {
        return interDoencaInternamentoPacienteList;
    }

    public void setInterDoencaInternamentoPacienteList(List<InterDoencaInternamentoPaciente> interDoencaInternamentoPacienteList) {
        this.interDoencaInternamentoPacienteList = interDoencaInternamentoPacienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdTipoDoencaInternamento != null ? pkIdTipoDoencaInternamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterTipoDoencaInternamento)) {
            return false;
        }
        InterTipoDoencaInternamento other = (InterTipoDoencaInternamento) object;
        if ((this.pkIdTipoDoencaInternamento == null && other.pkIdTipoDoencaInternamento != null) || (this.pkIdTipoDoencaInternamento != null && !this.pkIdTipoDoencaInternamento.equals(other.pkIdTipoDoencaInternamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.InterTipoDoencaInternamento[ pkIdTipoDoencaInternamento=" + pkIdTipoDoencaInternamento + " ]";
    }
    
}
