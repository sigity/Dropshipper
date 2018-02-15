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
 * @author userx
 */
@Entity
@Table(name = "kategori")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kategori.findAll", query = "SELECT k FROM Kategori k")
    , @NamedQuery(name = "Kategori.findByKategoriId", query = "SELECT k FROM Kategori k WHERE k.kategoriId = :kategoriId")
    , @NamedQuery(name = "Kategori.findByKategoriName", query = "SELECT k FROM Kategori k WHERE k.kategoriName = :kategoriName")
    , @NamedQuery(name = "Kategori.findByKategoriLevel", query = "SELECT k FROM Kategori k WHERE k.kategoriLevel = :kategoriLevel")
    , @NamedQuery(name = "Kategori.findByKategoriParentId", query = "SELECT k FROM Kategori k WHERE k.kategoriParentId = :kategoriParentId")
    , @NamedQuery(name = "Kategori.findByIsActive", query = "SELECT k FROM Kategori k WHERE k.isActive = :isActive")})
public class Kategori implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "KATEGORI_ID")
    private Integer kategoriId;
    @Size(max = 20)
    @Column(name = "KATEGORI_NAME")
    private String kategoriName;
    @Column(name = "KATEGORI_LEVEL")
    private Integer kategoriLevel;
    @Column(name = "KATEGORI_PARENT_ID")
    private Integer kategoriParentId;
    @Column(name = "IS_ACTIVE")
    private Boolean isActive;
    @OneToMany(mappedBy = "kategoriId", fetch = FetchType.LAZY)
    private List<Barang> barangList;

    public Kategori() {
    }

    public Kategori(Integer kategoriId) {
        this.kategoriId = kategoriId;
    }

    public Integer getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(Integer kategoriId) {
        this.kategoriId = kategoriId;
    }

    public String getKategoriName() {
        return kategoriName;
    }

    public void setKategoriName(String kategoriName) {
        this.kategoriName = kategoriName;
    }

    public Integer getKategoriLevel() {
        return kategoriLevel;
    }

    public void setKategoriLevel(Integer kategoriLevel) {
        this.kategoriLevel = kategoriLevel;
    }

    public Integer getKategoriParentId() {
        return kategoriParentId;
    }

    public void setKategoriParentId(Integer kategoriParentId) {
        this.kategoriParentId = kategoriParentId;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<Barang> getBarangList() {
        return barangList;
    }

    public void setBarangList(List<Barang> barangList) {
        this.barangList = barangList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kategoriId != null ? kategoriId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kategori)) {
            return false;
        }
        Kategori other = (Kategori) object;
        if ((this.kategoriId == null && other.kategoriId != null) || (this.kategoriId != null && !this.kategoriId.equals(other.kategoriId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.dropshipper.model.Kategori[ kategoriId=" + kategoriId + " ]";
    }
    
}
