package com.itheima.crm.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by 13718 on 2017/9/12.
 */
@Entity
@Table(name = "elec_text", schema = "itheima1128elec")
public class ElecText {
    private String textId;
    private String textName;
    private String textRemark;
    private Timestamp textDate;

    @Id
    @Column(name = "textID", nullable = false, length = 50)
    public String getTextId() {
        return textId;
    }

    public void setTextId(String textId) {
        this.textId = textId;
    }

    @Basic
    @Column(name = "textName", nullable = true, length = 50)
    public String getTextName() {
        return textName;
    }

    public void setTextName(String textName) {
        this.textName = textName;
    }

    @Basic
    @Column(name = "textRemark", nullable = true, length = 500)
    public String getTextRemark() {
        return textRemark;
    }

    public void setTextRemark(String textRemark) {
        this.textRemark = textRemark;
    }

    @Basic
    @Column(name = "textDate", nullable = true)
    public Timestamp getTextDate() {
        return textDate;
    }

    public void setTextDate(Timestamp textDate) {
        this.textDate = textDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElecText elecText = (ElecText) o;

        if (textId != null ? !textId.equals(elecText.textId) : elecText.textId != null) return false;
        if (textName != null ? !textName.equals(elecText.textName) : elecText.textName != null) return false;
        if (textRemark != null ? !textRemark.equals(elecText.textRemark) : elecText.textRemark != null) return false;
        if (textDate != null ? !textDate.equals(elecText.textDate) : elecText.textDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = textId != null ? textId.hashCode() : 0;
        result = 31 * result + (textName != null ? textName.hashCode() : 0);
        result = 31 * result + (textRemark != null ? textRemark.hashCode() : 0);
        result = 31 * result + (textDate != null ? textDate.hashCode() : 0);
        return result;
    }


}
