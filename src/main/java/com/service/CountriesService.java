package com.service;

import com.dao.CountriesDAO;
import com.model.Country;
import java.util.List;

public class CountriesService {
   
    CountriesDAO cou = new CountriesDAO();

    // 1. No parameter needed (gets all countries)
    public List<Country> getCountries(){
        return cou.getCountries();
    }

    // 2. Needs countryId to filter states!
    public List<Country> getStates(int countryId){
        return cou.getStates(countryId);
    }

    // 3. Needs stateId to filter villages!
    public List<Country> getVillages(int stateId){
        return cou.getVillages(stateId);
    }
}