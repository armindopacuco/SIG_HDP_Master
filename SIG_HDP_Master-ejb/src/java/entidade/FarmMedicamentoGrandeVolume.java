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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "farm_medicamento_grande_volume", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmMedicamentoGrandeVolume.findAll", query = "SELECT f FROM FarmMedicamentoGrandeVolume f"),
    @NamedQuery(name = "FarmMedicamentoGrandeVolume.findByPkIdMedicamentoGrandeVolume", query = "SELECT f FROM FarmMedicamentoGrandeVolume f WHERE f.pkIdMedicamentoGrandeVolume = :pkIdMedicamentoGrandeVolume"),
    @NamedQuery(name = "FarmMedicamentoGrandeVolume.findByFlagReceita", query = "SELECT f FROM FarmMedicamentoGrandeVolume f WHERE f.flagReceita = :flagReceita"),
    @NamedQuery(name = "FarmMedicamentoGrandeVolume.findByFlagNivelPostoSaude", query = "SELECT f FROM FarmMedicamentoGrandeVolume f WHERE f.flagNivelPostoSaude = :flagNivelPostoSaude"),
    @NamedQuery(name = "FarmMedicamentoGrandeVolume.findByFlagNivlCentroSaude", query = "SELECT f FROM FarmMedicamentoGrandeVolume f WHERE f.flagNivlCentroSaude = :flagNivlCentroSaude"),
    @NamedQuery(name = "FarmMedicamentoGrandeVolume.findByFlagHospitalMunicipal", query = "SELECT f FROM FarmMedicamentoGrandeVolume f WHERE f.flagHospitalMunicipal = :flagHospitalMunicipal"),
    @NamedQuery(name = "FarmMedicamentoGrandeVolume.findByFlagHospitalGeralEspecializado", query = "SELECT f FROM FarmMedicamentoGrandeVolume f WHERE f.flagHospitalGeralEspecializado = :flagHospitalGeralEspecializado")})
public class FarmMedicamentoGrandeVolume implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_medicamento_grande_volume")
    private Integer pkIdMedicamentoGrandeVolume;
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
    @JoinColumn(name = "fk_id_via_administracao", referencedColumnName = "pk_id_via_administracao")
    @ManyToOne(optional = false)
    private FarmViaAdministracao fkIdViaAdministracao;
    @JoinColumn(name = "fk_id_material_sanitario", referencedColumnName = "pk_id_material_sanitario")
    @ManyToOne(optional = false)
    private FarmMaterialSanitario fkIdMaterialSanitario;
    @JoinColumn(name = "fk_id_apresentacao", referencedColumnName = "pk_id_apresentacao")
    @ManyToOne(optional = false)
    private FarmApresentacao fkIdApresentacao;

    public FarmMedicamentoGrandeVolume() {
    }

    public FarmMedicamentoGrandeVolume(Integer pkIdMedicamentoGrandeVolume) {
        this.pkIdMedicamentoGrandeVolume = pkIdMedicamentoGrandeVolume;
    }

    public FarmMedicamentoGrandeVolume(Integer pkIdMedicamentoGrandeVolume, boolean flagReceita, boolean flagNivelPostoSaude, boolean flagNivlCentroSaude, boolean flagHospitalMunicipal, boolean flagHospitalGeralEspecializado) {
        this.pkIdMedicamentoGrandeVolume = pkIdMedicamentoGrandeVolume;
        this.flagReceita = flagReceita;
        this.flagNivelPostoSaude = flagNivelPostoSaude;
        this.flagNivlCentroSaude = flagNivlCentroSaude;
        this.flagHospitalMunicipal = flagHospitalMunicipal;
        this.flagHospitalGeralEspecializado = flagHospitalGeralEspecializado;
    }

    public Integer getPkIdMedicamentoGrandeVolume() {
        return pkIdMedicamentoGrandeVolume;
    }

    public void setPkIdMedicamentoGrandeVolume(Integer pkIdMedicamentoGrandeVolume) {
        this.pkIdMedicamentoGrandeVolume = pkIdMedicamentoGrandeVolume;
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

    public FarmViaAdministracao getFkIdViaAdministracao() {
        return fkIdViaAdministracao;
    }

    public void setFkIdViaAdministracao(FarmViaAdministracao fkIdViaAdministracao) {
        this.fkIdViaAdministracao = fkIdViaAdministracao;
    }

    public FarmMaterialSanitario getFkIdMaterialSanitario() {
        return fkIdMaterialSanitario;
    }

    public void setFkIdMaterialSanitario(FarmMaterialSanitario fkIdMaterialSanitario) {
        this.fkIdMaterialSanitario = fkIdMaterialSanitario;
    }

    public FarmApresentacao getFkIdApresentacao() {
        return fkIdApresentacao;
    }

    public void setFkIdApresentacao(FarmApresentacao fkIdApresentacao) {
        this.fkIdApresentacao = fkIdApresentacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdMedicamentoGrandeVolume != null ? pkIdMedicamentoGrandeVolume.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmMedicamentoGrandeVolume)) {
            return false;
        }
        FarmMedicamentoGrandeVolume other = (FarmMedicamentoGrandeVolume) object;
        if ((this.pkIdMedicamentoGrandeVolume == null && other.pkIdMedicamentoGrandeVolume != null) || (this.pkIdMedicamentoGrandeVolume != null && !this.pkIdMedicamentoGrandeVolume.equals(other.pkIdMedicamentoGrandeVolume))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmMedicamentoGrandeVolume[ pkIdMedicamentoGrandeVolume=" + pkIdMedicamentoGrandeVolume + " ]";
    }
    
}
