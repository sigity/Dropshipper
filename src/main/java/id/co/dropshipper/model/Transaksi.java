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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author userx
 */
@Entity
@Table(name = "transaksi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaksi.findAll", query = "SELECT t FROM Transaksi t")
    , @NamedQuery(name = "Transaksi.findByTransaksiId", query = "SELECT t FROM Transaksi t WHERE t.transaksiId = :transaksiId")
    , @NamedQuery(name = "Transaksi.findByTransaksiTgl", query = "SELECT t FROM Transaksi t WHERE t.transaksiTgl = :transaksiTgl")
    , @NamedQuery(name = "Transaksi.findByBiayaKurir", query = "SELECT t FROM Transaksi t WHERE t.biayaKurir = :biayaKurir")})
public class Transaksi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANSAKSI_ID")
    private Integer transaksiId;
    @Column(name = "TRANSAKSI_TGL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transaksiTgl;
    @Column(name = "BIAYA_KURIR")
    private Integer biayaKurir;
    @JoinColumn(name = "WAKTU_ID", referencedColumnName = "WAKTU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private WaktuPengambilan waktuId;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User userId;
    @OneToMany(mappedBy = "transaksiId", fetch = FetchType.LAZY)
    private List<Detailtransaksi> detailtransaksiList;

    public Transaksi() {
    }

    public Transaksi(Integer transaksiId) {
        this.transaksiId = transaksiId;
    }

    public Integer getTransaksiId() {
        return transaksiId;
    }

    public void setTransaksiId(Integer transaksiId) {
        this.transaksiId = transaksiId;
    }

    public Date getTransaksiTgl() {
        return transaksiTgl;
    }

    public void setTransaksiTgl(Date transaksiTgl) {
        this.transaksiTgl = transaksiTgl;
    }

    public Integer getBiayaKurir() {
        return biayaKurir;
    }

    public void setBiayaKurir(Integer biayaKurir) {
        this.biayaKurir = biayaKurir;
    }

    public WaktuPengambilan getWaktuId() {
        return waktuId;
    }

    public void setWaktuId(WaktuPengambilan waktuId) {
        this.waktuId = waktuId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        hash += (transaksiId != null ? transaksiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaksi)) {
            return false;
        }
        Transaksi other = (Transaksi) object;
        if ((this.transaksiId == null && other.transaksiId != null) || (this.transaksiId != null && !this.transaksiId.equals(other.transaksiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.dropshipper.model.Transaksi[ transaksiId=" + transaksiId + " ]";
    }
    
}
