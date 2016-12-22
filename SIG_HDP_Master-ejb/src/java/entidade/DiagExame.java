/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "diag_exame", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagExame.findAll", query = "SELECT d FROM DiagExame d"),
    @NamedQuery(name = "DiagExame.findByPkIdExame", query = "SELECT d FROM DiagExame d WHERE d.pkIdExame = :pkIdExame"),
    @NamedQuery(name = "DiagExame.findByDescricaoExame", query = "SELECT d FROM DiagExame d WHERE d.descricaoExame = :descricaoExame"),
    @NamedQuery(name = "DiagExame.findByFkIdPreco", query = "SELECT d FROM DiagExame d WHERE d.fkIdPreco = :fkIdPreco"),
    @NamedQuery(name = "DiagExame.findByTipoDados", query = "SELECT d FROM DiagExame d WHERE d.tipoDados = :tipoDados"),
    @NamedQuery(name = "DiagExame.findByFkIdTipoExame", query = "SELECT d FROM DiagExame d WHERE d.fkIdTipoExame = :fkIdTipoExame")})
public class DiagExame implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_exame")
    private Integer pkIdExame;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao_exame")
    private String descricaoExame;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_id_preco")
    private int fkIdPreco;
    @Size(max = 45)
    @Column(name = "tipo_dados")
    private String tipoDados;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_id_tipo_exame")
    private int fkIdTipoExame;
    @OneToMany(mappedBy = "fkIdExame")
    private List<DiagExameRealizado> diagExameRealizadoList;
    @JoinColumn(name = "fk_id_valor_referencia", referencedColumnName = "pk_id_valor_referencia")
    @ManyToOne(optional = false)
    private DiagValorReferencia fkIdValorReferencia;
    @JoinColumn(name = "fk_id_unidade", referencedColumnName = "pk_id_unidade")
    @ManyToOne(optional = false)
    private DiagUnidade fkIdUnidade;

    public DiagExame() {
    }

    public DiagExame(Integer pkIdExame) {
        this.pkIdExame = pkIdExame;
    }

    public DiagExame(Integer pkIdExame, String descricaoExame, int fkIdPreco, int fkIdTipoExame) {
        this.pkIdExame = pkIdExame;
        this.descricaoExame = descricaoExame;
        this.fkIdPreco = fkIdPreco;
        this.fkIdTipoExame = fkIdTipoExame;
    }

    public Integer getPkIdExame() {
        return pkIdExame;
    }

    public void setPkIdExame(Integer pkIdExame) {
        this.pkIdExame = pkIdExame;
    }

    public String getDescricaoExame() {
        return descricaoExame;
    }

    public void setDescricaoExame(String descricaoExame) {
        this.descricaoExame = descricaoExame;
    }

    public int getFkIdPreco() {
        return fkIdPreco;
    }

    public void setFkIdPreco(int fkIdPreco) {
        this.fkIdPreco = fkIdPreco;
    }

    public String getTipoDados() {
        return tipoDados;
    }

    public void setTipoDados(String tipoDados) {
        this.tipoDados = tipoDados;
    }

    public int getFkIdTipoExame() {
        return fkIdTipoExame;
    }

    public void setFkIdTipoExame(int fkIdTipoExame) {
        this.fkIdTipoExame = fkIdTipoExame;
    }

    @XmlTransient
    public List<DiagExameRealizado> getDiagExameRealizadoList() {
        return diagExameRealizadoList;
    }

    public void setDiagExameRealizadoList(List<DiagExameRealizado> diagExameRealizadoList) {
        this.diagExameRealizadoList = diagExameRealizadoList;
    }

    public DiagValorReferencia getFkIdValorReferencia() {
        return fkIdValorReferencia;
    }

    public void setFkIdValorReferencia(DiagValorReferencia fkIdValorReferencia) {
        this.fkIdValorReferencia = fkIdValorReferencia;
    }

    public DiagUnidade getFkIdUnidade() {
        return fkIdUnidade;
    }

    public void setFkIdUnidade(DiagUnidade fkIdUnidade) {
        this.fkIdUnidade = fkIdUnidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdExame != null ? pkIdExame.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagExame)) {
            return false;
        }
        DiagExame other = (DiagExame) object;
        if ((this.pkIdExame == null && other.pkIdExame != null) || (this.pkIdExame != null && !this.pkIdExame.equals(other.pkIdExame))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.DiagExame[ pkIdExame=" + pkIdExame + " ]";
    }
    
}
