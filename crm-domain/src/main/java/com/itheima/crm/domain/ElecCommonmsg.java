package com.itheima.crm.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 13718 on 2017/9/12.
 */
@Entity
@Table(name = "elec_commonmsg", schema = "itheima1128elec")
public class ElecCommonmsg {
    private String comId;
    private String stationRun;
    private String devRun;
    private Date createDate;

    @Id
    @Column(name = "comID", nullable = false, length = 255)
    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    @Basic
    @Column(name = "stationRun", nullable = true, length = 255)
    public String getStationRun() {
        return stationRun;
    }

    public void setStationRun(String stationRun) {
        this.stationRun = stationRun;
    }

    @Basic
    @Column(name = "devRun", nullable = true, length = 255)
    public String getDevRun() {
        return devRun;
    }

    public void setDevRun(String devRun) {
        this.devRun = devRun;
    }

    @Basic
    @Column(name = "createDate", nullable = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElecCommonmsg that = (ElecCommonmsg) o;

        if (comId != null ? !comId.equals(that.comId) : that.comId != null) return false;
        if (stationRun != null ? !stationRun.equals(that.stationRun) : that.stationRun != null) return false;
        if (devRun != null ? !devRun.equals(that.devRun) : that.devRun != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = comId != null ? comId.hashCode() : 0;
        result = 31 * result + (stationRun != null ? stationRun.hashCode() : 0);
        result = 31 * result + (devRun != null ? devRun.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
