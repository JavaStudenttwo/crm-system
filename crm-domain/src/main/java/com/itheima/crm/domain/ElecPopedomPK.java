package com.itheima.crm.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by 13718 on 2017/9/12.
 */
public class ElecPopedomPK implements Serializable {
    private String mid;
    private String pid;

    @Column(name = "mid", nullable = false, length = 255)
    @Id
    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    @Column(name = "pid", nullable = false, length = 255)
    @Id
    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElecPopedomPK that = (ElecPopedomPK) o;

        if (mid != null ? !mid.equals(that.mid) : that.mid != null) return false;
        if (pid != null ? !pid.equals(that.pid) : that.pid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mid != null ? mid.hashCode() : 0;
        result = 31 * result + (pid != null ? pid.hashCode() : 0);
        return result;
    }
}
