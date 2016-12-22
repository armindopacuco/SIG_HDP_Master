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
@Table(name = "farm_material_sanitario_has_efeito_secundario", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmMaterialSanitarioHasEfeitoSecundario.findAll", query = "SELECT f FROM FarmMaterialSanitarioHasEfeitoSecundario f"),
    @NamedQuery(name = "FarmMaterialSanitarioHasEfeitoSecundario.findByPkIdMaterialHasAgenteActivo", query = "SELECT f FROM FarmMaterialSanitarioHasEfeitoSecundario f WHERE f.pkIdMaterialHasAgenteActivo = :pkIdMaterialHasAgenteActivo")})
public class FarmMaterialSanitarioHasEfeitoSecundario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_material_has_agente_activo")
    private Integer pkIdMaterialHasAgenteActivo;
    @JoinColumn(name = "fk_id_material_sanitario", referencedColumnName = "pk_id_material_sanitario")
    @ManyToOne(optional = false)
    private FarmMaterialSanitario fkIdMaterialSanitario;
    @JoinColumn(name = "fk_id_efeito_secundario", referencedColumnName = "pk_id_efeito_secundario")
    @ManyToOne(optional = false)
    private FarmEfeitoSecundario fkIdEfeitoSecundario;

    public FarmMaterialSanitarioHasEfeitoSecundario() {
    }

    public FarmMaterialSanitarioHasEfeitoSecundario(Integer pkIdMaterialHasAgenteActivo) {
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

    public FarmEfeitoSecundario getFkIdEfeitoSecundario() {
        return fkIdEfeitoSecundario;
    }

    public void setFkIdEfeitoSecundario(FarmEfeitoSecundario fkIdEfeitoSecundario) {
        this.fkIdEfeitoSecundario = fkIdEfeitoSecundario;
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
        if (!(object instanceof FarmMaterialSanitarioHasEfeitoSecundario)) {
            return false;
        }
        FarmMaterialSanitarioHasEfeitoSecundario other = (FarmMaterialSanitarioHasEfeitoSecundario) object;
        if ((this.pkIdMaterialHasAgenteActivo == null && other.pkIdMaterialHasAgenteActivo != null) || (this.pkIdMaterialHasAgenteActivo != null && !this.pkIdMaterialHasAgenteActivo.equals(other.pkIdMaterialHasAgenteActivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmMaterialSanitarioHasEfeitoSecundario[ pkIdMaterialHasAgenteActivo=" + pkIdMaterialHasAgenteActivo + " ]";
    }
    
}
