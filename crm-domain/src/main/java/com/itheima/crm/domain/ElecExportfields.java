package com.itheima.crm.domain;

import javax.persistence.*;

/**
 * Created by 13718 on 2017/9/12.
 */
@Entity
@Table(name = "elec_exportfields", schema = "itheima1128elec")
public class ElecExportfields {
    private String belongTo;
    private String expNameList;
    private String expFieldName;
    private String noExpNameList;
    private String noExpFieldName;

    @Id
    @Column(name = "belongTo", nullable = false, length = 255)
    public String getBelongTo() {
        return belongTo;
    }

    public void setBelongTo(String belongTo) {
        this.belongTo = belongTo;
    }

    @Basic
    @Column(name = "expNameList", nullable = true, length = 255)
    public String getExpNameList() {
        return expNameList;
    }

    public void setExpNameList(String expNameList) {
        this.expNameList = expNameList;
    }

    @Basic
    @Column(name = "expFieldName", nullable = true, length = 255)
    public String getExpFieldName() {
        return expFieldName;
    }

    public void setExpFieldName(String expFieldName) {
        this.expFieldName = expFieldName;
    }

    @Basic
    @Column(name = "noExpNameList", nullable = true, length = 255)
    public String getNoExpNameList() {
        return noExpNameList;
    }

    public void setNoExpNameList(String noExpNameList) {
        this.noExpNameList = noExpNameList;
    }

    @Basic
    @Column(name = "noExpFieldName", nullable = true, length = 255)
    public String getNoExpFieldName() {
        return noExpFieldName;
    }

    public void setNoExpFieldName(String noExpFieldName) {
        this.noExpFieldName = noExpFieldName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElecExportfields that = (ElecExportfields) o;

        if (belongTo != null ? !belongTo.equals(that.belongTo) : that.belongTo != null) return false;
        if (expNameList != null ? !expNameList.equals(that.expNameList) : that.expNameList != null) return false;
        if (expFieldName != null ? !expFieldName.equals(that.expFieldName) : that.expFieldName != null) return false;
        if (noExpNameList != null ? !noExpNameList.equals(that.noExpNameList) : that.noExpNameList != null)
            return false;
        if (noExpFieldName != null ? !noExpFieldName.equals(that.noExpFieldName) : that.noExpFieldName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = belongTo != null ? belongTo.hashCode() : 0;
        result = 31 * result + (expNameList != null ? expNameList.hashCode() : 0);
        result = 31 * result + (expFieldName != null ? expFieldName.hashCode() : 0);
        result = 31 * result + (noExpNameList != null ? noExpNameList.hashCode() : 0);
        result = 31 * result + (noExpFieldName != null ? noExpFieldName.hashCode() : 0);
        return result;
    }
}
