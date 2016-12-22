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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "diag_categoria_exame", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagCategoriaExame.findAll", query = "SELECT d FROM DiagCategoriaExame d"),
    @NamedQuery(name = "DiagCategoriaExame.findByPkIdCategoria", query = "SELECT d FROM DiagCategoriaExame d WHERE d.pkIdCategoria = :pkIdCategoria"),
    @NamedQuery(name = "DiagCategoriaExame.findByDescricaoCategoria", query = "SELECT d FROM DiagCategoriaExame d WHERE d.descricaoCategoria = :descricaoCategoria"),
    @NamedQuery(name = "DiagCategoriaExame.findByFkIdSector", query = "SELECT d FROM DiagCategoriaExame d WHERE d.fkIdSector = :fkIdSector")})
public class DiagCategoriaExame implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_categoria")
    private Integer pkIdCategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao_categoria")
    private String descricaoCategoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_id_sector")
    private int fkIdSector;

    public DiagCategoriaExame() {
    }

    public DiagCategoriaExame(Integer pkIdCategoria) {
        this.pkIdCategoria = pkIdCategoria;
    }

    public DiagCategoriaExame(Integer pkIdCategoria, String descricaoCategoria, int fkIdSector) {
        this.pkIdCategoria = pkIdCategoria;
        this.descricaoCategoria = descricaoCategoria;
        this.fkIdSector = fkIdSector;
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

    public int getFkIdSector() {
        return fkIdSector;
    }

    public void setFkIdSector(int fkIdSector) {
        this.fkIdSector = fkIdSector;
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
        if (!(object instanceof DiagCategoriaExame)) {
            return false;
        }
        DiagCategoriaExame other = (DiagCategoriaExame) object;
        if ((this.pkIdCategoria == null && other.pkIdCategoria != null) || (this.pkIdCategoria != null && !this.pkIdCategoria.equals(other.pkIdCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.DiagCategoriaExame[ pkIdCategoria=" + pkIdCategoria + " ]";
    }
    
}
