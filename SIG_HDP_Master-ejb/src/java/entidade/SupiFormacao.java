/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "supi_formacao", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupiFormacao.findAll", query = "SELECT s FROM SupiFormacao s"),
    @NamedQuery(name = "SupiFormacao.findByDescricaoFormacao", query = "SELECT s FROM SupiFormacao s WHERE s.descricaoFormacao = :descricaoFormacao"),
    @NamedQuery(name = "SupiFormacao.findByDataInicio", query = "SELECT s FROM SupiFormacao s WHERE s.dataInicio = :dataInicio"),
    @NamedQuery(name = "SupiFormacao.findByDataTermino", query = "SELECT s FROM SupiFormacao s WHERE s.dataTermino = :dataTermino"),
    @NamedQuery(name = "SupiFormacao.findByCargaHorariaDiaria", query = "SELECT s FROM SupiFormacao s WHERE s.cargaHorariaDiaria = :cargaHorariaDiaria"),
    @NamedQuery(name = "SupiFormacao.findByDataCadastro", query = "SELECT s FROM SupiFormacao s WHERE s.dataCadastro = :dataCadastro"),
    @NamedQuery(name = "SupiFormacao.findByTema", query = "SELECT s FROM SupiFormacao s WHERE s.tema = :tema"),
    @NamedQuery(name = "SupiFormacao.findByPkIdFormacao", query = "SELECT s FROM SupiFormacao s WHERE s.pkIdFormacao = :pkIdFormacao")})
public class SupiFormacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 100)
    @Column(name = "descricao_formacao")
    private String descricaoFormacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_termino")
    @Temporal(TemporalType.DATE)
    private Date dataTermino;
    @Basic(optional = false)
    @NotNull
    @Column(name = "carga_horaria_diaria")
    private int cargaHorariaDiaria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Size(max = 100)
    @Column(name = "tema")
    private String tema;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_formacao")
    private Integer pkIdFormacao;
    @JoinColumn(name = "fk_id_formador", referencedColumnName = "pk_id_formador")
    @ManyToOne(optional = false)
    private SupiFormador fkIdFormador;
    @JoinColumn(name = "fk_id_endereco", referencedColumnName = "pk_id_endereco")
    @ManyToOne(optional = false)
    private GrlEndereco fkIdEndereco;

    public SupiFormacao() {
    }

    public SupiFormacao(Integer pkIdFormacao) {
        this.pkIdFormacao = pkIdFormacao;
    }

    public SupiFormacao(Integer pkIdFormacao, Date dataInicio, Date dataTermino, int cargaHorariaDiaria, Date dataCadastro) {
        this.pkIdFormacao = pkIdFormacao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.cargaHorariaDiaria = cargaHorariaDiaria;
        this.dataCadastro = dataCadastro;
    }

    public String getDescricaoFormacao() {
        return descricaoFormacao;
    }

    public void setDescricaoFormacao(String descricaoFormacao) {
        this.descricaoFormacao = descricaoFormacao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public int getCargaHorariaDiaria() {
        return cargaHorariaDiaria;
    }

    public void setCargaHorariaDiaria(int cargaHorariaDiaria) {
        this.cargaHorariaDiaria = cargaHorariaDiaria;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Integer getPkIdFormacao() {
        return pkIdFormacao;
    }

    public void setPkIdFormacao(Integer pkIdFormacao) {
        this.pkIdFormacao = pkIdFormacao;
    }

    public SupiFormador getFkIdFormador() {
        return fkIdFormador;
    }

    public void setFkIdFormador(SupiFormador fkIdFormador) {
        this.fkIdFormador = fkIdFormador;
    }

    public GrlEndereco getFkIdEndereco() {
        return fkIdEndereco;
    }

    public void setFkIdEndereco(GrlEndereco fkIdEndereco) {
        this.fkIdEndereco = fkIdEndereco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdFormacao != null ? pkIdFormacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupiFormacao)) {
            return false;
        }
        SupiFormacao other = (SupiFormacao) object;
        if ((this.pkIdFormacao == null && other.pkIdFormacao != null) || (this.pkIdFormacao != null && !this.pkIdFormacao.equals(other.pkIdFormacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.SupiFormacao[ pkIdFormacao=" + pkIdFormacao + " ]";
    }
    
}
