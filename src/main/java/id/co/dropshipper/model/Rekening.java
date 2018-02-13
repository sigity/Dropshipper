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
 * @author userx
 */
@Entity
@Table(name = "rekening")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rekening.findAll", query = "SELECT r FROM Rekening r")
    , @NamedQuery(name = "Rekening.findByRekeningId", query = "SELECT r FROM Rekening r WHERE r.rekeningId = :rekeningId")
    , @NamedQuery(name = "Rekening.findByRekeningName", query = "SELECT r FROM Rekening r WHERE r.rekeningName = :rekeningName")})
public class Rekening implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "REKENING_ID")
    private Integer rekeningId;
    @Size(max = 30)
    @Column(name = "REKENING_NAME")
    private String rekeningName;
    @JoinColumn(name = "BANK_ID", referencedColumnName = "BANK_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Bank bankId;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User userId;

    public Rekening() {
    }

    public Rekening(Integer rekeningId) {
        this.rekeningId = rekeningId;
    }

    public Integer getRekeningId() {
        return rekeningId;
    }

    public void setRekeningId(Integer rekeningId) {
        this.rekeningId = rekeningId;
    }

    public String getRekeningName() {
        return rekeningName;
    }

    public void setRekeningName(String rekeningName) {
        this.rekeningName = rekeningName;
    }

    public Bank getBankId() {
        return bankId;
    }

    public void setBankId(Bank bankId) {
        this.bankId = bankId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rekeningId != null ? rekeningId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rekening)) {
            return false;
        }
        Rekening other = (Rekening) object;
        if ((this.rekeningId == null && other.rekeningId != null) || (this.rekeningId != null && !this.rekeningId.equals(other.rekeningId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.dropshipper.model.Rekening[ rekeningId=" + rekeningId + " ]";
    }
    
}
