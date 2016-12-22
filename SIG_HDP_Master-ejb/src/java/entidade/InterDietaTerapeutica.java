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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "inter_dieta_terapeutica", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterDietaTerapeutica.findAll", query = "SELECT i FROM InterDietaTerapeutica i"),
    @NamedQuery(name = "InterDietaTerapeutica.findByPkIdMsDietaTerapeutica", query = "SELECT i FROM InterDietaTerapeutica i WHERE i.pkIdMsDietaTerapeutica = :pkIdMsDietaTerapeutica"),
    @NamedQuery(name = "InterDietaTerapeutica.findByData", query = "SELECT i FROM InterDietaTerapeutica i WHERE i.data = :data"),
    @NamedQuery(name = "InterDietaTerapeutica.findByFase", query = "SELECT i FROM InterDietaTerapeutica i WHERE i.fase = :fase"),
    @NamedQuery(name = "InterDietaTerapeutica.findByAlimento", query = "SELECT i FROM InterDietaTerapeutica i WHERE i.alimento = :alimento"),
    @NamedQuery(name = "InterDietaTerapeutica.findByMlRefeicao", query = "SELECT i FROM InterDietaTerapeutica i WHERE i.mlRefeicao = :mlRefeicao"),
    @NamedQuery(name = "InterDietaTerapeutica.findByNRefeicaoDia", query = "SELECT i FROM InterDietaTerapeutica i WHERE i.nRefeicaoDia = :nRefeicaoDia"),
    @NamedQuery(name = "InterDietaTerapeutica.findByMlDia", query = "SELECT i FROM InterDietaTerapeutica i WHERE i.mlDia = :mlDia"),
    @NamedQuery(name = "InterDietaTerapeutica.findByFerro", query = "SELECT i FROM InterDietaTerapeutica i WHERE i.ferro = :ferro"),
    @NamedQuery(name = "InterDietaTerapeutica.findByFerroQuantidadeTomada", query = "SELECT i FROM InterDietaTerapeutica i WHERE i.ferroQuantidadeTomada = :ferroQuantidadeTomada"),
    @NamedQuery(name = "InterDietaTerapeutica.findByPapa", query = "SELECT i FROM InterDietaTerapeutica i WHERE i.papa = :papa"),
    @NamedQuery(name = "InterDietaTerapeutica.findByOutros", query = "SELECT i FROM InterDietaTerapeutica i WHERE i.outros = :outros")})
public class InterDietaTerapeutica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_ms_dieta_terapeutica")
    private Integer pkIdMsDietaTerapeutica;
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Size(max = 45)
    @Column(name = "fase")
    private String fase;
    @Column(name = "alimento")
    private Integer alimento;
    @Size(max = 45)
    @Column(name = "ml_refeicao")
    private String mlRefeicao;
    @Column(name = "n_refeicao_dia")
    private Integer nRefeicaoDia;
    @Size(max = 45)
    @Column(name = "ml_dia")
    private String mlDia;
    @Size(max = 45)
    @Column(name = "ferro")
    private String ferro;
    @Size(max = 45)
    @Column(name = "ferro_quantidade_tomada")
    private String ferroQuantidadeTomada;
    @Size(max = 45)
    @Column(name = "papa")
    private String papa;
    @Size(max = 45)
    @Column(name = "outros")
    private String outros;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne
    private RhFuncionario fkIdFuncionario;
    @JoinColumn(name = "fk_id_registo_internamento", referencedColumnName = "pk_id_registo_internamento")
    @ManyToOne(optional = false)
    private InterRegistoInternamento fkIdRegistoInternamento;

    public InterDietaTerapeutica() {
    }

    public InterDietaTerapeutica(Integer pkIdMsDietaTerapeutica) {
        this.pkIdMsDietaTerapeutica = pkIdMsDietaTerapeutica;
    }

    public Integer getPkIdMsDietaTerapeutica() {
        return pkIdMsDietaTerapeutica;
    }

    public void setPkIdMsDietaTerapeutica(Integer pkIdMsDietaTerapeutica) {
        this.pkIdMsDietaTerapeutica = pkIdMsDietaTerapeutica;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public Integer getAlimento() {
        return alimento;
    }

    public void setAlimento(Integer alimento) {
        this.alimento = alimento;
    }

    public String getMlRefeicao() {
        return mlRefeicao;
    }

    public void setMlRefeicao(String mlRefeicao) {
        this.mlRefeicao = mlRefeicao;
    }

    public Integer getNRefeicaoDia() {
        return nRefeicaoDia;
    }

    public void setNRefeicaoDia(Integer nRefeicaoDia) {
        this.nRefeicaoDia = nRefeicaoDia;
    }

    public String getMlDia() {
        return mlDia;
    }

    public void setMlDia(String mlDia) {
        this.mlDia = mlDia;
    }

    public String getFerro() {
        return ferro;
    }

    public void setFerro(String ferro) {
        this.ferro = ferro;
    }

    public String getFerroQuantidadeTomada() {
        return ferroQuantidadeTomada;
    }

    public void setFerroQuantidadeTomada(String ferroQuantidadeTomada) {
        this.ferroQuantidadeTomada = ferroQuantidadeTomada;
    }

    public String getPapa() {
        return papa;
    }

    public void setPapa(String papa) {
        this.papa = papa;
    }

    public String getOutros() {
        return outros;
    }

    public void setOutros(String outros) {
        this.outros = outros;
    }

    public RhFuncionario getFkIdFuncionario() {
        return fkIdFuncionario;
    }

    public void setFkIdFuncionario(RhFuncionario fkIdFuncionario) {
        this.fkIdFuncionario = fkIdFuncionario;
    }

    public InterRegistoInternamento getFkIdRegistoInternamento() {
        return fkIdRegistoInternamento;
    }

    public void setFkIdRegistoInternamento(InterRegistoInternamento fkIdRegistoInternamento) {
        this.fkIdRegistoInternamento = fkIdRegistoInternamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdMsDietaTerapeutica != null ? pkIdMsDietaTerapeutica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterDietaTerapeutica)) {
            return false;
        }
        InterDietaTerapeutica other = (InterDietaTerapeutica) object;
        if ((this.pkIdMsDietaTerapeutica == null && other.pkIdMsDietaTerapeutica != null) || (this.pkIdMsDietaTerapeutica != null && !this.pkIdMsDietaTerapeutica.equals(other.pkIdMsDietaTerapeutica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.InterDietaTerapeutica[ pkIdMsDietaTerapeutica=" + pkIdMsDietaTerapeutica + " ]";
    }
    
}
