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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauro
 */
@Entity
@Table(name = "grl_horario_intervalo", catalog = "sigh_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrlHorarioIntervalo.findAll", query = "SELECT g FROM GrlHorarioIntervalo g"),
    @NamedQuery(name = "GrlHorarioIntervalo.findByPkIdHorarioIntervalo", query = "SELECT g FROM GrlHorarioIntervalo g WHERE g.pkIdHorarioIntervalo = :pkIdHorarioIntervalo"),
    @NamedQuery(name = "GrlHorarioIntervalo.findByHoraInicio", query = "SELECT g FROM GrlHorarioIntervalo g WHERE g.horaInicio = :horaInicio"),
    @NamedQuery(name = "GrlHorarioIntervalo.findByHoraTermino", query = "SELECT g FROM GrlHorarioIntervalo g WHERE g.horaTermino = :horaTermino")})
public class GrlHorarioIntervalo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_horario_intervalo")
    private Integer pkIdHorarioIntervalo;
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Column(name = "hora_termino")
    @Temporal(TemporalType.TIME)
    private Date horaTermino;
    @JoinColumn(name = "fk_id_turno", referencedColumnName = "pk_id_turno")
    @ManyToOne(optional = false)
    private GrlTurno fkIdTurno;

    public GrlHorarioIntervalo() {
    }

    public GrlHorarioIntervalo(Integer pkIdHorarioIntervalo) {
        this.pkIdHorarioIntervalo = pkIdHorarioIntervalo;
    }

    public Integer getPkIdHorarioIntervalo() {
        return pkIdHorarioIntervalo;
    }

    public void setPkIdHorarioIntervalo(Integer pkIdHorarioIntervalo) {
        this.pkIdHorarioIntervalo = pkIdHorarioIntervalo;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(Date horaTermino) {
        this.horaTermino = horaTermino;
    }

    public GrlTurno getFkIdTurno() {
        return fkIdTurno;
    }

    public void setFkIdTurno(GrlTurno fkIdTurno) {
        this.fkIdTurno = fkIdTurno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdHorarioIntervalo != null ? pkIdHorarioIntervalo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrlHorarioIntervalo)) {
            return false;
        }
        GrlHorarioIntervalo other = (GrlHorarioIntervalo) object;
        if ((this.pkIdHorarioIntervalo == null && other.pkIdHorarioIntervalo != null) || (this.pkIdHorarioIntervalo != null && !this.pkIdHorarioIntervalo.equals(other.pkIdHorarioIntervalo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.GrlHorarioIntervalo[ pkIdHorarioIntervalo=" + pkIdHorarioIntervalo + " ]";
    }
    
}
