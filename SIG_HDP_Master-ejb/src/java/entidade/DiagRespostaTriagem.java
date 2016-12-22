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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "diag_resposta_triagem", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagRespostaTriagem.findAll", query = "SELECT d FROM DiagRespostaTriagem d"),
    @NamedQuery(name = "DiagRespostaTriagem.findByPkIdRespostaTriagem", query = "SELECT d FROM DiagRespostaTriagem d WHERE d.pkIdRespostaTriagem = :pkIdRespostaTriagem"),
    @NamedQuery(name = "DiagRespostaTriagem.findByDescricaoRespostaTriagem", query = "SELECT d FROM DiagRespostaTriagem d WHERE d.descricaoRespostaTriagem = :descricaoRespostaTriagem")})
public class DiagRespostaTriagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_resposta_triagem")
    private Integer pkIdRespostaTriagem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao_resposta_triagem")
    private String descricaoRespostaTriagem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pergunta")
    private List<DiagResultado> diagResultadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gravida")
    private List<DiagTriagem> diagTriagemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toxicoDependente")
    private List<DiagTriagem> diagTriagemList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sono")
    private List<DiagTriagem> diagTriagemList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parceiros")
    private List<DiagTriagem> diagTriagemList3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peso")
    private List<DiagTriagem> diagTriagemList4;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ultimaDoacao")
    private List<DiagTriagem> diagTriagemList5;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hepatite")
    private List<DiagTriagem> diagTriagemList6;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "epilepsia")
    private List<DiagTriagem> diagTriagemList7;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sifilis")
    private List<DiagTriagem> diagTriagemList8;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tatuagem")
    private List<DiagTriagem> diagTriagemList9;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transfusao")
    private List<DiagTriagem> diagTriagemList10;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alimentacao")
    private List<DiagTriagem> diagTriagemList11;

    public DiagRespostaTriagem() {
    }

    public DiagRespostaTriagem(Integer pkIdRespostaTriagem) {
        this.pkIdRespostaTriagem = pkIdRespostaTriagem;
    }

    public DiagRespostaTriagem(Integer pkIdRespostaTriagem, String descricaoRespostaTriagem) {
        this.pkIdRespostaTriagem = pkIdRespostaTriagem;
        this.descricaoRespostaTriagem = descricaoRespostaTriagem;
    }

    public Integer getPkIdRespostaTriagem() {
        return pkIdRespostaTriagem;
    }

    public void setPkIdRespostaTriagem(Integer pkIdRespostaTriagem) {
        this.pkIdRespostaTriagem = pkIdRespostaTriagem;
    }

    public String getDescricaoRespostaTriagem() {
        return descricaoRespostaTriagem;
    }

    public void setDescricaoRespostaTriagem(String descricaoRespostaTriagem) {
        this.descricaoRespostaTriagem = descricaoRespostaTriagem;
    }

    @XmlTransient
    public List<DiagResultado> getDiagResultadoList() {
        return diagResultadoList;
    }

    public void setDiagResultadoList(List<DiagResultado> diagResultadoList) {
        this.diagResultadoList = diagResultadoList;
    }

    @XmlTransient
    public List<DiagTriagem> getDiagTriagemList() {
        return diagTriagemList;
    }

    public void setDiagTriagemList(List<DiagTriagem> diagTriagemList) {
        this.diagTriagemList = diagTriagemList;
    }

    @XmlTransient
    public List<DiagTriagem> getDiagTriagemList1() {
        return diagTriagemList1;
    }

    public void setDiagTriagemList1(List<DiagTriagem> diagTriagemList1) {
        this.diagTriagemList1 = diagTriagemList1;
    }

    @XmlTransient
    public List<DiagTriagem> getDiagTriagemList2() {
        return diagTriagemList2;
    }

    public void setDiagTriagemList2(List<DiagTriagem> diagTriagemList2) {
        this.diagTriagemList2 = diagTriagemList2;
    }

    @XmlTransient
    public List<DiagTriagem> getDiagTriagemList3() {
        return diagTriagemList3;
    }

    public void setDiagTriagemList3(List<DiagTriagem> diagTriagemList3) {
        this.diagTriagemList3 = diagTriagemList3;
    }

    @XmlTransient
    public List<DiagTriagem> getDiagTriagemList4() {
        return diagTriagemList4;
    }

    public void setDiagTriagemList4(List<DiagTriagem> diagTriagemList4) {
        this.diagTriagemList4 = diagTriagemList4;
    }

    @XmlTransient
    public List<DiagTriagem> getDiagTriagemList5() {
        return diagTriagemList5;
    }

    public void setDiagTriagemList5(List<DiagTriagem> diagTriagemList5) {
        this.diagTriagemList5 = diagTriagemList5;
    }

    @XmlTransient
    public List<DiagTriagem> getDiagTriagemList6() {
        return diagTriagemList6;
    }

    public void setDiagTriagemList6(List<DiagTriagem> diagTriagemList6) {
        this.diagTriagemList6 = diagTriagemList6;
    }

    @XmlTransient
    public List<DiagTriagem> getDiagTriagemList7() {
        return diagTriagemList7;
    }

    public void setDiagTriagemList7(List<DiagTriagem> diagTriagemList7) {
        this.diagTriagemList7 = diagTriagemList7;
    }

    @XmlTransient
    public List<DiagTriagem> getDiagTriagemList8() {
        return diagTriagemList8;
    }

    public void setDiagTriagemList8(List<DiagTriagem> diagTriagemList8) {
        this.diagTriagemList8 = diagTriagemList8;
    }

    @XmlTransient
    public List<DiagTriagem> getDiagTriagemList9() {
        return diagTriagemList9;
    }

    public void setDiagTriagemList9(List<DiagTriagem> diagTriagemList9) {
        this.diagTriagemList9 = diagTriagemList9;
    }

    @XmlTransient
    public List<DiagTriagem> getDiagTriagemList10() {
        return diagTriagemList10;
    }

    public void setDiagTriagemList10(List<DiagTriagem> diagTriagemList10) {
        this.diagTriagemList10 = diagTriagemList10;
    }

    @XmlTransient
    public List<DiagTriagem> getDiagTriagemList11() {
        return diagTriagemList11;
    }

    public void setDiagTriagemList11(List<DiagTriagem> diagTriagemList11) {
        this.diagTriagemList11 = diagTriagemList11;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdRespostaTriagem != null ? pkIdRespostaTriagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagRespostaTriagem)) {
            return false;
        }
        DiagRespostaTriagem other = (DiagRespostaTriagem) object;
        if ((this.pkIdRespostaTriagem == null && other.pkIdRespostaTriagem != null) || (this.pkIdRespostaTriagem != null && !this.pkIdRespostaTriagem.equals(other.pkIdRespostaTriagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.DiagRespostaTriagem[ pkIdRespostaTriagem=" + pkIdRespostaTriagem + " ]";
    }
    
}
