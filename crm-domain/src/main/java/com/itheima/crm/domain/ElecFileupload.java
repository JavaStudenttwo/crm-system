package com.itheima.crm.domain;

import javax.persistence.*;

/**
 * Created by 13718 on 2017/9/12.
 */
@Entity
@Table(name = "elec_fileupload", schema = "itheima1128elec")
public class ElecFileupload {
    private int seqId;
    private String projId;
    private String belongTo;
    private String fileName;
    private String fileUrl;
    private String progressTime;
    private String comment;

    @Id
    @Column(name = "seqId", nullable = false)
    public int getSeqId() {
        return seqId;
    }

    public void setSeqId(int seqId) {
        this.seqId = seqId;
    }

    @Basic
    @Column(name = "projId", nullable = true, length = 255)
    public String getProjId() {
        return projId;
    }

    public void setProjId(String projId) {
        this.projId = projId;
    }

    @Basic
    @Column(name = "belongTo", nullable = true, length = 255)
    public String getBelongTo() {
        return belongTo;
    }

    public void setBelongTo(String belongTo) {
        this.belongTo = belongTo;
    }

    @Basic
    @Column(name = "fileName", nullable = true, length = 255)
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Basic
    @Column(name = "fileUrl", nullable = true, length = 255)
    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Basic
    @Column(name = "progressTime", nullable = true, length = 255)
    public String getProgressTime() {
        return progressTime;
    }

    public void setProgressTime(String progressTime) {
        this.progressTime = progressTime;
    }

    @Basic
    @Column(name = "comment", nullable = true, length = 255)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElecFileupload that = (ElecFileupload) o;

        if (seqId != that.seqId) return false;
        if (projId != null ? !projId.equals(that.projId) : that.projId != null) return false;
        if (belongTo != null ? !belongTo.equals(that.belongTo) : that.belongTo != null) return false;
        if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) return false;
        if (fileUrl != null ? !fileUrl.equals(that.fileUrl) : that.fileUrl != null) return false;
        if (progressTime != null ? !progressTime.equals(that.progressTime) : that.progressTime != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = seqId;
        result = 31 * result + (projId != null ? projId.hashCode() : 0);
        result = 31 * result + (belongTo != null ? belongTo.hashCode() : 0);
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (fileUrl != null ? fileUrl.hashCode() : 0);
        result = 31 * result + (progressTime != null ? progressTime.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }
}
