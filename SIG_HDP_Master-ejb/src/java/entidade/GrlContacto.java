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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "grl_contacto", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrlContacto.findAll", query = "SELECT g FROM GrlContacto g"),
    @NamedQuery(name = "GrlContacto.findByPkIdContacto", query = "SELECT g FROM GrlContacto g WHERE g.pkIdContacto = :pkIdContacto"),
    @NamedQuery(name = "GrlContacto.findByTelefone1", query = "SELECT g FROM GrlContacto g WHERE g.telefone1 = :telefone1"),
    @NamedQuery(name = "GrlContacto.findByTelefone2", query = "SELECT g FROM GrlContacto g WHERE g.telefone2 = :telefone2"),
    @NamedQuery(name = "GrlContacto.findByEmail1", query = "SELECT g FROM GrlContacto g WHERE g.email1 = :email1"),
    @NamedQuery(name = "GrlContacto.findByEmail2", query = "SELECT g FROM GrlContacto g WHERE g.email2 = :email2")})
public class GrlContacto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_contacto")
    private Integer pkIdContacto;
    @Size(max = 100)
    @Column(name = "telefone1")
    private String telefone1;
    @Size(max = 100)
    @Column(name = "telefone2")
    private String telefone2;
    @Size(max = 100)
    @Column(name = "email1")
    private String email1;
    @Size(max = 100)
    @Column(name = "email2")
    private String email2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdContacto")
    private List<GrlPessoa> grlPessoaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdContacto")
    private List<GrlInstituicao> grlInstituicaoList;

    public GrlContacto() {
    }

    public GrlContacto(Integer pkIdContacto) {
        this.pkIdContacto = pkIdContacto;
    }

    public Integer getPkIdContacto() {
        return pkIdContacto;
    }

    public void setPkIdContacto(Integer pkIdContacto) {
        this.pkIdContacto = pkIdContacto;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    @XmlTransient
    public List<GrlPessoa> getGrlPessoaList() {
        return grlPessoaList;
    }

    public void setGrlPessoaList(List<GrlPessoa> grlPessoaList) {
        this.grlPessoaList = grlPessoaList;
    }

    @XmlTransient
    public List<GrlInstituicao> getGrlInstituicaoList() {
        return grlInstituicaoList;
    }

    public void setGrlInstituicaoList(List<GrlInstituicao> grlInstituicaoList) {
        this.grlInstituicaoList = grlInstituicaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdContacto != null ? pkIdContacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrlContacto)) {
            return false;
        }
        GrlContacto other = (GrlContacto) object;
        if ((this.pkIdContacto == null && other.pkIdContacto != null) || (this.pkIdContacto != null && !this.pkIdContacto.equals(other.pkIdContacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.GrlContacto[ pkIdContacto=" + pkIdContacto + " ]";
    }
    
}
