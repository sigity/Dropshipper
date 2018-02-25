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
@Table(name = "lokasi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lokasi.findAll", query = "SELECT l FROM Lokasi l")
    , @NamedQuery(name = "Lokasi.findByLokasiid", query = "SELECT l FROM Lokasi l WHERE l.lokasiid = :lokasiid")
    , @NamedQuery(name = "Lokasi.findByAlamatlengkap", query = "SELECT l FROM Lokasi l WHERE l.alamatlengkap = :alamatlengkap")
    , @NamedQuery(name = "Lokasi.findByKodepos", query = "SELECT l FROM Lokasi l WHERE l.kodepos = :kodepos")
    , @NamedQuery(name = "Lokasi.findByIsactive", query = "SELECT l FROM Lokasi l WHERE l.isactive = :isactive")})
public class Lokasi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LOKASIID")
    private Integer lokasiid;
    @Size(max = 30)
    @Column(name = "ALAMATLENGKAP")
    private String alamatlengkap;
    @Column(name = "KODEPOS")
    private Integer kodepos;
    @Column(name = "ISACTIVE")
    private Integer isactive;
    @JoinColumn(name = "WILAYAHID", referencedColumnName = "WILAYAHID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Wilayah wilayahid;
    @OneToMany(mappedBy = "lokasiid", fetch = FetchType.LAZY)
    private List<Vendor> vendorList;
    @OneToMany(mappedBy = "lokasiid", fetch = FetchType.LAZY)
    private List<User> userList;

    public Lokasi() {
    }

    public Lokasi(Integer lokasiid) {
        this.lokasiid = lokasiid;
    }

    public Integer getLokasiid() {
        return lokasiid;
    }

    public void setLokasiid(Integer lokasiid) {
        this.lokasiid = lokasiid;
    }

    public String getAlamatlengkap() {
        return alamatlengkap;
    }

    public void setAlamatlengkap(String alamatlengkap) {
        this.alamatlengkap = alamatlengkap;
    }

    public Integer getKodepos() {
        return kodepos;
    }

    public void setKodepos(Integer kodepos) {
        this.kodepos = kodepos;
    }

    public Integer getIsactive() {
        return isactive;
    }

    public void setIsactive(Integer isactive) {
        this.isactive = isactive;
    }

    public Wilayah getWilayahid() {
        return wilayahid;
    }

    public void setWilayahid(Wilayah wilayahid) {
        this.wilayahid = wilayahid;
    }

    @XmlTransient
    public List<Vendor> getVendorList() {
        return vendorList;
    }

    public void setVendorList(List<Vendor> vendorList) {
        this.vendorList = vendorList;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lokasiid != null ? lokasiid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lokasi)) {
            return false;
        }
        Lokasi other = (Lokasi) object;
        if ((this.lokasiid == null && other.lokasiid != null) || (this.lokasiid != null && !this.lokasiid.equals(other.lokasiid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.dropshipper.model.Lokasi[ lokasiid=" + lokasiid + " ]";
    }
    
}
