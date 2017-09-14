package com.itheima.crm.domain;

import javax.persistence.*;

/**
 * Created by 13718 on 2017/9/12.
 */
@Entity
@Table(name = "elec_role_popedom", schema = "itheima1128elec")
@IdClass(ElecRolePopedomPK.class)
public class ElecRolePopedom {
    private String roleId;
    private String mid;
    private String pid;

    @Id
    @Column(name = "roleID", nullable = false, length = 255)
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Id
    @Column(name = "mid", nullable = false, length = 255)
    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    @Id
    @Column(name = "pid", nullable = false, length = 255)
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

        ElecRolePopedom that = (ElecRolePopedom) o;

        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
        if (mid != null ? !mid.equals(that.mid) : that.mid != null) return false;
        if (pid != null ? !pid.equals(that.pid) : that.pid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (mid != null ? mid.hashCode() : 0);
        result = 31 * result + (pid != null ? pid.hashCode() : 0);
        return result;
    }
}
