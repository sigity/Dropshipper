/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.dropshipper.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author Sigit Yudhianto
 */
@Entity
@Table(name = "kurir")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kurir.findAll", query = "SELECT k FROM Kurir k")
    , @NamedQuery(name = "Kurir.findByKuririd", query = "SELECT k FROM Kurir k WHERE k.kuririd = :kuririd")
    , @NamedQuery(name = "Kurir.findByKurirname", query = "SELECT k FROM Kurir k WHERE k.kurirname = :kurirname")
    , @NamedQuery(name = "Kurir.findByIsactive", query = "SELECT k FROM Kurir k WHERE k.isactive = :isactive")})
public class Kurir implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "KURIRID")
    private Integer kuririd;
    @Size(max = 30)
    @Column(name = "KURIRNAME")
    private String kurirname;
    @Column(name = "ISACTIVE")
    private Integer isactive;
    @OneToMany(mappedBy = "kuririd", fetch = FetchType.LAZY)
    private List<Pengambilan> pengambilanList;

    public Kurir() {
    }

    public Kurir(Integer kuririd) {
        this.kuririd = kuririd;
    }

    public Integer getKuririd() {
        return kuririd;
    }

    public void setKuririd(Integer kuririd) {
        this.kuririd = kuririd;
    }

    public String getKurirname() {
        return kurirname;
    }

    public void setKurirname(String kurirname) {
        this.kurirname = kurirname;
    }

    public Integer getIsactive() {
        return isactive;
    }

    public void setIsactive(Integer isactive) {
        this.isactive = isactive;
    }

    @XmlTransient
    public List<Pengambilan> getPengambilanList() {
        return pengambilanList;
    }

    public void setPengambilanList(List<Pengambilan> pengambilanList) {
        this.pengambilanList = pengambilanList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kuririd != null ? kuririd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kurir)) {
            return false;
        }
        Kurir other = (Kurir) object;
        if ((this.kuririd == null && other.kuririd != null) || (this.kuririd != null && !this.kuririd.equals(other.kuririd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.dropshipper.model.Kurir[ kuririd=" + kuririd + " ]";
    }
    
}
