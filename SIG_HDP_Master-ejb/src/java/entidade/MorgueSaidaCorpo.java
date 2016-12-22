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
@Table(name = "morgue_saida_corpo", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MorgueSaidaCorpo.findAll", query = "SELECT m FROM MorgueSaidaCorpo m"),
    @NamedQuery(name = "MorgueSaidaCorpo.findByPkIdSaidaCorpo", query = "SELECT m FROM MorgueSaidaCorpo m WHERE m.morgueSaidaCorpoPK.pkIdSaidaCorpo = :pkIdSaidaCorpo"),
    @NamedQuery(name = "MorgueSaidaCorpo.findByFkIdCorpo", query = "SELECT m FROM MorgueSaidaCorpo m WHERE m.morgueSaidaCorpoPK.fkIdCorpo = :fkIdCorpo"),
    @NamedQuery(name = "MorgueSaidaCorpo.findByFkIdDestino", query = "SELECT m FROM MorgueSaidaCorpo m WHERE m.morgueSaidaCorpoPK.fkIdDestino = :fkIdDestino"),
    @NamedQuery(name = "MorgueSaidaCorpo.findByDataSaida", query = "SELECT m FROM MorgueSaidaCorpo m WHERE m.dataSaida = :dataSaida")})
public class MorgueSaidaCorpo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MorgueSaidaCorpoPK morgueSaidaCorpoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_saida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataSaida;
    @JoinColumn(name = "fk_id_destino", referencedColumnName = "pk_id_destino", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MorgueDestino morgueDestino;
    @JoinColumn(name = "fk_id_corpo", referencedColumnName = "pk_id_corpo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MorgueCorpo morgueCorpo;
    @JoinColumn(name = "fk_id_destino", referencedColumnName = "pk_id_instituicao", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GrlInstituicao grlInstituicao;

    public MorgueSaidaCorpo() {
    }

    public MorgueSaidaCorpo(MorgueSaidaCorpoPK morgueSaidaCorpoPK) {
        this.morgueSaidaCorpoPK = morgueSaidaCorpoPK;
    }

    public MorgueSaidaCorpo(MorgueSaidaCorpoPK morgueSaidaCorpoPK, Date dataSaida) {
        this.morgueSaidaCorpoPK = morgueSaidaCorpoPK;
        this.dataSaida = dataSaida;
    }

    public MorgueSaidaCorpo(int pkIdSaidaCorpo, int fkIdCorpo, int fkIdDestino) {
        this.morgueSaidaCorpoPK = new MorgueSaidaCorpoPK(pkIdSaidaCorpo, fkIdCorpo, fkIdDestino);
    }

    public MorgueSaidaCorpoPK getMorgueSaidaCorpoPK() {
        return morgueSaidaCorpoPK;
    }

    public void setMorgueSaidaCorpoPK(MorgueSaidaCorpoPK morgueSaidaCorpoPK) {
        this.morgueSaidaCorpoPK = morgueSaidaCorpoPK;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public MorgueDestino getMorgueDestino() {
        return morgueDestino;
    }

    public void setMorgueDestino(MorgueDestino morgueDestino) {
        this.morgueDestino = morgueDestino;
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
        hash += (morgueSaidaCorpoPK != null ? morgueSaidaCorpoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MorgueSaidaCorpo)) {
            return false;
        }
        MorgueSaidaCorpo other = (MorgueSaidaCorpo) object;
        if ((this.morgueSaidaCorpoPK == null && other.morgueSaidaCorpoPK != null) || (this.morgueSaidaCorpoPK != null && !this.morgueSaidaCorpoPK.equals(other.morgueSaidaCorpoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.MorgueSaidaCorpo[ morgueSaidaCorpoPK=" + morgueSaidaCorpoPK + " ]";
    }
    
}
