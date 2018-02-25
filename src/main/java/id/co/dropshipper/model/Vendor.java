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
@Table(name = "vendor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendor.findAll", query = "SELECT v FROM Vendor v")
    , @NamedQuery(name = "Vendor.findByVendorid", query = "SELECT v FROM Vendor v WHERE v.vendorid = :vendorid")
    , @NamedQuery(name = "Vendor.findByVendorname", query = "SELECT v FROM Vendor v WHERE v.vendorname = :vendorname")
    , @NamedQuery(name = "Vendor.findByVendorphone", query = "SELECT v FROM Vendor v WHERE v.vendorphone = :vendorphone")
    , @NamedQuery(name = "Vendor.findByVendormail", query = "SELECT v FROM Vendor v WHERE v.vendormail = :vendormail")
    , @NamedQuery(name = "Vendor.findByIsactive", query = "SELECT v FROM Vendor v WHERE v.isactive = :isactive")})
public class Vendor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VENDORID")
    private Integer vendorid;
    @Size(max = 30)
    @Column(name = "VENDORNAME")
    private String vendorname;
    @Size(max = 13)
    @Column(name = "VENDORPHONE")
    private String vendorphone;
    @Size(max = 30)
    @Column(name = "VENDORMAIL")
    private String vendormail;
    @Column(name = "ISACTIVE")
    private Integer isactive;
    @OneToMany(mappedBy = "vendorid", fetch = FetchType.LAZY)
    private List<Barang> barangList;
    @JoinColumn(name = "LOKASIID", referencedColumnName = "LOKASIID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Lokasi lokasiid;

    public Vendor() {
    }

    public Vendor(Integer vendorid) {
        this.vendorid = vendorid;
    }

    public Integer getVendorid() {
        return vendorid;
    }

    public void setVendorid(Integer vendorid) {
        this.vendorid = vendorid;
    }

    public String getVendorname() {
        return vendorname;
    }

    public void setVendorname(String vendorname) {
        this.vendorname = vendorname;
    }

    public String getVendorphone() {
        return vendorphone;
    }

    public void setVendorphone(String vendorphone) {
        this.vendorphone = vendorphone;
    }

    public String getVendormail() {
        return vendormail;
    }

    public void setVendormail(String vendormail) {
        this.vendormail = vendormail;
    }

    public Integer getIsactive() {
        return isactive;
    }

    public void setIsactive(Integer isactive) {
        this.isactive = isactive;
    }

    @XmlTransient
    public List<Barang> getBarangList() {
        return barangList;
    }

    public void setBarangList(List<Barang> barangList) {
        this.barangList = barangList;
    }

    public Lokasi getLokasiid() {
        return lokasiid;
    }

    public void setLokasiid(Lokasi lokasiid) {
        this.lokasiid = lokasiid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendorid != null ? vendorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendor)) {
            return false;
        }
        Vendor other = (Vendor) object;
        if ((this.vendorid == null && other.vendorid != null) || (this.vendorid != null && !this.vendorid.equals(other.vendorid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.dropshipper.model.Vendor[ vendorid=" + vendorid + " ]";
    }
    
}
