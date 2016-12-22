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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "grl_ficheiro_anexado", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrlFicheiroAnexado.findAll", query = "SELECT g FROM GrlFicheiroAnexado g"),
    @NamedQuery(name = "GrlFicheiroAnexado.findByPkIdFicheiroAnexado", query = "SELECT g FROM GrlFicheiroAnexado g WHERE g.pkIdFicheiroAnexado = :pkIdFicheiroAnexado"),
    @NamedQuery(name = "GrlFicheiroAnexado.findByFicheiro", query = "SELECT g FROM GrlFicheiroAnexado g WHERE g.ficheiro = :ficheiro")})
public class GrlFicheiroAnexado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_ficheiro_anexado")
    private Integer pkIdFicheiroAnexado;
    @Size(max = 150)
    @Column(name = "ficheiro")
    private String ficheiro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdFoto")
    private List<GrlPessoa> grlPessoaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdBi")
    private List<RhCandidato> rhCandidatoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdDocMilitar")
    private List<RhCandidato> rhCandidatoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdCurriculumVitae")
    private List<RhCandidato> rhCandidatoList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdCertificadoHabilitacoes")
    private List<RhCandidato> rhCandidatoList3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdCedulaCarteira")
    private List<RhCandidato> rhCandidatoList4;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkRegistoCriminal")
    private List<RhCandidato> rhCandidatoList5;
    @OneToMany(mappedBy = "fkIdFoto")
    private List<FarmMaterialSanitario> farmMaterialSanitarioList;

    public GrlFicheiroAnexado() {
    }

    public GrlFicheiroAnexado(Integer pkIdFicheiroAnexado) {
        this.pkIdFicheiroAnexado = pkIdFicheiroAnexado;
    }

    public Integer getPkIdFicheiroAnexado() {
        return pkIdFicheiroAnexado;
    }

    public void setPkIdFicheiroAnexado(Integer pkIdFicheiroAnexado) {
        this.pkIdFicheiroAnexado = pkIdFicheiroAnexado;
    }

    public String getFicheiro() {
        return ficheiro;
    }

    public void setFicheiro(String ficheiro) {
        this.ficheiro = ficheiro;
    }

    @XmlTransient
    public List<GrlPessoa> getGrlPessoaList() {
        return grlPessoaList;
    }

    public void setGrlPessoaList(List<GrlPessoa> grlPessoaList) {
        this.grlPessoaList = grlPessoaList;
    }

    @XmlTransient
    public List<RhCandidato> getRhCandidatoList() {
        return rhCandidatoList;
    }

    public void setRhCandidatoList(List<RhCandidato> rhCandidatoList) {
        this.rhCandidatoList = rhCandidatoList;
    }

    @XmlTransient
    public List<RhCandidato> getRhCandidatoList1() {
        return rhCandidatoList1;
    }

    public void setRhCandidatoList1(List<RhCandidato> rhCandidatoList1) {
        this.rhCandidatoList1 = rhCandidatoList1;
    }

    @XmlTransient
    public List<RhCandidato> getRhCandidatoList2() {
        return rhCandidatoList2;
    }

    public void setRhCandidatoList2(List<RhCandidato> rhCandidatoList2) {
        this.rhCandidatoList2 = rhCandidatoList2;
    }

    @XmlTransient
    public List<RhCandidato> getRhCandidatoList3() {
        return rhCandidatoList3;
    }

    public void setRhCandidatoList3(List<RhCandidato> rhCandidatoList3) {
        this.rhCandidatoList3 = rhCandidatoList3;
    }

    @XmlTransient
    public List<RhCandidato> getRhCandidatoList4() {
        return rhCandidatoList4;
    }

    public void setRhCandidatoList4(List<RhCandidato> rhCandidatoList4) {
        this.rhCandidatoList4 = rhCandidatoList4;
    }

    @XmlTransient
    public List<RhCandidato> getRhCandidatoList5() {
        return rhCandidatoList5;
    }

    public void setRhCandidatoList5(List<RhCandidato> rhCandidatoList5) {
        this.rhCandidatoList5 = rhCandidatoList5;
    }

    @XmlTransient
    public List<FarmMaterialSanitario> getFarmMaterialSanitarioList() {
        return farmMaterialSanitarioList;
    }

    public void setFarmMaterialSanitarioList(List<FarmMaterialSanitario> farmMaterialSanitarioList) {
        this.farmMaterialSanitarioList = farmMaterialSanitarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdFicheiroAnexado != null ? pkIdFicheiroAnexado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrlFicheiroAnexado)) {
            return false;
        }
        GrlFicheiroAnexado other = (GrlFicheiroAnexado) object;
        if ((this.pkIdFicheiroAnexado == null && other.pkIdFicheiroAnexado != null) || (this.pkIdFicheiroAnexado != null && !this.pkIdFicheiroAnexado.equals(other.pkIdFicheiroAnexado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.GrlFicheiroAnexado[ pkIdFicheiroAnexado=" + pkIdFicheiroAnexado + " ]";
    }
    
}
