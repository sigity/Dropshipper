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
@Table(name = "wilayah")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wilayah.findAll", query = "SELECT w FROM Wilayah w")
    , @NamedQuery(name = "Wilayah.findByWilayahId", query = "SELECT w FROM Wilayah w WHERE w.wilayahId = :wilayahId")
    , @NamedQuery(name = "Wilayah.findByWilayahName", query = "SELECT w FROM Wilayah w WHERE w.wilayahName = :wilayahName")
    , @NamedQuery(name = "Wilayah.findByLevel", query = "SELECT w FROM Wilayah w WHERE w.level = :level")
    , @NamedQuery(name = "Wilayah.findByIsActive", query = "SELECT w FROM Wilayah w WHERE w.isActive = :isActive")})
public class Wilayah implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "WILAYAH_ID")
    private Integer wilayahId;
    @Size(max = 20)
    @Column(name = "WILAYAH_NAME")
    private String wilayahName;
    @Column(name = "LEVEL")
    private Integer level;
    @Column(name = "IS_ACTIVE")
    private Integer isActive;
    @OneToMany(mappedBy = "parentId", fetch = FetchType.LAZY)
    private List<Wilayah> wilayahList;
    @JoinColumn(name = "PARENT_ID", referencedColumnName = "WILAYAH_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Wilayah parentId;
    @OneToMany(mappedBy = "wilayahId", fetch = FetchType.LAZY)
    private List<Lokasi> lokasiList;

    public Wilayah() {
    }

    public Wilayah(Integer wilayahId) {
        this.wilayahId = wilayahId;
    }

    public Integer getWilayahId() {
        return wilayahId;
    }

    public void setWilayahId(Integer wilayahId) {
        this.wilayahId = wilayahId;
    }

    public String getWilayahName() {
        return wilayahName;
    }

    public void setWilayahName(String wilayahName) {
        this.wilayahName = wilayahName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<Wilayah> getWilayahList() {
        return wilayahList;
    }

    public void setWilayahList(List<Wilayah> wilayahList) {
        this.wilayahList = wilayahList;
    }

    public Wilayah getParentId() {
        return parentId;
    }

    public void setParentId(Wilayah parentId) {
        this.parentId = parentId;
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
        hash += (wilayahId != null ? wilayahId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wilayah)) {
            return false;
        }
        Wilayah other = (Wilayah) object;
        if ((this.wilayahId == null && other.wilayahId != null) || (this.wilayahId != null && !this.wilayahId.equals(other.wilayahId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.dropshipper.model.Wilayah[ wilayahId=" + wilayahId + " ]";
    }
    
}
