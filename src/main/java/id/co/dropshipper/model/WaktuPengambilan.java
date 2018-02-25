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
 * @author Sigit Yudhianto
 */
@Entity
@Table(name = "waktupengambilan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Waktupengambilan.findAll", query = "SELECT w FROM Waktupengambilan w")
    , @NamedQuery(name = "Waktupengambilan.findByWaktuid", query = "SELECT w FROM Waktupengambilan w WHERE w.waktuid = :waktuid")
    , @NamedQuery(name = "Waktupengambilan.findByWaktupengambilan", query = "SELECT w FROM Waktupengambilan w WHERE w.waktupengambilan = :waktupengambilan")
    , @NamedQuery(name = "Waktupengambilan.findByIsactive", query = "SELECT w FROM Waktupengambilan w WHERE w.isactive = :isactive")})
public class Waktupengambilan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "WAKTUID")
    private Integer waktuid;
    @Column(name = "WAKTUPENGAMBILAN")
    @Temporal(TemporalType.TIME)
    private Date waktupengambilan;
    @Column(name = "ISACTIVE")
    private Integer isactive;
    @OneToMany(mappedBy = "waktuid", fetch = FetchType.LAZY)
    private List<Pengambilan> pengambilanList;
    @OneToMany(mappedBy = "waktuid", fetch = FetchType.LAZY)
    private List<Transaksi> transaksiList;

    public Waktupengambilan() {
    }

    public Waktupengambilan(Integer waktuid) {
        this.waktuid = waktuid;
    }

    public Integer getWaktuid() {
        return waktuid;
    }

    public void setWaktuid(Integer waktuid) {
        this.waktuid = waktuid;
    }

    public Date getWaktupengambilan() {
        return waktupengambilan;
    }

    public void setWaktupengambilan(Date waktupengambilan) {
        this.waktupengambilan = waktupengambilan;
    }

    public Integer getIsactive() {
        return isactive;
    }

    public void setIsactive(Integer isactive) {
        this.isactive = isactive;
    }

    @XmlTransient
    public List<Pengambilan> getPengambilanList() {
        return pengambilanList;
    }

    public void setPengambilanList(List<Pengambilan> pengambilanList) {
        this.pengambilanList = pengambilanList;
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
        hash += (waktuid != null ? waktuid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Waktupengambilan)) {
            return false;
        }
        Waktupengambilan other = (Waktupengambilan) object;
        if ((this.waktuid == null && other.waktuid != null) || (this.waktuid != null && !this.waktuid.equals(other.waktuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.dropshipper.model.Waktupengambilan[ waktuid=" + waktuid + " ]";
    }
    
}
