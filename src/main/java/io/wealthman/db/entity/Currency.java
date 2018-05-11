package io.wealthman.db.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "currency")
public class Currency implements Serializable {

    @Id
    protected UUID id;

    @Column(name = "create_ts")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createTs;

    @Column(name = "created_by")
    protected String createdBy;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "descr", length = 200)
    private String descr;

    public Currency() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getCreateTs() {
        return createTs;
    }

    public void setCreateTs(Date createTs) {
        this.createTs = createTs;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
