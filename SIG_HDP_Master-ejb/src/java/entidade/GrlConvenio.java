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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "grl_convenio", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrlConvenio.findAll", query = "SELECT g FROM GrlConvenio g"),
    @NamedQuery(name = "GrlConvenio.findByPkIdConvenio", query = "SELECT g FROM GrlConvenio g WHERE g.pkIdConvenio = :pkIdConvenio"),
    @NamedQuery(name = "GrlConvenio.findByNomeConvenio", query = "SELECT g FROM GrlConvenio g WHERE g.nomeConvenio = :nomeConvenio")})
public class GrlConvenio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_convenio")
    private Integer pkIdConvenio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome_convenio")
    private String nomeConvenio;
    @JoinColumn(name = "fk_id_instituicao", referencedColumnName = "pk_id_instituicao")
    @ManyToOne(optional = false)
    private GrlInstituicao fkIdInstituicao;
    @JoinColumn(name = "fk_id_estado_convenio", referencedColumnName = "pk_id_estado_convenio")
    @ManyToOne(optional = false)
    private GrlEstadoConvenio fkIdEstadoConvenio;

    public GrlConvenio() {
    }

    public GrlConvenio(Integer pkIdConvenio) {
        this.pkIdConvenio = pkIdConvenio;
    }

    public GrlConvenio(Integer pkIdConvenio, String nomeConvenio) {
        this.pkIdConvenio = pkIdConvenio;
        this.nomeConvenio = nomeConvenio;
    }

    public Integer getPkIdConvenio() {
        return pkIdConvenio;
    }

    public void setPkIdConvenio(Integer pkIdConvenio) {
        this.pkIdConvenio = pkIdConvenio;
    }

    public String getNomeConvenio() {
        return nomeConvenio;
    }

    public void setNomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }

    public GrlInstituicao getFkIdInstituicao() {
        return fkIdInstituicao;
    }

    public void setFkIdInstituicao(GrlInstituicao fkIdInstituicao) {
        this.fkIdInstituicao = fkIdInstituicao;
    }

    public GrlEstadoConvenio getFkIdEstadoConvenio() {
        return fkIdEstadoConvenio;
    }

    public void setFkIdEstadoConvenio(GrlEstadoConvenio fkIdEstadoConvenio) {
        this.fkIdEstadoConvenio = fkIdEstadoConvenio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdConvenio != null ? pkIdConvenio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrlConvenio)) {
            return false;
        }
        GrlConvenio other = (GrlConvenio) object;
        if ((this.pkIdConvenio == null && other.pkIdConvenio != null) || (this.pkIdConvenio != null && !this.pkIdConvenio.equals(other.pkIdConvenio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.GrlConvenio[ pkIdConvenio=" + pkIdConvenio + " ]";
    }
    
}
