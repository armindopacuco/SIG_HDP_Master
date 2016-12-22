/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "farm_material_sanitario", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmMaterialSanitario.findAll", query = "SELECT f FROM FarmMaterialSanitario f"),
    @NamedQuery(name = "FarmMaterialSanitario.findByPkIdMaterialSanitario", query = "SELECT f FROM FarmMaterialSanitario f WHERE f.pkIdMaterialSanitario = :pkIdMaterialSanitario"),
    @NamedQuery(name = "FarmMaterialSanitario.findByNomeGenerico", query = "SELECT f FROM FarmMaterialSanitario f WHERE f.nomeGenerico = :nomeGenerico"),
    @NamedQuery(name = "FarmMaterialSanitario.findByNomeComercial", query = "SELECT f FROM FarmMaterialSanitario f WHERE f.nomeComercial = :nomeComercial"),
    @NamedQuery(name = "FarmMaterialSanitario.findByAplicacoes", query = "SELECT f FROM FarmMaterialSanitario f WHERE f.aplicacoes = :aplicacoes"),
    @NamedQuery(name = "FarmMaterialSanitario.findByObservacoes", query = "SELECT f FROM FarmMaterialSanitario f WHERE f.observacoes = :observacoes"),
    @NamedQuery(name = "FarmMaterialSanitario.findByIndicacoes", query = "SELECT f FROM FarmMaterialSanitario f WHERE f.indicacoes = :indicacoes"),
    @NamedQuery(name = "FarmMaterialSanitario.findByContraIndicacoes", query = "SELECT f FROM FarmMaterialSanitario f WHERE f.contraIndicacoes = :contraIndicacoes"),
    @NamedQuery(name = "FarmMaterialSanitario.findByAvisos", query = "SELECT f FROM FarmMaterialSanitario f WHERE f.avisos = :avisos"),
    @NamedQuery(name = "FarmMaterialSanitario.findByDataHoraCadastro", query = "SELECT f FROM FarmMaterialSanitario f WHERE f.dataHoraCadastro = :dataHoraCadastro")})
