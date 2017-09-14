package com.itheima.crm.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 13718 on 2017/9/12.
 */
@Entity
@Table(name = "elec_popedom", schema = "itheima1128elec")
@IdClass(ElecPopedomPK.class)
public class ElecPopedom {
    private String mid;
    private String pid;
    private String name;
    private String url;
    private String icon;
    private String target;
    private Boolean isParent;
    private Boolean isMenu;


    /**非持久化javabean属性*/
    //表示如果一个父包含的所有子的集合
    private List<ElecPopedom> list = new ArrayList<ElecPopedom>();
    //角色ID
    private String roleID;
    /**
     * 添加一个标识，判断页面的复选框是否被选中，该标识要放置到ElecPopedom对象中
     flag=1：选中
     flag=2：没有被选中
     */
    private String flag;

    //页面中传递的选中的功能权限
    private String [] selectoper;

    //页面中传递的选中的用户ID
    private String [] selectuser;

    public List<ElecPopedom> getList() {
        return list;
    }

    public void setList(List<ElecPopedom> list) {
        this.list = list;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String[] getSelectoper() {
        return selectoper;
    }

    public void setSelectoper(String[] selectoper) {
        this.selectoper = selectoper;
    }

    public String[] getSelectuser() {
        return selectuser;
    }

    public void setSelectuser(String[] selectuser) {
        this.selectuser = selectuser;
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

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "url", nullable = true, length = 255)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "icon", nullable = true, length = 255)
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "target", nullable = true, length = 255)
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Basic
    @Column(name = "isParent", nullable = true)
    public Boolean getParent() {
        return isParent;
    }

    public void setParent(Boolean parent) {
        isParent = parent;
    }

    @Basic
    @Column(name = "isMenu", nullable = true)
    public Boolean getMenu() {
        return isMenu;
    }

    public void setMenu(Boolean menu) {
        isMenu = menu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElecPopedom that = (ElecPopedom) o;

        if (mid != null ? !mid.equals(that.mid) : that.mid != null) return false;
        if (pid != null ? !pid.equals(that.pid) : that.pid != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (icon != null ? !icon.equals(that.icon) : that.icon != null) return false;
        if (target != null ? !target.equals(that.target) : that.target != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mid != null ? mid.hashCode() : 0;
        result = 31 * result + (pid != null ? pid.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (target != null ? target.hashCode() : 0);
        return result;
    }
}
