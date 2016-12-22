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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "inter_ficha_contr_tera_medicacao", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterFichaContrTeraMedicacao.findAll", query = "SELECT i FROM InterFichaContrTeraMedicacao i"),
    @NamedQuery(name = "InterFichaContrTeraMedicacao.findByPkIdFichaContrTeraMedicacao", query = "SELECT i FROM InterFichaContrTeraMedicacao i WHERE i.pkIdFichaContrTeraMedicacao = :pkIdFichaContrTeraMedicacao"),
    @NamedQuery(name = "InterFichaContrTeraMedicacao.findByDosagem", query = "SELECT i FROM InterFichaContrTeraMedicacao i WHERE i.dosagem = :dosagem"),
    @NamedQuery(name = "InterFichaContrTeraMedicacao.findByViaAdministracao", query = "SELECT i FROM InterFichaContrTeraMedicacao i WHERE i.viaAdministracao = :viaAdministracao"),
    @NamedQuery(name = "InterFichaContrTeraMedicacao.findByHora", query = "SELECT i FROM InterFichaContrTeraMedicacao i WHERE i.hora = :hora")})
public class InterFichaContrTeraMedicacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_ficha_contr_tera_medicacao")
    private Integer pkIdFichaContrTeraMedicacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dosagem")
    private String dosagem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "via_administracao")
    private String viaAdministracao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @JoinColumn(name = "fk_id_abertura_ficha_contr_terapeutica", referencedColumnName = "pk_id_abertura_ficha_contr_terapeutica")
    @ManyToOne(optional = false)
    private InterAberturaFichaContrTerapeutica fkIdAberturaFichaContrTerapeutica;
    @JoinColumn(name = "fk_id_medicamento", referencedColumnName = "pk_id_material_sanitario")
    @ManyToOne(optional = false)
    private FarmMaterialSanitario fkIdMedicamento;

    public InterFichaContrTeraMedicacao() {
    }

    public InterFichaContrTeraMedicacao(Integer pkIdFichaContrTeraMedicacao) {
        this.pkIdFichaContrTeraMedicacao = pkIdFichaContrTeraMedicacao;
    }

    public InterFichaContrTeraMedicacao(Integer pkIdFichaContrTeraMedicacao, String dosagem, String viaAdministracao, Date hora) {
        this.pkIdFichaContrTeraMedicacao = pkIdFichaContrTeraMedicacao;
        this.dosagem = dosagem;
        this.viaAdministracao = viaAdministracao;
        this.hora = hora;
    }

    public Integer getPkIdFichaContrTeraMedicacao() {
        return pkIdFichaContrTeraMedicacao;
    }

    public void setPkIdFichaContrTeraMedicacao(Integer pkIdFichaContrTeraMedicacao) {
        this.pkIdFichaContrTeraMedicacao = pkIdFichaContrTeraMedicacao;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public String getViaAdministracao() {
        return viaAdministracao;
    }

    public void setViaAdministracao(String viaAdministracao) {
        this.viaAdministracao = viaAdministracao;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public InterAberturaFichaContrTerapeutica getFkIdAberturaFichaContrTerapeutica() {
        return fkIdAberturaFichaContrTerapeutica;
    }

    public void setFkIdAberturaFichaContrTerapeutica(InterAberturaFichaContrTerapeutica fkIdAberturaFichaContrTerapeutica) {
        this.fkIdAberturaFichaContrTerapeutica = fkIdAberturaFichaContrTerapeutica;
    }

    public FarmMaterialSanitario getFkIdMedicamento() {
        return fkIdMedicamento;
    }

    public void setFkIdMedicamento(FarmMaterialSanitario fkIdMedicamento) {
        this.fkIdMedicamento = fkIdMedicamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdFichaContrTeraMedicacao != null ? pkIdFichaContrTeraMedicacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterFichaContrTeraMedicacao)) {
            return false;
        }
        InterFichaContrTeraMedicacao other = (InterFichaContrTeraMedicacao) object;
        if ((this.pkIdFichaContrTeraMedicacao == null && other.pkIdFichaContrTeraMedicacao != null) || (this.pkIdFichaContrTeraMedicacao != null && !this.pkIdFichaContrTeraMedicacao.equals(other.pkIdFichaContrTeraMedicacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.InterFichaContrTeraMedicacao[ pkIdFichaContrTeraMedicacao=" + pkIdFichaContrTeraMedicacao + " ]";
    }
    
}
