package com.example.ssm.service;

import com.example.ssm.entity.Country;
import com.example.ssm.mapper.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryMapper countryMapper;

    public List<Integer> getAllCountryId() {
        return countryMapper.getAllCountryId();
    }

    public Country queryCountryById(Long id) {
        return countryMapper.queryCountryById(id);
    }

    public void addCountry(Country country) {
        countryMapper.addCountry(country);
    }

    public List<Country> selectAll() {
        return countryMapper.selectAll();
    }

    public List<Country> queryCountryByCondition(Country tempCountry) {
        return countryMapper.queryCountryByCondition(tempCountry);
    }

    public int updateCountry(Country country){
        return countryMapper.updateCountry(country);
    }
}
