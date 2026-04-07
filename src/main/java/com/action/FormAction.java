package com.action;

import com.dao.UserDAO;
import com.model.Condition;
import java.util.List;

public class FormAction {

    private String name;
    private String password;
    private List<Condition> conditions;

    public String execute() {
        return "success";
    }

    public String saveData() {

        // ✅ Save user + conditions together
        new UserDAO().saveUser(name, password, conditions);

        return "success";
    }

    // getters & setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }
}