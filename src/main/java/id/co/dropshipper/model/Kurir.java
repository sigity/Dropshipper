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
@Table(name = "kurir")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kurir.findAll", query = "SELECT k FROM Kurir k")
    , @NamedQuery(name = "Kurir.findByKurirId", query = "SELECT k FROM Kurir k WHERE k.kurirId = :kurirId")
    , @NamedQuery(name = "Kurir.findByKurirName", query = "SELECT k FROM Kurir k WHERE k.kurirName = :kurirName")
    , @NamedQuery(name = "Kurir.findByIsActive", query = "SELECT k FROM Kurir k WHERE k.isActive = :isActive")})
public class Kurir implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "KURIR_ID")
    private Integer kurirId;
    @Size(max = 25)
    @Column(name = "KURIR_NAME")
    private String kurirName;
    @Column(name = "IS_ACTIVE")
    private Boolean isActive;
    @OneToMany(mappedBy = "kurirId", fetch = FetchType.LAZY)
    private List<Pengambilan> pengambilanList;

    public Kurir() {
    }

    public Kurir(Integer kurirId) {
        this.kurirId = kurirId;
    }

    public Integer getKurirId() {
        return kurirId;
    }

    public void setKurirId(Integer kurirId) {
        this.kurirId = kurirId;
    }

    public String getKurirName() {
        return kurirName;
    }

    public void setKurirName(String kurirName) {
        this.kurirName = kurirName;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<Pengambilan> getPengambilanList() {
        return pengambilanList;
    }

    public void setPengambilanList(List<Pengambilan> pengambilanList) {
        this.pengambilanList = pengambilanList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kurirId != null ? kurirId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kurir)) {
            return false;
        }
        Kurir other = (Kurir) object;
        if ((this.kurirId == null && other.kurirId != null) || (this.kurirId != null && !this.kurirId.equals(other.kurirId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.dropshipper.model.Kurir[ kurirId=" + kurirId + " ]";
    }
    
}
