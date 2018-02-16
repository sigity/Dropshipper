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
 * @author userx
 */
@Entity
@Table(name = "vendor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendor.findAll", query = "SELECT v FROM Vendor v")
    , @NamedQuery(name = "Vendor.findByVendorId", query = "SELECT v FROM Vendor v WHERE v.vendorId = :vendorId")
    , @NamedQuery(name = "Vendor.findByVendorName", query = "SELECT v FROM Vendor v WHERE v.vendorName = :vendorName")
    , @NamedQuery(name = "Vendor.findByVendorPhone", query = "SELECT v FROM Vendor v WHERE v.vendorPhone = :vendorPhone")
    , @NamedQuery(name = "Vendor.findByVendorEmail", query = "SELECT v FROM Vendor v WHERE v.vendorEmail = :vendorEmail")
    , @NamedQuery(name = "Vendor.findByIsActive", query = "SELECT v FROM Vendor v WHERE v.isActive = :isActive")})
public class Vendor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VENDOR_ID")
    private Integer vendorId;
    @Size(max = 20)
    @Column(name = "VENDOR_NAME")
    private String vendorName;
    @Size(max = 13)
    @Column(name = "VENDOR_PHONE")
    private String vendorPhone;
    @Size(max = 30)
    @Column(name = "VENDOR_EMAIL")
    private String vendorEmail;
    @Column(name = "IS_ACTIVE")
    private Integer isActive;
    @OneToMany(mappedBy = "vendorId", fetch = FetchType.LAZY)
    private List<Barang> barangList;
    @JoinColumn(name = "LOKASI_ID", referencedColumnName = "LOKASI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Lokasi lokasiId;

    public Vendor() {
    }

    public Vendor(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorPhone() {
        return vendorPhone;
    }

    public void setVendorPhone(String vendorPhone) {
        this.vendorPhone = vendorPhone;
    }

    public String getVendorEmail() {
        return vendorEmail;
    }

    public void setVendorEmail(String vendorEmail) {
        this.vendorEmail = vendorEmail;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<Barang> getBarangList() {
        return barangList;
    }

    public void setBarangList(List<Barang> barangList) {
        this.barangList = barangList;
    }

    public Lokasi getLokasiId() {
        return lokasiId;
    }

    public void setLokasiId(Lokasi lokasiId) {
        this.lokasiId = lokasiId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendorId != null ? vendorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendor)) {
            return false;
        }
        Vendor other = (Vendor) object;
        if ((this.vendorId == null && other.vendorId != null) || (this.vendorId != null && !this.vendorId.equals(other.vendorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.dropshipper.model.Vendor[ vendorId=" + vendorId + " ]";
    }
    
}
