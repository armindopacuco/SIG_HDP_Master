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
@Table(name = "diag_resultado", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagResultado.findAll", query = "SELECT d FROM DiagResultado d"),
    @NamedQuery(name = "DiagResultado.findByPkIdResultado", query = "SELECT d FROM DiagResultado d WHERE d.pkIdResultado = :pkIdResultado"),
    @NamedQuery(name = "DiagResultado.findByDescricaoResultado", query = "SELECT d FROM DiagResultado d WHERE d.descricaoResultado = :descricaoResultado"),
    @NamedQuery(name = "DiagResultado.findByObservacao", query = "SELECT d FROM DiagResultado d WHERE d.observacao = :observacao"),
    @NamedQuery(name = "DiagResultado.findByDataResultado", query = "SELECT d FROM DiagResultado d WHERE d.dataResultado = :dataResultado")})
public class DiagResultado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_resultado")
    private Integer pkIdResultado;
    @Size(max = 45)
    @Column(name = "descricao_resultado")
    private String descricaoResultado;
    @Size(max = 45)
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "data_resultado")
    @Temporal(TemporalType.DATE)
    private Date dataResultado;
    @JoinColumn(name = "pergunta", referencedColumnName = "pk_id_resposta_triagem")
    @ManyToOne(optional = false)
    private DiagRespostaTriagem pergunta;
    @JoinColumn(name = "fk_id_amostra", referencedColumnName = "pk_id_amostra")
    @ManyToOne(optional = false)
    private DiagAmostra fkIdAmostra;

    public DiagResultado() {
    }

    public DiagResultado(Integer pkIdResultado) {
        this.pkIdResultado = pkIdResultado;
    }

    public Integer getPkIdResultado() {
        return pkIdResultado;
    }

    public void setPkIdResultado(Integer pkIdResultado) {
        this.pkIdResultado = pkIdResultado;
    }

    public String getDescricaoResultado() {
        return descricaoResultado;
    }

    public void setDescricaoResultado(String descricaoResultado) {
        this.descricaoResultado = descricaoResultado;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataResultado() {
        return dataResultado;
    }

    public void setDataResultado(Date dataResultado) {
        this.dataResultado = dataResultado;
    }

    public DiagRespostaTriagem getPergunta() {
        return pergunta;
    }

    public void setPergunta(DiagRespostaTriagem pergunta) {
        this.pergunta = pergunta;
    }

    public DiagAmostra getFkIdAmostra() {
        return fkIdAmostra;
    }

    public void setFkIdAmostra(DiagAmostra fkIdAmostra) {
        this.fkIdAmostra = fkIdAmostra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdResultado != null ? pkIdResultado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagResultado)) {
            return false;
        }
        DiagResultado other = (DiagResultado) object;
        if ((this.pkIdResultado == null && other.pkIdResultado != null) || (this.pkIdResultado != null && !this.pkIdResultado.equals(other.pkIdResultado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.DiagResultado[ pkIdResultado=" + pkIdResultado + " ]";
    }
    
}
