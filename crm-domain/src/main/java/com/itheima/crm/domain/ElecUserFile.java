package com.itheima.crm.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by 13718 on 2017/9/12.
 */
@Entity
@Table(name = "elec_user_file", schema = "itheima1128elec")
public class ElecUserFile {
    private String fileId;
    private String fileName;
    private String fileUrl;
    private Timestamp progressTime;
    private String userId;

    @Id
    @Column(name = "fileID", nullable = false, length = 255)
    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
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
    @Column(name = "fileURL", nullable = true, length = 255)
    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Basic
    @Column(name = "progressTime", nullable = true)
    public Timestamp getProgressTime() {
        return progressTime;
    }

    public void setProgressTime(Timestamp progressTime) {
        this.progressTime = progressTime;
    }

    @Basic
    @Column(name = "userID", nullable = true, length = 255)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElecUserFile that = (ElecUserFile) o;

        if (fileId != null ? !fileId.equals(that.fileId) : that.fileId != null) return false;
        if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) return false;
        if (fileUrl != null ? !fileUrl.equals(that.fileUrl) : that.fileUrl != null) return false;
        if (progressTime != null ? !progressTime.equals(that.progressTime) : that.progressTime != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fileId != null ? fileId.hashCode() : 0;
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (fileUrl != null ? fileUrl.hashCode() : 0);
        result = 31 * result + (progressTime != null ? progressTime.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
