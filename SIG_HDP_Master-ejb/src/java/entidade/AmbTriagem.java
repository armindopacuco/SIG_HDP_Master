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
@Table(name = "amb_triagem", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbTriagem.findAll", query = "SELECT a FROM AmbTriagem a"),
    @NamedQuery(name = "AmbTriagem.findByPkIdTriagem", query = "SELECT a FROM AmbTriagem a WHERE a.pkIdTriagem = :pkIdTriagem"),
    @NamedQuery(name = "AmbTriagem.findByTemperatura", query = "SELECT a FROM AmbTriagem a WHERE a.temperatura = :temperatura"),
    @NamedQuery(name = "AmbTriagem.findByPulso", query = "SELECT a FROM AmbTriagem a WHERE a.pulso = :pulso"),
    @NamedQuery(name = "AmbTriagem.findByFrequenciaRespiratoria", query = "SELECT a FROM AmbTriagem a WHERE a.frequenciaRespiratoria = :frequenciaRespiratoria"),
    @NamedQuery(name = "AmbTriagem.findByFrequenciaCardiaca", query = "SELECT a FROM AmbTriagem a WHERE a.frequenciaCardiaca = :frequenciaCardiaca"),
    @NamedQuery(name = "AmbTriagem.findByPeso", query = "SELECT a FROM AmbTriagem a WHERE a.peso = :peso"),
    @NamedQuery(name = "AmbTriagem.findByAltura", query = "SELECT a FROM AmbTriagem a WHERE a.altura = :altura"),
    @NamedQuery(name = "AmbTriagem.findByGlicemia", query = "SELECT a FROM AmbTriagem a WHERE a.glicemia = :glicemia"),
    @NamedQuery(name = "AmbTriagem.findByDataHoraTriagem", query = "SELECT a FROM AmbTriagem a WHERE a.dataHoraTriagem = :dataHoraTriagem"),
    @NamedQuery(name = "AmbTriagem.findByFazTriagem", query = "SELECT a FROM AmbTriagem a WHERE a.fazTriagem = :fazTriagem"),
    @NamedQuery(name = "AmbTriagem.findByObservacoes", query = "SELECT a FROM AmbTriagem a WHERE a.observacoes = :observacoes"),
    @NamedQuery(name = "AmbTriagem.findByFkIdServicoSolicitado", query = "SELECT a FROM AmbTriagem a WHERE a.fkIdServicoSolicitado = :fkIdServicoSolicitado")})
public class AmbTriagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_triagem")
    private Integer pkIdTriagem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "temperatura")
    private double temperatura;
    @Column(name = "pulso")
    private Integer pulso;
    @Size(max = 100)
    @Column(name = "frequencia_respiratoria")
    private String frequenciaRespiratoria;
    @Size(max = 100)
    @Column(name = "frequencia_cardiaca")
    private String frequenciaCardiaca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso")
    private int peso;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "altura")
    private Double altura;
    @Size(max = 100)
    @Column(name = "glicemia")
    private String glicemia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_hora_triagem")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraTriagem;
    @Size(max = 500)
    @Column(name = "faz_triagem")
    private String fazTriagem;
    @Size(max = 500)
    @Column(name = "observacoes")
    private String observacoes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_id_servico_solicitado")
    private int fkIdServicoSolicitado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPkIdTriagem")
    private List<AmbTriagemAsSinal> ambTriagemAsSinalList;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne(optional = false)
    private RhFuncionario fkIdFuncionario;
    @JoinColumn(name = "fk_pk_id_estado", referencedColumnName = "pk_id_estado")
    @ManyToOne(optional = false)
    private AmbEstado fkPkIdEstado;
    @OneToMany(mappedBy = "fkPkIdTriagem")
    private List<AmbConsulta> ambConsultaList;

    public AmbTriagem() {
    }

    public AmbTriagem(Integer pkIdTriagem) {
        this.pkIdTriagem = pkIdTriagem;
    }

    public AmbTriagem(Integer pkIdTriagem, double temperatura, int peso, Date dataHoraTriagem, int fkIdServicoSolicitado) {
        this.pkIdTriagem = pkIdTriagem;
        this.temperatura = temperatura;
        this.peso = peso;
        this.dataHoraTriagem = dataHoraTriagem;
        this.fkIdServicoSolicitado = fkIdServicoSolicitado;
    }

    public Integer getPkIdTriagem() {
        return pkIdTriagem;
    }

    public void setPkIdTriagem(Integer pkIdTriagem) {
        this.pkIdTriagem = pkIdTriagem;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public Integer getPulso() {
        return pulso;
    }

    public void setPulso(Integer pulso) {
        this.pulso = pulso;
    }

    public String getFrequenciaRespiratoria() {
        return frequenciaRespiratoria;
    }

    public void setFrequenciaRespiratoria(String frequenciaRespiratoria) {
        this.frequenciaRespiratoria = frequenciaRespiratoria;
    }

    public String getFrequenciaCardiaca() {
        return frequenciaCardiaca;
    }

    public void setFrequenciaCardiaca(String frequenciaCardiaca) {
        this.frequenciaCardiaca = frequenciaCardiaca;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public String getGlicemia() {
        return glicemia;
    }

    public void setGlicemia(String glicemia) {
        this.glicemia = glicemia;
    }

    public Date getDataHoraTriagem() {
        return dataHoraTriagem;
    }

    public void setDataHoraTriagem(Date dataHoraTriagem) {
        this.dataHoraTriagem = dataHoraTriagem;
    }

    public String getFazTriagem() {
        return fazTriagem;
    }

    public void setFazTriagem(String fazTriagem) {
        this.fazTriagem = fazTriagem;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public int getFkIdServicoSolicitado() {
        return fkIdServicoSolicitado;
    }

    public void setFkIdServicoSolicitado(int fkIdServicoSolicitado) {
        this.fkIdServicoSolicitado = fkIdServicoSolicitado;
    }

    @XmlTransient
    public List<AmbTriagemAsSinal> getAmbTriagemAsSinalList() {
        return ambTriagemAsSinalList;
    }

    public void setAmbTriagemAsSinalList(List<AmbTriagemAsSinal> ambTriagemAsSinalList) {
        this.ambTriagemAsSinalList = ambTriagemAsSinalList;
    }

    public RhFuncionario getFkIdFuncionario() {
        return fkIdFuncionario;
    }

    public void setFkIdFuncionario(RhFuncionario fkIdFuncionario) {
        this.fkIdFuncionario = fkIdFuncionario;
    }

    public AmbEstado getFkPkIdEstado() {
        return fkPkIdEstado;
    }

    public void setFkPkIdEstado(AmbEstado fkPkIdEstado) {
        this.fkPkIdEstado = fkPkIdEstado;
    }

    @XmlTransient
    public List<AmbConsulta> getAmbConsultaList() {
        return ambConsultaList;
    }

    public void setAmbConsultaList(List<AmbConsulta> ambConsultaList) {
        this.ambConsultaList = ambConsultaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdTriagem != null ? pkIdTriagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbTriagem)) {
            return false;
        }
        AmbTriagem other = (AmbTriagem) object;
        if ((this.pkIdTriagem == null && other.pkIdTriagem != null) || (this.pkIdTriagem != null && !this.pkIdTriagem.equals(other.pkIdTriagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbTriagem[ pkIdTriagem=" + pkIdTriagem + " ]";
    }
    
}
