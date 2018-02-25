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
 * @author Sigit Yudhianto
 */
@Entity
@Table(name = "bank")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bank.findAll", query = "SELECT b FROM Bank b")
    , @NamedQuery(name = "Bank.findByBankid", query = "SELECT b FROM Bank b WHERE b.bankid = :bankid")
    , @NamedQuery(name = "Bank.findByBankname", query = "SELECT b FROM Bank b WHERE b.bankname = :bankname")
    , @NamedQuery(name = "Bank.findByIsactive", query = "SELECT b FROM Bank b WHERE b.isactive = :isactive")})
public class Bank implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BANKID")
    private Integer bankid;
    @Size(max = 30)
    @Column(name = "BANKNAME")
    private String bankname;
    @Column(name = "ISACTIVE")
    private Integer isactive;
    @OneToMany(mappedBy = "bankid", fetch = FetchType.LAZY)
    private List<Rekening> rekeningList;

    public Bank() {
    }

    public Bank(Integer bankid) {
        this.bankid = bankid;
    }

    public Integer getBankid() {
        return bankid;
    }

    public void setBankid(Integer bankid) {
        this.bankid = bankid;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public Integer getIsactive() {
        return isactive;
    }

    public void setIsactive(Integer isactive) {
        this.isactive = isactive;
    }

    @XmlTransient
    public List<Rekening> getRekeningList() {
        return rekeningList;
    }

    public void setRekeningList(List<Rekening> rekeningList) {
        this.rekeningList = rekeningList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bankid != null ? bankid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bank)) {
            return false;
        }
        Bank other = (Bank) object;
        if ((this.bankid == null && other.bankid != null) || (this.bankid != null && !this.bankid.equals(other.bankid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.dropshipper.model.Bank[ bankid=" + bankid + " ]";
    }
    
}
