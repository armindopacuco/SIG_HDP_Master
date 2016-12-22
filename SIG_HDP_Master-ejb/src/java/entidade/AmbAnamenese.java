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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "amb_anamenese", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbAnamenese.findAll", query = "SELECT a FROM AmbAnamenese a"),
    @NamedQuery(name = "AmbAnamenese.findByPkIdAnamenese", query = "SELECT a FROM AmbAnamenese a WHERE a.pkIdAnamenese = :pkIdAnamenese"),
    @NamedQuery(name = "AmbAnamenese.findByAlergiaMedicacao", query = "SELECT a FROM AmbAnamenese a WHERE a.alergiaMedicacao = :alergiaMedicacao"),
    @NamedQuery(name = "AmbAnamenese.findByAlergiaAlimento", query = "SELECT a FROM AmbAnamenese a WHERE a.alergiaAlimento = :alergiaAlimento"),
    @NamedQuery(name = "AmbAnamenese.findByDescricaoAf", query = "SELECT a FROM AmbAnamenese a WHERE a.descricaoAf = :descricaoAf"),
    @NamedQuery(name = "AmbAnamenese.findByAmbGrauParentesco", query = "SELECT a FROM AmbAnamenese a WHERE a.ambGrauParentesco = :ambGrauParentesco"),
    @NamedQuery(name = "AmbAnamenese.findByInicioDoenca", query = "SELECT a FROM AmbAnamenese a WHERE a.inicioDoenca = :inicioDoenca"),
    @NamedQuery(name = "AmbAnamenese.findByPesoHabitual", query = "SELECT a FROM AmbAnamenese a WHERE a.pesoHabitual = :pesoHabitual"),
    @NamedQuery(name = "AmbAnamenese.findByDescricaoDoenca", query = "SELECT a FROM AmbAnamenese a WHERE a.descricaoDoenca = :descricaoDoenca"),
    @NamedQuery(name = "AmbAnamenese.findByDescricaoMedicamentoAf", query = "SELECT a FROM AmbAnamenese a WHERE a.descricaoMedicamentoAf = :descricaoMedicamentoAf"),
    @NamedQuery(name = "AmbAnamenese.findByDescricaoAp", query = "SELECT a FROM AmbAnamenese a WHERE a.descricaoAp = :descricaoAp"),
    @NamedQuery(name = "AmbAnamenese.findByComplicacoesPresentes", query = "SELECT a FROM AmbAnamenese a WHERE a.complicacoesPresentes = :complicacoesPresentes"),
    @NamedQuery(name = "AmbAnamenese.findByInfoAdicional", query = "SELECT a FROM AmbAnamenese a WHERE a.infoAdicional = :infoAdicional")})
