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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sigit Yudhianto
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByUserid", query = "SELECT u FROM User u WHERE u.userid = :userid")
    , @NamedQuery(name = "User.findByUserktp", query = "SELECT u FROM User u WHERE u.userktp = :userktp")
    , @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username")
    , @NamedQuery(name = "User.findByNamauser", query = "SELECT u FROM User u WHERE u.namauser = :namauser")
    , @NamedQuery(name = "User.findByUsermail", query = "SELECT u FROM User u WHERE u.usermail = :usermail")
    , @NamedQuery(name = "User.findByUserpassword", query = "SELECT u FROM User u WHERE u.userpassword = :userpassword")
    , @NamedQuery(name = "User.findByUserphone", query = "SELECT u FROM User u WHERE u.userphone = :userphone")
    , @NamedQuery(name = "User.findByIsactive", query = "SELECT u FROM User u WHERE u.isactive = :isactive")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USERID")
    private Integer userid;
    @Size(max = 16)
    @Column(name = "USERKTP")
    private String userktp;
    @Size(max = 30)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 15)
    @Column(name = "NAMAUSER")
    private String namauser;
    @Size(max = 30)
    @Column(name = "USERMAIL")
    private String usermail;
    @Size(max = 20)
    @Column(name = "USERPASSWORD")
    private String userpassword;
    @Size(max = 13)
    @Column(name = "USERPHONE")
    private String userphone;
    @Column(name = "ISACTIVE")
    private Integer isactive;
    @OneToMany(mappedBy = "userid", fetch = FetchType.LAZY)
    private List<Transaksi> transaksiList;
    @OneToMany(mappedBy = "userid", fetch = FetchType.LAZY)
    private List<Rekening> rekeningList;
    @JoinColumn(name = "LOKASIID", referencedColumnName = "LOKASIID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Lokasi lokasiid;

    public User() {
    }

    public User(Integer userid) {
        this.userid = userid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUserktp() {
        return userktp;
    }

    public void setUserktp(String userktp) {
        this.userktp = userktp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNamauser() {
        return namauser;
    }

    public void setNamauser(String namauser) {
        this.namauser = namauser;
    }

    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public Integer getIsactive() {
        return isactive;
    }

    public void setIsactive(Integer isactive) {
        this.isactive = isactive;
    }

    @XmlTransient
    public List<Transaksi> getTransaksiList() {
        return transaksiList;
    }

    public void setTransaksiList(List<Transaksi> transaksiList) {
        this.transaksiList = transaksiList;
    }

    @XmlTransient
    public List<Rekening> getRekeningList() {
        return rekeningList;
    }

    public void setRekeningList(List<Rekening> rekeningList) {
        this.rekeningList = rekeningList;
    }

    public Lokasi getLokasiid() {
        return lokasiid;
    }

    public void setLokasiid(Lokasi lokasiid) {
        this.lokasiid = lokasiid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.dropshipper.model.User[ userid=" + userid + " ]";
    }
    
}
