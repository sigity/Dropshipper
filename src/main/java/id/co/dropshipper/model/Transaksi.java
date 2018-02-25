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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Sigit Yudhianto
 */
@Entity
@Table(name = "transaksi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaksi.findAll", query = "SELECT t FROM Transaksi t")
    , @NamedQuery(name = "Transaksi.findByTransaksiid", query = "SELECT t FROM Transaksi t WHERE t.transaksiid = :transaksiid")
    , @NamedQuery(name = "Transaksi.findByTransaksitgl", query = "SELECT t FROM Transaksi t WHERE t.transaksitgl = :transaksitgl")
    , @NamedQuery(name = "Transaksi.findByTglpengiriman", query = "SELECT t FROM Transaksi t WHERE t.tglpengiriman = :tglpengiriman")
    , @NamedQuery(name = "Transaksi.findByIsactive", query = "SELECT t FROM Transaksi t WHERE t.isactive = :isactive")})
public class Transaksi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TRANSAKSIID")
    private Integer transaksiid;
    @Column(name = "TRANSAKSITGL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transaksitgl;
    @Column(name = "TGLPENGIRIMAN")
    @Temporal(TemporalType.DATE)
    private Date tglpengiriman;
    @Column(name = "ISACTIVE")
    private Integer isactive;
    @JoinColumn(name = "WAKTUID", referencedColumnName = "WAKTUID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Waktupengambilan waktuid;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User userid;
    @OneToMany(mappedBy = "transaksiid", fetch = FetchType.LAZY)
    private List<Detailtransaksi> detailtransaksiList;

    public Transaksi() {
    }

    public Transaksi(Integer transaksiid) {
        this.transaksiid = transaksiid;
    }

    public Integer getTransaksiid() {
        return transaksiid;
    }

    public void setTransaksiid(Integer transaksiid) {
        this.transaksiid = transaksiid;
    }

    public Date getTransaksitgl() {
        return transaksitgl;
    }

    public void setTransaksitgl(Date transaksitgl) {
        this.transaksitgl = transaksitgl;
    }

    public Date getTglpengiriman() {
        return tglpengiriman;
    }

    public void setTglpengiriman(Date tglpengiriman) {
        this.tglpengiriman = tglpengiriman;
    }

    public Integer getIsactive() {
        return isactive;
    }

    public void setIsactive(Integer isactive) {
        this.isactive = isactive;
    }

    public Waktupengambilan getWaktuid() {
        return waktuid;
    }

    public void setWaktuid(Waktupengambilan waktuid) {
        this.waktuid = waktuid;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
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
        hash += (transaksiid != null ? transaksiid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaksi)) {
            return false;
        }
        Transaksi other = (Transaksi) object;
        if ((this.transaksiid == null && other.transaksiid != null) || (this.transaksiid != null && !this.transaksiid.equals(other.transaksiid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.dropshipper.model.Transaksi[ transaksiid=" + transaksiid + " ]";
    }
    
}
