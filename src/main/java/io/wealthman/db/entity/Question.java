package io.wealthman.db.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "question")
public class Question implements Serializable {

    @Id
    protected UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "form_id")
    private QuestForm form;

    @Column(name = "num")
    private Integer num;

    @Column(name = "type", length = 100, nullable = false)
    private String type;

    @Column(name = "params", length = 100)
    private String params;

    @Column(name = "text", length = 2000)
    private String text;

    public Question() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public QuestForm getForm() {
        return form;
    }

    public void setForm(QuestForm form) {
        this.form = form;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
