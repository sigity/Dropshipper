/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.dropshipper.model;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sigit Yudhianto
 */
@Entity
@Table(name = "detailtransaksi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detailtransaksi.findAll", query = "SELECT d FROM Detailtransaksi d")
    , @NamedQuery(name = "Detailtransaksi.findByDetailid", query = "SELECT d FROM Detailtransaksi d WHERE d.detailid = :detailid")
    , @NamedQuery(name = "Detailtransaksi.findByDetailqty", query = "SELECT d FROM Detailtransaksi d WHERE d.detailqty = :detailqty")
    , @NamedQuery(name = "Detailtransaksi.findByDetailtotal", query = "SELECT d FROM Detailtransaksi d WHERE d.detailtotal = :detailtotal")
    , @NamedQuery(name = "Detailtransaksi.findByTotalberat", query = "SELECT d FROM Detailtransaksi d WHERE d.totalberat = :totalberat")
    , @NamedQuery(name = "Detailtransaksi.findByIsactive", query = "SELECT d FROM Detailtransaksi d WHERE d.isactive = :isactive")})
public class Detailtransaksi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DETAILID")
    private Integer detailid;
    @Column(name = "DETAILQTY")
    private Integer detailqty;
    @Column(name = "DETAILTOTAL")
    private Integer detailtotal;
    @Column(name = "TOTALBERAT")
    private Integer totalberat;
    @Column(name = "ISACTIVE")
    private Integer isactive;
    @JoinColumn(name = "TRANSAKSIID", referencedColumnName = "TRANSAKSIID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Transaksi transaksiid;
    @JoinColumn(name = "BARANGID", referencedColumnName = "BARANGID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Barang barangid;

    public Detailtransaksi() {
    }

    public Detailtransaksi(Integer detailid) {
        this.detailid = detailid;
    }

    public Integer getDetailid() {
        return detailid;
    }

    public void setDetailid(Integer detailid) {
        this.detailid = detailid;
    }

    public Integer getDetailqty() {
        return detailqty;
    }

    public void setDetailqty(Integer detailqty) {
        this.detailqty = detailqty;
    }

    public Integer getDetailtotal() {
        return detailtotal;
    }

    public void setDetailtotal(Integer detailtotal) {
        this.detailtotal = detailtotal;
    }

    public Integer getTotalberat() {
        return totalberat;
    }

    public void setTotalberat(Integer totalberat) {
        this.totalberat = totalberat;
    }

    public Integer getIsactive() {
        return isactive;
    }

    public void setIsactive(Integer isactive) {
        this.isactive = isactive;
    }

    public Transaksi getTransaksiid() {
        return transaksiid;
    }

    public void setTransaksiid(Transaksi transaksiid) {
        this.transaksiid = transaksiid;
    }

    public Barang getBarangid() {
        return barangid;
    }

    public void setBarangid(Barang barangid) {
        this.barangid = barangid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detailid != null ? detailid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detailtransaksi)) {
            return false;
        }
        Detailtransaksi other = (Detailtransaksi) object;
        if ((this.detailid == null && other.detailid != null) || (this.detailid != null && !this.detailid.equals(other.detailid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.dropshipper.model.Detailtransaksi[ detailid=" + detailid + " ]";
    }
    
}
