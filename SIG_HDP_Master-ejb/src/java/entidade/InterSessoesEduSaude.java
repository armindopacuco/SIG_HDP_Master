/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "inter_sessoes_edu_saude", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterSessoesEduSaude.findAll", query = "SELECT i FROM InterSessoesEduSaude i"),
    @NamedQuery(name = "InterSessoesEduSaude.findByPkIdSessoesEduSaude", query = "SELECT i FROM InterSessoesEduSaude i WHERE i.pkIdSessoesEduSaude = :pkIdSessoesEduSaude"),
    @NamedQuery(name = "InterSessoesEduSaude.findByDescricao", query = "SELECT i FROM InterSessoesEduSaude i WHERE i.descricao = :descricao")})
public class InterSessoesEduSaude implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_sessoes_edu_saude")
    private Integer pkIdSessoesEduSaude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdSessaoEduSaude")
    private List<InterSessoesEduDadas> interSessoesEduDadasList;

    public InterSessoesEduSaude() {
    }

    public InterSessoesEduSaude(Integer pkIdSessoesEduSaude) {
        this.pkIdSessoesEduSaude = pkIdSessoesEduSaude;
    }

    public InterSessoesEduSaude(Integer pkIdSessoesEduSaude, String descricao) {
        this.pkIdSessoesEduSaude = pkIdSessoesEduSaude;
        this.descricao = descricao;
    }

    public Integer getPkIdSessoesEduSaude() {
        return pkIdSessoesEduSaude;
    }

    public void setPkIdSessoesEduSaude(Integer pkIdSessoesEduSaude) {
        this.pkIdSessoesEduSaude = pkIdSessoesEduSaude;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<InterSessoesEduDadas> getInterSessoesEduDadasList() {
        return interSessoesEduDadasList;
    }

    public void setInterSessoesEduDadasList(List<InterSessoesEduDadas> interSessoesEduDadasList) {
        this.interSessoesEduDadasList = interSessoesEduDadasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdSessoesEduSaude != null ? pkIdSessoesEduSaude.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterSessoesEduSaude)) {
            return false;
        }
        InterSessoesEduSaude other = (InterSessoesEduSaude) object;
        if ((this.pkIdSessoesEduSaude == null && other.pkIdSessoesEduSaude != null) || (this.pkIdSessoesEduSaude != null && !this.pkIdSessoesEduSaude.equals(other.pkIdSessoesEduSaude))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.InterSessoesEduSaude[ pkIdSessoesEduSaude=" + pkIdSessoesEduSaude + " ]";
    }
    
}
