package com.itheima.crm.domain;

import javax.persistence.*;

/**
 * Created by 13718 on 2017/9/12.
 */
@Entity
@Table(name = "elec_systemddl", schema = "itheima1128elec")
public class ElecSystemddl {
    private int seqId;
    private String keyword;
    private Integer ddlCode;
    private String ddlName;

    @Id
    @Column(name = "seqID", nullable = false)
    public int getSeqId() {
        return seqId;
    }

    public void setSeqId(int seqId) {
        this.seqId = seqId;
    }

    @Basic
    @Column(name = "keyword", nullable = true, length = 255)
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Basic
    @Column(name = "ddlCode", nullable = true)
    public Integer getDdlCode() {
        return ddlCode;
    }

    public void setDdlCode(Integer ddlCode) {
        this.ddlCode = ddlCode;
    }

    @Basic
    @Column(name = "ddlName", nullable = true, length = 255)
    public String getDdlName() {
        return ddlName;
    }

    public void setDdlName(String ddlName) {
        this.ddlName = ddlName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElecSystemddl that = (ElecSystemddl) o;

        if (seqId != that.seqId) return false;
        if (keyword != null ? !keyword.equals(that.keyword) : that.keyword != null) return false;
        if (ddlCode != null ? !ddlCode.equals(that.ddlCode) : that.ddlCode != null) return false;
        if (ddlName != null ? !ddlName.equals(that.ddlName) : that.ddlName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = seqId;
        result = 31 * result + (keyword != null ? keyword.hashCode() : 0);
        result = 31 * result + (ddlCode != null ? ddlCode.hashCode() : 0);
        result = 31 * result + (ddlName != null ? ddlName.hashCode() : 0);
        return result;
    }
}
