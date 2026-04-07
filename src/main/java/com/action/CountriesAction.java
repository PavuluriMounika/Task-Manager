package com.action;

import com.model.Country;
import com.service.CountriesService;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

public class CountriesAction extends ActionSupport {
    
    private List<Country> countryList;
    private List<Country> stateList;
    private List<Country> villageList;
    
    private int countryId; // Matches the 'name' in s:select and AJAX data
    private int stateId;

    CountriesService service = new CountriesService();

    // Initial page load
    public String execute() {
        countryList = service.getCountries();
        return SUCCESS;
    }

    // AJAX call for States
    public String fetchStates() {
        stateList = service.getStates(countryId);
        return SUCCESS;
    }

    // AJAX call for Villages
    public String fetchVillages() {
        villageList = service.getVillages(stateId);
        return SUCCESS;
    }

    // GETTERS AND SETTERS (Crucial for JSON and Struts)
    public List<Country> getCountryList() { return countryList; }
    public void setCountryList(List<Country> countryList) { this.countryList = countryList; }
    public List<Country> getStateList() { return stateList; }
    public void setStateList(List<Country> stateList) { this.stateList = stateList; }
    public List<Country> getVillageList() { return villageList; }
    public void setVillageList(List<Country> villageList) { this.villageList = villageList; }
    public int getCountryId() { return countryId; }
    public void setCountryId(int countryId) { this.countryId = countryId; }
    public int getStateId() { return stateId; }
    public void setStateId(int stateId) { this.stateId = stateId; }
    
}