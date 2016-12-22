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
@Table(name = "farm_material_gastavel", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmMaterialGastavel.findAll", query = "SELECT f FROM FarmMaterialGastavel f"),
    @NamedQuery(name = "FarmMaterialGastavel.findByPkIdMaterialGastavel", query = "SELECT f FROM FarmMaterialGastavel f WHERE f.pkIdMaterialGastavel = :pkIdMaterialGastavel"),
    @NamedQuery(name = "FarmMaterialGastavel.findByDescricaoMaterialGastavel", query = "SELECT f FROM FarmMaterialGastavel f WHERE f.descricaoMaterialGastavel = :descricaoMaterialGastavel"),
    @NamedQuery(name = "FarmMaterialGastavel.findByTamanho", query = "SELECT f FROM FarmMaterialGastavel f WHERE f.tamanho = :tamanho"),
    @NamedQuery(name = "FarmMaterialGastavel.findByFlagReceita", query = "SELECT f FROM FarmMaterialGastavel f WHERE f.flagReceita = :flagReceita"),
    @NamedQuery(name = "FarmMaterialGastavel.findByFlagNivelPostoSaude", query = "SELECT f FROM FarmMaterialGastavel f WHERE f.flagNivelPostoSaude = :flagNivelPostoSaude"),
    @NamedQuery(name = "FarmMaterialGastavel.findByFlagNivlCentroSaude", query = "SELECT f FROM FarmMaterialGastavel f WHERE f.flagNivlCentroSaude = :flagNivlCentroSaude"),
    @NamedQuery(name = "FarmMaterialGastavel.findByFlagHospitalMunicipal", query = "SELECT f FROM FarmMaterialGastavel f WHERE f.flagHospitalMunicipal = :flagHospitalMunicipal"),
    @NamedQuery(name = "FarmMaterialGastavel.findByFlagHospitalGeralEspecializado", query = "SELECT f FROM FarmMaterialGastavel f WHERE f.flagHospitalGeralEspecializado = :flagHospitalGeralEspecializado")})
public class FarmMaterialGastavel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_material_gastavel")
    private Integer pkIdMaterialGastavel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descricao_material_gastavel")
    private String descricaoMaterialGastavel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tamanho")
    private int tamanho;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flag_receita")
    private boolean flagReceita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flag_nivel_posto_saude")
    private boolean flagNivelPostoSaude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flag_nivl_centro_saude")
    private boolean flagNivlCentroSaude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flag_hospital_municipal")
    private boolean flagHospitalMunicipal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flag_hospital_geral_especializado")
    private boolean flagHospitalGeralEspecializado;
    @JoinColumn(name = "fk_id_unidade_medida", referencedColumnName = "pk_id_unidade_medida")
    @ManyToOne(optional = false)
    private FarmUnidadeMedida fkIdUnidadeMedida;
    @JoinColumn(name = "fk_id_material_sanitario", referencedColumnName = "pk_id_material_sanitario")
    @ManyToOne(optional = false)
    private FarmMaterialSanitario fkIdMaterialSanitario;

    public FarmMaterialGastavel() {
    }

    public FarmMaterialGastavel(Integer pkIdMaterialGastavel) {
        this.pkIdMaterialGastavel = pkIdMaterialGastavel;
    }

    public FarmMaterialGastavel(Integer pkIdMaterialGastavel, String descricaoMaterialGastavel, int tamanho, boolean flagReceita, boolean flagNivelPostoSaude, boolean flagNivlCentroSaude, boolean flagHospitalMunicipal, boolean flagHospitalGeralEspecializado) {
        this.pkIdMaterialGastavel = pkIdMaterialGastavel;
        this.descricaoMaterialGastavel = descricaoMaterialGastavel;
        this.tamanho = tamanho;
        this.flagReceita = flagReceita;
        this.flagNivelPostoSaude = flagNivelPostoSaude;
        this.flagNivlCentroSaude = flagNivlCentroSaude;
        this.flagHospitalMunicipal = flagHospitalMunicipal;
        this.flagHospitalGeralEspecializado = flagHospitalGeralEspecializado;
    }

    public Integer getPkIdMaterialGastavel() {
        return pkIdMaterialGastavel;
    }

    public void setPkIdMaterialGastavel(Integer pkIdMaterialGastavel) {
        this.pkIdMaterialGastavel = pkIdMaterialGastavel;
    }

    public String getDescricaoMaterialGastavel() {
        return descricaoMaterialGastavel;
    }

    public void setDescricaoMaterialGastavel(String descricaoMaterialGastavel) {
        this.descricaoMaterialGastavel = descricaoMaterialGastavel;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public boolean getFlagReceita() {
        return flagReceita;
    }

    public void setFlagReceita(boolean flagReceita) {
        this.flagReceita = flagReceita;
    }

    public boolean getFlagNivelPostoSaude() {
        return flagNivelPostoSaude;
    }

    public void setFlagNivelPostoSaude(boolean flagNivelPostoSaude) {
        this.flagNivelPostoSaude = flagNivelPostoSaude;
    }

    public boolean getFlagNivlCentroSaude() {
        return flagNivlCentroSaude;
    }

    public void setFlagNivlCentroSaude(boolean flagNivlCentroSaude) {
        this.flagNivlCentroSaude = flagNivlCentroSaude;
    }

    public boolean getFlagHospitalMunicipal() {
        return flagHospitalMunicipal;
    }

    public void setFlagHospitalMunicipal(boolean flagHospitalMunicipal) {
        this.flagHospitalMunicipal = flagHospitalMunicipal;
    }

    public boolean getFlagHospitalGeralEspecializado() {
        return flagHospitalGeralEspecializado;
    }

    public void setFlagHospitalGeralEspecializado(boolean flagHospitalGeralEspecializado) {
        this.flagHospitalGeralEspecializado = flagHospitalGeralEspecializado;
    }

    public FarmUnidadeMedida getFkIdUnidadeMedida() {
        return fkIdUnidadeMedida;
    }

    public void setFkIdUnidadeMedida(FarmUnidadeMedida fkIdUnidadeMedida) {
        this.fkIdUnidadeMedida = fkIdUnidadeMedida;
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
        hash += (pkIdMaterialGastavel != null ? pkIdMaterialGastavel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmMaterialGastavel)) {
            return false;
        }
        FarmMaterialGastavel other = (FarmMaterialGastavel) object;
        if ((this.pkIdMaterialGastavel == null && other.pkIdMaterialGastavel != null) || (this.pkIdMaterialGastavel != null && !this.pkIdMaterialGastavel.equals(other.pkIdMaterialGastavel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmMaterialGastavel[ pkIdMaterialGastavel=" + pkIdMaterialGastavel + " ]";
    }
    
}
