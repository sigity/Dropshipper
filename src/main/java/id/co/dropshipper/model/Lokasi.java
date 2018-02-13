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
@Table(name = "lokasi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lokasi.findAll", query = "SELECT l FROM Lokasi l")
    , @NamedQuery(name = "Lokasi.findByLokasiId", query = "SELECT l FROM Lokasi l WHERE l.lokasiId = :lokasiId")
    , @NamedQuery(name = "Lokasi.findByKodepos", query = "SELECT l FROM Lokasi l WHERE l.kodepos = :kodepos")
    , @NamedQuery(name = "Lokasi.findByAlamat", query = "SELECT l FROM Lokasi l WHERE l.alamat = :alamat")})
public class Lokasi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LOKASI_ID")
    private Integer lokasiId;
    @Column(name = "KODEPOS")
    private Long kodepos;
    @Size(max = 50)
    @Column(name = "ALAMAT")
    private String alamat;
    @JoinColumn(name = "WILAYAH_ID", referencedColumnName = "WILAYAH_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Wilayah wilayahId;
    @OneToMany(mappedBy = "lokasiId", fetch = FetchType.LAZY)
    private List<Vendor> vendorList;
    @OneToMany(mappedBy = "lokasiId", fetch = FetchType.LAZY)
    private List<User> userList;

    public Lokasi() {
    }

    public Lokasi(Integer lokasiId) {
        this.lokasiId = lokasiId;
    }

    public Integer getLokasiId() {
        return lokasiId;
    }

    public void setLokasiId(Integer lokasiId) {
        this.lokasiId = lokasiId;
    }

    public Long getKodepos() {
        return kodepos;
    }

    public void setKodepos(Long kodepos) {
        this.kodepos = kodepos;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Wilayah getWilayahId() {
        return wilayahId;
    }

    public void setWilayahId(Wilayah wilayahId) {
        this.wilayahId = wilayahId;
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
        hash += (lokasiId != null ? lokasiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lokasi)) {
            return false;
        }
        Lokasi other = (Lokasi) object;
        if ((this.lokasiId == null && other.lokasiId != null) || (this.lokasiId != null && !this.lokasiId.equals(other.lokasiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.dropshipper.model.Lokasi[ lokasiId=" + lokasiId + " ]";
    }
    
}
