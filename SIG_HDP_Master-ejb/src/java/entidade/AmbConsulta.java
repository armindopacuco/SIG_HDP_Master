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
@Table(name = "amb_consulta", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbConsulta.findAll", query = "SELECT a FROM AmbConsulta a"),
    @NamedQuery(name = "AmbConsulta.findByPkIdConsulta", query = "SELECT a FROM AmbConsulta a WHERE a.pkIdConsulta = :pkIdConsulta"),
    @NamedQuery(name = "AmbConsulta.findByCodigoConsulta", query = "SELECT a FROM AmbConsulta a WHERE a.codigoConsulta = :codigoConsulta"),
    @NamedQuery(name = "AmbConsulta.findByHipoteseDiagnostica", query = "SELECT a FROM AmbConsulta a WHERE a.hipoteseDiagnostica = :hipoteseDiagnostica"),
    @NamedQuery(name = "AmbConsulta.findByObservacoesMedicas", query = "SELECT a FROM AmbConsulta a WHERE a.observacoesMedicas = :observacoesMedicas"),
    @NamedQuery(name = "AmbConsulta.findByDataHoraConsulta", query = "SELECT a FROM AmbConsulta a WHERE a.dataHoraConsulta = :dataHoraConsulta"),
    @NamedQuery(name = "AmbConsulta.findByOQueSente", query = "SELECT a FROM AmbConsulta a WHERE a.oQueSente = :oQueSente"),
    @NamedQuery(name = "AmbConsulta.findByQuandoComecou", query = "SELECT a FROM AmbConsulta a WHERE a.quandoComecou = :quandoComecou"),
    @NamedQuery(name = "AmbConsulta.findByHistoriaDoencaCtual", query = "SELECT a FROM AmbConsulta a WHERE a.historiaDoencaCtual = :historiaDoencaCtual"),
    @NamedQuery(name = "AmbConsulta.findByUsoDeMedicacao", query = "SELECT a FROM AmbConsulta a WHERE a.usoDeMedicacao = :usoDeMedicacao"),
    @NamedQuery(name = "AmbConsulta.findByImpressoesGerais", query = "SELECT a FROM AmbConsulta a WHERE a.impressoesGerais = :impressoesGerais"),
    @NamedQuery(name = "AmbConsulta.findByColoracaoMucosas", query = "SELECT a FROM AmbConsulta a WHERE a.coloracaoMucosas = :coloracaoMucosas"),
    @NamedQuery(name = "AmbConsulta.findByHidratacaoMucosas", query = "SELECT a FROM AmbConsulta a WHERE a.hidratacaoMucosas = :hidratacaoMucosas"),
    @NamedQuery(name = "AmbConsulta.findByCorPele", query = "SELECT a FROM AmbConsulta a WHERE a.corPele = :corPele"),
    @NamedQuery(name = "AmbConsulta.findByTexturaPele", query = "SELECT a FROM AmbConsulta a WHERE a.texturaPele = :texturaPele"),
    @NamedQuery(name = "AmbConsulta.findByTurgorPele", query = "SELECT a FROM AmbConsulta a WHERE a.turgorPele = :turgorPele"),
    @NamedQuery(name = "AmbConsulta.findByPresencaPregas", query = "SELECT a FROM AmbConsulta a WHERE a.presencaPregas = :presencaPregas"),
    @NamedQuery(name = "AmbConsulta.findByTurgorTecidoCelular", query = "SELECT a FROM AmbConsulta a WHERE a.turgorTecidoCelular = :turgorTecidoCelular"),
    @NamedQuery(name = "AmbConsulta.findByEspessuraTecido", query = "SELECT a FROM AmbConsulta a WHERE a.espessuraTecido = :espessuraTecido"),
    @NamedQuery(name = "AmbConsulta.findByAdenomegalias", query = "SELECT a FROM AmbConsulta a WHERE a.adenomegalias = :adenomegalias"),
    @NamedQuery(name = "AmbConsulta.findByLocalizacao", query = "SELECT a FROM AmbConsulta a WHERE a.localizacao = :localizacao"),
    @NamedQuery(name = "AmbConsulta.findByTamanho", query = "SELECT a FROM AmbConsulta a WHERE a.tamanho = :tamanho"),
    @NamedQuery(name = "AmbConsulta.findByDorGanglios", query = "SELECT a FROM AmbConsulta a WHERE a.dorGanglios = :dorGanglios"),
    @NamedQuery(name = "AmbConsulta.findByAderencia", query = "SELECT a FROM AmbConsulta a WHERE a.aderencia = :aderencia"),
    @NamedQuery(name = "AmbConsulta.findByOutrosDados", query = "SELECT a FROM AmbConsulta a WHERE a.outrosDados = :outrosDados")})
