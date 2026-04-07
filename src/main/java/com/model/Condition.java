package com.model;

import javax.persistence.*;

@Entity
@Table(name = "conditions")   // ✅ matches DAO table
public class Condition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "field")
    private String field;

    @Column(name = "value")
    private String value;

    @Column(name = "user_id")
    private int userId;

    // getters & setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}