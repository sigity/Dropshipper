/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.dropshipper.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author userx
 */
@Entity
@Table(name = "waktu_pengambilan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WaktuPengambilan.findAll", query = "SELECT w FROM WaktuPengambilan w")
    , @NamedQuery(name = "WaktuPengambilan.findByWaktuId", query = "SELECT w FROM WaktuPengambilan w WHERE w.waktuId = :waktuId")
    , @NamedQuery(name = "WaktuPengambilan.findByWaktuPengambilan", query = "SELECT w FROM WaktuPengambilan w WHERE w.waktuPengambilan = :waktuPengambilan")
    , @NamedQuery(name = "WaktuPengambilan.findByIsActive", query = "SELECT w FROM WaktuPengambilan w WHERE w.isActive = :isActive")})
public class WaktuPengambilan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "WAKTU_ID")
    private Integer waktuId;
    @Column(name = "WAKTU_PENGAMBILAN")
    @Temporal(TemporalType.TIME)
    private Date waktuPengambilan;
    @Column(name = "IS_ACTIVE")
    private Integer isActive;
    @OneToMany(mappedBy = "waktuId", fetch = FetchType.LAZY)
    private List<Transaksi> transaksiList;

    public WaktuPengambilan() {
    }

    public WaktuPengambilan(Integer waktuId) {
        this.waktuId = waktuId;
    }

    public Integer getWaktuId() {
        return waktuId;
    }

    public void setWaktuId(Integer waktuId) {
        this.waktuId = waktuId;
    }

    public Date getWaktuPengambilan() {
        return waktuPengambilan;
    }

    public void setWaktuPengambilan(Date waktuPengambilan) {
        this.waktuPengambilan = waktuPengambilan;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<Transaksi> getTransaksiList() {
        return transaksiList;
    }

    public void setTransaksiList(List<Transaksi> transaksiList) {
        this.transaksiList = transaksiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (waktuId != null ? waktuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WaktuPengambilan)) {
            return false;
        }
        WaktuPengambilan other = (WaktuPengambilan) object;
        if ((this.waktuId == null && other.waktuId != null) || (this.waktuId != null && !this.waktuId.equals(other.waktuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.dropshipper.model.WaktuPengambilan[ waktuId=" + waktuId + " ]";
    }
    
}
