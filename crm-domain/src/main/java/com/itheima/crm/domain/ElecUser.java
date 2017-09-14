package com.itheima.crm.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by 13718 on 2017/9/12.
 */
@Entity
@Table(name = "elec_user", schema = "itheima1128elec")
public class ElecUser {
    private String userId;
    private String jctId;
    private String jctUnitId;
    private String userName;
    private String logonName;
    private String logonPwd;
    private String sexId;
    private Date birthday;
    private String address;
    private String contactTel;
    private String email;
    private String mobile;
    private String isDuty;
    private String postId;
    private Date onDutyDate;
    private Date offDutyDate;
    private String remark;

    @Id
    @Column(name = "userID", nullable = false, length = 255)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "jctID", nullable = true, length = 255)
    public String getJctId() {
        return jctId;
    }

    public void setJctId(String jctId) {
        this.jctId = jctId;
    }

    @Basic
    @Column(name = "jctUnitID", nullable = true, length = 255)
    public String getJctUnitId() {
        return jctUnitId;
    }

    public void setJctUnitId(String jctUnitId) {
        this.jctUnitId = jctUnitId;
    }

    @Basic
    @Column(name = "userName", nullable = true, length = 255)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "logonName", nullable = true, length = 255)
    public String getLogonName() {
        return logonName;
    }

    public void setLogonName(String logonName) {
        this.logonName = logonName;
    }

    @Basic
    @Column(name = "logonPwd", nullable = true, length = 255)
    public String getLogonPwd() {
        return logonPwd;
    }

    public void setLogonPwd(String logonPwd) {
        this.logonPwd = logonPwd;
    }

    @Basic
    @Column(name = "sexID", nullable = true, length = 255)
    public String getSexId() {
        return sexId;
    }

    public void setSexId(String sexId) {
        this.sexId = sexId;
    }

    @Basic
    @Column(name = "birthday", nullable = true)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "contactTel", nullable = true, length = 255)
    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "mobile", nullable = true, length = 255)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "isDuty", nullable = true, length = 255)
    public String getIsDuty() {
        return isDuty;
    }

    public void setIsDuty(String isDuty) {
        this.isDuty = isDuty;
    }

    @Basic
    @Column(name = "postID", nullable = true, length = 255)
    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    @Basic
    @Column(name = "onDutyDate", nullable = true)
    public Date getOnDutyDate() {
        return onDutyDate;
    }

    public void setOnDutyDate(Date onDutyDate) {
        this.onDutyDate = onDutyDate;
    }

    @Basic
    @Column(name = "offDutyDate", nullable = true)
    public Date getOffDutyDate() {
        return offDutyDate;
    }

    public void setOffDutyDate(Date offDutyDate) {
        this.offDutyDate = offDutyDate;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 255)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElecUser elecUser = (ElecUser) o;

        if (userId != null ? !userId.equals(elecUser.userId) : elecUser.userId != null) return false;
        if (jctId != null ? !jctId.equals(elecUser.jctId) : elecUser.jctId != null) return false;
        if (jctUnitId != null ? !jctUnitId.equals(elecUser.jctUnitId) : elecUser.jctUnitId != null) return false;
        if (userName != null ? !userName.equals(elecUser.userName) : elecUser.userName != null) return false;
        if (logonName != null ? !logonName.equals(elecUser.logonName) : elecUser.logonName != null) return false;
        if (logonPwd != null ? !logonPwd.equals(elecUser.logonPwd) : elecUser.logonPwd != null) return false;
        if (sexId != null ? !sexId.equals(elecUser.sexId) : elecUser.sexId != null) return false;
        if (birthday != null ? !birthday.equals(elecUser.birthday) : elecUser.birthday != null) return false;
        if (address != null ? !address.equals(elecUser.address) : elecUser.address != null) return false;
        if (contactTel != null ? !contactTel.equals(elecUser.contactTel) : elecUser.contactTel != null) return false;
        if (email != null ? !email.equals(elecUser.email) : elecUser.email != null) return false;
        if (mobile != null ? !mobile.equals(elecUser.mobile) : elecUser.mobile != null) return false;
        if (isDuty != null ? !isDuty.equals(elecUser.isDuty) : elecUser.isDuty != null) return false;
        if (postId != null ? !postId.equals(elecUser.postId) : elecUser.postId != null) return false;
        if (onDutyDate != null ? !onDutyDate.equals(elecUser.onDutyDate) : elecUser.onDutyDate != null) return false;
        if (offDutyDate != null ? !offDutyDate.equals(elecUser.offDutyDate) : elecUser.offDutyDate != null)
            return false;
        if (remark != null ? !remark.equals(elecUser.remark) : elecUser.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (jctId != null ? jctId.hashCode() : 0);
        result = 31 * result + (jctUnitId != null ? jctUnitId.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (logonName != null ? logonName.hashCode() : 0);
        result = 31 * result + (logonPwd != null ? logonPwd.hashCode() : 0);
        result = 31 * result + (sexId != null ? sexId.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (contactTel != null ? contactTel.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (isDuty != null ? isDuty.hashCode() : 0);
        result = 31 * result + (postId != null ? postId.hashCode() : 0);
        result = 31 * result + (onDutyDate != null ? onDutyDate.hashCode() : 0);
        result = 31 * result + (offDutyDate != null ? offDutyDate.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
