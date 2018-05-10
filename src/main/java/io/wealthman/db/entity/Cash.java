package io.wealthman.db.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "cash")
public class Cash implements Serializable {
    @Id
    private UUID id;

    @Column(name = "create_ts", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTs;

    @Column(name = "type", length = 100, nullable = false)
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    @ManyToOne
    @JoinColumn(name = "curr_id", nullable = false)
    private Currency currency;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CurrCourse course;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "overhead")
    private Double overhead;

    @Column(name = "params", length = 2000)
    private String params;

    public Cash() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public CurrCourse getCourse() {
        return course;
    }

    public void setCourse(CurrCourse course) {
        this.course = course;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getOverhead() {
        return overhead;
    }

    public void setOverhead(Double overhead) {
        this.overhead = overhead;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cash cash = (Cash) o;
        return Objects.equals(id, cash.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
