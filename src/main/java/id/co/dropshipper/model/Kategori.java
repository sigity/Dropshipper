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
@Table(name = "kategori")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kategori.findAll", query = "SELECT k FROM Kategori k")
    , @NamedQuery(name = "Kategori.findByKategoriid", query = "SELECT k FROM Kategori k WHERE k.kategoriid = :kategoriid")
    , @NamedQuery(name = "Kategori.findByKategoriname", query = "SELECT k FROM Kategori k WHERE k.kategoriname = :kategoriname")
    , @NamedQuery(name = "Kategori.findByKategorilevel", query = "SELECT k FROM Kategori k WHERE k.kategorilevel = :kategorilevel")
    , @NamedQuery(name = "Kategori.findByIsactive", query = "SELECT k FROM Kategori k WHERE k.isactive = :isactive")})
public class Kategori implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "KATEGORIID")
    private Integer kategoriid;
    @Size(max = 30)
    @Column(name = "KATEGORINAME")
    private String kategoriname;
    @Column(name = "KATEGORILEVEL")
    private Integer kategorilevel;
    @Column(name = "ISACTIVE")
    private Integer isactive;
    @OneToMany(mappedBy = "kategoriid", fetch = FetchType.LAZY)
    private List<Barang> barangList;
    @OneToMany(mappedBy = "kategoriparentid", fetch = FetchType.LAZY)
    private List<Kategori> kategoriList;
    @JoinColumn(name = "KATEGORIPARENTID", referencedColumnName = "KATEGORIID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Kategori kategoriparentid;

    public Kategori() {
    }

    public Kategori(Integer kategoriid) {
        this.kategoriid = kategoriid;
    }

    public Integer getKategoriid() {
        return kategoriid;
    }

    public void setKategoriid(Integer kategoriid) {
        this.kategoriid = kategoriid;
    }

    public String getKategoriname() {
        return kategoriname;
    }

    public void setKategoriname(String kategoriname) {
        this.kategoriname = kategoriname;
    }

    public Integer getKategorilevel() {
        return kategorilevel;
    }

    public void setKategorilevel(Integer kategorilevel) {
        this.kategorilevel = kategorilevel;
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

    @XmlTransient
    public List<Kategori> getKategoriList() {
        return kategoriList;
    }

    public void setKategoriList(List<Kategori> kategoriList) {
        this.kategoriList = kategoriList;
    }

    public Kategori getKategoriparentid() {
        return kategoriparentid;
    }

    public void setKategoriparentid(Kategori kategoriparentid) {
        this.kategoriparentid = kategoriparentid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kategoriid != null ? kategoriid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kategori)) {
            return false;
        }
        Kategori other = (Kategori) object;
        if ((this.kategoriid == null && other.kategoriid != null) || (this.kategoriid != null && !this.kategoriid.equals(other.kategoriid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.dropshipper.model.Kategori[ kategoriid=" + kategoriid + " ]";
    }
    
}
