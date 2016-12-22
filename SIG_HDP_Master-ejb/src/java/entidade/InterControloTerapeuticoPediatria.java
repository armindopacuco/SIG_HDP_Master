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
@Table(name = "inter_controlo_terapeutico_pediatria", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterControloTerapeuticoPediatria.findAll", query = "SELECT i FROM InterControloTerapeuticoPediatria i"),
    @NamedQuery(name = "InterControloTerapeuticoPediatria.findByPkIdControloTerapeuticoPediatria", query = "SELECT i FROM InterControloTerapeuticoPediatria i WHERE i.pkIdControloTerapeuticoPediatria = :pkIdControloTerapeuticoPediatria"),
    @NamedQuery(name = "InterControloTerapeuticoPediatria.findByProcessoInternamento", query = "SELECT i FROM InterControloTerapeuticoPediatria i WHERE i.processoInternamento = :processoInternamento"),
    @NamedQuery(name = "InterControloTerapeuticoPediatria.findByDataHora", query = "SELECT i FROM InterControloTerapeuticoPediatria i WHERE i.dataHora = :dataHora"),
    @NamedQuery(name = "InterControloTerapeuticoPediatria.findByTemperatura", query = "SELECT i FROM InterControloTerapeuticoPediatria i WHERE i.temperatura = :temperatura"),
    @NamedQuery(name = "InterControloTerapeuticoPediatria.findByDosagemMedicamento", query = "SELECT i FROM InterControloTerapeuticoPediatria i WHERE i.dosagemMedicamento = :dosagemMedicamento"),
    @NamedQuery(name = "InterControloTerapeuticoPediatria.findByPulso", query = "SELECT i FROM InterControloTerapeuticoPediatria i WHERE i.pulso = :pulso"),
    @NamedQuery(name = "InterControloTerapeuticoPediatria.findByFr", query = "SELECT i FROM InterControloTerapeuticoPediatria i WHERE i.fr = :fr"),
    @NamedQuery(name = "InterControloTerapeuticoPediatria.findByTa", query = "SELECT i FROM InterControloTerapeuticoPediatria i WHERE i.ta = :ta"),
    @NamedQuery(name = "InterControloTerapeuticoPediatria.findByDef", query = "SELECT i FROM InterControloTerapeuticoPediatria i WHERE i.def = :def"),
    @NamedQuery(name = "InterControloTerapeuticoPediatria.findByDiurese", query = "SELECT i FROM InterControloTerapeuticoPediatria i WHERE i.diurese = :diurese")})
public class InterControloTerapeuticoPediatria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_controlo_terapeutico_pediatria")
    private Integer pkIdControloTerapeuticoPediatria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "processo_internamento")
    private int processoInternamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "temperatura")
    private float temperatura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dosagem_medicamento")
    private String dosagemMedicamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pulso")
    private String pulso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fr")
    private String fr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ta")
    private String ta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "def")
    private String def;
    @Size(max = 45)
    @Column(name = "diurese")
    private String diurese;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne
    private RhFuncionario fkIdFuncionario;
    @JoinColumn(name = "fk_id_medicamento", referencedColumnName = "pk_id_material_sanitario")
    @ManyToOne
    private FarmMaterialSanitario fkIdMedicamento;

    public InterControloTerapeuticoPediatria() {
    }

    public InterControloTerapeuticoPediatria(Integer pkIdControloTerapeuticoPediatria) {
        this.pkIdControloTerapeuticoPediatria = pkIdControloTerapeuticoPediatria;
    }

    public InterControloTerapeuticoPediatria(Integer pkIdControloTerapeuticoPediatria, int processoInternamento, Date dataHora, float temperatura, String dosagemMedicamento, String pulso, String fr, String ta, String def) {
        this.pkIdControloTerapeuticoPediatria = pkIdControloTerapeuticoPediatria;
        this.processoInternamento = processoInternamento;
        this.dataHora = dataHora;
        this.temperatura = temperatura;
        this.dosagemMedicamento = dosagemMedicamento;
        this.pulso = pulso;
        this.fr = fr;
        this.ta = ta;
        this.def = def;
    }

    public Integer getPkIdControloTerapeuticoPediatria() {
        return pkIdControloTerapeuticoPediatria;
    }

    public void setPkIdControloTerapeuticoPediatria(Integer pkIdControloTerapeuticoPediatria) {
        this.pkIdControloTerapeuticoPediatria = pkIdControloTerapeuticoPediatria;
    }

    public int getProcessoInternamento() {
        return processoInternamento;
    }

    public void setProcessoInternamento(int processoInternamento) {
        this.processoInternamento = processoInternamento;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public String getDosagemMedicamento() {
        return dosagemMedicamento;
    }

    public void setDosagemMedicamento(String dosagemMedicamento) {
        this.dosagemMedicamento = dosagemMedicamento;
    }

    public String getPulso() {
        return pulso;
    }

    public void setPulso(String pulso) {
        this.pulso = pulso;
    }

    public String getFr() {
        return fr;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }

    public String getTa() {
        return ta;
    }

    public void setTa(String ta) {
        this.ta = ta;
    }

    public String getDef() {
        return def;
    }

    public void setDef(String def) {
        this.def = def;
    }

    public String getDiurese() {
        return diurese;
    }

    public void setDiurese(String diurese) {
        this.diurese = diurese;
    }

    public RhFuncionario getFkIdFuncionario() {
        return fkIdFuncionario;
    }

    public void setFkIdFuncionario(RhFuncionario fkIdFuncionario) {
        this.fkIdFuncionario = fkIdFuncionario;
    }

    public FarmMaterialSanitario getFkIdMedicamento() {
        return fkIdMedicamento;
    }

    public void setFkIdMedicamento(FarmMaterialSanitario fkIdMedicamento) {
        this.fkIdMedicamento = fkIdMedicamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdControloTerapeuticoPediatria != null ? pkIdControloTerapeuticoPediatria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterControloTerapeuticoPediatria)) {
            return false;
        }
        InterControloTerapeuticoPediatria other = (InterControloTerapeuticoPediatria) object;
        if ((this.pkIdControloTerapeuticoPediatria == null && other.pkIdControloTerapeuticoPediatria != null) || (this.pkIdControloTerapeuticoPediatria != null && !this.pkIdControloTerapeuticoPediatria.equals(other.pkIdControloTerapeuticoPediatria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.InterControloTerapeuticoPediatria[ pkIdControloTerapeuticoPediatria=" + pkIdControloTerapeuticoPediatria + " ]";
    }
    
}
