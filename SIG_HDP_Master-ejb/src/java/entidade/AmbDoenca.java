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
@Table(name = "amb_doenca", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbDoenca.findAll", query = "SELECT a FROM AmbDoenca a"),
    @NamedQuery(name = "AmbDoenca.findByPkIdDoenca", query = "SELECT a FROM AmbDoenca a WHERE a.pkIdDoenca = :pkIdDoenca"),
    @NamedQuery(name = "AmbDoenca.findByDescricao", query = "SELECT a FROM AmbDoenca a WHERE a.descricao = :descricao"),
    @NamedQuery(name = "AmbDoenca.findByCodigoInterno", query = "SELECT a FROM AmbDoenca a WHERE a.codigoInterno = :codigoInterno"),
    @NamedQuery(name = "AmbDoenca.findByCodigoInternacional", query = "SELECT a FROM AmbDoenca a WHERE a.codigoInternacional = :codigoInternacional"),
    @NamedQuery(name = "AmbDoenca.findByEspecificacao", query = "SELECT a FROM AmbDoenca a WHERE a.especificacao = :especificacao")})
public class AmbDoenca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_doenca")
    private Integer pkIdDoenca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 100)
    @Column(name = "codigo_interno")
    private String codigoInterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "codigo_internacional")
    private String codigoInternacional;
    @Size(max = 100)
    @Column(name = "especificacao")
    private String especificacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdDoenca")
    private List<InterDoencaInternamentoPaciente> interDoencaInternamentoPacienteList;
    @OneToMany(mappedBy = "fkIdDoenca")
    private List<AmbCategoriaDoencaNivel1> ambCategoriaDoencaNivel1List;

    public AmbDoenca() {
    }

    public AmbDoenca(Integer pkIdDoenca) {
        this.pkIdDoenca = pkIdDoenca;
    }

    public AmbDoenca(Integer pkIdDoenca, String descricao, String codigoInternacional) {
        this.pkIdDoenca = pkIdDoenca;
        this.descricao = descricao;
        this.codigoInternacional = codigoInternacional;
    }

    public Integer getPkIdDoenca() {
        return pkIdDoenca;
    }

    public void setPkIdDoenca(Integer pkIdDoenca) {
        this.pkIdDoenca = pkIdDoenca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public String getCodigoInternacional() {
        return codigoInternacional;
    }

    public void setCodigoInternacional(String codigoInternacional) {
        this.codigoInternacional = codigoInternacional;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    @XmlTransient
    public List<InterDoencaInternamentoPaciente> getInterDoencaInternamentoPacienteList() {
        return interDoencaInternamentoPacienteList;
    }

    public void setInterDoencaInternamentoPacienteList(List<InterDoencaInternamentoPaciente> interDoencaInternamentoPacienteList) {
        this.interDoencaInternamentoPacienteList = interDoencaInternamentoPacienteList;
    }

    @XmlTransient
    public List<AmbCategoriaDoencaNivel1> getAmbCategoriaDoencaNivel1List() {
        return ambCategoriaDoencaNivel1List;
    }

    public void setAmbCategoriaDoencaNivel1List(List<AmbCategoriaDoencaNivel1> ambCategoriaDoencaNivel1List) {
        this.ambCategoriaDoencaNivel1List = ambCategoriaDoencaNivel1List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdDoenca != null ? pkIdDoenca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbDoenca)) {
            return false;
        }
        AmbDoenca other = (AmbDoenca) object;
        if ((this.pkIdDoenca == null && other.pkIdDoenca != null) || (this.pkIdDoenca != null && !this.pkIdDoenca.equals(other.pkIdDoenca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbDoenca[ pkIdDoenca=" + pkIdDoenca + " ]";
    }
    
}
