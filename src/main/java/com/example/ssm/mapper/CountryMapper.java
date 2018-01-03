package com.example.ssm.mapper;

import com.example.ssm.entity.Country;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CountryMapper {
    List<Country> selectAll();

    void addCountry(Country country);
    void deleteCountryById(Long id);
    int updateCountry(Country country);

    List<Country> queryCountryByCondition(Country country);
    Country queryCountryById(Long id);
    List<Integer> getAllCountryId();

    List<Country> showCountryByPage(@Param("pageNo") int pageNo);
}