public class AmbAnamenese implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_anamenese")
    private Integer pkIdAnamenese;
    @Size(max = 100)
    @Column(name = "alergia_medicacao")
    private String alergiaMedicacao;
    @Size(max = 100)
    @Column(name = "alergia_alimento")
    private String alergiaAlimento;
    @Size(max = 100)
    @Column(name = "descricao_af")
    private String descricaoAf;
    @Size(max = 100)
    @Column(name = "amb_grau_parentesco")
    private String ambGrauParentesco;
    @Size(max = 100)
    @Column(name = "inicio_doenca")
    private String inicioDoenca;
    @Size(max = 100)
    @Column(name = "peso_habitual")
    private String pesoHabitual;
    @Size(max = 100)
    @Column(name = "descricao_doenca")
    private String descricaoDoenca;
    @Size(max = 100)
    @Column(name = "descricao_medicamento_af")
    private String descricaoMedicamentoAf;
    @Size(max = 100)
    @Column(name = "descricao_ap")
    private String descricaoAp;
    @Size(max = 100)
    @Column(name = "complicacoes_presentes")
    private String complicacoesPresentes;
    @Size(max = 150)
    @Column(name = "info_adicional")
    private String infoAdicional;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdAnamnese")
    private List<AmbAnamneseAsGrau> ambAnamneseAsGrauList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdAnamnese")
    private List<AmbAnamneseAsComplicacaoPresente> ambAnamneseAsComplicacaoPresenteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdAnamnese")
    private List<AmbAnamneseAsAntecedentePessoal> ambAnamneseAsAntecedentePessoalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdAnamnese")
    private List<AmbAnamneseAsDoenca> ambAnamneseAsDoencaList;
    @JoinColumn(name = "fk_id_consulta", referencedColumnName = "pk_id_consulta")
    @ManyToOne(optional = false)
    private AmbConsulta fkIdConsulta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdAnamnese")
    private List<AmbAnamneseAsFarmaco> ambAnamneseAsFarmacoList;

    public AmbAnamenese() {
    }

    public AmbAnamenese(Integer pkIdAnamenese) {
        this.pkIdAnamenese = pkIdAnamenese;
    }

    public Integer getPkIdAnamenese() {
        return pkIdAnamenese;
    }

    public void setPkIdAnamenese(Integer pkIdAnamenese) {
        this.pkIdAnamenese = pkIdAnamenese;
    }

    public String getAlergiaMedicacao() {
        return alergiaMedicacao;
    }

    public void setAlergiaMedicacao(String alergiaMedicacao) {
        this.alergiaMedicacao = alergiaMedicacao;
    }

    public String getAlergiaAlimento() {
        return alergiaAlimento;
    }

    public void setAlergiaAlimento(String alergiaAlimento) {
        this.alergiaAlimento = alergiaAlimento;
    }

    public String getDescricaoAf() {
        return descricaoAf;
    }

    public void setDescricaoAf(String descricaoAf) {
        this.descricaoAf = descricaoAf;
    }

    public String getAmbGrauParentesco() {
        return ambGrauParentesco;
    }

    public void setAmbGrauParentesco(String ambGrauParentesco) {
        this.ambGrauParentesco = ambGrauParentesco;
    }

    public String getInicioDoenca() {
        return inicioDoenca;
    }

    public void setInicioDoenca(String inicioDoenca) {
        this.inicioDoenca = inicioDoenca;
    }

    public String getPesoHabitual() {
        return pesoHabitual;
    }

    public void setPesoHabitual(String pesoHabitual) {
        this.pesoHabitual = pesoHabitual;
    }

    public String getDescricaoDoenca() {
        return descricaoDoenca;
    }

    public void setDescricaoDoenca(String descricaoDoenca) {
        this.descricaoDoenca = descricaoDoenca;
    }

    public String getDescricaoMedicamentoAf() {
        return descricaoMedicamentoAf;
    }

    public void setDescricaoMedicamentoAf(String descricaoMedicamentoAf) {
        this.descricaoMedicamentoAf = descricaoMedicamentoAf;
    }

    public String getDescricaoAp() {
        return descricaoAp;
    }

    public void setDescricaoAp(String descricaoAp) {
        this.descricaoAp = descricaoAp;
    }

    public String getComplicacoesPresentes() {
        return complicacoesPresentes;
    }

    public void setComplicacoesPresentes(String complicacoesPresentes) {
        this.complicacoesPresentes = complicacoesPresentes;
    }

    public String getInfoAdicional() {
        return infoAdicional;
    }

    public void setInfoAdicional(String infoAdicional) {
        this.infoAdicional = infoAdicional;
    }

    @XmlTransient
    public List<AmbAnamneseAsGrau> getAmbAnamneseAsGrauList() {
        return ambAnamneseAsGrauList;
    }

    public void setAmbAnamneseAsGrauList(List<AmbAnamneseAsGrau> ambAnamneseAsGrauList) {
        this.ambAnamneseAsGrauList = ambAnamneseAsGrauList;
    }

    @XmlTransient
    public List<AmbAnamneseAsComplicacaoPresente> getAmbAnamneseAsComplicacaoPresenteList() {
        return ambAnamneseAsComplicacaoPresenteList;
    }

    public void setAmbAnamneseAsComplicacaoPresenteList(List<AmbAnamneseAsComplicacaoPresente> ambAnamneseAsComplicacaoPresenteList) {
        this.ambAnamneseAsComplicacaoPresenteList = ambAnamneseAsComplicacaoPresenteList;
    }

    @XmlTransient
    public List<AmbAnamneseAsAntecedentePessoal> getAmbAnamneseAsAntecedentePessoalList() {
        return ambAnamneseAsAntecedentePessoalList;
    }

    public void setAmbAnamneseAsAntecedentePessoalList(List<AmbAnamneseAsAntecedentePessoal> ambAnamneseAsAntecedentePessoalList) {
        this.ambAnamneseAsAntecedentePessoalList = ambAnamneseAsAntecedentePessoalList;
    }

    @XmlTransient
    public List<AmbAnamneseAsDoenca> getAmbAnamneseAsDoencaList() {
        return ambAnamneseAsDoencaList;
    }

    public void setAmbAnamneseAsDoencaList(List<AmbAnamneseAsDoenca> ambAnamneseAsDoencaList) {
        this.ambAnamneseAsDoencaList = ambAnamneseAsDoencaList;
    }

    public AmbConsulta getFkIdConsulta() {
        return fkIdConsulta;
    }

    public void setFkIdConsulta(AmbConsulta fkIdConsulta) {
        this.fkIdConsulta = fkIdConsulta;
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
        hash += (pkIdAnamenese != null ? pkIdAnamenese.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbAnamenese)) {
            return false;
        }
        AmbAnamenese other = (AmbAnamenese) object;
        if ((this.pkIdAnamenese == null && other.pkIdAnamenese != null) || (this.pkIdAnamenese != null && !this.pkIdAnamenese.equals(other.pkIdAnamenese))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.AmbAnamenese[ pkIdAnamenese=" + pkIdAnamenese + " ]";
    }
    
}
