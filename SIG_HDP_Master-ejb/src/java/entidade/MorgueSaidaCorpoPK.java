/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author mauro
 */
@Embeddable
public class MorgueSaidaCorpoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "pk_id_saida_corpo")
    private int pkIdSaidaCorpo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_id_corpo")
    private int fkIdCorpo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_id_destino")
    private int fkIdDestino;

    public MorgueSaidaCorpoPK() {
    }

    public MorgueSaidaCorpoPK(int pkIdSaidaCorpo, int fkIdCorpo, int fkIdDestino) {
        this.pkIdSaidaCorpo = pkIdSaidaCorpo;
        this.fkIdCorpo = fkIdCorpo;
        this.fkIdDestino = fkIdDestino;
    }

    public int getPkIdSaidaCorpo() {
        return pkIdSaidaCorpo;
    }

    public void setPkIdSaidaCorpo(int pkIdSaidaCorpo) {
        this.pkIdSaidaCorpo = pkIdSaidaCorpo;
    }

    public int getFkIdCorpo() {
        return fkIdCorpo;
    }

    public void setFkIdCorpo(int fkIdCorpo) {
        this.fkIdCorpo = fkIdCorpo;
    }

    public int getFkIdDestino() {
        return fkIdDestino;
    }

    public void setFkIdDestino(int fkIdDestino) {
        this.fkIdDestino = fkIdDestino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pkIdSaidaCorpo;
        hash += (int) fkIdCorpo;
        hash += (int) fkIdDestino;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MorgueSaidaCorpoPK)) {
            return false;
        }
        MorgueSaidaCorpoPK other = (MorgueSaidaCorpoPK) object;
        if (this.pkIdSaidaCorpo != other.pkIdSaidaCorpo) {
            return false;
        }
        if (this.fkIdCorpo != other.fkIdCorpo) {
            return false;
        }
        if (this.fkIdDestino != other.fkIdDestino) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.MorgueSaidaCorpoPK[ pkIdSaidaCorpo=" + pkIdSaidaCorpo + ", fkIdCorpo=" + fkIdCorpo + ", fkIdDestino=" + fkIdDestino + " ]";
    }
    
}
