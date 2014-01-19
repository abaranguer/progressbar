/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prova.progressbar.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author albert
 */
@Entity
@Table(name = "PROVA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prova.findAll", query = "SELECT p FROM Prova p"),
    @NamedQuery(name = "Prova.findById", query = "SELECT p FROM Prova p WHERE p.id = :id"),
    @NamedQuery(name = "Prova.findByName", query = "SELECT p FROM Prova p WHERE p.name = :name"),
    @NamedQuery(name = "Prova.findByValue", query = "SELECT p FROM Prova p WHERE p.value = :value"),
    @NamedQuery(name = "Prova.deleteAll", query = "DELETE FROM Prova")
})
public class Prova implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "VALUE")
    private String value;

    public Prova() {
    }

    public Prova(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prova)) {
            return false;
        }
        Prova other = (Prova) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prova.progressbar.model.Prova[ id=" + id + " ]";
    }
    
}
