/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "supi_formacao_estagiario", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupiFormacaoEstagiario.findAll", query = "SELECT s FROM SupiFormacaoEstagiario s"),
    @NamedQuery(name = "SupiFormacaoEstagiario.findByPkIdFormacaoEstagiario", query = "SELECT s FROM SupiFormacaoEstagiario s WHERE s.pkIdFormacaoEstagiario = :pkIdFormacaoEstagiario"),
    @NamedQuery(name = "SupiFormacaoEstagiario.findByNumeroAula", query = "SELECT s FROM SupiFormacaoEstagiario s WHERE s.numeroAula = :numeroAula"),
    @NamedQuery(name = "SupiFormacaoEstagiario.findByTema", query = "SELECT s FROM SupiFormacaoEstagiario s WHERE s.tema = :tema")})
public class SupiFormacaoEstagiario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_formacao_estagiario")
    private Integer pkIdFormacaoEstagiario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_aula")
    private int numeroAula;
    @Size(max = 100)
    @Column(name = "tema")
    private String tema;
    @JoinColumn(name = "fk_id_estagiario", referencedColumnName = "pk_id_estagiario")
    @ManyToOne(optional = false)
    private SupiEstagiario fkIdEstagiario;

    public SupiFormacaoEstagiario() {
    }

    public SupiFormacaoEstagiario(Integer pkIdFormacaoEstagiario) {
        this.pkIdFormacaoEstagiario = pkIdFormacaoEstagiario;
    }

    public SupiFormacaoEstagiario(Integer pkIdFormacaoEstagiario, int numeroAula) {
        this.pkIdFormacaoEstagiario = pkIdFormacaoEstagiario;
        this.numeroAula = numeroAula;
    }

    public Integer getPkIdFormacaoEstagiario() {
        return pkIdFormacaoEstagiario;
    }

    public void setPkIdFormacaoEstagiario(Integer pkIdFormacaoEstagiario) {
        this.pkIdFormacaoEstagiario = pkIdFormacaoEstagiario;
    }

    public int getNumeroAula() {
        return numeroAula;
    }

    public void setNumeroAula(int numeroAula) {
        this.numeroAula = numeroAula;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public SupiEstagiario getFkIdEstagiario() {
        return fkIdEstagiario;
    }

    public void setFkIdEstagiario(SupiEstagiario fkIdEstagiario) {
        this.fkIdEstagiario = fkIdEstagiario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdFormacaoEstagiario != null ? pkIdFormacaoEstagiario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupiFormacaoEstagiario)) {
            return false;
        }
        SupiFormacaoEstagiario other = (SupiFormacaoEstagiario) object;
        if ((this.pkIdFormacaoEstagiario == null && other.pkIdFormacaoEstagiario != null) || (this.pkIdFormacaoEstagiario != null && !this.pkIdFormacaoEstagiario.equals(other.pkIdFormacaoEstagiario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.SupiFormacaoEstagiario[ pkIdFormacaoEstagiario=" + pkIdFormacaoEstagiario + " ]";
    }
    
}
