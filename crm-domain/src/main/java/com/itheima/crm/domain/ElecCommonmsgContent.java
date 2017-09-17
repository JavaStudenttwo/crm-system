package com.itheima.crm.domain;

import javax.persistence.*;

/**
 * Created by 13718 on 2017/9/12.
 */
@Entity
@Table(name = "elec_commonmsg_content", schema = "itheima1128elec")
public class ElecCommonmsgContent {
    private String comId;
    private String type;
    private String content;
    /**
     * 因存入数据时考虑content属性大小有限，所以对一条大数据进行分割，分割成了几条小数据
     * orderby属性记录的是次数据属于总数据的第几条
     */
    private Integer orderby;

    @Id
    @Column(name = "comID", nullable = false, length = 255)
    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 255)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 255)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "orderby", nullable = true)
    public Integer getOrderby() {
        return orderby;
    }

    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElecCommonmsgContent that = (ElecCommonmsgContent) o;

        if (comId != null ? !comId.equals(that.comId) : that.comId != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (orderby != null ? !orderby.equals(that.orderby) : that.orderby != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = comId != null ? comId.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (orderby != null ? orderby.hashCode() : 0);
        return result;
    }
}
