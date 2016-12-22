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
@Table(name = "diag_exame_realizado", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagExameRealizado.findAll", query = "SELECT d FROM DiagExameRealizado d"),
    @NamedQuery(name = "DiagExameRealizado.findByPkIdExameRealizado", query = "SELECT d FROM DiagExameRealizado d WHERE d.pkIdExameRealizado = :pkIdExameRealizado"),
    @NamedQuery(name = "DiagExameRealizado.findByData", query = "SELECT d FROM DiagExameRealizado d WHERE d.data = :data"),
    @NamedQuery(name = "DiagExameRealizado.findByResultados", query = "SELECT d FROM DiagExameRealizado d WHERE d.resultados = :resultados")})
public class DiagExameRealizado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_exame_realizado")
    private Integer pkIdExameRealizado;
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Size(max = 255)
    @Column(name = "resultados")
    private String resultados;
    @JoinColumn(name = "fk_id_funcionario", referencedColumnName = "pk_id_funcionario")
    @ManyToOne
    private RhFuncionario fkIdFuncionario;
    @JoinColumn(name = "fk_id_exame", referencedColumnName = "pk_id_exame")
    @ManyToOne
    private DiagExame fkIdExame;
    @JoinColumn(name = "fk_id_servico_solicitado", referencedColumnName = "pk_id_servico_solicitado")
    @ManyToOne
    private AdmsServicoSolicitado fkIdServicoSolicitado;

    public DiagExameRealizado() {
    }

    public DiagExameRealizado(Integer pkIdExameRealizado) {
        this.pkIdExameRealizado = pkIdExameRealizado;
    }

    public Integer getPkIdExameRealizado() {
        return pkIdExameRealizado;
    }

    public void setPkIdExameRealizado(Integer pkIdExameRealizado) {
        this.pkIdExameRealizado = pkIdExameRealizado;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }

    public RhFuncionario getFkIdFuncionario() {
        return fkIdFuncionario;
    }

    public void setFkIdFuncionario(RhFuncionario fkIdFuncionario) {
        this.fkIdFuncionario = fkIdFuncionario;
    }

    public DiagExame getFkIdExame() {
        return fkIdExame;
    }

    public void setFkIdExame(DiagExame fkIdExame) {
        this.fkIdExame = fkIdExame;
    }

    public AdmsServicoSolicitado getFkIdServicoSolicitado() {
        return fkIdServicoSolicitado;
    }

    public void setFkIdServicoSolicitado(AdmsServicoSolicitado fkIdServicoSolicitado) {
        this.fkIdServicoSolicitado = fkIdServicoSolicitado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdExameRealizado != null ? pkIdExameRealizado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagExameRealizado)) {
            return false;
        }
        DiagExameRealizado other = (DiagExameRealizado) object;
        if ((this.pkIdExameRealizado == null && other.pkIdExameRealizado != null) || (this.pkIdExameRealizado != null && !this.pkIdExameRealizado.equals(other.pkIdExameRealizado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.DiagExameRealizado[ pkIdExameRealizado=" + pkIdExameRealizado + " ]";
    }
    
}
