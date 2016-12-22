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
@Table(name = "diag_triagem", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagTriagem.findAll", query = "SELECT d FROM DiagTriagem d"),
    @NamedQuery(name = "DiagTriagem.findByPkIdTriagem", query = "SELECT d FROM DiagTriagem d WHERE d.pkIdTriagem = :pkIdTriagem"),
    @NamedQuery(name = "DiagTriagem.findByFkIdCandidatoDador", query = "SELECT d FROM DiagTriagem d WHERE d.fkIdCandidatoDador = :fkIdCandidatoDador")})
public class DiagTriagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_triagem")
    private Integer pkIdTriagem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_id_candidato_dador")
    private int fkIdCandidatoDador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdTriagem")
    private List<DiagExameDador> diagExameDadorList;
    @JoinColumn(name = "fk_id_resultado_triagem", referencedColumnName = "pk_id_resultado_triagem")
    @ManyToOne(optional = false)
    private DiagResultadoTriagem fkIdResultadoTriagem;
    @JoinColumn(name = "gravida", referencedColumnName = "pk_id_resposta_triagem")
    @ManyToOne(optional = false)
    private DiagRespostaTriagem gravida;
    @JoinColumn(name = "toxico_dependente", referencedColumnName = "pk_id_resposta_triagem")
    @ManyToOne(optional = false)
    private DiagRespostaTriagem toxicoDependente;
    @JoinColumn(name = "sono", referencedColumnName = "pk_id_resposta_triagem")
    @ManyToOne(optional = false)
    private DiagRespostaTriagem sono;
    @JoinColumn(name = "parceiros", referencedColumnName = "pk_id_resposta_triagem")
    @ManyToOne(optional = false)
    private DiagRespostaTriagem parceiros;
    @JoinColumn(name = "peso", referencedColumnName = "pk_id_resposta_triagem")
    @ManyToOne(optional = false)
    private DiagRespostaTriagem peso;
    @JoinColumn(name = "ultima_doacao", referencedColumnName = "pk_id_resposta_triagem")
    @ManyToOne(optional = false)
    private DiagRespostaTriagem ultimaDoacao;
    @JoinColumn(name = "hepatite", referencedColumnName = "pk_id_resposta_triagem")
    @ManyToOne(optional = false)
    private DiagRespostaTriagem hepatite;
    @JoinColumn(name = "epilepsia", referencedColumnName = "pk_id_resposta_triagem")
    @ManyToOne(optional = false)
    private DiagRespostaTriagem epilepsia;
    @JoinColumn(name = "sifilis", referencedColumnName = "pk_id_resposta_triagem")
    @ManyToOne(optional = false)
    private DiagRespostaTriagem sifilis;
    @JoinColumn(name = "tatuagem", referencedColumnName = "pk_id_resposta_triagem")
    @ManyToOne(optional = false)
    private DiagRespostaTriagem tatuagem;
    @JoinColumn(name = "transfusao", referencedColumnName = "pk_id_resposta_triagem")
    @ManyToOne(optional = false)
    private DiagRespostaTriagem transfusao;
    @JoinColumn(name = "alimentacao", referencedColumnName = "pk_id_resposta_triagem")
    @ManyToOne(optional = false)
    private DiagRespostaTriagem alimentacao;
    @OneToMany(mappedBy = "fkIdTriagem")
    private List<DiagDador> diagDadorList;

    public DiagTriagem() {
    }

    public DiagTriagem(Integer pkIdTriagem) {
        this.pkIdTriagem = pkIdTriagem;
    }

    public DiagTriagem(Integer pkIdTriagem, int fkIdCandidatoDador) {
        this.pkIdTriagem = pkIdTriagem;
        this.fkIdCandidatoDador = fkIdCandidatoDador;
    }

    public Integer getPkIdTriagem() {
        return pkIdTriagem;
    }

    public void setPkIdTriagem(Integer pkIdTriagem) {
        this.pkIdTriagem = pkIdTriagem;
    }

    public int getFkIdCandidatoDador() {
        return fkIdCandidatoDador;
    }

    public void setFkIdCandidatoDador(int fkIdCandidatoDador) {
        this.fkIdCandidatoDador = fkIdCandidatoDador;
    }

    @XmlTransient
    public List<DiagExameDador> getDiagExameDadorList() {
        return diagExameDadorList;
    }

    public void setDiagExameDadorList(List<DiagExameDador> diagExameDadorList) {
        this.diagExameDadorList = diagExameDadorList;
    }

    public DiagResultadoTriagem getFkIdResultadoTriagem() {
        return fkIdResultadoTriagem;
    }

    public void setFkIdResultadoTriagem(DiagResultadoTriagem fkIdResultadoTriagem) {
        this.fkIdResultadoTriagem = fkIdResultadoTriagem;
    }

    public DiagRespostaTriagem getGravida() {
        return gravida;
    }

    public void setGravida(DiagRespostaTriagem gravida) {
        this.gravida = gravida;
    }

    public DiagRespostaTriagem getToxicoDependente() {
        return toxicoDependente;
    }

    public void setToxicoDependente(DiagRespostaTriagem toxicoDependente) {
        this.toxicoDependente = toxicoDependente;
    }

    public DiagRespostaTriagem getSono() {
        return sono;
    }

    public void setSono(DiagRespostaTriagem sono) {
        this.sono = sono;
    }

    public DiagRespostaTriagem getParceiros() {
        return parceiros;
    }

    public void setParceiros(DiagRespostaTriagem parceiros) {
        this.parceiros = parceiros;
    }

    public DiagRespostaTriagem getPeso() {
        return peso;
    }

    public void setPeso(DiagRespostaTriagem peso) {
        this.peso = peso;
    }

    public DiagRespostaTriagem getUltimaDoacao() {
        return ultimaDoacao;
    }

    public void setUltimaDoacao(DiagRespostaTriagem ultimaDoacao) {
        this.ultimaDoacao = ultimaDoacao;
    }

    public DiagRespostaTriagem getHepatite() {
        return hepatite;
    }

    public void setHepatite(DiagRespostaTriagem hepatite) {
        this.hepatite = hepatite;
    }

    public DiagRespostaTriagem getEpilepsia() {
        return epilepsia;
    }

    public void setEpilepsia(DiagRespostaTriagem epilepsia) {
        this.epilepsia = epilepsia;
    }

    public DiagRespostaTriagem getSifilis() {
        return sifilis;
    }

    public void setSifilis(DiagRespostaTriagem sifilis) {
        this.sifilis = sifilis;
    }

    public DiagRespostaTriagem getTatuagem() {
        return tatuagem;
    }

    public void setTatuagem(DiagRespostaTriagem tatuagem) {
        this.tatuagem = tatuagem;
    }

    public DiagRespostaTriagem getTransfusao() {
        return transfusao;
    }

    public void setTransfusao(DiagRespostaTriagem transfusao) {
        this.transfusao = transfusao;
    }

    public DiagRespostaTriagem getAlimentacao() {
        return alimentacao;
    }

    public void setAlimentacao(DiagRespostaTriagem alimentacao) {
        this.alimentacao = alimentacao;
    }

    @XmlTransient
    public List<DiagDador> getDiagDadorList() {
        return diagDadorList;
    }

    public void setDiagDadorList(List<DiagDador> diagDadorList) {
        this.diagDadorList = diagDadorList;
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
        if (!(object instanceof DiagTriagem)) {
            return false;
        }
        DiagTriagem other = (DiagTriagem) object;
        if ((this.pkIdTriagem == null && other.pkIdTriagem != null) || (this.pkIdTriagem != null && !this.pkIdTriagem.equals(other.pkIdTriagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.DiagTriagem[ pkIdTriagem=" + pkIdTriagem + " ]";
    }
    
}
