package io.wealthman.db.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "portfolio")
public class Portfolio implements Serializable {

    @Id
    protected UUID id;

    @Column(name = "create_ts")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createTs;

    @Column(name = "created_by")
    protected String createdBy;

    @Column(name = "expire_ts")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expireTs;

    @Column(name = "contract_num", length = 100)
    private String contractNum;

    @Column(name = "type", length = 100)
    private String type;

    @Column(name = "params", length = 2000)
    private String params;

    @Column(name = "portfolio_str", length = 4000)
    private String portfolioStr;

    @Column(name = "portfolio_hash", length = 200)
    private String portfolio_hash;

    public Portfolio() {
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getPortfolioStr() {
        return portfolioStr;
    }

    public void setPortfolioStr(String portfolioStr) {
        this.portfolioStr = portfolioStr;
    }

    public String getPortfolio_hash() {
        return portfolio_hash;
    }

    public void setPortfolio_hash(String portfolio_hash) {
        this.portfolio_hash = portfolio_hash;
    }
}
