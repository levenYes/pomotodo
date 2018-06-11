package cn.liwenye.bean;

import java.util.Date;

/**
 * @author liwenye
 *
 * @date 20180610
 */
public class Pomos {
    private String uuid;

    private Date createdAt;

    private Date updatedAt;

    private String created_at;

    private String updated_at;

    private String description;

    private Date startedAt;

    private Date endedAt;

    private Date localStartedAt;

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getStarted_at() {
        return started_at;
    }

    public void setStarted_at(String started_at) {
        this.started_at = started_at;
    }

    public String getEnded_at() {
        return ended_at;
    }

    public void setEnded_at(String ended_at) {
        this.ended_at = ended_at;
    }

    public String getLocal_started_at() {
        return local_started_at;
    }

    public void setLocal_started_at(String local_started_at) {
        this.local_started_at = local_started_at;
    }

    public String getLocal_ended_at() {
        return local_ended_at;
    }

    public void setLocal_ended_at(String local_ended_at) {
        this.local_ended_at = local_ended_at;
    }

    private Date localEndedAt;

    private String started_at;

    private String ended_at;

    private String local_started_at;

    private String local_ended_at;

    private Integer length;

    private Boolean abandoned;

    private Boolean manual;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
    }

    public Date getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(Date endedAt) {
        this.endedAt = endedAt;
    }

    public Date getLocalStartedAt() {
        return localStartedAt;
    }

    public void setLocalStartedAt(Date localStartedAt) {
        this.localStartedAt = localStartedAt;
    }

    public Date getLocalEndedAt() {
        return localEndedAt;
    }

    public void setLocalEndedAt(Date localEndedAt) {
        this.localEndedAt = localEndedAt;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Boolean getAbandoned() {
        return abandoned;
    }

    public void setAbandoned(Boolean abandoned) {
        this.abandoned = abandoned;
    }

    public Boolean getManual() {
        return manual;
    }

    public void setManual(Boolean manual) {
        this.manual = manual;
    }
}