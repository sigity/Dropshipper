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
 * @author userx
 */
@Entity
@Table(name = "pengambilan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pengambilan.findAll", query = "SELECT p FROM Pengambilan p")
    , @NamedQuery(name = "Pengambilan.findByPengambilanId", query = "SELECT p FROM Pengambilan p WHERE p.pengambilanId = :pengambilanId")})
public class Pengambilan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PENGAMBILAN_ID")
    private Integer pengambilanId;
    @JoinColumn(name = "DETAIL_ID", referencedColumnName = "DETAIL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Detailtransaksi detailId;
    @JoinColumn(name = "KURIR_ID", referencedColumnName = "KURIR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Kurir kurirId;

    public Pengambilan() {
    }

    public Pengambilan(Integer pengambilanId) {
        this.pengambilanId = pengambilanId;
    }

    public Integer getPengambilanId() {
        return pengambilanId;
    }

    public void setPengambilanId(Integer pengambilanId) {
        this.pengambilanId = pengambilanId;
    }

    public Detailtransaksi getDetailId() {
        return detailId;
    }

    public void setDetailId(Detailtransaksi detailId) {
        this.detailId = detailId;
    }

    public Kurir getKurirId() {
        return kurirId;
    }

    public void setKurirId(Kurir kurirId) {
        this.kurirId = kurirId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pengambilanId != null ? pengambilanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pengambilan)) {
            return false;
        }
        Pengambilan other = (Pengambilan) object;
        if ((this.pengambilanId == null && other.pengambilanId != null) || (this.pengambilanId != null && !this.pengambilanId.equals(other.pengambilanId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.dropshipper.model.Pengambilan[ pengambilanId=" + pengambilanId + " ]";
    }
    
}
