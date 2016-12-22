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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "diag_imagem", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagImagem.findAll", query = "SELECT d FROM DiagImagem d"),
    @NamedQuery(name = "DiagImagem.findByPkIdImagem", query = "SELECT d FROM DiagImagem d WHERE d.pkIdImagem = :pkIdImagem"),
    @NamedQuery(name = "DiagImagem.findByDescricaoImagem", query = "SELECT d FROM DiagImagem d WHERE d.descricaoImagem = :descricaoImagem"),
    @NamedQuery(name = "DiagImagem.findByCaminho", query = "SELECT d FROM DiagImagem d WHERE d.caminho = :caminho")})
public class DiagImagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_imagem")
    private Integer pkIdImagem;
    @Size(max = 45)
    @Column(name = "descricao_imagem")
    private String descricaoImagem;
    @Size(max = 45)
    @Column(name = "caminho")
    private String caminho;
    @JoinColumn(name = "fk_id_colecta", referencedColumnName = "pk_id_colecta")
    @ManyToOne(optional = false)
    private DiagColecta fkIdColecta;

    public DiagImagem() {
    }

    public DiagImagem(Integer pkIdImagem) {
        this.pkIdImagem = pkIdImagem;
    }

    public Integer getPkIdImagem() {
        return pkIdImagem;
    }

    public void setPkIdImagem(Integer pkIdImagem) {
        this.pkIdImagem = pkIdImagem;
    }

    public String getDescricaoImagem() {
        return descricaoImagem;
    }

    public void setDescricaoImagem(String descricaoImagem) {
        this.descricaoImagem = descricaoImagem;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public DiagColecta getFkIdColecta() {
        return fkIdColecta;
    }

    public void setFkIdColecta(DiagColecta fkIdColecta) {
        this.fkIdColecta = fkIdColecta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdImagem != null ? pkIdImagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagImagem)) {
            return false;
        }
        DiagImagem other = (DiagImagem) object;
        if ((this.pkIdImagem == null && other.pkIdImagem != null) || (this.pkIdImagem != null && !this.pkIdImagem.equals(other.pkIdImagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.DiagImagem[ pkIdImagem=" + pkIdImagem + " ]";
    }
    
}
