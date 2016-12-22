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
@Table(name = "inter_tratamento_sistematico", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterTratamentoSistematico.findAll", query = "SELECT i FROM InterTratamentoSistematico i"),
    @NamedQuery(name = "InterTratamentoSistematico.findByPkIdTratamentoSistematico", query = "SELECT i FROM InterTratamentoSistematico i WHERE i.pkIdTratamentoSistematico = :pkIdTratamentoSistematico"),
    @NamedQuery(name = "InterTratamentoSistematico.findByData", query = "SELECT i FROM InterTratamentoSistematico i WHERE i.data = :data"),
    @NamedQuery(name = "InterTratamentoSistematico.findByVita", query = "SELECT i FROM InterTratamentoSistematico i WHERE i.vita = :vita"),
    @NamedQuery(name = "InterTratamentoSistematico.findByAntibiotico1", query = "SELECT i FROM InterTratamentoSistematico i WHERE i.antibiotico1 = :antibiotico1"),
    @NamedQuery(name = "InterTratamentoSistematico.findByAmoxicilina", query = "SELECT i FROM InterTratamentoSistematico i WHERE i.amoxicilina = :amoxicilina"),
    @NamedQuery(name = "InterTratamentoSistematico.findByCloroquina", query = "SELECT i FROM InterTratamentoSistematico i WHERE i.cloroquina = :cloroquina"),
    @NamedQuery(name = "InterTratamentoSistematico.findByMebendazole", query = "SELECT i FROM InterTratamentoSistematico i WHERE i.mebendazole = :mebendazole")})
public class InterTratamentoSistematico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_tratamento_sistematico")
    private Integer pkIdTratamentoSistematico;
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Size(max = 45)
    @Column(name = "vita")
    private String vita;
    @Size(max = 45)
    @Column(name = "antibiotico1")
    private String antibiotico1;
    @Size(max = 45)
    @Column(name = "amoxicilina")
    private String amoxicilina;
    @Size(max = 45)
    @Column(name = "cloroquina")
    private String cloroquina;
    @Size(max = 45)
    @Column(name = "mebendazole")
    private String mebendazole;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne
    private RhFuncionario fkIdFuncionario;
    @JoinColumn(name = "fk_id_registo_internamento", referencedColumnName = "pk_id_registo_internamento")
    @ManyToOne(optional = false)
    private InterRegistoInternamento fkIdRegistoInternamento;

    public InterTratamentoSistematico() {
    }

    public InterTratamentoSistematico(Integer pkIdTratamentoSistematico) {
        this.pkIdTratamentoSistematico = pkIdTratamentoSistematico;
    }

    public Integer getPkIdTratamentoSistematico() {
        return pkIdTratamentoSistematico;
    }

    public void setPkIdTratamentoSistematico(Integer pkIdTratamentoSistematico) {
        this.pkIdTratamentoSistematico = pkIdTratamentoSistematico;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getVita() {
        return vita;
    }

    public void setVita(String vita) {
        this.vita = vita;
    }

    public String getAntibiotico1() {
        return antibiotico1;
    }

    public void setAntibiotico1(String antibiotico1) {
        this.antibiotico1 = antibiotico1;
    }

    public String getAmoxicilina() {
        return amoxicilina;
    }

    public void setAmoxicilina(String amoxicilina) {
        this.amoxicilina = amoxicilina;
    }

    public String getCloroquina() {
        return cloroquina;
    }

    public void setCloroquina(String cloroquina) {
        this.cloroquina = cloroquina;
    }

    public String getMebendazole() {
        return mebendazole;
    }

    public void setMebendazole(String mebendazole) {
        this.mebendazole = mebendazole;
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
        hash += (pkIdTratamentoSistematico != null ? pkIdTratamentoSistematico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterTratamentoSistematico)) {
            return false;
        }
        InterTratamentoSistematico other = (InterTratamentoSistematico) object;
        if ((this.pkIdTratamentoSistematico == null && other.pkIdTratamentoSistematico != null) || (this.pkIdTratamentoSistematico != null && !this.pkIdTratamentoSistematico.equals(other.pkIdTratamentoSistematico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.InterTratamentoSistematico[ pkIdTratamentoSistematico=" + pkIdTratamentoSistematico + " ]";
    }
    
}