public class AmbConsulta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_consulta")
    private Integer pkIdConsulta;
    @Size(max = 100)
    @Column(name = "codigo_consulta")
    private String codigoConsulta;
    @Size(max = 100)
    @Column(name = "hipotese_diagnostica")
    private String hipoteseDiagnostica;
    @Size(max = 500)
    @Column(name = "observacoes_medicas")
    private String observacoesMedicas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_hora_consulta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraConsulta;
    @Size(max = 1500)
    @Column(name = "o_que_sente")
    private String oQueSente;
    @Size(max = 1500)
    @Column(name = "quando_comecou")
    private String quandoComecou;
    @Size(max = 100)
    @Column(name = "historia_doenca_ctual")
    private String historiaDoencaCtual;
    @Size(max = 100)
    @Column(name = "uso_de_medicacao")
    private String usoDeMedicacao;
    @Size(max = 100)
    @Column(name = "impressoes_gerais")
    private String impressoesGerais;
    @Size(max = 100)
    @Column(name = "coloracao_mucosas")
    private String coloracaoMucosas;
    @Size(max = 100)
    @Column(name = "hidratacao_mucosas")
    private String hidratacaoMucosas;
    @Size(max = 100)
    @Column(name = "cor_pele")
    private String corPele;
    @Size(max = 100)
    @Column(name = "textura_pele")
    private String texturaPele;
    @Size(max = 100)
    @Column(name = "turgor_pele")
    private String turgorPele;
    @Size(max = 100)
    @Column(name = "presenca_pregas")
    private String presencaPregas;
    @Size(max = 100)
    @Column(name = "turgor_tecido_celular")
    private String turgorTecidoCelular;
    @Size(max = 100)
    @Column(name = "espessura_tecido")
    private String espessuraTecido;
    @Size(max = 100)
    @Column(name = "adenomegalias")
    private String adenomegalias;
    @Size(max = 100)
    @Column(name = "localizacao")
    private String localizacao;
    @Size(max = 100)
    @Column(name = "tamanho")
    private String tamanho;
    @Size(max = 100)
    @Column(name = "dor_ganglios")
    private String dorGanglios;
    @Size(max = 100)
    @Column(name = "aderencia")
    private String aderencia;
    @Size(max = 150)
    @Column(name = "outros_dados")
    private String outrosDados;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdConsulta")
    private List<AmbPrescricaoMedica> ambPrescricaoMedicaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdConsulta")
    private List<AmbDiagnosticoHipotese> ambDiagnosticoHipoteseList;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne(optional = false)
    private RhFuncionario fkIdFuncionario;
    @JoinColumn(name = "fk_pk_id_triagem", referencedColumnName = "pk_id_triagem")
    @ManyToOne
    private AmbTriagem fkPkIdTriagem;
    @JoinColumn(name = "fk_pk_id_estado", referencedColumnName = "pk_id_estado")
    @ManyToOne(optional = false)
    private AmbEstado fkPkIdEstado;
    @JoinColumn(name = "fk_pk_id_adms_solicitacao_servico", referencedColumnName = "pk_id_servico_solicitado")
    @ManyToOne(optional = false)
    private AdmsServicoSolicitado fkPkIdAdmsSolicitacaoServico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdConsulta")
    private List<AmbConsultaRetorno> ambConsultaRetornoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdConsulta")
    private List<AmbConsultaAsFarmaco> ambConsultaAsFarmacoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdConsulta")
    private List<AmbAnamenese> ambAnameneseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdConsulta")
    private List<AmbDiagnostico> ambDiagnosticoList;

    public AmbConsulta() {
    }

    public AmbConsulta(Integer pkIdConsulta) {
        this.pkIdConsulta = pkIdConsulta;
    }

    public AmbConsulta(Integer pkIdConsulta, Date dataHoraConsulta) {
        this.pkIdConsulta = pkIdConsulta;
        this.dataHoraConsulta = dataHoraConsulta;
    }

    public Integer getPkIdConsulta() {
        return pkIdConsulta;
    }

    public void setPkIdConsulta(Integer pkIdConsulta) {
        this.pkIdConsulta = pkIdConsulta;
    }

    public String getCodigoConsulta() {
        return codigoConsulta;
    }

    public void setCodigoConsulta(String codigoConsulta) {
        this.codigoConsulta = codigoConsulta;
    }

    public String getHipoteseDiagnostica() {
        return hipoteseDiagnostica;
    }

    public void setHipoteseDiagnostica(String hipoteseDiagnostica) {
        this.hipoteseDiagnostica = hipoteseDiagnostica;
    }

    public String getObservacoesMedicas() {
        return observacoesMedicas;
    }

    public void setObservacoesMedicas(String observacoesMedicas) {
        this.observacoesMedicas = observacoesMedicas;
    }

    public Date getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public void setDataHoraConsulta(Date dataHoraConsulta) {
        this.dataHoraConsulta = dataHoraConsulta;
    }

    public String getOQueSente() {
        return oQueSente;
    }

    public void setOQueSente(String oQueSente) {
        this.oQueSente = oQueSente;
    }

    public String getQuandoComecou() {
        return quandoComecou;
    }

    public void setQuandoComecou(String quandoComecou) {
        this.quandoComecou = quandoComecou;
    }

    public String getHistoriaDoencaCtual() {
        return historiaDoencaCtual;
    }

    public void setHistoriaDoencaCtual(String historiaDoencaCtual) {
        this.historiaDoencaCtual = historiaDoencaCtual;
    }

    public String getUsoDeMedicacao() {
        return usoDeMedicacao;
    }

    public void setUsoDeMedicacao(String usoDeMedicacao) {
        this.usoDeMedicacao = usoDeMedicacao;
    }

    public String getImpressoesGerais() {
        return impressoesGerais;
    }

    public void setImpressoesGerais(String impressoesGerais) {
        this.impressoesGerais = impressoesGerais;
    }

    public String getColoracaoMucosas() {
        return coloracaoMucosas;
    }

    public void setColoracaoMucosas(String coloracaoMucosas) {
        this.coloracaoMucosas = coloracaoMucosas;
    }

    public String getHidratacaoMucosas() {
        return hidratacaoMucosas;
    }

    public void setHidratacaoMucosas(String hidratacaoMucosas) {
        this.hidratacaoMucosas = hidratacaoMucosas;
    }

    public String getCorPele() {
        return corPele;
    }

    public void setCorPele(String corPele) {
        this.corPele = corPele;
    }

    public String getTexturaPele() {
        return texturaPele;
    }

    public void setTexturaPele(String texturaPele) {
        this.texturaPele = texturaPele;
    }

    public String getTurgorPele() {
        return turgorPele;
    }

    public void setTurgorPele(String turgorPele) {
        this.turgorPele = turgorPele;
    }

    public String getPresencaPregas() {
        return presencaPregas;
    }

    public void setPresencaPregas(String presencaPregas) {
        this.presencaPregas = presencaPregas;
    }

    public String getTurgorTecidoCelular() {
        return turgorTecidoCelular;
    }

    public void setTurgorTecidoCelular(String turgorTecidoCelular) {
        this.turgorTecidoCelular = turgorTecidoCelular;
    }

    public String getEspessuraTecido() {
        return espessuraTecido;
    }

    public void setEspessuraTecido(String espessuraTecido) {
        this.espessuraTecido = espessuraTecido;
    }

    public String getAdenomegalias() {
        return adenomegalias;
    }

    public void setAdenomegalias(String adenomegalias) {
        this.adenomegalias = adenomegalias;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getDorGanglios() {
        return dorGanglios;
    }

    public void setDorGanglios(String dorGanglios) {
        this.dorGanglios = dorGanglios;
    }

    public String getAderencia() {
        return aderencia;
    }

    public void setAderencia(String aderencia) {
        this.aderencia = aderencia;
    }

    public String getOutrosDados() {
        return outrosDados;
    }

    public void setOutrosDados(String outrosDados) {
        this.outrosDados = outrosDados;
    }

    @XmlTransient
    public List<AmbPrescricaoMedica> getAmbPrescricaoMedicaList() {
        return ambPrescricaoMedicaList;
    }

    public void setAmbPrescricaoMedicaList(List<AmbPrescricaoMedica> ambPrescricaoMedicaList) {
        this.ambPrescricaoMedicaList = ambPrescricaoMedicaList;
    }

    @XmlTransient
    public List<AmbDiagnosticoHipotese> getAmbDiagnosticoHipoteseList() {
        return ambDiagnosticoHipoteseList;
    }

    public void setAmbDiagnosticoHipoteseList(List<AmbDiagnosticoHipotese> ambDiagnosticoHipoteseList) {
        this.ambDiagnosticoHipoteseList = ambDiagnosticoHipoteseList;
    }

    public RhFuncionario getFkIdFuncionario() {
        return fkIdFuncionario;
    }

    public void setFkIdFuncionario(RhFuncionario fkIdFuncionario) {
        this.fkIdFuncionario = fkIdFuncionario;
    }

    public AmbTriagem getFkPkIdTriagem() {
        return fkPkIdTriagem;
    }

    public void setFkPkIdTriagem(AmbTriagem fkPkIdTriagem) {
        this.fkPkIdTriagem = fkPkIdTriagem;
    }

    public AmbEstado getFkPkIdEstado() {
        return fkPkIdEstado;
    }

    public void setFkPkIdEstado(AmbEstado fkPkIdEstado) {
        this.fkPkIdEstado = fkPkIdEstado;
    }

    public AdmsServicoSolicitado getFkPkIdAdmsSolicitacaoServico() {
        return fkPkIdAdmsSolicitacaoServico;
    }

    public void setFkPkIdAdmsSolicitacaoServico(AdmsServicoSolicitado fkPkIdAdmsSolicitacaoServico) {
        this.fkPkIdAdmsSolicitacaoServico = fkPkIdAdmsSolicitacaoServico;
    }

    @XmlTransient
    public List<AmbConsultaRetorno> getAmbConsultaRetornoList() {
        return ambConsultaRetornoList;
    }

    public void setAmbConsultaRetornoList(List<AmbConsultaRetorno> ambConsultaRetornoList) {
        this.ambConsultaRetornoList = ambConsultaRetornoList;
    }

    @XmlTransient
    public List<AmbConsultaAsFarmaco> getAmbConsultaAsFarmacoList() {
        return ambConsultaAsFarmacoList;
    }

    public void setAmbConsultaAsFarmacoList(List<AmbConsultaAsFarmaco> ambConsultaAsFarmacoList) {
        this.ambConsultaAsFarmacoList = ambConsultaAsFarmacoList;
    }

    @XmlTransient
    public List<AmbAnamenese> getAmbAnameneseList() {
        return ambAnameneseList;
    }

    public void setAmbAnameneseList(List<AmbAnamenese> ambAnameneseList) {
        this.ambAnameneseList = ambAnameneseList;
    }

    @XmlTransient
    public List<AmbDiagnostico> getAmbDiagnosticoList() {
        return ambDiagnosticoList;
    }

    public void setAmbDiagnosticoList(List<AmbDiagnostico> ambDiagnosticoList) {
        this.ambDiagnosticoList = ambDiagnosticoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdConsulta != null ? pkIdConsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbConsulta)) {
            return false;
        }
        AmbConsulta other = (AmbConsulta) object;
        if ((this.pkIdConsulta == null && other.pkIdConsulta != null) || (this.pkIdConsulta != null && !this.pkIdConsulta.equals(other.pkIdConsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbConsulta[ pkIdConsulta=" + pkIdConsulta + " ]";
    }
    
}
