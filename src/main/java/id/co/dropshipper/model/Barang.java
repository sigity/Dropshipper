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
import javax.persistence.Lob;
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
@Table(name = "barang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barang.findAll", query = "SELECT b FROM Barang b")
    , @NamedQuery(name = "Barang.findByBarangId", query = "SELECT b FROM Barang b WHERE b.barangId = :barangId")
    , @NamedQuery(name = "Barang.findBySku", query = "SELECT b FROM Barang b WHERE b.sku = :sku")
    , @NamedQuery(name = "Barang.findByBarangName", query = "SELECT b FROM Barang b WHERE b.barangName = :barangName")
    , @NamedQuery(name = "Barang.findByWarna", query = "SELECT b FROM Barang b WHERE b.warna = :warna")
    , @NamedQuery(name = "Barang.findByBarangBerat", query = "SELECT b FROM Barang b WHERE b.barangBerat = :barangBerat")
    , @NamedQuery(name = "Barang.findByBarangPrice", query = "SELECT b FROM Barang b WHERE b.barangPrice = :barangPrice")
    , @NamedQuery(name = "Barang.findByGambar", query = "SELECT b FROM Barang b WHERE b.gambar = :gambar")
    , @NamedQuery(name = "Barang.findByIsActive", query = "SELECT b FROM Barang b WHERE b.isActive = :isActive")})
public class Barang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BARANG_ID")
    private Integer barangId;
    @Size(max = 15)
    @Column(name = "SKU")
    private String sku;
    @Size(max = 30)
    @Column(name = "BARANG_NAME")
    private String barangName;
    @Size(max = 15)
    @Column(name = "WARNA")
    private String warna;
    @Column(name = "BARANG_BERAT")
    private Integer barangBerat;
    @Column(name = "BARANG_PRICE")
    private Integer barangPrice;
    @Size(max = 255)
    @Column(name = "GAMBAR")
    private String gambar;
    @Lob
    @Size(max = 65535)
    @Column(name = "BARANG_KETERANGAN")
    private String barangKeterangan;
    @Column(name = "IS_ACTIVE")
    private int isActive;
    @JoinColumn(name = "VENDOR_ID", referencedColumnName = "VENDOR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Vendor vendorId;
    @JoinColumn(name = "KATEGORI_ID", referencedColumnName = "KATEGORI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Kategori kategoriId;
    @OneToMany(mappedBy = "barangId", fetch = FetchType.LAZY)
    private List<Detailtransaksi> detailtransaksiList;

    public Barang() {
    }

    public Barang(Integer barangId) {
        this.barangId = barangId;
    }

    public Integer getBarangId() {
        return barangId;
    }

    public void setBarangId(Integer barangId) {
        this.barangId = barangId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getBarangName() {
        return barangName;
    }

    public void setBarangName(String barangName) {
        this.barangName = barangName;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public Integer getBarangBerat() {
        return barangBerat;
    }

    public void setBarangBerat(Integer barangBerat) {
        this.barangBerat = barangBerat;
    }

    public Integer getBarangPrice() {
        return barangPrice;
    }

    public void setBarangPrice(Integer barangPrice) {
        this.barangPrice = barangPrice;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getBarangKeterangan() {
        return barangKeterangan;
    }

    public void setBarangKeterangan(String barangKeterangan) {
        this.barangKeterangan = barangKeterangan;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public Vendor getVendorId() {
        return vendorId;
    }

    public void setVendorId(Vendor vendorId) {
        this.vendorId = vendorId;
    }

    public Kategori getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(Kategori kategoriId) {
        this.kategoriId = kategoriId;
    }

    @XmlTransient
    public List<Detailtransaksi> getDetailtransaksiList() {
        return detailtransaksiList;
    }

    public void setDetailtransaksiList(List<Detailtransaksi> detailtransaksiList) {
        this.detailtransaksiList = detailtransaksiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (barangId != null ? barangId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barang)) {
            return false;
        }
        Barang other = (Barang) object;
        if ((this.barangId == null && other.barangId != null) || (this.barangId != null && !this.barangId.equals(other.barangId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.dropshipper.model.Barang[ barangId=" + barangId + " ]";
    }
    
}
