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
public class MorgueEntradaCorpoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "pk_id_entrada_corpo")
    private int pkIdEntradaCorpo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_id_corpo")
    private int fkIdCorpo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_id_proveniencia")
    private int fkIdProveniencia;

    public MorgueEntradaCorpoPK() {
    }

    public MorgueEntradaCorpoPK(int pkIdEntradaCorpo, int fkIdCorpo, int fkIdProveniencia) {
        this.pkIdEntradaCorpo = pkIdEntradaCorpo;
        this.fkIdCorpo = fkIdCorpo;
        this.fkIdProveniencia = fkIdProveniencia;
    }

    public int getPkIdEntradaCorpo() {
        return pkIdEntradaCorpo;
    }

    public void setPkIdEntradaCorpo(int pkIdEntradaCorpo) {
        this.pkIdEntradaCorpo = pkIdEntradaCorpo;
    }

    public int getFkIdCorpo() {
        return fkIdCorpo;
    }

    public void setFkIdCorpo(int fkIdCorpo) {
        this.fkIdCorpo = fkIdCorpo;
    }

    public int getFkIdProveniencia() {
        return fkIdProveniencia;
    }

    public void setFkIdProveniencia(int fkIdProveniencia) {
        this.fkIdProveniencia = fkIdProveniencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pkIdEntradaCorpo;
        hash += (int) fkIdCorpo;
        hash += (int) fkIdProveniencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MorgueEntradaCorpoPK)) {
            return false;
        }
        MorgueEntradaCorpoPK other = (MorgueEntradaCorpoPK) object;
        if (this.pkIdEntradaCorpo != other.pkIdEntradaCorpo) {
            return false;
        }
        if (this.fkIdCorpo != other.fkIdCorpo) {
            return false;
        }
        if (this.fkIdProveniencia != other.fkIdProveniencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.MorgueEntradaCorpoPK[ pkIdEntradaCorpo=" + pkIdEntradaCorpo + ", fkIdCorpo=" + fkIdCorpo + ", fkIdProveniencia=" + fkIdProveniencia + " ]";
    }
    
}
