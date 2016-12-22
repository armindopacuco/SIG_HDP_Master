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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "farm_medicamento", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmMedicamento.findAll", query = "SELECT f FROM FarmMedicamento f"),
    @NamedQuery(name = "FarmMedicamento.findByPkIdMedicamento", query = "SELECT f FROM FarmMedicamento f WHERE f.pkIdMedicamento = :pkIdMedicamento"),
    @NamedQuery(name = "FarmMedicamento.findByFlagReceita", query = "SELECT f FROM FarmMedicamento f WHERE f.flagReceita = :flagReceita"),
    @NamedQuery(name = "FarmMedicamento.findByFlagNivelPostoSaude", query = "SELECT f FROM FarmMedicamento f WHERE f.flagNivelPostoSaude = :flagNivelPostoSaude"),
    @NamedQuery(name = "FarmMedicamento.findByFlagNivlCentroSaude", query = "SELECT f FROM FarmMedicamento f WHERE f.flagNivlCentroSaude = :flagNivlCentroSaude"),
    @NamedQuery(name = "FarmMedicamento.findByFlagHospitalMunicipal", query = "SELECT f FROM FarmMedicamento f WHERE f.flagHospitalMunicipal = :flagHospitalMunicipal"),
    @NamedQuery(name = "FarmMedicamento.findByFlagHospitalGeralEspecializado", query = "SELECT f FROM FarmMedicamento f WHERE f.flagHospitalGeralEspecializado = :flagHospitalGeralEspecializado")})
public class FarmMedicamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_medicamento")
    private Integer pkIdMedicamento;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFarmaco")
    private List<AmbConsultaAsFarmaco> ambConsultaAsFarmacoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFarmaco")
    private List<AmbPrescricaoMedicaAsFarmaco> ambPrescricaoMedicaAsFarmacoList;
    @JoinColumn(name = "fk_id_via_administracao", referencedColumnName = "pk_id_via_administracao")
    @ManyToOne(optional = false)
    private FarmViaAdministracao fkIdViaAdministracao;
    @JoinColumn(name = "fk_id_material_sanitario", referencedColumnName = "pk_id_material_sanitario")
    @ManyToOne(optional = false)
    private FarmMaterialSanitario fkIdMaterialSanitario;
    @JoinColumn(name = "fk_id_categoria", referencedColumnName = "pk_id_categoria_nivel_4")
    @ManyToOne(optional = false)
    private FarmCategoriaNivel4 fkIdCategoria;
    @JoinColumn(name = "fk_id_apesentacao", referencedColumnName = "pk_id_apresentacao")
    @ManyToOne(optional = false)
    private FarmApresentacao fkIdApesentacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFarmaco")
    private List<AmbAnamneseAsFarmaco> ambAnamneseAsFarmacoList;

    public FarmMedicamento() {
    }

    public FarmMedicamento(Integer pkIdMedicamento) {
        this.pkIdMedicamento = pkIdMedicamento;
    }

    public FarmMedicamento(Integer pkIdMedicamento, boolean flagReceita, boolean flagNivelPostoSaude, boolean flagNivlCentroSaude, boolean flagHospitalMunicipal, boolean flagHospitalGeralEspecializado) {
        this.pkIdMedicamento = pkIdMedicamento;
        this.flagReceita = flagReceita;
        this.flagNivelPostoSaude = flagNivelPostoSaude;
        this.flagNivlCentroSaude = flagNivlCentroSaude;
        this.flagHospitalMunicipal = flagHospitalMunicipal;
        this.flagHospitalGeralEspecializado = flagHospitalGeralEspecializado;
    }

    public Integer getPkIdMedicamento() {
        return pkIdMedicamento;
    }

    public void setPkIdMedicamento(Integer pkIdMedicamento) {
        this.pkIdMedicamento = pkIdMedicamento;
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

    @XmlTransient
    public List<AmbConsultaAsFarmaco> getAmbConsultaAsFarmacoList() {
        return ambConsultaAsFarmacoList;
    }

    public void setAmbConsultaAsFarmacoList(List<AmbConsultaAsFarmaco> ambConsultaAsFarmacoList) {
        this.ambConsultaAsFarmacoList = ambConsultaAsFarmacoList;
    }

    @XmlTransient
    public List<AmbPrescricaoMedicaAsFarmaco> getAmbPrescricaoMedicaAsFarmacoList() {
        return ambPrescricaoMedicaAsFarmacoList;
    }

    public void setAmbPrescricaoMedicaAsFarmacoList(List<AmbPrescricaoMedicaAsFarmaco> ambPrescricaoMedicaAsFarmacoList) {
        this.ambPrescricaoMedicaAsFarmacoList = ambPrescricaoMedicaAsFarmacoList;
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

    public FarmCategoriaNivel4 getFkIdCategoria() {
        return fkIdCategoria;
    }

    public void setFkIdCategoria(FarmCategoriaNivel4 fkIdCategoria) {
        this.fkIdCategoria = fkIdCategoria;
    }

    public FarmApresentacao getFkIdApesentacao() {
        return fkIdApesentacao;
    }

    public void setFkIdApesentacao(FarmApresentacao fkIdApesentacao) {
        this.fkIdApesentacao = fkIdApesentacao;
    }

    @XmlTransient
    public List<AmbAnamneseAsFarmaco> getAmbAnamneseAsFarmacoList() {
        return ambAnamneseAsFarmacoList;
    }

    public void setAmbAnamneseAsFarmacoList(List<AmbAnamneseAsFarmaco> ambAnamneseAsFarmacoList) {
        this.ambAnamneseAsFarmacoList = ambAnamneseAsFarmacoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdMedicamento != null ? pkIdMedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmMedicamento)) {
            return false;
        }
        FarmMedicamento other = (FarmMedicamento) object;
        if ((this.pkIdMedicamento == null && other.pkIdMedicamento != null) || (this.pkIdMedicamento != null && !this.pkIdMedicamento.equals(other.pkIdMedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmMedicamento[ pkIdMedicamento=" + pkIdMedicamento + " ]";
    }
    
}
