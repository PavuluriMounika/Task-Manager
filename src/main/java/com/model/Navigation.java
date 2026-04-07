/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import javax.persistence.*;

/**
 *
 * @author mounika
 */
@Entity
@Table(name ="APP_NAVIGATION")
public class Navigation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer navId;
    
    @Column(name = "MENU_LABEL")
    private String menuLabel;

    @Column(name = "ACTION_URL")
    private String actionUrl;

    public String getMenuLabel() {
        return menuLabel;
    }

    public void setMenuLabel(String menuLabel) {
        this.menuLabel = menuLabel;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }
    
    

    
}