public class FarmMaterialSanitario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_material_sanitario")
    private Integer pkIdMaterialSanitario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome_generico")
    private String nomeGenerico;
    @Size(max = 50)
    @Column(name = "nome_comercial")
    private String nomeComercial;
    @Size(max = 200)
    @Column(name = "aplicacoes")
    private String aplicacoes;
    @Size(max = 200)
    @Column(name = "observacoes")
    private String observacoes;
    @Size(max = 200)
    @Column(name = "indicacoes")
    private String indicacoes;
    @Size(max = 200)
    @Column(name = "contra_indicacoes")
    private String contraIndicacoes;
    @Size(max = 200)
    @Column(name = "avisos")
    private String avisos;
    @Column(name = "data_hora_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCadastro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdMaterialSanitario")
    private List<FarmInfoFabricoMaterialSanitario> farmInfoFabricoMaterialSanitarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdMaterialSanitario")
    private List<FarmMaterialSanitarioHasEfeitoSecundario> farmMaterialSanitarioHasEfeitoSecundarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdMaterialSanitario")
    private List<FarmFichaDeStock> farmFichaDeStockList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdMaterialSanitario")
    private List<FarmMovimento> farmMovimentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdMaterialSanitario")
    private List<FarmFornecimento> farmFornecimentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdMaterialSanitario")
    private List<FarmMedicamentoGrandeVolume> farmMedicamentoGrandeVolumeList;
    @JoinColumn(name = "fk_id_funcionario_cadastrou", referencedColumnName = "pk_id_funcionario")
    @ManyToOne(optional = false)
    private RhFuncionario fkIdFuncionarioCadastrou;
    @JoinColumn(name = "fk_id_foto", referencedColumnName = "pk_id_ficheiro_anexado")
    @ManyToOne
    private GrlFicheiroAnexado fkIdFoto;
    @JoinColumn(name = "fk_id_tipo_material", referencedColumnName = "pk_id_tipo_material")
    @ManyToOne(optional = false)
    private FarmTipoMaterialSanitario fkIdTipoMaterial;
    @JoinColumn(name = "fk_id_marca", referencedColumnName = "pk_id_marca")
    @ManyToOne(optional = false)
    private FarmMarcaMaterialSanitario fkIdMarca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdMaterialSanitario")
    private List<FarmMaterialGastavel> farmMaterialGastavelList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdMaterialSanitario")
    private List<FarmMaterialSanitarioHasAgenteActivo> farmMaterialSanitarioHasAgenteActivoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdMaterialSanitario")
    private List<FarmMaterialSanitarioHasOutroComponente> farmMaterialSanitarioHasOutroComponenteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdMaterialSanitario")
    private List<FarmMedicamento> farmMedicamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdMaterialSanitario")
    private List<FarmArmazenamentoHasMaterialSanitario> farmArmazenamentoHasMaterialSanitarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdMaterialSanitario")
    private List<FarmVendaHasMedicamento> farmVendaHasMedicamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdMedicamento")
    private List<InterFichaContrTeraMedicacao> interFichaContrTeraMedicacaoList;
    @OneToMany(mappedBy = "fkIdMedicamento")
    private List<InterControloTerapeuticoPediatria> interControloTerapeuticoPediatriaList;

    public FarmMaterialSanitario() {
    }

    public FarmMaterialSanitario(Integer pkIdMaterialSanitario) {
        this.pkIdMaterialSanitario = pkIdMaterialSanitario;
    }

    public FarmMaterialSanitario(Integer pkIdMaterialSanitario, String nomeGenerico) {
        this.pkIdMaterialSanitario = pkIdMaterialSanitario;
        this.nomeGenerico = nomeGenerico;
    }

    public Integer getPkIdMaterialSanitario() {
        return pkIdMaterialSanitario;
    }

    public void setPkIdMaterialSanitario(Integer pkIdMaterialSanitario) {
        this.pkIdMaterialSanitario = pkIdMaterialSanitario;
    }

    public String getNomeGenerico() {
        return nomeGenerico;
    }

    public void setNomeGenerico(String nomeGenerico) {
        this.nomeGenerico = nomeGenerico;
    }

    public String getNomeComercial() {
        return nomeComercial;
    }

    public void setNomeComercial(String nomeComercial) {
        this.nomeComercial = nomeComercial;
    }

    public String getAplicacoes() {
        return aplicacoes;
    }

    public void setAplicacoes(String aplicacoes) {
        this.aplicacoes = aplicacoes;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getIndicacoes() {
        return indicacoes;
    }

    public void setIndicacoes(String indicacoes) {
        this.indicacoes = indicacoes;
    }

    public String getContraIndicacoes() {
        return contraIndicacoes;
    }

    public void setContraIndicacoes(String contraIndicacoes) {
        this.contraIndicacoes = contraIndicacoes;
    }

    public String getAvisos() {
        return avisos;
    }

    public void setAvisos(String avisos) {
        this.avisos = avisos;
    }

    public Date getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(Date dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    @XmlTransient
    public List<FarmInfoFabricoMaterialSanitario> getFarmInfoFabricoMaterialSanitarioList() {
        return farmInfoFabricoMaterialSanitarioList;
    }

    public void setFarmInfoFabricoMaterialSanitarioList(List<FarmInfoFabricoMaterialSanitario> farmInfoFabricoMaterialSanitarioList) {
        this.farmInfoFabricoMaterialSanitarioList = farmInfoFabricoMaterialSanitarioList;
    }

    @XmlTransient
    public List<FarmMaterialSanitarioHasEfeitoSecundario> getFarmMaterialSanitarioHasEfeitoSecundarioList() {
        return farmMaterialSanitarioHasEfeitoSecundarioList;
    }

    public void setFarmMaterialSanitarioHasEfeitoSecundarioList(List<FarmMaterialSanitarioHasEfeitoSecundario> farmMaterialSanitarioHasEfeitoSecundarioList) {
        this.farmMaterialSanitarioHasEfeitoSecundarioList = farmMaterialSanitarioHasEfeitoSecundarioList;
    }

    @XmlTransient
    public List<FarmFichaDeStock> getFarmFichaDeStockList() {
        return farmFichaDeStockList;
    }

    public void setFarmFichaDeStockList(List<FarmFichaDeStock> farmFichaDeStockList) {
        this.farmFichaDeStockList = farmFichaDeStockList;
    }

    @XmlTransient
    public List<FarmMovimento> getFarmMovimentoList() {
        return farmMovimentoList;
    }

    public void setFarmMovimentoList(List<FarmMovimento> farmMovimentoList) {
        this.farmMovimentoList = farmMovimentoList;
    }

    @XmlTransient
    public List<FarmFornecimento> getFarmFornecimentoList() {
        return farmFornecimentoList;
    }

    public void setFarmFornecimentoList(List<FarmFornecimento> farmFornecimentoList) {
        this.farmFornecimentoList = farmFornecimentoList;
    }

    @XmlTransient
    public List<FarmMedicamentoGrandeVolume> getFarmMedicamentoGrandeVolumeList() {
        return farmMedicamentoGrandeVolumeList;
    }

    public void setFarmMedicamentoGrandeVolumeList(List<FarmMedicamentoGrandeVolume> farmMedicamentoGrandeVolumeList) {
        this.farmMedicamentoGrandeVolumeList = farmMedicamentoGrandeVolumeList;
    }

    public RhFuncionario getFkIdFuncionarioCadastrou() {
        return fkIdFuncionarioCadastrou;
    }

    public void setFkIdFuncionarioCadastrou(RhFuncionario fkIdFuncionarioCadastrou) {
        this.fkIdFuncionarioCadastrou = fkIdFuncionarioCadastrou;
    }

    public GrlFicheiroAnexado getFkIdFoto() {
        return fkIdFoto;
    }

    public void setFkIdFoto(GrlFicheiroAnexado fkIdFoto) {
        this.fkIdFoto = fkIdFoto;
    }

    public FarmTipoMaterialSanitario getFkIdTipoMaterial() {
        return fkIdTipoMaterial;
    }

    public void setFkIdTipoMaterial(FarmTipoMaterialSanitario fkIdTipoMaterial) {
        this.fkIdTipoMaterial = fkIdTipoMaterial;
    }

    public FarmMarcaMaterialSanitario getFkIdMarca() {
        return fkIdMarca;
    }

    public void setFkIdMarca(FarmMarcaMaterialSanitario fkIdMarca) {
        this.fkIdMarca = fkIdMarca;
    }

    @XmlTransient
    public List<FarmMaterialGastavel> getFarmMaterialGastavelList() {
        return farmMaterialGastavelList;
    }

    public void setFarmMaterialGastavelList(List<FarmMaterialGastavel> farmMaterialGastavelList) {
        this.farmMaterialGastavelList = farmMaterialGastavelList;
    }

    @XmlTransient
    public List<FarmMaterialSanitarioHasAgenteActivo> getFarmMaterialSanitarioHasAgenteActivoList() {
        return farmMaterialSanitarioHasAgenteActivoList;
    }

    public void setFarmMaterialSanitarioHasAgenteActivoList(List<FarmMaterialSanitarioHasAgenteActivo> farmMaterialSanitarioHasAgenteActivoList) {
        this.farmMaterialSanitarioHasAgenteActivoList = farmMaterialSanitarioHasAgenteActivoList;
    }

    @XmlTransient
    public List<FarmMaterialSanitarioHasOutroComponente> getFarmMaterialSanitarioHasOutroComponenteList() {
        return farmMaterialSanitarioHasOutroComponenteList;
    }

    public void setFarmMaterialSanitarioHasOutroComponenteList(List<FarmMaterialSanitarioHasOutroComponente> farmMaterialSanitarioHasOutroComponenteList) {
        this.farmMaterialSanitarioHasOutroComponenteList = farmMaterialSanitarioHasOutroComponenteList;
    }

    @XmlTransient
    public List<FarmMedicamento> getFarmMedicamentoList() {
        return farmMedicamentoList;
    }

    public void setFarmMedicamentoList(List<FarmMedicamento> farmMedicamentoList) {
        this.farmMedicamentoList = farmMedicamentoList;
    }

    @XmlTransient
    public List<FarmArmazenamentoHasMaterialSanitario> getFarmArmazenamentoHasMaterialSanitarioList() {
        return farmArmazenamentoHasMaterialSanitarioList;
    }

    public void setFarmArmazenamentoHasMaterialSanitarioList(List<FarmArmazenamentoHasMaterialSanitario> farmArmazenamentoHasMaterialSanitarioList) {
        this.farmArmazenamentoHasMaterialSanitarioList = farmArmazenamentoHasMaterialSanitarioList;
    }

    @XmlTransient
    public List<FarmVendaHasMedicamento> getFarmVendaHasMedicamentoList() {
        return farmVendaHasMedicamentoList;
    }

    public void setFarmVendaHasMedicamentoList(List<FarmVendaHasMedicamento> farmVendaHasMedicamentoList) {
        this.farmVendaHasMedicamentoList = farmVendaHasMedicamentoList;
    }

    @XmlTransient
    public List<InterFichaContrTeraMedicacao> getInterFichaContrTeraMedicacaoList() {
        return interFichaContrTeraMedicacaoList;
    }

    public void setInterFichaContrTeraMedicacaoList(List<InterFichaContrTeraMedicacao> interFichaContrTeraMedicacaoList) {
        this.interFichaContrTeraMedicacaoList = interFichaContrTeraMedicacaoList;
    }

    @XmlTransient
    public List<InterControloTerapeuticoPediatria> getInterControloTerapeuticoPediatriaList() {
        return interControloTerapeuticoPediatriaList;
    }

    public void setInterControloTerapeuticoPediatriaList(List<InterControloTerapeuticoPediatria> interControloTerapeuticoPediatriaList) {
        this.interControloTerapeuticoPediatriaList = interControloTerapeuticoPediatriaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdMaterialSanitario != null ? pkIdMaterialSanitario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmMaterialSanitario)) {
            return false;
        }
        FarmMaterialSanitario other = (FarmMaterialSanitario) object;
        if ((this.pkIdMaterialSanitario == null && other.pkIdMaterialSanitario != null) || (this.pkIdMaterialSanitario != null && !this.pkIdMaterialSanitario.equals(other.pkIdMaterialSanitario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmMaterialSanitario[ pkIdMaterialSanitario=" + pkIdMaterialSanitario + " ]";
    }
    
}
