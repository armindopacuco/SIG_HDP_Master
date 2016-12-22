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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "morgue_entrada_corpo", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MorgueEntradaCorpo.findAll", query = "SELECT m FROM MorgueEntradaCorpo m"),
    @NamedQuery(name = "MorgueEntradaCorpo.findByPkIdEntradaCorpo", query = "SELECT m FROM MorgueEntradaCorpo m WHERE m.morgueEntradaCorpoPK.pkIdEntradaCorpo = :pkIdEntradaCorpo"),
    @NamedQuery(name = "MorgueEntradaCorpo.findByFkIdCorpo", query = "SELECT m FROM MorgueEntradaCorpo m WHERE m.morgueEntradaCorpoPK.fkIdCorpo = :fkIdCorpo"),
    @NamedQuery(name = "MorgueEntradaCorpo.findByFkIdProveniencia", query = "SELECT m FROM MorgueEntradaCorpo m WHERE m.morgueEntradaCorpoPK.fkIdProveniencia = :fkIdProveniencia"),
    @NamedQuery(name = "MorgueEntradaCorpo.findByDataEntrada", query = "SELECT m FROM MorgueEntradaCorpo m WHERE m.dataEntrada = :dataEntrada")})
public class MorgueEntradaCorpo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MorgueEntradaCorpoPK morgueEntradaCorpoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_entrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEntrada;
    @JoinColumn(name = "fk_id_responsavel", referencedColumnName = "pk_id_funcionario")
    @ManyToOne
    private RhFuncionario fkIdResponsavel;
    @JoinColumn(name = "fk_id_proveniencia", referencedColumnName = "pk_id_proveniencia", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MorgueProveniencia morgueProveniencia;
    @JoinColumn(name = "fk_id_corpo", referencedColumnName = "pk_id_corpo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MorgueCorpo morgueCorpo;
    @JoinColumn(name = "fk_id_proveniencia", referencedColumnName = "pk_id_instituicao", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GrlInstituicao grlInstituicao;

    public MorgueEntradaCorpo() {
    }

    public MorgueEntradaCorpo(MorgueEntradaCorpoPK morgueEntradaCorpoPK) {
        this.morgueEntradaCorpoPK = morgueEntradaCorpoPK;
    }

    public MorgueEntradaCorpo(MorgueEntradaCorpoPK morgueEntradaCorpoPK, Date dataEntrada) {
        this.morgueEntradaCorpoPK = morgueEntradaCorpoPK;
        this.dataEntrada = dataEntrada;
    }

    public MorgueEntradaCorpo(int pkIdEntradaCorpo, int fkIdCorpo, int fkIdProveniencia) {
        this.morgueEntradaCorpoPK = new MorgueEntradaCorpoPK(pkIdEntradaCorpo, fkIdCorpo, fkIdProveniencia);
    }

    public MorgueEntradaCorpoPK getMorgueEntradaCorpoPK() {
        return morgueEntradaCorpoPK;
    }

    public void setMorgueEntradaCorpoPK(MorgueEntradaCorpoPK morgueEntradaCorpoPK) {
        this.morgueEntradaCorpoPK = morgueEntradaCorpoPK;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public RhFuncionario getFkIdResponsavel() {
        return fkIdResponsavel;
    }

    public void setFkIdResponsavel(RhFuncionario fkIdResponsavel) {
        this.fkIdResponsavel = fkIdResponsavel;
    }

    public MorgueProveniencia getMorgueProveniencia() {
        return morgueProveniencia;
    }

    public void setMorgueProveniencia(MorgueProveniencia morgueProveniencia) {
        this.morgueProveniencia = morgueProveniencia;
    }

    public MorgueCorpo getMorgueCorpo() {
        return morgueCorpo;
    }

    public void setMorgueCorpo(MorgueCorpo morgueCorpo) {
        this.morgueCorpo = morgueCorpo;
    }

    public GrlInstituicao getGrlInstituicao() {
        return grlInstituicao;
    }

    public void setGrlInstituicao(GrlInstituicao grlInstituicao) {
        this.grlInstituicao = grlInstituicao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (morgueEntradaCorpoPK != null ? morgueEntradaCorpoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MorgueEntradaCorpo)) {
            return false;
        }
        MorgueEntradaCorpo other = (MorgueEntradaCorpo) object;
        if ((this.morgueEntradaCorpoPK == null && other.morgueEntradaCorpoPK != null) || (this.morgueEntradaCorpoPK != null && !this.morgueEntradaCorpoPK.equals(other.morgueEntradaCorpoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.MorgueEntradaCorpo[ morgueEntradaCorpoPK=" + morgueEntradaCorpoPK + " ]";
    }
    
}
