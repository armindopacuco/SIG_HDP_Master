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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "amb_categoria_doenca_nivel_2", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbCategoriaDoencaNivel2.findAll", query = "SELECT a FROM AmbCategoriaDoencaNivel2 a"),
    @NamedQuery(name = "AmbCategoriaDoencaNivel2.findByPkIdCategoria", query = "SELECT a FROM AmbCategoriaDoencaNivel2 a WHERE a.pkIdCategoria = :pkIdCategoria"),
    @NamedQuery(name = "AmbCategoriaDoencaNivel2.findByDescricaoCategoria", query = "SELECT a FROM AmbCategoriaDoencaNivel2 a WHERE a.descricaoCategoria = :descricaoCategoria"),
    @NamedQuery(name = "AmbCategoriaDoencaNivel2.findByCodigoInterno", query = "SELECT a FROM AmbCategoriaDoencaNivel2 a WHERE a.codigoInterno = :codigoInterno"),
    @NamedQuery(name = "AmbCategoriaDoencaNivel2.findByCodigoInternacional", query = "SELECT a FROM AmbCategoriaDoencaNivel2 a WHERE a.codigoInternacional = :codigoInternacional")})
public class AmbCategoriaDoencaNivel2 implements Serializable {
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
    @JoinColumn(name = "fk_id_categoria_nivel_1", referencedColumnName = "pk_id_categoria")
    @ManyToOne
    private AmbCategoriaDoencaNivel1 fkIdCategoriaNivel1;

    public AmbCategoriaDoencaNivel2() {
    }

    public AmbCategoriaDoencaNivel2(Integer pkIdCategoria) {
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

    public AmbCategoriaDoencaNivel1 getFkIdCategoriaNivel1() {
        return fkIdCategoriaNivel1;
    }

    public void setFkIdCategoriaNivel1(AmbCategoriaDoencaNivel1 fkIdCategoriaNivel1) {
        this.fkIdCategoriaNivel1 = fkIdCategoriaNivel1;
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
        if (!(object instanceof AmbCategoriaDoencaNivel2)) {
            return false;
        }
        AmbCategoriaDoencaNivel2 other = (AmbCategoriaDoencaNivel2) object;
        if ((this.pkIdCategoria == null && other.pkIdCategoria != null) || (this.pkIdCategoria != null && !this.pkIdCategoria.equals(other.pkIdCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbCategoriaDoencaNivel2[ pkIdCategoria=" + pkIdCategoria + " ]";
    }
    
}
