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
 * @author Sigit Yudhianto
 */
@Entity
@Table(name = "barang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barang.findAll", query = "SELECT b FROM Barang b")
    , @NamedQuery(name = "Barang.findByBarangid", query = "SELECT b FROM Barang b WHERE b.barangid = :barangid")
    , @NamedQuery(name = "Barang.findBySku", query = "SELECT b FROM Barang b WHERE b.sku = :sku")
    , @NamedQuery(name = "Barang.findByBarangname", query = "SELECT b FROM Barang b WHERE b.barangname = :barangname")
    , @NamedQuery(name = "Barang.findByWarna", query = "SELECT b FROM Barang b WHERE b.warna = :warna")
    , @NamedQuery(name = "Barang.findByBerat", query = "SELECT b FROM Barang b WHERE b.berat = :berat")
    , @NamedQuery(name = "Barang.findByDimensi", query = "SELECT b FROM Barang b WHERE b.dimensi = :dimensi")
    , @NamedQuery(name = "Barang.findByHarga", query = "SELECT b FROM Barang b WHERE b.harga = :harga")
    , @NamedQuery(name = "Barang.findByIsactive", query = "SELECT b FROM Barang b WHERE b.isactive = :isactive")})
public class Barang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BARANGID")
    private Integer barangid;
    @Size(max = 20)
    @Column(name = "SKU")
    private String sku;
    @Size(max = 30)
    @Column(name = "BARANGNAME")
    private String barangname;
    @Size(max = 20)
    @Column(name = "WARNA")
    private String warna;
    @Column(name = "BERAT")
    private Integer berat;
    @Size(max = 20)
    @Column(name = "DIMENSI")
    private String dimensi;
    @Column(name = "HARGA")
    private Integer harga;
    @Lob
    @Size(max = 65535)
    @Column(name = "KETERANGAN")
    private String keterangan;
    @Lob
    @Column(name = "GAMBAR")
    private byte[] gambar;
    @Column(name = "ISACTIVE")
    private Integer isactive;
    @JoinColumn(name = "VENDORID", referencedColumnName = "VENDORID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Vendor vendorid;
    @JoinColumn(name = "KATEGORIID", referencedColumnName = "KATEGORIID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Kategori kategoriid;
    @OneToMany(mappedBy = "barangid", fetch = FetchType.LAZY)
    private List<Detailtransaksi> detailtransaksiList;

    public Barang() {
    }

    public Barang(Integer barangid) {
        this.barangid = barangid;
    }

    public Integer getBarangid() {
        return barangid;
    }

    public void setBarangid(Integer barangid) {
        this.barangid = barangid;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getBarangname() {
        return barangname;
    }

    public void setBarangname(String barangname) {
        this.barangname = barangname;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public Integer getBerat() {
        return berat;
    }

    public void setBerat(Integer berat) {
        this.berat = berat;
    }

    public String getDimensi() {
        return dimensi;
    }

    public void setDimensi(String dimensi) {
        this.dimensi = dimensi;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public byte[] getGambar() {
        return gambar;
    }

    public void setGambar(byte[] gambar) {
        this.gambar = gambar;
    }

    public Integer getIsactive() {
        return isactive;
    }

    public void setIsactive(Integer isactive) {
        this.isactive = isactive;
    }

    public Vendor getVendorid() {
        return vendorid;
    }

    public void setVendorid(Vendor vendorid) {
        this.vendorid = vendorid;
    }

    public Kategori getKategoriid() {
        return kategoriid;
    }

    public void setKategoriid(Kategori kategoriid) {
        this.kategoriid = kategoriid;
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
        hash += (barangid != null ? barangid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barang)) {
            return false;
        }
        Barang other = (Barang) object;
        if ((this.barangid == null && other.barangid != null) || (this.barangid != null && !this.barangid.equals(other.barangid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.dropshipper.model.Barang[ barangid=" + barangid + " ]";
    }
    
}
