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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sigit Yudhianto
 */
@Entity
@Table(name = "rekening")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rekening.findAll", query = "SELECT r FROM Rekening r")
    , @NamedQuery(name = "Rekening.findByRekeningid", query = "SELECT r FROM Rekening r WHERE r.rekeningid = :rekeningid")
    , @NamedQuery(name = "Rekening.findByRekeningnumber", query = "SELECT r FROM Rekening r WHERE r.rekeningnumber = :rekeningnumber")
    , @NamedQuery(name = "Rekening.findByRekeningname", query = "SELECT r FROM Rekening r WHERE r.rekeningname = :rekeningname")})
public class Rekening implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "REKENINGID")
    private Integer rekeningid;
    @Column(name = "REKENINGNUMBER")
    private Integer rekeningnumber;
    @Size(max = 30)
    @Column(name = "REKENINGNAME")
    private String rekeningname;
    @JoinColumn(name = "BANKID", referencedColumnName = "BANKID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Bank bankid;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User userid;

    public Rekening() {
    }

    public Rekening(Integer rekeningid) {
        this.rekeningid = rekeningid;
    }

    public Integer getRekeningid() {
        return rekeningid;
    }

    public void setRekeningid(Integer rekeningid) {
        this.rekeningid = rekeningid;
    }

    public Integer getRekeningnumber() {
        return rekeningnumber;
    }

    public void setRekeningnumber(Integer rekeningnumber) {
        this.rekeningnumber = rekeningnumber;
    }

    public String getRekeningname() {
        return rekeningname;
    }

    public void setRekeningname(String rekeningname) {
        this.rekeningname = rekeningname;
    }

    public Bank getBankid() {
        return bankid;
    }

    public void setBankid(Bank bankid) {
        this.bankid = bankid;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rekeningid != null ? rekeningid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rekening)) {
            return false;
        }
        Rekening other = (Rekening) object;
        if ((this.rekeningid == null && other.rekeningid != null) || (this.rekeningid != null && !this.rekeningid.equals(other.rekeningid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.dropshipper.model.Rekening[ rekeningid=" + rekeningid + " ]";
    }
    
}
