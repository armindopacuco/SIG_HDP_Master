/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "amb_categoria_doenca_nivel_1", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbCategoriaDoencaNivel1.findAll", query = "SELECT a FROM AmbCategoriaDoencaNivel1 a"),
    @NamedQuery(name = "AmbCategoriaDoencaNivel1.findByPkIdCategoria", query = "SELECT a FROM AmbCategoriaDoencaNivel1 a WHERE a.pkIdCategoria = :pkIdCategoria"),
    @NamedQuery(name = "AmbCategoriaDoencaNivel1.findByDescricaoCategoria", query = "SELECT a FROM AmbCategoriaDoencaNivel1 a WHERE a.descricaoCategoria = :descricaoCategoria"),
    @NamedQuery(name = "AmbCategoriaDoencaNivel1.findByCodigoInterno", query = "SELECT a FROM AmbCategoriaDoencaNivel1 a WHERE a.codigoInterno = :codigoInterno"),
    @NamedQuery(name = "AmbCategoriaDoencaNivel1.findByCodigoInternacional", query = "SELECT a FROM AmbCategoriaDoencaNivel1 a WHERE a.codigoInternacional = :codigoInternacional")})
public class AmbCategoriaDoencaNivel1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_categoria")
    private Integer pkIdCategoria;
    @Size(max = 150)
    @Column(name = "descricao_categoria")
    private String descricaoCategoria;
    @Size(max = 100)
    @Column(name = "codigo_interno")
    private String codigoInterno;
    @Size(max = 100)
    @Column(name = "codigo_internacional")
    private String codigoInternacional;
    @JoinColumn(name = "fk_id_doenca", referencedColumnName = "pk_id_doenca")
    @ManyToOne
    private AmbDoenca fkIdDoenca;
    @OneToMany(mappedBy = "fkIdCategoriaNivel1")
    private List<AmbCategoriaDoencaNivel2> ambCategoriaDoencaNivel2List;

    public AmbCategoriaDoencaNivel1() {
    }

    public AmbCategoriaDoencaNivel1(Integer pkIdCategoria) {
        this.pkIdCategoria = pkIdCategoria;
    }

    public Integer getPkIdCategoria() {
        return pkIdCategoria;
    }

    public void setPkIdCategoria(Integer pkIdCategoria) {
        this.pkIdCategoria = pkIdCategoria;
    }

    public String getDescricaoCategoria() {
        return descricaoCategoria;
    }

    public void setDescricaoCategoria(String descricaoCategoria) {
        this.descricaoCategoria = descricaoCategoria;
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

    public AmbDoenca getFkIdDoenca() {
        return fkIdDoenca;
    }

    public void setFkIdDoenca(AmbDoenca fkIdDoenca) {
        this.fkIdDoenca = fkIdDoenca;
    }

    @XmlTransient
    public List<AmbCategoriaDoencaNivel2> getAmbCategoriaDoencaNivel2List() {
        return ambCategoriaDoencaNivel2List;
    }

    public void setAmbCategoriaDoencaNivel2List(List<AmbCategoriaDoencaNivel2> ambCategoriaDoencaNivel2List) {
        this.ambCategoriaDoencaNivel2List = ambCategoriaDoencaNivel2List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdCategoria != null ? pkIdCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbCategoriaDoencaNivel1)) {
            return false;
        }
        AmbCategoriaDoencaNivel1 other = (AmbCategoriaDoencaNivel1) object;
        if ((this.pkIdCategoria == null && other.pkIdCategoria != null) || (this.pkIdCategoria != null && !this.pkIdCategoria.equals(other.pkIdCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbCategoriaDoencaNivel1[ pkIdCategoria=" + pkIdCategoria + " ]";
    }
    
}
