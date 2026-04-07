package com.action;

import java.util.List;
import com.model.Condition;
import com.dao.UserDAO;

public class SaveDataAction {

    private String name;
    private String password;
    private List<Condition> conditions;

    public String execute() {

        UserDAO dao = new UserDAO();
        dao.saveUser(name, password, conditions);

        return "success";
    }

    // getters & setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public List<Condition> getConditions() { return conditions; }
    public void setConditions(List<Condition> conditions) { this.conditions = conditions; }
}