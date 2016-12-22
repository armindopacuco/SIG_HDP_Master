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
@Table(name = "amb_consultorio", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbConsultorio.findAll", query = "SELECT a FROM AmbConsultorio a"),
    @NamedQuery(name = "AmbConsultorio.findByPkIdConsultorio", query = "SELECT a FROM AmbConsultorio a WHERE a.pkIdConsultorio = :pkIdConsultorio"),
    @NamedQuery(name = "AmbConsultorio.findByDescricao", query = "SELECT a FROM AmbConsultorio a WHERE a.descricao = :descricao"),
    @NamedQuery(name = "AmbConsultorio.findByEstadoSala", query = "SELECT a FROM AmbConsultorio a WHERE a.estadoSala = :estadoSala")})
public class AmbConsultorio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_consultorio")
    private Integer pkIdConsultorio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "estado_sala")
    private Integer estadoSala;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPkIdConsultorio")
    private List<AmbConsultorioAtendimento> ambConsultorioAtendimentoList;

    public AmbConsultorio() {
    }

    public AmbConsultorio(Integer pkIdConsultorio) {
        this.pkIdConsultorio = pkIdConsultorio;
    }

    public AmbConsultorio(Integer pkIdConsultorio, String descricao) {
        this.pkIdConsultorio = pkIdConsultorio;
        this.descricao = descricao;
    }

    public Integer getPkIdConsultorio() {
        return pkIdConsultorio;
    }

    public void setPkIdConsultorio(Integer pkIdConsultorio) {
        this.pkIdConsultorio = pkIdConsultorio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getEstadoSala() {
        return estadoSala;
    }

    public void setEstadoSala(Integer estadoSala) {
        this.estadoSala = estadoSala;
    }

    @XmlTransient
    public List<AmbConsultorioAtendimento> getAmbConsultorioAtendimentoList() {
        return ambConsultorioAtendimentoList;
    }

    public void setAmbConsultorioAtendimentoList(List<AmbConsultorioAtendimento> ambConsultorioAtendimentoList) {
        this.ambConsultorioAtendimentoList = ambConsultorioAtendimentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdConsultorio != null ? pkIdConsultorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbConsultorio)) {
            return false;
        }
        AmbConsultorio other = (AmbConsultorio) object;
        if ((this.pkIdConsultorio == null && other.pkIdConsultorio != null) || (this.pkIdConsultorio != null && !this.pkIdConsultorio.equals(other.pkIdConsultorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbConsultorio[ pkIdConsultorio=" + pkIdConsultorio + " ]";
    }
    
}
