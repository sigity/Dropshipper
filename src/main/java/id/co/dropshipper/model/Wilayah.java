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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "wilayah")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wilayah.findAll", query = "SELECT w FROM Wilayah w")
    , @NamedQuery(name = "Wilayah.findByWilayahid", query = "SELECT w FROM Wilayah w WHERE w.wilayahid = :wilayahid")
    , @NamedQuery(name = "Wilayah.findByWilayahname", query = "SELECT w FROM Wilayah w WHERE w.wilayahname = :wilayahname")
    , @NamedQuery(name = "Wilayah.findByWilayahlevel", query = "SELECT w FROM Wilayah w WHERE w.wilayahlevel = :wilayahlevel")
    , @NamedQuery(name = "Wilayah.findByIsactive", query = "SELECT w FROM Wilayah w WHERE w.isactive = :isactive")})
public class Wilayah implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "WILAYAHID")
    private Integer wilayahid;
    @Size(max = 30)
    @Column(name = "WILAYAHNAME")
    private String wilayahname;
    @Column(name = "WILAYAHLEVEL")
    private Integer wilayahlevel;
    @Column(name = "ISACTIVE")
    private Integer isactive;
    @OneToMany(mappedBy = "wilayahparentid", fetch = FetchType.LAZY)
    private List<Wilayah> wilayahList;
    @JoinColumn(name = "WILAYAHPARENTID", referencedColumnName = "WILAYAHID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Wilayah wilayahparentid;
    @OneToMany(mappedBy = "wilayahid", fetch = FetchType.LAZY)
    private List<Lokasi> lokasiList;

    public Wilayah() {
    }

    public Wilayah(Integer wilayahid) {
        this.wilayahid = wilayahid;
    }

    public Integer getWilayahid() {
        return wilayahid;
    }

    public void setWilayahid(Integer wilayahid) {
        this.wilayahid = wilayahid;
    }

    public String getWilayahname() {
        return wilayahname;
    }

    public void setWilayahname(String wilayahname) {
        this.wilayahname = wilayahname;
    }

    public Integer getWilayahlevel() {
        return wilayahlevel;
    }

    public void setWilayahlevel(Integer wilayahlevel) {
        this.wilayahlevel = wilayahlevel;
    }

    public Integer getIsactive() {
        return isactive;
    }

    public void setIsactive(Integer isactive) {
        this.isactive = isactive;
    }

    @XmlTransient
    public List<Wilayah> getWilayahList() {
        return wilayahList;
    }

    public void setWilayahList(List<Wilayah> wilayahList) {
        this.wilayahList = wilayahList;
    }

    public Wilayah getWilayahparentid() {
        return wilayahparentid;
    }

    public void setWilayahparentid(Wilayah wilayahparentid) {
        this.wilayahparentid = wilayahparentid;
    }

    @XmlTransient
    public List<Lokasi> getLokasiList() {
        return lokasiList;
    }

    public void setLokasiList(List<Lokasi> lokasiList) {
        this.lokasiList = lokasiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wilayahid != null ? wilayahid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wilayah)) {
            return false;
        }
        Wilayah other = (Wilayah) object;
        if ((this.wilayahid == null && other.wilayahid != null) || (this.wilayahid != null && !this.wilayahid.equals(other.wilayahid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.dropshipper.model.Wilayah[ wilayahid=" + wilayahid + " ]";
    }
    
}
