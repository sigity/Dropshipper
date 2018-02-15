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
 * @author userx
 */
@Entity
@Table(name = "bank")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bank.findAll", query = "SELECT b FROM Bank b")
    , @NamedQuery(name = "Bank.findByBankId", query = "SELECT b FROM Bank b WHERE b.bankId = :bankId")
    , @NamedQuery(name = "Bank.findByBankName", query = "SELECT b FROM Bank b WHERE b.bankName = :bankName")
    , @NamedQuery(name = "Bank.findByBankTrfcd", query = "SELECT b FROM Bank b WHERE b.bankTrfcd = :bankTrfcd")
    , @NamedQuery(name = "Bank.findByIsActive", query = "SELECT b FROM Bank b WHERE b.isActive = :isActive")})
public class Bank implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BANK_ID")
    private Integer bankId;
    @Size(max = 30)
    @Column(name = "BANK_NAME")
    private String bankName;
    @Size(max = 10)
    @Column(name = "BANK_TRFCD")
    private String bankTrfcd;
    @Column(name = "IS_ACTIVE")
    private Boolean isActive;
    @OneToMany(mappedBy = "bankId", fetch = FetchType.LAZY)
    private List<Rekening> rekeningList;

    public Bank() {
    }

    public Bank(Integer bankId) {
        this.bankId = bankId;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankTrfcd() {
        return bankTrfcd;
    }

    public void setBankTrfcd(String bankTrfcd) {
        this.bankTrfcd = bankTrfcd;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
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
        hash += (bankId != null ? bankId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bank)) {
            return false;
        }
        Bank other = (Bank) object;
        if ((this.bankId == null && other.bankId != null) || (this.bankId != null && !this.bankId.equals(other.bankId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.dropshipper.model.Bank[ bankId=" + bankId + " ]";
    }
    
}
