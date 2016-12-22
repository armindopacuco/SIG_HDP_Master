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
@Table(name = "inter_ficha_contr_ter_vitais", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterFichaContrTerVitais.findAll", query = "SELECT i FROM InterFichaContrTerVitais i"),
    @NamedQuery(name = "InterFichaContrTerVitais.findByPkIdFichaContrTerVitais", query = "SELECT i FROM InterFichaContrTerVitais i WHERE i.pkIdFichaContrTerVitais = :pkIdFichaContrTerVitais"),
    @NamedQuery(name = "InterFichaContrTerVitais.findByTemp", query = "SELECT i FROM InterFichaContrTerVitais i WHERE i.temp = :temp"),
    @NamedQuery(name = "InterFichaContrTerVitais.findByPulso", query = "SELECT i FROM InterFichaContrTerVitais i WHERE i.pulso = :pulso"),
    @NamedQuery(name = "InterFichaContrTerVitais.findByFr", query = "SELECT i FROM InterFichaContrTerVitais i WHERE i.fr = :fr"),
    @NamedQuery(name = "InterFichaContrTerVitais.findByTa", query = "SELECT i FROM InterFichaContrTerVitais i WHERE i.ta = :ta"),
    @NamedQuery(name = "InterFichaContrTerVitais.findByDef", query = "SELECT i FROM InterFichaContrTerVitais i WHERE i.def = :def"),
    @NamedQuery(name = "InterFichaContrTerVitais.findByDiurese", query = "SELECT i FROM InterFichaContrTerVitais i WHERE i.diurese = :diurese"),
    @NamedQuery(name = "InterFichaContrTerVitais.findByOutrosDescricao", query = "SELECT i FROM InterFichaContrTerVitais i WHERE i.outrosDescricao = :outrosDescricao"),
    @NamedQuery(name = "InterFichaContrTerVitais.findByOutrosValor", query = "SELECT i FROM InterFichaContrTerVitais i WHERE i.outrosValor = :outrosValor"),
    @NamedQuery(name = "InterFichaContrTerVitais.findByHora", query = "SELECT i FROM InterFichaContrTerVitais i WHERE i.hora = :hora")})
public class InterFichaContrTerVitais implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_ficha_contr_ter_vitais")
    private Integer pkIdFichaContrTerVitais;
    @Basic(optional = false)
    @NotNull
    @Column(name = "temp")
    private float temp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pulso")
    private float pulso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fr")
    private float fr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ta")
    private float ta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "def")
    private float def;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diurese")
    private float diurese;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "outros_descricao")
    private String outrosDescricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "outros_valor")
    private float outrosValor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @JoinColumn(name = "fk_id_abertura_ficha_contr_terapeutica", referencedColumnName = "pk_id_abertura_ficha_contr_terapeutica")
    @ManyToOne(optional = false)
    private InterAberturaFichaContrTerapeutica fkIdAberturaFichaContrTerapeutica;

    public InterFichaContrTerVitais() {
    }

    public InterFichaContrTerVitais(Integer pkIdFichaContrTerVitais) {
        this.pkIdFichaContrTerVitais = pkIdFichaContrTerVitais;
    }

    public InterFichaContrTerVitais(Integer pkIdFichaContrTerVitais, float temp, float pulso, float fr, float ta, float def, float diurese, String outrosDescricao, float outrosValor, Date hora) {
        this.pkIdFichaContrTerVitais = pkIdFichaContrTerVitais;
        this.temp = temp;
        this.pulso = pulso;
        this.fr = fr;
        this.ta = ta;
        this.def = def;
        this.diurese = diurese;
        this.outrosDescricao = outrosDescricao;
        this.outrosValor = outrosValor;
        this.hora = hora;
    }

    public Integer getPkIdFichaContrTerVitais() {
        return pkIdFichaContrTerVitais;
    }

    public void setPkIdFichaContrTerVitais(Integer pkIdFichaContrTerVitais) {
        this.pkIdFichaContrTerVitais = pkIdFichaContrTerVitais;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getPulso() {
        return pulso;
    }

    public void setPulso(float pulso) {
        this.pulso = pulso;
    }

    public float getFr() {
        return fr;
    }

    public void setFr(float fr) {
        this.fr = fr;
    }

    public float getTa() {
        return ta;
    }

    public void setTa(float ta) {
        this.ta = ta;
    }

    public float getDef() {
        return def;
    }

    public void setDef(float def) {
        this.def = def;
    }

    public float getDiurese() {
        return diurese;
    }

    public void setDiurese(float diurese) {
        this.diurese = diurese;
    }

    public String getOutrosDescricao() {
        return outrosDescricao;
    }

    public void setOutrosDescricao(String outrosDescricao) {
        this.outrosDescricao = outrosDescricao;
    }

    public float getOutrosValor() {
        return outrosValor;
    }

    public void setOutrosValor(float outrosValor) {
        this.outrosValor = outrosValor;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public InterAberturaFichaContrTerapeutica getFkIdAberturaFichaContrTerapeutica() {
        return fkIdAberturaFichaContrTerapeutica;
    }

    public void setFkIdAberturaFichaContrTerapeutica(InterAberturaFichaContrTerapeutica fkIdAberturaFichaContrTerapeutica) {
        this.fkIdAberturaFichaContrTerapeutica = fkIdAberturaFichaContrTerapeutica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdFichaContrTerVitais != null ? pkIdFichaContrTerVitais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterFichaContrTerVitais)) {
            return false;
        }
        InterFichaContrTerVitais other = (InterFichaContrTerVitais) object;
        if ((this.pkIdFichaContrTerVitais == null && other.pkIdFichaContrTerVitais != null) || (this.pkIdFichaContrTerVitais != null && !this.pkIdFichaContrTerVitais.equals(other.pkIdFichaContrTerVitais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.InterFichaContrTerVitais[ pkIdFichaContrTerVitais=" + pkIdFichaContrTerVitais + " ]";
    }
    
}
