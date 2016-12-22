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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "inter_abertura_ficha_contr_terapeutica", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterAberturaFichaContrTerapeutica.findAll", query = "SELECT i FROM InterAberturaFichaContrTerapeutica i"),
    @NamedQuery(name = "InterAberturaFichaContrTerapeutica.findByPkIdAberturaFichaContrTerapeutica", query = "SELECT i FROM InterAberturaFichaContrTerapeutica i WHERE i.pkIdAberturaFichaContrTerapeutica = :pkIdAberturaFichaContrTerapeutica"),
    @NamedQuery(name = "InterAberturaFichaContrTerapeutica.findByPeso", query = "SELECT i FROM InterAberturaFichaContrTerapeutica i WHERE i.peso = :peso"),
    @NamedQuery(name = "InterAberturaFichaContrTerapeutica.findByData", query = "SELECT i FROM InterAberturaFichaContrTerapeutica i WHERE i.data = :data")})
public class InterAberturaFichaContrTerapeutica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_abertura_ficha_contr_terapeutica")
    private Integer pkIdAberturaFichaContrTerapeutica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso")
    private float peso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdAberturaFichaContrTerapeutica")
    private List<InterFichaContrTerVitais> interFichaContrTerVitaisList;
    @JoinColumn(name = "fk_id_registo_internamento", referencedColumnName = "pk_id_registo_internamento")
    @ManyToOne(optional = false)
    private InterRegistoInternamento fkIdRegistoInternamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdAberturaFichaContrTerapeutica")
    private List<InterFichaContrTeraMedicacao> interFichaContrTeraMedicacaoList;

    public InterAberturaFichaContrTerapeutica() {
    }

    public InterAberturaFichaContrTerapeutica(Integer pkIdAberturaFichaContrTerapeutica) {
        this.pkIdAberturaFichaContrTerapeutica = pkIdAberturaFichaContrTerapeutica;
    }

    public InterAberturaFichaContrTerapeutica(Integer pkIdAberturaFichaContrTerapeutica, float peso, Date data) {
        this.pkIdAberturaFichaContrTerapeutica = pkIdAberturaFichaContrTerapeutica;
        this.peso = peso;
        this.data = data;
    }

    public Integer getPkIdAberturaFichaContrTerapeutica() {
        return pkIdAberturaFichaContrTerapeutica;
    }

    public void setPkIdAberturaFichaContrTerapeutica(Integer pkIdAberturaFichaContrTerapeutica) {
        this.pkIdAberturaFichaContrTerapeutica = pkIdAberturaFichaContrTerapeutica;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @XmlTransient
    public List<InterFichaContrTerVitais> getInterFichaContrTerVitaisList() {
        return interFichaContrTerVitaisList;
    }

    public void setInterFichaContrTerVitaisList(List<InterFichaContrTerVitais> interFichaContrTerVitaisList) {
        this.interFichaContrTerVitaisList = interFichaContrTerVitaisList;
    }

    public InterRegistoInternamento getFkIdRegistoInternamento() {
        return fkIdRegistoInternamento;
    }

    public void setFkIdRegistoInternamento(InterRegistoInternamento fkIdRegistoInternamento) {
        this.fkIdRegistoInternamento = fkIdRegistoInternamento;
    }

    @XmlTransient
    public List<InterFichaContrTeraMedicacao> getInterFichaContrTeraMedicacaoList() {
        return interFichaContrTeraMedicacaoList;
    }

    public void setInterFichaContrTeraMedicacaoList(List<InterFichaContrTeraMedicacao> interFichaContrTeraMedicacaoList) {
        this.interFichaContrTeraMedicacaoList = interFichaContrTeraMedicacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdAberturaFichaContrTerapeutica != null ? pkIdAberturaFichaContrTerapeutica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterAberturaFichaContrTerapeutica)) {
            return false;
        }
        InterAberturaFichaContrTerapeutica other = (InterAberturaFichaContrTerapeutica) object;
        if ((this.pkIdAberturaFichaContrTerapeutica == null && other.pkIdAberturaFichaContrTerapeutica != null) || (this.pkIdAberturaFichaContrTerapeutica != null && !this.pkIdAberturaFichaContrTerapeutica.equals(other.pkIdAberturaFichaContrTerapeutica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.InterAberturaFichaContrTerapeutica[ pkIdAberturaFichaContrTerapeutica=" + pkIdAberturaFichaContrTerapeutica + " ]";
    }
    
}
