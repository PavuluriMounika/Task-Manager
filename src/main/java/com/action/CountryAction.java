package com.action;

import java.util.List;
import com.dao.CountryDAO;
import com.dao.StateDAO;
import com.model.Country;
import com.model.State;

public class CountryAction {

    // 🔹 For country dropdown
    private List<Country> countryList;

    // 🔹 For state dropdown
    private int countryId;
    private List<State> stateList;

    // ✅ Page load (countries)
    public String execute() {
        countryList = new CountryDAO().getAllCountries();
        return "success";
    }

    // ✅ AJAX call (states)
    public String getStates() {
        stateList = new StateDAO().getStatesByCountry(countryId);
        return "success";
    }

    // Getters
    public List<Country> getCountryList() {
        return countryList;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public List<State> getStateList() {
        return stateList;
    }
}