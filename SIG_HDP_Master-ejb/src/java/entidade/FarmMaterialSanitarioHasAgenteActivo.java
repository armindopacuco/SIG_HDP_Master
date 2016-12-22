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
@Table(name = "farm_material_sanitario_has_agente_activo", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmMaterialSanitarioHasAgenteActivo.findAll", query = "SELECT f FROM FarmMaterialSanitarioHasAgenteActivo f"),
    @NamedQuery(name = "FarmMaterialSanitarioHasAgenteActivo.findByPkIdMaterialHasAgenteActivo", query = "SELECT f FROM FarmMaterialSanitarioHasAgenteActivo f WHERE f.pkIdMaterialHasAgenteActivo = :pkIdMaterialHasAgenteActivo")})
public class FarmMaterialSanitarioHasAgenteActivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_material_has_agente_activo")
    private Integer pkIdMaterialHasAgenteActivo;
    @JoinColumn(name = "fk_id_material_sanitario", referencedColumnName = "pk_id_material_sanitario")
    @ManyToOne(optional = false)
    private FarmMaterialSanitario fkIdMaterialSanitario;
    @JoinColumn(name = "fk_id_agente_activo", referencedColumnName = "pk_id_agente_activo")
    @ManyToOne(optional = false)
    private FarmAgenteActivo fkIdAgenteActivo;

    public FarmMaterialSanitarioHasAgenteActivo() {
    }

    public FarmMaterialSanitarioHasAgenteActivo(Integer pkIdMaterialHasAgenteActivo) {
        this.pkIdMaterialHasAgenteActivo = pkIdMaterialHasAgenteActivo;
    }

    public Integer getPkIdMaterialHasAgenteActivo() {
        return pkIdMaterialHasAgenteActivo;
    }

    public void setPkIdMaterialHasAgenteActivo(Integer pkIdMaterialHasAgenteActivo) {
        this.pkIdMaterialHasAgenteActivo = pkIdMaterialHasAgenteActivo;
    }

    public FarmMaterialSanitario getFkIdMaterialSanitario() {
        return fkIdMaterialSanitario;
    }

    public void setFkIdMaterialSanitario(FarmMaterialSanitario fkIdMaterialSanitario) {
        this.fkIdMaterialSanitario = fkIdMaterialSanitario;
    }

    public FarmAgenteActivo getFkIdAgenteActivo() {
        return fkIdAgenteActivo;
    }

    public void setFkIdAgenteActivo(FarmAgenteActivo fkIdAgenteActivo) {
        this.fkIdAgenteActivo = fkIdAgenteActivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdMaterialHasAgenteActivo != null ? pkIdMaterialHasAgenteActivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmMaterialSanitarioHasAgenteActivo)) {
            return false;
        }
        FarmMaterialSanitarioHasAgenteActivo other = (FarmMaterialSanitarioHasAgenteActivo) object;
        if ((this.pkIdMaterialHasAgenteActivo == null && other.pkIdMaterialHasAgenteActivo != null) || (this.pkIdMaterialHasAgenteActivo != null && !this.pkIdMaterialHasAgenteActivo.equals(other.pkIdMaterialHasAgenteActivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmMaterialSanitarioHasAgenteActivo[ pkIdMaterialHasAgenteActivo=" + pkIdMaterialHasAgenteActivo + " ]";
    }
    
}
