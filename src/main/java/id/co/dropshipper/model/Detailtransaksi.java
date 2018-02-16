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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author userx
 */
@Entity
@Table(name = "detailtransaksi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detailtransaksi.findAll", query = "SELECT d FROM Detailtransaksi d")
    , @NamedQuery(name = "Detailtransaksi.findByDetailId", query = "SELECT d FROM Detailtransaksi d WHERE d.detailId = :detailId")
    , @NamedQuery(name = "Detailtransaksi.findByDetailQty", query = "SELECT d FROM Detailtransaksi d WHERE d.detailQty = :detailQty")
    , @NamedQuery(name = "Detailtransaksi.findByDetailTotal", query = "SELECT d FROM Detailtransaksi d WHERE d.detailTotal = :detailTotal")
    , @NamedQuery(name = "Detailtransaksi.findByTotalBerat", query = "SELECT d FROM Detailtransaksi d WHERE d.totalBerat = :totalBerat")
    , @NamedQuery(name = "Detailtransaksi.findByIsActive", query = "SELECT d FROM Detailtransaksi d WHERE d.isActive = :isActive")})
public class Detailtransaksi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DETAIL_ID")
    private Integer detailId;
    @Column(name = "DETAIL_QTY")
    private Integer detailQty;
    @Column(name = "DETAIL_TOTAL")
    private Integer detailTotal;
    @Column(name = "TOTAL_BERAT")
    private Integer totalBerat;
    @Column(name = "IS_ACTIVE")
    private Integer isActive;
    @OneToMany(mappedBy = "detailId", fetch = FetchType.LAZY)
    private List<Pengambilan> pengambilanList;
    @JoinColumn(name = "BARANG_ID", referencedColumnName = "BARANG_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Barang barangId;
    @JoinColumn(name = "TRANSAKSI_ID", referencedColumnName = "TRANSAKSI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Transaksi transaksiId;

    public Detailtransaksi() {
    }

    public Detailtransaksi(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getDetailQty() {
        return detailQty;
    }

    public void setDetailQty(Integer detailQty) {
        this.detailQty = detailQty;
    }

    public Integer getDetailTotal() {
        return detailTotal;
    }

    public void setDetailTotal(Integer detailTotal) {
        this.detailTotal = detailTotal;
    }

    public Integer getTotalBerat() {
        return totalBerat;
    }

    public void setTotalBerat(Integer totalBerat) {
        this.totalBerat = totalBerat;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<Pengambilan> getPengambilanList() {
        return pengambilanList;
    }

    public void setPengambilanList(List<Pengambilan> pengambilanList) {
        this.pengambilanList = pengambilanList;
    }

    public Barang getBarangId() {
        return barangId;
    }

    public void setBarangId(Barang barangId) {
        this.barangId = barangId;
    }

    public Transaksi getTransaksiId() {
        return transaksiId;
    }

    public void setTransaksiId(Transaksi transaksiId) {
        this.transaksiId = transaksiId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detailId != null ? detailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detailtransaksi)) {
            return false;
        }
        Detailtransaksi other = (Detailtransaksi) object;
        if ((this.detailId == null && other.detailId != null) || (this.detailId != null && !this.detailId.equals(other.detailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.dropshipper.model.Detailtransaksi[ detailId=" + detailId + " ]";
    }
    
}
