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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "farm_material_sanitario_has_outro_componente", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmMaterialSanitarioHasOutroComponente.findAll", query = "SELECT f FROM FarmMaterialSanitarioHasOutroComponente f"),
    @NamedQuery(name = "FarmMaterialSanitarioHasOutroComponente.findByPkIdMaterialHasComponente", query = "SELECT f FROM FarmMaterialSanitarioHasOutroComponente f WHERE f.pkIdMaterialHasComponente = :pkIdMaterialHasComponente")})
public class FarmMaterialSanitarioHasOutroComponente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_material_has_componente")
    private Integer pkIdMaterialHasComponente;
    @JoinColumn(name = "fk_id_componente", referencedColumnName = "pk_id_componente")
    @ManyToOne(optional = false)
    private FarmOutroComponente fkIdComponente;
    @JoinColumn(name = "fk_id_material_sanitario", referencedColumnName = "pk_id_material_sanitario")
    @ManyToOne(optional = false)
    private FarmMaterialSanitario fkIdMaterialSanitario;

    public FarmMaterialSanitarioHasOutroComponente() {
    }

    public FarmMaterialSanitarioHasOutroComponente(Integer pkIdMaterialHasComponente) {
        this.pkIdMaterialHasComponente = pkIdMaterialHasComponente;
    }

    public Integer getPkIdMaterialHasComponente() {
        return pkIdMaterialHasComponente;
    }

    public void setPkIdMaterialHasComponente(Integer pkIdMaterialHasComponente) {
        this.pkIdMaterialHasComponente = pkIdMaterialHasComponente;
    }

    public FarmOutroComponente getFkIdComponente() {
        return fkIdComponente;
    }

    public void setFkIdComponente(FarmOutroComponente fkIdComponente) {
        this.fkIdComponente = fkIdComponente;
    }

    public FarmMaterialSanitario getFkIdMaterialSanitario() {
        return fkIdMaterialSanitario;
    }

    public void setFkIdMaterialSanitario(FarmMaterialSanitario fkIdMaterialSanitario) {
        this.fkIdMaterialSanitario = fkIdMaterialSanitario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdMaterialHasComponente != null ? pkIdMaterialHasComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmMaterialSanitarioHasOutroComponente)) {
            return false;
        }
        FarmMaterialSanitarioHasOutroComponente other = (FarmMaterialSanitarioHasOutroComponente) object;
        if ((this.pkIdMaterialHasComponente == null && other.pkIdMaterialHasComponente != null) || (this.pkIdMaterialHasComponente != null && !this.pkIdMaterialHasComponente.equals(other.pkIdMaterialHasComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmMaterialSanitarioHasOutroComponente[ pkIdMaterialHasComponente=" + pkIdMaterialHasComponente + " ]";
    }
    
}
