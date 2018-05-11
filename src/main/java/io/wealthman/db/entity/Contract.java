package io.wealthman.db.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "contract")
public class Contract implements Serializable {

    @Id
    protected UUID id;

    @Column(name = "create_ts")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createTs;

    @Column(name = "expire_ts")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expireTs;

    @Column(name = "contract_num", length = 100)
    private String contractNum;

    @Column(name = "type", length = 100)
    private String type;

    @Column(name = "state", length = 100)
    private String state;

    @Column(name = "params", length = 2000)
    private String params;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private User manager;

    @ManyToOne
    @JoinColumn(name = "investor_id")
    private User investor;

    public Contract() {
    }

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

    public Date getExpireTs() {
        return expireTs;
    }

    public void setExpireTs(Date expireTs) {
        this.expireTs = expireTs;
    }

    public String getContractNum() {
        return contractNum;
    }

    public void setContractNum(String contractNum) {
        this.contractNum = contractNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public User getInvestor() {
        return investor;
    }

    public void setInvestor(User investor) {
        this.investor = investor;
    }
}
