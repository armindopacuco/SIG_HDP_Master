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
@Table(name = "farm_venda", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmVenda.findAll", query = "SELECT f FROM FarmVenda f"),
    @NamedQuery(name = "FarmVenda.findByPkIdVenda", query = "SELECT f FROM FarmVenda f WHERE f.pkIdVenda = :pkIdVenda"),
    @NamedQuery(name = "FarmVenda.findByData", query = "SELECT f FROM FarmVenda f WHERE f.data = :data"),
    @NamedQuery(name = "FarmVenda.findByFkIdPrescricaoMedica", query = "SELECT f FROM FarmVenda f WHERE f.fkIdPrescricaoMedica = :fkIdPrescricaoMedica")})
public class FarmVenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_id_venda")
    private Integer pkIdVenda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_id_prescricao_medica")
    private int fkIdPrescricaoMedica;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne(optional = false)
    private RhFuncionario fkIdFuncionario;
    @JoinColumn(name = "fk_id_cliente", referencedColumnName = "pk_id_cliente")
    @ManyToOne(optional = false)
    private FarmCliente fkIdCliente;
    @JoinColumn(name = "fk_id_armazenamento", referencedColumnName = "pk_id_armazenamento")
    @ManyToOne(optional = false)
    private FarmArmazenamento fkIdArmazenamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdVenda")
    private List<FarmVendaHasMedicamento> farmVendaHasMedicamentoList;

    public FarmVenda() {
    }

    public FarmVenda(Integer pkIdVenda) {
        this.pkIdVenda = pkIdVenda;
    }

    public FarmVenda(Integer pkIdVenda, Date data, int fkIdPrescricaoMedica) {
        this.pkIdVenda = pkIdVenda;
        this.data = data;
        this.fkIdPrescricaoMedica = fkIdPrescricaoMedica;
    }

    public Integer getPkIdVenda() {
        return pkIdVenda;
    }

    public void setPkIdVenda(Integer pkIdVenda) {
        this.pkIdVenda = pkIdVenda;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getFkIdPrescricaoMedica() {
        return fkIdPrescricaoMedica;
    }

    public void setFkIdPrescricaoMedica(int fkIdPrescricaoMedica) {
        this.fkIdPrescricaoMedica = fkIdPrescricaoMedica;
    }

    public RhFuncionario getFkIdFuncionario() {
        return fkIdFuncionario;
    }

    public void setFkIdFuncionario(RhFuncionario fkIdFuncionario) {
        this.fkIdFuncionario = fkIdFuncionario;
    }

    public FarmCliente getFkIdCliente() {
        return fkIdCliente;
    }

    public void setFkIdCliente(FarmCliente fkIdCliente) {
        this.fkIdCliente = fkIdCliente;
    }

    public FarmArmazenamento getFkIdArmazenamento() {
        return fkIdArmazenamento;
    }

    public void setFkIdArmazenamento(FarmArmazenamento fkIdArmazenamento) {
        this.fkIdArmazenamento = fkIdArmazenamento;
    }

    @XmlTransient
    public List<FarmVendaHasMedicamento> getFarmVendaHasMedicamentoList() {
        return farmVendaHasMedicamentoList;
    }

    public void setFarmVendaHasMedicamentoList(List<FarmVendaHasMedicamento> farmVendaHasMedicamentoList) {
        this.farmVendaHasMedicamentoList = farmVendaHasMedicamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdVenda != null ? pkIdVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmVenda)) {
            return false;
        }
        FarmVenda other = (FarmVenda) object;
        if ((this.pkIdVenda == null && other.pkIdVenda != null) || (this.pkIdVenda != null && !this.pkIdVenda.equals(other.pkIdVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.FarmVenda[ pkIdVenda=" + pkIdVenda + " ]";
    }
    
}
