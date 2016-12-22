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
@Table(name = "diag_tipo_exame", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagTipoExame.findAll", query = "SELECT d FROM DiagTipoExame d"),
    @NamedQuery(name = "DiagTipoExame.findByPkIdTipoExame", query = "SELECT d FROM DiagTipoExame d WHERE d.pkIdTipoExame = :pkIdTipoExame"),
    @NamedQuery(name = "DiagTipoExame.findByDescricaoTipoExame", query = "SELECT d FROM DiagTipoExame d WHERE d.descricaoTipoExame = :descricaoTipoExame"),
    @NamedQuery(name = "DiagTipoExame.findByFkIdCategoria", query = "SELECT d FROM DiagTipoExame d WHERE d.fkIdCategoria = :fkIdCategoria")})
public class DiagTipoExame implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_tipo_exame")
    private Integer pkIdTipoExame;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao_tipo_exame")
    private String descricaoTipoExame;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_id_categoria")
    private int fkIdCategoria;

    public DiagTipoExame() {
    }

    public DiagTipoExame(Integer pkIdTipoExame) {
        this.pkIdTipoExame = pkIdTipoExame;
    }

    public DiagTipoExame(Integer pkIdTipoExame, String descricaoTipoExame, int fkIdCategoria) {
        this.pkIdTipoExame = pkIdTipoExame;
        this.descricaoTipoExame = descricaoTipoExame;
        this.fkIdCategoria = fkIdCategoria;
    }

    public Integer getPkIdTipoExame() {
        return pkIdTipoExame;
    }

    public void setPkIdTipoExame(Integer pkIdTipoExame) {
        this.pkIdTipoExame = pkIdTipoExame;
    }

    public String getDescricaoTipoExame() {
        return descricaoTipoExame;
    }

    public void setDescricaoTipoExame(String descricaoTipoExame) {
        this.descricaoTipoExame = descricaoTipoExame;
    }

    public int getFkIdCategoria() {
        return fkIdCategoria;
    }

    public void setFkIdCategoria(int fkIdCategoria) {
        this.fkIdCategoria = fkIdCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdTipoExame != null ? pkIdTipoExame.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagTipoExame)) {
            return false;
        }
        DiagTipoExame other = (DiagTipoExame) object;
        if ((this.pkIdTipoExame == null && other.pkIdTipoExame != null) || (this.pkIdTipoExame != null && !this.pkIdTipoExame.equals(other.pkIdTipoExame))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.DiagTipoExame[ pkIdTipoExame=" + pkIdTipoExame + " ]";
    }
    
}
