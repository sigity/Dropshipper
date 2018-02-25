/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.dropshipper.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sigit Yudhianto
 */
@Entity
@Table(name = "pengambilan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pengambilan.findAll", query = "SELECT p FROM Pengambilan p")
    , @NamedQuery(name = "Pengambilan.findByPengambilanid", query = "SELECT p FROM Pengambilan p WHERE p.pengambilanid = :pengambilanid")
    , @NamedQuery(name = "Pengambilan.findByIsactive", query = "SELECT p FROM Pengambilan p WHERE p.isactive = :isactive")})
public class Pengambilan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PENGAMBILANID")
    private Integer pengambilanid;
    @Column(name = "ISACTIVE")
    private Integer isactive;
    @JoinColumn(name = "WAKTUID", referencedColumnName = "WAKTUID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Waktupengambilan waktuid;
    @JoinColumn(name = "KURIRID", referencedColumnName = "KURIRID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Kurir kuririd;

    public Pengambilan() {
    }

    public Pengambilan(Integer pengambilanid) {
        this.pengambilanid = pengambilanid;
    }

    public Integer getPengambilanid() {
        return pengambilanid;
    }

    public void setPengambilanid(Integer pengambilanid) {
        this.pengambilanid = pengambilanid;
    }

    public Integer getIsactive() {
        return isactive;
    }

    public void setIsactive(Integer isactive) {
        this.isactive = isactive;
    }

    public Waktupengambilan getWaktuid() {
        return waktuid;
    }

    public void setWaktuid(Waktupengambilan waktuid) {
        this.waktuid = waktuid;
    }

    public Kurir getKuririd() {
        return kuririd;
    }

    public void setKuririd(Kurir kuririd) {
        this.kuririd = kuririd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pengambilanid != null ? pengambilanid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pengambilan)) {
            return false;
        }
        Pengambilan other = (Pengambilan) object;
        if ((this.pengambilanid == null && other.pengambilanid != null) || (this.pengambilanid != null && !this.pengambilanid.equals(other.pengambilanid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.dropshipper.model.Pengambilan[ pengambilanid=" + pengambilanid + " ]";
    }
    
}
